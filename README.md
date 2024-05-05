# Maze Solver
Java program designed to solve mazes.

## Menu
![Menu](https://github.com/Adam035/Maze-Solver/assets/164177546/d57444f8-71ef-42a4-87f0-44abc6abea13)

The menu panel is used to select the file and set the delay

## Maze
![Maze](https://github.com/Adam035/Maze-Solver/assets/164177546/75b8fd75-8f62-498e-a5fc-0f5d70ead89d)

Selected maze should be a specific file. Each pixel represents one field, it could be starting point, endpoint, wall or blank space. Field types are assigned to a specific colors.
* Start 🠦 ![#b5e61d](https://placehold.co/15x15/b5e61d/b5e61d.png) `#b5e61d`
* Stop 🠦 ![#ed1c24](https://placehold.co/15x15/ed1c24/ed1c24.png) `#ed1c24`
* Wall 🠦 ![#000000](https://placehold.co/15x15/000000/000000.png) `#000000`

Every other color will be treated like a blank spase

## Solver
![Solver](https://github.com/Adam035/Maze-Solver/assets/164177546/86787ea1-d972-4952-8db7-453f3648d903)

Maze is solved by using the simplest method, bruteforce :). The track is implemented as a linked list. If a node is neighbor of the tail and has not been visited before, then it is added to the list. A node is selected depending on its position from the tail, the highest priority is given to those above, then to the right, then down, those on the left are last. If there is no node to add (all neighbors of the tail were visited), then the last elements are removed from the list until a new node can be added (has not been visited yet).

## Plans
* Maze building program
* Other methods of solving
