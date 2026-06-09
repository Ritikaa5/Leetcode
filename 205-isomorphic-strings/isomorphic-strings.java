class Solution {
    public boolean isIsomorphic(String s, String t) {
         // Create map for s -> t mapping
        HashMap<Character, Character> mapST = new HashMap<>();

        // Create reverse map for t -> s mapping
        // This prevents many-to-one mapping issue
        HashMap<Character, Character> mapTS = new HashMap<>();


        // Traverse both strings together
        for(int i = 0; i < s.length(); i++) {

            // Get current character from both strings
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);


            // ----------------------------
            // CHECK s -> t MAPPING
            // ----------------------------

            // If character from s already mapped
            if(mapST.containsKey(ch1)) {

                // Check if existing mapping matches current character
                // Example:
                // g -> d already stored
                // but now g -> x comes => invalid
                if(mapST.get(ch1) != ch2) {
                    return false;
                }

            } else {

                // If not mapped before,
                // create new mapping
                // Example: e -> a
                mapST.put(ch1, ch2);
            }


          
            // CHECK t -> s MAPPING
       

            // Why reverse check?
            // To avoid:
            // a -> x
            // b -> x (wrong)
            // One character cannot map to multiple chars

            // If character from t already mapped
            if(mapTS.containsKey(ch2)) {

                // Check if mapping is valid
                if(mapTS.get(ch2) != ch1) {
                    return false;
                }

            } else {

                // Add reverse mapping
                // Example: a -> e
                mapTS.put(ch2, ch1);
            }
        }

        // If loop completed,
        // all mappings are valid
        return true;
    }
}