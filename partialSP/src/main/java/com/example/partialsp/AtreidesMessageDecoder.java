package com.example.partialsp;

public class AtreidesMessageDecoder implements MessageVisitor {
    @Override
    public void visit(Message message) {
        String decodedMessage = decodeMessage(message.getMessage());
        message.setMessage(decodedMessage);

    }
    private String decodeMessage(String message) {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            c = (char) (c + 3);
            decoded.append(c);
        }
        return decoded.toString();
    }
}
