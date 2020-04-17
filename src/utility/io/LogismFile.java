package utility.io;

import utility.converter.ConverterInterface;
import utility.converter.Digits;

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
            output.add(ConverterInterface.binaryToHex(s, Digits.LGSIM));
        }
        this.myOutput = output;
    }


}
