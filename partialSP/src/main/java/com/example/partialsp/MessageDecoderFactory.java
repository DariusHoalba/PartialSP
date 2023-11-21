package com.example.partialsp;

public class MessageDecoderFactory {
    public static MessageVisitor getDecoder(String house) {
        if ("atreides".equals(house)) {
            return new AtreidesMessageDecoder();
        } else if ("harkonnen".equals(house)) {
            return new HarkonnenMessageDecoder();
        }
        throw new IllegalArgumentException("Unknown house");
    }
}
