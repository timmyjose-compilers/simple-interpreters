## mini-shell

This is a simple interpreter for a pure scripting language called Mini Shell, whose specification is given in this document. This interpreter is a purely iterative 
interpreter which simply executes each command in the script without maintaining any state.


### Specification

```
  Script ::= Command*

  Command ::= Command-Name Argument* <eol>

  Argument ::= Filename | Literal

  Command-Name ::= create
                | delete
                | edit
                | list
                | print
                | quit
                | Filename
```

### Supported Commands

```
  ------------------------------------------------------------------------------------------------------------------------------------
  |    Command              |          Argument(s)      |                                 Meaning                                    |
  |----------------------------------------------------------------------------------------------------------------------------------|
  |  create                 | filename                  |   create an empty file with the given name                                 |
  |  delete                 | filename1 ... filenamen   |   delete all named files                                                   |
  |  list                   | none                      |   list the names of all files owned by the current user                    |
  |  print                  | filename number           |   print the given number of copies of the named file                       |
  |  run executable program | filename arg1 ... argn    |   run the executable contained in the named file, with the given arguments |
  |----------------------------------------------------------------------------------------------------------------------------------|
   
```