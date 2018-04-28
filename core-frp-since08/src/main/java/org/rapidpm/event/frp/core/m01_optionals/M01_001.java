package org.rapidpm.event.frp.core.m01_optionals;


/**
 * Change the interface Service, to handle the Value null in a proper way with Optional
 * <p>
 * Change the interface Service into an FunctionalInterface, so the
 * the method doWork can be invoked with lambdas
 */
public class M01_001 {

  public Integer doWork(String input, Service converter) {
    return converter.convert(input);
  }

  public interface Service {

    default Integer convert(String input) {
      return Integer.parseInt(input);
    }

  }

}
