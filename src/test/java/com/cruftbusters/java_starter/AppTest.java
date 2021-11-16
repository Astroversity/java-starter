package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test void appHasAGreeting() {
    App greeter = new App();
    assertEquals("What's up, Dan?", greeter.getGreeting("Dan"));
    assertEquals("What's up, Smith?", greeter.getGreeting("Smith"));

  }
}
