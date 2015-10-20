/**
 * Elevator OOD: Multi-Elevator OOD
 * 6 elevators and a controller.
 * Each floor has two request buttons for each direction.
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
		reqFloor = _reqFloor;
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
* The only difference between One-Elevator OOD is we cannot set the class as a singleton
*/
public class Elevator {
	//The maximun weight (1.5 ton) that the elevator allows
	private static final int CAPACITY = 1500;
	private ElevatorStatus moveStatus;
	private int currentFloor;
	private boolean isDoorCloosed;
	//Use id to identify each elevator
	private int id;

	public Elevator(int _id) {
		id = _id;
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
* Because there is only one controller. We create it as a Singleton.
* Also to make the controller runs in different thread, we implement Runnable interface.
* @see java.lang.Runnable
*/
public class Controller implements Runnable{
	//Use an array of List to store the requests, Other data structure is also possible
	private ArrayList<List<Request>> ques = new ArrayList<List<Request>>();
	//Total 6 elevators
	private Elevator[] eles = new Elevator[6];
	//The instance make Controller works as a singleton
	private static instance = new Controller();

	private Controller() {
		for (int i = 0; i < 6; i++) {
			ques.add(new ArrayList<Request>());
			eles[i] = new Elevator(i);
		}
	}
	public Controller getInstance() {
		return instance;
	}
	public void addRequest(Request req) {
		//Find the smallest distance of the last Request in each que
		//Then insert req into the que
	}
	public Request getNextRequest(int index) {
		if (ques.get(index).size() <= 0) {
			return null;
		}
		return que.poll();
	}
	public void process() {
		for (int i = 0 ; i < 6; i++) {
			Request req = getNextRequest(i);
			if (req != null) {
				eles[i].moveFollowRequest(req);
			}
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