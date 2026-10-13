class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // '('
            if (ch == '(') {
                low++;
                high++;
            }

            // ')'
            else if (ch == ')') {
                low--;
                high--;
            }

            // '*'
            else {
                // '*' ko ')' maanenge -> low decrease
                low--;

                // '*' ko '(' maanenge -> high increase
                high++;
            }

            // Agar maximum bhi negative ho gaya
            // to string valid nahi ho sakti
            if (high < 0) {
                return false;
            }

            // low negative ho sakta hai,
            // kyunki '*' ko empty bhi maan sakte hain
            if (low < 0) {
                low = 0;
            }
        }

        // Agar minimum possible open brackets 0 hai
        // tab valid possibility exist karti hai
        return low == 0;


    }
}