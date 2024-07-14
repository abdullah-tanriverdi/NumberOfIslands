# Number of Islands
This project implements an algorithm to count the number of islands in an m x n 2D binary grid. The '1' characters in the grid represent land, while the '0' characters
represent water. An island is defined as a group of '1's connected horizontally or vertically. The project uses 
the BFS (Breadth-First Search) algorithm to calculate the number of islands.

## Example

    char[][] grid1 = {
    {'1', '1', '1', '1', '0'},
    {'1', '1', '0', '1', '0'},
    {'1', '1', '0', '0', '0'},
    {'0', '0', '0', '0', '0'}
    };

    char[][] grid2 = {
    {'1', '1', '0', '0', '0'},
    {'1', '1', '0', '0', '0'},
    {'0', '0', '1', '0', '0'},
    {'0', '0', '0', '1', '1'}
    };

 
    //1
    //3



### Description    

This project calculates the number of islands in a given grid using the BFS algorithm. The main steps of the algorithm are as follows:

Traverse each cell in the grid.
If a cell is '1' and has not been visited before:
Start a BFS to mark all cells in this island as visited.
Increment the island counter.
Return the island counter once the entire grid has been traversed.

The BFS algorithm performs a breadth-first search using a queue. It moves in four directions (up, down, right, left) from each cell and visits all connected cells.
