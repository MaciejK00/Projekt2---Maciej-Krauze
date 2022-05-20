import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;

class Wykres extends JPanel {

    BufferedImage image;
    int szer;
    int wys;
    int[] pixele;
    int rozmiar = 256;
    int[] wy = new int[rozmiar];

    int maxx = 0;
    int w;
    int h;
    Dimension wymiar;

    public Wykres(BufferedImage image) {
        this.image = image;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.wymiar = this.getSize();
        this.w = this.wymiar.width;
        this.h = this.wymiar.height;
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        try {
            MediaTracker t = new MediaTracker(this);
            t.addImage(this.image, 0);
            t.waitForID(0);
            this.szer = this.image.getWidth((ImageObserver)null);
            this.wys = this.image.getHeight((ImageObserver)null);
            this.pixele = new int[this.szer * this.wys];
            PixelGrabber pg = new PixelGrabber(this.image, 0, 0, this.szer, this.wys, this.pixele, 0, this.szer);
            pg.grabPixels();
        } catch (InterruptedException var8) {
            System.out.println("Błąd");
            return;
        }

        int i;
        int y;
        int x;
        int ost;
        for(x = 0; x < this.szer * this.wys; ++x) {
            ost = this.pixele[x];
            i = rozmiar-1 & ost >> 16;
            y = rozmiar-1 & ost >> 8;
            int b = rozmiar-1 & ost;
            int z = (int)(0.33 * (double)i + 0.56 * (double)y + 0.11 * (double)b);
            this.wy[z]++;
        }

        for(x = 0; x < rozmiar; ++x) {
            if (this.wy[x] > this.maxx) {
                this.maxx = this.wy[x];
            }
        }

        x = (this.w - rozmiar) / 2;
        ost = this.h - this.h * this.wy[0] / this.maxx;

        for(i = 0; i < rozmiar; ++x) {
            y = this.h - this.h * this.wy[i] / this.maxx;
            g.setColor(Color.CYAN);
            g.fillRect(x, y, 1, this.h);
            g.setColor(Color.BLUE);
            g.drawLine(x - 1, ost, x, y);
            ost = y;
            ++i;
        }
    }
}