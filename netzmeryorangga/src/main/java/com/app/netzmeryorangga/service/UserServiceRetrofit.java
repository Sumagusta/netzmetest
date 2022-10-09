package com.app.netzmeryorangga.service;

import com.app.netzmeryorangga.model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserServiceRetrofit {

	@GET("/api")
	Call<JSONResponse> get();
}
