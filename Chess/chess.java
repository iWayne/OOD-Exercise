/**
* OOD for Chess
* 2 Players
**/

public abstract class Piece {
	private Color color;
	private String name;
	public Piece(String _color, Color _name){...};
}

public enum Color {
	Black(0), White(1);

	private int value;
	private Color(int val) {}
	public int getValue() {}
}

public class King/Queen/Bishop/Knight/Rook/Pawn extends Piece{
	//...
}

public class Spot {
	private int x;
	private int y;
	private Color color;
	private Piece piece;

	public Spot(int _x, int _y, Piece _piece) {}
	public void setPiece(Piece _piece) {}
	public void removePiece(Piece _piece) {}
}

public class Board {
	private Spot spots[8][8];
	private List<Piece> removedPiece;
	
	public Board() {}
	public boolean isValidMoving(int x, int y, int tarX, int tarY) {}
	public void movePiece(int x, int y, int tarX, int tarY) {}
	public void removePiece(int x, int y) {}
}

public class Player {
	private String name;
	private int numWin;
	private int numDraw;
	private int numLoss;
}

public class Game {
	private static instance = new Game();
	private Board board = new Board();
	private HashMap<Player, Color> = new HashMap<Player, Color>();
	private Player[] players = new Player[2];

	private Game(){}
	public static Game getInstance() {}
	public void selectColor() {}
	public boolean checkWinner() {}
	public void start() {}

}