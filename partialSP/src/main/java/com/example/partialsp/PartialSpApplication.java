package com.example.partialsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//@SpringBootApplication
public class PartialSpApplication {
        public static void main(String[] args) {
            //SpringApplication.run(PartialSpApplication.class, args);
            try {
                String filePath = "src/messages.json";
                MessageProcessor processor = new MessageProcessor();
                processor.processMessages(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("A apărut o eroare în timpul citirii sau procesării fișierului: " + e.getMessage());
            }
        }
}

//Factory: MessageDecoderFactory + Casa_MessageDecoder
//Visitor: MessageVisitor
//Strategy: MessageDecoderContext
