class Solution {
    public List<Integer> getRow(int rowIndex) {
        

           // Saari rows store karne ke liye list
        List<List<Integer>> result = new ArrayList<>();

        // Har row banane ke liye loop
        for (int i = 0; i <= rowIndex; i++) {

            // Current row ko store karne ke liye empty list
            List<Integer> row = new ArrayList<>();

            // Current row mein elements add karne ke liye loop
            for (int j = 0; j <= i; j++) {

                // Row ka first aur last element hamesha 1 hota hai
                if (j == 0 || j == i) {
                    row.add(1);
                } 
                else {
                    // Previous row ke left aur right elements add karo
                    int left = result.get(i - 1).get(j - 1);
                    int right = result.get(i - 1).get(j);

                    // Dono elements ka sum current row mein add karo
                    row.add(left + right);
                }
            }

            // Complete row ko result mein add karo
            result.add(row);
        }

        // Pascal's Triangle return karo
        return result.get(rowIndex);
    }
}