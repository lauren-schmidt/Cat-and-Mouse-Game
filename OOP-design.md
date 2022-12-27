# OOP Design Document

[Update the path below so your UML diagram appears in the rendered markdown, once you do, remove this text!]

![](/path/to/UML.ong)

## Overview

## Creature Class

Includes variables that are universal for all of the creatures in the City, as well as a general constructor for objects of the Creature class. Includes getter and setter methods for the GridPoints, and getters for the Lab and Direction variables. Contains a methods to:

- Compute the distance to another creature
- Make a random turn
- toString method
  And contains abstract methods for
- step
- takeAction
  That are implemented differently for each child class related to the Creature class, depending on that particular Creature's actions.

## Mouse Class

Contains a constructor, an implementation of takeAction() and step(), and an override of the randomTurn() method.
The Mouse has the following behavior:

- Has a 20% chance of turning in a random direction
- Creates a new baby mouse at the same location after 20 rounds
- Dies after 30 rounds of simulation time
- Color is always set to blue
- If sharing a location with an instanceof Cat, ZombieCat, or KillerRabbit classes, then set the boolean dead equal to "true" because it is eaten.

OOP: The Mouse class overrides the takeAction, step, and randomTurn methods that are defined in Creature. It is able to do this because it extends Creature. It is able to modify elements of the Creature class to fit its functionality, which demonstrates object-oriented programming.

## Cat Class

Contains a constructor, an implementation of takeAction() and step(), and an override of the randomTurn() method. Contains a new method, search(), which finds the closest Creature within 20 GridPoints of the cat. If the Creature that this function locates is an instanceof the Mouse class, it returns the closest mouse.
The Cat has the following behavior:

- Changes direction 5% of the time
- Displayed as a yellow dot when idle, and cyan when chasing a Mouse
- If search() returns a Mouse, and the Mouse is within 20 GridPoints in any direction of the current Cat, the cat will chase after it.
- If on the same GridPoint as a Mouse, will eat the mouse
- Jumps two spaces at a time when moving
- Dies if has not eaten within 50 moves.
- Dies if on the same square as a ZombieCat, and turns into a ZombieCat
- Dies if on the same square as a KillerRabbit

OOP: The Cat class overrides the takeAction, step, and randomTurn methods that are defined in Creature. It is able to do this because it extends Creature. It is able to modify elements of the Creature class to fit its functionality, which demonstrates object-oriented programming.

## ZombieCat Class

Contains a constructor, an implementation of takeAction() and step(), and an override of the randomTurn() method. Contains a new method, search(), which finds the closest Creature within 40 GridPoints of the ZombieCat. If the Creature that this function locates is an instanceof the Mouse or Cat class, it returns the closest creature.
The ZombieCat has the following behavior:

- If shares a gridpoint location with a cat or a mouse, eats the mouse
- Can search up to 40 squares in any direction
- Dies after 100 rounds without eating
- Creates a new ZombieCat anytime it eats a Cat
- Not in an active chase = Lab is set to black
- In a chase = Lab is set to red
- Jumps three spaces at a time when moving

OOP: The ZombieCat class overrides the takeAction, step, and randomTurn methods that are defined in Cat. It is able to do this because it extends Cat, which extends Creature. It is able to modify elements of both the Cat and Creature class to fit its functionality, which demonstrates object-oriented programming.

## KillerRabbit Class

Contains a constructor, an implementation of takeAction() and step(), and an override of the randomTurn() method. Contains a new method, search(), which finds the closest Creature within 40 GridPoints of the KillerRabbit. It eats all creatures it shares a location with.

- If shares a gridpoint with any Creature (object of the Creature Class other than a KillerRabbit) it eats it.
- Has a steplength of 4
- Magenta when stationery and orange when chasing
- Has a 10% chance of turning in a random direction
- Spawns three new rabbits for every creature eaten ... multiplies like rabbits.

OOP: The KillerRabbit class overrides the takeAction, step, and randomTurn methods that are defined in Cat. It is able to do this because it extends Cat, which extends Creature. It is able to modify elements of both the Cat and Creature class to fit its functionality, which demonstrates object-oriented programming.
