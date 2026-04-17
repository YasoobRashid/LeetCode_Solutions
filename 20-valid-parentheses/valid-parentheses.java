class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i =0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(!st.isEmpty()){
                char last = st.peek();
                if(isPair(last, curr)){
                    st.pop();
                    continue;
                }
            }
            st.push(curr);
        }    

        return st.isEmpty();    
    }

    boolean isPair(char last, char curr){
        return (last =='(' && curr==')') ||
                (last =='{' && curr=='}') ||
                (last == '[' && curr ==']');
    }
}