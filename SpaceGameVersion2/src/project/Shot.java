package project;

import java.awt.Color;
import java.awt.Graphics2D;

public class Shot {
	    private int[] shotCoords = new int[2];
	    private int velocity = 20;
	    Color custom=new Color(16,249,121);

	    public Shot(int x, int y) {
	        this.shotCoords[0] = x;
	        this.shotCoords[1] = y;
	    }
	    
	    public int getShotPosY(){
	        return this.shotCoords[1];
	    }
	    public void paint(Graphics2D g) {
	        g.setColor(custom);
	        g.fillRect(this.shotCoords[0], this.shotCoords[1] -= velocity, 3, 20);
	    }
}
