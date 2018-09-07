package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import to.adapt.junit5demo.annotation.Fast;
import to.adapt.junit5demo.annotation.Slow;

class MetaAnnotationTagTest {

  @Test
  @Fast
  void testFastOperation() {
    assertEquals(42, new MyClass().theAnswer());
  }

  @Test
  @Slow
  void testSlowOperation() {
    new MyClass().longRunningOperation();
  }

}
