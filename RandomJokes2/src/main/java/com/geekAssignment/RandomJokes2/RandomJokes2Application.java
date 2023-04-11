package com.geekAssignment.RandomJokes2;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class RandomJokes2Application {

	public static void main(String[] args) throws Exception{

//		SpringApplication.run(RandomJokes2Application.class, args);

//		URL getUrl = new URL("https://official-joke-api.appspot.com/random_joke");

		URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		// https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true

		int responseCode = connection.getResponseCode();

		if (responseCode == 200) {


			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));// stream- running input
			StringBuilder jsonResponseData = new StringBuilder();
			String readLine = null;


			while ((readLine = in.readLine()) != null) {
				jsonResponseData.append(readLine);
			}

			in.close();
			JSONObject masterData = new JSONObject(jsonResponseData.toString());

			System.out.println("joke- " + masterData.get("value"));

//			System.out.println("joke- " + masterData.get("setup"));
//			System.out.println("Current punchline " + masterData.get("punchline"));


		} else {
			System.out.println("This is not valid URL- " + responseCode);
		}


	}

}
