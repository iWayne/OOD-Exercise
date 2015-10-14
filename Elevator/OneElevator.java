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
	private static final int CAPACITY;
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

public class Controller implements Runnable{
	List<Request> que = new List<Request>();
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