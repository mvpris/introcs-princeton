import java.util.Collections;
import java.util.TreeSet;

public class WebBlocker {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] objectionableWebsites = in.readAllStrings();
        StdRandom.shuffle(objectionableWebsites);

        TreeSet<String> set = new TreeSet<>();
        Collections.addAll(set, objectionableWebsites);

        while (!StdIn.isEmpty()) {
            String website = StdIn.readString();
            if (!set.contains(website)) StdOut.println(website);
        }

//        run cmd line
//        java WebBlocker objWebsites.txt < listWebsites.txt
    }
}
