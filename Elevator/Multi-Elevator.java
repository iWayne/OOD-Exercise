/**
* Multi-Elevator System
* 6 elevators and a controller
* Request Button contains floor number and direction
**/


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

public class Elevator {
	private static final int CAPACITY = 1000;
	private ElevatorStatus moveStatus;
	private int currentFloor;
	private boolean isDoorCloosed;
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

public class Controller implements Runnable{
	private ArrayList<List<Request>> ques = new ArrayList<List<Request>>();
	private Elevator[] eles = new Elevator[6];
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