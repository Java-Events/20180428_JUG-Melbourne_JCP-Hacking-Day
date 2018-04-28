package org.rapidpm.event.frp.core.m09_completable_future.observer.m02;

public class Observer_02 {


  public static void main(String[] args) {
    final Registration registerA = Registry.register("key1", System.out::println);
    final Registration registerB = Registry.register("key2", System.out::println);
    Registry.sendEvent("Hello World");

    //done by life cycle
    registerA.remove();

    Registry.sendEvent("Hello World again");
  }
}
