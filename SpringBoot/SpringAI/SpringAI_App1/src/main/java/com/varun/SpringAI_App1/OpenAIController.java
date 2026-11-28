package com.varun.SpringAI_App1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
public class OpenAIController {

    private ChatClient chatClient;


    // for multiple models
//    public OpenAIController(ChatModel chatModel){
//        this.chatClient = ChatClient.create(chatModel);
//    }

    // for only one ai model
    public OpenAIController(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/api/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){

        ChatResponse chatResponse = chatClient
                            .prompt(message)
                            .call()
                            .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());


        String response = chatResponse.getResult()
                .getOutput()
                .getText();



        return ResponseEntity.ok(response);
    }
}
