# 学习笔记

## Greedy

### Elements of the Greedy Strategy
1. Greedy Choice 
   1. Idea:
      
      - Local optimal choice at each step can yield a globally optimal solution
2. Difference btw Greedy and DP
   
      |          |                Greedy                 |            Dynamic Programming            |
      | :------: | :-----------------------------------: | :---------------------------------------: |
      |  Chioce  | Make choice before solving subproblem | Solve subproblem before making any choice |
   | Approach |               Top-Down                |                 Bottom-Up                 |
   
2. Optimal Substructure 
   
   - A problem exihibits optimal substructure if an optimal solution to the problem contains within it has optimal solutions to subproblem.

## Binary Search

The general idea:

- Set left and right, compute mid
- Find the target with mid, adjust left and right boundaries coordinately.

Questions:

1. When to use `left < right` and when to use `left <= right`?

```
When left <= right ?
- When we are lazy and want to finish valid return inside the while loop
- When there's only one element in the array and it is the target, we want the index return within the while loop, and not falls to return -1
- See 704
```

```
When left < right ?
- In this case, the loop breaks at left == right, and the left/right may be the target we are looking for, so we have to do extra work to check whether the left/right is the target, and return index if found.
- See 278
```

2. What are some pitfalls would cause infinite loop?

- After we ensure the midpoint is not the target, we did not move away from midpoint. E.g., left = mid, right = mid are incorrect. Consider the situation [-1,0,3,5,9], target = 2, we have no problem to shrink the range to [-1,0], but since the target cannot be found, and the target is greater than mid, we would  assign right = mid again and again. However, if we use right = mid-1 instead, left, right and mid are all pointing to the first element, we can break from the loop after next condition check which makes the right <  left, and return -1 by default.



## BFS & DFS

### DFS

If a node has neighbors, arbitrarily pick one of those and go there *unless we’ve already seen that node*. 

```
DFS(graph, start_node, end_node):
    frontier = new Stack()
    frontier.push(start_node)
    explored = new Set()
    while frontier is not empty:
        current_node = frontier.pop()
        if current_node in explored: continue
        if current_node == end_node: return success
        
        for neighbor in graph.get_neigbhors(current_node):
            frontier.push(neighbor)
        explored.add(current_node)
```

### BFS

Explore all the neighbors of our starting node before exploring any other node.

```
BFS(graph, start_node, end_node):
    frontier = new Queue()
    frontier.enqueue(start_node)
    explored = new Set()
    
    while frontier is not empty:
        current_node = frontier.dequeue()
        if current_node in explored: continue
        if current_node == end_node: return success
        
        for neighbor in graph.get_neigbhors(current_node):
            frontier.enqueue(neighbor)
        explored.add(current_node)
```

<img src="https://i.loli.net/2020/09/06/ryfAD9mESgNMlJR.png" style="zoom:80%;" />

## References

1. [DFS & BFS](https://medium.com/tebs-lab/breadth-first-search-and-depth-first-search-4310f3bf8416)