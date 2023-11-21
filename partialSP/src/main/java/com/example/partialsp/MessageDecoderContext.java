package com.example.partialsp;

public class MessageDecoderContext {
    private MessageVisitor decoder;

    public void setDecoder(MessageVisitor decoder) {
        this.decoder = decoder;
    }

    public void decodeMessage(Message message) {
        decoder.visit(message);

    }
}
