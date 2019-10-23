package Project3;

import java.util.concurrent.ThreadLocalRandom;

import cs212lib.Queue;
import cs212lib.QueueException;

public class Departure extends Thread{
	int time;
	Queue <Airline> queue;
	private boolean running = true;
	final private long now;
	
	public Departure (int t) {
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
	
	public String toString() {
		String str = "";
		str += "Time: " + time;
		return str;
		
	}
	public void run() {
		while(running){
			//TODO Calculate the time (based on timeTillnext)
			int nextEvent = Simulation.timeTillNext(time);
			//TODO: Use sleep
			try {
				sleep(Simulation.timeTillNext(nextEvent));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Arrival Queue Stopped");
			}
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
			System.out.println("Flight " + a.getID() + " added to Departure queue.");
			
		}
	}
	public void stopRunning(){
		running = false;
	}
}
