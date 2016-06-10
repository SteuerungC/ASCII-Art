package de.steuerungc.ascii_art;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileHandler {

    private JFileChooser open, save;

    public File loadPicture() throws Exception {
        open = new JFileChooser();
        return new File(read());
    }

    private String read() {
        open.setDialogTitle("Select picture");
        open.setFileFilter(new FileNameExtensionFilter("JPG-Bild", "jpg"));
        if (open.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            open.setVisible(true);
            return open.getSelectedFile().getPath();
        }
        else {
            return null;
        }
    }

    public void savePicture(BufferedImage bfi) throws Exception {
        save = new JFileChooser();

        String path = write();
        if (path.endsWith(".jpg")) {
            ImageIO.write(bfi, "png", new File(path));
        } else {
            ImageIO.write(bfi, "png", new File(path + ".jpg"));
        }
    }

    private String write() {
        save.setDialogTitle("Save generated picture");
        save.setFileFilter(new FileNameExtensionFilter("JPG-Bild", "jpg"));
        if (save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            save.setVisible(true);
            return save.getSelectedFile().getPath();
        }
        else {
            return null;
        }
    }
}
