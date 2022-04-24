package com.codenotfound;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.codenotfound.grpc.CypherQueryClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {

  @Autowired
  private CypherQueryClient helloWorldClient;

  @Test
  public void testSayHello() {
    String msg = new String(helloWorldClient.queryCypher("MATCH (a:Person) RETURN a.name AS name"));
    System.out.println(msg);
    assertThat(msg).isEqualTo("server response : Record<{name: \"John\"}>");
  }
}
