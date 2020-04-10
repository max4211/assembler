import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mif2lgsim {

    private static final String BEGIN = "BEGIN";
    private static final String END = "END";
    private static final String SEPARATOR = " : ";
    private static final String SEMICOLON = ";";
    private static final String LGSIM_EXT = ".imem.lgsim";
    private static final String LGSIM_HEADER = "v2.0 raw";
    private static final String PATHNAME = System.getProperty("user.dir");
    private static final String FILESUFFIX = "" + LGSIM_EXT; // File extension for write, can add more if desired

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
    private static final String FILENAME = "regcheck.mif";
    private static final String READ_FILE_DIRECTORY = "/data/mif";
    private static final String WRITE_FILE_DIRECTORY = "/data/lgsim/";

    /**
     * TODO
     * Change below filters to determine what is printed out and what is not
     * FILE_SCAN is the original scanning of the assembler output (includes metadata)
     * PARSE_SCAN is the second scan of only parsed program code (between BEGIN and END)
     * INDIVIDUAL_TRANSLATIONS show transformation from binary -> dec -> hex
     */
    private static final boolean PRINT_FILE_SCAN = false;
    private static final boolean PRINT_PARSE_SCAN = false;
    private static final boolean PRINT_INDIVIDUAL_TRANSLATIONS = false;


    private static void convertFile() throws FileNotFoundException {
        File file = createFile();
        Scanner sc = createScanner(file);
        List<String> program = parseProgram(sc);
        if (PRINT_FILE_SCAN) { scanProgram(program); }
        List<String> binaryText = parseBinary(program);
        List<String> hexText = translateBinary(binaryText);
        writeFile(hexText);
    }

    private static void writeFile(List<String> hexText) {
        try {
            String filename = nameFile();
            FileWriter fw = new FileWriter(combinePathToFile(PATHNAME, filename));
            PrintWriter pw = new PrintWriter(fw);
            for (String s: hexText) {
                if (PRINT_PARSE_SCAN) { System.out.println(s); }
                pw.println(s);
            }
            pw.close();
            System.out.printf("SUCCESS \nWROTE HEXTEXT TO FILE: %s", filename);
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

    private static List<String> translateBinary(List<String> binaryText) {
        List<String> hexText = new ArrayList<>();
        int dec; String hex;
        hexText.add(LGSIM_HEADER);
        for (String s: binaryText) {
            try {
                dec = Integer.parseInt(s, 2);
                hex = Integer.toString(dec, 16);
                if (PRINT_INDIVIDUAL_TRANSLATIONS) { System.out.printf("BIN: %s --> DEC: %d ---> HEX: %s \n", s, dec, hex); }
            } catch (NumberFormatException e) {
                System.out.printf("could not convert \"%s\" to hex, inserting in raw form\n", s);
                hex = "raw bin:" + s;
            }
            hexText.add(hex);
        }
        return hexText;
    }


    private static List<String> parseBinary(List<String> program) {
        List<String> binaryText = new ArrayList<>();
        String[] splitRaw;
        String[] splitInstruction;
        String binary;
        for (String s: program) {
            if (s.length() > 5) {
                if (PRINT_PARSE_SCAN) { System.out.println(s); }
                splitRaw = s.split(SEPARATOR);
                splitInstruction = splitRaw[1].split(SEMICOLON);
                binary = splitInstruction[0];
                binaryText.add(binary);
            }
        }
        return binaryText;
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
            if (line.contains(BEGIN)) {
                inProgram = true;
            } else if (line.contains(END)) {
                inProgram = false;
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
