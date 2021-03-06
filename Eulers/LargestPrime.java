package Eulers;
import java.util.*;
import java.lang.Number;
import java.math.BigInteger;

/**
 * Write a description of class LargestPrime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LargestPrime
{

    /**
     * Constructor for objects of class LargestPrime
     */
    public LargestPrime()
    {
        clear();
        BigInteger number = new BigInteger("600851475143");
        BigInteger test = new BigInteger("13195");
        System.out.println("Largest Prime Factor: " + largestPrimeFactorQuadMethod(number));
    }

    public BigInteger largestPrimeFactorQuadMethod(BigInteger number) {
        BigInteger a = number;
        BigInteger currentDivisor = new BigInteger("2");
        BigInteger largestDivisor = new BigInteger("0");
        while(!(a.equals(BigInteger.ONE))) {
            if(a.mod(currentDivisor).equals(BigInteger.ZERO)) { //a is divisible by b
                a = a.divide(currentDivisor);
            } else {
                currentDivisor = currentDivisor.add(BigInteger.ONE);
            }
        }
        return currentDivisor;
    }
    
    

    public boolean isPrime(BigInteger number) {
        BigInteger half = (number).divide(new BigInteger("2"));
        for (BigInteger bi = half; bi.compareTo(BigInteger.ONE) > 0; bi = bi.subtract(BigInteger.ONE)) {
            if((number.mod(bi)).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList listOfFactors(BigInteger number) {
        ArrayList factors = new ArrayList();

        for (BigInteger bi = BigInteger.valueOf(1); bi.compareTo(number) < 0; bi = bi.add(BigInteger.ONE)) {
            if(number.mod(bi).equals(BigInteger.ZERO) && !(factors.contains(bi))) {
                factors.add(bi);
            }
        }
        return factors;
    }

    //Helper Functions
    public int sum(ArrayList array) {
        int arrayLength = array.size();
        int currentSum = 0;
        for(int i = 0; i<array.size(); i++) {
            currentSum = currentSum + ((Integer) array.get(i));
        }
        return currentSum;
    }

    public int sum(int[] array) {
        int arrayLength = array.length;
        int currentSum = 0;
        for(int i = 0; i<array.length; i++) {
            currentSum = currentSum + array[i];
        }
        return currentSum;
    }

    public void printArray(int[] array) {
        System.out.println("Here is Your Array!");
        for (int i = 0; i<array.length; i++) {
            boolean lastTurn = (i==array.length-1);
            if (lastTurn) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    public void clear() {
        System.out.println("\f");
    }
}
