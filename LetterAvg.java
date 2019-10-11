import java.io.IOException;
import java.util.ArrayList;
/**
 * class extends MesoInherit to access the total stations read from the file
 * @author m7md2
 *
 */
public class LetterAvg extends MesoInherit {
	 
	//private variable decleration
	private char letAvg;
	private String[] totalStations;
	private ArrayList<String> letterStations = new ArrayList<>();
	
	/**
	 * default constructor
	 */
	public LetterAvg() {
	}
	
	public LetterAvg(char letAvg) throws IOException {
		
		MesoInherit m = new MesoInherit(new MesoStation (super.getStationID()));
		this.totalStations = m.getTotalStations();
		this.letAvg = letAvg;
		
		numberOfStationWithLetterAvg();
	}
	public int numberOfStationWithLetterAvg() {
		
		int count = 0;
		this.letterStations = new ArrayList<>();
		for (int i = 0 ; i < this.totalStations.length - 1; ++i) {
			if (this.totalStations[i].charAt(0) == letAvg) {
				count++;
				this.letterStations.add(totalStations[i]);
			}
		}
		return count;
	}
	/**
	 * a print toString method that overrides the default java method. prints the names of the stations
	 * as shown in the project description
	 * @return output string
	 */
	@Override
	public String toString() {
		String result = "\nThey are:" + "\n";
		for (int i = 0; i < this.letterStations.size(); ++i) {
			if ( i == this.letterStations.size() - 1) {
				result += this.letterStations.get(i);
			}
			else {
			result += this.letterStations.get(i) + "\n";
			}
		}
		
		return result;
	}

}
