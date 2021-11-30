package groupe_b;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Florian Latapie
 */
public class Assembleur {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir") + "\\files\\";
        System.out.println("Working Directory = " + dir);
        File f = new File(dir);
        List<String> allFiles = List.of(f.list()).stream().filter(file -> file.endsWith(".s")).toList();
        System.out.println(allFiles);


        for (String filename : allFiles) {
            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                String inputFilePath = dir + filename;
                String outputFilePath = inputFilePath.substring(0, inputFilePath.length() - 2) + ".bin";
                System.out.println(inputFilePath);
                reader = new BufferedReader(new FileReader(inputFilePath));
                writer = new BufferedWriter(new FileWriter(outputFilePath));
                String ligne;
                printAndWrite(writer, "v2.0 raw" + System.lineSeparator());
                while ((ligne = reader.readLine()) != null) {
                    String out = convertToASM(ligne);
                    int decimal = Integer.parseInt(out, 2);
                    out = Integer.toString(decimal, 16);
                    printAndWrite(writer, out);
                }
                System.out.println("\n");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reader.close();
                writer.close();
            }
        }

    }

    private static void printAndWrite(BufferedWriter writer, String ligne) throws IOException {
        System.out.print(ligne);
        writer.write(ligne);
    }

    private static String convertToASM(String ligne) throws Exception {
        List<String> arguments = new ArrayList<>(List.of(ligne.split(" ")));

        String instruction = arguments.get(0).toLowerCase(Locale.ROOT);

        switch (instruction) {
            case "ands":
                return Fonctions.ands(ligne);
            case "sub"
                return Fonctions.sub(ligne);
            default:
                String message = "instruction needs to be implemented : " + ligne;
                System.out.println(message);
                return message;
        }
    }
}
