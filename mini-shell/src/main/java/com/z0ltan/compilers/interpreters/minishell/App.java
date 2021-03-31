package com.z0ltan.compilers.interpreters.minishell;

import java.io.FileInputStream;

public class App {
  public static void main(String[] args) throws Exception {
    if (args.length > 1) {
      showUsageAndExit();
    }
    if (args.length == 0) {
      runRepl();
    } else {
      runScript(args[0]);
    }
  }

  private static void showUsageAndExit() {
    System.out.println("Usage: minishell [script]");
    System.exit(1);
  }

  private static void runRepl() {
    final Interpreter interpreter = new Interpreter();
    interpreter.interpret();
  }

  private static void runScript(final String script) throws Exception {
    final Interpreter interpreter = new Interpreter(new FileInputStream(script));
    interpreter.interpret();
  }
}
