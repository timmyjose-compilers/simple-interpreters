package com.z0ltan.compilers.vms.hypo;

public class App {
  public static void main(String[] args) {
    final Interpreter interpreter = new Interpreter(args[0]);
    interpreter.emulate();
    System.out.printf("Result = %d\n", interpreter.result());
  }
}
