package exceptions;

	/**'
	 * This is a class the represents the Empty queue excption and 
	 * will get called when a peek or enqueue is called on an empty Queue
	 * @author Matthew
	 *
	 */
public class EmptyQueueException extends Exception {
	
	/**
	 * Constructor for Empty Queue Exception
	 */
	public EmptyQueueException() {
		super("This Queue is Empty");
	}
}
