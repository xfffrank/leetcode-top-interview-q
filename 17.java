class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits.length() == 0) return queue;
        String[] numbers = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.offer("");

        for (int i = 0; i < digits.length(); i++) {
            char[] letters = numbers[digits.charAt(i) - '0'].toCharArray();
            while (queue.peek().length() == i) {
                String pre = queue.poll();
                for (char c: letters) {
                    queue.offer(pre + c);
                }
            }
        }
        return queue;
    }
}