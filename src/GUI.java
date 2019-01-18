import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class GUI {
  static JFrame jf;
  static JPanel jp;
  JButton[][] jb;
  Game game;
  public void resetGUI() {
	  for (int i=0; i<this.jb.length; i++) {
	      for (int j=0; j<this.jb[i].length; j++) {
	          this.jb[i][j].setBackground(Color.black);
	          this.jb[i][j].setOpaque(false);
	      }
	   }
  }
  

  
  public void updateGUI() {
	  this.resetGUI();
	  for (int i = 0; i < this.game.pirates.size(); i++) {
		  this.jb[this.game.pirates.get(i).getRow()][ this.game.pirates.get(i).getCol()].setBackground(Color.red);
		  this.jb[this.game.pirates.get(i).getRow()][ this.game.pirates.get(i).getCol()].setOpaque(true);

	  }
  	for (int i = 0; i < this.game.rock.size(); i++) {
  		this.jb[this.game.rock.get(i).getRow()][ this.game.rock.get(i).getCol()].setBackground(Color.orange);
  		this.jb[this.game.rock.get(i).getRow()][ this.game.rock.get(i).getCol()].setOpaque(true);

  	}
  	this.jb[this.game.ship.getRow()][ this.game.ship.getCol()].setBackground(Color.darkGray);
  	this.jb[this.game.ship.getRow()][ this.game.ship.getCol()].setOpaque(true);

  	this.jb[this.game.goal.getRow()][this.game.goal.getCol()].setBackground(Color.GREEN);
  	this.jb[this.game.goal.getRow()][this.game.goal.getCol()].setOpaque(true);

  	}
  
  public void DisplayMessage(String message) {
	    JFrame f;  
	    f=new JFrame();  
	    JOptionPane.showMessageDialog(f, message);
  }
  
  public void PlayOrInstructions() {
	  JFrame f;  
	  f=new JFrame();  
	  int a = JOptionPane.showConfirmDialog(f,"Do you know the rules?");
	  if(a==JOptionPane.NO_OPTION){ 
	   this.DisplayMessage("You are a GREY ship trying to get to GREEN goal. Avoid YELLOW rocks and RED pirate ships.\nControls:\n  W\nASD\n");
	  }
	  }
  
  GUI() {
    game = new Game();
    game.init();
    int dim = game.board.getDim();
    this.PlayOrInstructions();
    jf = new JFrame("Pirates");
    jf.setSize(500, 500);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    jp = new JPanel();
    jp.setLayout(new GridLayout(dim, dim));
    jp.setBackground(Color.BLUE);

    jb = new JButton[dim][dim];
    for (int i=0; i<dim; i++) {
      for (int j=0; j<dim; j++) {
        jb[i][j] = new JButton();
        jb[i][j].setSize(30, 30);
        jb[i][j].setEnabled(false);
        jb[i][j].setBackground(Color.BLUE);
        this.jb[i][j].setOpaque(false);

        jp.add(jb[i][j]);
      }
    }
    jf.add(jp);
    jf.setResizable(false);
    jf.setVisible(true);
    
	  KeyListener kl = new KeyListener() {
	      @Override
	      public void keyPressed(KeyEvent e) {
	    	  switch(e.getKeyCode()) {
	    	  case 65:game.playMove(0);
	    	  break;
	    	  case 87:game.playMove(1);
	    	  break;
	    	  case 68:game.playMove(2);
	    	  break;
	    	  case 83:game.playMove(3);
	    	  break;
	    	  }


	        
	      }

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	  
	  };


    
    
    
    jf.addKeyListener(kl); 
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }


