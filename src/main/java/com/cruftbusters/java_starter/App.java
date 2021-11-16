package com.cruftbusters.java_starter;

public class App {
  public String getGreeting(String name) {
    return String.format("What's up, %s?", name);
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting("Dan"));
  }
}
