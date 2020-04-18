package utility.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TextFile extends OutputFile {

    private static final String EXTENSION = ".txt";

    public TextFile(String path, String outputBase, String digits, Output data) {
        super(path, data);
        this.myExtension = EXTENSION;
        this.myHeader = new ArrayList<>();
        convertOutputToBase(outputBase, digits);
    }

}
