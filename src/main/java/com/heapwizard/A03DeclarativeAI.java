package com.heapwizard;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

interface Assistant {
    @SystemMessage("You are a polite technical recruiter.")
    String assessCandidate(@UserMessage String resumeSummary);
}

public class A03DeclarativeAI {
    public static void main(String[] args) {
    	
		ChatLanguageModel model = GoogleAiGeminiChatModel
				.builder()
				.apiKey(System.getenv("GEMINI_API_KEY"))
				.modelName("gemini-3.8-flash")
				.build();
    	
    	
        Assistant assistant = AiServices.create(Assistant.class, model);
        
        String verdict = assistant.assessCandidate("5 years Java, Spring Boot, Kafka, Docker.");
        System.out.println(verdict);
    }
}
