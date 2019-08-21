package com.automationtest.testing.com.automationtest.config;

import java.io.File;
import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlTesting {

	@Autowired
	private YamlConfig ymlConfig;

	public HashMap<String, ArrayList<String>> readDataFromFile() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		HashMap<String, ArrayList<String>> hm = null;
		try {
			ymlConfig = mapper.readValue(new File("TestData.yml"), YamlConfig.class);
			ArrayList<String> inputLang = (ArrayList<String>) ymlConfig.getInputLanguage();
			ArrayList<String> outputlang = (ArrayList<String>) ymlConfig.getOutputLanguage();
			ArrayList<String> inputText = (ArrayList<String>) ymlConfig.getInputText();
			ArrayList<String> outputText = (ArrayList<String>) ymlConfig.getOutputText();

			hm = new HashMap<String, ArrayList<String>>();
			hm.put("inputlanguage", inputLang);
			hm.put("outputlanguage", outputlang);
			hm.put("inputtext", inputText);
			hm.put("outputtext", outputText);
			
			return hm;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}
}
