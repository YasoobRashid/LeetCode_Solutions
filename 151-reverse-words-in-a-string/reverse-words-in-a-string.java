class Solution {
    public String reverseWords(String s) {
        //optimal approach using two pointer

        String res = "";
        int right = s.length()-1;
        int end;
        int start;
        while(right>=0){
            while(right>=0 && s.charAt(right)== ' '){
                right--;
            }
            end = right;

            if(right<0){
                break;
            }

            while(right>=0 && s.charAt(right)!=' '){
                right--;
            }

            start = right+1;

            res += s.substring(start,end+1)+" ";
        }

        return res.trim();
    }
}