class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set candies = new HashSet<>();

        for(int candytypes: candyType){
            candies.add(candytypes);
        }

        int halfcandies = n/2;

        return Math.min(candies.size(),halfcandies);

    }
}