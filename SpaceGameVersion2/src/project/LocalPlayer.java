package project;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class LocalPlayer {
	private int[] coords = {190, 500};
    private int velocity = 3;
    BufferedImage imagemNave = null;
    private boolean canShoot = true;
    private int timer = 0;
    private int Score=0;

    public LocalPlayer() {
    }
    public int getScore(){
        return this.Score;
    }
    public void addKillScore(){
        this.Score+=1;
    }
    public void moviment(int valor) {
        switch (valor) {
            case 68:
                if(coords[0]<500-85)
                coords[0] += velocity;
                break;
            case 65:
                if(coords[0]>0)
                coords[0] -= velocity;
                break;
            case 87:
                if(coords[1]>0)
                coords[1] -= velocity;
                break;
            case 83:
                if(coords[1]<595)
                coords[1] += velocity;
                break;
            default:

        }
        if (timer >= 15) {
            canShoot = true;
            timer = 0;
        }
        timer++;
    }

    public Shot shoot() {
        canShoot = false;
        Shot newShot = new Shot(coords[0] + 33, coords[1] - 20);
        return newShot;
    }

    public boolean canShoot() {
        return this.canShoot;
    }

    void paint(Graphics2D g,BufferedImage naveSelected) {
        g.drawImage(naveSelected, coords[0], coords[1], coords[0] + 70, coords[1] + 70, 0, 0, naveSelected.getWidth(), naveSelected.getHeight(), null);
    }
}
