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
    static boolean outputHex = true;

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
                    if (outputHex) {
                        int decimal = Integer.parseInt(binaryString, 2);
                        binaryString = Integer.toString(decimal, 16);
                    }
                }
                afficherEtEcrire(writer, Fonctions.padLeftZeros(binaryString,4) + " ");
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
            case "lsls":
                return Fonctions.lsls(ligne);
            case "lsrs":
                return Fonctions.lsrs(ligne);
            case "asrs":
                return Fonctions.asrs(ligne);
            case "adds":
                return Fonctions.adds(ligne);
            case "subs":
                return Fonctions.subs(ligne);
            case "cmp":
                return Fonctions.cmp(ligne);
            case "movs":
                return Fonctions.movs(ligne);
            case "ands":
                return Fonctions.ands(ligne);
            case "eors":
                return Fonctions.eors(ligne);
            case "adcs":
                return Fonctions.adcRegister(ligne);
            case "sbcs":
                return Fonctions.sbcRegister(ligne);
            case "rors":
                return Fonctions.rorRegister(ligne);
            case "tst":
                return Fonctions.tstRegister(ligne);
            case "rsbs":
                return Fonctions.rsbs(ligne);
            case "cmn":
                return Fonctions.cmn(ligne);
            case "orrs":
                return Fonctions.orrs(ligne);
            case "muls":
                return Fonctions.muls(ligne);
            case "bics":
                return Fonctions.bics(ligne);
            case "mvns":
                return Fonctions.mvns(ligne);
            case "str":
                return Fonctions.str(ligne);
            case "ldr":
                return Fonctions.ldr(ligne);
            case "add":
                return Fonctions.add(ligne);
            case "sub":
                return Fonctions.sub(ligne);

            default:
                String message = "\ninstruction a besoin d'etre implémenté  : '" + ligne + "'";
                System.out.println(message);
                return message;
        }
    }
}
