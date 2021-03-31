package com.z0ltan.compilers.interpreters.minishell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter {
  private MiniShellStatus status;
  private InputStream stream;
  private List<String> fileStore;

  public Interpreter(final InputStream stream) {
    this.status = MiniShellStatus.HALTED;
    this.stream = stream;
    this.fileStore = new ArrayList<>();
  }

  public Interpreter() {
    this(System.in);
  }

  public void interpret() {
    this.status = MiniShellStatus.RUNNING;

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.stream))) {
      do {
        String line = reader.readLine();
        if (line == null) {
          break;
        }
        
        String[] parts = line.split(" ");
        final MiniShellCommand cmd = new MiniShellCommand(parts[0], Arrays.copyOfRange(parts, 1, parts.length));

        switch (cmd.name) {
          case "create":
            System.out.println("Created file " + cmd.args[0]);
            this.fileStore.add(cmd.args[0]);
            break;

          case "delete":
            System.out.println("Deleting the following files..");
            for (final String file : cmd.args) {
              System.out.printf("\t%s\n", file);
              this.fileStore.remove(file);
            }
            break;

          case "edit":
            System.out.println("Editing file: " + cmd.args[0]);
            break;

          case "list":
            System.out.println("Listing all files created by user...");
            for (final String file : this.fileStore) {
              System.out.printf("\t%s\n", file);
            }
            break;

          case "print":
            System.out.printf("Printed %d copies of %s\n", Integer.parseInt(cmd.args[1]), cmd.args[0]);
            break;

          case "quit":
            System.out.println("Bye!");
            this.status = MiniShellStatus.HALTED;
            break;

          case "run":
            System.out.printf("Executing command %s on arguments...", cmd.args[0]);
            for (int i = 1; i < cmd.args.length; i++) {
              System.out.printf("\t%s\n", cmd.args[i]);
            }
            break;

          default:
            break;
        }
      } while (this.status == MiniShellStatus.RUNNING);
    } catch (Exception ex) {
      throw new RuntimeException(ex.getLocalizedMessage());
    }
  }
}
