/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       int low = 1;
        int high = n;

        while (low <= high) {

            // Middle version
            int mid = low + (high - low) / 2;

            // Agar mid bad hai
            if (isBadVersion(mid)) {

                // Ho sakta hai isse pehle bhi bad version ho
                // Isliye left side search karenge
                high = mid - 1;
            }
            else {

                // Mid good hai
                // To first bad version right side mein hoga
                low = mid + 1;
            }
        }

        // Loop ke end mein low first bad version par hoga
        return low;
    }
}