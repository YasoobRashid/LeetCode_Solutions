class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int j = 0;
        for(int i =1; i<arr.length; i++){
            int n = arr[i]-arr[j];
            min = Math.min(n,min);
            j++;
        }

        int k = 0;
        for(int i =1; i<arr.length;i++){
            if(arr[i]-arr[k]== min){
                res.add(Arrays.asList(arr[k],arr[i]));
                k++;
            }
            else{
                k++;
            }
        }

        return res;
    }
}