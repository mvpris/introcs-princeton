public class app4130 {
    public static String no2slash(String name) {
        char[] c = name.toCharArray();
        int n = name.length();
        int i = 1;
        while (i < n) {
            if ((c[i - 1] == '/') && (c[i] == '/')) {
                for (int j = i + 1; j < n; j++)
                    c[j - 1] = c[j];
                n--;
            } else i++;
        }

        String result = "";
        for (int j = 0; j < i; j++) {
            result += c[j];
        }
        return result;
    }

    public static String no2slashlinear(String name) {
        int n = name.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && name.charAt(i) == '/' && name.charAt(i - 1) == '/') continue;
            sb.append(name.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String name = "/d1///d2////d3/test.html";
        String result1 = no2slash(name);
        String result2 = no2slashlinear(name);
        StdOut.println(result1);
        StdOut.println(result2);
    }
}
