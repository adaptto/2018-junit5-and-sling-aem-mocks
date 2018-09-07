package to.adapt.junit5demo.junit5.testcontext;

import static io.wcm.testing.mock.wcmio.caconfig.ContextPlugins.WCMIO_CACONFIG;
import static org.apache.sling.testing.mock.caconfig.ContextPlugins.CACONFIG;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextBuilder;

/**
 * Sets up {@link AemContext} for unit tests in this application.
 */
public final class AppAemContext {

  private AppAemContext() {
    // static methods only
  }

  public static AemContext newAemContext() {
    return new AemContextBuilder()
        // register plugins
        .plugin(CACONFIG)
        .plugin(WCMIO_CACONFIG)
        // shared context setup code for all tests
        .<AemContext>afterSetUp(context -> {
          // register sling models
          context.addModelsForPackage("to.adapt.junit5demo");
        })
        .build();
  }

}
