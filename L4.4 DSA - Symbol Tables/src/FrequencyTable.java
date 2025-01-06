import java.util.TreeMap;

public class FrequencyTable {
    private final TreeMap<String, Integer> freqTable = new TreeMap<>();

//    public FrequencyTable() {
//        freqTable = new TreeMap<>();
//    }
//
//    public FrequencyTable(TreeMap<String, Integer> x) {
//        freqTable = new TreeMap<>(x);
//    }

    public void click(String s) {
        if (s == null) throw new IllegalArgumentException("called click() with null argument");
        if (!freqTable.containsKey(s)) freqTable.put(s, 1);
        else {
            int i = freqTable.get(s);
            i++;
            freqTable.put(s, i);
        }
    }

    public Integer count(String s) {
        if (s == null) throw new IllegalArgumentException("called count() with null argument");
        if (freqTable.containsKey(s)) return freqTable.get(s);
        else return 0;
//        Can be replaced with
//        return freqTable.getOrDefault(s, 0);
    }

    public static void main(String[] args) {
        String[] keys = {"song1", "song2", "song3"};
        int[] vals = {1, 2, 3};
        FrequencyTable ft = new FrequencyTable();

        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals[i]; j++) {
                ft.click(keys[i]);
            }
        }

        for (String key : keys) {
            StdOut.println(key + ": " + ft.count(key) + " clicks");
        }

        String s = "song4";
        StdOut.println(s + ": " + ft.count(s) + " clicks");
    }
}
