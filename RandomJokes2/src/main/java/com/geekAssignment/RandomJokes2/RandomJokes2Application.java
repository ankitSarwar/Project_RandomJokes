package com.geekAssignment.RandomJokes2;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class RandomJokes2Application {

	public static void main(String[] args) throws Exception{

//		SpringApplication.run(RandomJokes2Application.class, args);


		String url ="https://api.chucknorris.io/jokes/random";
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).build();
		var client= HttpClient.newBuilder().build();
		HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());


//		URL getUrl = new URL("https://official-joke-api.appspot.com/random_joke");

//		URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
//		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
//		connection.setRequestMethod("GET");
//		// https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true
//
//		int responseCode = connection.getResponseCode();
//
//		if (responseCode == 200) {
//
//
//			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));// stream- running input
//			StringBuilder jsonResponseData = new StringBuilder();
//			String readLine = null;
//
//
//			while ((readLine = in.readLine())!= null) {
//				jsonResponseData.append(readLine);
//			}
//
//			in.close();
//			JSONObject masterData = new JSONObject(jsonResponseData.toString());
//
//			System.out.println("joke- " + masterData.get("value"));
//
////			System.out.println("joke- " + masterData.get("setup"));
////			System.out.println("Current punchline " + masterData.get("punchline"));
//
//		} else {
//			System.out.println("This is not valid URL- " + responseCode);
//		}



	}

}
