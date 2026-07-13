class Solution {
    public int thirdMax(int[] nums) {
               long l = Long.MIN_VALUE;
        long sl = Long.MIN_VALUE;
        long tl = Long.MIN_VALUE;

        for (int a : nums) {
            l = Math.max(l, a);
        }

        for (int a : nums) {
            if (a == l) continue;
            sl = Math.max(sl, a);
        }

        for (int a : nums) {
            if (a == l || a == sl) continue;
            tl = Math.max(tl, a);
        }

        if (tl == Long.MIN_VALUE)
            return (int) l;

        return (int) tl;


    }
}