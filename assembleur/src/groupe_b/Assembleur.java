package groupe_b;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Florian Latapie
 */
public class Assembleur {
    public static void main(String[] args) throws IOException {
        String dossierDExec = System.getProperty("user.dir") + "\\files\\";
        System.out.println("Recherche de fichers '*.s' dans " + dossierDExec);
        File fichiersDuDossierDExec = new File(dossierDExec);
        List<String> tousLesFichiersS = Stream.of(Objects.requireNonNull(fichiersDuDossierDExec.list())).filter(file -> file.endsWith(".s")).toList();
        System.out.println("fichiers a convertir : " + tousLesFichiersS);

        for (String nomDuFichier : tousLesFichiersS) {
            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                String cheminDuFichierDEntree = dossierDExec + nomDuFichier;
                String cheminDuFichierDeSortie = cheminDuFichierDEntree.substring(0, cheminDuFichierDEntree.length() - 2) + ".bin";
                System.out.println(cheminDuFichierDEntree);
                reader = new BufferedReader(new FileReader(cheminDuFichierDEntree));
                writer = new BufferedWriter(new FileWriter(cheminDuFichierDeSortie));

                String ligne;
                afficherEtEcrire(writer, "v2.0 raw" + System.lineSeparator());
                while ((ligne = reader.readLine()) != null) {
                    traiterLigne(writer, ligne);
                }
                System.out.println("\n");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
        }
    }

    private static void traiterLigne(BufferedWriter writer, String ligne) throws Exception {
        if (!ligne.startsWith("@")) {
            if (!ligne.isEmpty()) {
                String binaryString = convertirVersBinaire(ligne);
                if (binaryString.length() != 16) {
                    binaryString = "instruction de mauvaise longueur ("
                            + binaryString.length() + "): " + ligne + " ==> "
                            + binaryString + "\n";
                } else {
                    System.out.println("\n binary string "+ binaryString);
                    int decimal = Integer.parseInt(binaryString, 2);
                    binaryString = Integer.toString(decimal, 16);
                }
                afficherEtEcrire(writer, binaryString+ " ");
            }
        }
    }

    private static void afficherEtEcrire(BufferedWriter writer, String ligne) throws IOException {
        System.out.print(ligne);
        writer.write(ligne);
    }

    private static String convertirVersBinaire(String ligne) throws Exception {
        List<String> arguments = new ArrayList<>(List.of(ligne.split(" ")));

        String instruction = arguments.get(0).toLowerCase(Locale.ROOT);

        switch (instruction) {
            case "ands":
                return Fonctions.ands(ligne);
            /*
            case "shift":
                return Fonctions.sub(ligne);
            case "add":
                return Fonctions.move(ligne);
            case "sub":
                return Fonctions.sub(ligne);
            */
            case "movs":
                return Fonctions.movs(ligne);

            default:
                String message = "instruction a besoin d'etre implémenté  : " + ligne;
                System.out.println(message);
                return message;
        }
    }
}
