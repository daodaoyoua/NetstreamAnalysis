// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Simulator.proto

package grpc;

public final class Simulator {
  private Simulator() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_SimResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_SimResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_NetStream_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_NetStream_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_NShead_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_NShead_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_NSbody_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_NSbody_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\017Simulator.proto\022\004grpc\" \n\013SimResponse\022\021" +
      "\n\tisArrived\030\001 \001(\010\"C\n\tNetStream\022\032\n\004head\030\001" +
      " \001(\0132\014.grpc.NShead\022\032\n\004body\030\002 \003(\0132\014.grpc." +
      "NSbody\"\263\001\n\006NShead\022\017\n\007version\030\001 \001(\005\022\r\n\005co" +
      "unt\030\002 \001(\005\022\021\n\tSysUptime\030\003 \001(\001\022\021\n\tunix_sec" +
      "s\030\004 \001(\001\022\022\n\nunix_nsecs\030\005 \001(\001\022\025\n\rflow_sequ" +
      "ence\030\006 \001(\003\022\023\n\013engine_type\030\007 \001(\005\022\021\n\tengin" +
      "e_id\030\010 \001(\005\022\020\n\010reserved\030\t \001(\t\"\323\002\n\006NSbody\022" +
      "\022\n\nStart_time\030\001 \001(\001\022\020\n\010End_time\030\002 \001(\001\022\025\n" +
      "\rPackage_count\030\003 \001(\005\022\022\n\nByte_count\030\004 \001(\005" +
      "\022\025\n\rProtocol_type\030\005 \001(\005\022\016\n\006Dst_IP\030\006 \001(\t\022" +
      "\016\n\006Src_IP\030\007 \001(\t\022\017\n\007Next_IP\030\010 \001(\t\022\017\n\007Dstm" +
      "ask\030\t \001(\t\022\017\n\007Srcmask\030\n \001(\t\022\016\n\006Dst_AS\030\013 \001" +
      "(\005\022\016\n\006Src_AS\030\014 \001(\005\022\025\n\rOut_interface\030\r \001(" +
      "\t\022\024\n\014In_interface\030\016 \001(\t\022\020\n\010Dst_port\030\017 \001(" +
      "\005\022\020\n\010Src_port\030\020 \001(\005\022\013\n\003Tos\030\021 \001(\005\022\020\n\010Rese" +
      "rved\030\022 \001(\t2G\n\020SimulatorService\0223\n\rsendNe" +
      "tStream\022\017.grpc.NetStream\032\021.grpc.SimRespo" +
      "nseB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_grpc_SimResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_SimResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_SimResponse_descriptor,
        new String[] { "IsArrived", });
    internal_static_grpc_NetStream_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_NetStream_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_NetStream_descriptor,
        new String[] { "Head", "Body", });
    internal_static_grpc_NShead_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpc_NShead_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_NShead_descriptor,
        new String[] { "Version", "Count", "SysUptime", "UnixSecs", "UnixNsecs", "FlowSequence", "EngineType", "EngineId", "Reserved", });
    internal_static_grpc_NSbody_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpc_NSbody_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_NSbody_descriptor,
        new String[] { "StartTime", "EndTime", "PackageCount", "ByteCount", "ProtocolType", "DstIP", "SrcIP", "NextIP", "Dstmask", "Srcmask", "DstAS", "SrcAS", "OutInterface", "InInterface", "DstPort", "SrcPort", "Tos", "Reserved", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
