package com.codenotfound.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codenotfound.grpc.helloworld.QueryResults;
import com.codenotfound.grpc.helloworld.CypherQueryServiceGrpc;
import com.codenotfound.grpc.helloworld.QueryMsg;
import io.grpc.stub.StreamObserver;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import static org.neo4j.driver.Values.parameters;

@GRpcService
public class CypherQueryServiceImpl
    extends CypherQueryServiceGrpc.CypherQueryServiceImplBase {
  
  String uri = new String("bolt://localhost:7687");
  String user = new String("neo4j");
  String password = new String("1q2w3e4r");
  private Driver driver = GraphDatabase.driver(uri,AuthTokens.basic( user, password ));

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CypherQueryServiceImpl.class);

  @Override
  public void queryCypher(QueryMsg request,
      StreamObserver<QueryResults> responseObserver) {
    LOGGER.info("server received {}", request);

    String response = new String("server response : ");

    try (Session session = driver.session()) {

      Result result = session.run(request.getQuery());
      
      while (result.hasNext()){
        Record record = result.next();
        LOGGER.info("{}",record.toString());
        response = response.concat(new String(record.toString()));
      }
    }

    // String message = "Hello " + request.getFirstName() + " "
    //     + request.getLastName() + "!";
    QueryResults queryresults =
        QueryResults.newBuilder().setMessage(response).build();
    LOGGER.info("server respond : {}",response);


    responseObserver.onNext(queryresults);
    responseObserver.onCompleted();
  }
}
