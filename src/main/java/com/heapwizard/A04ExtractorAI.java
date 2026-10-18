package com.heapwizard;

import java.util.List;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;

public class A04ExtractorAI {
	
	public record UserSummary(String name, int age, List<String> skills) {}
	
	interface ExtractorService {
	    @UserMessage("Extract user details from this bio: {{it}}")
	    UserSummary extract(String bio);
	}
	
	public static void main(String[] args) {
		
		ChatLanguageModel model = GoogleAiGeminiChatModel
				.builder()
				.apiKey(System.getenv("GEMINI_API_KEY"))
				.modelName("gemini-3.8-flash")
				.build();
		
		ExtractorService service = AiServices.create(ExtractorService.class, model);
		UserSummary summary = service.extract("Alice is a 29-year-old backend dev who knows Java, Docker, and Kafka.");
		
		System.out.println(summary);
	}
}
