import javax.swing.JFrame;

// frame, initialize board array
public class Chess
{
	static BoardComponent boardcomponent;  // static helps to make it a global variable for all the classes
	static final int WINDOWWIDTH = 352, WINDOWHEIGHT = 374;
	// array for each piece on board		
	// create 2D array: 'Piece[][]'
	// name array: 'position';
	// creating a new statement of array: 'new Piece[8][8]'
	static Piece[][] position = new Piece[8][8];  // static bc only one position array (only one board);
	
	public static void main(String[] args) 
	{
		new Chess();  // call 'Chess'
	}
	
	// Chess constructor
	public Chess()
	{
		// class object
		JFrame myFrame = new JFrame("Chess Board");
		myFrame.setSize(WINDOWWIDTH, WINDOWHEIGHT);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardcomponent = new BoardComponent(this);  // passing 'this' (chess) to 'boardcomponent'
		myFrame.add(boardcomponent);  // add object 'boardcomponent' to myFrame;
		BoardMouseListener boardML;
		boardML = new BoardMouseListener();
		// format: .add(component) <--- anything that implements JComponent; OR .addMouseListener(mouselistener) where 
		// MouseListener is the listener and (mouselistener) is the type component;
		boardcomponent.addMouseListener(boardML);  // adding all methods of 'MouseListener' to this window
		// paint all of these on the board
		
		// black pieces
		position[0][0] = new Rook(true); 
		position[0][1] = new Knight(true);
		position[0][2] = new Bishop(true);
		position[0][3] = new Queen(true);
		position[0][4] = new King(true);
		position[0][5] = new Bishop(true);
		position[0][6] = new Knight(true);
		position[0][7] = new Rook(true);
		
		for (int row = 1; row < 2; row++)  // black pawns 
		{
			for (int col = 0; col < 8; col++)
			{
				position[row][col] = new Pawn(true);
			}
		}
		// white pieces
		position[7][0] = new Rook(false); 
		position[7][1] = new Knight(false);
		position[7][2] = new Bishop(false);
		position[7][3] = new Queen(false);
		position[7][4] = new King(false);
		position[7][5] = new Bishop(false);
		position[7][6] = new Knight(false);
		position[7][7] = new Rook(false);
		
		for (int row = 6; row < 7; row++)  // white pawns 
		{
			for (int col = 0; col < 8; col++)
			{
				position[row][col] = new Pawn(false);
			}
		}
		
		myFrame.setVisible(true);
	}
	

}
