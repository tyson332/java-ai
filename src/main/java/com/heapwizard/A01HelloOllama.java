package com.heapwizard;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class A01HelloOllama {
	public static void main(String[] args) {
		System.out.println("[Start] Main class");
		ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2:1b")  //llama3.2:1b and qwen2.5-coder
                .build();
		System.out.println("Going to call model");
        String greeting = model.generate("Hello! Who are you?");
        System.out.println("Output" + greeting);
        System.out.println("[Completed] Main class");
	}
}
