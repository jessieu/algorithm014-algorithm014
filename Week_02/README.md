# 学习笔记

## Hash Map

**HashMap** stores elements in so-called *buckets* and the number of buckets is called *capacity*.

### 1. HashMap in Java7

1. Implementation: Array(bucket) and LinkedList

2. The default capacity is the power of two.

   1. Initial capacity is `2 << 4`, aka 16

   2. Whenever the capacity is not the power of two, it will be incremented to the nearest power of 2 by calling `roundToPowerOf2`  .

   3. Why power of two, not others?

      If the capacity of array is in power-of-two, the hash code can be easily converted to the index based on a simple `AND` operation and this seems to be more efficient as compared to modulus operation:

      ```
      index = hash & (capacity - 1);
      ```

      If the capacity is the power of two, whenever it minus 1, it will have a bunch of 1 in the result, and with `AND` operation, we can separate that much number of digits from the hash, which has the same effect as using `mod`, but more efficient.

3. Load Factor: 0.75. When `capacity * loadFactor > Thredshold`, rehash.

4. Problem of HashMap in Java7

   1. Not thread-safe. Deadlock.
   2. Malicious users can create [hash-collision DOS attack](https://www.hiawatha-webserver.org/weblog/30) to crash the server
      - When a webbrowser sends variables (GET or POST) to a website, the website application places those variables in an indexed array. For quick lookup, most languages use hash algoritms.
      - If a hacker sends a HTTP request in which he deliberately uses two keys which give the same hash and adds several thousands of other variables, the CPU of the webserver will be quite busy when looking up variables. 

### 2. HashMap in Java8

1. Implementation:  the data structure in which the values inside one bucket are stored is changed from a list to a balanced tree if a bucket contains **8** or more values, and it's changed back to a list if, at some point, only 6 values are left in the bucket. This improves the performance to be *O(log n)*.
   - The `treeify threshold` is 8 because under random hashCodes, the frequency of nodes in bins follows a Poisson distribution, which mean the probability of 8 nodes in a bucket is low.

### 3. Commonly Used Methods in HashMap

1. **`boolean containsKey(Object key)`** Return True if for a specified key, mapping is present in the map.
2. **`boolean containsValue(Object value)`** Return true if one or more key is mapped to a specified value.
3. **`boolean isEmpty()`** Check whether the map is empty or not. Returns true if the map is empty.
4. **`Object get(Object key)`** Retrieve or fetch the value mapped by a particular key.
5. **`Value get(Object key)`**: It returns the value for the specified key.
6. **`Object getOrDefault(Object key, V defaultValue)`** Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
7. **`Object putIfAbsent(K key, V value)`** If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value.
8. **`Set keySet()`**: It returns the Set of the keys fetched from the map.
9. **`int size()`**: Returns the size of the map – Number of key-value mappings.



## Tree

- A tree organizes its data in a **hierarchical**, **nonlinear** form

- A binary tree: each node can have up to 2 children

- A **binary search tree** is a binary tree that is **sorted** according to values in nodes. For each node n, a binary search tree satisfies the 3 properties:

  1. n's value is greater than all values in its left subtree T~L~

  2. n's value is less than all values in its right subtree T~R~

  3. T~L~ and T~R~ are both binary search trees

- Tree Height - the number of nodes on the **longest path** from the root to a leaf.

- In a **full binary tree** of height h, all nodes which are at a level less than h have two children.

- A **complete binary tree** of height h is full down to level h-1, with level h filled from left to right



### Binary Tree Traversal

- Preorder - display current node, then left subtree, then right subtree

```
if (T != null) {
	Display the data in T's root
	Traverse T's left subtree
	Traverse T's right subtree
}
```

- Inorder - display left subtree, then current node, then right subtree

```
if (T != null) {
	Traverse T's left subtree
	Display the data in T's root
	Traverse T's right subtree
}
```

- postorder - display left subtree, then right subtree, then current node

```
if (T != null) {
	Traverse T's left subtree
	Traverse T's right subtree
	Display the data in T's root
}
```



### Binary Search Tree

Retrieval, removal, and insertion operations depend on the height of the tree

#### 1. Search

```
boolean search(T, target) {
    if (T.isEmpty())
    	return false
    else if (target == T.getRootData())
    	return true
    else if (target < T.getRootData())
    	return search(left subtree of T, target)
    else
    	return search(right subtree of T, target)
}
```



#### 2. Insert

```
Traverse the binary tree in order, find the correct position and insert.
```



#### 3. Remove

There are 3 possibilities for target:

1. target is a leaf
- Deletion is trivial
2. target has exactly one child
   - Copy the child to the node and delete the child
3. target has two children
   - Find inorder successor of the node(minimum node in the right subtree). Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.



## Heap

- A heap (maxheap) is a complete binary tree that is either empty or whose root satisfies two properties:
  - Contains a value greater than or equal to the value in each of its children

  - Has heaps as its subtrees

- A minheap is similar, but the root has the smallest item



### Methods

1. Remove	

   Remove an item needs to remove the root and then rebuild the heap so it's still a heap.

    1. Copy the last item in the heap to the root node and then delete the last item.
    2. HeapifyDown(rebuild) to maintain the heap structure - trickle this item down until it reaches a node where we once again have a heap

2. Insert

- Insert the new item at the end, and trickle it up (HeapifyUp)

<hr>

Add or remove an item is `O(1)`, but heapify up or down is `O(logN)`. So in general, add and remove are O(logN).



### Create a Heap from an Array

- Suppose parent index is `i`, then index of left child is in `2i + 1`, and index of right child is in `2i + 2`



## Leetcode Problems

| Problem                                                      | Method 1                                                     | Method 2                                                     | Level  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ |
| [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/) | Sort two strings and compare                                 | Use an array as hash table, alphabets' ascii number as key. Count occurrences of each letter in the two strings and compare them, i.e.,increment counter for s, and decrement counter for t, if at any point, the counter drops below 0, return false immediately . | Easy   |
| [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Create a helper function to determine whether two strings are anagram. Use nested for loop, compare each string with the rest of string by calling the helper function. To avoid a word is grouped in more than one group, replace the visited string with some special character. | Use a hash map. Sort each string, and use the sorted string as key. The value is a list of string whose sorted string are the same as the key. The best thing is we can simply return the values of the map directly. | Medium |
| [589. N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/) | Recursion - Add root's value to result, then traverse its children. | Iteration - use a stack. However, because the stack is LIFO, if we want to maintain the pop-out order as the preorder, we have to **add children to the stack reversely**. | Easy   |
| [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Recursion - traverse left child, add root to result, then traverse right child. | Iteration - use a stack. Traverse **left subtree all the way down**, then add the left child to the result. Switch to the right child. | Medium |
| [144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | Recursion - Add root's value to result, traverse left subtree, then right subtree. | Iteration - use a stack. Add current node's value to result. Add  current node's right child to stack, then right child. | Medium |
| [429. N-ary Tree Level Order Traversal](https://leetcode.com/problems/n-ary-tree-level-order-traversal/) | Recursion - Similar to 589, what's different is to carry level information at each recursive step. Whenever, the result list's size less than the level, create a new level and it indicates moving to the next level. | Iteration - similar to 589, but instead of a stack, use a queue. Poll the same level nodes from front, and add their children to back. | Medium |
| [263. Ugly Number](https://leetcode.com/problems/ugly-number/) | Divide the num by 2, 3, 5 continuously. If the number becomes 1, then it's an ugly number otherwise not. |                                                              | Easy   |
| [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | Use a Min Heap structure,implemented by priority queue(small value has higher priority). Iterate the array and build a hashmap that map number to its frequency. Iterate the hash map and build the min heap by frequencies. Remove element when the size of heap is greater than k, ie., keep the largest number only) | Quick Select - will do later                                 | Medium |



## Conclusion

This weeks feel much better. At least for some easy problems, I can come up a brute force solution. However, I need more practices on how to explain my solution clearly. I really don't like the way how they organize the lecture and homework. Can they just put the corresponding homwork underneath each chapter instead of all in the last chapter....