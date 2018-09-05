package to.adapt.junit5demo.components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import to.adapt.junit5demo.testcontext.AppAemContext;

@ExtendWith(AemContextExtension.class)
public class CurrentDateTest {

  private final AemContext context = AppAemContext.newAemContext();

  private CurrentDate underTest;

  @BeforeEach
  public void setUp() {
    underTest = context.request().adaptTo(CurrentDate.class);
  }

  @Test
  public void testYear() {
    assertTrue(underTest.getYear() >= 2018);
  }

}
