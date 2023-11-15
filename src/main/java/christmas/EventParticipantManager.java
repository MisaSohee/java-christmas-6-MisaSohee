package christmas;

public class EventParticipantManager {
    private static int participantCount = 0;

    public static void increaseParticipantCount() {
        participantCount++;
    }

    public static int getParticipantCount() {
        return participantCount;
    }
}
