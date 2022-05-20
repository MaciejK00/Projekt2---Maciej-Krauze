import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Panel extends JPanel {
    private BufferedImage zdjecie;
    Menu menu;


    public Panel(BufferedImage zdjecie){
        this.zdjecie =zdjecie;
        menu = new Menu(zdjecie);

        this.setSize(zdjecie.getWidth(),zdjecie.getHeight());


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(zdjecie, 0, 0, this);
        this.validate();
        this.repaint();

    }

}


