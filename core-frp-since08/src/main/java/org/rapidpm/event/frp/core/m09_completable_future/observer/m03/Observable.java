package org.rapidpm.event.frp.core.m09_completable_future.observer.m03;


import java.util.Set;
import java.util.function.Consumer;

import static java.util.concurrent.ConcurrentHashMap.newKeySet;

public class Observable<VALUE> {

  private final Set<Consumer<VALUE>> listeners = newKeySet();

  public Registration register(Consumer<VALUE> listener) {
    listeners.add(listener);
    return () -> listeners.remove(listener);
  }

  public void sendEvent(VALUE event) {
    listeners.forEach(c -> c.accept(event));
  }
}
