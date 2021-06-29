package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: Simulator.proto")
public final class SimulatorServiceGrpc {

  private SimulatorServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.SimulatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<NetStream,
      SimResponse> getSendNetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendNetStream",
      requestType = NetStream.class,
      responseType = SimResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<NetStream,
      SimResponse> getSendNetStreamMethod() {
    io.grpc.MethodDescriptor<NetStream, SimResponse> getSendNetStreamMethod;
    if ((getSendNetStreamMethod = SimulatorServiceGrpc.getSendNetStreamMethod) == null) {
      synchronized (SimulatorServiceGrpc.class) {
        if ((getSendNetStreamMethod = SimulatorServiceGrpc.getSendNetStreamMethod) == null) {
          SimulatorServiceGrpc.getSendNetStreamMethod = getSendNetStreamMethod =
              io.grpc.MethodDescriptor.<NetStream, SimResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendNetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  NetStream.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SimResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SimulatorServiceMethodDescriptorSupplier("sendNetStream"))
              .build();
        }
      }
    }
    return getSendNetStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SimulatorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimulatorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimulatorServiceStub>() {
        @Override
        public SimulatorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimulatorServiceStub(channel, callOptions);
        }
      };
    return SimulatorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimulatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimulatorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimulatorServiceBlockingStub>() {
        @Override
        public SimulatorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimulatorServiceBlockingStub(channel, callOptions);
        }
      };
    return SimulatorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SimulatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimulatorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimulatorServiceFutureStub>() {
        @Override
        public SimulatorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimulatorServiceFutureStub(channel, callOptions);
        }
      };
    return SimulatorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SimulatorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendNetStream(NetStream request,
                              io.grpc.stub.StreamObserver<SimResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendNetStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendNetStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                NetStream,
                SimResponse>(
                  this, METHODID_SEND_NET_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class SimulatorServiceStub extends io.grpc.stub.AbstractAsyncStub<SimulatorServiceStub> {
    private SimulatorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SimulatorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimulatorServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendNetStream(NetStream request,
                              io.grpc.stub.StreamObserver<SimResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendNetStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SimulatorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SimulatorServiceBlockingStub> {
    private SimulatorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SimulatorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimulatorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public SimResponse sendNetStream(NetStream request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendNetStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SimulatorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SimulatorServiceFutureStub> {
    private SimulatorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SimulatorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimulatorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SimResponse> sendNetStream(
        NetStream request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendNetStreamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_NET_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SimulatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SimulatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_NET_STREAM:
          serviceImpl.sendNetStream((NetStream) request,
              (io.grpc.stub.StreamObserver<SimResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SimulatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SimulatorServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Simulator.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SimulatorService");
    }
  }

  private static final class SimulatorServiceFileDescriptorSupplier
      extends SimulatorServiceBaseDescriptorSupplier {
    SimulatorServiceFileDescriptorSupplier() {}
  }

  private static final class SimulatorServiceMethodDescriptorSupplier
      extends SimulatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SimulatorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SimulatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SimulatorServiceFileDescriptorSupplier())
              .addMethod(getSendNetStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
