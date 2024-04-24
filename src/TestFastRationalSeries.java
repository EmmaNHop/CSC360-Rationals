//Emma Hopkins : this program uses FastRational.java to calculate the sum of a series of fractions
public class TestFastRationalSeries {
    public static void main (String[] args){

        FastRational rational1 = new FastRational(1,2);

        for(int i = 2; i < 100; i++){
            FastRational rational2 = new FastRational(i,i+1);
            rational1 = rational1.add(rational2);
        }

        System.out.println("Series sum = " + rational1.toString());
        System.out.println("Series sum = " + rational1.doubleValue());
    }
}