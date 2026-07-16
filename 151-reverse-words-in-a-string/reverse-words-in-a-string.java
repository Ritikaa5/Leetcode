class Solution {
    public String reverseWords(String s) {
        
// Remove leading/trailing spaces and split the sentence into words
        // "\\s+" means one or more spaces
        String[] words = s.trim().split("\\s+");

        // StringBuilder is efficient for string concatenation
        StringBuilder result = new StringBuilder();

        // Traverse the words array from the last word to the first
        for (int i = words.length - 1; i >= 0; i--) {

            // Append the current word
            result.append(words[i]);

            // Add a space after every word except the last one
            if (i != 0) {
                result.append(" ");
            }
        }    
         // Convert StringBuilder to String and return
          return result.toString();
    }
}