import java.util.Random;

public class Program1342 {
    public static void main(String[] args) {

        Random random = new Random();
        int trial = 1000000;

        System.out.println("The player never changes the door.");
        int win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            if (contestantDoor == prizeDoor) {
                win++;
            }
        }

        System.out.println("Total Wins out of " + trial + ": " + win);
        System.out.println("Percent win: " + (double) win / trial);
        System.out.println();

        System.out.println("The player always changes the door.");
        win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            int wrongDoor = prizeDoor;
            while (wrongDoor == prizeDoor ||
                    wrongDoor == contestantDoor) {
                wrongDoor = random.nextInt(3);
            }

            int alternateDoor = 3 - (contestantDoor + wrongDoor);

            if (alternateDoor == prizeDoor) {
                win++;
            }
        }

        System.out.println("Total Wins out of " + trial + ": " + win);
        System.out.println("Percent win: " + (double) win / trial);
    }
}
