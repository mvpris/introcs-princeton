public class ChemicalElement {
    private final String name;
    private final int number;
    private final String symbol;
    private final double mass;

    public ChemicalElement(String name, int number, String symbol, double mass) {
        this.name = name;
        this.number = number;
        this.symbol = symbol;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMass() {
        return mass;
    }

    public static void main(String[] args) {
        ChemicalElement hydrogen = new ChemicalElement("Hydrogen", 1, "H", 1.0078);
        System.out.println(hydrogen.mass);
    }
}
