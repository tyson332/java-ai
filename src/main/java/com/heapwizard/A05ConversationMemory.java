package com.heapwizard;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

interface ChatAssistant {
    @SystemMessage("AI Chat bot")
    String chat(@UserMessage String chatInput);
}

public class A05ConversationMemory {
	public static void main(String[] args) {
		ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);
		
		ChatLanguageModel model = GoogleAiGeminiChatModel
				.builder()
				.apiKey(System.getenv("GEMINI_API_KEY"))
				.modelName("gemini-3.8-flash")
				.build();
		
		
		ChatAssistant assistant = AiServices.builder(ChatAssistant.class)
		        .chatLanguageModel(model)
		        .chatMemory(memory)
		        .build();
		
		String output = assistant.chat("My favorite language is Java.");
		System.out.println("Output 1 : "+output);
		String output2 = assistant.chat("What did I say my favorite language was?"); // Model remembers "Java"
		System.out.println("Output 2 : "+output2);
	}
}
