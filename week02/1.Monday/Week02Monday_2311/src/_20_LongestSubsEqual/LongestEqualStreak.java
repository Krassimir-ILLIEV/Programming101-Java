package _20_LongestSubsEqual;

public class LongestEqualStreak {

    public static int maxEqualConsecutive(int[] items) {
        int maxStreak = 0;
        int currentStreak = 0;
        for (int i = 0; i < items.length; i++) {

            if (i + 1 < items.length && items[i] == items[i + 1]) {
                currentStreak++;

            } else {
                if (currentStreak+1 > maxStreak) {
                    maxStreak = currentStreak + 1;
                }
                currentStreak = 0;
            }

        }
        return maxStreak;
    }

    public static void main(String[] args) {
        System.out.println(maxEqualConsecutive(new int[] { 1, 2, 3, 3, 3, 3, 4, 3, 3 }));
        // == 4
        System.out.println(maxEqualConsecutive(new int[] { 1, 1, 2, 2, 3, 3, 4, 4,5,5,5,4 }));
        // == 3
    }

}
