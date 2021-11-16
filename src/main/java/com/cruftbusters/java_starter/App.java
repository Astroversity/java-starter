package com.cruftbusters.java_starter;

public class App {
  public String getGreeting(String name) {
    return "What's up, " + name + "?";
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting("Dan"));
  }
}
