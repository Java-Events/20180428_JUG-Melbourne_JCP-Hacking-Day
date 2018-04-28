package org.rapidpm.event.frp.core.m09_completable_future.observer.m02;

import java.util.function.Consumer;

public class Registry {
  private static final Observable<String, String> observable = new Observable<>();

  public static Registration register(String key, Consumer<String> consumer) {
    return observable.register(key, consumer);
  }

  public static void sendEvent(String input) {
    observable.sendEvent(input);
  }
}
