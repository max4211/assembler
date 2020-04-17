package utility.io;

import utility.converter.Converter;
import utility.converter.ConverterInterface;
import utility.converter.Digits;

import java.util.ArrayList;
import java.util.List;

public class LogismFile extends OutputFile {

    private static final String OUTPUT_BASE = "BIN";
    private static final String DIGITS = "32";

    public LogismFile(String path, Output data) {
        super(path, data);
        this.myExtension = ".lgsim";
        this.myHeader = new ArrayList<>(List.of("v2.0 raw"));
        convertOutputToBase(OUTPUT_BASE, DIGITS);
        insertHeader(this.myHeader, this.myOutput.getList());
    }

}
