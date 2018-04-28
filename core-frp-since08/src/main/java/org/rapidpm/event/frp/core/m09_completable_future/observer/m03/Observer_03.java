package org.rapidpm.event.frp.core.m09_completable_future.observer.m03;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class Observer_03 {

  public static void main(String[] args) {
    version01();
//    version02();
    version03();

    version04();

    version05();

    version06();

    version07();


    //now with cleaning


    final List<String> results = new ArrayList<>();

    final Observable<String>   observableA = new Observable<>();
    final Observable<String>   observableB = new Observable<>();
    final Observable<String[]> observableC = new Observable<>();

    Registration rA1 = observableA.register(s -> observableB.sendEvent(s.toUpperCase()));
    Registration rA2 = observableA.register(s -> observableB.sendEvent(s.toLowerCase()));

    Registration rB = observableB.register(s -> observableC.sendEvent(s.split(" ")));

    Registration rC1 = observableC.register(strings -> results.addAll(asList(strings)));
    Registration rC2 = observableC.register(strings -> out.println("From C2 " + asList(strings)));

    observableA.sendEvent("Hello World ");

    out.println("results = " + results);

    // cleaning
    rA1.remove();
    rA2.remove();
    rB.remove();
    rC1.remove();
    rC2.remove();

    // who have to call this methods at what time ?


  }

  private static void version07() {
    final List<String> results = new ArrayList<>();

    final Observable<String>   observableA = new Observable<>();
    final Observable<String>   observableB = new Observable<>();
    final Observable<String[]> observableC = new Observable<>();

    observableA.register(s -> observableB.sendEvent(s.toUpperCase()));
    observableA.register(s -> observableB.sendEvent(s.toLowerCase()));
    observableB.register(s -> observableC.sendEvent(s.split(" ")));
    observableC.register(strings -> results.addAll(asList(strings)));
    observableC.register(strings -> out.println("From C2 " + asList(strings)));

    observableA.sendEvent("Hello World ");

    out.println("results = " + results);
  }

  private static void version06() {
    final List<String> results = new ArrayList<>();

    final Observable<String>   observableA = new Observable<>();
    final Observable<String>   observableB = new Observable<>();
    final Observable<String[]> observableC = new Observable<>();

    observableA.register(s -> observableB.sendEvent(s.toUpperCase()));
    observableA.register(s -> observableB.sendEvent(s.toLowerCase()));
    observableB.register(s -> observableC.sendEvent(s.split(" ")));
    observableC.register(strings -> results.addAll(asList(strings)));

    observableA.sendEvent("Hello World ");

    out.println("results = " + results);
  }

  private static void version05() {
    final List<String> results = new ArrayList<>();

    final Observable<String>   observableA = new Observable<>();
    final Observable<String>   observableB = new Observable<>();
    final Observable<String[]> observableC = new Observable<>();

    observableA.register(s -> observableB.sendEvent(s.toUpperCase()));
    observableB.register(s -> observableC.sendEvent(s.split(" ")));
    observableC.register(strings -> results.addAll(asList(strings)));

    observableA.sendEvent("Hello World ");

    out.println("results = " + results);
  }

  private static void version04() {
    final List<String> results = new ArrayList<>();

    final Observable<String>   observableA = new Observable<>();
    final Observable<String>   observableB = new Observable<>();
    final Observable<String[]> observableC = new Observable<>();

    observableA.register(s -> observableB.sendEvent(new Worker().doWork(s)));
    observableB.register(s -> observableC.sendEvent(new Worker().split(s)));
    observableC.register(strings -> results.addAll(asList(strings)));

    observableA.sendEvent("Hello World ");

    out.println("results = " + results);
  }

  private static void version03() {
    //
    final Worker worker = new Worker();
    // state outside -> not nice
    final List<String> results = new ArrayList<>();

    final Observable<String>   observableA = new Observable<>();
    final Observable<String>   observableB = new Observable<>();
    final Observable<String[]> observableC = new Observable<>();

    observableA.register(s -> observableB.sendEvent(worker.doWork(s)));
    observableB.register(s -> observableC.sendEvent(worker.split(s)));
    observableC.register(strings -> results.addAll(asList(strings)));

    observableA.sendEvent("Hello World ");

    out.println("results = " + results);
  }

  private static void version01() {
    // one way to chain tasks
    final Worker   worker = new Worker();
    final String[] split  = worker.split(worker.doWork("Hello World"));
    out.println("result = " + asList(split));
  }

//  private static void version02() {
//    String result;
//    //chain observer
//    final Worker                     worker      = new Worker();
//    final Observable<String, String> observableA = new Observable<>();
//    final Observable<String, String> observableB = new Observable<>();
//    Registration registration = observableA
//        .register("A", s -> observableB.sendEvent(worker.doWork(s)));
//
//
//  }

  public static class Worker {

    public String doWork(String input) {
      return input.toUpperCase();
    }

    public String[] split(String input) {
      return input.split(" ");
    }
  }
}
