class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    void helper(int c[], int t, int st, List<Integer>curr , int sum){
        if(sum==t){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(sum>t){
            return;
        }

        for(int i =st; i<c.length; i++){
            curr.add(c[i]);
            helper(c, t, i, curr, sum+c[i]);
            curr.remove(curr.size()-1);
        }


    }
}