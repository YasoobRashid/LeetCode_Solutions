class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a );
        long sum =0;

        for(int gift:gifts){
            sum +=gift;
            pq.offer(gift);
        }

        for(int i =0; i<k;i++){
            if(pq.isEmpty()) break;
            int largest = pq.poll();
            int sq = (int)Math.sqrt(largest);
            sum = sum - (largest - sq);
            pq.offer(sq);
        }
        return (long)sum;
    }
}