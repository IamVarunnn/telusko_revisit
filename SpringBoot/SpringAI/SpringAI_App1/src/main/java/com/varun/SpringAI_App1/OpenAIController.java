package com.varun.SpringAI_App1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.session.SessionService;
import org.springframework.ai.session.advisor.SessionAdvisors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {

    private final ChatClient chatClient;

    // Option A: Attach SessionAdvisors directly using the auto-configured SessionService
    public OpenAIController(ChatClient.Builder chatClientBuilder, SessionService sessionService) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(SessionAdvisors.builder(sessionService).build())
                .build();
    }

    // Option B: If you already defined a @Bean ChatClient in a @Configuration class, use this instead:
    // public OpenAIController(ChatClient chatClient) {
    //     this.chatClient = chatClient;
    // }

    @GetMapping("/api/{message}")
    public ResponseEntity<String> getAnswer(
            @RequestParam(defaultValue = "default-session") String sessionId,
            @PathVariable String message) {

        ChatResponse chatResponse = chatClient
                .prompt(message)
                .advisors(SessionAdvisors.session(sessionId))
                .call()
                .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult()
                .getOutput()
                .getText();

        return ResponseEntity.ok(response);
    }
}
