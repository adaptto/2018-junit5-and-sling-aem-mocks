package to.adapt.junit5demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConditionalTest {

  @Test
  void runAlways() { /*...*/ }

  @Test
  @Disabled
  void runNever() { /*...*/ }

  @Test
  @EnabledOnOs({ OS.LINUX, OS.MAC })
  void runOnSpecificOS() { /*...*/ }

  @Test
  @DisabledOnJre(JRE.JAVA_10)
  void runOnSpecificJRE() { /*...*/ }

}
