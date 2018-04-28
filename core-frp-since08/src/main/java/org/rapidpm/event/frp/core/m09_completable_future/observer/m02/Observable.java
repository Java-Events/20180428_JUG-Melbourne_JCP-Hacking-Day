package org.rapidpm.event.frp.core.m09_completable_future.observer.m02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Observable<KEY, VALUE> {

  private final Map<KEY, Consumer<VALUE>> listeners = new ConcurrentHashMap<>();

  public Registration register(KEY key, Consumer<VALUE> listener) {
    listeners.put(key, listener);

    return () -> listeners.remove(key);
  }

  public void sendEvent(VALUE event) {
    listeners.values().forEach(c -> c.accept(event));
  }
}
