package to.adapt.junit5demo.components;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.factory.ModelFactory;

import com.adobe.cq.wcm.core.components.models.Image;

/**
 * Model for the carousel component.
 */
@Model(adaptables = SlingHttpServletRequest.class)
public class Carousel {

  /**
   * Node name for slides child node
   */
  public static final String NN_SLIDES = "slides";

  private List<Image> slideImages;

  @Self
  private SlingHttpServletRequest request;
  @OSGiService
  private ModelFactory modelFactory;

  @PostConstruct
  private void activate() {
    slideImages = buildSlideImages();
  }

  private List<Image> buildSlideImages() {
    List<Image> images = new ArrayList<>();

    // get configured media references and convert them to image urls
    Resource slides = request.getResource().getChild(NN_SLIDES);
    if (slides != null) {
      for (Resource slide : slides.getChildren()) {
        // adapt the resource using the core image component
        // since it can only be adapted from a SlingHttpServletRequest we need to use the modelFactory to wrap the request
        Image img = modelFactory.getModelFromWrappedRequest(request, slide, Image.class);
        if (img != null && StringUtils.isNotBlank(img.getSrc())) {
          images.add(img);
        }
      }
    }

    return images;
  }

  public List<Image> getSlideImages() {
    return this.slideImages;
  }

}
