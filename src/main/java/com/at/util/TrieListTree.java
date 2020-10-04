package com.at.util;

import java.util.ArrayList;
import java.util.List;

public class TrieListTree {
    static class TrieNode {
        int count;//次数
        char value;
        List<TrieNode> children = new ArrayList<>();

        public TrieNode(char value) {
            this.value = value;
        }
    }

    public static void insert(TrieNode root, String key) {
        TrieNode node = root;
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            TrieNode t = find(node, chars[i]);
            if ( t == null) {
                t = new TrieNode(chars[i]);
                node.children.add(t);
            }
            node = t;
        }
        node.count++;
    }

    public static int search(TrieNode root, String key) {
        TrieNode node = root;
        char[] chars = key.toCharArray();

        for (int i = 0; i < chars.length && node != null; i++) {
            node = find(node,chars[i]);
        }
        return node == null ? 0 : node.count;
    }

    public static TrieNode find(TrieNode node, char c) {
        for (int i = 0; i < node.children.size(); i++) {
            if (node.children.get(i).value == c)
                return node.children.get(i);
        }
        return null;
    }

    public static void main(String[] args){
        String[] strings = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        TrieNode root = new TrieNode('1');

        for (int i = 0; i < 8; i++) {
            insert(root, strings[i]);
        }

        System.out.println(search(root, "the"));
    }
}
