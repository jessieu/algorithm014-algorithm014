# 学习笔记

## Trie Tree

![Zero-allocation Trie Traversal](https://nullprogram.com/img/trie/trie.svg)

- Keyword Tree based on the prefix of a string. N-ary Tree in essence.
- Each node consists of at max 26 children and edges connect each parent node to its children.
- We need to mark the last node of every key as end of word node.

### Common Trie Operations

1. Insert
   - Every character of the input key is inserted as an individual Trie node.
   - The key character acts as an index into the aray children.
   - Costs: O(k), k is the key length
2. Search 
   - Compare characters and move down.
   - Searching termination:
     1. Reach the end of the string
     2. Lack of key in the trie.
   - Costs: O(k), k is the key length

The memory requirements of Trie is O(AlphabetSize * keyLength * N) where N is number of keys in Trie.

## Union Find

- Also called **Disjoint Set**
- It keeps track of a set of elements partitioned into a number of disjoint(non-overlapping) subsets.

### A Union-Find algorithm Operations

1. Find
   - Determine which subset a particular element is in.
2. Union
   - Join two subsets into a single subset.

## Bidirectional BFS

It runs two simutaneous search to find smallest path from source to goal vertex.

1. Forward search from source vertex toward goal vertex.
2. Backward search from goal vertex toward source vertex.

**The search terminates when two graphs intersect.**

### When to use bidirectional BFS?

1. Both initial and goal states are unique and completely defined.
2. The branching factor is exactly the same in both directions.

## A* Search

- Optimize path-finding and graph traversal.
- Problem: Consider a square grid having many obstacles and we are given a starting cell and a target cell. We want to reach the target cell (if possible) from the starting cell as quickly as possible. 
- A* search: at each step it picks the node according to a value - ***f*** which is a parameter equal to the sum of two other parameters - ***g*** and ***h***. At each step it picks the node/cell having the lowest f, and process that node/cell.

## Red-Black Tree & AVL

### Red-Black Tree

- A binary search tree with one extra attribute for each node: the color.

  ```
  class TreeNode {
  	TreeNode left;
  	TreeNode right;
  	int val;
  	boolean color;
  }
  ```

- Properties:

  - Every node is either red or black.
  - Every leaf is black.
  - If a node is red, then both its children are black.
  - Every simple path from a node to a descendant leaf contains the same number of black nodes.

### AVL Tree

- A height balancing binary search tree. 
- AVL tree checks the height of the left and the right sub-trees and assures that the difference is not more than 1.