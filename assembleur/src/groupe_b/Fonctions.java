package groupe_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Florian Latapie
 */
public class Fonctions {
    static String s010000 = "010000";

    private static List<String> instructionVersListe(String instruction) throws Exception {
        List<String> arguments = new ArrayList<>(List.of(instruction.split(" ")));
        if (arguments.size() != 3) {
            throw new Exception("instruction ands incorrecte : " + instruction);
        }
        for (int i = 0; i < arguments.size(); i++) {
            arguments.set(i, arguments.get(i).toLowerCase(Locale.ROOT).replace(",", "").replace("#", "").replace("r",""));
        }
        return arguments;
    }

    public static String ands(String instruction) throws Exception {
        List<String> arguments = instructionVersListe(instruction);

        String codop = "0000";
        String Rm = arguments.get(1);
        String Rdn = arguments.get(2);

        return s010000 + codop + Rm + Rdn;
    }

    /*public static String sub(String ligne) throws Exception {
        List<String> arguments = instructionVersListe(ligne);
        return "'sub' not yet implemented : " + ligne;
    }*/

    public static String movs(String ligne) throws Exception {
        String s001 = "001";
        String s00 =  "00";
        List<String> args = instructionVersListe(ligne);
        String rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String imm8 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 8);;

        /*System.out.println(s001 +" : " + s001.length());
        System.out.println(s00 +" : " + s00.length());
        System.out.println(rd +" : " + rd.length());
        System.out.println(imm8 +" : " + imm8.length());*/

        return s001 + s00 + rd + imm8;
    }

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
}
