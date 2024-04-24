public class TestBigRational
{
    public static void main (String[] args)
    {
        BigRational big1 = new BigRational(1,2);

        for(int i = 2; i < 100; i++)
        {
            BigRational big2 = new BigRational(i, i + 1);
            big1 = big1.add(big2);
            System.out.println(big1.getDenominator());
            System.out.println(big1.getNumerator());
        }
        System.out.println("series sum = " + big1.toString());
        System.out.println("series sum = " + big1.doubleValue());
    }
}
