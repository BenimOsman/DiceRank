# DiceRank
## WT ASSIGNMENT (SPRING - 2023)

### The Game is a Multiplayer Game where N players roll a 6 faced dice in a round-robin fashion. Each time a player rolls the dice their points increase by the number (1 to 6) achieved by the roll. As soon as a player accumulates M points they complete the game and are assigned a rank. Remaining players continue to play the game till they accumulate at least M points. The game ends when all players have accumulated at least M points.

#### Rules of the Game:
The order in which the users roll the dice is decided randomly at the start of the game. - If a player rolls the value "6" then they immediately get another chance to roll again and move ahead in the game. If a player rolls the value "1" two consecutive times then they are forced to skip their next turn as a penalty.

#### Implementation Details:
Implementing a standalone program in Java which takes the values N (number of players) and M (points of accumulate) as command line arguments. - Name the players as Player-1 to Player-N and randomly assign the order in which they will roll the dice. When it's the turn for Player-X to roll the dice prompt a message like “Player-3 it’s your turn (press ‘r’ to roll the dice). Randomly simulate a dice roll, display the points achieved and add the points to the user’s score. Print the current rank table which displays the points of all users and their rank after each roll. If the user gets another chance because they rolled a ‘6’ or they are penalized because they rolled ‘1’ twice consecutively then print appropriate message on standard output to inform the user. If a user completes the game, print an appropriate message on the output displaying their rank.
