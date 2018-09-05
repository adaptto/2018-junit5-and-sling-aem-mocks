package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.junit.jupiter.api.Test;

class ExceptionHandlingTest {

  @Test
  void testException() {
    MyClass underTest = new MyClass();
    assertEquals(42, underTest.theAnswer());
    assertThrows(FileNotFoundException.class, () -> {
      underTest.readFile();
    });
  }

  @Test
  void testTimeout() {
    MyClass underTest = new MyClass();
    assertTimeout(Duration.ofMillis(500), () -> {
      underTest.longRunningOperation();
    });
  }

}
