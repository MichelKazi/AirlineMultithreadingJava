package Project3;

public class Airline {

	private String flightID;
	private long entered;
	private long exited;
	
	public Airline(String ID, long enter) {
		flightID = ID;
		setEntered(enter);
	}

	public String getID() {
		return this.flightID;
	}
	
	public long getEntered() {
		return entered;
	}

	public void setEntered(long entered) {
		this.entered = entered;
	}

	public long getExited() {
		return exited;
	}

	public void setExited(long exited) {
		this.exited = exited;
	}
	
	public String toString() {
		return flightID + " | Time entered: " + entered +  " | Time exited: " + exited;
	}
}
