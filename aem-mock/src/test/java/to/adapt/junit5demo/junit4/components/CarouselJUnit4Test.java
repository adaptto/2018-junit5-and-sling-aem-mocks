package to.adapt.junit5demo.junit4.components;

import static com.day.cq.commons.DownloadResource.PN_REFERENCE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static to.adapt.junit5demo.components.Carousel.NN_SLIDES;

import java.util.stream.Collectors;

import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.adobe.cq.wcm.core.components.models.Image;
import com.day.cq.wcm.api.Page;
import com.google.common.collect.ImmutableList;

import io.wcm.testing.mock.aem.junit.AemContext;
import to.adapt.junit5demo.components.Carousel;
import to.adapt.junit5demo.components.MailserverNotConfiguredException;
import to.adapt.junit5demo.junit4.testcontext.AppAemContext;

public class CarouselJUnit4Test {

  @Rule
  public final AemContext context = AppAemContext.newAemContext();

  private Resource resource;

  @Before
  public void setUp() {
    Page page = context.create().page("/content/mypage");
    resource = context.create().resource(page.getContentResource().getPath() + "/myresource");
    context.currentResource(resource);
  }

  @Test
  public void testSlideImageUrls() {
    context.create().asset("/content/dam/slides/slide1.png", 80, 30, "image/png");
    context.create().asset("/content/dam/slides/slide2.png", 80, 30, "image/png");

    context.build().resource(resource.getPath() + "/" + NN_SLIDES)
        .siblingsMode()
        .resource("item1", PN_REFERENCE, "/content/dam/slides/slide1.png")
        .resource("item2", PN_REFERENCE, "/content/dam/slides/slide2.png");

    Carousel underTest = context.request().adaptTo(Carousel.class);
    assertEquals(ImmutableList.of(
        "/content/mypage/_jcr_content/myresource/slides/item1.img.png",
        "/content/mypage/_jcr_content/myresource/slides/item2.img.png"),
        underTest.getSlideImages().stream()
            .map(Image::getSrc)
            .collect(Collectors.toList()));
  }

  @Test
  public void testEmptySlideImageUrls() {
    Carousel underTest = context.request().adaptTo(Carousel.class);
    assertTrue(underTest.getSlideImages().isEmpty());
  }

  @Test(expected = MailserverNotConfiguredException.class)
  public void testSendSlides() {
    Carousel underTest = context.request().adaptTo(Carousel.class);
    // try to send slides via mail without having a mail server configured
    underTest.sendSlides();
  }

}
