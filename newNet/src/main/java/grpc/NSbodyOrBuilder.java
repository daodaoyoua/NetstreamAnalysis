// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Simulator.proto

package grpc;

public interface NSbodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.NSbody)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>double Start_time = 1;</code>
   * @return The startTime.
   */
  double getStartTime();

  /**
   * <code>double End_time = 2;</code>
   * @return The endTime.
   */
  double getEndTime();

  /**
   * <code>int32 Package_count = 3;</code>
   * @return The packageCount.
   */
  int getPackageCount();

  /**
   * <code>int32 Byte_count = 4;</code>
   * @return The byteCount.
   */
  int getByteCount();

  /**
   * <pre>
   *对应号
   * </pre>
   *
   * <code>int32 Protocol_type = 5;</code>
   * @return The protocolType.
   */
  int getProtocolType();

  /**
   * <code>string Dst_IP = 6;</code>
   * @return The dstIP.
   */
  String getDstIP();
  /**
   * <code>string Dst_IP = 6;</code>
   * @return The bytes for dstIP.
   */
  com.google.protobuf.ByteString
      getDstIPBytes();

  /**
   * <code>string Src_IP = 7;</code>
   * @return The srcIP.
   */
  String getSrcIP();
  /**
   * <code>string Src_IP = 7;</code>
   * @return The bytes for srcIP.
   */
  com.google.protobuf.ByteString
      getSrcIPBytes();

  /**
   * <code>string Next_IP = 8;</code>
   * @return The nextIP.
   */
  String getNextIP();
  /**
   * <code>string Next_IP = 8;</code>
   * @return The bytes for nextIP.
   */
  com.google.protobuf.ByteString
      getNextIPBytes();

  /**
   * <code>string Dstmask = 9;</code>
   * @return The dstmask.
   */
  String getDstmask();
  /**
   * <code>string Dstmask = 9;</code>
   * @return The bytes for dstmask.
   */
  com.google.protobuf.ByteString
      getDstmaskBytes();

  /**
   * <code>string Srcmask = 10;</code>
   * @return The srcmask.
   */
  String getSrcmask();
  /**
   * <code>string Srcmask = 10;</code>
   * @return The bytes for srcmask.
   */
  com.google.protobuf.ByteString
      getSrcmaskBytes();

  /**
   * <code>int32 Dst_AS = 11;</code>
   * @return The dstAS.
   */
  int getDstAS();

  /**
   * <code>int32 Src_AS = 12;</code>
   * @return The srcAS.
   */
  int getSrcAS();

  /**
   * <code>string Out_interface = 13;</code>
   * @return The outInterface.
   */
  String getOutInterface();
  /**
   * <code>string Out_interface = 13;</code>
   * @return The bytes for outInterface.
   */
  com.google.protobuf.ByteString
      getOutInterfaceBytes();

  /**
   * <code>string In_interface = 14;</code>
   * @return The inInterface.
   */
  String getInInterface();
  /**
   * <code>string In_interface = 14;</code>
   * @return The bytes for inInterface.
   */
  com.google.protobuf.ByteString
      getInInterfaceBytes();

  /**
   * <code>int32 Dst_port = 15;</code>
   * @return The dstPort.
   */
  int getDstPort();

  /**
   * <code>int32 Src_port = 16;</code>
   * @return The srcPort.
   */
  int getSrcPort();

  /**
   * <code>int32 Tos = 17;</code>
   * @return The tos.
   */
  int getTos();

  /**
   * <code>string Reserved = 18;</code>
   * @return The reserved.
   */
  String getReserved();
  /**
   * <code>string Reserved = 18;</code>
   * @return The bytes for reserved.
   */
  com.google.protobuf.ByteString
      getReservedBytes();
}