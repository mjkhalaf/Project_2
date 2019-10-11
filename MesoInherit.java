import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MesoInherit extends MesoAbstract{
	
	
	private String stationID;
	/**
	 * list of stations being read from a file
	 */
	private String[] totalStations;
	
	/**
	 * Default constructor
	 */
	public MesoInherit() {
		
	}
	/**
	 * MesoInherit constructor. initilizes the array list as well as the station ID it also invokes the readfile 
	 * method
	 * @param station
	 * @throws IOException
	 */
	public MesoInherit(MesoStation station) throws IOException {
		
		this.stationID = station.getStID();
		this.totalStations = new String[1];
		readFile();
		
	}
	/**
	 * read the data from the Mesnet File and storing them in the provate array
	 * @throws IOException
	 */
	public void readFile() throws IOException 
	{
		
		String filename = "Mesonet.txt";
		BufferedReader stationsList = new BufferedReader(new FileReader(filename));
		String currLine = "";
		
		//reading the header
		for (int i = 0; i < 3; ++i) {
		currLine = stationsList.readLine();
		} 
		//reading first station name
		currLine = stationsList.readLine();
		
		
		int index = 0;
		String[] temp;
		//expand an array
		while (currLine != null) {
			
			 
			 temp = new String[totalStations.length + 1];
			 for (int i = 0; i < totalStations.length; ++i) {
				 temp[i] = totalStations[i];
			 }
			 totalStations = temp;
			 currLine = currLine.substring(1, 5);
			 totalStations[index] = currLine;
			 
			 currLine = stationsList.readLine();
			 ++index;
		}
		stationsList.close();
	}
	/**
	 * gets the required ASCII values and their average and stores in an array 
	 */
	public int[] calAverage() {
		
		int charType[] = {this.stationID.charAt(0), this.stationID.charAt(1)
		              , this.stationID.charAt(2), this.stationID.charAt(3)};
		int ceiling= 0;
		int floor = 0;
		int sum = 0;
		
		for (int i = 0; i < charType.length; ++i) {
			sum += charType[i];
		}
		double avg = sum / 4.0;
		floor = (int)avg;
		ceiling = floor + 1;
		int intAvg; 
		
		if (avg - floor < 0.5 ) {
			intAvg = floor;
		}
		else {
			intAvg = ceiling;
		}
		int[] output = {ceiling, floor, intAvg};
		
		return output;
	}

	/**
	 * letter average of the station id
	 */
	public char letterAverage() {
		
		int[] temp = calAverage();
		
		return (char)temp[2];
	}
	public String getStationID() {
		return stationID;
	}
	public String[] getTotalStations() {
		return totalStations;
	}
	


	
	

	

}
