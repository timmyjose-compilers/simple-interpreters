package com.z0ltan.compilers.vms.hypo;

public class Instruction {
  public Opcodes op;
  public short d;

  public Instruction(final Opcodes op, final short d) {
    this.op = op;
    this.d = d;
  }

  public Instruction(final Opcodes op) {
    this(op, (short)-1);
  }
}
