package basic;

/**
 * Given a decimal number, convert that number to its binary representation.
 *
 */
public class decimalToBinary {

  public static void toBinary(int num) {
    String binary = "";
    while (num > 0) {
      binary = num % 2 + binary;
      num /= 2;
    }
    System.out.println("binary: " + binary);
  }

  /**
   * Implementation from https://algorithms.tutorialhorizon.com/decimal-to-binary/ which could be a
   * bit excessive with reverse call
   */
  public static void toBinary2(int num) {
    StringBuilder sb = new StringBuilder();
    int n = num;
    while (num > 0) {
      sb.append(num % 2);
      num /= 2;
    }
    System.out.println("Number: " + n + ", binary representation: " + sb.reverse().toString());
  }

  public static void main(String[] args) {
    toBinary(7);
    toBinary2(7);
    toBinary(8);
    toBinary2(8);
    toBinary(105);
    toBinary2(105);
  }
}
