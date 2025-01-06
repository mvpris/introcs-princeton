public class app3110 {
    public static String complementWatsonCrick(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            if (c == 'A') {
//                result.append('T');
//            } else if (c == 'T') {
//                result.append('A');
//            } else if (c == 'C') {
//                result.append('G');
//            } else if (c == 'G') {
//                result.append('C');
//            }
//        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'A':
                    result.append('T');
                    break;
                case 'T':
                    result.append('A');
                    break;
                case 'C':
                    result.append('G');
                    break;
                case 'G':
                    result.append('C');
                    break;
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(complementWatsonCrick(args[0]));
    }
}
