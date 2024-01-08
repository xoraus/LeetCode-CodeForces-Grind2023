class Solution {
    public boolean isPossible(int[] piles, long speed, long totalHours){
        long hoursRequired = 0;

        for(int bananas: piles){
            hoursRequired += Math.ceil((double) bananas / speed);
        }

        return (hoursRequired <= totalHours);
    }

    public long maxInArray(int[] piles) {
        int max = 0;
        for (int bananas : piles)
            max = Math.max(max, bananas);
        return max;
    }

    public int minEatingSpeed(int[] piles, int totalHours) {
        long left = 1l;
        long right = maxInArray(piles);

        while(left <= right){
            long mid = left + (right - left) / 2l;
            if(isPossible(piles, mid, totalHours) == true){
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }
        return (int)left;
    }
}