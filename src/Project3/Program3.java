package Project3;

import javax.swing.JOptionPane;

public class Program3 {
	Arrival arrival;
	Departure departure;
	Runway runway;
	
	 
	long startTime;
	long simulationTime;

	public void startSimulation(long time) {
		// TODO: Create instance of each thread ()
		arrival = new Arrival(Simulation.LANDING_TIME);
		departure = new Departure(Simulation.TAKEOFF_TIME);
		runway = new Runway(arrival, departure);
		// TODO: Start each thread
		startTime = System.currentTimeMillis();
		simulationTime = time * 60000;
		
		arrival.start();
		departure.start();
		runway.start();
		
		// Loop - run simulation for specified time
		while (System.currentTimeMillis() < startTime + simulationTime);
		// TODO: stop the loop in each thread – call the stopRunning method
		arrival.stopRunning();
		departure.stopRunning();
		runway.stopRunning();
		// TODO: interrupt each thread – method from Thread class
		try {
			// TODO: wait for each thread to die – method from Thread class
			arrival.interrupt();
			departure.interrupt();
			runway.interrupt();
			// call the join method
			arrival.join();
			departure.join();
			runway.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * TODO: Input the length of time to run the simulation (in minutes) Create an
		 * instance of Program3 Call the startSimulation method and pass the time to it
		 * Loop while the Arrival or Departure threads are alive Stop the Runway thread
		 * from running
		 */
		String input = JOptionPane.showInputDialog("Enter the length of time in minutes: ");
		long time = Long.parseLong(input);

		// create an instance of Program 3
		Program3 p3 = new Program3();
		p3.startSimulation(time);
	}
}