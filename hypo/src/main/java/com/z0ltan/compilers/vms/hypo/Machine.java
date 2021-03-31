package com.z0ltan.compilers.vms.hypo;

public class Machine {
  public short PC;
  public short ACC;
  public Status status;

  private static final short CODESIZE = 4096;
  private static final short DATASIZE = 4096;

  public Instruction[] code = new Instruction[CODESIZE];
  public short[] data = new short[DATASIZE];
}
