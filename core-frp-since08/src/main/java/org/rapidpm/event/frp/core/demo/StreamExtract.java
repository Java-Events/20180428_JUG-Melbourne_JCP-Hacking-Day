package org.rapidpm.event.frp.core.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamExtract {


  public static void main(String[] args) {
    List<String> list = Arrays.asList("A", "B", "C");


    final String a = "A";
    final String b = "B";


    Consumer<String> println = System.out::println;

    Predicate<String> predicateA = s -> s.contains(a);
    Predicate<String> predicateB = s -> s.contains(b);

    Function<String, Predicate<String>> f
        = (i) -> s -> s.contains(s);


    String a1 = "A";
    list
        .stream()
        .filter(f.apply(a1))
        .forEach(println);
    list
        .stream()
        .filter(f.apply("B"))
        .forEach(println);

  }
}
