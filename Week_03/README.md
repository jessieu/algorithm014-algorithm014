# 学习笔记

## Divide and Conquer

- 3 steps:
  1. **Divide**: Divide a large problem into small pieces
  2. **Conquer**: solve small subproblems recursively until solved
  3. **Merge**: Merge the solution of small subproblems
- Divide &  Conquer vs. Dynamic Programming
  - Both divide a problem into subproblems
  - Divide and Conquer should be used when same subproblems are not evaluated many times. Otherwise Dynamic Programming or Memoization should be used.

### Template for Divide and Conquer

```java
private static int divide_conquer(Problem problem, int param, … ) {
    // recursion terminator
	if (problem == NULL) {
		int res = process_last_result();
		return res; 
	}
	
	// process current problem
	subProblems = split_problem(problem)
	
	// merge
	res0 = divide_conquer(subProblems[0])
	res1 = divide_conquer(subProblems[1])
	result = process_result(res0, res1);
	
	return result;
}
```



## Recursive Backtracking

- Useful for constraint satisfaction problems that involve assigning values to variables according to a set of constraints.
  - N-queens
  - Map color
  - Others: combination, subset, room scheduling
- General idea is to try all possible combinations. It can be thought of selective tree. Initial starting position is tree node, and the final state is leaf. 
  - At each node, we eliminate choices that are obviously not possible and proceed to recursively check only those that have potential. This way, at each depth of the tree, we mitigate the number of choices to consider in the future.
- Backtracking reduces the # of possible value assignments that we consider, because it **never considers invalid assignments**.… 
- Using recursion allows us to easily handle an arbitrary number of variables. 
  - stores the state of each variable in a separate stack frame

### Template for Recursive Backtracking

```java
private void backtracking(Problem problem, Solution solution, other params) {
    // terminator
    if (found a solution) {
        addToFinalResult();
        return;
	}
    // process current problem
    for (val = first to last) {
        if (isValid(val, n)) {
			subProblems = split_problem(problem)
            solution.add(val);
            backtracking(subProblem, soultion, other params);
            solution.removeValue(val); // backtrack other solution
        }
	}
}
```

