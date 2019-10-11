import java.io.IOException;

public class PosAvg extends MesoInherit{
	
	/**
	 * Array list for all the stations read from the file
	 */
	private String[] totalStations;
	private String stationID;
	/**
	 * number order of the station ID in the list of stations
	 */
	private int index;
	private String[] statoinPairs = new String[4];
	
	
	/**
	 * default constructor
	 */
	public PosAvg() 
	{
		this.stationID = "nothing";
	
	}
	/**
	 * Class constructor that takes the parameter of a stationID. also creates a MesoInherit to access the list of 
	 * station ID's. also invokes the method calAverage
	 * @param stationID
	 * @throws IOException
	 */
	public PosAvg(String stationID) throws IOException 
	{
		MesoInherit m = new MesoInherit(new MesoStation (super.getStationID()));
		this.totalStations = m.getTotalStations();
		this.stationID = stationID;
		this.index = indexOfStation();
		
		calAverage();
	}
	/**
	 * calculating the index variable of the stationID
	 * @return index of the station
	 */
	public int indexOfStation() {
		
		int count = 0;
		
		for (count = 0; count < this.totalStations.length; ++count)
		{
			
			if (this.stationID.equals(this.totalStations[count])) {
				break;
			}
		}
		return count + 1;
	}
	/**
	 * inherited method, no need to return the int array here, because the method is only changing the 
	 * private arrayList stationPairs to find the station pairs that are the average of the index
	 * @return null
	 */
	public int[] calAverage()  {
		
		this.statoinPairs[0] = this.totalStations[this.index - 2];
		this.statoinPairs[1] = this.totalStations[this.index ];
		this.statoinPairs[2] = this.totalStations[this.index - 3];
		this.statoinPairs[3] = this.totalStations[this.index + 1];
		
		return null;
		
	}
	@Override
	public String toString() {
		
		return "This index is average of " + this.statoinPairs[0] + " and " + this.statoinPairs[1]
		+ ", " + this.statoinPairs[2] + " and " + this.statoinPairs[3] + ", and so on.";
		
	}


	
}
