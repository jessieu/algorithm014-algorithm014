# 学习笔记

## Bit Manipulation

| x ^ 0s = x  | x & 0s = 0 | x \| 0s = x  |
| ----------- | ---------- | ------------ |
| x ^ 1s = ~x | x & 1s = x | x \| 1s = 1s |
| x ^ x = 0   | x & x = x  | x \| x = x   |

- Two types of right shift:

  1. arithmetic right shift: shift values to the right but fill in the new bits with the value of the sign bit.

     ```
     a = 10110101
     a >> 1
     a = 11011010
     ```

  2. logical right shift: shift the bits and put a 0 in the most significant bit. 

     ```
     a = 10110101
     a >>> 1
     a = 01011010
     ```

### Common Bit Tasks: Getting and Setting

1. Get Bit

   ```java
   boolean getiBit(int num, inti) {
   	return ((num && (1 << i)) != 0);
   }
   ```

2. Set Bit

   ```java
   int setBit(int num, int i) {
   	return num | (1 << i);
   }
   ```

3. Clear Bit

   ```java
   // clear ith bit only
   int clearBit(int num, int i) {
       int mask = ~(1 << i);
       return num & mask;
   }
   // clear all bits from the most significant bit through i
   int clearBitMSBthroughI(int num, int i) {
       int mask = (1 << i) - 1;
       return num & mask;
   }
   // clear all bits from i through 0
   int clearBitsIthrough0(int num, int i) {
       int mask = (-1 << (i + 1));
       return num & mask;
   }
   ```

4. Update Bit

   ```java
   int updateBit(int num, int i, boolean bitIs1) {
       int value = bitIs1 ? 1 : 0;
       int mask = ~(1 << i);
       return (num & mask) | (value << i);
   }
   ```

   

## Bloom Filter

- Probabilistic data structure.
- Tells whether an element **may be** in a set, or **definitely not**.
- **False positives: ** a search for a nonexistent element can give an incorrect answer.
  - more elements in the filter, the error rate increases.

### Implementation of Bloom Filter

Bit array + hash map

An empty Bloom filter is a bit array of m bits, all set to 0. There are also k different hash functions, each of which maps a set element to one of the m bit position.

- To add an element, feed it to the hash functions to get *k* bit positions, and set the bits at these positions to 1.
- To test if an element is in the set, feed it to the hash functions to get k bit positions.
  - If any of the bits at these positions is 0, the element **definitely isn’t** the set.
  - If all are 1, then the element **may be** in the set.

![Bloom filter](https://yourbasic.org/algorithms/bloom-filter.svg)

## LRU Cache

- Organize items in order of use.
- Can quickly identify which item hasn't been used for the longest amount of time.
- Often implemented by pairing a doubly linked list with a hash map.

### LinkedHashMap as LRU Cache in Java 

Unlimited Capacity

```java
class LRUCacheDemo {
    public static void lruCacheTest() {
        // if we pass false to the constructor, it will not behave like a LRU cache
        Map<String, String> lruCache = new LinkedHashMap<>(16, 0.75f, true);
        lruCache.put("a", "A");
        lruCache.put("b", "B");
        lruCache.put("c", "C");
        System.out.println(lruCache); // {a=A, b=B, c=C}
        
        lruCache.get("a");
        System.out.println(lruCache); // {b=B, c=C, a=A}
        
        lruCache.get("b");
        System.out.println(lruCache); // {c=C, a=A, b=B}
    }
}
```

Limited Capacity

```java
class LRUCacheDemo {
    public static void lruCacheTest() {
        Map<String, String> lruCache = new LRUCache<>(16, 0.75f, true);
        lruCache.put("a", "A");
        lruCache.put("b", "B");
        lruCache.put("c", "C");
        System.out.println(lruCache); // {a=A, b=B, c=C}
        
        lruCache.get("a");
        System.out.println(lruCache); // {b=B, c=C, a=A}
        
        lruCache.put("d", "D"); // eldest entry b=B will be deleted
        System.out.println(lruCache); // {c=C, a=A, d=D}
    }
}
class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private static final int MAX_ENTRIES = 3;
    public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }
    // Invoke by put and putAll after inserting a new entry into the map
    public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
```



## Sorting

### Bubble Sort

```java
class BubbleSort {
  // Sort the input array
  public static void bubbleSort(int[] arr){
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (arr[j] < arr[i]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
```

### Selection Sort

```java
class SelectionSort {
  public static void selectSort(int[] arr) {
    int len = arr.length;

    for (int i = 0; i < len - 2; i++) {
      int currentMin = arr[i];
      int index = i;
      for (int j = i; j < len; j++) {
        if (arr[j] < currentMin) {
          currentMin = arr[j];
          index = j;
        }
      }
      arr[index] = arr[i];
      arr[i] = currentMin;
    }
  }
}
```

### Insertion Sort

```java
class InsertionSort {
  public static void insertSort(int[] arr) {
    int len = arr.length;
  
    for (int i = 1; i < len; i++) {
      int key = arr[i];
      int j = i - 1;
      // insert element into proper position
      while (j >=0 && arr[j] > key) {
        // shift
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = key;
    }
  }
 }
```

### Merge Sort

```java
class MergeSort {
  public static void merge(int[] arr, int low, int mid, int high) {
    int n = high-low + 1;
    int[] merged = new int[n];
    int left = low;
    int right = mid + 1;
    int count = 0;
    while (left <= mid && right <= high) {
      if (arr[left] < arr[right]) {
        merged[count++] = arr[left++];
      }else {
        merged[count++] = arr[right++];
      }
    }

    while (left <= mid) {
      merged[count++] = arr[left++];
    }
    while (right <= high) {
      merged[count++] = arr[right++];
    }

    for (int i = 0; i < n; i++) {
      arr[low+i] = merged[i];
    }
  }


  public static void mergeSort(int[] arr, int low, int high) {
    int mid = low + (high - low) / 2; // avoid overflow
    if (low < high) { // if this is not checked, stack overflow
      mergeSort(arr, low, mid);
      mergeSort(arr, mid+1, high);
      merge(arr, low, mid, high);
    }
  }
}
```

### Quick Sort

```java
class QuickSort {
  // here we use the end as pivot
  public static int partition(int[] arr, int low, int high) {
    int left = low;
    int right = high - 1;
    int pivot = high;

    while (true) {
      while (arr[left] < arr[pivot])
        left++;
      while (right > 0 && arr[right] > arr[pivot])
        right--;

      if (left >= right) {
        break;
      } else {
      	// swap left and right
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
    }
    // swap left and pivot
    int temp = arr[left];
    arr[left] = arr[pivot];
    arr[pivot] = temp;

    // return new pivot
    return left;
  }

  public static void quickSort(int[] arr, int low, int high) {
    // partition the original array into two halves around p
    if (low <= high) {
      int pivot = partition(arr, low, high);
      quickSort(arr, low, pivot - 1); // recursively sort the first partition
      quickSort(arr,pivot+1, high); // recursively sort the second partition
    }
  }
}
```

![Must-Know Sorting Algorithms in Python - Zax Rosenberg](https://zaxrosenberg.com/wp-content/uploads/2017/12/sort_complexity.png)

