// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: v2ray.com/core/app/proxyman/command/command.proto

package com.v2ray.core.app.proxyman.command;

/**
 * Protobuf type {@code v2ray.core.app.proxyman.command.AlterOutboundRequest}
 */
public  final class AlterOutboundRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:v2ray.core.app.proxyman.command.AlterOutboundRequest)
    AlterOutboundRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AlterOutboundRequest.newBuilder() to construct.
  private AlterOutboundRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AlterOutboundRequest() {
    tag_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AlterOutboundRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 10: {
            String s = input.readStringRequireUtf8();

            tag_ = s;
            break;
          }
          case 18: {
            com.v2ray.core.common.serial.TypedMessage.Builder subBuilder = null;
            if (operation_ != null) {
              subBuilder = operation_.toBuilder();
            }
            operation_ = input.readMessage(com.v2ray.core.common.serial.TypedMessage.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(operation_);
              operation_ = subBuilder.buildPartial();
            }

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
    return Command.internal_static_v2ray_core_app_proxyman_command_AlterOutboundRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Command.internal_static_v2ray_core_app_proxyman_command_AlterOutboundRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AlterOutboundRequest.class, Builder.class);
  }

  public static final int TAG_FIELD_NUMBER = 1;
  private volatile Object tag_;
  /**
   * <code>string tag = 1;</code>
   */
  public String getTag() {
    Object ref = tag_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      tag_ = s;
      return s;
    }
  }
  /**
   * <code>string tag = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTagBytes() {
    Object ref = tag_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      tag_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OPERATION_FIELD_NUMBER = 2;
  private com.v2ray.core.common.serial.TypedMessage operation_;
  /**
   * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
   */
  public boolean hasOperation() {
    return operation_ != null;
  }
  /**
   * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
   */
  public com.v2ray.core.common.serial.TypedMessage getOperation() {
    return operation_ == null ? com.v2ray.core.common.serial.TypedMessage.getDefaultInstance() : operation_;
  }
  /**
   * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
   */
  public com.v2ray.core.common.serial.TypedMessageOrBuilder getOperationOrBuilder() {
    return getOperation();
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
    if (!getTagBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, tag_);
    }
    if (operation_ != null) {
      output.writeMessage(2, getOperation());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTagBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, tag_);
    }
    if (operation_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getOperation());
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
    if (!(obj instanceof AlterOutboundRequest)) {
      return super.equals(obj);
    }
    AlterOutboundRequest other = (AlterOutboundRequest) obj;

    if (!getTag()
        .equals(other.getTag())) return false;
    if (hasOperation() != other.hasOperation()) return false;
    if (hasOperation()) {
      if (!getOperation()
          .equals(other.getOperation())) return false;
    }
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
    hash = (37 * hash) + TAG_FIELD_NUMBER;
    hash = (53 * hash) + getTag().hashCode();
    if (hasOperation()) {
      hash = (37 * hash) + OPERATION_FIELD_NUMBER;
      hash = (53 * hash) + getOperation().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AlterOutboundRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AlterOutboundRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AlterOutboundRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AlterOutboundRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AlterOutboundRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AlterOutboundRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AlterOutboundRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AlterOutboundRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AlterOutboundRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AlterOutboundRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AlterOutboundRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AlterOutboundRequest parseFrom(
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
  public static Builder newBuilder(AlterOutboundRequest prototype) {
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
   * Protobuf type {@code v2ray.core.app.proxyman.command.AlterOutboundRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:v2ray.core.app.proxyman.command.AlterOutboundRequest)
      com.v2ray.core.app.proxyman.command.AlterOutboundRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Command.internal_static_v2ray_core_app_proxyman_command_AlterOutboundRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Command.internal_static_v2ray_core_app_proxyman_command_AlterOutboundRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AlterOutboundRequest.class, Builder.class);
    }

    // Construct using com.v2ray.core.app.proxyman.command.AlterOutboundRequest.newBuilder()
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
      tag_ = "";

      if (operationBuilder_ == null) {
        operation_ = null;
      } else {
        operation_ = null;
        operationBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Command.internal_static_v2ray_core_app_proxyman_command_AlterOutboundRequest_descriptor;
    }

    @Override
    public AlterOutboundRequest getDefaultInstanceForType() {
      return AlterOutboundRequest.getDefaultInstance();
    }

    @Override
    public AlterOutboundRequest build() {
      AlterOutboundRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public AlterOutboundRequest buildPartial() {
      AlterOutboundRequest result = new AlterOutboundRequest(this);
      result.tag_ = tag_;
      if (operationBuilder_ == null) {
        result.operation_ = operation_;
      } else {
        result.operation_ = operationBuilder_.build();
      }
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
      if (other instanceof AlterOutboundRequest) {
        return mergeFrom((AlterOutboundRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AlterOutboundRequest other) {
      if (other == AlterOutboundRequest.getDefaultInstance()) return this;
      if (!other.getTag().isEmpty()) {
        tag_ = other.tag_;
        onChanged();
      }
      if (other.hasOperation()) {
        mergeOperation(other.getOperation());
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
      AlterOutboundRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AlterOutboundRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object tag_ = "";
    /**
     * <code>string tag = 1;</code>
     */
    public String getTag() {
      Object ref = tag_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        tag_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string tag = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTagBytes() {
      Object ref = tag_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        tag_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string tag = 1;</code>
     */
    public Builder setTag(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      tag_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string tag = 1;</code>
     */
    public Builder clearTag() {
      
      tag_ = getDefaultInstance().getTag();
      onChanged();
      return this;
    }
    /**
     * <code>string tag = 1;</code>
     */
    public Builder setTagBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      tag_ = value;
      onChanged();
      return this;
    }

    private com.v2ray.core.common.serial.TypedMessage operation_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.v2ray.core.common.serial.TypedMessage, com.v2ray.core.common.serial.TypedMessage.Builder, com.v2ray.core.common.serial.TypedMessageOrBuilder> operationBuilder_;
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public boolean hasOperation() {
      return operationBuilder_ != null || operation_ != null;
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public com.v2ray.core.common.serial.TypedMessage getOperation() {
      if (operationBuilder_ == null) {
        return operation_ == null ? com.v2ray.core.common.serial.TypedMessage.getDefaultInstance() : operation_;
      } else {
        return operationBuilder_.getMessage();
      }
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public Builder setOperation(com.v2ray.core.common.serial.TypedMessage value) {
      if (operationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        operation_ = value;
        onChanged();
      } else {
        operationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public Builder setOperation(
        com.v2ray.core.common.serial.TypedMessage.Builder builderForValue) {
      if (operationBuilder_ == null) {
        operation_ = builderForValue.build();
        onChanged();
      } else {
        operationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public Builder mergeOperation(com.v2ray.core.common.serial.TypedMessage value) {
      if (operationBuilder_ == null) {
        if (operation_ != null) {
          operation_ =
            com.v2ray.core.common.serial.TypedMessage.newBuilder(operation_).mergeFrom(value).buildPartial();
        } else {
          operation_ = value;
        }
        onChanged();
      } else {
        operationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public Builder clearOperation() {
      if (operationBuilder_ == null) {
        operation_ = null;
        onChanged();
      } else {
        operation_ = null;
        operationBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public com.v2ray.core.common.serial.TypedMessage.Builder getOperationBuilder() {
      
      onChanged();
      return getOperationFieldBuilder().getBuilder();
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    public com.v2ray.core.common.serial.TypedMessageOrBuilder getOperationOrBuilder() {
      if (operationBuilder_ != null) {
        return operationBuilder_.getMessageOrBuilder();
      } else {
        return operation_ == null ?
            com.v2ray.core.common.serial.TypedMessage.getDefaultInstance() : operation_;
      }
    }
    /**
     * <code>.v2ray.core.common.serial.TypedMessage operation = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.v2ray.core.common.serial.TypedMessage, com.v2ray.core.common.serial.TypedMessage.Builder, com.v2ray.core.common.serial.TypedMessageOrBuilder> 
        getOperationFieldBuilder() {
      if (operationBuilder_ == null) {
        operationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.v2ray.core.common.serial.TypedMessage, com.v2ray.core.common.serial.TypedMessage.Builder, com.v2ray.core.common.serial.TypedMessageOrBuilder>(
                getOperation(),
                getParentForChildren(),
                isClean());
        operation_ = null;
      }
      return operationBuilder_;
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


    // @@protoc_insertion_point(builder_scope:v2ray.core.app.proxyman.command.AlterOutboundRequest)
  }

  // @@protoc_insertion_point(class_scope:v2ray.core.app.proxyman.command.AlterOutboundRequest)
  private static final AlterOutboundRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AlterOutboundRequest();
  }

  public static AlterOutboundRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AlterOutboundRequest>
      PARSER = new com.google.protobuf.AbstractParser<AlterOutboundRequest>() {
    @Override
    public AlterOutboundRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AlterOutboundRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AlterOutboundRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AlterOutboundRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public AlterOutboundRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

