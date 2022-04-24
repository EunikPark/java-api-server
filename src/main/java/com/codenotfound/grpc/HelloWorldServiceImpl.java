package com.codenotfound.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codenotfound.grpc.helloworld.Greeting;
import com.codenotfound.grpc.helloworld.HelloWorldServiceGrpc;
import com.codenotfound.grpc.helloworld.Person;
import io.grpc.stub.StreamObserver;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import static org.neo4j.driver.Values.parameters;

@GRpcService
public class HelloWorldServiceImpl
    extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
  
  String uri = new String("bolt://localhost:7687");
  String user = new String("neo4j");
  String password = new String("1q2w3e4r");
  private Driver driver = GraphDatabase.driver(uri,AuthTokens.basic( user, password ));

  private static final Logger LOGGER =
      LoggerFactory.getLogger(HelloWorldServiceImpl.class);

  @Override
  public void sayHello(Person request,
      StreamObserver<Greeting> responseObserver) {
    LOGGER.info("server received {}", request);
    String response = new String("server response");

    try (Session session = driver.session()) {
      // response = session.writeTransaction(tx -> {
      //   Result result = tx.run("CREATE (a:Greeting) " +
      //       "SET a.message = $message " +
      //       "RETURN a.message + ', from node ' + id(a)",
      //       parameters("message", request.getFirstName()));
      //   return result.single().get(0).asString();
      // }); 
      // session.writeTransaction(tx -> tx.run("MERGE (a:Person {name: $x})", parameters("x", request.getFirstName())));
      Result result = session.run( "MATCH (a:Person) RETURN a.name AS name");
      while (result.hasNext()){
        Record record = result.next();
        LOGGER.info("{}",record.toString());
        response = response.concat(new String(record.toString()));
      }
    }

    String message = "Hello " + request.getFirstName() + " "
        + request.getLastName() + "!";
    Greeting greeting =
        Greeting.newBuilder().setMessage(response).build();
    LOGGER.info("{}",response);



    responseObserver.onNext(greeting);
    responseObserver.onCompleted();
  }
}
