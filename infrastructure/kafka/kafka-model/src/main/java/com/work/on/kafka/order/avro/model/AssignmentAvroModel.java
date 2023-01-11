/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.work.on.kafka.order.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AssignmentAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -9027827578944204914L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AssignmentAvroModel\",\"namespace\":\"com.work.on.kafka.order.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"topic\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"deliveryDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"points\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"tasks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"TaskAvroModel\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"description\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"polls\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"PollAvroModel\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"pollName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"questions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"QuestionAvroModel\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"questionDesc\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"answer\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}}]}}},{\"name\":\"files\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FileAssignmentAvroModel\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"}]}}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<AssignmentAvroModel> ENCODER =
      new BinaryMessageEncoder<AssignmentAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AssignmentAvroModel> DECODER =
      new BinaryMessageDecoder<AssignmentAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AssignmentAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AssignmentAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AssignmentAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AssignmentAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AssignmentAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AssignmentAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AssignmentAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AssignmentAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String topic;
  private java.lang.String customerId;
  private java.time.Instant deliveryDate;
  private java.time.Instant createdAt;
  private java.math.BigDecimal points;
  private java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> tasks;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AssignmentAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param topic The new value for topic
   * @param customerId The new value for customerId
   * @param deliveryDate The new value for deliveryDate
   * @param createdAt The new value for createdAt
   * @param points The new value for points
   * @param tasks The new value for tasks
   */
  public AssignmentAvroModel(java.lang.String id, java.lang.String topic, java.lang.String customerId, java.time.Instant deliveryDate, java.time.Instant createdAt, java.math.BigDecimal points, java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> tasks) {
    this.id = id;
    this.topic = topic;
    this.customerId = customerId;
    this.deliveryDate = deliveryDate.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.points = points;
    this.tasks = tasks;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return topic;
    case 2: return customerId;
    case 3: return deliveryDate;
    case 4: return createdAt;
    case 5: return points;
    case 6: return tasks;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      new org.apache.avro.Conversions.DecimalConversion(),
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: topic = value$ != null ? value$.toString() : null; break;
    case 2: customerId = value$ != null ? value$.toString() : null; break;
    case 3: deliveryDate = (java.time.Instant)value$; break;
    case 4: createdAt = (java.time.Instant)value$; break;
    case 5: points = (java.math.BigDecimal)value$; break;
    case 6: tasks = (java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'topic' field.
   * @return The value of the 'topic' field.
   */
  public java.lang.String getTopic() {
    return topic;
  }


  /**
   * Sets the value of the 'topic' field.
   * @param value the value to set.
   */
  public void setTopic(java.lang.String value) {
    this.topic = value;
  }

  /**
   * Gets the value of the 'customerId' field.
   * @return The value of the 'customerId' field.
   */
  public java.lang.String getCustomerId() {
    return customerId;
  }


  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.String value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'deliveryDate' field.
   * @return The value of the 'deliveryDate' field.
   */
  public java.time.Instant getDeliveryDate() {
    return deliveryDate;
  }


  /**
   * Sets the value of the 'deliveryDate' field.
   * @param value the value to set.
   */
  public void setDeliveryDate(java.time.Instant value) {
    this.deliveryDate = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'points' field.
   * @return The value of the 'points' field.
   */
  public java.math.BigDecimal getPoints() {
    return points;
  }


  /**
   * Sets the value of the 'points' field.
   * @param value the value to set.
   */
  public void setPoints(java.math.BigDecimal value) {
    this.points = value;
  }

  /**
   * Gets the value of the 'tasks' field.
   * @return The value of the 'tasks' field.
   */
  public java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> getTasks() {
    return tasks;
  }


  /**
   * Sets the value of the 'tasks' field.
   * @param value the value to set.
   */
  public void setTasks(java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> value) {
    this.tasks = value;
  }

  /**
   * Creates a new AssignmentAvroModel RecordBuilder.
   * @return A new AssignmentAvroModel RecordBuilder
   */
  public static com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder newBuilder() {
    return new com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder();
  }

  /**
   * Creates a new AssignmentAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AssignmentAvroModel RecordBuilder
   */
  public static com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder newBuilder(com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder other) {
    if (other == null) {
      return new com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder();
    } else {
      return new com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new AssignmentAvroModel RecordBuilder by copying an existing AssignmentAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new AssignmentAvroModel RecordBuilder
   */
  public static com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder newBuilder(com.work.on.kafka.order.avro.model.AssignmentAvroModel other) {
    if (other == null) {
      return new com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder();
    } else {
      return new com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for AssignmentAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AssignmentAvroModel>
    implements org.apache.avro.data.RecordBuilder<AssignmentAvroModel> {

    private java.lang.String id;
    private java.lang.String topic;
    private java.lang.String customerId;
    private java.time.Instant deliveryDate;
    private java.time.Instant createdAt;
    private java.math.BigDecimal points;
    private java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> tasks;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.topic)) {
        this.topic = data().deepCopy(fields()[1].schema(), other.topic);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customerId)) {
        this.customerId = data().deepCopy(fields()[2].schema(), other.customerId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.deliveryDate)) {
        this.deliveryDate = data().deepCopy(fields()[3].schema(), other.deliveryDate);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.points)) {
        this.points = data().deepCopy(fields()[5].schema(), other.points);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.tasks)) {
        this.tasks = data().deepCopy(fields()[6].schema(), other.tasks);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing AssignmentAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.work.on.kafka.order.avro.model.AssignmentAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.topic)) {
        this.topic = data().deepCopy(fields()[1].schema(), other.topic);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customerId)) {
        this.customerId = data().deepCopy(fields()[2].schema(), other.customerId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.deliveryDate)) {
        this.deliveryDate = data().deepCopy(fields()[3].schema(), other.deliveryDate);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.points)) {
        this.points = data().deepCopy(fields()[5].schema(), other.points);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tasks)) {
        this.tasks = data().deepCopy(fields()[6].schema(), other.tasks);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'topic' field.
      * @return The value.
      */
    public java.lang.String getTopic() {
      return topic;
    }


    /**
      * Sets the value of the 'topic' field.
      * @param value The value of 'topic'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setTopic(java.lang.String value) {
      validate(fields()[1], value);
      this.topic = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'topic' field has been set.
      * @return True if the 'topic' field has been set, false otherwise.
      */
    public boolean hasTopic() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'topic' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearTopic() {
      topic = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerId' field.
      * @return The value.
      */
    public java.lang.String getCustomerId() {
      return customerId;
    }


    /**
      * Sets the value of the 'customerId' field.
      * @param value The value of 'customerId'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setCustomerId(java.lang.String value) {
      validate(fields()[2], value);
      this.customerId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'customerId' field has been set.
      * @return True if the 'customerId' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'customerId' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearCustomerId() {
      customerId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'deliveryDate' field.
      * @return The value.
      */
    public java.time.Instant getDeliveryDate() {
      return deliveryDate;
    }


    /**
      * Sets the value of the 'deliveryDate' field.
      * @param value The value of 'deliveryDate'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setDeliveryDate(java.time.Instant value) {
      validate(fields()[3], value);
      this.deliveryDate = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'deliveryDate' field has been set.
      * @return True if the 'deliveryDate' field has been set, false otherwise.
      */
    public boolean hasDeliveryDate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'deliveryDate' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearDeliveryDate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[4], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'points' field.
      * @return The value.
      */
    public java.math.BigDecimal getPoints() {
      return points;
    }


    /**
      * Sets the value of the 'points' field.
      * @param value The value of 'points'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setPoints(java.math.BigDecimal value) {
      validate(fields()[5], value);
      this.points = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'points' field has been set.
      * @return True if the 'points' field has been set, false otherwise.
      */
    public boolean hasPoints() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'points' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearPoints() {
      points = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'tasks' field.
      * @return The value.
      */
    public java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> getTasks() {
      return tasks;
    }


    /**
      * Sets the value of the 'tasks' field.
      * @param value The value of 'tasks'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder setTasks(java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel> value) {
      validate(fields()[6], value);
      this.tasks = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'tasks' field has been set.
      * @return True if the 'tasks' field has been set, false otherwise.
      */
    public boolean hasTasks() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'tasks' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.AssignmentAvroModel.Builder clearTasks() {
      tasks = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AssignmentAvroModel build() {
      try {
        AssignmentAvroModel record = new AssignmentAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.topic = fieldSetFlags()[1] ? this.topic : (java.lang.String) defaultValue(fields()[1]);
        record.customerId = fieldSetFlags()[2] ? this.customerId : (java.lang.String) defaultValue(fields()[2]);
        record.deliveryDate = fieldSetFlags()[3] ? this.deliveryDate : (java.time.Instant) defaultValue(fields()[3]);
        record.createdAt = fieldSetFlags()[4] ? this.createdAt : (java.time.Instant) defaultValue(fields()[4]);
        record.points = fieldSetFlags()[5] ? this.points : (java.math.BigDecimal) defaultValue(fields()[5]);
        record.tasks = fieldSetFlags()[6] ? this.tasks : (java.util.List<com.work.on.kafka.order.avro.model.TaskAvroModel>) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AssignmentAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<AssignmentAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AssignmentAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<AssignmentAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










