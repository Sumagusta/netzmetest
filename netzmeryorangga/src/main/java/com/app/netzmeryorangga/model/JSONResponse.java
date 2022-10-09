package com.app.netzmeryorangga.model;

import java.util.List;

import lombok.Data;

@Data
public class JSONResponse {
	private List<RandomUser> results;
	private Info info;
}
