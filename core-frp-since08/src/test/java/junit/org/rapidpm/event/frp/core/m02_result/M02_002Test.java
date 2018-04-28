package junit.org.rapidpm.event.frp.core.m02_result;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.rapidpm.event.frp.core.m02_result.M02_002;

public class M02_002Test {

  @Disabled
  @Test
  void test001() {
    String result = new M02_002().testMe("Hello World", "l");
    Assertions.assertEquals("HeXXo WorXXd", result);

  }
}
