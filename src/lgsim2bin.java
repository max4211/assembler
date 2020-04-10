import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lgsim2bin {

    private static final String ZERO = "0";
    private static final String LGSIM_HEADER = "v2.0 raw";
    private static final String TXT_EXT = ".txt";
    private static final String PATHNAME = System.getProperty("user.dir");
    private static final String FILESUFFIX = "_bin" + TXT_EXT; // File extension for write, can add more if desired

    private static final boolean ADD_PIPES = true;
    private static final List<Integer> PIPE_INDEXS = List.of(30, 25, 20, 15, 10, 5);
    private static final String PIPE_SYMBOL = "||";

    /**
     * TODO
     * Change the below information if accessing file in a different location
     * If file is in the same directory, can leave pathname as is
     * FILENAME is the file to read (single filename)
     * READ_FILE_DIRECTORY is the path to the file from the directory java is run from ("user.dir")
     * WRITE_FILE_DIRECTORY is the path to the write file from the directory java is run from ("user.dir")
     * ** Make sure directory for write file dir exists before running
     * Example hierarchy is base_dir --> data folder --> (lgsim and mif folders separate)
     */
    private static final String FILENAME = "misc.imem.lgsim";
    private static final String READ_FILE_DIRECTORY = "/data/lgsim";
    private static final String WRITE_FILE_DIRECTORY = "/data/bin/";

    /**
     * TODO
     * Change below filters to determine what is printed out and what is not
     * FILE_SCAN is the original scanning of the assembler output (includes metadata)
     * PARSE_SCAN is the second scan of only parsed program code (between BEGIN and END)
     * INDIVIDUAL_TRANSLATIONS show transformation from binary -> dec -> hex
     */
    private static final boolean PRINT_FILE_SCAN = true;
    private static final boolean PRINT_PARSE_SCAN = false;
    private static final boolean PRINT_INDIVIDUAL_TRANSLATIONS = true;
    private static final boolean WRITE_HEX_TO_FILE = true;



    private static void convertFile() throws FileNotFoundException {
        File file = createFile();
        Scanner sc = createScanner(file);
        List<String> program = parseProgram(sc);
        if (PRINT_FILE_SCAN) { scanProgram(program); }
        List<String> binaryText = parseHex(program);
        List<String> hexText = translateHex(binaryText);
        writeFile(hexText);
    }

    private static void writeFile(List<String> binText) {
        try {
            String filename = nameFile();
            FileWriter fw = new FileWriter(combinePathToFile(PATHNAME, filename));
            PrintWriter pw = new PrintWriter(fw);
            for (String s: binText) {
                if (PRINT_PARSE_SCAN) { System.out.println(s); }
                pw.println(s);
            }
            pw.close();
            System.out.printf("SUCCESS \nWROTE BINTEXT TO FILE: %s", filename);
        } catch (IOException e) {
            System.out.println("couldn't write file, sorry :(");
            System.exit(0);
        }

    }

    private static String nameFile() {
        String[] split = FILENAME.split("\\.");
        String name = WRITE_FILE_DIRECTORY + split[0] + FILESUFFIX;
        System.out.printf("FILENAME: %s\n", name);
        return WRITE_FILE_DIRECTORY + split[0] + FILESUFFIX;
    }

    private static List<String> translateHex(List<String> hexText) {
        List<String> binText = new ArrayList<>();
        int dec; String bin;
        binText.add(LGSIM_HEADER);
        for (String s: hexText) {
            try {
                dec = Integer.parseInt(s, 16);
                bin = Integer.toString(dec, 2);
                if (PRINT_INDIVIDUAL_TRANSLATIONS) { System.out.printf("HEX: %s --> DEC: %d ---> BIN: %s \n", s, dec, bin); }
            } catch (NumberFormatException e) {
                System.out.printf("could not convert \"%s\" to hex, inserting in raw form\n", s);
                bin = "raw bin:" + s;
            }
            binText.add(binFilter(bin));
        }
        return binText;
    }

    private static String binFilter(String s) {
        int pad = 32 - s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, zeroPad(pad));
        return sb.toString();
    }

    private static String zeroPad(int pad) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < pad; i ++) {
            temp.append(ZERO);
        }
        if (ADD_PIPES) {
            return addPipes(temp.toString());
        }
        return temp.toString();
    }

    private static String addPipes(String s) {
        StringBuilder temp = new StringBuilder(s);
        if (s.length() > 30) {
            for (int index: PIPE_INDEXS) {
                temp.insert(index, PIPE_SYMBOL);
                System.out.print(temp);
            }
            return temp.toString();
        }
        return s;
    }


    private static List<String> parseHex(List<String> program) {
        List<String> hexText = new ArrayList<>();
        for (String s: program) {
            if (s.length() > 5) {
                if (PRINT_PARSE_SCAN) { System.out.println(s); }
                try {
                    hexText.add(s.trim());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.printf("%s \nPROGRAM_LINE: %s", e.getMessage(), s);
                }

            }
        }
        return hexText;
    }

    private static void scanProgram(List<String> program) {
        System.out.println("SCANNING PROGRAM: ");
        for (String s: program) {
            System.out.println(s);
        }
    }

    private static List<String> parseProgram(Scanner sc) {
        boolean inProgram = false;
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (inProgram) {
                list.add(line);
            }
            if (line.contains(LGSIM_HEADER)) {
                inProgram = true;
            }
        }
        return list;
    }

    private static Scanner createScanner(File file) throws FileNotFoundException {
        return new Scanner(file);
    }

    private static String combinePathToFile(String path, String file) {
        return path + "\\" + file;
    }

    private static File createFile() {
        File file = new File(combinePathToFile(PATHNAME + READ_FILE_DIRECTORY, FILENAME));
        return file;
    }

    public static void main(String[] args) throws FileNotFoundException {
        convertFile();
    }
}
