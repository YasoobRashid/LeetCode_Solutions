class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        int i =0;
        //diff b/w pairs 
        for(int j = i+1; j<arr.length;j++){
            int diff = arr[j]-arr[i];
            min = Math.min(min,diff);
            i++;
        }

        int k = 0; 
        //finding pairs
        for(int j = k+1; j<arr.length;j++){
            if(arr[j]-arr[k]==min){
                res.add(Arrays.asList(arr[k],arr[j]));
                k++;
            }
            else{
                k++;
            }
        }

        return res;

        
    }
}