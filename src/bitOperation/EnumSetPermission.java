package bitOperation;

import java.util.EnumSet;

public class EnumSetPermission {

  public enum Permission {

    ALLOW_SELECT(1 << 0), ALLOW_INSERT(1 << 1), ALLOW_UPDATE(1 << 2), ALLOW_DELETE(1 << 3);

    private int code;

    private Permission(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    public static final EnumSet<Permission> ALL = EnumSet.allOf(Permission.class);

    public static void main(String[] args) {

      // all public methods from BitFlagPermission is well supported by EnumSet out of the box
      System.out.println(ALL);

      // return false
      System.out.println(ALL.contains(Permission.ALLOW_DELETE));

      // return false
      EnumSet<Permission> writeOnlyPermissions =
          EnumSet.of(Permission.ALLOW_INSERT, Permission.ALLOW_UPDATE, Permission.ALLOW_DELETE);
      System.out.println(writeOnlyPermissions.contains(Permission.ALLOW_SELECT));

      System.out.println(Permission.ALLOW_SELECT.ordinal());
      System.out.println(Permission.ALLOW_DELETE.ordinal());
      System.out.println(Integer.toBinaryString(Permission.ALLOW_SELECT.getCode()));
      System.out.println(Integer.toBinaryString(Permission.ALLOW_DELETE.getCode()));
      System.out.println(Integer
          .toBinaryString(Permission.ALLOW_DELETE.getCode() | Permission.ALLOW_SELECT.getCode()));

      int allPermissions = 0;
      for (Permission permission : writeOnlyPermissions) {
        allPermissions = allPermissions | permission.getCode();
      }
      // print writeOnlyPermissions permissions in (decimal, binary)
      System.out.println(allPermissions + "," + Integer.toBinaryString(allPermissions));

      // convert 15 (1111 in binary) to EnumSet
      int sourceInDecimal = 15;
      EnumSet<Permission> noneOfPermission = EnumSet.noneOf(Permission.class);
      ALL.stream().forEach(permission -> {
        int code = permission.getCode();
        if ((code & sourceInDecimal) == code) {
          noneOfPermission.add(permission);
        }
      });
      System.out.println("permissions: " + noneOfPermission);
    }
  }
}

