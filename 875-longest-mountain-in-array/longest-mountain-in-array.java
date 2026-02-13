class Solution {
    public int longestMountain(int[] arr) {

        int n = arr.length;
        int maxLen =0;

        for(int i =1; i<n-1; i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int st = i-1;
                int end = i+1;

                //expanifng start
                while(st>0 && arr[st]>arr[st-1]){
                    st--;
                }

                //expanding end
                while(end<n-1 && arr[end]>arr[end+1]){
                    end++;
                }

                maxLen = Math.max(maxLen, end-st+1);

            }
        }

        return maxLen;
    }
}