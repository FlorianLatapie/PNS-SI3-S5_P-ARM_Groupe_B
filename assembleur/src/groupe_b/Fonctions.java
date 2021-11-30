package groupe_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Florian Latapie
 */
public class Fonctions {
    static String s010000 = "010000";

    private static List<String> ThreeArgsInstructionWithHashtagOn2ndArgToList(String instruction) throws Exception {
        List<String> arguments = new ArrayList<>(List.of(instruction.split(" ")));
        if (arguments.size() != 3) {
            throw new Exception("instruction ands incorrecte : " + instruction);
        }
        for (int i = 0; i < arguments.size(); i++) {
            arguments.set(i, arguments.get(i).toLowerCase(Locale.ROOT).replace(",", "").replace("#", ""));
        }
        return arguments;
    }

    private static List<String> ThreeArgsInstructionToList(String instruction) throws Exception {
        List<String> arguments = new ArrayList<>(List.of(instruction.split(" ")));
        if (arguments.size() != 3) {
            throw new Exception("instruction ands incorrecte : " + instruction);
        }
        for (int i = 0; i < arguments.size(); i++) {
            arguments.set(i, arguments.get(i).toLowerCase(Locale.ROOT).replace(",", ""));
        }
        return arguments;
    }

    public static String ands(String instruction) throws Exception {
        List<String> arguments = ThreeArgsInstructionToList(instruction);

        String codop = "0000";
        String Rm = arguments.get(1);
        String Rdn = arguments.get(2);

        return s010000 + codop + Rm + Rdn;
    }

    public static String sub(String ligne) throws Exception {
        List<String> arguments = ThreeArgsInstructionWithHashtagOn2ndArgToList(ligne);
        return "'sub' not yet implemented : " + ligne;
    }
}
