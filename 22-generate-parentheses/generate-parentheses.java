class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> res = new ArrayList<>();
        helper(n, res, 0,0,"");
        return res;
    }

    void helper(int n, List<String>res, int ob, int cb, String curr){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }

        if(ob<n){
            helper(n, res, ob+1, cb, curr +"(");
        }

        if(cb<n && cb<ob){
            helper(n,res, ob, cb+1, curr+")");
        }
    }
}