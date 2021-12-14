package com.cruftbusters.java_starter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
  @Test
  void appHasAGreetingInEnglish() {
    Greeter greeter = new Greeter("English");
    assertEquals("What's up, Dan?", greeter.getGreeting("Dan"));
    assertEquals("What's up, Smith?", greeter.getGreeting("Smith"));

  }

  @Test
  void appHasAGreetingInSpanish() {
    Greeter greeter = new Greeter("Spanish");
    assertEquals("Hola, Dan?", greeter.getGreeting("Dan"));
    assertEquals("Hola, Smith?", greeter.getGreeting("Smith"));

  }

  @Test
  void appHasAGreetingInFrench() {
    Greeter greeter = new Greeter("French");
    assertEquals("Bon jour, Dan?", greeter.getGreeting("Dan"));
    assertEquals("Bon jour, Smith?", greeter.getGreeting("Smith"));
  }
}
