package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Logic;
import game.Sequence;
import mechanism.Collision;

public class Keyboard implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Logic.gamestate == Sequence.start) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Logic.gamestate = Sequence.ingame;

			}
		}

		if (Logic.gamestate == Sequence.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				try {
					if (!Collision.collideInRotation(Logic.currentBlock)) {
						Logic.currentBlock.rotate();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_S) {
				Logic.speedup = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_D) {

				try {
					if (!Collision.collideWithWall(Logic.currentBlock, 1)
							&& !Collision.collideWithBlock(Logic.currentBlock, 1)) {
						Logic.currentBlock.setX(Logic.currentBlock.getX() + 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				try {
					if (!Collision.collideWithWall(Logic.currentBlock, -1)
							&& !Collision.collideWithBlock(Logic.currentBlock, -1)) {
						Logic.currentBlock.setX(Logic.currentBlock.getX() - 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Logic.gamestate = Sequence.pause;

			}
		} else if (Logic.gamestate == Sequence.pause) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Logic.gamestate = Sequence.ingame;
			}

		} else if (Logic.gamestate == Sequence.gameover) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Logic.gamestate = Sequence.ingame;
				Logic.clear();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Logic.gamestate == Sequence.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_S) {
				Logic.speedup = false;
			}
		}

	}

}
