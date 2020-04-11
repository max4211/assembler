package utility.io;

import utility.converter.Converter;
import utility.converter.Digits;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LogismFile extends OutputFile {

    public LogismFile(String path, Output data) {
        super(path, data);
        this.myExtension = ".lgsim";
        this.myHeader = new ArrayList<>(List.of("v2.0 raw"));
        convertOutputToHex();
        insertHeader(this.myHeader, this.myOutput.getList());
    }

    private void convertOutputToHex() {
        Output output = new Output();
        for (String s: this.myOutput.getList()) {
            output.add(Converter.binaryToHex(s, Digits.LGSIM));
        }
        this.myOutput = output;
    }


}
