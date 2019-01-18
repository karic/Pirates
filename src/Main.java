import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		boolean gui_only = true;
		if (gui_only) {
	        GUI gui = new GUI();
	        
		} else {
		
		Game game = new Game();
		game.init();
		int lvl=1;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (lvl < 3) {
		game.initLevel(lvl);
		while(!game.end()) {
            game.toConsole();
			System.out.print("Commands: \n");
			System.out.print("a - LEFT \n");
			System.out.print("w - UP \n");
			System.out.print("d - RIGHT \n");
			System.out.print("s - DOWN \n");
			
			
			try {
				char line = bufferedReader.readLine().charAt(0);
				switch (line) {
				case 'a': game.playMove(0); break;
				case 'w': game.playMove(1); break;
				case 'd': game.playMove(2); break;
				case 's': game.playMove(3); break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if (game.isWon) {
			System.out.println("You escaped. Proceed to the next level.");
			lvl++;
		} else {
			System.out.println("You have been caught.");
			return;
		}
		}

	}	
	
	
	}
	
	
	
	
}

