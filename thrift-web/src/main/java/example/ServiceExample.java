/**
 * Autogenerated by Thrift Compiler (0.9.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package example;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceExample {

    public interface Iface {

        public BeanExample getBean(int anArg, String anOther) throws org.apache.thrift.TException;

    }

    public interface AsyncIface {

        public void getBean(int anArg, String anOther, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.getBean_call> resultHandler) throws org.apache.thrift.TException;

    }

    public static class Client extends org.apache.thrift.TServiceClient implements Iface {
        public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
            public Factory() {
            }

            public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
                return new Client(prot);
            }

            public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
                return new Client(iprot, oprot);
            }
        }

        public Client(org.apache.thrift.protocol.TProtocol prot) {
            super(prot, prot);
        }

        public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
            super(iprot, oprot);
        }

        public BeanExample getBean(int anArg, String anOther) throws org.apache.thrift.TException {
            send_getBean(anArg, anOther);
            return recv_getBean();
        }

        public void send_getBean(int anArg, String anOther) throws org.apache.thrift.TException {
            getBean_args args = new getBean_args();
            args.setAnArg(anArg);
            args.setAnOther(anOther);
            sendBase("getBean", args);
        }

        public BeanExample recv_getBean() throws org.apache.thrift.TException {
            getBean_result result = new getBean_result();
            receiveBase(result, "getBean");
            if (result.isSetSuccess()) {
                return result.success;
            }
            throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getBean failed: unknown result");
        }

    }

    public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
        public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
            private org.apache.thrift.async.TAsyncClientManager clientManager;
            private org.apache.thrift.protocol.TProtocolFactory protocolFactory;

            public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
                this.clientManager = clientManager;
                this.protocolFactory = protocolFactory;
            }

            public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
                return new AsyncClient(protocolFactory, clientManager, transport);
            }
        }

        public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
            super(protocolFactory, clientManager, transport);
        }

        public void getBean(int anArg, String anOther, org.apache.thrift.async.AsyncMethodCallback<getBean_call> resultHandler) throws org.apache.thrift.TException {
            checkReady();
            getBean_call method_call = new getBean_call(anArg, anOther, resultHandler, this, ___protocolFactory, ___transport);
            this.___currentMethod = method_call;
            ___manager.call(method_call);
        }

        public static class getBean_call extends org.apache.thrift.async.TAsyncMethodCall {
            private int anArg;
            private String anOther;

            public getBean_call(int anArg, String anOther, org.apache.thrift.async.AsyncMethodCallback<getBean_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
                super(client, protocolFactory, transport, resultHandler, false);
                this.anArg = anArg;
                this.anOther = anOther;
            }

            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
                prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getBean", org.apache.thrift.protocol.TMessageType.CALL, 0));
                getBean_args args = new getBean_args();
                args.setAnArg(anArg);
                args.setAnOther(anOther);
                args.write(prot);
                prot.writeMessageEnd();
            }

            public BeanExample getResult() throws org.apache.thrift.TException {
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                return (new Client(prot)).recv_getBean();
            }
        }

    }

    public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
        private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());

        public Processor(I iface) {
            super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
        }

        protected Processor(I iface, Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
            super(iface, getProcessMap(processMap));
        }

        private static <I extends Iface> Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
            processMap.put("getBean", new getBean());
            return processMap;
        }

        public static class getBean<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getBean_args> {
            public getBean() {
                super("getBean");
            }

            public getBean_args getEmptyArgsInstance() {
                return new getBean_args();
            }

            protected boolean isOneway() {
                return false;
            }

            public getBean_result getResult(I iface, getBean_args args) throws org.apache.thrift.TException {
                getBean_result result = new getBean_result();
                result.success = iface.getBean(args.anArg, args.anOther);
                return result;
            }
        }

    }

    public static class getBean_args implements org.apache.thrift.TBase<getBean_args, getBean_args._Fields>, java.io.Serializable, Cloneable {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getBean_args");

        private static final org.apache.thrift.protocol.TField AN_ARG_FIELD_DESC = new org.apache.thrift.protocol.TField("anArg", org.apache.thrift.protocol.TType.I32, (short) 1);
        private static final org.apache.thrift.protocol.TField AN_OTHER_FIELD_DESC = new org.apache.thrift.protocol.TField("anOther", org.apache.thrift.protocol.TType.STRING, (short) 2);

        private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();

        static {
            schemes.put(StandardScheme.class, new getBean_argsStandardSchemeFactory());
            schemes.put(TupleScheme.class, new getBean_argsTupleSchemeFactory());
        }

        public int anArg; // required
        public String anOther; // required

        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            AN_ARG((short) 1, "anArg"),
            AN_OTHER((short) 2, "anOther");

            private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

            static {
                for (_Fields field : EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, or null if its not found.
             */
            public static _Fields findByThriftId(int fieldId) {
                switch (fieldId) {
                    case 1: // AN_ARG
                        return AN_ARG;
                    case 2: // AN_OTHER
                        return AN_OTHER;
                    default:
                        return null;
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, throwing an exception
             * if it is not found.
             */
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                _Fields fields = findByThriftId(fieldId);
                if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return fields;
            }

            /**
             * Find the _Fields constant that matches name, or null if its not found.
             */
            public static _Fields findByName(String name) {
                return byName.get(name);
            }

            private final short _thriftId;
            private final String _fieldName;

            _Fields(short thriftId, String fieldName) {
                _thriftId = thriftId;
                _fieldName = fieldName;
            }

            public short getThriftFieldId() {
                return _thriftId;
            }

            public String getFieldName() {
                return _fieldName;
            }
        }

        // isset id assignments
        private static final int __ANARG_ISSET_ID = 0;
        private byte __isset_bitfield = 0;
        public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

        static {
            Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            tmpMap.put(_Fields.AN_ARG, new org.apache.thrift.meta_data.FieldMetaData("anArg", org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
            tmpMap.put(_Fields.AN_OTHER, new org.apache.thrift.meta_data.FieldMetaData("anOther", org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getBean_args.class, metaDataMap);
        }

        public getBean_args() {
        }

        public getBean_args(
                int anArg,
                String anOther) {
            this();
            this.anArg = anArg;
            setAnArgIsSet(true);
            this.anOther = anOther;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public getBean_args(getBean_args other) {
            __isset_bitfield = other.__isset_bitfield;
            this.anArg = other.anArg;
            if (other.isSetAnOther()) {
                this.anOther = other.anOther;
            }
        }

        public getBean_args deepCopy() {
            return new getBean_args(this);
        }

        @Override
        public void clear() {
            setAnArgIsSet(false);
            this.anArg = 0;
            this.anOther = null;
        }

        public int getAnArg() {
            return this.anArg;
        }

        public getBean_args setAnArg(int anArg) {
            this.anArg = anArg;
            setAnArgIsSet(true);
            return this;
        }

        public void unsetAnArg() {
            __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ANARG_ISSET_ID);
        }

        /** Returns true if field anArg is set (has been assigned a value) and false otherwise */
        public boolean isSetAnArg() {
            return EncodingUtils.testBit(__isset_bitfield, __ANARG_ISSET_ID);
        }

        public void setAnArgIsSet(boolean value) {
            __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ANARG_ISSET_ID, value);
        }

        public String getAnOther() {
            return this.anOther;
        }

        public getBean_args setAnOther(String anOther) {
            this.anOther = anOther;
            return this;
        }

        public void unsetAnOther() {
            this.anOther = null;
        }

        /** Returns true if field anOther is set (has been assigned a value) and false otherwise */
        public boolean isSetAnOther() {
            return this.anOther != null;
        }

        public void setAnOtherIsSet(boolean value) {
            if (!value) {
                this.anOther = null;
            }
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
                case AN_ARG:
                    if (value == null) {
                        unsetAnArg();
                    } else {
                        setAnArg((Integer) value);
                    }
                    break;

                case AN_OTHER:
                    if (value == null) {
                        unsetAnOther();
                    } else {
                        setAnOther((String) value);
                    }
                    break;

            }
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
                case AN_ARG:
                    return Integer.valueOf(getAnArg());

                case AN_OTHER:
                    return getAnOther();

            }
            throw new IllegalStateException();
        }

        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        public boolean isSet(_Fields field) {
            if (field == null) {
                throw new IllegalArgumentException();
            }

            switch (field) {
                case AN_ARG:
                    return isSetAnArg();
                case AN_OTHER:
                    return isSetAnOther();
            }
            throw new IllegalStateException();
        }

        @Override
        public boolean equals(Object that) {
            if (that == null)
                return false;
            if (that instanceof getBean_args)
                return this.equals((getBean_args) that);
            return false;
        }

        public boolean equals(getBean_args that) {
            if (that == null)
                return false;

            boolean this_present_anArg = true;
            boolean that_present_anArg = true;
            if (this_present_anArg || that_present_anArg) {
                if (!(this_present_anArg && that_present_anArg))
                    return false;
                if (this.anArg != that.anArg)
                    return false;
            }

            boolean this_present_anOther = true && this.isSetAnOther();
            boolean that_present_anOther = true && that.isSetAnOther();
            if (this_present_anOther || that_present_anOther) {
                if (!(this_present_anOther && that_present_anOther))
                    return false;
                if (!this.anOther.equals(that.anOther))
                    return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        public int compareTo(getBean_args other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;
            getBean_args typedOther = (getBean_args) other;

            lastComparison = Boolean.valueOf(isSetAnArg()).compareTo(typedOther.isSetAnArg());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetAnArg()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.anArg, typedOther.anArg);
                if (lastComparison != 0) {
                    return lastComparison;
                }
            }
            lastComparison = Boolean.valueOf(isSetAnOther()).compareTo(typedOther.isSetAnOther());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetAnOther()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.anOther, typedOther.anOther);
                if (lastComparison != 0) {
                    return lastComparison;
                }
            }
            return 0;
        }

        public _Fields fieldForId(int fieldId) {
            return _Fields.findByThriftId(fieldId);
        }

        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("getBean_args(");
            boolean first = true;

            sb.append("anArg:");
            sb.append(this.anArg);
            first = false;
            if (!first) sb.append(", ");
            sb.append("anOther:");
            if (this.anOther == null) {
                sb.append("null");
            } else {
                sb.append(this.anOther);
            }
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws org.apache.thrift.TException {
            // check for required fields
            // check for sub-struct validity
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            try {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            try {
                // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
                __isset_bitfield = 0;
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private static class getBean_argsStandardSchemeFactory implements SchemeFactory {
            public getBean_argsStandardScheme getScheme() {
                return new getBean_argsStandardScheme();
            }
        }

        private static class getBean_argsStandardScheme extends StandardScheme<getBean_args> {

            public void read(org.apache.thrift.protocol.TProtocol iprot, getBean_args struct) throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
                iprot.readStructBegin();
                while (true) {
                    schemeField = iprot.readFieldBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        break;
                    }
                    switch (schemeField.id) {
                        case 1: // AN_ARG
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                                struct.anArg = iprot.readI32();
                                struct.setAnArgIsSet(true);
                            } else {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            }
                            break;
                        case 2: // AN_OTHER
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                                struct.anOther = iprot.readString();
                                struct.setAnOtherIsSet(true);
                            } else {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            }
                            break;
                        default:
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    iprot.readFieldEnd();
                }
                iprot.readStructEnd();

                // check for required fields of primitive type, which can't be checked in the validate method
                struct.validate();
            }

            public void write(org.apache.thrift.protocol.TProtocol oprot, getBean_args struct) throws org.apache.thrift.TException {
                struct.validate();

                oprot.writeStructBegin(STRUCT_DESC);
                oprot.writeFieldBegin(AN_ARG_FIELD_DESC);
                oprot.writeI32(struct.anArg);
                oprot.writeFieldEnd();
                if (struct.anOther != null) {
                    oprot.writeFieldBegin(AN_OTHER_FIELD_DESC);
                    oprot.writeString(struct.anOther);
                    oprot.writeFieldEnd();
                }
                oprot.writeFieldStop();
                oprot.writeStructEnd();
            }

        }

        private static class getBean_argsTupleSchemeFactory implements SchemeFactory {
            public getBean_argsTupleScheme getScheme() {
                return new getBean_argsTupleScheme();
            }
        }

        private static class getBean_argsTupleScheme extends TupleScheme<getBean_args> {

            @Override
            public void write(org.apache.thrift.protocol.TProtocol prot, getBean_args struct) throws org.apache.thrift.TException {
                TTupleProtocol oprot = (TTupleProtocol) prot;
                BitSet optionals = new BitSet();
                if (struct.isSetAnArg()) {
                    optionals.set(0);
                }
                if (struct.isSetAnOther()) {
                    optionals.set(1);
                }
                oprot.writeBitSet(optionals, 2);
                if (struct.isSetAnArg()) {
                    oprot.writeI32(struct.anArg);
                }
                if (struct.isSetAnOther()) {
                    oprot.writeString(struct.anOther);
                }
            }

            @Override
            public void read(org.apache.thrift.protocol.TProtocol prot, getBean_args struct) throws org.apache.thrift.TException {
                TTupleProtocol iprot = (TTupleProtocol) prot;
                BitSet incoming = iprot.readBitSet(2);
                if (incoming.get(0)) {
                    struct.anArg = iprot.readI32();
                    struct.setAnArgIsSet(true);
                }
                if (incoming.get(1)) {
                    struct.anOther = iprot.readString();
                    struct.setAnOtherIsSet(true);
                }
            }
        }

    }

    public static class getBean_result implements org.apache.thrift.TBase<getBean_result, getBean_result._Fields>, java.io.Serializable, Cloneable {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getBean_result");

        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short) 0);

        private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();

        static {
            schemes.put(StandardScheme.class, new getBean_resultStandardSchemeFactory());
            schemes.put(TupleScheme.class, new getBean_resultTupleSchemeFactory());
        }

        public BeanExample success; // required

        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            SUCCESS((short) 0, "success");

            private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

            static {
                for (_Fields field : EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, or null if its not found.
             */
            public static _Fields findByThriftId(int fieldId) {
                switch (fieldId) {
                    case 0: // SUCCESS
                        return SUCCESS;
                    default:
                        return null;
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, throwing an exception
             * if it is not found.
             */
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                _Fields fields = findByThriftId(fieldId);
                if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return fields;
            }

            /**
             * Find the _Fields constant that matches name, or null if its not found.
             */
            public static _Fields findByName(String name) {
                return byName.get(name);
            }

            private final short _thriftId;
            private final String _fieldName;

            _Fields(short thriftId, String fieldName) {
                _thriftId = thriftId;
                _fieldName = fieldName;
            }

            public short getThriftFieldId() {
                return _thriftId;
            }

            public String getFieldName() {
                return _fieldName;
            }
        }

        // isset id assignments
        public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

        static {
            Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BeanExample.class)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getBean_result.class, metaDataMap);
        }

        public getBean_result() {
        }

        public getBean_result(
                BeanExample success) {
            this();
            this.success = success;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public getBean_result(getBean_result other) {
            if (other.isSetSuccess()) {
                this.success = new BeanExample(other.success);
            }
        }

        public getBean_result deepCopy() {
            return new getBean_result(this);
        }

        @Override
        public void clear() {
            this.success = null;
        }

        public BeanExample getSuccess() {
            return this.success;
        }

        public getBean_result setSuccess(BeanExample success) {
            this.success = success;
            return this;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        /** Returns true if field success is set (has been assigned a value) and false otherwise */
        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean value) {
            if (!value) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
                case SUCCESS:
                    if (value == null) {
                        unsetSuccess();
                    } else {
                        setSuccess((BeanExample) value);
                    }
                    break;

            }
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
                case SUCCESS:
                    return getSuccess();

            }
            throw new IllegalStateException();
        }

        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        public boolean isSet(_Fields field) {
            if (field == null) {
                throw new IllegalArgumentException();
            }

            switch (field) {
                case SUCCESS:
                    return isSetSuccess();
            }
            throw new IllegalStateException();
        }

        @Override
        public boolean equals(Object that) {
            if (that == null)
                return false;
            if (that instanceof getBean_result)
                return this.equals((getBean_result) that);
            return false;
        }

        public boolean equals(getBean_result that) {
            if (that == null)
                return false;

            boolean this_present_success = true && this.isSetSuccess();
            boolean that_present_success = true && that.isSetSuccess();
            if (this_present_success || that_present_success) {
                if (!(this_present_success && that_present_success))
                    return false;
                if (!this.success.equals(that.success))
                    return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        public int compareTo(getBean_result other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;
            getBean_result typedOther = (getBean_result) other;

            lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetSuccess()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
                if (lastComparison != 0) {
                    return lastComparison;
                }
            }
            return 0;
        }

        public _Fields fieldForId(int fieldId) {
            return _Fields.findByThriftId(fieldId);
        }

        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("getBean_result(");
            boolean first = true;

            sb.append("success:");
            if (this.success == null) {
                sb.append("null");
            } else {
                sb.append(this.success);
            }
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws org.apache.thrift.TException {
            // check for required fields
            // check for sub-struct validity
            if (success != null) {
                success.validate();
            }
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            try {
                write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            try {
                read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private static class getBean_resultStandardSchemeFactory implements SchemeFactory {
            public getBean_resultStandardScheme getScheme() {
                return new getBean_resultStandardScheme();
            }
        }

        private static class getBean_resultStandardScheme extends StandardScheme<getBean_result> {

            public void read(org.apache.thrift.protocol.TProtocol iprot, getBean_result struct) throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
                iprot.readStructBegin();
                while (true) {
                    schemeField = iprot.readFieldBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        break;
                    }
                    switch (schemeField.id) {
                        case 0: // SUCCESS
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                                struct.success = new BeanExample();
                                struct.success.read(iprot);
                                struct.setSuccessIsSet(true);
                            } else {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            }
                            break;
                        default:
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    iprot.readFieldEnd();
                }
                iprot.readStructEnd();

                // check for required fields of primitive type, which can't be checked in the validate method
                struct.validate();
            }

            public void write(org.apache.thrift.protocol.TProtocol oprot, getBean_result struct) throws org.apache.thrift.TException {
                struct.validate();

                oprot.writeStructBegin(STRUCT_DESC);
                if (struct.success != null) {
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
                    struct.success.write(oprot);
                    oprot.writeFieldEnd();
                }
                oprot.writeFieldStop();
                oprot.writeStructEnd();
            }

        }

        private static class getBean_resultTupleSchemeFactory implements SchemeFactory {
            public getBean_resultTupleScheme getScheme() {
                return new getBean_resultTupleScheme();
            }
        }

        private static class getBean_resultTupleScheme extends TupleScheme<getBean_result> {

            @Override
            public void write(org.apache.thrift.protocol.TProtocol prot, getBean_result struct) throws org.apache.thrift.TException {
                TTupleProtocol oprot = (TTupleProtocol) prot;
                BitSet optionals = new BitSet();
                if (struct.isSetSuccess()) {
                    optionals.set(0);
                }
                oprot.writeBitSet(optionals, 1);
                if (struct.isSetSuccess()) {
                    struct.success.write(oprot);
                }
            }

            @Override
            public void read(org.apache.thrift.protocol.TProtocol prot, getBean_result struct) throws org.apache.thrift.TException {
                TTupleProtocol iprot = (TTupleProtocol) prot;
                BitSet incoming = iprot.readBitSet(1);
                if (incoming.get(0)) {
                    struct.success = new BeanExample();
                    struct.success.read(iprot);
                    struct.setSuccessIsSet(true);
                }
            }
        }

    }

}
