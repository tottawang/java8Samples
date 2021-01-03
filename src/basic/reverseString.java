package basic;

public class reverseString {

  public static void main(String[] args) {
    // using String.charAt
    String test = "reverseString";
    char[] resveredString = new char[test.length()];
    for (int i = 0; i < test.length(); i++) {
      resveredString[test.length() - 1 - i] = test.charAt(i);
    }
    System.out.println(resveredString);

    // using StringBuffer
    StringBuffer sbr = new StringBuffer(test);
    // To reverse the string
    sbr.reverse();
    System.out.println(sbr);

    // using bytes
    // To convert characters to bytes, you need to specify a character encoding. Some character
    // encodings use one byte per character, while others use two or more bytes.
    byte[] testInBytes = test.getBytes();
    byte[] reversedInBytes = new byte[testInBytes.length];
    for (int i = 0; i < testInBytes.length; i++) {
      reversedInBytes[testInBytes.length - 1 - i] = testInBytes[i];
    }
    System.out.println(new String(reversedInBytes));
  }

}
