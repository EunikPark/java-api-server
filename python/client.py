import grpc
import HelloWorld_pb2
import HelloWorld_pb2_grpc


def run() :
    with grpc.insecure_channel('localhost:6565') as channel:
        stub = HelloWorld_pb2_grpc.HelloWorldServiceStub(channel)
        person = HelloWorld_pb2.Person(first_name="ABC", last_name="QWE")
        greeting = stub.sayHello(person)
        print(greeting.message)



if __name__ == '__main__':
    run()