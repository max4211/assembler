package utility.io;

public abstract class OutputFile implements Save {

    protected final String myPath;
    protected final Output myOutput;

    public OutputFile(String path, Output data) {
        this.myPath = path;
        this.myOutput = data;
    }

}
