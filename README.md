# TicTacToe Project

This project consists of developing a TicTacToe game using unit tests to validate the functionalities. The game is played on a 3x3 grid where two players, X and O, take turns placing their pieces to be the first to align three pieces either horizontally, vertically, or diagonally.

## Features

### Part I: Core Game Features

1. **Placing Pieces**
   - A piece can be placed on any empty space on the 3x3 grid.
   - Three tests are associated with this requirement:
     - If a piece is placed outside the X-axis, a `RuntimeException` is thrown.
     - If a piece is placed outside the Y-axis, a `RuntimeException` is thrown.
     - If a piece is placed on an already occupied space, a `RuntimeException` is thrown.

2. **Support for Two Players**
   - The game supports two players who alternate turns:
     - Player X goes first.
     - If Player X made the last move, Player O should play next.
     - If Player O made the last move, Player X should play next.

3. **Victory Conditions**
   - The system checks all possible winning combinations (horizontal, vertical, and diagonal).
   - A player wins by being the first to align three of their pieces, either horizontally, vertically, or diagonally.

4. **Draw Conditions**
   - The game is declared a draw if all the cells of the grid are filled without either player aligning three pieces.

### Part II: Storing Moves

In this part, we add a storage functionality to allow players to continue the game at a later time.

1. **Added Classes:**
   - `TicTacToeSave`: This class handles the saving of moves into a database.
   - `Data`: This class manages the connection to the database.
   - `GererDB`: An interface defining database operations.
   - `TicTacToeSaveTest`: Unit tests to verify the correct functionality of move storage and database management.

2. **Storage Requirements:**
   - **Store a Move**: Each move is stored with the turn number, the X and Y positions, and the player (X or O).
   - **Store Each Turn**: Each turn is saved in the database. When starting a new game session, the old data is cleaned up.
   - **Database Initialization**: If the `tic-tac-toe` database does not exist, it is created.

## Technologies Used

- **IDE**: IntelliJ IDEA
- **Language**: Java
- **Testing**: JUnit
- **Database**: SQLite (or another suitable database)

### `pom.xml` File
The necessary dependencies are added to the `pom.xml` file, including:
- JUnit for testing.
- JDBC or a database management library for persistence.

## Running the Project

1. **Prepare the `pom.xml` File**: Add the following dependencies to your `pom.xml`:
   - JUnit for testing.
   - SQLite for database management (or another database of your choice).

2. **Run the Tests**: Execute the tests in `TicTacToeTest` to validate the core game functionalities.

3. **Move Storage**: Test the move storage functionality using `TicTacToeSaveTest`. Verify database creation, storing turns, and session management.

## Contributing

Contributions are welcome! If you have suggestions for improvements or bug fixes, feel free to open an issue or submit a pull request.

## Running the Tests

1. **Piece Placement Tests**: Ensure that exceptions are thrown for incorrect placements.
2. **Player Turn Tests**: Verify that the next player is correctly determined after each turn.
3. **Victory Condition Tests**: Check that the system correctly detects victory and draw conditions.
4. **Database Tests**: Test move storage, old data cleanup, and proper database initialization.

## Prerequisites

- Java 8 or higher.
- IntelliJ IDEA or any other Java IDE.
- A database (SQLite, MySQL, or another depending on your choice).
- Maven for dependency management.
