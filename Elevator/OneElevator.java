/**
 * Elevator OOD: One elevator
 * @author  Wayne Shan
 * @version 1.0, Oct. 2015
 * Note that I miss the range of the floors
 */


/**
*  Request Class
*  Requests will be created by users and sent to the elevator controller
*/
public class Request {
	private int reqFloor;
	private boolean goUp;

	public Request(int _reqFloor, boolean _goUp) {

		//The user's current floor
		reqFloor = _reqFloor;
		//The direction user want to go
		goUp = _goUp;
	}
	public int getReqFloor() {
		return toFloor;
	}
	public boolean goUp() {
		return goUp
	}
}

/**
* ElevatorStatus Enumeration
* List the possible status of an Elevator
* @see java.lang.Enum above JDK 1.5
*/
public enum ElevatorStatus {
	Idel(0), MovingUp(1),MovingDown(-1);
	
	private int value;

	private ElevatorStatus(int val) {
		value = val;
	}
	public int getValue() {
		return value;
	}
}

/**
* Elevator Class
* Because there is only one elevator. We create it as Singleton.<br>
* It will move follow the request from Controller Class
*/
public class Elevator {
	//The maximun weight that the elevator allows
	private static final int CAPACITY;
	//The instance make Elevator works as a singleton
	private static instance = new Elevator();
	private ElevatorStatus moveStatus;
	private int currentFloor;
	private boolean isDoorCloosed;

	public static Elevator getInstance() {
		return instance;
	}
	public void moveUp();
	public void moveDown();
	public boolean checkCapacity();
	public boolean closeDoor();
	public boolean openDoor();
	public ElevatorStatus getCurrentStatus();
	public int getCurrentFloor();
	public boolean getIsDoorCloosed();
	public void moveFollowRequest(Request req);
}

/**
* Controller Class
* It is used to sort the requests and control the elevator<br>
* Because there is only one controller. We create it as Singleton.
* Also to make the controller runs in different thread, we implement Runnable interface.
* @see java.lang.Runnable
*/
public class Controller implements Runnable{
	//Use que to store the requests, Other data structure is also possible
	List<Request> que = new List<Request>();

	//The instance make Controller works as a singleton
	private static instance = new Controller();

	public Controller getInstance() {
		return instance;
	}
	public void addRequest(Request req) {
		if (!que.contains(req)) {
			que.add(req);
		}
	}
	public Request getNextRequest() {
		if (que.size() <= 0) {
			return null;
		}
		return que.poll();
	}
	public void process() {
		Request req = getNextRequest();
		if (req != null) {
			Elevator.getInstance().moveFollowRequest(req);
		}
	}
	public void run() {
		while(True) {
			process();
		}
	}
}

/**
* User Class
* The definition of a user<br>
* Users will form the requests and send the requests to the Elevator Controller
*/
public class User {
	private String userName;
	private int currentFloor;
	private boolean goUp;

	public User(int _currentFloor, boolean _goUp) {
		currentFloor = _currentFloor;
		goUp = _goUp;
	}

	public void sentRequest() {
		Request req = new Request(currentFloor, goUp);
		Controller.getInstance().addRequest(req);
	}
}