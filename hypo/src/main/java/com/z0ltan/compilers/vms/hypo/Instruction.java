package com.z0ltan.compilers.vms.hypo;

public class Instruction {
  public Opcodes op;
  public int d;

  public Instruction(final Opcodes op, final int d) {
    this.op = op;
    this.d = d;
  }

  public Instruction(final Opcodes op) {
    this(op, -1);
  }
}
