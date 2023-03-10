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
public class PollAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2379080522151227788L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PollAvroModel\",\"namespace\":\"com.work.on.kafka.order.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"pollName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"questions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"QuestionAvroModel\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"questionDesc\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"answer\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PollAvroModel> ENCODER =
      new BinaryMessageEncoder<PollAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PollAvroModel> DECODER =
      new BinaryMessageDecoder<PollAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PollAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PollAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PollAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PollAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PollAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PollAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PollAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PollAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String pollName;
  private java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> questions;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PollAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param pollName The new value for pollName
   * @param questions The new value for questions
   */
  public PollAvroModel(java.lang.String id, java.lang.String pollName, java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> questions) {
    this.id = id;
    this.pollName = pollName;
    this.questions = questions;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return pollName;
    case 2: return questions;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: pollName = value$ != null ? value$.toString() : null; break;
    case 2: questions = (java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel>)value$; break;
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
   * Gets the value of the 'pollName' field.
   * @return The value of the 'pollName' field.
   */
  public java.lang.String getPollName() {
    return pollName;
  }


  /**
   * Sets the value of the 'pollName' field.
   * @param value the value to set.
   */
  public void setPollName(java.lang.String value) {
    this.pollName = value;
  }

  /**
   * Gets the value of the 'questions' field.
   * @return The value of the 'questions' field.
   */
  public java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> getQuestions() {
    return questions;
  }


  /**
   * Sets the value of the 'questions' field.
   * @param value the value to set.
   */
  public void setQuestions(java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> value) {
    this.questions = value;
  }

  /**
   * Creates a new PollAvroModel RecordBuilder.
   * @return A new PollAvroModel RecordBuilder
   */
  public static com.work.on.kafka.order.avro.model.PollAvroModel.Builder newBuilder() {
    return new com.work.on.kafka.order.avro.model.PollAvroModel.Builder();
  }

  /**
   * Creates a new PollAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PollAvroModel RecordBuilder
   */
  public static com.work.on.kafka.order.avro.model.PollAvroModel.Builder newBuilder(com.work.on.kafka.order.avro.model.PollAvroModel.Builder other) {
    if (other == null) {
      return new com.work.on.kafka.order.avro.model.PollAvroModel.Builder();
    } else {
      return new com.work.on.kafka.order.avro.model.PollAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PollAvroModel RecordBuilder by copying an existing PollAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PollAvroModel RecordBuilder
   */
  public static com.work.on.kafka.order.avro.model.PollAvroModel.Builder newBuilder(com.work.on.kafka.order.avro.model.PollAvroModel other) {
    if (other == null) {
      return new com.work.on.kafka.order.avro.model.PollAvroModel.Builder();
    } else {
      return new com.work.on.kafka.order.avro.model.PollAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PollAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PollAvroModel>
    implements org.apache.avro.data.RecordBuilder<PollAvroModel> {

    private java.lang.String id;
    private java.lang.String pollName;
    private java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> questions;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.work.on.kafka.order.avro.model.PollAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.pollName)) {
        this.pollName = data().deepCopy(fields()[1].schema(), other.pollName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.questions)) {
        this.questions = data().deepCopy(fields()[2].schema(), other.questions);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing PollAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.work.on.kafka.order.avro.model.PollAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pollName)) {
        this.pollName = data().deepCopy(fields()[1].schema(), other.pollName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.questions)) {
        this.questions = data().deepCopy(fields()[2].schema(), other.questions);
        fieldSetFlags()[2] = true;
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
    public com.work.on.kafka.order.avro.model.PollAvroModel.Builder setId(java.lang.String value) {
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
    public com.work.on.kafka.order.avro.model.PollAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'pollName' field.
      * @return The value.
      */
    public java.lang.String getPollName() {
      return pollName;
    }


    /**
      * Sets the value of the 'pollName' field.
      * @param value The value of 'pollName'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.PollAvroModel.Builder setPollName(java.lang.String value) {
      validate(fields()[1], value);
      this.pollName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'pollName' field has been set.
      * @return True if the 'pollName' field has been set, false otherwise.
      */
    public boolean hasPollName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'pollName' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.PollAvroModel.Builder clearPollName() {
      pollName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'questions' field.
      * @return The value.
      */
    public java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> getQuestions() {
      return questions;
    }


    /**
      * Sets the value of the 'questions' field.
      * @param value The value of 'questions'.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.PollAvroModel.Builder setQuestions(java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> value) {
      validate(fields()[2], value);
      this.questions = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'questions' field has been set.
      * @return True if the 'questions' field has been set, false otherwise.
      */
    public boolean hasQuestions() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'questions' field.
      * @return This builder.
      */
    public com.work.on.kafka.order.avro.model.PollAvroModel.Builder clearQuestions() {
      questions = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PollAvroModel build() {
      try {
        PollAvroModel record = new PollAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.pollName = fieldSetFlags()[1] ? this.pollName : (java.lang.String) defaultValue(fields()[1]);
        record.questions = fieldSetFlags()[2] ? this.questions : (java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel>) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PollAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PollAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PollAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PollAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.pollName);

    long size0 = this.questions.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (com.work.on.kafka.order.avro.model.QuestionAvroModel e0: this.questions) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString();

      this.pollName = in.readString();

      long size0 = in.readArrayStart();
      java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> a0 = this.questions;
      if (a0 == null) {
        a0 = new SpecificData.Array<com.work.on.kafka.order.avro.model.QuestionAvroModel>((int)size0, SCHEMA$.getField("questions").schema());
        this.questions = a0;
      } else a0.clear();
      SpecificData.Array<com.work.on.kafka.order.avro.model.QuestionAvroModel> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.work.on.kafka.order.avro.model.QuestionAvroModel>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          com.work.on.kafka.order.avro.model.QuestionAvroModel e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new com.work.on.kafka.order.avro.model.QuestionAvroModel();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString();
          break;

        case 1:
          this.pollName = in.readString();
          break;

        case 2:
          long size0 = in.readArrayStart();
          java.util.List<com.work.on.kafka.order.avro.model.QuestionAvroModel> a0 = this.questions;
          if (a0 == null) {
            a0 = new SpecificData.Array<com.work.on.kafka.order.avro.model.QuestionAvroModel>((int)size0, SCHEMA$.getField("questions").schema());
            this.questions = a0;
          } else a0.clear();
          SpecificData.Array<com.work.on.kafka.order.avro.model.QuestionAvroModel> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.work.on.kafka.order.avro.model.QuestionAvroModel>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              com.work.on.kafka.order.avro.model.QuestionAvroModel e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new com.work.on.kafka.order.avro.model.QuestionAvroModel();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










