package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled
class ParameterTest {

  @ParameterizedTest
  @ValueSource(ints = { 38, 42, 55 })
  void tryDifferentAnswers(int anAnswer) {
    assertEquals(anAnswer, new MyClass().theAnswer());
  }

}
