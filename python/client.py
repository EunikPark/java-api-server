import grpc
import CypherQuery_pb2
import CypherQuery_pb2_grpc


def run() :
    with grpc.insecure_channel('localhost:6565') as channel:
        stub = CypherQuery_pb2_grpc.CypherQueryServiceStub(channel)
        queryMsg = CypherQuery_pb2.QueryMsg(query="MATCH (a:Person) RETURN a.name AS name")
        queryResults = stub.queryCypher(queryMsg)
        print(queryResults.message)

if __name__ == '__main__':
    run()