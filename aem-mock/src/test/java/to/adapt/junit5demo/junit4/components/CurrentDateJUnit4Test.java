package to.adapt.junit5demo.junit4.components;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.wcm.testing.mock.aem.junit.AemContext;
import to.adapt.junit5demo.components.CurrentDate;
import to.adapt.junit5demo.junit4.testcontext.AppAemContext;

public class CurrentDateJUnit4Test {

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
