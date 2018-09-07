package to.adapt.junit5demo.junit4.testcontext;

import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.testing.mock.aem.junit.AemContextBuilder;

/**
 * Sets up {@link AemContext} for unit tests in this application.
 */
public final class AppAemContext {

  private AppAemContext() {
    // static methods only
  }

  public static AemContext newAemContext() {
    return new AemContextBuilder()
        .<AemContext>afterSetUp(context -> {
          // register sling models
          context.addModelsForPackage("to.adapt.junit5demo");
        })
        .build();
  }

}
