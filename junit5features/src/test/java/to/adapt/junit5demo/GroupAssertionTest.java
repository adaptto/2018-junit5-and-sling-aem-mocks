package to.adapt.junit5demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.Test;

class GroupAssertionTest {

  @Test
  void testValueMap() {
    ValueMap props = new MyClass().getProps();
    assertAll(
        () -> assertEquals("value1", props.get("prop1", "")),
        () -> assertEquals(42, (int)props.get("prop2", 0))
    );
  }

}
