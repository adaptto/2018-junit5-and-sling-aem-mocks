package to.adapt.junit5demo;

import java.io.FileNotFoundException;

import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;

import com.google.common.collect.ImmutableMap;

class MyClass {

  int theAnswer() {
    return 42;
  }

  ValueMap getProps() {
    return new ValueMapDecorator(ImmutableMap.of(
        "prop1", "value1",
        "prop2", 42));
  }

  void readFile() throws FileNotFoundException {
    throw new FileNotFoundException("unknown file");
  }

  void longRunningOperation() {
    try {
      Thread.sleep(100);
    }
    catch (InterruptedException ex) {
      // ignore for this example
    }
  }

}
