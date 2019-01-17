import java.util.ArrayList;
import java.util.List;

public class Game {

	
	Board board;
	List<Pirate> pirates = new ArrayList<Pirate>() ;
	Ship ship;
	List<Ship> rock = new ArrayList<Ship>() ;

	public void init() {
		board = new Board(5);
		board.setShip(0, 0);
		board.toConsole();
	}
	
	public void playMove(int direction) {
		this.moveShip(direction);
		this.movePirates();
		this.checkPirateColision();
	}
	boolean end() {
		for (int i = 0; i < pirates.size(); i++) {
			if (this.ship.getRow() == this.pirates.get(i).getRow() && this.ship.getCol() == this.pirates.get(i).getCol()) {
				return true;
			}
		}
		for (int i = 0; i < rock.size(); i++) {
			if (this.ship.getRow() == this.rock.get(i).getRow() && this.ship.getCol() == this.rock.get(i).getCol()) {
				return true;
			}
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
    	case 0:  this.ship.setRow(ship.getRow() - 1 );
    		break;
    	case 1:  this.ship.setCol(ship.getCol() + 1);
    		break;
    	case 2:  this.ship.setRow(ship.getRow() + 1);
    		break;
    	case 3:  this.ship.setCol(ship.getCol() - 1);
    		break;
    	}
    }
    
    private void checkPirateColision() {
        int destroyedShips[] = new int[this.pirates.size()];
    	for (int i = 0; i < this.pirates.size(); i++) {
    		for (int j = i; j < this.pirates.size(); j++) {
    			if (this.pirates.get(i).getRow() == this.pirates.get(j).getRow() && this.pirates.get(i).getCol() == this.pirates.get(j).getCol()) {
    				Ship newRock = new Ship(this.pirates.get(i).getRow(), this.pirates.get(i).getCol());
    				this.rock.add(newRock);
    				destroyedShips[i]=1;
    				destroyedShips[j]=1;
    			}
    			
    		}
		}
    	for (int i = destroyedShips.length; i <= 0; i--) {
    		if (destroyedShips[i] == 1); {
    			this.pirates.remove(i);
    			}
    	}
    }
}

