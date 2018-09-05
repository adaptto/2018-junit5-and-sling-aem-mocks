package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisibilityTest {

  private MyClass underTest;

  @BeforeEach
  void setUp() {
    underTest = new MyClass();
  }

  @Test
  void testTheAnswer() {
    assertEquals(42, underTest.theAnswer(),
        "Answer to the Ultimate Question of Life, "
            + "the Universe, and Everything");
  }

}
