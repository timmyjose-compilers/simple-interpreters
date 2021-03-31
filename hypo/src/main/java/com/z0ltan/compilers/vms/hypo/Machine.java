package com.z0ltan.compilers.vms.hypo;

public class Machine {
  public int PC;
  public int ACC;
  public Status status;

  private static final int CODESIZE = 4096;
  private static final int DATASIZE = 4096;

  public Instruction[] code = new Instruction[CODESIZE];
  public int[] data = new int[DATASIZE];
}
