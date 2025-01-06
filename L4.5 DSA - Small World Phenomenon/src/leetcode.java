import java.util.*;

public class leetcode {
    public static void main(String[] args) {
        // 876 Middle of The Linked List
        List<String> result = new ArrayList<>();
        result.add("aaa");
        result.add("aaa2");
        result.add("asd");
        result.add("asaad");
        StdOut.println(result.indexOf("asd"));
        StdOut.println(result.get(result.indexOf("asd")));
        String[] ss = new String[5];
        List<String> l2 = Arrays.asList(ss);
        String[] s = result.toArray(new String[0]);
        StdOut.println();
        for (String s1 : s) StdOut.println(s1);

        // 383 Ransom Note
        Set<String> set383 = new HashSet<>();
        Map<String, String> map383 = new HashMap<>();
    }

    // 383 Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            String c = String.valueOf(magazine.charAt(i));
            map.put(c, 0);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            String c = String.valueOf(ransomNote.charAt(i));
            if (map.containsKey(c) && map.get(c) == 0)
                map.put(c, map.get(c) + 1);
            if (!map.containsKey(c) || map.get(c) != 0)
                return false;
        }
        return true;
    }
}
