# Project 2


## Help Received

Please document any help you received in completing this lab. Note that the what you submit should be your own work. Refer to the syllabus for more details. 

I received help from the instructional team in office hours. 

## Describe your work


## Part 1: UML Diagram

Note that you must do two tasks here:

1. Add to your repo a document `UML.png` that is a image of your UML diagram
2. Update the document `OOP-design.md` that describes your OOP design, referencing your document.
3. You will receive feedback on your design in a github issue

For your final submission, please update `UML.png` with the final UML diagram and `OOP-design.md` with your final description. Below describe the major changes you made.

Major changes made in UML diagram
- Added KillerRabbit class instead of Rat class, which extends Cat instead of Mouse 
- Added search methods for Cat, ZombieCat, and KillerRabbit 
- Removed unnecessary "baby" method for Mouse class
- Removed unnecessary "foodNearby" boolean
- Updated moves and movesSinceEaten variables for each Class as are implemented in code. 
## Part 2: Implementation

What level simulation did you achieve

Level : [0,1,2,3,4] <-- choose one!

If you completed Level 4, describe the additional creature you added to the simulation.

I completed level 4 of the simulation, and added a `KillerRabbit` creature to the simulation. The characteristics of the KillerRabbit include:
1. Dies after 40 rounds of simulation time, or after 20 moves without eating.  
2. Eats any other creature that it lands on. 
3. Adds 3 new KillerRabbits at its location for every creature that it eats. 

