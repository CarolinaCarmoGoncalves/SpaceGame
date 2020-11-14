package project;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener{
	
	public BufferedImage imagemNave;
    private int x = 0;
    private JFrame janelaJogo;
    private PainelJogo spaceInvaders;
    
    PropertyChangeSupport pcs = new  PropertyChangeSupport(this);
    String property="initial";

    public MainMenu() {
        manButton();
        imagemNave = null;
        init();
    }

    private void manButton() {
        this.setLayout(null);
        JButton playB = new JButton("Jogar");
        playB.setBounds(90, 580, 300, 50);
        this.add(playB);
        playB.addKeyListener(new KeyAdapter() {
        	  public void keyPressed(KeyEvent key) {
        		  selectionButtonPressed(key.getKeyCode() );
        	  }
        });
        playB.addActionListener(this);
    }

    protected void selectionButtonPressed(int key) {
		switch (key) {
	        case KeyEvent.VK_RIGHT:
	            if (this.x < 2) {
	                this.x += 1;
	            }
	            break;
	        case KeyEvent.VK_LEFT:
	            if (this.x > -2) {
	                this.x -= 1;
	            }
	            break;
	        default:
		}
		
	}

	public void init() {
        janelaJogo = new JFrame("Space Invaders 44551 44479");
        janelaJogo.setSize(500, 700);
        janelaJogo.setResizable(false);
        janelaJogo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janelaJogo.setLayout(null);
        janelaJogo.setLocationRelativeTo(null);
        this.setBounds(0, 0, 500, 700);
        janelaJogo.add(this);

        janelaJogo.setVisible(true);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\background.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.setColor(Color.white);
        g.drawString("Menu Principal", 75, 50);
        naveSelection(g);
    }

    private void naveSelection(Graphics g) {
        switch (x) {
            case -2:
                imagemNave = naveSelect("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\player_ship_blue.png");
                break;
            case -1:
                imagemNave = naveSelect("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\player_ship_orange.png");
                break;
            case 0:
                imagemNave = naveSelect("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\player_ship_normal.png");
                break;
            case 1:
                imagemNave = naveSelect("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\player_ship_pink.png");
                break;
            case 2:
                imagemNave = naveSelect("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\player_ship_yellow.png");
                break;
            default:
        }
        g.drawImage(imagemNave, 110, 200, imagemNave.getWidth(), imagemNave.getHeight(), null);
    }

    public BufferedImage naveSelect(String naveDir) {
        try {
            imagemNave = ImageIO.read(new File(naveDir));
        } catch (IOException e) {
            System.out.println("Não foi possível carregar a imagem do inimigo");
            e.printStackTrace();
        }
        return imagemNave;
    }

    public BufferedImage getNaveIMG() {
        return this.imagemNave;
    }

   
	public void updateJFrame() {
		janelaJogo.repaint();
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		this.janelaJogo.setVisible(false);
        this.janelaJogo.remove(this);
        spaceInvaders=new PainelJogo(getNaveIMG());
        spaceInvaders.setBounds(0, 0, 500, 700);    
        this.janelaJogo.add(spaceInvaders);
        janelaJogo.setVisible(true);
        this.janelaJogo.addKeyListener(spaceInvaders);
        
        
    }

	public PainelJogo getSpaceInvaders() {
		return spaceInvaders;
	}

	public void setSpaceInvaders(PainelJogo spaceInvaders) {
		this.spaceInvaders = spaceInvaders;
	}
	
	
}
