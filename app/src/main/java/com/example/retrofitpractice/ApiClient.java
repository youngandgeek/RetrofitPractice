package com.example.retrofitpractice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //implementing get request

        public static String BASE_URL ="https://jsonplaceholder.typicode.com/";
        //retrofit instance
        private static Retrofit retrofit;
        public static Retrofit getClient(){
            if(retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        //convert the json with GsonConverter
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }

