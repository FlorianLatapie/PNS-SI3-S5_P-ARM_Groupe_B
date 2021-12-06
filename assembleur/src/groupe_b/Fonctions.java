package groupe_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Florian Latapie
 */
public class Fonctions {
    static String s010000 = "010000";

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    private static List<String> instructionVersListe(String instruction) throws Exception {
        List<String> arguments = new ArrayList<>(List.of(instruction.split(" ")));
        if (arguments.size() != 3) {
            throw new Exception("instruction ands incorrecte : " + instruction);
        }
        for (int i = 0; i < arguments.size(); i++) {
            arguments.set(i, arguments.get(i).toLowerCase(Locale.ROOT).replace(",", "").replace("#", "").replace("r", ""));
        }
        return arguments;
    }

    public static String movs(String ligne) throws Exception {
        String s001 = "001";
        String s00 = "00";
        List<String> args = instructionVersListe(ligne);
        String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String imm8 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 8);

        return s001 + s00 + Rd + imm8;
    }


    public static String subs(String ligne) throws Exception {
        if (ligne.contains("#")) {
            return subImmediate3bits(ligne);
        } else if (ligne.contains("[") && ligne.contains("]")) {
            return subImmediate8bits(ligne);
        } else {
            return subRegister(ligne);
        }
    }

    private static String subRegister(String ligne) throws Exception{
        List<String> args = instructionVersListe(ligne);
        String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String Rn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(3))), 3);
        return 000 + 11 + 0 + 1 + Rm + Rn + Rd;
    }

    private static String subImmediate8bits(String ligne) throws Exception {
        List<String> args = instructionVersListe(ligne);
        String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String imm8 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 8);
        return 001 + 11 + Rd + imm8;
    }

    public static String subImmediate3bits(String ligne) throws Exception {
        List<String> args = instructionVersListe(ligne);
        String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String Rn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 3);
        String imm3 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(3))), 3);
        return "000" + "11" + "1" + "1" + imm3 + Rn + Rd;
    }

    public static String instructionCodopRdnRm(String ligne, String codop) throws Exception{
        List<String> args = instructionVersListe(ligne);

        String Rdn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))),3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))),3);

        return s010000 + codop + Rm + Rdn;
    }

    public static String ands(String ligne) throws Exception {
        List<String> args = instructionVersListe(ligne);

        String codop = "0000";
        String Rdn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))),3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))),3);

        return s010000 + codop + Rm + Rdn;
    }

    public static String eors(String ligne) throws Exception{
        List<String> args = instructionVersListe(ligne);

        String codop = "0001";
        String Rdn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))),3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))),3);

        return s010000 + codop + Rm + Rdn;
    }

    public static String lsls(String ligne) throws Exception{
        List<String> args = instructionVersListe(ligne);

        String codop = "0010";
        String Rdn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))),3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))),3);

        return s010000 + codop + Rm + Rdn;
    }

    public static String lsrs(String ligne) throws Exception{
        List<String> args = instructionVersListe(ligne);

        String codop = "0011";
        String Rdn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))),3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))),3);

        return s010000 + codop + Rm + Rdn;
    }
}
