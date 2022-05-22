package OOP.univ; 
import java.io.Serializable; 
import java.util.Date; 
 public class WeatherMessage implements Serializable { 
 	private Weather weather;  	
 	private String message; 
 	public WeatherMessage(Weather weather, String message) {  	 	
 		this.weather = weather; 
	 	this.message = message; 
	 } 
 	
 	public WeatherMessage(Weather weather) {  	 	
 		this.weather = weather; 
	 	this.message = "Погода на данный момент: "; 
	 } 

 
	public WeatherMessage(String sky, String precipitation, int temperature) {
		weather = new Weather(sky, precipitation, temperature);
		message = "Погода на данный момент: ";
		
	}

	public Weather getWeather() { 
	 	return weather; 
	} 
 
 	public void setWeather(Weather weather) {  	 	
 		this.weather = weather; 
	} 
 
 	public String getMessage() {  	 	
 		return message; 
	} 
 
	public void setMessage(String message) { 
	 	this.message = message; 
	}

	@Override
	public String toString() {
		return message + " [Небо: " + weather.getSky() + 
				" Осадки: " + weather.getPrecipitation() + 
				" Температура: " + weather.getTemperature() + "]";
	}
	
	
 } 