package utility.io;

import java.io.File;

public interface OutputInterface {

    /**
     * Appends string to output
     * @param s string to append
     */
    void add(String s);

    /**
     * Create file type based on specification
     * @param type is the type of file
     * @param path is the path to save the file to
     */
    void write(FileType type, String path);

    /**
     * Write all lines in output to console
     * @return String of all lines
     */
    String consoleOut();
}
