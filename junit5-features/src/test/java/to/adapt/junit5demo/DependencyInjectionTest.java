package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class DependencyInjectionTest {

  @Test
  void testDependencies(AemContext context, TestInfo testInfo) {
    MyClass underTest = new MyClass();

    context.registerService(MyClass.class, underTest);

    assertEquals(42, new MyClass().theAnswer(),
        "The answer was wrong in: " + testInfo.getDisplayName());
  }

}
