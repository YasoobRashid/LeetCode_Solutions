class Solution {

    public boolean canEatAll(int[] piles, int speed, int h){
        int totalHours= 0;
        for(int pile: piles){
            totalHours += (pile + speed-1)/speed;
        }
        return totalHours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo =1;
        int hi = Integer.MAX_VALUE;
        int result = hi;

        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;

            if(canEatAll(piles, mid, h)){
                result = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return result;
    }
}