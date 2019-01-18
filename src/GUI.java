import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

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
	          this.jb[i][j].setBackground(null);
	      }
	   }
  }
  
  public void updateGUI() {
	  this.resetGUI();
	  for (int i = 0; i < this.game.pirates.size(); i++) {
		  this.jb[this.game.pirates.get(i).getRow()][ this.game.pirates.get(i).getCol()].setBackground(Color.red);
  	}
  	for (int i = 0; i < this.game.rock.size(); i++) {
  		this.jb[this.game.rock.get(i).getRow()][ this.game.rock.get(i).getCol()].setBackground(Color.orange);
  	}
  	this.jb[this.game.ship.getRow()][ this.game.ship.getCol()].setBackground(Color.darkGray);
  	this.jb[this.game.goal.getRow()][this.game.goal.getCol()].setBackground(Color.GREEN);
  	}
  
  
  
  GUI() {
    game = new Game();
    game.init();
    int dim = game.board.getDim();

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
        jb[i][j].setBackground(null);
        jp.add(jb[i][j]);
      }
    }
    this.game.initLevel(1);
    this.updateGUI();
    jf.add(jp);
    jf.setResizable(false);
    jf.setVisible(true);


    
    
    
    
    
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }


