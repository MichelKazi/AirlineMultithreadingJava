package Project3;
import java.util.concurrent.ThreadLocalRandom;

import cs212lib.Queue;
import cs212lib.QueueException;

public class Arrival extends Thread {
	private Queue <Airline> queue;
	private int time;
	private boolean running = true;
	final private long now;
	
	public Arrival (int t) {
		time = t;
		queue = new Queue<Airline>();
		now = System.currentTimeMillis();
	}
	
	public Queue<Airline> getQueue() {
		return queue;
	} 
	
	public int getTime() {
		return time;
	}
	
	
	public void run() {
		while(running) {
			//TODO use timeTillNext method
			// to simulate the landing
			int nextEvent = Simulation.timeTillNext(time);
			//TODO: Use sleep
			try {
				sleep(Simulation.timeTillNext(nextEvent)); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Arrival Queue Stopped");
			}
			//TODO: Create a new Airline
			//	use AIRLINES array from Simulation
			//	use a Random object to get a random number as index for AIRLINES
			//	between 0 and Simulation.AIRLINES.length
			int r = ThreadLocalRandom.current().nextInt(0, Simulation.AIRLINES.length-1);
			Airline a = new Airline(Simulation.AIRLINES[r], System.currentTimeMillis() - now);
			//TODO add that object to the queue
			try {
				queue.enqueue(a);
			} catch (QueueException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			//TODO print information about airline
			System.out.println("Flight " + a.getID() + " added to Arrival queue.");
			//System.out.println(queue.getSize());
			
		} 
	}
	public void stopRunning(){
		running = false;
	}
}
