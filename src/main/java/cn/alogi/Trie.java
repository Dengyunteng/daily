package cn.alogi;

public class Trie {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        if(text == null)return;
        TrieNode p = root;
        for(int i = 0; i < text.length; i++){
            int pos = text[i] - 'a';
            if(p.children[pos] == null){
                p.children[pos] = new TrieNode(text[i]);
            }
            p = p.children[pos];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] text){
        if(text == null) return false;
        TrieNode p = root;
        for(int i = 0; i < text.length; i++){
            int pos = text[i] - 'a';
            if(p.children[pos] == null){
                return false;
            }
            p = p.children[pos];
        }
        return p.isEndingChar;
    }
}
class TrieNode{
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data){
        this.data = data;
    }
}
