package groupe_b;

import static groupe_b.Assembleur.caractereEspacement;
import static groupe_b.Fonctions.padLeftZeros;

public class HexToBinary {
    public static void main(String[] args) {
        String entree = "2000 2101 2214 4288 d4ff e7ff 4252 428a dbff e000 2032 e7f4 1883 ";
        String[] hex = entree.split(" ");

        for (int i = 0; i < hex.length; i++) {
            System.out.print(padLeftZeros(Integer.toBinaryString(Integer.parseInt(hex[i], 16)), 16)+ caractereEspacement);
        }

    }
}
