# 学习笔记

## The New Stuffs I Learned This Week

1. Skip List

   ![Skip List](https://iq.opengenus.org/content/images/2019/03/skip-list.png)

   1. Linked List 

      1. Hard to search in less than O(n) time. 
      2. Hard to jump to the middle.

   2. Properties

      1. Keys in sorted order
      2. O(logN) levels
      3. Each higher level contains half the elements of its lower level

   3. Search

      ```
      When search for k:
       If k = key, done!
       If k < next key, go down a level
       If k ≥ next key, go right
      ```

      - O(log n) levels --- because you cut the # of items in half at each level
      - Will visit **at most 2 nodes per level**

   4. Delete and Insert

      - Need to rearrange
      - Time Complexity: `O(logN)`

2. Why should I use Deque over Stack?

   1. Object-oriented Design. `Deque` is an interface, while `Stack` is a class. You can only extend one class. Implements an interface will give you more flexibility and freedom.
   2. Inconsistency. `Stack` extends `Vector`, which means that you can access the Stack by index. It violates the LIFO.
   3. Synchronization. `Deque` is thread-safe, but `Stack` is not.

3. HashMap

   1. An array of mini-lists
   2. Internal lookup:
      1. Quickly determine the bucket number in which this element may reside (using `key.hashCode()`).
      2. Go over the mini-list and return the element that matches the key (using `key.equals()`).
   3. On collisions, items are chained together like a linked list.
   4. Sometimes, if we want to keep track on character and its frequency, an array might be better.
      - For string input is `ascii` , use new array, size 256, convert the character in string to  array index by using `char-'0'` 



## Leetcode Problems

| Problem                                                      | Brute Force                                                  | Best                                                         | Level    |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | -------- |
| [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Use an extra space, an ArrayList, to store the index of element in the first iteration. Then copy them to the array. | Two pointers: slow-runner is used to pin the element to be replaced, while fast-runner skips duplicate and find next non-duplicated element. | **Easy** |
| [189. Rotate Array](https://leetcode.com/problems/rotate-array/) | Rotate all the elements of the array in k steps by rotating the elements by 1 unit in each step | 1. Reverse original array,  2. Reverse first `k` elements. 3. Reverse last `n-k` element | Easy     |
| [283. Move Zeros](https://leetcode.com/problems/move-zeroes/) | Count the number of zeros. Use an extra array to copy all non-zero elements in order. Append zeros to the end of new array. | Two pointers: zeros tracking the index of first zero and nonZeros tracking the index of first non-zero. Swap zeros and nonZeros. | Easy     |
| [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | Recursion with formula: {`list1[0]+mergeTwoLists(list1[1:],list2), list1[0]<list2[0]`   `list2[0]+mergeTwoLists(list1,list2[1:]), otherwise`} | Iterate two lists in parallel, always select the smaller one append to the result list. Watch out for unequal length of two lists. Copy the remaining to the result list. | Easy     |
| [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) | Two Pointers(from beginning). Run two input arrays in parallel and use a new array to hold the smaller value at each iteration. | Two Pointers(from the end). Run two input arrays in parallel. Put the larger one to the end of nums1. | Easy     |
| [1. Two Sum](https://leetcode.com/problems/two-sum/)         | Loop through each element x*x* and find if there is another value that equals to target - x. | `One-pass HashMap`. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. If it exists, we have found a solution and return immediately. | Easy     |
| [66. Plus One](https://leetcode.com/problems/plus-one/)      |                                                              | Identify the rightmost digit which is not equal to nine and increase that digit by one. If it's equal to nine, calculate the carry and sum, and bring the carry forward along. | Easy     |
| [641. Design Circular Deque](https://leetcode.com/problems/design-circular-deque/) | Use ArrayList, front, end, and counts variable to keep track on the index and queue size. To calculate the index - `last = (last + 1) % capacity;` and `front = ((front - 1) % capacity + capacity) % capacity;` | Doubly Linked List. Need to define the linked list class.    | Medium   |
| [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) |                                                              |                                                              | Hard     |



## Conclusion

This week is the first week of the Algorithm Bootcamp, and also the last week of my summer class. Honstly, I did not spend much time on the algorithm study. However, next week, will spend more time on it. The biggest thing I learned from this week is how to analyze the problem when you have no idea, either the Brute Force or divide and conquer. Don't be shame of coming up a tedious or inefficient solution. And I found out that I have ideas on solving some problem, but just hard to organize them together and make things work. I definitely need a lot of practices. 