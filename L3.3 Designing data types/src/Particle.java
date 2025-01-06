public class Particle {
    private final Vector position;
    private final Vector velocity;
    private final double mass;

    public Particle(Vector position, Vector velocity, double mass) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
    }

    public double kineticEnergy() {
        return 0.5 * mass * velocity.dot(velocity);
    }

    public static void main(String[] args) {
        In in = new In();
        System.out.println("Input total number of vectors:");
        int n = in.readInt();

        double[][] vectorsArray = new double[n][];
        double[] masses = new double[n];
        Vector[] vectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            vectorsArray[i] = new double[3];
            System.out.println("Input the coordinates of vector " + i + ":");
            for (int j = 0; j < 3; j++) {
                vectorsArray[i][j] = in.readDouble();
            }
            vectors[i] = new Vector(vectorsArray[0]);
            System.out.println("Input particle's mass:");
            masses[i] = in.readDouble();
        }

        System.out.println("Input which particles' kinetic energies are to be computed:");
        int v1 = in.readInt();
        int v2 = in.readInt();

        Particle particle1 = new Particle(vectors[v1], vectors[v1], masses[v1]);
        Particle particle2 = new Particle(vectors[v2], vectors[v2], masses[v2]);

        System.out.println("v1_ke=" + particle1.kineticEnergy());
        System.out.println("v2_ke=" + particle2.kineticEnergy());
    }
}
