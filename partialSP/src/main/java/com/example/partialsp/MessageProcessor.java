package com.example.partialsp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MessageProcessor {

    public void saveDecodedMessagesToFile(List<Message> messages, String outputFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(outputFilePath), messages);
    }
    public void processMessages(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Message> messages = objectMapper.readValue(new URL("file:" + filePath), new TypeReference<List<Message>>(){});
        MessageDecoderContext context = new MessageDecoderContext();
        for (Message message : messages) {
            //System.out.println(message.getMessage() + "      " + message.getHouse() + '\n');
            MessageVisitor decoder = MessageDecoderFactory.getDecoder(message.getHouse());
            context.setDecoder(decoder);
            context.decodeMessage(message);

            System.out.println("Date: " + message.getDate() +
                    ", House: " + message.getHouse() +
                    ", Decoded Message: " + message.getMessage());

        }
        String outputFilePath = "src/decodificat.json";
        saveDecodedMessagesToFile(messages, outputFilePath);
    }
}