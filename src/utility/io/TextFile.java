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

    public TextFile(String path, Output data) {
        super(path, data);
        this.myExtension = EXTENSION;
        this.myHeader = new ArrayList<>();
    }

    @Override
    public void save() {
        try {
            String path = this.myPath + this.myExtension;
            Files.write(Paths.get(path),
                    this.myOutput.getList(),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
