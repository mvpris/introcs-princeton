public class StringGenome {
    private String genome = "";

    public void addNucleotide(char c) {
        if (c != 'A' && c != 'C' && c != 'G' && c != 'T')
            throw new IllegalArgumentException("Nucleotide is not valid.");
        genome += c;
    }

    public char nucleotideAt(int i) {
        if (i < 0 || i >= genome.length())
            throw new IndexOutOfBoundsException("Nucleotide position is out of bounds.");
        return genome.charAt(i);
    }

    public boolean isPotentialGene(String dna) {
//        Length is a multiple of 3.
        if (dna.length() % 3 != 0) return false;

//        Starts with start codon.
        if (!dna.startsWith("ATG")) return false;

//        No intervening stop codons.
        for (int i = 3; i < dna.length() - 3; i++) {
            if (i % 3 == 0) {
                String codon = dna.substring(i, i + 3);
                if (codon.equals("TAA")) return false;
                if (codon.equals("TAG")) return false;
                if (codon.equals("TGA")) return false;
            }
        }

//        Ends with a stop codon.
        if (dna.endsWith("TAA")) return true;
        if (dna.endsWith("TAG")) return true;
        if (dna.endsWith("TGA")) return true;
        return false;
    }

    public void addCodon(String codon) {
//        if (!isPotentialGene(codon))
//            throw new IllegalArgumentException("Codon is not valid.");
//        else genome += codon;
        if (isPotentialGene(codon)) genome += codon;
    }

    public String getGenome() {
        return genome;
    }

    public static void main(String[] args) {
        StringGenome genome = new StringGenome();
        genome.addNucleotide('A');
        genome.addNucleotide('C');
        genome.addNucleotide('G');
        genome.addNucleotide('T');
        System.out.println("Nucleotide at position 1 is = " + genome.nucleotideAt(1));
        String codon = "ATGAAATAA";
        String codonInvalid = "ATGAAAAAA";
        genome.addCodon(codon);
        genome.addCodon(codonInvalid);
        System.out.println("Genome is = " + genome.getGenome());
    }
}
