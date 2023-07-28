package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class restAssured {
	private static final String API_KEY = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
   // private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

	public static void main(String[] args) throws IOException {
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
		int statusCode = response.statusCode();
		String statusLine = response.statusLine();
		System.out.println(statusCode);
		System.out.println(statusLine);
		
		

		    
		    
		        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		        int option;
		        
		        do {
		            showMenu();
		            option = Integer.parseInt(reader.readLine());

		            switch (option) {
		                case 1:
		                    getWeatherData("temperature", reader);
		                    break;
		                case 2:
		                    getWeatherData("wind_speed", reader);
		                    break;
		                case 3:
		                    getWeatherData("pressure", reader);
		                    break;
		                case 0:
		                    System.out.println("Exiting the program.");
		                    break;
		                default:
		                    System.out.println("Invalid option. Please try again.");
		            }
		        } while (option != 0);
		    }

		    private static void showMenu() {
		        System.out.println("\nOptions:");
		        System.out.println("1. Get weather");
		        System.out.println("2. Get Wind Speed");
		        System.out.println("3. Get Pressure");
		        System.out.println("0. Exit");
		        System.out.print("Enter your choice: ");
		    }

		    private static void getWeatherData(String dataType, BufferedReader reader) throws IOException {
		        System.out.print("Enter the date: ");
		        String date = reader.readLine();

		        String cityName = "London"; // Replace 'CityName' with your desired city
		        String urlString = API_KEY + "?q=" + cityName + "&appid=" + API_KEY;

		        URL url = new URL(urlString);
		        URLConnection conn = url.openConnection();

		        try (BufferedReader apiReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
		            StringBuilder response = new StringBuilder();
		            String line;

		            while ((line = apiReader.readLine()) != null) {
		                response.append(line);
		            }

		            String responseData = response.toString();

		            switch (dataType) {
		                case "temperature":
		                    double temperature = parseTemperature(responseData);
		                    System.out.printf("The temperature on %s is %.2f °C%n", date, temperature);
		                    break;
		                case "wind_speed":
		                    double windSpeed = parseWindSpeed(responseData);
		                    System.out.printf("The wind speed on %s is %.2f m/s%n", date, windSpeed);
		                    break;
		                case "pressure":
		                    double pressure = parsePressure(responseData);
		                    System.out.printf("The pressure on %s is %.2f hPa%n", date, pressure);
		                    break;
		            }
		        }
		    }

		    private static double parseTemperature(String data) {
		        // Parse the temperature from the JSON response data
		        // You can use JSON parsing libraries like Jackson or Gson for a more robust solution
		        return 25.0; // Replace this with the actual temperature value
		    }

		    private static double parseWindSpeed(String data) {
		        // Parse the wind speed from the JSON response data
		        // You can use JSON parsing libraries like Jackson or Gson for a more robust solution
		        return 5.5; // Replace this with the actual wind speed value
		    }

		    private static double parsePressure(String data) {
		        // Parse the pressure from the JSON response data
		        // You can use JSON parsing libraries like Jackson or Gson for a more robust solution
		        return 1013.25; // Replace this with the actual pressure value
		    }
		
	

}
