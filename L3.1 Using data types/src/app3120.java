public class app3120 {
    public static String[] gene(String dna) {
        String[] t = new String[10000];
        int count = 0;

        for (int i = 0; i < dna.length() - 3; i++) {
            String startCodon = dna.substring(i, i + 3);
            if (startCodon.equals("ATG")) {
                for (int j = i + 3; j <= dna.length() - 3; j++) {
                    String endCodon = dna.substring(j, j + 3);
                    if (endCodon.equals("TAA") || endCodon.equals("TAG") || endCodon.equals("TGA")) {
                        String codon = dna.substring(i, j + 3);
                        if (isPotentialGene(codon)) {
                            t[count] = codon;
                            count++;
                        }
                    }
                }
            }
        }

        String[] s = new String[count];
        System.arraycopy(t, 0, s, 0, s.length);
        return s;
    }

    public static boolean isPotentialGene(String dna) {
        if (dna.length() % 3 != 0) return false;
        if (!dna.startsWith("ATG")) return false;
        for (int i = 3; i < dna.length() - 3; i++) {
            if (i % 3 == 0) {
                String codon = dna.substring(i, i + 3);
                if (codon.equals("TAA")) return false;
                if (codon.equals("TAG")) return false;
                if (codon.equals("TGA")) return false;
            }
        }
        if (dna.endsWith("TAA")) return true;
        if (dna.endsWith("TAG")) return true;
        if (dna.endsWith("TGA")) return true;
        return false;
    }

    public static void main(String[] args) {
//          for gene method:
//        String dna = args[0];
//        String[] s = gene(dna);
//        for (String value : s) {
//            System.out.println(value);
//        }

        String s = args[0];
        int minCodonLength = Integer.parseInt(args[1]);
        for (int i = 0; i < s.length() - minCodonLength; i++) {
            for (int j = i + minCodonLength; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPotentialGene(sub)) {
                    System.out.println(sub);
                }
            }
        }
    }
}
