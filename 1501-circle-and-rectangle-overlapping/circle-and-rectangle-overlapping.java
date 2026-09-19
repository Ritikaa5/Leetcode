class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
         // Find the closest point on the rectangle to the circle's center
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate squared distance between closest point and circle's center
        long dx = xCenter - closestX;
        long dy = yCenter - closestY;
        
        // If this distance is <= radius, they overlap
        return (dx * dx + dy * dy) <= (long) radius * radius; 
    }
}