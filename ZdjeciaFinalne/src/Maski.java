import java.awt.*;
import java.awt.image.BufferedImage;


public class Maski {
    BufferedImage image;
    int width;
    int height;
    boolean maska1;
    boolean maska2;
    boolean maska3;

    public Maski(BufferedImage image,boolean maska1,boolean maska2, boolean maska3) {


        try {
        this.image = image;


            width = image.getWidth();
            height = image.getHeight();

            int[][] maska = new int[3][3];

            this.maska1 = maska1;
            this.maska2 = maska2;
            this.maska3= maska3;

            if(maska1) {
                maska[0][0] = 0;
                maska[0][1] = 0;
                maska[0][2] = 0;
                maska[1][0] = 0;
                maska[1][1] = 1;
                maska[1][2] = -1;
                maska[2][0] = 0;
                maska[2][1] = 0;
                maska[2][2] = 0;
            }
            if(maska2) {
                maska[0][0] = -2;
                maska[0][1] = 1;
                maska[0][2] = -2;
                maska[1][0] = 1;
                maska[1][1] = 4;
                maska[1][2] = 1;
                maska[2][0] = -2;
                maska[2][1] = 1;
                maska[2][2] = -2;
            }
            if(maska3) {
                maska[0][0] = 1;
                maska[0][1] = 2;
                maska[0][2] = 1;
                maska[1][0] = 0;
                maska[1][1] = 0;
                maska[1][2] = 0;
                maska[2][0] = -1;
                maska[2][1] = -2;
                maska[2][2] = -1;
            }

            int pomoc_r;
            int pomoc_g;
            int pomoc_b;
            int red_wy, green_wy, blue_wy;


            for (int i = 1; i < height - 1; i++) {
                for (int j = 1; j < width - 1; j++) {

                    pomoc_r = 0;
                    pomoc_g = 0;
                    pomoc_b = 0;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {


                            Color c = new Color(image.getRGB(j + k, i + l));
                            int red = (int) (c.getRed());
                            int green = (int) (c.getGreen());
                            int blue = (int) (c.getBlue());

                            pomoc_r += red * maska[k + 1][l + 1];
                            pomoc_g += green * maska[k + 1][l + 1];
                            pomoc_b += blue * maska[k + 1][l + 1];


                        }
                    }

                    if (pomoc_r >= 0 && pomoc_r <= 255) red_wy = pomoc_r;
                    else red_wy = 0;
                    if (pomoc_g >= 0 && pomoc_g <= 255) green_wy = pomoc_g;
                    else green_wy = 0;
                    if (pomoc_b >= 0 && pomoc_b <= 255) blue_wy = pomoc_b;
                    else blue_wy = 0;

                    Color newColor = new Color(red_wy, green_wy, blue_wy);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
        } catch (Exception e) {
        }
    }
}