# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: CypherQuery.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x11\x43ypherQuery.proto\x12 com.codenotfound.grpc.helloworld\"\x19\n\x08QueryMsg\x12\r\n\x05query\x18\x01 \x01(\t\"\x1f\n\x0cQueryResults\x12\x0f\n\x07message\x18\x01 \x01(\t2\x7f\n\x12\x43ypherQueryService\x12i\n\x0bqueryCypher\x12*.com.codenotfound.grpc.helloworld.QueryMsg\x1a..com.codenotfound.grpc.helloworld.QueryResultsB\x02P\x01\x62\x06proto3')



_QUERYMSG = DESCRIPTOR.message_types_by_name['QueryMsg']
_QUERYRESULTS = DESCRIPTOR.message_types_by_name['QueryResults']
QueryMsg = _reflection.GeneratedProtocolMessageType('QueryMsg', (_message.Message,), {
  'DESCRIPTOR' : _QUERYMSG,
  '__module__' : 'CypherQuery_pb2'
  # @@protoc_insertion_point(class_scope:com.codenotfound.grpc.helloworld.QueryMsg)
  })
_sym_db.RegisterMessage(QueryMsg)

QueryResults = _reflection.GeneratedProtocolMessageType('QueryResults', (_message.Message,), {
  'DESCRIPTOR' : _QUERYRESULTS,
  '__module__' : 'CypherQuery_pb2'
  # @@protoc_insertion_point(class_scope:com.codenotfound.grpc.helloworld.QueryResults)
  })
_sym_db.RegisterMessage(QueryResults)

_CYPHERQUERYSERVICE = DESCRIPTOR.services_by_name['CypherQueryService']
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'P\001'
  _QUERYMSG._serialized_start=55
  _QUERYMSG._serialized_end=80
  _QUERYRESULTS._serialized_start=82
  _QUERYRESULTS._serialized_end=113
  _CYPHERQUERYSERVICE._serialized_start=115
  _CYPHERQUERYSERVICE._serialized_end=242
# @@protoc_insertion_point(module_scope)