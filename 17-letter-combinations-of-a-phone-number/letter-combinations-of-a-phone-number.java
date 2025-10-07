class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if(digits==null||digits.length()==0){
            return res;
        }
        Map<Character,String> dToA = new HashMap<>();
        dToA.put('2',"abc");
        dToA.put('3',"def");
        dToA.put('4',"ghi");
        dToA.put('5',"jkl");
        dToA.put('6',"mno");
        dToA.put('7',"pqrs");
        dToA.put('8',"tuv");
        dToA.put('9',"wxyz");

        backtrack(digits,0,new StringBuilder(), res, dToA);

        return res;

    }

    public void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        String letters = digitToLetters.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}