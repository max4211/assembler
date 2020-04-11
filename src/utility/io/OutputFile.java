package utility.io;

import java.util.List;

public abstract class OutputFile implements Save {

    protected final String myPath;
    protected Output myOutput;
    protected String myExtension;
    protected List<String> myHeader;

    public OutputFile(String path, Output data) {
        this.myPath = path;
        this.myOutput = data;
    }

    protected void insertHeader(List<String> header, List<String> data) {
        Output output = new Output();
        for (String s: header)
            output.add(s);
        for (String s: data)
            output.add(s);
        this.myOutput = output;
    }

}
