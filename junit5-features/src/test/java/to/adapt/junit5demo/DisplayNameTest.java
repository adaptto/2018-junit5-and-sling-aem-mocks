package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display name demonstration")
class DisplayNameTest {

  @Test
  @DisplayName("This tests the correct answer")
  void testTheAnswer() {
    assertEquals(42, new MyClass().theAnswer());
  }

  @Test
  @DisplayName("This get's the answer wrong")
  @Disabled
  void testTheWrongAnswer() {
    assertEquals(45, new MyClass().theAnswer());
  }

}
