Student name: Mohamed Ashraf Ali
Student number: 200297273

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Vehicle]

This superclass is extended into at least two subclasses called [Car and Motorbike]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Car] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [mass]

These/this new properties/property are used by the subclass in the following way: [Used to work out momentum which is used for the collision method.]

Subclass [Car] extends the superclass by overriding the following methods (there must be at least one): [vehicleName, line 14]

These overridden methods are used in the working code in the following places: [In the game class, lines: 126, 136, 142, 151, 157, 163]

Subclass 2.

Subclass [Motorbike] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [hasFallen]

These/this new properties/property are used by the subclass in the following way: [The motorbike object has a chance of falling. This boolean is true if it has fallen.]

Subclass [Motorbike] extends the superclass by overriding the following methods (there must be at least one): [rand_maxSpeed (Line 12) and vehicleName (Line 17)]

These overridden methods are used in the working code in the following places: [Game class: vehicleName (line 142 and 163), rand_MaxSpeed (line 140 and 161)]


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [Game class (line 100)]. The name of the superclass used in this example is [Track] and the subclasses used are [RaceTrack].

Late dynamic binding can be seen in [Game class (line 106)].

[The method is overriden because for this object, I changed the values of the length to suit the type of track the user has selected. If I had not done this, the values would have not been appropriate for this specific object. In a later method, I send the superclass type Track because the user may have selected a different type of Track (line 171.]

Example 2.

The substitution principle can be seen in use in [Game class line 123]. The name of the superclass used in this example is [Vehicle] and the subclasses used are [F1, Stock, Motorbike].

Late dynamic binding can be seen in [Game class (line 124, 130, 140, 149, 155, 161)].

[Vehicles of different subclasses are put into an ArrayList, which means that they all need to be of the Vehicle object. A nested-for loop iterates through the Vehicles calling classes specific to the subclass and to the super class.]
