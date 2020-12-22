//package com.ashwin.kafka.fintech.serializer;
//
//import com.ashwin.kafka.fintech.model.Transaction;
////import kafka.message.ExchangeMessage.Order;
//import org.apache.kafka.common.serialization.Serializer;
//
//
//public class OrderSerializer extends Adapter implements Serializer<Transaction> {
//    @Override
//    public byte[] serialize(final String topic, final Transaction data) {
//        return data.toByteArray();
//    }
//}