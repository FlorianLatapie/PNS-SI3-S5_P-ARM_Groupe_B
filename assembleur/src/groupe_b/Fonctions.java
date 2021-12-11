package groupe_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Florian Latapie
 */
public class Fonctions {
    static String s010000 = "010000";
    static String erreur_instruction_ = "Erreur instruction ";

    // méthodes java

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

    //

    public static List<String> instructionVersListe(String instruction) {
        List<String> arguments = new ArrayList<>(List.of(instruction.split(" ")));

        for (int i = 0; i < arguments.size(); i++) {
            arguments.set(
                    i,
                    arguments.get(i)
                            .toLowerCase(Locale.ROOT)
                            .replace(",", "")
                            .replace("#", "")
                            .replace("r", ""));
        }
        return arguments;
    }

    // instructions avec décodage commun

    public static String instructionCodopRdnRm(String ligne, String codop) throws Exception {
        List<String> args = instructionVersListe(ligne);

        String Rdn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 3);

        return s010000 + codop + Rm + Rdn;
    }

    public static String instructionImm5RmRd(String ligne, String case2) throws Exception {
        if (case2.length() != 2) {
            return erreur_instruction_ + ligne;
        }
        List<String> args = instructionVersListe(ligne);
        String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 3);
        String imm5 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(3))), 5);

        return "000" + case2 + imm5 + Rm + Rd;
    }

    public static String instructionRdImm8(String ligne, String case2) throws Exception {
        List<String> args = instructionVersListe(ligne);
        String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String imm8 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 8);

        return "001" + case2 + Rd + imm8;
    }

    public static String addSub(String ligne, String registerImmediate, String addSub) throws Exception {
        if (registerImmediate.length() != 1 || addSub.length() != 1) {
            return erreur_instruction_ + ligne;
        }
        List<String> args = instructionVersListe(ligne);

        if (args.size() == 4) {
            String Rd = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
            String Rn = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2))), 3);
            String Rm = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(3))), 3);
            return "000" + "11" + registerImmediate + addSub + Rm + Rn + Rd;
        } else {
            return  erreur_instruction_ + "(nb d'args mauvais) : " + ligne;
        }
    }

    // instructions avec meme entete

    public static String lsls(String ligne) throws Exception {
        if (ligne.contains("#")) {
            return lslImmediate(ligne);
        } else {
            return lslRegister(ligne);
        }
    }

    public static String lsrs(String ligne) throws Exception {
        if (ligne.contains("#")) {
            return lsrImmediate(ligne);
        } else {
            return lsrRegister(ligne);
        }
    }

    public static String asrs(String ligne) throws Exception {
        if (ligne.contains("#")) {
            return asrImmediate(ligne);
        } else {
            return asrRegister(ligne);
        }
    }

    public static String adds(String ligne) throws Exception {
        if (ligne.contains("#")) {
            List<String> args = instructionVersListe(ligne);
            if (args.size() == 4) {
                return addImmediate3bits(ligne);
            } else if (args.size() == 3) {
                return addImmediate8bits(ligne);
            }
        } else {
            return addRegister(ligne);
        }
        return erreur_instruction_ + ligne;
    }

    public static String subs(String ligne) throws Exception {
        if (ligne.contains("#")) {
            List<String> args = instructionVersListe(ligne);
            if (args.size() == 4) {
                return subImmediate3bits(ligne);
            } else if (args.size() == 3) {
                return subImmediate8bits(ligne);
            }
        } else {
            return subRegister(ligne);
        }
        return erreur_instruction_ + ligne;
    }

    public static String cmp(String ligne) throws Exception {
        if (ligne.contains("#")) {
            return cmpImmediate(ligne);
        } else {
            return cmpRegister(ligne);
        }
    }

    public static String add(String ligne) throws Exception {
        if (instructionVersListe(ligne).size() == 4) {
            return addImmediate4args(ligne);
        }
        return addImmediate(ligne);
    }


    // instructions individuelles

    // 9.1.1.1 LSL (immediate) : Logical Shift Left (p. 282)
    // LSLS <Rd>, <Rm>, #<imm5>
    // 000 00 imm5 Rm Rd
    private static String lslImmediate(String ligne) throws Exception {
        return instructionImm5RmRd(ligne, "00");
    }

    // 9.1.1.2 LSR (immediate) : Logical Shift Right (p. 284)
    // LSRS <Rd>, <Rm>, #<imm5>
    // 000 01 imm5 Rm Rd
    private static String lsrImmediate(String ligne) throws Exception {
        return instructionImm5RmRd(ligne, "01");
    }

    // 9.1.1.3 ASR (immediate) : Arithmetic Shift Right (p. 203)
    // ASRS <Rd>, <Rm>, #<imm5>
    // 000 10 imm5 Rm Rd
    private static String asrImmediate(String ligne) throws Exception {
        return instructionImm5RmRd(ligne, "10");
    }

    // 9.1.1.4 ADD (register) : Add register (p. 192)
    // ADDS <Rd>, <Rn>, <Rm>
    // 000 11 0 0 Rm Rn Rd
    private static String addRegister(String ligne) throws Exception {
        return addSub(ligne, "0", "0");
    }

    // 9.1.1.5 SUB (register) : Substract register (p. 404)
    // SUBS <Rd>, <Rn>, <Rm>
    // 000 11 0 1 Rm Rn Rd
    private static String subRegister(String ligne) throws Exception {
        return addSub(ligne, "0", "1");
    }

    // 9.1.1.6 ADD (immediate) : Add 3-bit immediate (p. 190)
    // ADDS <Rd>, <Rn>, <#imm3>
    // 000 11 1 0 Rm Rn Rd
    private static String addImmediate3bits(String ligne) throws Exception {
        return addSub(ligne, "1", "0");
    }

    // 9.1.1.7 SUB (immediate) : Subtract 3-bit immediate (p. 402)
    // SUBS <Rd>, <Rn>, #<imm3>
    // 000 11 1 1 Rm Rn Rd
    private static String subImmediate3bits(String ligne) throws Exception {
        return addSub(ligne, "1", "1");
    }

    // 9.1.1.8 MOV (immediate) : Move (p. 291)
    // MOVS <Rd>, #<imm8>
    // 001 00 Rd imm8
    public static String movs(String ligne) throws Exception {
        if (ligne.contains("#")){
            return instructionRdImm8(ligne, "00");
        } else {
            ligne += ", #0";
            return instructionImm5RmRd(ligne, "00");
        }
    }

    // 9.1.1.9 CMP (immediate) : Compare (p. 223)
    // CMP <Rd>, #<imm8>
    // 001 01 Rd imm8
    private static String cmpImmediate(String ligne) throws Exception {
        return instructionRdImm8(ligne, "01");
    }

    // 9.1.1.10 ADD (immediate) : Add 8-bit immediate (p. 190)
    // ADDS <Rdn >, [ <Rdn>, ] #<imm8>
    // 001 10 Rd imm8
    private static String addImmediate8bits(String ligne) throws Exception {
        return instructionRdImm8(ligne, "10");
    }

    // 9.1.1.11 SUB (immediate) : Subtract 8-bit immediate (p. 402)
    // SUBS <Rdn>, [ <Rdn >, ] #<imm8>
    // 001 11 Rd imm8
    private static String subImmediate8bits(String ligne) throws Exception {
        return instructionRdImm8(ligne, "11");
    }

    // Data Processing

    // 9.1.2.1 AND (register) : Bitwise AND (p. 201)
    // ANDS <Rdn>, <Rm>
    // 010000 0000 Rm Rdn
    public static String ands(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0000");
    }

    // 9.1.2.2 EOR (register) : Exclusive OR (p. 233)
    // EORS <Rdn>, <Rm>
    // 010000 0001 Rm Rdn
    public static String eors(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0001");
    }

    // 9.1.2.3 LSL (register) : Logical Shift Left (p. 283)
    // LSLS <Rdn>, <Rm>
    // 010000 0010 Rm Rdn
    private static String lslRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0010");
    }

    // 9.1.2.4 LSR (register) : Logical Shift Right (p. 285)
    // LSRS <Rdn>, <Rm>
    // 010000 0011 Rm Rdn
    private static String lsrRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0011");
    }

    // 9.1.2.5 ASR (register) : Arithmetic Shift Right (p. 204)
    // ASRS <Rdn>, <Rm>
    // 010000 0100 Rm Rdn
    private static String asrRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0100");
    }

    // 9.1.2.6 ADC (register) : Add with Carry (p. 188)
    // ADCS <Rdn>, <Rm>
    // 010000 0101 Rm Rdn
    public static String adcRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0101");
    }

    // 9.1.2.7 SBC (register) : Substract with Carry (p. 347)
    // SBCS <Rdn>, <Rm>
    // 010000 0110 Rm Rdn
    public static String sbcRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0110");
    }

    // 9.1.2.8 ROR (register) : Rotate Right (p. 339)
    // RORS <Rdn>, <Rm>
    // 010000 0111 Rm Rdn
    public static String rorRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "0111");
    }

    // 9.1.2.9 TST (register) : Set flags on bitwise AND (p. 420)
    // TST <Rn>, <Rm>
    // 010000 1000 Rm Rdn
    public static String tstRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1000");
    }

    // 9.1.2.10 RSB (immediate) : Reverse Substract from 0 (p. 341)
    // RSBS <Rd>, <Rn>, #0
    // 010000 1001 Rm Rdn
    public static String rsbs(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1001");
    }

    // 9.1.2.11 CMP (register) : Compare Registers (p. 224)
    // CMP <Rn>, <Rm>
    // 010000 1010 Rm Rdn
    private static String cmpRegister(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1010");
    }

    // 9.1.2.12 CMN (register) : Compare Negative (p. 222)
    // CMN <Rn>, <Rm>
    // 010000 1011 Rm Rdn
    public static String cmn(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1011");
    }

    // 9.1.2.13 ORR (register) : Logical OR (p. 310)
    // ORRS <Rdn>, <Rm>
    // 010000 1100 Rm Rdn
    public static String orrs(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1100");
    }

    // 9.1.2.14 MUL : Multiply Two Registers (p. 302)
    // MULS <Rdm>, <Rn>, <Rdm>
    // 010000 1101 Rm Rdn
    public static String muls(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1101");
    }

    // 9.1.2.15 BIC (register) : Bit Clear (p. 210)
    // BICS <Rdn>, <Rm>
    // 010000 1110 Rm Rdn
    public static String bics(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1110");
    }

    // 9.1.2.16 MVN (register) : Bitwise NOT (p. 304)
    // MVNS <Rd>, <Rm>
    // 010000 1111 Rm Rdn
    public static String mvns(String ligne) throws Exception {
        return instructionCodopRdnRm(ligne, "1111");
    }

    // load / store

    // 9.1.3.1 STR (immediate) : Store Register (p. 386)
    // STR <Rt>, [SP,#<offset>]
    // 1001 0 Rt imm8
    public static String str(String ligne) throws Exception {
        List<String> args = instructionVersListe(ligne);
        String Rt = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        String imm8ToParse;
        if (args.size() == 4) {
            imm8ToParse = args.get(3).replace("]", "");
        } else {
            imm8ToParse = "0";
        }
        String imm8 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(imm8ToParse) / 4), 8);
        return "1001" + "0" + Rt + imm8;
    }

    // 9.1.3.2 LDR (immediate) : Load Register (p. 246)
    // LDR <Rt >, [SP{, #<offset>}]
    // 1001 1 Rt imm8
    public static String ldr(String ligne) {
        List<String> args = instructionVersListe(ligne);
        String Rt = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(1))), 3);
        if (args.size() == 4) {
            String imm8 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(3).replace("]", "")) / 4), 8);
            return "1001" + "1" + Rt + imm8;
        } else if (args.size() == 3) {
            String imm8 = padLeftZeros("", 8);
            return "1001" + "1" + Rt + imm8;
        }
        else return erreur_instruction_ + ligne;
    }

    // 9.1.4 Miscellaneous 16-bit instructions

    // 9.1.4.1 ADD (SP plus immediate) : Add Immediate to SP (p. 194)
    // ADD [SP,] SP, #<offset>
    // 1011 0000 0 imm7
    private static String addImmediate(String ligne) {
        List<String> args = instructionVersListe(ligne);
        String imm7 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2)) / 4), 7);
        return "1011" + "0000" + "0" + imm7;
    }

    private static String addImmediate4args(String ligne) throws Exception {
        List<String> args = instructionVersListe(ligne);
        String imm7 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(3)) / 4), 7);
        return "1011" + "0000" + "0" + imm7;
    }


    // 9.1.4.2 SUB (SP minus immediate) : Subtract Immediate from SP (p. 402)
    // SUB [SP,] SP, #<offset>
    // 1011 0000 1 imm7
    public static String sub(String ligne) throws Exception {
        List<String> args = instructionVersListe(ligne);
        String imm7 = padLeftZeros(Integer.toBinaryString(Integer.parseInt(args.get(2)) / 4), 7);
        return "1011" + "0000" + "1" + imm7;
    }

    // 9.1.5 Branch

    // 9.1.5.1 B : Conditional Branch (p. 205)
    // B<c> <label>
    // 1101 cond imm8
    public static String conditionalBranch(String ligne, String cond, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        List<String> args = instructionVersListe(ligne);
        if (args.size() != 2){
            return erreur_instruction_ + numeroLigne + ":" + ligne;
        }

        String label = args.get(1).replace(":", "");
        int ligneLabel = dicoeLabelLigne.get(label);

        int nCible = ligneLabel;
        int nSource = numeroLigne;

        int calcul = nCible - nSource -3 ;
        String imm8;
        if (calcul < 0) {
            imm8 = padLeftZeros(Integer.toBinaryString(calcul).substring(24), 8);
        } else {
            imm8 = padLeftZeros(Integer.toBinaryString(calcul), 8);
        }
        return "1101" + cond + imm8;
    }

    // 9.1.5.2 B : Unconditional Branch (p. 205)
    // B <label>
    // 11100 imm11
    public static String unconditionalBranch(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        List<String> args = instructionVersListe(ligne);
        if (args.size() != 2){
            return erreur_instruction_ + numeroLigne + ":" + ligne;
        }

        String label = args.get(1).replace(":", "");
        int ligneLabel = dicoeLabelLigne.get(label);

        int nCible = ligneLabel;
        int nSource = numeroLigne;

        int calcul = nCible - nSource -3 ;
        String imm11;
        if (calcul < 0) {
            imm11 = padLeftZeros(Integer.toBinaryString(calcul).substring(21), 11);
        } else {
            imm11 = padLeftZeros(Integer.toBinaryString(calcul), 11);
        }

        return "11100" + imm11;
    }

    // labels

    public static String beq(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0000", dicoeLabelLigne, numeroLigne);
    }
    public static String bne(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0001", dicoeLabelLigne, numeroLigne);
    }
    public static String bcs(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0010", dicoeLabelLigne, numeroLigne);
    }
    public static String bhs(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0010", dicoeLabelLigne, numeroLigne);
    }
    public static String bcc(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0011", dicoeLabelLigne, numeroLigne);
    }
    public static String blo(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0011", dicoeLabelLigne, numeroLigne);
    }
    public static String bmi(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0100", dicoeLabelLigne, numeroLigne);
    }
    public static String bpl(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0101", dicoeLabelLigne, numeroLigne);
    }
    public static String bvs(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0110", dicoeLabelLigne, numeroLigne);
    }
    public static String bvc(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "0111", dicoeLabelLigne, numeroLigne);
    }
    public static String bhi(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1000", dicoeLabelLigne, numeroLigne);
    }
    public static String bls(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1001", dicoeLabelLigne, numeroLigne);
    }
    public static String bge(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1010", dicoeLabelLigne, numeroLigne);
    }
    public static String blt(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1011", dicoeLabelLigne, numeroLigne);
    }
    public static String bgt(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1100", dicoeLabelLigne, numeroLigne);
    }
    public static String ble(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1101", dicoeLabelLigne, numeroLigne);
    }
    public static String bal(String ligne, Map<String, Integer> dicoeLabelLigne, int numeroLigne) {
        return conditionalBranch(ligne, "1110", dicoeLabelLigne, numeroLigne);
    }
}
