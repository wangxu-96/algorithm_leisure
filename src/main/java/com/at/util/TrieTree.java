package com.at.util;

/**
 * 字典树
 */
public class TrieTree {

    /**
     * 字典树节点
     */
    static class trieNode{
        int count;//次数
        trieNode[] children = new trieNode[26];//子节点，仅字母
    }

    /**
     * 创建字典树节点
     */
    public static trieNode createTrieNode(){
        trieNode trieNode = new trieNode();
        trieNode.count = 0;
        for (int i = 0; i < 26; i++) {
            trieNode.children[i] = null;
        }
        return trieNode;
    }

    public static void insert(trieNode root,String key){
        trieNode trieNode = root;
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (trieNode.children[chars[i]-'a'] == null){
                trieNode.children[chars[i]-'a'] = createTrieNode();
            }
            trieNode = trieNode.children[chars[i]-'a'];
        }
        trieNode.count++;
    }

    public static int search(trieNode root,String key){
        trieNode node = root;
        char[] chars = key.toCharArray();

        for (int i = 0; i < chars.length && node != null; i++) {
            node = node.children[chars[i]-'a'];
        }
        return node == null? 0:node.count;
    }


    public static void main(String[] args){
        String[] strings = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        trieNode root = createTrieNode();

        for (int i = 0; i < 8; i++) {
            insert(root, strings[i]);
        }

        System.out.println(search(root, "there"));
    }


}
