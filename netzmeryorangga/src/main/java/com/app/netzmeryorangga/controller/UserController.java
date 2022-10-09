package com.app.netzmeryorangga.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.netzmeryorangga.model.JSONResponse;
import com.app.netzmeryorangga.model.RandomUser;
import com.app.netzmeryorangga.model.dto.Person;
import com.app.netzmeryorangga.service.UserServiceRetrofit;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@RestController
@Slf4j
@RequestMapping("/api/netzme")
public class UserController {

	@GetMapping("/get/users")
	public JSONResponse getUsers() throws IOException {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me")
				.addConverterFactory(JacksonConverterFactory.create()).build();

		UserServiceRetrofit service = retrofit.create(UserServiceRetrofit.class);

		JSONResponse users = service.get().execute().body();

		return users;
	}

	@GetMapping("/get/person")
	public Person getPerson() throws IOException {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me")
				.addConverterFactory(JacksonConverterFactory.create()).build();

		UserServiceRetrofit service = retrofit.create(UserServiceRetrofit.class);

		JSONResponse users = service.get().execute().body();

		// RandomUser

		// log.info("gender : ",new RandomUser().getGender());

		Person person = new Person();
		for (RandomUser item : users.getResults()) {
			person.setGender(item.getGender());
			person.setFullname(item.getName().getTitle() +" "+ item.getName().getFirst() +" "+ item.getName().getLast());
			person.setAddress(item.getLocation().getStreet().getName()+" "+item.getLocation().getCity());
			person.setPicture(item.getPicture().getLarge());
		}

		// person.setGender();

		return person;

	}
		
}
