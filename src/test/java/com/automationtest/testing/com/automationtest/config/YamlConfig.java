package com.automationtest.testing.com.automationtest.config;

import java.util.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YamlConfig {
  
    private List<String> inputLanguage = new ArrayList<String>();
    private List<String> outputLanguage = new ArrayList<String>();
    private List<String> inputText = new ArrayList<String>();
    private List<String> outputText = new ArrayList<String>();
	public List<String> getInputLanguage() {
		return inputLanguage;
	}
	public void setInputLanguage(List<String> inputLanguage) {
		this.inputLanguage = inputLanguage;
	}
	public List<String> getOutputLanguage() {
		return outputLanguage;
	}
	public void setOutputLanguage(List<String> outputLanguage) {
		this.outputLanguage = outputLanguage;
	}
	public List<String> getInputText() {
		return inputText;
	}
	public void setInputText(List<String> inputText) {
		this.inputText = inputText;
	}
	public List<String> getOutputText() {
		return outputText;
	}
	public void setOutputText(List<String> outputText) {
		this.outputText = outputText;
	}
    
 
    // standard getters and setters
 
}