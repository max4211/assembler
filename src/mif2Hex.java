import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mif2Hex {

    private static final String BEGIN = "BEGIN";
    private static final String END = "END";
    private static final String SEPARATOR = " : ";
    private static final String SEMICOLON = ";";

    /**
     * Change the below information if accessing file in a different location
     * If file is in the same directory, can leave pathname as is
     * Change filesuffix for what you want new file to be named (after original name)
     */
    private static final String FILENAME = "overflow.mif"; // EDIT ME!!!
    private static final String PATHNAME = System.getProperty("user.dir");
    private static final String FILEPREFIX = "data/hex/";
    private static final String FILESUFFIX = "_hex.txt";

    private static void convertFile() throws FileNotFoundException {
        File file = createFile();
        Scanner sc = createScanner(file);
        List<String> program = parseProgram(sc);
        scanProgram(program);
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
                System.out.println(s);
                pw.println(s);
            }
            pw.close();
            System.out.printf("SUCCESS \nWROTE HEXTEXT TO FILE:\n%s", filename);
        } catch (IOException e) {
            System.out.println("couldn't write file, sorry :(");
            System.exit(0);
        }

    }

    private static String nameFile() {
        String[] split = FILENAME.split("\\.");
        String name = FILEPREFIX + split[0] + FILESUFFIX;
        System.out.printf("filename: %s\n", name);
        return FILEPREFIX + split[0] + FILESUFFIX;
    }

    private static List<String> translateBinary(List<String> binaryText) {
        List<String> hexText = new ArrayList<>();
        int dec; String hex;
        for (String s: binaryText) {
            try {
                dec = Integer.parseInt(s, 2);
                hex = Integer.toString(dec, 16);
                System.out.printf("SUCCESS - dec: %d ---> hex: %s \n", dec, hex);
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
                System.out.println(s);
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
        File file = new File(combinePathToFile(PATHNAME + "/data/mif", FILENAME));
        return file;
    }

    public static void main(String[] args) throws FileNotFoundException {
        convertFile();
    }
}
