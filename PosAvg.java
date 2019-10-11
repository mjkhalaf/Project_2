
import java.io.IOException;

public class PosAvg extends MesoInherit{
	/**
	 * Array list for all the stations read from the file
	 */
	private String[] totalStations;
	private String stationID;
	private int index;
	private String[] statoinPairs = new String[4];
	
	
	
	public PosAvg() 
	{
		stationID = "";
	}
	
	public PosAvg(String stationID) throws IOException 
	{
		MesoInherit m = new MesoInherit(new MesoStation (super.getStationID()));
		this.totalStations = m.getTotalStations();
		
		this.stationID = stationID;
		
		this.index = indexOfStation();
		
		calAverage();
	}
	
	public int indexOfStation() {
		int count = 0;
		for (count =0; count < this.totalStations.length; ++count)
		{
			
			if (this.stationID.equals(this.totalStations[count])) {
				break;
			}
		}
		return count + 1;
	}
	
	public int[] calAverage()  {
		
		this.statoinPairs[0] = this.totalStations[this.index - 2];
		this.statoinPairs[1] = this.totalStations[this.index ];
		this.statoinPairs[2] = this.totalStations[this.index - 3];
		this.statoinPairs[3] = this.totalStations[this.index + 1];
		
		return null;
		
	}
	@Override
	public String toString() {
		String result = "This index is average of " + this.statoinPairs[0] + " and " + this.statoinPairs[1]
		+ ", " + this.statoinPairs[2] + " and " + this.statoinPairs[3] + ", and so on.";
		return result;
	}


	
}
