public class Board {
	static final int SEA = 0;
	static final int SHIP = 1;
	static final int ROCK = 2;
	static final int PIRATE = 3;
	static final int GOAL = 5;


	private int dimRow;
	private int dimCol;

	int[][] board;
	
	public int getDim() {
		return dimCol;
		
	}
	
	Board(int n) {
		this.dimRow = n;
		this.dimCol = n;

		this.board = new int[this.dimRow][this.dimCol];

		for (int i = 0; i < this.dimRow; i++) {
			for (int j = 0; j < this.dimCol; j++) {
				this.board[i][j] = Board.SEA;
			}
		}
	}
	
	public void toConsole() {
		System.out.print("\n");
		for (int i = 0; i < this.dimRow; i++) {
			for (int j = 0; j < this.dimCol; j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.print("\n");
	}

	public void resetBoard() {
		for (int i = 0; i < this.dimRow; i++) {
			for (int j = 0; j < this.dimCol; j++) {
				this.board[i][j] = Board.SEA;
			}
		}
	}
	void setShip(int row, int col) {
		this.board[row][col] = Board.SHIP;
	}

	void setPirate(int row, int col) {
		this.board[row][col] = Board.PIRATE;
	}

	void setSea(int row, int col) {
		this.board[row][col] = Board.SEA;
	}
	
	void setGoal(int row, int col) {
		this.board[row][col] = Board.GOAL;
	}
	
	void setRock(int row, int col) {
		this.board[row][col] = Board.ROCK;
	}

}