/**
 * Chess OOD
 * Nothing special
 * @author  Wayne Shan
 * @version 1.0, Oct. 2015
 */

/**
* Request Class
* Used to transmit movings between player and game controller
*/
public class Request {
	public int playerID;
	public int oriX;
	public int oriY;
	public int tarX;
	public int tarY;

	public Request(int _oriX, int _oriY, int _tarX, int _tarY){...};
}

/**
* Piece Class
* The abstract class for piece
*/
public abstract class Piece {
	private Color color;
	private String name;
	private int pieceID;
	public Piece(String _color, Color _name){...};
}

/**
* Color Class
* Identify the color of both pieces and spots
*/
public enum Color {
	Black(0), White(1);

	private int value;
	private Color(int val) {}
	public int getValue() {}
}

/**
* Special Piece Class
* The more detail about different pieces, like images
*/
public class King/Queen/Bishop/Knight/Rook/Pawn extends Piece{
	//...
}

/**
* Spot Class
* The unit block in the Game Board
*/
public class Spot {
	//The position of the Spot in the board
	private int x;
	private int y;
	//The spot can also have a color, but the color will not affect the game
	private Color color;
	//There maybe a piece on the spot. If no piece, the value will be Null
	private Piece piece;

	public Spot(int _x, int _y, Piece _piece) {}
	public void setPiece(Piece _piece) {}
	public void removePiece(Piece _piece) {}
}

/**
* Board Class
* The game board, which is constructed by spots
*/
public class Board {
	private Spot spots[8][8];
	//Remember the pieces that have been captured
	private List<Piece> removedPiece;
	
	//Initializtion the game borad, setting locations for pieces
	public Board() {}
	//Check if the moving of a specific piece is valid, then call move
	public boolean movePieceIfValid(int _oriX, int _oriY, int _tarX, int _tarY, Color _color) {
		//Invalid = Diff color, no piece on spot, invalid moving, etc
		boolean invalid;
		if (invalid) { 
			return false;
		}
		movePiece(_x, _y, _tarX, _tarY);
		return true;
	}
	//Move a piece if the moving is valid
	public void movePiece(int _oriX, int _oriY, int _tarX, int _tarY) {
		//will check capture and remove piece if necessary
	}
	//Capture a piece
	public void removePiece(int _x, int _y) {}
	//Return pieces color
}

/**
* Player Class
* Identify the player
*/
public class Player {
	private int playerID;
	private String name;
	private int numWin;
	private int numDraw;
	private int numLoss;

	public Player(...){...};
}

/**
* GameController Class
* It is used to connect all the classes, and control the process of the game
* There is only one game controller, so it could be a singleton
* @see java.lang.Runnable
*/
public class GameController implements Runnable {
	private static instance = new Game();
	//Initilaze the board
	private Board board = new Board();
	//Remember the color each player picked
	private HashMap<Player, Color> playerColor = new HashMap<Player, Color>();
	//Two Players
	private Player[] players = new Player[2];
	//Remeber the current player
	private Player currentPlayer = null;

	private Game(){}
	public static Game getInstance() {}
	public void selectColor() {}
	public boolean hasWon() {}
	public void run() {
		boolean turn = true;
		while (!hasWon()) {
			process();
			if (currentPlayer.equals(players[0])) {
				currentPlayer = players[1];
			} else {
				currentPlayer = players[0];
			}
		}
	}
	//In process method, Controller will receive input about moving until the end of the game
	public boolean process() {
		boolean successfullyMove = false;
		while (successfullyMove) {
			oriX, oriY, tarX, tarY = input() //Invalid syntax in JAVA
			successfullyMove = board.getInstance().movePieceIfValid( oriX, oriY, tarX, tarY, playerColor.get(currentPlayer);
		}
		
	}
}