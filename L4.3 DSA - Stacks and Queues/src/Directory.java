import java.io.File;

public class Directory {
    public static void main(String[] args) {
        Queue<File> queue = new Queue<>();
        File root = new File(args[0]);     // root directory
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            File directory = queue.dequeue();
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) queue.enqueue(file);
                    else StdOut.println(file.length() + ":\t" + file);
                }
            }
        }
    }
}

