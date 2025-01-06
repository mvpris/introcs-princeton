import java.util.TreeSet;

public class PasswordChecker {
    TreeSet<String> dictionary;
    String password;

    public PasswordChecker(String password) {
        dictionary = new TreeSet<>();
        while (!StdIn.isEmpty()) {
            dictionary.add(StdIn.readString());
        }
        if (check(password)) {
            this.password = password;
            StdOut.println("Password is valid");
        } else throw new IllegalArgumentException("Password is not valid");
    }

    private boolean check(String password) {
//        StdOut.println("f1=" + f1(password));
//        StdOut.println("f2=" + f2(password));
//        StdOut.println("f3=" + f3(password));
//        StdOut.println("f4=" + f4(password));
//        StdOut.println("f5=" + f5(password));
        return f1(password) && !f2(password) && !f3(password) && !f4(password) && !f5(password);
    }

    private boolean f1(String password) {
        return password.length() >= 8;
    }

    private boolean f2(String password) {
        return dictionary.contains(password);
    }

    private boolean f3(String password) {
        for (String word : dictionary) {
            if (password.matches(word + "[0-9]")) {
                return true;
            }
        }
        return false;
    }

    private boolean f4(String password) {
        for (int i = 1; i < password.length() - 1; i++) {
            if (Character.isDigit(password.charAt(i))) {
                String firstPart = password.substring(0, i);
                String secondPart = password.substring(i + 1);
                if (dictionary.contains(firstPart) && dictionary.contains(secondPart)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean f5(String password) {
        String reversedPassword = new StringBuilder(password).reverse().toString();
        return f2(reversedPassword) || f3(reversedPassword) || f4(reversedPassword);
    }

    public static void main(String[] args) {
        new PasswordChecker(args[0]);
        // input: java PasswordChecker asteroid5hello < web2.txt
        // input: java PasswordChecker jkasd2oaqq < web2.txt
    }
}
