package com.ds.trie;

class TrieNode {
	int terminatined;
	TrieNode[] nodes = new TrieNode[26];
	
	TrieNode() {}
	
	public TrieNode next(char c) {
		return nodes[c-'a'];
	}
}

class Trie {
	TrieNode root;
	
	Trie() {
		this.root = new TrieNode();
	}
	
	public void insert(String s) {
		TrieNode current = root;
		
		for(int i=0; i<s.length(); i++) {
			TrieNode next = current.next(s.charAt(i));
			if(next == null) {
				current.nodes[s.charAt(i) - 'a'] = new TrieNode();
			}
			current = current.nodes[s.charAt(i)-'a'];
		}
		
		current.terminatined++;
	}
	
	public int search(String s) {
		TrieNode current = root;
		
		for(int i=0; i<s.length(); i++) {
			current = current.next(s.charAt(i));
			if(current == null)
				return 0;
		}
		
		return current.terminatined;
	}
	
	public void delete(String s) {
		TrieNode current = root;
		
		for(int i=0; i<s.length(); i++) {
			current = current.next(s.charAt(i));
			if(current == null)
				throw new RuntimeException("String not found");
		}
		
		if(current.terminatined != 0)
			current.terminatined--;
		else
			throw new RuntimeException("String not found");
		
		
	}
	
}

public class TrieExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.insert("pqrd");
		t.insert("pqrd");
		t.insert("pqrd");
		t.insert("pqrs");
		t.insert("pqrst");
		System.out.println(t.search("pqrd"));
		System.out.println(t.search("pqrs"));
		System.out.println(t.search("pqrst"));
		t.delete("pqrd");
		t.delete("pqrs");
		
		System.out.println(t.search("pqrd"));
		System.out.println(t.search("pqrs"));
		System.out.println(t.search("pqrst"));
	}

}
