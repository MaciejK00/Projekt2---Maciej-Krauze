import java.awt.*;
import java.awt.image.BufferedImage;

public class Zdjecia  {
    BufferedImage zdjecie;
    int width;
    int height;
    int R;
    int G;
    int B;

    Color odczytany;



    boolean zakres(double x){
        if(x>255 || x<0) return false;
        else return true;
    }
    public Zdjecia(BufferedImage zdjecie) {
        this.zdjecie = zdjecie;
        width = zdjecie.getWidth();
        height = zdjecie.getHeight();

    }

    void negatyw(){
        int y = 255;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                odczytany = new Color(zdjecie.getRGB(i,j));
                R= odczytany.getRed();
                G= odczytany.getGreen();
                B= odczytany.getBlue();

                Color kolor = new Color(zdjecie.getRGB(i,j));

                R = y-kolor.getRed() ;
                G = y-kolor.getGreen();
                B = y-kolor.getBlue();

                Color nowy = new Color(R,G,B);
                zdjecie.setRGB(i,j,nowy.getRGB());
            }

        }
    }

    void przyciemmnienie(){
        int y=-30;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                odczytany = new Color(zdjecie.getRGB(i,j));
                R= odczytany.getRed();
                G= odczytany.getGreen();
                B= odczytany.getBlue();

                Color kolor = new Color(zdjecie.getRGB(i,j));
                if(zakres(kolor.getRed() + y)) {

                    R = kolor.getRed() + y;
                }
                else R = kolor.getRed();

                if(zakres(kolor.getGreen() + y)) {


                    G = kolor.getGreen() + y;
                }
                else G = kolor.getGreen();
                if(zakres(kolor.getBlue() +y)) {

                    B = kolor.getBlue() +y;
                }
                else B = kolor.getBlue();

                Color nowy = new Color(R,G,B);
                zdjecie.setRGB(i,j,nowy.getRGB());

            }

        }


    }
    void rozjasnianie(){
        int y=30;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                odczytany = new Color(zdjecie.getRGB(i,j));
                R= odczytany.getRed();
                G= odczytany.getGreen();
                B= odczytany.getBlue();

                Color kolor = new Color(zdjecie.getRGB(i,j));
                if(zakres(kolor.getRed() + y)) {

                    R = kolor.getRed() + y;
                }
                else R = kolor.getRed();

                if(zakres(kolor.getGreen() + y)) {


                    G = kolor.getGreen() + y;
                }
                else G = kolor.getGreen();
                if(zakres(kolor.getBlue() +y)) {

                    B = kolor.getBlue() +y;
                }
                else B = kolor.getBlue();

                Color nowy = new Color(R,G,B);
                zdjecie.setRGB(i,j,nowy.getRGB());

            }

        }
    }

}