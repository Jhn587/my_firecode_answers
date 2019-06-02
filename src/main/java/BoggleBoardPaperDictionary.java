import java.util.*;

/**
 * Boggle with Paper Dictionary
 * You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a rudimentary, paper Dictionary
 * in the form of an ArrayList of close to 10,000 words. Write a method - boggleByot that searches the Boggle Board for words
 * in the dictionary. Your method should return an alphabetically sorted ArrayList of words that are present on the board as
 * well as in the dictionary. Words on the board can be constructed with sequentially adjacent letters, where adjacent letters
 * are horizontal or vertical neighbors (not diagonal). Also, each letter on the Boggle Board must be used only once.
 * <p>
 * Note:
 * Your program should run in a reasonable amount of time - about a few milliseconds for each test case.
 * <p>
 * Example:
 * <p>
 * Input Board :
 * {
 * {A, O, L},
 * {D, E, L},
 * {G, H, I},
 * }
 * Dictionary : [HELLO, HOW, ARE, YOU] (as a Trie)
 * Output: [HELLO]
 */
public class BoggleBoardPaperDictionary {
    Set<String> foundWords = new TreeSet<>();

    static class TrieNode {
        Map<Character, TrieNode> trie = new HashMap<>();
        String content;
        boolean isWord;
    }

    public ArrayList<String> boggleByot(char[][] board, ArrayList<String> dictionary) {
        TrieNode root = buildTrie(dictionary);
        //thoughts do a dfs on each tile, that ends when all squares on board have been reached or no unused adjacenent tiles(horizonal or vertical)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                doDFS(board, i, j, new HashSet<>(), root);
            }
        }
        return new ArrayList<>(foundWords);
    }

    private TrieNode buildTrie(ArrayList<String> dictionary) {
        TrieNode root = new TrieNode();
        root.content = "";
        root.isWord = false;
        for (String word : dictionary) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode nextNode = node.trie.getOrDefault(c, new TrieNode());
                String nextContent = node.content + c;
                nextNode.content = nextContent;
                node.trie.put(c, nextNode);
                node = nextNode;

            }
            node.isWord = true;
        }
        return root;
    }


    private void doDFS(char[][] board, int row, int col, Set<String> visitedCells, TrieNode node) {
        String key = row + ":" + col;
        if (visitedCells.contains(key)) {
            return;
        }

        if (row > board.length - 1) {
            return;
        }
        if (row < 0) {
            return;
        }
        if (col > board[row].length - 1) {
            return;
        }
        if (col < 0) {
            return;
        }
        char nextLetter = board[row][col];
        if (!node.trie.containsKey(nextLetter)) {
            return;
        }
        TrieNode nextNode = node.trie.get(nextLetter);
        if (nextNode.isWord) {
            foundWords.add(nextNode.content);
        }
//
        visitedCells.add(key);
        doDFS(board, row + 1, col, new HashSet<>(visitedCells), nextNode);
        doDFS(board, row - 1, col, new HashSet<>(visitedCells), nextNode);
        doDFS(board, row, col + 1, new HashSet<>(visitedCells), nextNode);
        doDFS(board, row, col - 1, new HashSet<>(visitedCells), nextNode);
    }
}
