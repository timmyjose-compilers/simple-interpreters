package com.z0ltan.compilers.interpreters.minishell;

import java.util.Arrays;

public class MiniShellCommand {
  public String name;
  public String[] args;

  public MiniShellCommand(final String name, final String[] args) {
    this.name = name;
    this.args = args;
  }

  @Override
  public String toString() {
    return "MiniShellCommand { name = " + this.name + ", args = " + Arrays.toString(this.args) + " }";
  }
}
