# CSC360 Rationals
 
Write a program that uses the FastRational class to compute the
following summation:

1/2 + 2/3 + 3/4 + ... + 98/99 + 99/100

First display the result using its toString method, and then using its doubleValue method. You
will discover that the output is incorrect:

Series sum = 1349247664274259951 / 1822963237492290880
Series sum = 0.7401398100217947

The actual sum should quite a bit larger. The culprit is integer overflow. 

Create a new class called BigRational. Base it on the FastRational class but use
java.math.BigInteger for both the numerator and denominator. This will require that you modify most
or all of the methods from FastRational. For instance, when the operators +, -, *, or / where 
performed on the numerator or denominator, you will now need to use .add, .subtract, .multiply, 
or .divide, respectively. Note that the BigInteger class comes with a gcd method, so use that for 
computing gcds! BigRational must extend Number. In a file called TestBigRationalSeries.java write a 
test program that computes and displays the series as specified in Problem 2. It should work correctly 
this time:

Series sum = 264414864639329557497913717698145082779489 / 2788815009188499086581352357412492142272
Series sum = 94.8126224823604