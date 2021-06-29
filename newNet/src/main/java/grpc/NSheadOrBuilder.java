// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Simulator.proto

package grpc;

public interface NSheadOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.NShead)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 version = 1;</code>
   * @return The version.
   */
  int getVersion();

  /**
   * <code>int32 count = 2;</code>
   * @return The count.
   */
  int getCount();

  /**
   * <code>double SysUptime = 3;</code>
   * @return The sysUptime.
   */
  double getSysUptime();

  /**
   * <code>double unix_secs = 4;</code>
   * @return The unixSecs.
   */
  double getUnixSecs();

  /**
   * <code>double unix_nsecs = 5;</code>
   * @return The unixNsecs.
   */
  double getUnixNsecs();

  /**
   * <code>int64 flow_sequence = 6;</code>
   * @return The flowSequence.
   */
  long getFlowSequence();

  /**
   * <code>int32 engine_type = 7;</code>
   * @return The engineType.
   */
  int getEngineType();

  /**
   * <code>int32 engine_id = 8;</code>
   * @return The engineId.
   */
  int getEngineId();

  /**
   * <code>string reserved = 9;</code>
   * @return The reserved.
   */
  String getReserved();
  /**
   * <code>string reserved = 9;</code>
   * @return The bytes for reserved.
   */
  com.google.protobuf.ByteString
      getReservedBytes();
}