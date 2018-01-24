# Lab 4

### Question 1 Cereal

ArrayList practice. 

*	Remove "Oatmeal" from the ArrayList.
*	Add the name of your favorite breakfast food to the ArrayList.
*	Add "Cornflakes" to the ArrayList.
*	Print all of the items in the ArrayList, one per line.
*	Print a message if the ArrayList contains “Special K”. Print a different message if it does not contain "Special K".
*	(Optional) non-programming question: what does Captain Crunch have to do with computer hacking?


### Question 2 Dice

Write a program to roll a set of dice. Generate a random number between 1 and 6 for
each dice to be rolled, and save the values in an ArrayList.

Display the total of all the dice rolled.

In other words, you'll need a method that 
tests if all of the values in an ArrayList are the same. 


### Question 3 Recycling Truck

You work for a recycling company.
You’d like to collect some statistics on how much each of the
houses on a certain street is recycling.

Each house has to use crates for their recycling. Your program will
count the number of crates set out by each house.

This street is a little unusual since it only has 8 houses, and the city planner
must have been a computer programmer, since the house numbers are 0, 1, 2, 3, 4, 5, 6, and 7.

(Hint – the house numbers are the same as array element indexes.)

Write a program that asks for the number of recycling crates set out by each house.
You should store, and process this data, in an array.
DON'T use an ArrayList or LinkedList!

Analyse your data and determine:
*	How many recycling crates, in total, from all the houses on the street?
*	What is the largest number of crates set out by any house?
*	What is the smallest number of crates set out by any house?
*	Which house had the most recycling? Display that house number.

Write code in the methods indicated.


### Question 4 Snowfall 

Extend this program to:

Ask user for a month, and snowfall amount, and add this data to HashMap provided.
Check if month is already in HashMap before adding data.
  If so, warn user that they will overwrite data, and ask for confirmation before writing.
  If the user does not want to overwrite data, the addToHashMap method should do nothing. 


For month names, assume that all month names will be the full name, with the
initial letter capitalized, and will always be spelled the same, example "May" or "September"

Optional: add input validation if you like.

Identify the month with the most snowfall.
Add up all of the snowfall amounts and display the total.

Write code in the methods indicated.


### Question 5 Lakes

You are a runner, and you are in training for a race. You'd like to keep track of all of your
times for your training runs. You only like to run around lakes. Here's some example data,

|Lake    |Time   |
|--------|-------|
| Cedar  | 45.15 |
| Cedar  | 43.32 |
| Harriet| 49.34 |
| Harriet| 44.43 |
| Harriet| 46.22 |
| Como   | 32.11 |
| Como   | 28.14 |

Write a program that enables you to enter the names of lakes and times, and store it all of this
data in data structure(s). You'll need to save EVERY time entered for each lake.

Don't store it in individual variables. Your program should still work if you started running
around another lake too (e.g. Lake of the Isles, or Lake Phalen).

Your program should be able to analyze the data that you have stored, and print your fastest
time for each lake you ran around. So, for the data above, your program will display something like

```
Cedar, 43.32  
Harriet, 44.43  
Como, 28.14
```

You should also be able to calculate the average time for each lake. So, for the same data as above,
your program will calculate something like this (you may truncate, or round numbers to 2 decimal places)

```
Cedar, 44.23
Harriet, 46.66
Como, 30.12
```

Print all of the the data - Lake Name, Average, and Fastest Time, in a table.


Your program should be case-insensitive. So "Como" is the same lake as "como" or "COMO".

Your program should use the generic types of data structures.
You should use methods to organize your program.
Hint: you may need to combine more than one type of data structure.


### Question 6 Go Fish

`Question_6_Go_Fish.java` is a first prototype of a program that plays a simplified version of the children's card
game Go Fish against you.  This version is based from the rules given at

https://en.wikipedia.org/wiki/Go_Fish

"Seven cards are dealt from a standard 52-card deck to each player.
The remaining cards are spread out in a disorderly pile referred to as the "pool".
The player whose turn it is to play asks another player for his or her cards of a
particular face value. For example Alice may ask, "Bob, do you have any threes?"
Alice must have at least one card of the rank she requested. Bob must hand
over all cards of that rank if possible. If he has none, Bob tells Alice to "go fish"
and Alice draws a card from the pool and places it in her own hand.

Then it is the next player's turn – unless the card Alice drew is the card she asked for,
in which case she shows it to the other players, and she gets another turn. When any player at
any time has all four cards of one face value, it forms a book, and the cards must be placed
face up in front of that player.

Play proceeds to the left. When all sets of cards have been laid down in books, the game ends.
The player with the most books wins."

Your tasks: finish the incomplete methods. Run and test the program. Also run the unit tests.
You might want to add some extra System.out.println() statements to update the player on the status of the game.

Optional extra challenge: Write your own test to check the behavior of your selectComputerCardValue method.
