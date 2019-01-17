
public class Pirate {
	private int row;
	private int col;
	private boolean rowFirst;

	Pirate(){
		
	
	}
	public void approach(int n, int m) {
		if (this.rowFirst) {
			if (!this.approachRow(n)) {
				this.approachColumn(m);
			}
		}else{
		    if (!this.approachColumn(m)) {
		    	this.approachRow(n);
		    }
		}
		
	}
	
	
	private boolean approachRow(int n) {
		if (this.row - n < 0) {
			this.row++;
			return true;
		} else if (this.row - n == 0){
			return false;
		} else {
			this.row--;
			return true;
		}
		
	}
	private boolean approachColumn(int m) {
		if (this.row - m < 0) {
			this.col++;
			return true;
		} else if (this.col - m == 0){
			return false;
		} else {
			this.col--;
			return true;
		}
	}

	

	

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}



	

	Pirate(int row, int col) {
		this.row = row;
		this.col = col;
        this.rowFirst = this.randomBoolean();
	}


	public boolean randomBoolean(){
	    return Math.random() < 0.5;
	}
}
