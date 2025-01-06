public class DowJones {
    private final DowJonesEntry[] djia;
    private final int n;

    public DowJones(String filename) {
        In inCsv = new In(filename);
        String filenameTxt = filename.substring(0, filename.indexOf(".")) + ".txt";
        Out out = new Out(filenameTxt);
        In inTxt = new In(filenameTxt);

        inCsv.readLine();
        int n = 0;
        while (inCsv.hasNextLine()) {
            String s = inCsv.readLine();
            n++;
            out.println(s);
        }
        this.n = n;

        djia = new DowJonesEntry[n];
        for (int i = 0; i < n; i++) {
            String line = inTxt.readLine();
            String[] ls = line.split(",");
            djia[i] = new DowJonesEntry(ls[0],
                    Double.parseDouble(ls[1]),
                    Double.parseDouble(ls[2]),
                    Double.parseDouble(ls[3]),
                    Double.parseDouble(ls[4]),
                    Double.parseDouble(ls[5]),
                    Double.parseDouble(ls[6]));
        }
    }

    public double averageOpen(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double sum = 0.0;
        for (int i = a[1]; i <= a[0]; i++) {
            sum += djia[i].getOpen();
        }
//        System.out.println("sum=" + sum);
        return sum / a[2];
    }


    public double averageHigh(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double sum = 0.0;
        for (int i = a[1]; i <= a[0]; i++) {
            sum += djia[i].getHigh();
        }
        return sum / a[2];
    }


    public double averageLow(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double sum = 0.0;
        for (int i = a[1]; i <= a[0]; i++) {
            sum += djia[i].getLow();
        }
        return sum / a[2];
    }


    public double averageClose(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double sum = 0.0;
        for (int i = a[1]; i <= a[0]; i++) {
            sum += djia[i].getClose();
        }
        return sum / a[2];
    }


    public double averageVolume(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double sum = 0.0;
        for (int i = a[1]; i <= a[0]; i++) {
            sum += djia[i].getVolume();
        }
        return sum / a[2];
    }


    public double averageAdjClose(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double sum = 0.0;
        for (int i = a[1]; i <= a[0]; i++) {
            sum += djia[i].getAdjClose();
        }
        return sum / a[2];
    }

    public int[] getPeriod(String startDate, String endDate) {
        int[] a = new int[3];
        for (int i = 0; i < n; i++) {
            if (djia[i].getDate().equals(startDate)) a[0] = i;
            if (djia[i].getDate().equals(endDate)) a[1] = i;
        }
        a[2] = a[0] - a[1] + 1;
//        System.out.println("s=a[0]=" + a[0]);
//        System.out.println("e=a[1]==" + a[1]);
//        System.out.println("period=" + a[2]);
        return a;
    }

    public void plotOpen(String startDate, String endDate) {
        int[] a = getPeriod(startDate, endDate);
        double[] djiaOpen = new double[a[2]];
        int count = a[2] - 1;
        for (int i = a[1]; i <= a[0]; i++) {
            djiaOpen[count] = djia[i].getOpen();
            count--;
        }
        StdDraw.setYscale(0, StdStats.max(djiaOpen));
        StdStats.plotPoints(djiaOpen);
    }

    public static void main(String[] args) {
        String filename = args[0];
        String startDate = args[1];
        String endDate = args[2];
        DowJones djia = new DowJones(filename);
//        System.out.println("n = " + djia.n);
//        Sample period: "01-Oct-28", "17-Mar-06"
        System.out.println("Average result over period = " + djia.averageOpen(startDate, endDate));
        djia.plotOpen(startDate, endDate);
    }
}
