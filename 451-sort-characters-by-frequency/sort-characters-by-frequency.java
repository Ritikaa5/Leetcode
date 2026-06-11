class Solution {
    public String frequencySort(String s) {
         // Step 1: count frequency
        HashMap<Character, Integer> map =
                new HashMap<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // increase frequency
            map.put(ch,
                    map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap
        PriorityQueue<Character> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                map.get(b)
                                - map.get(a)
                );

        // add unique characters
        pq.addAll(map.keySet());

        // Step 3: build result
        StringBuilder res =
                new StringBuilder();

        while(!pq.isEmpty()) {

            char ch = pq.poll();

            int freq = map.get(ch);

            // add char freq times
            for(int i = 0; i < freq; i++) {
                res.append(ch);
            }
        }

        return res.toString();
    }
    
}