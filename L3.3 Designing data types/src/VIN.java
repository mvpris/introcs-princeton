import java.util.Objects;

public class VIN {
    private int n;
    private String[] VINs = new String[10];

    public void resize() {
        String[] temp = new String[2 * n];
        System.arraycopy(VINs, 0, temp, 0, VINs.length);
        VINs = temp;
    }

    public void add(String VIN) {
        if (!check(VIN)) throw new RuntimeException("VIN is not valid.");
        if (n == VINs.length) resize();
        VINs[n++] = VIN;

    }

    public boolean check(String VIN) {
        boolean flag = true;
        if (VIN.length() != 17) flag = false;
        if (VIN.contains("I")) flag = false;
        if (VIN.contains("O")) flag = false;
        if (VIN.contains("Q")) flag = false;
        return flag;
    }

    public String getVIN(int i) {
        return VINs[i];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        VIN that = (VIN) obj;
        boolean flag = true;
        for (int i = 0; i < VINs.length; i++) {
//            Safe because Objects.equals() can handle null values and won't throw a NullPointerException,
//            therefore the expression will evaluate to true/false;
            if (!Objects.equals(this.VINs[i], that.VINs[i])) {
                flag = false;
                break;
            }
//            Not safe because it could throw a NullPointerException if one of the values to compare is null;
//            if (!this.VINs[i].equals(that.VINs[i])) {
//                flag = false;
//                break;
//            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(VINs.length);
        for (String vin : VINs) {
            result += 31 * Objects.hash(vin);
        }
        return result;
    }

    public static void main(String[] args) {
        String VIN1 = "1G4AJ47A0BH191698";
        VIN VIN = new VIN();
        VIN.add(VIN1);
    }
}
