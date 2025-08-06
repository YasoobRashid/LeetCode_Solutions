class Solution {

    public boolean canEatAll(int[] piles, int speed, int h){
        long totalHours= 0;
        for(int pile: piles){
            int div = pile/speed;
            totalHours+= div;
            if(pile%speed!=0){
                totalHours++;
            }
        }
        return totalHours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo =1;
        int hi = Arrays.stream(piles).max().getAsInt();
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