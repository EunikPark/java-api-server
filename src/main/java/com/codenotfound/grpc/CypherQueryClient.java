package com.codenotfound.grpc;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.codenotfound.grpc.helloworld.QueryMsg;
import com.codenotfound.grpc.helloworld.CypherQueryServiceGrpc;
import com.codenotfound.grpc.helloworld.QueryResults;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Component
public class CypherQueryClient {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CypherQueryClient.class);

  private CypherQueryServiceGrpc.CypherQueryServiceBlockingStub CypherQueryServiceBlockingStub;

  @PostConstruct
  private void init() {
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 6565).usePlaintext().build();

    CypherQueryServiceBlockingStub =
        CypherQueryServiceGrpc.newBlockingStub(managedChannel);
  }

  public String queryCypher(String msg) {
    QueryMsg queryMsg = QueryMsg.newBuilder().setQuery(msg).build();
    
    LOGGER.info("client sending {}", queryMsg);

    QueryResults results =
        CypherQueryServiceBlockingStub.queryCypher(queryMsg);
    LOGGER.info("client received {}", results);

    return results.getMessage();
  }
}
