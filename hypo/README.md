## hypo

Hypo is a simple virtual machine whose specification is laid out in this document. Hypo uses a word size of 16 bits.

### Code Store

Hypo has a 4096 word code store. Each instruction has a 4 bit opcode and a 12 bit operand field. The register PC contains the address of the next instruction to be 
executed. The instruction at address 0 is executed first.

Here is the list of all the opcodes supported by Hypo:

---------------------------------------------------
| Opcode     Instruction        Meaning           |
---------------------------------------------------
|   0          STORE d      data[d] <- ACC        |  
|   1          LOAD d       ACC <- data[d]        |
|   2          LOADL d      ACC <- d              |
|   3          ADD d        ACC <- ACC + data[d]  |
|   4          SUB d        ACC <- ACC - data[d]  |
|   5          JUMP d       PC <- d               |
|   6          JUMPZd       PC <- d, if ACC = 0   |
|   7          HALT         stop execution        |
---------------------------------------------------

### Data Store

Hypo has a 4096 word data store, and a 1 word accumulator, the register ACC.

### Samples

Look at the sample programs in the [samples](samples) directory.