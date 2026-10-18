package com.heapwizard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class A02HelloGenAI {

	private static final Logger logger = LoggerFactory.getLogger(A02HelloGenAI.class);

	public static void main(String[] args) {
		logger.info("[Start] Main class");
		ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
				.modelName("gemini-3.8-flash").build();
		logger.info("Going to call model");
		String greeting = model.generate("Hello! Who are you?");
		logger.info("Output" + greeting);
		logger.info("[Completed] Main class");
	}
}
