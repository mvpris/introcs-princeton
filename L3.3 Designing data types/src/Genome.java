public class Genome {
    private int n;
    private char[] genome = new char[2];

    public void resize() {
        char[] temp = new char[2 * n];
        System.arraycopy(genome, 0, temp, 0, genome.length);
        genome = temp;
    }

    public void addNucleotide(char c) {
        if (c != 'A' && c != 'C' && c != 'G' && c != 'T')
            throw new IllegalArgumentException("Nucleotide is not valid.");
        if (n == genome.length) resize();
        genome[n++] = c;
    }

    public char nucleotideAt(int i) {
        if (i < 0 || i >= genome.length)
            throw new ArrayIndexOutOfBoundsException("Nucleotide position is out of bounds.");
        return genome[i];
    }

    public int length() {
        return n;
    }

    public String getGenome() {
        String dna = "";
        for (char nucleotide : genome) {
            dna += nucleotide;
        }
        return dna;
    }

    public static void main(String[] args) {
        Genome genome = new Genome();
        genome.addNucleotide('A');
        genome.addNucleotide('C');
        genome.addNucleotide('G');
        genome.addNucleotide('T');
        System.out.println("Nucleotide at position 1 is = " + genome.nucleotideAt(1));
        System.out.println("Genome is = " + genome.getGenome());
    }
}
