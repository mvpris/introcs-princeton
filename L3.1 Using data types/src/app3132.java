public class app3132 {
    public static boolean length(String password) {
        return password.length() >= 8;
    }

    public static boolean digits(String password) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < digits.length; j++) {
                if (password.charAt(i) == digits[j]) return true;
            }
        }
        return false;
    }

    public static boolean uppercase(String password) {
        char[] uppercase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < uppercase.length; j++) {
                if (password.charAt(i) == uppercase[j]) return true;
            }
        }
        return false;
    }

    public static boolean lowercase(String password) {
        char[] lowercase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < lowercase.length; j++) {
                if (password.charAt(i) == lowercase[j]) return true;
            }
        }
        return false;
    }

    public static boolean character(String password) {
        for (int i = 0; i < password.length(); i++) {
            String check = String.valueOf(password.charAt(i));
            if (!digits(check) && !uppercase(check) && !lowercase(check)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String password = args[0];
        System.out.println(length(password) + " length");
        System.out.println(digits(password) + " digits");
        System.out.println(uppercase(password) + " uppercase");
        System.out.println(lowercase(password) + " lowercase");
        System.out.println(character(password) + " character");
        boolean conditions = length(password) && digits(password) && uppercase(password) && lowercase(password) &&
                character(password);
        System.out.println(conditions + " all conditions");
    }
}
