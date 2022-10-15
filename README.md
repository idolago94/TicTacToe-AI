Main.java:
The Main class create the board and continue with the while loop until the game is over.
Every run inside the loop is turn of a player, once the user and once the computer.
After the game is over, check who is win and print a message accordingly.

Board.java:
There are two type of constructor of the class:
    1. Create a new empty board.
    2. Create a copy of the board that give as argument.
print(): print the visual board state.
set()/get(): set/get the specific position in the board.
isTerminated(): check if the game is over.
score(): return the score of the game. -1=computer win, 1=user win, 0=draw.
getSize(): return the size of the board.

AI.java:
The AI class implements the computer turn.
Every computer turn, the 'play' function call and return the best next state of the board(after the computer played).
All the other functions in this class are private and use for get the best next state of board.


Example 1: (DRAW)
board:
_ _ _ 
_ _ _ 
_ _ _ 

choose row (0-2)
0
choose column (0-2)
0
board:
X _ _ 
_ _ _ 
_ _ _ 

AI plays...
board:
X _ O 
_ _ _ 
_ _ _ 

choose row (0-2)
2
choose column (0-2)
2
board:
X _ O 
_ _ _ 
_ _ X 

AI plays...
board:
X _ O 
_ O _ 
_ _ X 

choose row (0-2)
2
choose column (0-2)
0
board:
X _ O 
_ O _ 
X _ X 

AI plays...
board:
X _ O 
O O _ 
X _ X 

choose row (0-2)
1
choose column (0-2)
2
board:
X _ O 
O O X 
X _ X 

AI plays...
board:
X _ O 
O O X 
X O X 

choose row (0-2)
0
choose column (0-2)
1
board:
X X O 
O O X 
X O X 

DRAW


Example 2: (AI WIN)
board:
_ _ _ 
_ _ _ 
_ _ _ 

choose row (0-2)
0
choose column (0-2)
0
board:
X _ _ 
_ _ _ 
_ _ _ 

AI plays...
board:
X _ O 
_ _ _ 
_ _ _ 

choose row (0-2)
2
choose column (0-2)
0
board:
X _ O 
_ _ _ 
X _ _ 

AI plays...
board:
X _ O 
O _ _ 
X _ _ 

choose row (0-2)
1
choose column (0-2)
1
board:
X _ O 
O X _ 
X _ _ 

AI plays...
board:
X _ O 
O X _ 
X _ O 

choose row (0-2)
0
choose column (0-2)
1
board:
X X O 
O X _ 
X _ O 

AI plays...
board:
X X O 
O X O 
X _ O 

AI WIN