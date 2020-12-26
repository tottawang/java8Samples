package bitOperation;

public class BitFlagPermission {

  public static final int ALLOW_SELECT = 1 << 0;
  public static final int ALLOW_INSERT = 1 << 1;
  public static final int ALLOW_UPDATE = 1 << 2;
  public static final int ALLOW_DELETE = 1 << 3; // 1000 in binary, 8 in decimal

  private int flag;

  public void addPermission(int permission) {
    flag |= permission;
  }

  public void removePermission(int permission) {
    flag &= ~permission;
  }

  public boolean isAllow(int permission) {
    return (flag & permission) == permission;
  }

  public boolean isNotAllow(int permission) {
    return (flag & permission) == 0;
  }

  public boolean isOnlyAllow(int permission) {
    return flag == permission;
  }

  public int getFlag() {
    return flag;
  }

  public static void main(String[] args) {
    BitFlagPermission test = new BitFlagPermission();
    test.addPermission(BitFlagPermission.ALLOW_DELETE);
    System.out.println(test.getFlag());
  }
}

