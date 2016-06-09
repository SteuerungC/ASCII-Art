package de.steuerungc.ascii_art;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {
            File file = new File("C:\\Users\\Bjarne\\Desktop\\a.png");
            new Worker(file, "");
    }
}
