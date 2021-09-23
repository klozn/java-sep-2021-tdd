# Minesweeper

You have here a very simple minesweeper implementation, but it's not that pretty.
It has several code smells (long method, switch case, ...), and it's hard to test.

## Clean code
Refactor this code using the creator pattern to make it more readable.
Don't forget to write test!


### Hint
Often we choose to have a separate class that creates our object. 
Typically in java we call this class a factory.
Try creating a BoardFactory class and let it create a board.
Don't be shy about creating packages either.


## Open closed (extra)
The code is not very extensible if you want to create a new difficulty.
Use the concepts of open/closed and dependency inversion to make this code more extensible.

### Extension
Now that you've made yor code extensible add a new type of difficulty (BORDER) where the borders of the board are all bombs.

### Hint
Make your BoardFactory an abstract class or interface and create a separate class for each difficulty.
Now link each subclass to the right difficulty value.

