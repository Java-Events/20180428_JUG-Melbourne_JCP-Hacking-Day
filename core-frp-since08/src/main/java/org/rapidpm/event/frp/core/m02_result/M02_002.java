package org.rapidpm.event.frp.core.m02_result;

import org.rapidpm.frp.model.Result;

import java.util.function.BiFunction;

/**
 * Combine the Function sync or async
 */
public class M02_002 {

  final BiFunction<String, String, String> transform() {
    return (input, replace) -> input.replaceAll(replace, "XX");

  }

  public Result<String> toUpper(String input) {
    return Result.success(input.toUpperCase());
  }

  public String testMe(String input, String replace) {
    final BiFunction<String, String, String> f = transform();

    throw new RuntimeException("implement me");
  }

}
