package Project3;
/**
* Class with static methods - use these constants and call these methods as necessary
* Simulation.TAKEOFF_TIME and Simulation.LANDING_TIME can be used in Program3
* Simulation.timeTillNext method can be called from the Arrival and Departure run methods
*/
	import java.util.Random;
	public class Simulation {
		public static final int TAKEOFF_TIME = 4000;
		public static final int LANDING_TIME = 5000;
		public static String[] AIRLINES = {"AA","AI","AF","AZ","KL","BA","BW","DL","FL","BA","AC","ET","GH","LH","JM","KE","TW","UA"};
	/*
	 *  Converts milliseconds to minutes
	 * 	@param millisecs
	 * @return timeInMinutes
	 */
		public static long timeInMinutes(long millisecs){
			return millisecs / 60000;
		}
		/*
		 * Converts minutes to milliseconds
		 * @param timeInMinutes
		 * @return timeInMilisecs
		 */
		public static long timeInMilisecs(long timeInMinutes){
			return timeInMinutes * 60000;
		}
		/*
		 * Calculates time till next event
		 * @param meanEventTime in milliseconds
		 * @return timeTillNext - time before next event occurs
		 */
		public static int timeTillNext(int meanEventTime){
			Random random = new Random();
			double randomDouble = random.nextDouble();
			int timeTillNext = (int)Math.round (-meanEventTime * Math.log (1 - randomDouble));
			return timeTillNext;
		}
	}