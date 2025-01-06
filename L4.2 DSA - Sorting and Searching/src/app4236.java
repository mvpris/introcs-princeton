import java.util.Arrays;

public class app4236 {
    public static void main(String[] args) {
        String[] domainNames = StdIn.readAllStrings();
        int n = domainNames.length;

        Domain[] domains = new Domain[n];
        for (int i = 0; i < n; i++) {
            domains[i] = new Domain(domainNames[i]);
        }

        Arrays.sort(domains);

        for (Domain d : domains) StdOut.println(d.toString());
//        java app4236
//        edu.princeton.cs wwe.google.ro wwa.yahoo.com wwa.aloha.con dcs.jngas.co.uk gas.khsd.au
//                ^Z
//        au.khsd.gas
//        com.yahoo.wwa
//        con.aloha.wwa
//        cs.princeton.edu
//        ro.google.wwe
//        uk.co.jngas.dcs
    }
}
