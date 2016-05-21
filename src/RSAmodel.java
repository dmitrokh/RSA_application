/**
 * @author Dmytro Khelemendyk
 * CS-0026 Discrete Structures
 * 05/2016
 */

//this class is made in jgrasp
import java.nio.charset.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Random;
import java.util.Arrays; //needed to print an array of String without overriding toString() method of Object

public class RSAmodel //Model class (following the VMC implementation)
{
  private static int prime1 = 0, //first prime number to use (choose among first 1000 of prime numbers)
              prime2 = 0, //second prime number to use (choose among first 1000 of prime numbers)
              modN = 0, //variable for the product of p and q, later in calculations - the value of mod
              eexp = 0, //variable for the first exponent (will be used for the public key)  
              dexp = 0, //variable for second exponent in integer, will need as an exponent for decryption
              phi = 0; //variable for the totient of n
  private static Integer[] listOfPrimes;
  //private static ArrayList <Integer> arlE;
  private static ArrayList <BigInteger> arlE;
  private static String plainText; // text to encrypt
  private static String[] keys = new String[4];
  private String[] cipherText; // text to decrypt 
  private static BigInteger prime1BI, //these are the BigInteger versions of the above int variables
                            prime2BI, //see description for the above variables
                            eexpBI,
                            dexpBI,
                            phiBI,
                            modNBI; 
  private static final int MAX_INT_FOR_PRIME = 10000;
  
  public RSAmodel (int p1, int p2) // constructor for creation a new set of keys
  {
    prime1 = p1;
    prime1BI = new BigInteger(Integer.toString(prime1));    
    prime2 = p2;
    prime2BI = new BigInteger(Integer.toString(prime2));
  }  
  
  public RSAmodel (String pT, int e, int n) // constructor for encryption
  {
    plainText = pT;
    eexpBI = new BigInteger(Integer.toString(e));
    modNBI = new BigInteger(Integer.toString(n));
  }  
  
  public RSAmodel (String pT) // constructor for encryption
  {
    plainText = pT;
  }  
  
  public RSAmodel (String[] cT) // constructor for encryption
  {
    cipherText = cT;
  }  
  
  public RSAmodel (String[] cT, int d, int n) // constructor for decryption
  {
    cipherText = cT;
    dexpBI = new BigInteger(Integer.toString(d));
    modNBI = new BigInteger(Integer.toString(n));
  }   
  
  public static boolean isEvenTest(int p) //check that number is not even, if it is - it's not prime
  {
    boolean isEven = false;
    
    if (p % 2 == 0)
    {
      isEven = true;
    }
    
    //System.out.println("isEven for " + p + " is " + isEven);
    return isEven;
  }
  
  // check that the number is prime based on trial division
  public static boolean PrimalityTest (int p) 
  {
    boolean isPrime = true;
    
    if (!isEvenTest(p) || p == 2)
    {
       int sqrtP = (int)Math.round(Math.sqrt(p));
       
       for (int i = 2; i <= sqrtP; i++)
       {
         if (p % i == 0)
         {
           isPrime = false;
         }
       }
    }
    else
    {
      isPrime = false;
    }
    
    //System.out.println("PrimalityTest for " + p + " is " + isPrime);
    return isPrime;
  }
  
  //Builds an ArrayList of numbers that pass the primality test
  public static ArrayList<Integer> buildPrimeArrayList()
  {
    ArrayList<Integer> primes = new ArrayList<>();
    
    for (int i = 1; i < MAX_INT_FOR_PRIME; i++)
    {
      if (PrimalityTest(i))
      {
        primes.add(i);
      }
    }
    
    return primes;
  }
  
  //converts ArrayList of Integers to array of integers to feed it into JComboBox
  public static Integer[] buildPrimeList()
  {
    ArrayList <Integer> arlPrimes = buildPrimeArrayList();
    listOfPrimes = new Integer[arlPrimes.size()];
    for (int i=0; i < listOfPrimes.length; i++)
    {
        listOfPrimes[i] = arlPrimes.get(i).intValue();
    }
    
    return listOfPrimes;
  }
  
  //calculating value of n used for modulus, n is the common part of two keys
  public void modNCalc() 
  {
    RSAtab1.logMessages.append("Calculating modulus...\n");
    modNBI = prime1BI.multiply(prime2BI);    
  }
  
  //totient of n (number of numbers coprime to product number n)
  public void phiCalc() 
  { 
      RSAtab1.logMessages.append("Calculating phi...\n");
      //formula works only for prime numbers
      phiBI = (prime1BI.subtract(BigInteger.ONE)).multiply(prime2BI.subtract(BigInteger.ONE));      
  }
  
  //check that n is bigger than 2 in power equal to the size of the character to encrypt in bits
  public boolean isNBigEnough() 
  {
    boolean isBigEnough = true;
    //System.out.println("Default Charset=" + Charset.defaultCharset());
    //int pTextLength = plainText.getBytes(Charset.defaultCharset()).length;
    
    //assume most unicode characters are 2 bytes(16 bits) in java, so 2^16 is the max number of combinations to represent
    //a single character, and our n must be bigger than that
    if (modNBI.intValue() < Math.pow(2, 16))
    {
      isBigEnough = false;
    }
    
    RSAtab1.logMessages.append("Checking whether n is big enough for the current message..." + isBigEnough + "\n");
    return isBigEnough;
  }
  
  public boolean isNBigEnough(int n) 
  {
    boolean isBigEnough = true;
    //System.out.println("Default Charset=" + Charset.defaultCharset());
    //int pTextLength = plainText.getBytes(Charset.defaultCharset()).length;
       
    if (n < Math.pow(2, 16))
    {
      isBigEnough = false;
    }
    
    RSAtab1.logMessages.append("Checking whether n is big enough for the current message..." + isBigEnough + "\n");
    return isBigEnough;
  }
  
  //the alternative to a regular gcd Euclidean algorithm, could be faster sometimes
  public int binaryGCD (int e, int p) 
  {
    if (p == 0) return e; //if phi == 0, return eexp
    if (e == 0) return p; //if eexp == 0, return phi

    // eexp and phi even
    if ((e & 1) == 0 && (p & 1) == 0) return binaryGCD(e >> 1, p >> 1) << 1;
      // eexp is even, phi is odd
      else if ((e & 1) == 0) return binaryGCD(e >> 1, p);
        // eexp is odd, phi is even
        else if ((p & 1) == 0) return binaryGCD(e, p >> 1);
          // eexp and phi odd, eexp >= phi
          else if (e >= p) return binaryGCD((e - p) >> 1, p);
            // eexp and phi odd, eexp < phi
            else return binaryGCD(e, (p - e) >> 1);
  }
  
  //Euclidian algorithm
  public int gcd(int e, int p)
  {
    if (p == 0)
    {
      return p;        
    }
    else
    {
      return gcd(p, e % p);           
    }
  } 
  
  //checks that e is coprime to phi, based on GCD algorithm
  public boolean isCoprime(int ee) 
  {
    boolean areCoprime = true;
    
    if (gcd(ee, phi) != 1)
    {
      areCoprime = false;
    }
    
    RSAtab1.logMessages.append("Checking whether first exponent is coprime to phi...\n");
    return areCoprime;
  }
  
  //builds a list of numbers prime to phi(our first exponent) and returns a random number  
  public void chooseRandomE()
  {
    arlE = new ArrayList();  
    
    for (int i = 0; i < phiBI.intValue(); i++)
    {
      BigInteger iBI = new BigInteger(Integer.toString(i));
      if ((phiBI.gcd(iBI)).equals(BigInteger.ONE))
      {
        arlE.add(iBI);
      }
    }
    //System.out.println(Arrays.toString(arlE.toArray()));
    Random randGenerator = new Random();
    int randomIndex = randGenerator.nextInt(arlE.size());
    eexpBI = arlE.get(randomIndex);
    RSAtab1.logMessages.append("Choosing random first exponent out of list...\n");
  }
  
  //calculates the second exponent which must be a multinverse of first exponent mod phi
  public void dexpCalc()
  {
    dexpBI = eexpBI.modInverse(phiBI);
    RSAtab1.logMessages.append("Calculating second exponent...\n");
  }
  
  //verifies that product of first and second exponents equal to 1 in modulus phi
  public boolean verifyEAndD()
  {
    boolean verification = ((dexpBI.multiply(eexpBI)).mod(phiBI)).equals(BigInteger.ONE);
    RSAtab1.logMessages.append("verifying (eexp * dexp mod phi == 1)... " + verification + "\n");
   
    return verification;
  }

  //generates the set of keys, first exponent and modulus will be used for encryption,
  //and second exponent and modulus - for decryption
  public String[] makeKeys()
  {
       RSAtab1.logMessages.append("Generating keys:\n");
       modNCalc();
       phiCalc();
       chooseRandomE();
       dexpCalc();
       
       keys[0] = eexpBI.toString();
       keys[1] = modNBI.toString();
       keys[2] = dexpBI.toString();
       keys[3] = modNBI.toString();
       
       //in case if verification fails(which is unlikely), it will generates different set of keys untill succeds
       while (!verifyEAndD()) 
       {
         makeKeys();
       }
       
    return keys;
  }
  
  //based on formula (plainText)^e mod n = cypherText, creates the String array of encrypted symbols
  //uses the last created set of keys that have been created during the execution of the program 
  public String[] encrypt()  
  {                                       
    RSAtab1.logMessages.append("Encrypting the message...\n");
    if (isNBigEnough())
    {
       cipherText = new String[plainText.length()];
       for (int i = 0; i < plainText.length(); i++ )
       {
         BigInteger plainBI = new BigInteger(Integer.toString(plainText.charAt(i)));
         BigInteger bi1 = plainBI.pow(eexpBI.intValue());
         cipherText[i] = (bi1.mod(modNBI)).toString();
       }
    }
    else
    {
      JOptionPane.showMessageDialog(null, "The size of n is not big enough for your message, choose bigger primes.", "Warning!", JOptionPane.ERROR_MESSAGE);
      RSAtab1.logMessages.append("The current size of modulus is not big enough for the message, choose bigger primes.\n");
    }
    
    return cipherText;
  }
  
  //uses foreign keys for encryption, creates the String array of encrypted symbols
  public String[] encrypt(int e, int n) 
  {                                              
    RSAtab1.logMessages.append("Encrypting the message...\n");  
    if (isNBigEnough(n))
    {
       cipherText = new String[plainText.length()];
       for (int i = 0; i < plainText.length(); i++ )
       {
         BigInteger plainBI = new BigInteger(Integer.toString(plainText.charAt(i)));
         BigInteger bi1 = plainBI.pow(eexpBI.intValue());
         cipherText[i] = (bi1.mod(modNBI)).toString();
       }       
    }
    else
    {
      JOptionPane.showMessageDialog(null, "The size of n is not big enough for your message, choose bigger primes.", "Warning!", JOptionPane.ERROR_MESSAGE);
      RSAtab1.logMessages.append("The current size of modulus is not big enough for the message, choose bigger primes.\n");
    }
    
    return cipherText;
  }
  
  //decrypts the String array of cypher text using the last created set of keys; uses the same formula as encryption
  //function but instead of first exponent we plug in a second exponent
  public String decrypt() 
  {
    RSAtab1.logMessages.append("Decrypting the message...\n");
    StringBuilder plain = new StringBuilder();
    
    for (int i = 0; i < cipherText.length; i++ )
    {     
      BigInteger cipherBI = new BigInteger(cipherText[i]);
      //calculate BigInteger of cipher text in power dexp
      BigInteger bi2 = cipherBI.pow(dexpBI.intValue());
      //convert modN to BigInteger, calculate modulus of previous result, then get an integer representation of BigInteger,
      //then convert int to char
      int ciphoInt = (bi2.mod(modNBI)).intValue();
      char ciphoIntChar = (char)ciphoInt;
      plain.append(ciphoIntChar);     
    }
    
    plainText = plain.toString();
    return plainText;
  }
  
  //decrypts the message using foreign keys; uses the same formula as encryption function
  //but instead of first exponent we plug in a second exponent
  public String decrypt(int d, int n) 
  {
    RSAtab1.logMessages.append("Decrypting the message...\n");
    StringBuilder plain = new StringBuilder();
    
    for (int i = 0; i < cipherText.length; i++ )
    {
      BigInteger cipherBI = new BigInteger(cipherText[i]);
      dexp = d;
      //calculate BigInteger of cipher text in power dexp
      BigInteger bi2 = cipherBI.pow(dexp);
      //convert modN to BigInteger, calculate modulus of previous result, then get an integer representation of BigInteger,
      //then convert int to char
      int ciphoInt = (bi2.mod(new BigInteger(Integer.toString(n)))).intValue();
      char ciphoChar = (char)(ciphoInt);
      plain.append(ciphoChar);           
    }
    
    plainText = plain.toString();
    return plainText;
  }  
}