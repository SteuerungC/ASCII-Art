package de.steuerungc.ascii_art;


import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    @Getter
    private JButton start     = new JButton("Bild wählen");

    @Getter
    private JLabel log        = new JLabel("Wähle ein JPG-Bild aus.");


    public UserInterface(Handler handler) {

        super("ASCII-Art 1.0");

        start.addActionListener(handler);

        this.setLayout(new FlowLayout());

        this.add(log);
        this.add(start);

        this.setSize(200, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
