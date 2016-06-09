package de.steuerungc.ascii_art;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {
            File file = new File("H:\\uw.jpg");
            new Worker(file, "");
    }
}
