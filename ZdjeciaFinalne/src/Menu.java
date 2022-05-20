import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends JMenuBar {
    BufferedImage image;
    Maski maski;
    Zdjecia zdjecia;
    OknoWykres okno;

    public Menu(BufferedImage image){
        JMenu Lab5 = new JMenu("Lab5");
        JMenu Lab6 = new JMenu("Lab6");
        JMenu Lab7 = new JMenu("Lab7");
        JMenuItem rozjasnianie = new JMenuItem("rozjasnienie");
        rozjasnianie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zdjecia = new Zdjecia(image);

                zdjecia.rozjasnianie();
                okno.dispose();
                try {
                    okno = new OknoWykres(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        JMenuItem przyciemnianie = new JMenuItem("przyciemnianie ");

        przyciemnianie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zdjecia = new Zdjecia(image);
                zdjecia.przyciemmnienie();
                okno.dispose();
                try {
                    okno = new OknoWykres(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JMenuItem negatyw = new JMenuItem("negatyw");

        negatyw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                zdjecia = new Zdjecia(image);
                zdjecia.negatyw();
                okno.dispose();
                try {
                    okno = new OknoWykres(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        JMenuItem Histogram = new JMenuItem("Histogram");


        this.image = image;

        Histogram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    okno =  new OknoWykres(image);


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JMenuItem Maska = new JMenuItem("Maska1");
        Maska.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maski = new Maski(image,true,false,false);
                okno.dispose();
                try {
                    okno = new OknoWykres(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JMenuItem Maska2 = new JMenuItem("Maska2");
        Maska2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maski = new Maski(image,false,true,false);
                okno.dispose();
                try {
                    okno = new OknoWykres(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JMenuItem Maska3 = new JMenuItem("Maska3");
        Maska3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okno.dispose();
                try {
                    okno = new OknoWykres(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Lab5.add(rozjasnianie);
        Lab5.add(przyciemnianie);
        Lab5.add(negatyw);

        this.add(Lab5);

        Lab6.add(Histogram);
        this.add(Lab6);

        Lab7.add(Maska);
        Lab7.add(Maska2);
        Lab7.add(Maska3);
        this.add(Lab7);
    }
}
