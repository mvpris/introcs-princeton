import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrarScheduler {

    // Class to represent a class schedule entry
    static class ClassSchedule {
        String instructor;
        String classID;
        int startTime; // Time in hours: 9, 10, 11, 13, 14, 15

        public ClassSchedule(String instructor, String classID, int startTime) {
            this.instructor = instructor;
            this.classID = classID;
            this.startTime = startTime;
        }
    }

    public static void checkForConflicts(List<ClassSchedule> scheduleList) {
        // Map to store schedules by instructor
        Map<String, List<Integer>> instructorScheduleMap = new HashMap<>();

        for (ClassSchedule schedule : scheduleList) {
            String instructor = schedule.instructor;
            int startTime = schedule.startTime;

            // Initialize the schedule list for the instructor if not already present
            instructorScheduleMap.putIfAbsent(instructor, new ArrayList<>());

            // Check for conflicts
            if (instructorScheduleMap.get(instructor).contains(startTime)) {
                StdOut.println("Conflict detected for instructor " + instructor +
                        " at startTime " + startTime + " with class ID " + schedule.classID);
            } else {
                instructorScheduleMap.get(instructor).add(startTime);
            }
        }
    }

    public static void main(String[] args) {
        // Example schedule list
        List<ClassSchedule> scheduleList = new ArrayList<>();
        scheduleList.add(new ClassSchedule("Prof. Smith", "CS101", 9));
        scheduleList.add(new ClassSchedule("Prof. Smith", "CS102", 10));
        scheduleList.add(new ClassSchedule("Prof. Smith", "CS103", 9)); // Conflict
        scheduleList.add(new ClassSchedule("Prof. Johnson", "MA101", 13));
        scheduleList.add(new ClassSchedule("Prof. Johnson", "MA102", 14));
        scheduleList.add(new ClassSchedule("Prof. Brown", "PH101", 15));

        checkForConflicts(scheduleList);
    }
}
