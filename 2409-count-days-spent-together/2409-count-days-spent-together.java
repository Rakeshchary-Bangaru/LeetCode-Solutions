class Solution {

    public int countDaysTogether(
            String arriveAlice,
            String leaveAlice,
            String arriveBob,
            String leaveBob) {

        int aliceStart = dayOfYear(arriveAlice);
        int aliceEnd = dayOfYear(leaveAlice);

        int bobStart = dayOfYear(arriveBob);
        int bobEnd = dayOfYear(leaveBob);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    private int dayOfYear(String date) {

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        String[] parts = date.split("-");

        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }
}