package com.app.netzmeryorangga.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.netzmeryorangga.controller.UserController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerGetCustomePerson {

	@Autowired
	private MockMvc mvc;
	
	@Test
	void positiveTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/netzme/get/person");
		MvcResult result = mvc.perform(request).andReturn();
		
		Assertions.assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	void negativeTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/netzme/get/person");
		MvcResult result = mvc.perform(request).andReturn();
		
		Assertions.assertNull(result.getResponse().getContentAsString());
	}
	
}
