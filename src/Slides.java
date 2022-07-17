import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Slides {
    public String[] imageglob = new String[0];
    public JPanel panel = new JPanel(new FlowLayout());
    public org.imgscalr.Scalr scalr = new Scalr();



    public void runner() {
        System.out.println("starting slideshow");
        loadImages(loadImageGlob());
    }
    public String[] loadImageGlob() { //load images into String []
        FileContentReader fcr = new FileContentReader(null); // path to images
        System.out.println("grabImages\n");
        imageglob = fcr.getFiles(); // String []
        return imageglob;
    }

    //scaler
    public BufferedImage scaling(BufferedImage resizeMe) {
        //BufferedImage resizeMe = ImageIO.read(new File("orig.jpg"));
        Dimension newMaxSize = new Dimension(SlideShow.device.getDisplayMode().getWidth()-20, SlideShow.device.getDisplayMode().getHeight()-20);
        return scalr.resize(resizeMe, Scalr.Method.QUALITY,
                newMaxSize.width, newMaxSize.height);
    }

    //
    public void loadImages(String[] imagepaths) { /**/
        System.out.println("add images to caro"); /**/

        for (int i = 0; i < imagepaths.length; i++) { /**/
            /**/
             /**/

            try {
                BufferedImage bufferedImage = ImageIO.read(new File(imagepaths[i]));
                System.out.println(imagepaths[i]);
                //scale image//
                Image image = scaling(bufferedImage);
                //Image image = bufferedImage.getScaledInstance(SlideShow.device.getDisplayMode().getWidth()+1, SlideShow.device.getDisplayMode().getHeight(), 0);
                ////
                JLabel pic = new JLabel(new ImageIcon(image));

                panel.add(pic);
                pic.setSize(panel.getSize());
                panel.setVisible(true);
                pic.setVisible(true);
                panel.updateUI();
                try {
                    Thread.sleep(5000);
                } catch(Exception exception) {
                    System.out.println(exception);
                }
                panel.remove(pic);



            } catch (IOException exception) {
                System.out.println(exception);
            }

        }
    }



    public void clearImages() {
        panel.removeAll();
    }
}
