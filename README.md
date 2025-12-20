![Logo](https://media.licdn.com/dms/image/v2/D4D3DAQG2kdPKaBLEdg/image-scale_191_1128/image-scale_191_1128/0/1684485954234/volkswagen_digital_hub_cover?e=1766833200&v=beta&t=og9BxfLOAuz12bCHk57cH0fwcpnad-DrlY4z98x5tSs)

# VW Cleaning robot project

---

This program was created to control the robot that cleans the floor of VW's industrial buildings.

## Project overview

---

This project focuses on building an application to control autonomous cleaning robots at the Volkswagen Wolfsburg Factory.
These robots are designed to clean factory floors efficiently while using on-board cameras to inspect the environment and detect potential issues or hazards.

As part of a pilot test, the robots operate on an empty, rectangular factory floor with no obstacles.
This controlled environment allows us to evaluate the robots’ autonomous navigation, cleaning performance, and ability to reach corners and hard-to-clean areas.
The goal is to validate the system before deploying it in real industrial scenarios.

## Robot Navigation and Control

---

The factory floor is represented as a grid, with the bottom-left corner defined as coordinates `(0, 0)`.
Each robot’s position is described using X and Y coordinates along with a direction it is facing:
`North (N)`, `East (E)`, `South (S)`, or `West (W)`.
For example, `(0, 0, N)` means the robot starts at the bottom-left corner facing north.
Moving north from `(X, Y)` results in `(X, Y + 1)`.

Robots are controlled using a sequence of instructions:

- L: Rotate 90 degrees to the left
- R: Rotate 90 degrees to the right
- M: Move forward one grid unit in the current direction


## Input Format and Execution

---

The system input consists of:

1. The grid coordinates of the workspace.
2. Information about each robot, provided in pairs of lines:
    - The robot’s starting position and orientation.
    - A string of movement instructions.

Robots operate sequentially, meaning each robot completes its entire instruction set before the next one begins.

## Output Format and Execution

---

The application returns the final position and orientation of each robot after executing its commands.

`1 3 N`


## Example test case

---

Sample input:  
`5 5`  
`1 2 N`  
`LMLMLMLMM`  
`3 3 E`  
`MMRMMRMRRM`

Sample output:  
`1 2 N`  
`1 2 N`