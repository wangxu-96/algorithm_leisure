package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 *
 */
public class FindWords {

    static class Node{
        Map<Character,Node> children;
        boolean isEnd;
        Character val;
        String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Node(Character val) {
            this.val = val;
            this.children = new HashMap<>();
        }

        public boolean contains(Character character){
            return children.containsKey(character);
        }

        public void putChildrenNode(Character character,Node node){
            children.put( character, node);
        }

        public Node getChildrenNode(Character character){
            return children.get(character);
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, Node> children) {
            this.children = children;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Character getVal() {
            return val;
        }

        public void setVal(Character val) {
            this.val = val;
        }
    }

    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        Node root = new Node('#');

        // Step 1). Construct the Trie
        for (String word : words) {
            Node temp = root;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                if (temp.children.containsKey(aChar)) {
                    temp = temp.getChildrenNode(aChar);
                } else {
                    Node node = new Node(aChar);
                    temp.putChildrenNode(aChar, node);
                    temp = node;
                }
            }
            temp.setEnd(true);
            temp.setWord(word);
        }
        this._board = board;

        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }


        return this._result;
    }

    private void backtracking(int row, int col, Node parent) {

        Character letter = this._board[row][col];
        Node currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.isEnd()) {
            this._result.add(currNode.getWord());
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }

    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();

        List<String> words = findWords.findWords(new char[][]{{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});

        for (String s : words) {
            System.out.println(s);
        }
    }
}
