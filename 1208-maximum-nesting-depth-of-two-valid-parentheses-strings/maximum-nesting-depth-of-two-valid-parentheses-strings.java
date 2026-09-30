class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int[] answer = new int[seq.length()];

        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {

            // If current character is '('
            if (seq.charAt(i) == '(') {

                // Increase depth first
                depth++;

                // Assign '(' to group 0 or 1
                answer[i] = depth % 2;

            } 
            else {

                // Assign ')' to same group
                answer[i] = depth % 2;

                // Now decrease depth
                depth--;
            }
        }

        return answer;
    }
}