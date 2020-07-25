package com.at.wangxu.leetcode;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 */
public class Trie {

    Node root;


    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('1');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node dummyHead = root;

        for (int i = 0; i < chars.length; i++) {
            if (dummyHead.children[chars[i] - 'a'] == null) {
                dummyHead.children[chars[i] - 'a'] = new Node(chars[i]);
            }
            if (i == chars.length -1){
                dummyHead.children[chars[i] - 'a'].setWordEnd(true);
            }
            dummyHead = dummyHead.children[chars[i] - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node dummyHead = root;
        for (int i = 0; i < chars.length; i++) {
            if (dummyHead.children[chars[i] - 'a'] == null)
                return false;
            if (i == chars.length -1 && !dummyHead.children[chars[i] - 'a'].isWordEnd())
                return false;
            dummyHead = dummyHead.children[chars[i] - 'a'];
        }
        return true;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node dummyHead = root;
        for (char aChar : chars) {
            if (dummyHead.children[aChar - 'a'] == null)
                return false;
            dummyHead = dummyHead.children[aChar - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

    }

    static class Node {
        Node[] children;
        boolean isWordEnd;
        char character;

        public Node(char character) {
            children = new Node[26];
            this.character = character;
        }

        public Node[] getChildren() {
            return children;
        }

        public void setChildren(Node[] children) {
            this.children = children;
        }

        public boolean isWordEnd() {
            return isWordEnd;
        }

        public void setWordEnd(boolean wordEnd) {
            isWordEnd = wordEnd;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }
    }
}
