package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import io.wcm.testing.mock.aem.junit5.AemContext;
import to.adapt.junit5demo.annotation.AemContextAndMockito;

@AemContextAndMockito
class MetaAnnotationTest {

  @Mock
  private MyService service;

  @Test
  void testRegisterMockService(AemContext context) {
    context.registerService(MyService.class, service);
    assertSame(service, context.getService(MyService.class));
  }

}
