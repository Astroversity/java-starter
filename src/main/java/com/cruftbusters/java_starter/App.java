package com.cruftbusters.java_starter;

public class App {
  public String getGreeting() {
    return "What's up?";
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());
  }
}
