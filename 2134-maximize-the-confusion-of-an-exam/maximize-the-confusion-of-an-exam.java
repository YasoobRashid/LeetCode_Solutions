class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(flipEach(answerKey, k, 'T'), flipEach(answerKey, k, 'F'));
    }

    int flipEach(String ak, int k , char target){
        int start =0, flip = 0, maxLen=0;

        for(int end = 0; end<ak.length() ;end++){
            if(ak.charAt(end)!=target){
                flip++;
            }

            while(flip>k){
                if(ak.charAt(start)!=target){
                    flip--;
                }
                start++;
            }

            maxLen = Math.max(maxLen, end-start+1);
        } 
        return maxLen;
    }
}