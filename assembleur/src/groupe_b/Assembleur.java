package groupe_b;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Florian Latapie
 */
public class Assembleur {
    static boolean displayLinesInOutput = false;
    static boolean outputHex = !displayLinesInOutput;
    static boolean supressionDesBinAvantExec = false;


    public static void main(String[] args) throws IOException {

        String dossierDExec = System.getProperty("user.dir") + "\\files\\";
        System.out.println("Recherche de fichers '*.s' dans " + dossierDExec);
        File fichiersDuDossierDExec = new File(dossierDExec);
        List<String> tousLesFichiersS = Stream.of(Objects.requireNonNull(fichiersDuDossierDExec.list())).filter(file -> file.endsWith(".s")).toList();

        if (supressionDesBinAvantExec) {
            List<String> tousLesFichiersBin = Stream.of(Objects.requireNonNull(fichiersDuDossierDExec.list())).filter(file -> file.endsWith(".bin")).toList();
            tousLesFichiersBin.forEach(fichier -> {
                String fichierASupprimer = dossierDExec + fichier;
                System.out.println("Suppression de : " + fichierASupprimer);
                new File(fichierASupprimer).delete();
            });
        }
        System.out.println("fichiers a convertir : " + tousLesFichiersS);

        for (String nomDuFichier : tousLesFichiersS) {
            int compteLigne = 0;
            int compteLigneDico = 0;
            Map<String, Integer> dicoLabelLigne = new HashMap<>();

            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                String cheminDuFichierDEntree = dossierDExec + nomDuFichier;
                String cheminDuFichierDeSortie = cheminDuFichierDEntree.substring(0, cheminDuFichierDEntree.length() - 2) + ".bin";
                System.out.println("\n" + cheminDuFichierDEntree);
                reader = new BufferedReader(new FileReader(cheminDuFichierDEntree));
                writer = new BufferedWriter(new FileWriter(cheminDuFichierDeSortie));

                String ligne;
                afficherEtEcrire(writer, "v2.0 raw" + System.lineSeparator());
                while ((ligne = reader.readLine()) != null) {
                    remplirDico(ligne, dicoLabelLigne, compteLigneDico);
                    compteLigneDico++;
                }

                reader = new BufferedReader(new FileReader(cheminDuFichierDEntree));
                while ((ligne = reader.readLine()) != null) {
                    traiterLigne(writer, ligne, dicoLabelLigne, compteLigne);
                    compteLigne++;
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

    private static void remplirDico(String ligne, Map<String, Integer> dicoLabelLigne, int numeroLigne) {
        ligne = ligne.trim();
        ligne = ligne.replace("\t", " ");
        if (estLabel(ligne)) {
            dicoLabelLigne.put(ligne.substring(0, ligne.length() - 1).toLowerCase(Locale.ROOT), numeroLigne);

        }
    }

    private static boolean estLabel(String ligne) {
        if (ligne.isEmpty()) return false;
        if (ligne.charAt(0) == '.') {
            if (ligne.charAt(ligne.length() - 1) == ':') {
                return true;
            }
        }
        return false;
    }

    private static void traiterLigne(BufferedWriter writer, String ligne, Map<String, Integer> dicoLabelLigne, int numeroLigne) throws Exception {
        ligne = ligne.trim();
        ligne = ligne.replace("\t", " ");
        if (estLigneValide(ligne)) {
            String binaryString = convertirVersBinaire(ligne, dicoLabelLigne, numeroLigne);
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

            if (displayLinesInOutput) {
                afficherEtEcrire(writer, " l" + numeroLigne + " : " + Fonctions.padLeftZeros(binaryString, 4) + " ");
            } else {
                afficherEtEcrire(writer, Fonctions.padLeftZeros(binaryString, 4) + " ");
            }
        }
    }

    private static boolean estLigneValide(String ligne) throws Exception {
        if (ligne.isEmpty()) return false;
        ligne = ligne.trim();
        if (ligne.startsWith("@")) return false;
        if (ligne.charAt(0) == '.') return false;
        if (ligne.startsWith("add r7")) return false;
        if (ligne.startsWith("push")) return false;
        if (ligne.startsWith("run:")) return false;

        return true;
    }

    private static void afficherEtEcrire(BufferedWriter writer, String ligne) throws IOException {
        System.out.print(ligne);
        writer.write(ligne);
    }

    private static String convertirVersBinaire(String ligne, Map<String, Integer> dicoLabelLigne, int numeroLigne) throws Exception {
        ligne = ligne.replace("\t", " ");
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
            case "b":
                return Fonctions.unconditionalBranch(ligne, dicoLabelLigne, numeroLigne);
            case "beq":
                return Fonctions.beq(ligne, dicoLabelLigne, numeroLigne);
            case "bne":
                return Fonctions.bne(ligne, dicoLabelLigne, numeroLigne);
            case "bcs":
                return Fonctions.bcs(ligne, dicoLabelLigne, numeroLigne);
            case "bhs":
                return Fonctions.bhs(ligne, dicoLabelLigne, numeroLigne);
            case "bcc":
                return Fonctions.bcc(ligne, dicoLabelLigne, numeroLigne);
            case "blo":
                return Fonctions.blo(ligne, dicoLabelLigne, numeroLigne);
            case "bmi":
                return Fonctions.bmi(ligne, dicoLabelLigne, numeroLigne);
            case "bpl":
                return Fonctions.bpl(ligne, dicoLabelLigne, numeroLigne);
            case "bvs":
                return Fonctions.bvs(ligne, dicoLabelLigne, numeroLigne);
            case "bvc":
                return Fonctions.bvc(ligne, dicoLabelLigne, numeroLigne);
            case "bhi":
                return Fonctions.bhi(ligne, dicoLabelLigne, numeroLigne);
            case "bls":
                return Fonctions.bls(ligne, dicoLabelLigne, numeroLigne);
            case "bge":
                return Fonctions.bge(ligne, dicoLabelLigne, numeroLigne);
            case "blt":
                return Fonctions.blt(ligne, dicoLabelLigne, numeroLigne);
            case "bgt":
                return Fonctions.bgt(ligne, dicoLabelLigne, numeroLigne);
            case "ble":
                return Fonctions.ble(ligne, dicoLabelLigne, numeroLigne);
            case "bal":
                return Fonctions.bal(ligne, dicoLabelLigne, numeroLigne);
            default:
                String message = "\ninstruction a besoin d'etre implémenté  : '" + ligne + "'";
                System.out.println(message);
                return message;
        }
    }
}