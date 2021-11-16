package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test void appHasAGreetingInEnglish() {
    App greeter = new App("English");
    assertEquals("What's up, Dan?", greeter.getGreeting("Dan"));
    assertEquals("What's up, Smith?", greeter.getGreeting("Smith"));

  }

  @Test void appHasAGreetingInSpanish() {
    App greeter = new App("Spanish");
    assertEquals("Hola, Dan?", greeter.getGreeting("Dan"));
    assertEquals("Hola, Smith?", greeter.getGreeting("Smith"));

  }
}
