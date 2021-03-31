package com.z0ltan.compilers.vms.hypo;

import java.io.BufferedReader;
import java.io.FileReader;

public class Interpreter {
  private Machine machine;
  private String filepath;

  public Interpreter(final String filepath) {
    this.machine = new Machine();
    this.filepath = filepath;
  }

  private void loadProgram() {
    try (BufferedReader reader = new BufferedReader(new FileReader(this.filepath))) {
      String line = null;
      int nextInstrAddr = 0;

      while ((line = reader.readLine()) != null) {
        if (line.startsWith(";") || line.length() == 0) {
          continue;
        }

        String[] instr = line.split(" ");
        if (instr.length < 1 || instr.length > 2) {
          throw new IllegalStateException("invalid instruction: " + line);
        }

        String cmd = instr[0].toUpperCase();
        if (cmd.equals("HALT")) {
          this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.HALT);
        } else {
          int operand = Integer.valueOf(instr[1]);

          switch (cmd) {
            case "STORE":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.STORE, operand);
              break;

            case "LOAD":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.LOAD, operand);
              break;

            case "LOADL":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.LOADL, operand);
              break;

            case "ADD":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.ADD, operand);
              break;

            case "SUB":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.SUB, operand);
              break;

            case "JUMP":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.JUMP, operand);
              break;

            case "JUMPZ":
              this.machine.code[nextInstrAddr++] = new Instruction(Opcodes.JUMPZ, operand);
              break;
          }
        }
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex.getLocalizedMessage());
    }
  }

  public void emulate() {
    loadProgram();

    this.machine.PC = 0;
    this.machine.ACC = 0;
    this.machine.status = Status.RUNNING;

    do {
      final Instruction instr = this.machine.code[this.machine.PC++];

      switch (instr.op) {
        case STORE:
          this.machine.data[instr.d] = this.machine.ACC;
          break;

        case LOAD:
          this.machine.ACC = this.machine.data[instr.d];
          break;

        case LOADL:
          this.machine.ACC = instr.d;
          break;

        case ADD:
          this.machine.ACC += this.machine.data[instr.d];
          break;

        case SUB:
          this.machine.ACC -= this.machine.data[instr.d];
          break;

        case JUMP:
          this.machine.PC = instr.d;
          break;

        case JUMPZ:
          if (this.machine.ACC == 0) {
            this.machine.PC = instr.d;
          }
          break;

        case HALT:
          this.machine.status = Status.HALTED;
          break;

        default:
          this.machine.status = Status.FAILED;
      }
    } while (this.machine.status != Status.HALTED);
  }

  public int result() {
    return this.machine.ACC;
  }
}
