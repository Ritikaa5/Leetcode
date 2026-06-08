class Solution {

    public String removeDuplicates(String s) {

        // final result store karne ke liye
        StringBuilder result = new StringBuilder();

        // string ke har character par loop
        for(char ch : s.toCharArray()) {

            // result ki current length
            int len = result.length();

            // agar result empty nahi hai
            // aur last character current character ke equal hai
            // matlab adjacent duplicate mila
            if(len > 0 && result.charAt(len - 1) == ch) {

                // last duplicate character remove kar do
                result.deleteCharAt(len - 1);

            } else {

                // agar duplicate nahi hai
                // to character add kar do
                result.append(ch);
            }
        }

        // StringBuilder ko String me convert karke return
        return result.toString();
    }
}