package de.steuerungc.ascii_art;


import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Handler implements ActionListener {

    private UserInterface gui;
    private FileHandler   fh;
    private BufferedImage bfi = null;
    private int width, height;

    @Getter
    @Setter
    private static int step = 0;

    public Handler() {
        gui = new UserInterface(this);
        fh = new FileHandler();
    }

    public void actionPerformed (ActionEvent ae) {
        switch (step) {
            case 0: // Loading picture
                String trans;

                try {
                    BufferedImage bfi = ImageIO.read(fh.loadPicture());
                    width = bfi.getWidth();
                    height = bfi.getHeight();

                    trans = Worker.build(bfi);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    gui.getLog().setText("Unable to load picture.");
                    return;
                }

                try {
                    bfi = Worker.render(trans, height*16, width*15);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    gui.getLog().setText("Unable to render picture,");
                    return;
                }

                gui.getLog().setText("Picture rendered. Save now?");
                gui.getStart().setText("Save picture");
                step = 1;
                break;
            case 1: // Picture loaded
                try {
                    if (bfi == null) {
                        step = 0;
                        gui.getLog().setText("Failed to load ... mysterious :(");

                        return;
                    }
                    fh.savePicture(bfi);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    gui.getLog().setText("Unable to save. Try it again ...");
                    gui.getStart().setText("Select picture");
                    step = 0;
                    return;
                }
                gui.getLog().setText("Picture saved successfully!");
                gui.getStart().setText("Select picture");
                step = 0;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
