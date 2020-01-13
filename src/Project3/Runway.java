package Project3;

import cs212lib.QueueException;

public class Runway extends Thread {

	Arrival arrival;
	Departure departure;
	final private long now;

	private boolean running = true;

	public Runway(Arrival a, Departure d) {
		arrival = a;
		departure = d;
		now = System.currentTimeMillis();
	}

	public void run() {
		//Queue <Airline> a = arrival.getQueue();
		//Queue <Airline> d = departure.getQueue();
		System.out.println("Arrival Queue: " + arrival.getQueue().getSize());
		while (running) {
			System.out.println(" ");
			while (!arrival.getQueue().isEmpty()) {
				long currentTime = System.currentTimeMillis() - now;
				// TODO display airline info
				try {
					System.out.println(" ");
					System.out.println("Time: " + currentTime + " ");
					System.out.println("Flight " + arrival.getQueue().front().getID() + " cleared to land");
					arrival.getQueue().front().setExited(System.currentTimeMillis() - currentTime);
					System.out.println(arrival.getQueue().dequeue());
					// TODO simulate landing
					Thread.sleep(Simulation.LANDING_TIME);
				} catch (QueueException | InterruptedException e) {
					e.getMessage();
				}

			}
			
			while (!departure.getQueue().isEmpty()) {
				//TODO get a plane from departure
				long currentTime = System.currentTimeMillis() - now;
				//TODO display info airline
				try {
					
					System.out.println(" ");
				System.out.println("Time: " + currentTime + " ");
				System.out.println("Flight " + departure.getQueue().front().getID() + " cleared for takeoff");
				departure.getQueue().front().setExited(System.currentTimeMillis() - currentTime);
				System.out.println(departure.getQueue().dequeue());
				//TODO simulate takeoff
				Thread.sleep(Simulation.TAKEOFF_TIME);
				}
				catch (QueueException | InterruptedException e) {
					e.getMessage();
				}
			}

		}
	}

	public void stopRunning() {
		running = false;
	}
}