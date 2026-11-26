class Solution {
    public boolean canAliceWin(int n) {

        int remove = 10;
        boolean aliceTurn = true;

        while (n >= remove && remove > 0) {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }

        // If the loop ended on Alice's turn, Alice cannot make the next move and loses.
        return !aliceTurn;
        
    }
}