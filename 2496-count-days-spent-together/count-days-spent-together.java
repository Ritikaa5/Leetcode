class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        // Har month mein kitne days hain
        int[] days = {31, 28, 31, 30, 31, 30,
                      31, 31, 30, 31, 30, 31};

        // Chaaron dates ko year ke day number mein convert karo
        int a1 = getDay(arriveAlice, days);
        int a2 = getDay(leaveAlice, days);
        int b1 = getDay(arriveBob, days);
        int b2 = getDay(leaveBob, days);

        // Dono mein se latest arrival date
        int start = Math.max(a1, b1);

        // Dono mein se earliest departure date
        int end = Math.min(a2, b2);

        // Agar start, end se aage hai, toh koi common day nahi
        if (start > end) {
            return 0;
        }

        // +1 kyunki arrival aur departure dates bhi count hoti hain
        return end - start + 1;
    }

    // MM-DD date ko year ke day number mein convert karta hai
    private int getDay(String date, int[] days) {

        // Month extract karo
        int month = Integer.parseInt(date.substring(0, 2));

        // Day extract karo
        int day = Integer.parseInt(date.substring(3, 5));

        // Pichhle months ke saare days add karo
        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        // Year ka total day number return karo
        return day;
    }
}