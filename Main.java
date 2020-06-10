package launch;

import java.awt.FontFormatException;
import java.io.IOException;

import game.BlockType;
import game.Logic;
import gametable.Table;

public class Main {
	


	public static void main(String[] args) {
		
		
	
		Logic.currentBlock = new BlockType();
		Logic.blocks.add(Logic.currentBlock);
		Logic.nextBlock = new BlockType();
		
		try {
			Table g = new Table();
			g.create();
		} catch (FontFormatException | IOException e) {
			System.out.println("ERROR");
			e.printStackTrace(); 
		}
		
		startLoop();
		
	}
	
	public static void startLoop() {
		Movement loop = new Movement();
		loop.start();
	}

}
