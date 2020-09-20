# 学习笔记

## Dynamic Programming

### General Idea

It's used to solve optimization problem.

1. Break down the complex problem into simple subproblems.
2. Find optimal solution of these subproblems.
3. Save the results of subproblems (**Memoization**)
4. Reuse them so that same subproblem is not calculated more than once.
5. Finally calculate the result of complex problem.

> Applicable to problems that are having properties of **overlapping subproblems & optimal substructure**.


### Elements of Dynamic Programming

1. Define problem variables and decide the states. What will change after each decision?
2. Define table structure and size. 
   1. The table structure is defined by the number of problem variables.
   2. The size of this table is defined by the total number of different subproblems.
3. Table Initialization
4. Iterative structure to fill the table.
5. Termination and returning final solution.



