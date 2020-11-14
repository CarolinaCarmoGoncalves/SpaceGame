package project;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	BufferedImage backgroundImage;
    int y;

    public Background() {
        try {
            backgroundImage = ImageIO.read(new File("D:\\francisco\\SpaceInvaders-master\\src\\localPlayerIMG\\background.jpg"));
        } catch (IOException e) {
            System.out.println("Não foi possível carregar a imagem do inimigo");
            e.printStackTrace();
        }
        y = 0;
    }

    public void pinta(Graphics2D g) {
        g.drawImage(backgroundImage, 0, y - 608, backgroundImage.getWidth(), -backgroundImage.getHeight(), null);
        g.drawImage(backgroundImage, 0, y - 608, backgroundImage.getWidth(), backgroundImage.getHeight(), null);
        y += 3;
        if (y > 1916) {
            y = 0;
        }
    }
}
