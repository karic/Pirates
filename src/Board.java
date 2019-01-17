public class Board {
	static final int SEA = 0;
	static final int SHIP = 1;
	static final int ROCK = 2;
	static final int PIRATE = 3;

	private int dimRow;
	private int dimCol;

	int[][] board;
	
	
	Board(int n) {
		this.dimRow = n;
		this.dimCol = n;

		this.board = new int[this.dimRow][this.dimCol];

		for (int i = 0; i < this.dimRow; i++) {
			for (int j = 0; j < this.dimCol; j++) {
				this.board[i][j] = this.SEA;
			}
		}
	}
	
	void toConsole() {
		for (int i = 0; i < this.dimRow; i++) {
			for (int j = 0; j < this.dimCol; j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	void setShip(int row, int col) {
		this.board[row][col] = this.SHIP;
	}

	void setPirate(int row, int col) {
		this.board[row][col] = this.PIRATE;
	}

	void setSea(int row, int col) {
		this.board[row][col] = this.SEA;
	}
	
	void setRock(int row, int col) {
		this.board[row][col] = this.ROCK;
	}

}