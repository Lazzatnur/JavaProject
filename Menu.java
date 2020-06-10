package gametable;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import game.Logic;
import game.Sequence;

public class Menu extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (Logic.gamestate == Sequence.start) {
			g.setColor(new Color(4, 255, 0));
			g.fillRect(0, Table.height / 2 - 50, Table.width+200, 100);
			g.setColor(Color.WHITE);
			g.setFont(Table.pixelfont.deriveFont(14f));
			g.drawString("PRESS ENTER TO START", Table.width/10, Table.height / 2 +10);
		}else if(Logic.gamestate == Sequence.pause) {
			g.setColor(new Color(1, 97, 255));
			g.fillRect(0, Table.height / 2 - 50, Table.width+200, 100);
			g.setColor(Color.WHITE);
			g.setFont(Table.pixelfont.deriveFont(14f));
			g.drawString("PRESS ESC TO CONTINUE", Table.width/10, Table.height / 2 +10);
		}else if(Logic.gamestate == Sequence.gameover){
			g.setColor(new Color(255, 48, 2));
			g.fillRect(0, Table.height / 2 - 50, Table.width+200, 100);
			g.setColor(Color.WHITE);
			g.setFont(Table.pixelfont.deriveFont(14f));
			g.drawString("GAME OVER", Table.width/3, Table.height / 2 +10);
		}

		repaint();
		
	}
}
