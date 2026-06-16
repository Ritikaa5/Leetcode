class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();


        // Magazine ki frequency count
        for (char ch : magazine.toCharArray()) {

            // Already present
            if (map.containsKey(ch)) {

                map.put(ch, map.get(ch) + 1);
            }

            // First time
            else {

                map.put(ch, 1);
            }
        }


        // RansomNote traverse
        for (char ch : ransomNote.toCharArray()) {

            // Character available nahi hai
            if (!map.containsKey(ch)) {

                return false;
            }

            // Count decrease
            map.put(ch, map.get(ch) - 1);

            // Count 0 ho gaya
            if (map.get(ch) == 0) {

                map.remove(ch);
            }
        }

        return true;
    }
}