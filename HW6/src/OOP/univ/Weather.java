package OOP.univ;

import java.util.Objects;

public class Weather {
	private String sky;
	private String precipitation;
	private int temperature;
	
	public Weather() {
		sky = "Clear";
		precipitation = "None";
		temperature = 20;
	}
	
	public Weather(String sky, String precipitation, int temperature) {
		this.sky = sky;
		this.precipitation = precipitation;
		this.temperature = temperature;
	}

	public String getSky() {
		return sky;
	}
	public void setSky(String sky) {
		this.sky = sky;
	}
	public String getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Weather [sky=" + sky + ", precipitation=" + precipitation + ", temperature=" + temperature + " by Celsius]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(precipitation, sky, temperature);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		return Objects.equals(precipitation, other.precipitation) && Objects.equals(sky, other.sky)
				&& temperature == other.temperature;
	}
	
	
}
