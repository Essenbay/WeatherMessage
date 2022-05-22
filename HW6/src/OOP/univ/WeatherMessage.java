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
	 	this.message = "������ �� ������ ������: "; 
	 } 

 
	public WeatherMessage(String sky, String precipitation, int temperature) {
		weather = new Weather(sky, precipitation, temperature);
		message = "������ �� ������ ������: ";
		
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
		return message + " [����: " + weather.getSky() + 
				" ������: " + weather.getPrecipitation() + 
				" �����������: " + weather.getTemperature() + "]";
	}
	
	
 } 