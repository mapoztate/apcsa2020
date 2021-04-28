import core.data.*;
import java.util.*; 

public class Welcome03_List {
	public static void main(String[] args) {
  String id3 = "index";
		DataSource ds = DataSource.connect("/sharedfiles/weather.gov/xml/current_obs/" + id3 + ".xml").load();
		ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", "station/station_id",
				"station/state", "station/latitude", "station/longitude");
		System.out.println("Total stations: " + allstns.size());

		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a state abbreviation: ");
		String state = input.next();
		System.out.println("Stations in " + state);
		int count = 0;
		for (WeatherStation weather : allstns) {
			if (weather.isLocatedInState(state)) {
				count++;
				System.out.println("  " + weather.getId() + ": " + weather.getName());
			}
		}
		System.out.println("There are " + count + " stations in " + state + ".");
		WeatherStation southern = allstns.get(0);
		for (WeatherStation weather : allstns) {
			if (weather.getLat() < southern.getLat()) {
				southern = weather;
			}
		}
		System.out.println(southern.getName() + " Latitude: " + southern.getLat());
	}
}
