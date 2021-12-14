// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Simulator.proto

package grpc;

/**
 * Protobuf type {@code grpc.NShead}
 */
public final class NShead extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.NShead)
    NSheadOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NShead.newBuilder() to construct.
  private NShead(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NShead() {
    reserved_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new NShead();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NShead(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            version_ = input.readInt32();
            break;
          }
          case 16: {

            count_ = input.readInt32();
            break;
          }
          case 25: {

            sysUptime_ = input.readDouble();
            break;
          }
          case 33: {

            unixSecs_ = input.readDouble();
            break;
          }
          case 41: {

            unixNsecs_ = input.readDouble();
            break;
          }
          case 48: {

            flowSequence_ = input.readInt64();
            break;
          }
          case 56: {

            engineType_ = input.readInt32();
            break;
          }
          case 64: {

            engineId_ = input.readInt32();
            break;
          }
          case 74: {
            String s = input.readStringRequireUtf8();

            reserved_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Simulator.internal_static_grpc_NShead_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Simulator.internal_static_grpc_NShead_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            NShead.class, Builder.class);
  }

  public static final int VERSION_FIELD_NUMBER = 1;
  private int version_;
  /**
   * <code>int32 version = 1;</code>
   * @return The version.
   */
  @Override
  public int getVersion() {
    return version_;
  }

  public static final int COUNT_FIELD_NUMBER = 2;
  private int count_;
  /**
   * <code>int32 count = 2;</code>
   * @return The count.
   */
  @Override
  public int getCount() {
    return count_;
  }

  public static final int SYSUPTIME_FIELD_NUMBER = 3;
  private double sysUptime_;
  /**
   * <code>double SysUptime = 3;</code>
   * @return The sysUptime.
   */
  @Override
  public double getSysUptime() {
    return sysUptime_;
  }

  public static final int UNIX_SECS_FIELD_NUMBER = 4;
  private double unixSecs_;
  /**
   * <code>double unix_secs = 4;</code>
   * @return The unixSecs.
   */
  @Override
  public double getUnixSecs() {
    return unixSecs_;
  }

  public static final int UNIX_NSECS_FIELD_NUMBER = 5;
  private double unixNsecs_;
  /**
   * <code>double unix_nsecs = 5;</code>
   * @return The unixNsecs.
   */
  @Override
  public double getUnixNsecs() {
    return unixNsecs_;
  }

  public static final int FLOW_SEQUENCE_FIELD_NUMBER = 6;
  private long flowSequence_;
  /**
   * <code>int64 flow_sequence = 6;</code>
   * @return The flowSequence.
   */
  @Override
  public long getFlowSequence() {
    return flowSequence_;
  }

  public static final int ENGINE_TYPE_FIELD_NUMBER = 7;
  private int engineType_;
  /**
   * <code>int32 engine_type = 7;</code>
   * @return The engineType.
   */
  @Override
  public int getEngineType() {
    return engineType_;
  }

  public static final int ENGINE_ID_FIELD_NUMBER = 8;
  private int engineId_;
  /**
   * <code>int32 engine_id = 8;</code>
   * @return The engineId.
   */
  @Override
  public int getEngineId() {
    return engineId_;
  }

  public static final int RESERVED_FIELD_NUMBER = 9;
  private volatile Object reserved_;
  /**
   * <code>string reserved = 9;</code>
   * @return The reserved.
   */
  @Override
  public String getReserved() {
    Object ref = reserved_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      reserved_ = s;
      return s;
    }
  }
  /**
   * <code>string reserved = 9;</code>
   * @return The bytes for reserved.
   */
  @Override
  public com.google.protobuf.ByteString
      getReservedBytes() {
    Object ref = reserved_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      reserved_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (version_ != 0) {
      output.writeInt32(1, version_);
    }
    if (count_ != 0) {
      output.writeInt32(2, count_);
    }
    if (sysUptime_ != 0D) {
      output.writeDouble(3, sysUptime_);
    }
    if (unixSecs_ != 0D) {
      output.writeDouble(4, unixSecs_);
    }
    if (unixNsecs_ != 0D) {
      output.writeDouble(5, unixNsecs_);
    }
    if (flowSequence_ != 0L) {
      output.writeInt64(6, flowSequence_);
    }
    if (engineType_ != 0) {
      output.writeInt32(7, engineType_);
    }
    if (engineId_ != 0) {
      output.writeInt32(8, engineId_);
    }
    if (!getReservedBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 9, reserved_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (version_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, version_);
    }
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, count_);
    }
    if (sysUptime_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, sysUptime_);
    }
    if (unixSecs_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, unixSecs_);
    }
    if (unixNsecs_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, unixNsecs_);
    }
    if (flowSequence_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, flowSequence_);
    }
    if (engineType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, engineType_);
    }
    if (engineId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(8, engineId_);
    }
    if (!getReservedBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, reserved_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof NShead)) {
      return super.equals(obj);
    }
    NShead other = (NShead) obj;

    if (getVersion()
        != other.getVersion()) return false;
    if (getCount()
        != other.getCount()) return false;
    if (Double.doubleToLongBits(getSysUptime())
        != Double.doubleToLongBits(
            other.getSysUptime())) return false;
    if (Double.doubleToLongBits(getUnixSecs())
        != Double.doubleToLongBits(
            other.getUnixSecs())) return false;
    if (Double.doubleToLongBits(getUnixNsecs())
        != Double.doubleToLongBits(
            other.getUnixNsecs())) return false;
    if (getFlowSequence()
        != other.getFlowSequence()) return false;
    if (getEngineType()
        != other.getEngineType()) return false;
    if (getEngineId()
        != other.getEngineId()) return false;
    if (!getReserved()
        .equals(other.getReserved())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVersion();
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getCount();
    hash = (37 * hash) + SYSUPTIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        Double.doubleToLongBits(getSysUptime()));
    hash = (37 * hash) + UNIX_SECS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        Double.doubleToLongBits(getUnixSecs()));
    hash = (37 * hash) + UNIX_NSECS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        Double.doubleToLongBits(getUnixNsecs()));
    hash = (37 * hash) + FLOW_SEQUENCE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFlowSequence());
    hash = (37 * hash) + ENGINE_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getEngineType();
    hash = (37 * hash) + ENGINE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getEngineId();
    hash = (37 * hash) + RESERVED_FIELD_NUMBER;
    hash = (53 * hash) + getReserved().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static NShead parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NShead parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NShead parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NShead parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NShead parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NShead parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NShead parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NShead parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static NShead parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static NShead parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static NShead parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NShead parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(NShead prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.NShead}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.NShead)
      NSheadOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Simulator.internal_static_grpc_NShead_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Simulator.internal_static_grpc_NShead_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NShead.class, Builder.class);
    }

    // Construct using grpc.NShead.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      version_ = 0;

      count_ = 0;

      sysUptime_ = 0D;

      unixSecs_ = 0D;

      unixNsecs_ = 0D;

      flowSequence_ = 0L;

      engineType_ = 0;

      engineId_ = 0;

      reserved_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Simulator.internal_static_grpc_NShead_descriptor;
    }

    @Override
    public NShead getDefaultInstanceForType() {
      return NShead.getDefaultInstance();
    }

    @Override
    public NShead build() {
      NShead result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public NShead buildPartial() {
      NShead result = new NShead(this);
      result.version_ = version_;
      result.count_ = count_;
      result.sysUptime_ = sysUptime_;
      result.unixSecs_ = unixSecs_;
      result.unixNsecs_ = unixNsecs_;
      result.flowSequence_ = flowSequence_;
      result.engineType_ = engineType_;
      result.engineId_ = engineId_;
      result.reserved_ = reserved_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof NShead) {
        return mergeFrom((NShead)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(NShead other) {
      if (other == NShead.getDefaultInstance()) return this;
      if (other.getVersion() != 0) {
        setVersion(other.getVersion());
      }
      if (other.getCount() != 0) {
        setCount(other.getCount());
      }
      if (other.getSysUptime() != 0D) {
        setSysUptime(other.getSysUptime());
      }
      if (other.getUnixSecs() != 0D) {
        setUnixSecs(other.getUnixSecs());
      }
      if (other.getUnixNsecs() != 0D) {
        setUnixNsecs(other.getUnixNsecs());
      }
      if (other.getFlowSequence() != 0L) {
        setFlowSequence(other.getFlowSequence());
      }
      if (other.getEngineType() != 0) {
        setEngineType(other.getEngineType());
      }
      if (other.getEngineId() != 0) {
        setEngineId(other.getEngineId());
      }
      if (!other.getReserved().isEmpty()) {
        reserved_ = other.reserved_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      NShead parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (NShead) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int version_ ;
    /**
     * <code>int32 version = 1;</code>
     * @return The version.
     */
    @Override
    public int getVersion() {
      return version_;
    }
    /**
     * <code>int32 version = 1;</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(int value) {
      
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      
      version_ = 0;
      onChanged();
      return this;
    }

    private int count_ ;
    /**
     * <code>int32 count = 2;</code>
     * @return The count.
     */
    @Override
    public int getCount() {
      return count_;
    }
    /**
     * <code>int32 count = 2;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(int value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 count = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      
      count_ = 0;
      onChanged();
      return this;
    }

    private double sysUptime_ ;
    /**
     * <code>double SysUptime = 3;</code>
     * @return The sysUptime.
     */
    @Override
    public double getSysUptime() {
      return sysUptime_;
    }
    /**
     * <code>double SysUptime = 3;</code>
     * @param value The sysUptime to set.
     * @return This builder for chaining.
     */
    public Builder setSysUptime(double value) {
      
      sysUptime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double SysUptime = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSysUptime() {
      
      sysUptime_ = 0D;
      onChanged();
      return this;
    }

    private double unixSecs_ ;
    /**
     * <code>double unix_secs = 4;</code>
     * @return The unixSecs.
     */
    @Override
    public double getUnixSecs() {
      return unixSecs_;
    }
    /**
     * <code>double unix_secs = 4;</code>
     * @param value The unixSecs to set.
     * @return This builder for chaining.
     */
    public Builder setUnixSecs(double value) {
      
      unixSecs_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double unix_secs = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearUnixSecs() {
      
      unixSecs_ = 0D;
      onChanged();
      return this;
    }

    private double unixNsecs_ ;
    /**
     * <code>double unix_nsecs = 5;</code>
     * @return The unixNsecs.
     */
    @Override
    public double getUnixNsecs() {
      return unixNsecs_;
    }
    /**
     * <code>double unix_nsecs = 5;</code>
     * @param value The unixNsecs to set.
     * @return This builder for chaining.
     */
    public Builder setUnixNsecs(double value) {
      
      unixNsecs_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double unix_nsecs = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearUnixNsecs() {
      
      unixNsecs_ = 0D;
      onChanged();
      return this;
    }

    private long flowSequence_ ;
    /**
     * <code>int64 flow_sequence = 6;</code>
     * @return The flowSequence.
     */
    @Override
    public long getFlowSequence() {
      return flowSequence_;
    }
    /**
     * <code>int64 flow_sequence = 6;</code>
     * @param value The flowSequence to set.
     * @return This builder for chaining.
     */
    public Builder setFlowSequence(long value) {
      
      flowSequence_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 flow_sequence = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearFlowSequence() {
      
      flowSequence_ = 0L;
      onChanged();
      return this;
    }

    private int engineType_ ;
    /**
     * <code>int32 engine_type = 7;</code>
     * @return The engineType.
     */
    @Override
    public int getEngineType() {
      return engineType_;
    }
    /**
     * <code>int32 engine_type = 7;</code>
     * @param value The engineType to set.
     * @return This builder for chaining.
     */
    public Builder setEngineType(int value) {
      
      engineType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 engine_type = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearEngineType() {
      
      engineType_ = 0;
      onChanged();
      return this;
    }

    private int engineId_ ;
    /**
     * <code>int32 engine_id = 8;</code>
     * @return The engineId.
     */
    @Override
    public int getEngineId() {
      return engineId_;
    }
    /**
     * <code>int32 engine_id = 8;</code>
     * @param value The engineId to set.
     * @return This builder for chaining.
     */
    public Builder setEngineId(int value) {
      
      engineId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 engine_id = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearEngineId() {
      
      engineId_ = 0;
      onChanged();
      return this;
    }

    private Object reserved_ = "";
    /**
     * <code>string reserved = 9;</code>
     * @return The reserved.
     */
    public String getReserved() {
      Object ref = reserved_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        reserved_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string reserved = 9;</code>
     * @return The bytes for reserved.
     */
    public com.google.protobuf.ByteString
        getReservedBytes() {
      Object ref = reserved_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        reserved_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reserved = 9;</code>
     * @param value The reserved to set.
     * @return This builder for chaining.
     */
    public Builder setReserved(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reserved_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reserved = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearReserved() {
      
      reserved_ = getDefaultInstance().getReserved();
      onChanged();
      return this;
    }
    /**
     * <code>string reserved = 9;</code>
     * @param value The bytes for reserved to set.
     * @return This builder for chaining.
     */
    public Builder setReservedBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reserved_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.NShead)
  }

  // @@protoc_insertion_point(class_scope:grpc.NShead)
  private static final NShead DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new NShead();
  }

  public static NShead getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NShead>
      PARSER = new com.google.protobuf.AbstractParser<NShead>() {
    @Override
    public NShead parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NShead(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NShead> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NShead> getParserForType() {
    return PARSER;
  }

  @Override
  public NShead getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
