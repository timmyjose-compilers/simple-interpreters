package com.z0ltan.compilers.vms.hypo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.assertEquals;

public class AppTest extends TestCase {
  public AppTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(AppTest.class);
  }

  public void testAddnums() {
    final Interpreter interpreter = new Interpreter("samples/addnums.S");
    interpreter.emulate();
    assertEquals(interpreter.result(), (short)5);
  }

  public void testSubnums() {
    final Interpreter interpreter = new Interpreter("samples/subnums.S");
    interpreter.emulate();
    assertEquals(interpreter.result(), (short)-1);
  }

  public void testProduct() {
    final Interpreter interpreter = new Interpreter("samples/product.S");
    interpreter.emulate();
    assertEquals(interpreter.result(), (short)6);
  }
}
