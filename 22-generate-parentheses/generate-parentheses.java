class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        helper(n,res,"", 0,0);
        return res;
    }

    void helper(int n , List<String> res, String s, int ob, int cb) {
        if(ob==n && cb==n){
            res.add(s);
            return;
        }

        if(ob<n){
            helper(n, res, s+"(", ob+1, cb);
        }

        if(cb<ob){
            helper(n, res, s+")", ob, cb+1);
        }
    }
}