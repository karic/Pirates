import java.util.ArrayList;
import java.util.List;

public class Game {
    int size = 10;
    boolean isWon=false;
	
	Board board;
	List<Pirate> pirates = new ArrayList<Pirate>() ;
	Ship ship;
	List<Ship> rock = new ArrayList<Ship>() ;
	Ship goal;
	
	public void toConsole() {
		this.setBoardState();
		board.toConsole();
	}

	public void init() {
		board = new Board(size);
	}
	
	public void playMove(int direction) {
		this.moveShip(direction);
		this.movePirates();
		this.checkPirateColision();
	}
	private boolean checkOOBDeath() {
		if ( 0 > this.ship.getCol() || size <= this.ship.getCol() || 0 > this.ship.getRow() || size <= this.ship.getRow() ) {
			return true;
		} else {
			return false;
		}
	}

	boolean end() {
		if (this.isWon()) {
			isWon=true;
			return true;
		}
		for (int i = 0; i < pirates.size(); i++) {
			if (this.ship.getRow() == this.pirates.get(i).getRow() && this.ship.getCol() == this.pirates.get(i).getCol()) {
				isWon=false;
				return true;
			}
		}
		for (int i = 0; i < rock.size(); i++) {
			if (this.ship.getRow() == this.rock.get(i).getRow() && this.ship.getCol() == this.rock.get(i).getCol()) {
				isWon=false;
				return true;
			}
		}
		if (this.checkOOBDeath()){
			isWon=false;
			return true;
		}
		return false;
	}	
	
	
    public void movePirates() {
    	for (int i = 0; i < this.pirates.size(); i++) {
			this.pirates.get(i).approach(ship.getRow(), ship.getCol());
		}
    }
    
    public void moveShip(int direction) {
    	switch (direction) {
    	case 0:  this.ship.setCol(ship.getCol() - 1 );
    		break;
    	case 1:  this.ship.setRow(ship.getRow() - 1);
    		break;
    	case 2:  this.ship.setCol(ship.getCol() + 1);
    		break;
    	case 3:  this.ship.setRow(ship.getRow() + 1);
    		break;
    	}
    }
    
    public boolean isWon() {
    	if (this.ship.getCol()==this.goal.getCol() && this.ship.getRow()==this.goal.getRow()) {
    		return true;
    	} else {
    		return false;
    	}
    
    }
    
    private void checkPirateColision() {
        int destroyedShips[] = new int[this.pirates.size()];



    	for (int i = 0; i < this.pirates.size(); i++) {
			if (this.pirates.get(i).getRow() == this.goal.getRow() && this.pirates.get(i).getCol() == this.goal.getCol()) {
				destroyedShips[i]=1;
			}
			if ( 0 > this.pirates.get(i).getCol() || size <= this.pirates.get(i).getCol() || 0 > this.pirates.get(i).getRow() || size <= this.pirates.get(i).getRow() ) {
				destroyedShips[i]=1;

			}
			for (int j = i + 1; j < this.rock.size(); j++) {
    			if (this.pirates.get(i).getRow() == this.rock.get(j).getRow() && this.rock.get(i).getCol() == this.pirates.get(j).getCol()) {
    				destroyedShips[i]=1;
    			}
    		}
    		
    		
			for (int j = i + 1; j < this.pirates.size(); j++) {
    			if (this.pirates.get(i).getRow() == this.pirates.get(j).getRow() && this.pirates.get(i).getCol() == this.pirates.get(j).getCol()) {
    				this.rock.add(new Ship(this.pirates.get(i).getRow(), this.pirates.get(i).getCol()));
    				destroyedShips[i]=1;
    				destroyedShips[j]=1;
    			}
    		}
		}

    	for (int i = destroyedShips.length - 1; i >= 0; i--) {

    		if (destroyedShips[i] == 1){
    			this.pirates.remove(i);
    			}
    	}
    }
    
     void setBoardState() {
        board.resetBoard();
    	for (int i = 0; i < this.pirates.size(); i++) {
    		board.setPirate(this.pirates.get(i).getRow(), this.pirates.get(i).getCol());
    	}
    	for (int i = 0; i < this.rock.size(); i++) {
    		board.setRock(this.rock.get(i).getRow(), this.rock.get(i).getCol());
    	}
    	board.setShip(this.ship.getRow(), this.ship.getCol());
    	board.setGoal(this.goal.getRow(), this.goal.getCol());
    	
    }
	public void initLevel(int lvl) {
		switch (lvl) {
		case 1: 		
			pirates = new ArrayList<Pirate>() ;
			rock = new ArrayList<Ship>() ;
			ship = new Ship(0,3);
			goal = new Ship(0,9);
			this.pirates.add(new Pirate(8,9));
			this.pirates.add(new Pirate(8,8));
			this.pirates.add(new Pirate(8,7));
			this.pirates.add(new Pirate(8,6));
			break;
		case 2:
			pirates = new ArrayList<Pirate>() ;
			rock = new ArrayList<Ship>() ;
			ship = new Ship(0,3);
			goal = new Ship(0,9);
			this.rock.add(new Ship(0,5));
			this.pirates.add(new Pirate(8,9));
			this.pirates.add(new Pirate(8,8));
			this.setBoardState();	


		}
		this.setBoardState();	
	}

}

