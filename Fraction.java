public class Fraction
{
  public int whole, num, denom;

  public static void main(String[] args)
  {
    Fraction oneAndHalf = new Fraction(0, 4, 1);
    Fraction threeAndThreeQuarters = new Fraction(3, 9, 12);
    System.out.println(oneAndHalf.toString());
    //threeAndThreeQuarters.toString();
  }

  public Fraction()
  {
    whole = 0;
    num = 0;
    denom = 1;
  }

  public Fraction(int inNum, int inDenom)
  {
    whole = 0;
    num = inNum;
    denom = inDenom;
  }

  public Fraction(int inWhole, int inNum, int inDenom)
  {
    whole = inWhole;
    num = inNum;
    denom = inDenom;
  }

  public int gcd(int a, int b)
  {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public void reduce()
  {
    int extraWhole = 0;
    int gcd = gcd(num, denom);
    extraWhole += num / denom;
    whole += extraWhole;
    num -=  (denom * extraWhole);
    num /= gcd;
    denom /= gcd;
  }

  public Fraction add(Fraction A)
  {
    int newWhole, newNum, newDenom;
    int rawNum, aRawNum;
    rawNum = (num + (whole * denom)) * A.denom;
    aRawNum = (A.num + (A.whole * A.denom)) * denom;
    newDenom = A.denom * denom;
    newNum = rawNum + aRawNum;
    newWhole = whole + A.whole;
    Fraction result = new Fraction(newWhole, newNum, newDenom);
    result.reduce();
    return result;
  }
  // Fraction C = this - A;
  public Fraction substract(Fraction A)
  {
    int newWhole, newNum, newDenom;
    int rawNum, aRawNum;
    rawNum = (num + (whole * denom)) * A.denom;
    aRawNum = (A.num + (A.whole * A.denom)) * denom;
    newDenom = A.denom * denom;
    newNum = rawNum - aRawNum;
    newWhole = whole - A.whole;
    Fraction result = new Fraction(newWhole, newNum, newDenom);
    result.reduce();
    return result;
  }
  // Multiply the current Fraction to Fraction A, return the result as a new Fraction (reduced, of course)
  public Fraction multiply(Fraction A)
  {
    int newWhole;
    int newNum, newDenom;
    num = whole * denom;
    A.num = A.whole * A.denom;
    newNum = num * A.num;
    newDenom = denom * A.denom;
    Fraction result = new Fraction(newNum, newDenom);
    result.reduce();
    return result;
  }

  // Divide Fractions (this/A), return the result as a new Fraction (reduced, of course)
  // You may assume that A will be a non-zero value
  public Fraction divide(Fraction A)
  {
    int newWhole, newNum, newDenom;
    num = whole * denom;
    A.num = A.whole * A.denom;
    newNum = num / A.num;
    newDenom = denom / A.denom;
    Fraction result = new Fraction(newNum, newDenom);
    result.reduce();
    return result;
  }

  // raturns a string that contains a fraction in the format:
  // whole number, a space, the numerator, a slash (/), and a denominator (e.g: 2 3/4).
  // When the whole number is 0, just display the fraction part (e.g: 1/2 instead of 0 1/2.
  // When the numerator is 0, just display the whole number (e.g: 2 instead of 2 0/3).
  // Also, just display 3 instead of 3/1.
  public String toString()
  {
    this.reduce();
    if(num == 0)
      return (whole + "");
    else if (whole == 0)
      return (num + "/" + denom);
    else
      return (whole + " " + num + "/" + denom);
  }

  public void display()
  {
    System.out.println("Whole: " + this.whole);
    System.out.println("Numerator: " + this.num);
    System.out.println("Denominator: " + this.denom + "\n");
  }
}
