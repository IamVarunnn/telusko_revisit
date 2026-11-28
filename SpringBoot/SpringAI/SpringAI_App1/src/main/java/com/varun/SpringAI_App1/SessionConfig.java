package com.varun.SpringAI_App1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.session.InMemorySessionRepository;
import org.springframework.ai.session.SessionRepository;
import org.springframework.ai.session.SessionService;
import org.springframework.ai.session.advisor.SessionAdvisors;
import org.springframework.ai.session.compaction.TurnCountTrigger;
import org.springframework.ai.session.compaction.WindowCompactionStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    public SessionRepository sessionRepository() {
        return InMemorySessionRepository.builder().build();
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, SessionService sessionService) {
        return builder
            .defaultAdvisors(
                SessionAdvisors.builder(sessionService)
                    // Optional: compact history after 20 turns, keeping the last 10
                    .compaction(
                        new TurnCountTrigger(20),
                        WindowCompactionStrategy.builder().lastTurns(10).build()
                    )
                    .build()
            )
            .build();
    }
}
