package utility.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Output implements OutputInterface, CustomList {

    private List<String> myOutput;
    private static final String NEWLINE = "\n";

    public Output() {
        this.myOutput = new ArrayList<>();
    }


    @Override
    public void add(String s) {
        this.myOutput.add(s);
    }

    // TODO - implement full file write (using reflection on file type to make new File?)
    @Override
    public File write(FileType type) {
        return null;
    }

    @Override
    public String consoleOut() {
        StringBuilder sb = new StringBuilder();
        for (String s: this.myOutput) {
            sb.append(s + NEWLINE);
        }
        return sb.toString();
    }

    @Override
    public List<String> getList() {
        return this.myOutput;
    }
}
