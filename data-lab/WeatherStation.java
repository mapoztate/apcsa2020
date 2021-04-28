public class WeatherStation {
	private String name;
	private String id;
	private String state;
	private double lat;
	private double lng;

	
	WeatherStation(String name, String id, String state, double lat, double lng) {
		this.name = name;
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getLong() {
		return lng;
	}

	public double getLat() {
		return lat;
	}

	public boolean isLocatedInState(String st) {
		return this.state.equals(st);
	}

}
