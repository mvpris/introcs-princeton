public class PeriodicTable {
    private final ChemicalElement[] periodicTable;

    public PeriodicTable(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        periodicTable = new ChemicalElement[n];
        for (int i = 0; i < n; i++) {
            String name = in.readString();
            int number = in.readInt();
            String symbol = in.readString();
            double mass = in.readDouble();
            periodicTable[i] = new ChemicalElement(name, number, symbol, mass);
        }
    }

    public double getMolecularWeight(String molecule) {
        double weight = 0.0;
        String element = "";
        int count = 0;

        for (int i = 0; i < molecule.length(); i++) {
            char c = molecule.charAt(i);

            if (Character.isDigit(c)) {
                count = (count * 10) + Character.getNumericValue(c);
            } else if (Character.isUpperCase(c)) {
                weight += getElementWeight(element) * (count == 0 ? 1 : count);
                element = String.valueOf(c);
                count = 0;
            } else if (Character.isLowerCase(c)) {
                element += c;
            }
        }

        weight += getElementWeight(element) * (count == 0 ? 1 : count);

        return weight;
    }

    private double getElementWeight(String symbol) {
        for (ChemicalElement element : periodicTable) {
            if (element.getSymbol().equals(symbol)) {
                return element.getMass();
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        PeriodicTable pt = new PeriodicTable("elements.txt");
        System.out.println(pt.getMolecularWeight(args[0]));
    }
}
