# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import Simulator_pb2 as Simulator__pb2


class SimulatorServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.sendNetStream = channel.unary_unary(
                '/grpc.SimulatorService/sendNetStream',
                request_serializer=Simulator__pb2.NetStream.SerializeToString,
                response_deserializer=Simulator__pb2.SimResponse.FromString,
                )


class SimulatorServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def sendNetStream(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_SimulatorServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'sendNetStream': grpc.unary_unary_rpc_method_handler(
                    servicer.sendNetStream,
                    request_deserializer=Simulator__pb2.NetStream.FromString,
                    response_serializer=Simulator__pb2.SimResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'grpc.SimulatorService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class SimulatorService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def sendNetStream(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/grpc.SimulatorService/sendNetStream',
            Simulator__pb2.NetStream.SerializeToString,
            Simulator__pb2.SimResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
