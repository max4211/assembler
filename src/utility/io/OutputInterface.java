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
     * @return a file of the specified format
     */
    File write(FileType type);

    /**
     * Write all lines in output to console
     * @return String of all lines
     */
    String consoleOut();
}
