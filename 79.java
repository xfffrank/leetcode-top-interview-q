class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word == "") return false;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(index) || visited[i][j]) return false;
        visited[i][j] = true;
        boolean result = dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1);
        visited[i][j] = false;
        return result;
    }
}