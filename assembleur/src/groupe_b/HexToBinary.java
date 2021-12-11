package groupe_b;

import static groupe_b.Assembleur.caractereEspacement;
import static groupe_b.Fonctions.padLeftZeros;

public class HexToBinary {
    public static void main(String[] args) {
        String entree = "b099 b0ff b0f1 2000 9003 2001 9002 2002 9001 2003 9000 e7fe 980e 9903 4288 d104 e7fe 980c 990d 1840 900a e01f 980e 9902 4288 d104 e7fe 980c 990d 1a40 900a e014 980e 9901 4288 d104 e7fe 980c 990d 4341 910a e009 980e 9900 4288 d104 e7fe 980c 990d 4088 900a e7fe e7fe e7fe e7fe e7d2 ";
        String[] hex = entree.split(" ");

        for (int i = 0; i < hex.length; i++) {
            System.out.print(padLeftZeros(Integer.toBinaryString(Integer.parseInt(hex[i], 16)), 16)+ caractereEspacement);
        }

    }
}
