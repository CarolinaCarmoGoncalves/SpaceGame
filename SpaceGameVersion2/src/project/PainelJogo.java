package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PainelJogo extends JPanel implements KeyListener{

    private LocalPlayer nave = new LocalPlayer();
    private Background back = new Background();
    private BufferedImage navePic=null;
    private int movimentCoords = 0;

    private ArrayList<Shot> shots;

    public PainelJogo(BufferedImage imagem) {
        shots = new ArrayList<Shot>();
        this.navePic=imagem;
    }
   
    private void update(int arg) {
        nave.moviment(arg);
    }

    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);//limpar a tela
        Graphics2D g = (Graphics2D) g2.create();
        back.pinta(g);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        nave.paint(g,this.navePic);
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).paint(g);
            if (shots.get(i).getShotPosY() < 0) {
                shots.remove(i);
            }
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString("Score: ", 300,50);
        
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString(String.valueOf(nave.getScore()), 400,50);
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println(key.getKeyCode());
		update(key.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		
	}
}

