package com.cruftbusters.java_starter;

import java.util.Objects;

public class App {
  private String language;
  public App(String language){this.language=language;}
  public String getGreeting(String name) {
    if (Objects.equals(language, "English")) {
      return String.format("What's up, %s?", name);
    }
    if (Objects.equals(language, "Spanish")) {
      return String.format("Hola, %s?", name);
    }
    return String.format("Bon jour, %s?", name);
  }

  public static void main(String[] args) {
    System.out.println(new App("English").getGreeting("Dan"));
  }
}
