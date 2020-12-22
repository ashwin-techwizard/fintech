//package com.ashwin.kafka.fintech.serializer;
//
//import com.ashwin.kafka.fintech.model.Transaction;
//import com.google.protobuf.InvalidProtocolBufferException;
//import kafka.message.ExchangeMessage.Order;
//import org.apache.kafka.common.serialization.Deserializer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class OrderDeserializer extends Adapter implements Deserializer<Transaction> {
//    private static final Logger LOG = LoggerFactory.getLogger(OrderDeserializer.class);
//
//    @Override
//    public Transaction deserialize(final String topic, byte[] data) {
//        try {
//            return Order.parseFrom(data);
//        } catch (final InvalidProtocolBufferException e) {
//            LOG.error("Received unparseable message", e);
//            throw new RuntimeException("Received unparseable message " + e.getMessage(), e);
//        }
//    }
//
//}