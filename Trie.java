import java.util.*;

public class Trie {

  private class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
      this.children = new HashMap<Character, TrieNode>();
      this.isEndOfWord = false;
    }
  }

  private TrieNode root;

  Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {

    TrieNode temp = this.root;
    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      TrieNode temp2 = temp.children.get(c);

      if (temp2 == null) {
        temp2 = new TrieNode();
        temp.children.put(c, temp2);
      }
      temp = temp2;
    }
    temp.isEndOfWord = true;
  }

  public void insertRec(String word) {

    insertRec(root, word, 0);
  }

  public void insertRec(TrieNode current, String word, int currIndex) {

    if(currIndex == word.length()) {
      current.isEndOfWord = true;
      return;
    }

    char c = word.charAt(currIndex);
    TrieNode temp = current.children.get(c);

    if(temp == null) {
      temp = new TrieNode();
      current.children.put(c, temp);
    }

    insertRec(temp, word, currIndex++);
  }

  public boolean search(String word) {

    TrieNode temp = this.root;

    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(temp.children.containsKey(c)) {
        temp = temp.children.get(c);
      } else {
        return false;
      }
    }
    return temp.isEndOfWord;
  }

  public boolean searchRec(String word) {
    return searchRec(this.root, word, 0);
  }

  public boolean searchRec(TrieNode curr, String word, int currIndex) {

    if(currIndex == word.length()) {
      return curr.isEndOfWord;
    }

    char c = word.charAt(currIndex);
    if(curr.children.containsKey(c)) {
      curr = curr.children.get(c);
    } else {
      return false;
    }

    return searchRec(curr, word, currIndex++);
  }

  public boolean delete(String word) {
    return deleteHelper(this.root, word, 0);
  }

  public boolean deleteHelper(TrieNode curr, String word, int currIndex) {

      if (currIndex == word.length()) {
        if (curr.isEndOfWord == false) {
          return false;
        }
        curr.isEndOfWord = false;

        return curr.children.size() == 0;
      }

      char c = word.charAt(currIndex);
      if(curr.children.containsKey(c)) {
        curr = curr.children.get(c);
      }
      else {
        return false;
      }

      boolean toDelete = deleteHelper(curr, word, currIndex++);

      if(toDelete) {
        curr.children.remove(c);
        return curr.children.size() == 0;
      }

      return false;
  }

  public static void main(String[] args) {
    Trie t = new Trie();

    t.insert("test");
    t.insert("testing");
    t.insert("bird");
    t.insert("birdy");

    System.out.println(t.search("testing"));
    System.out.println(t.search("birdy"));

    System.out.println(t.delete("test"));
    System.out.println(t.search("testing"));
  }

}
