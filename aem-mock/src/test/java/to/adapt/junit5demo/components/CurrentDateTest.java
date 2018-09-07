package to.adapt.junit5demo.components;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.wcm.testing.mock.aem.junit.AemContext;
import to.adapt.junit5demo.testcontext.AppAemContext;

public class CurrentDateTest {

  @Rule
  public final AemContext context = AppAemContext.newAemContext();

  private CurrentDate underTest;

  @Before
  public void setUp() {
    underTest = context.request().adaptTo(CurrentDate.class);
  }

  @Test
  public void testYear() {
    assertTrue(underTest.getYear() >= 2018);
  }

}
