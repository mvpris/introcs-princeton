public class app3112 {
    public static void main(String[] args) {
        String isbn = args[0];
        System.out.println("The ISBN " + isbn + " is " + (isValidISBN(isbn) ? "valid" : "invalid"));
    }

    public static boolean isValidISBN(String isbn) {
        isbn = isbn.replace("-", "");

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(isbn.substring(i, i + 1));
            sum += ((10 - i) * digit);
        }

        String checksum = Integer.toString(11 - (sum % 11));
        if ("10".equals(checksum)) {
            checksum = "X";
        }
        
        return checksum.equals(isbn.substring(9));
    }
}
