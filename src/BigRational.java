import java.math.BigInteger;
public class BigRational implements Comparable<BigRational> {

    // Data fields for numerator and denominator

    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");
    
    /** Construct a rational with default properties */
    public BigRational() {
        this(0,1);
        numerator.setBit(0);
        denominator.setBit(1);
    }

    /** Construct a rational with specified numerator and denominator */
    public BigRational(BigInteger numerator, BigInteger denominator) {
        if (denominator.intValue() == 0)
            throw new ArithmeticException("Rational number with denominator zero");
        BigInteger gcd = gcd(numerator, denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.abs();
        denominator = denominator.divide(gcd);
    }

    public BigRational(int n, int d) {
        numerator.setBit(n);
        denominator.setBit(d);
        if (denominator.intValue() == 0)
            throw new ArithmeticException("Rational number with denominator zero");
        BigInteger gcd = gcd(numerator, denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.abs();
        denominator = denominator.divide(gcd);
    }
    /** Find GCD of two number s*/
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        return fastGcd(n, d);
    }

    /** Use Euclid's algorithm to compute a GCD.*/
    private static BigInteger fastGcd(BigInteger m, BigInteger n)
    // Assumes m and n are non-negative
    {
        if (m.intValue() == 0)
            return n;
        if (n.intValue() == 0)
            return m;
        m = m.abs();
        n = n.abs();
        while (true)
        {
            BigInteger r = m.remainder(n);
            if (r.intValue() == 0)
                return n;
            m = n;
            n = r;
        }
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }


    /** Add a rational number to this rational */
    public BigRational add(BigRational secondRational) {
        BigInteger n = new BigInteger("0");
        BigInteger d = new BigInteger("1");
        n.equals(numerator.multiply(secondRational.getDenominator())
                .add(denominator.multiply(secondRational.getNumerator())));
        d.equals(denominator.multiply(secondRational.getDenominator()));
        return new BigRational(n, d);
    }

    /** Subtract a rational number from this rational */
    public BigRational subtract(BigRational secondRational) {
        BigInteger n = new BigInteger("0");
        BigInteger d = new BigInteger("1");
        n.add(numerator.multiply(secondRational.getDenominator()));
        n.subtract(denominator.multiply(secondRational.getNumerator()));
        d.add(denominator.multiply(secondRational.getDenominator()));
        return new BigRational(n, d);
    }
    /*
    /** Multiply a rational number to this rational
    public BigRational multiply(BigRational secondRational) {
        BigInteger n = new BigInteger("0");
        BigInteger d = new BigInteger("0");
        n = numerator.multiply(secondRational.getNumerator());
        d = denominator.multiply(secondRational.getDenominator());
        return new BigRational(n, d);
    }

    /** Divide a rational number from this rational
    public BigRational divide(BigRational secondRational) {
        BigInteger n = new BigInteger("0");
        BigInteger d = new BigInteger("0");
        n = numerator.multiply(secondRational.getDenominator());
        d = denominator.multiply(secondRational.numerator);
        return new BigRational(n, d);
    }*/

    @Override
    public String toString() {
        if (denominator.intValue() == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        BigInteger temp = new BigInteger("1");
        temp = numerator.subtract((((BigRational)(other))).getNumerator());
        if (temp.intValue() == 0)
            return true;
        else
            return false;
    }

    // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float)doubleValue();
    }

    // Implement the doubleValue method in Number
    public double doubleValue() {
        BigInteger temp = new BigInteger("0");
        temp = numerator.divide(denominator);
        return temp.doubleValue();
    }

    // Implement the abstract intValue method in Number
    public int intValue() {
        BigInteger temp = new BigInteger("0");
        temp = numerator.divide(denominator);
        return temp.intValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(BigRational o) {
        BigInteger temp = new BigInteger("0");
        temp = numerator.subtract(o.getNumerator());
        if (temp.intValue() > 0)
            return 1;
        else if (temp.intValue() < 0)
            return -1;
        else
            return 0;
    }
}