public class StackOfInts {
    private Node first;

    private class Node {
        private int item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(int num) {
        Node oldFirst = first;
        first = new Node();
        first.item = num;
        first.next = oldFirst;
    }

    public int pop() {
        int i = first.item;
        first = first.next;
        return i;
    }

    public static void main(String[] args) {
        StackOfInts stack1 = new StackOfInts();
        Stack<Integer> stack2 = new Stack<>();

        int n = Integer.parseInt(args[0]);
        Stopwatch timer1 = new Stopwatch();
        for (int i = 0; i < n; i++) {
            stack1.push(i);
        }
        double elapsedTime1 = timer1.elapsedTime();
        StdOut.println("elapsedTime1=" + elapsedTime1);

        Stopwatch timer2 = new Stopwatch();
        for (int i = 0; i < n; i++) {
            stack2.push(i);
        }
        double elapsedTime2 = timer2.elapsedTime();
        StdOut.println("elapsedTime2=" + elapsedTime2);

        /*
.../src> java StackOfInts 10000
elapsedTime1=0.001
elapsedTime2=0.001
.../src> java StackOfInts 100000
elapsedTime1=0.003
elapsedTime2=0.003
.../src> java StackOfInts 1000000
elapsedTime1=0.297
elapsedTime2=0.226
.../src> java StackOfInts 10000000
elapsedTime1=1.391
elapsedTime2=3.932
.../src> java StackOfInts 20000000
elapsedTime1=2.651
elapsedTime2=7.05
.../src> java StackOfInts 40000000
elapsedTime1=4.931
elapsedTime2=17.972

        Penalty time is Integer stack is approx 3 times slower (and increasing) than int stack because of autoboxing.
        Order of growth of running time is linear since there is only one for loop iterating n times with the
        only instruction stack.push(i) running in constant time.
         */
    }
}
