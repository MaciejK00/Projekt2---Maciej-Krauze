import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Okno extends JFrame {
    Panel panel;
    BufferedImage image;

    public Okno(){
        try {
            image = ImageIO.read(new File("ratusz.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel  = new Panel(image);

        this.setJMenuBar(panel.menu);


        this.add(panel);
        this.setSize(panel.getWidth(),panel.getHeight());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Okno();
    }
}
