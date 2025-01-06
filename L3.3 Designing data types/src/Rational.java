public class Rational {
    private final int num, den;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator should not be equal to zero.");
//        assert denominator != 0 : "Denominator should not be equal to zero.";
        int gcd = Euclid.gcd(numerator, denominator);
        num = numerator / gcd;
        den = denominator / gcd;
    }

    public Rational plus(Rational b) {
        int numerator = num * b.den + b.num * den;
        int denominator = den * b.den;
        return new Rational(numerator, denominator);
    }

    public Rational minus(Rational b) {
        int numerator = num * b.den - b.num * den;
        int denominator = den * b.den;
        return new Rational(numerator, denominator);
    }

    public Rational times(Rational b) {
        return new Rational(num * b.num, den * b.den);
    }

    public Rational divides(Rational b) {
        return new Rational(num * b.den, den * b.num);
    }

    public String toString() {
        return num + "/" + den;
    }

    public static void main(String[] args) {
        Rational x = new Rational(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Rational y = new Rational(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        Rational zplus = x.plus(y);
        Rational zminus = x.minus(y);
        Rational ztimes = x.times(y);
        Rational zdivides = x.divides(y);
        System.out.println("x+y=" + zplus.toString());
        System.out.println("x-y=" + zminus.toString());
        System.out.println("x*y=" + ztimes.toString());
        System.out.println("x/y=" + zdivides.toString());
    }
}
