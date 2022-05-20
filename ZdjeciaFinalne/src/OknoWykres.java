
import javax.swing.*;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class OknoWykres extends JFrame {

    BufferedImage image;
    Wykres wykres;
    public OknoWykres(BufferedImage image) throws IOException {
        this.image=  image;
        wykres = new Wykres(this.image);
        wykres.validate();
        wykres.repaint();

        this.add(wykres);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);

    }

}
