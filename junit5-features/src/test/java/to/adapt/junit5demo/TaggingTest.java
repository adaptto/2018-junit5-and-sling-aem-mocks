package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaggingTest {

  @Test
  @Tag("fast")
  void testFastOperation() {
    assertEquals(42, new MyClass().theAnswer());
  }

  @Test
  @Tag("slow")
  void testSlowOperation() {
    new MyClass().longRunningOperation();
  }

}
