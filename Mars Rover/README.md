Mars Rover Kata
===============
Video demo @ https://www.youtube.com/watch?v=24vzFAvOzo0

Develop an api that moves a rover around on a grid.
You are given an initial starting position point of (0,0) which are X and Y coordinates
on a grid of (10,10).

const std::string execute(const std::string& commandSequence);

Output
======
A string that describes the current X and Y coordinate and the current direction that the rover is
facing separated by colons.
e.g. 2:3:N means x pos is 2, y pos is 3 and is currently facing north

Rules
=====
1: N is the initial direction it is facing (i.e. N, E, S, W)
2: L and R allow the rover to rotate left and right
3: M allows the rover to move one unit in the current direction.
4: The rover receives a sequence of commands e.g. "RMMLM" rotates to the right, moves two units,
        rotates to the left and moves one more unit.
5: The rover wraps around if it reaches the end of the grid.
6: The grid may have obstacles. If a given sequence of commands encounters an obstacle then the rover
        will move to the last possible coordinate and then report the obstacle coordinate.
        e.g. OB:2:3:N
