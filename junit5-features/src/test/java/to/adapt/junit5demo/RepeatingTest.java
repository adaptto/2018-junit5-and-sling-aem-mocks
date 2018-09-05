package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

@Disabled
class RepeatingTest {

  @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
  void tryHardToFindTheAnswer(RepetitionInfo info) {
    assertEquals(37 + info.getCurrentRepetition(), new MyClass().theAnswer());
  }

}
