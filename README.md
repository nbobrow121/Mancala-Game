# Library Control

In summary, this code runs the game mancala with different game rules

## Description

The code runs a basic Mancala game, organized into five classes: Board, MancalaGame, Pit, Player, and Store. The Board class establishes the game board, enabling player actions. MancalaGame manages the game and player interactions. The Pit class tracks individual pit stone counts. Player defines player attributes, and Store manages stone storage. This object oriented setup delivers a functional Mancala game with moves, captures, wins, etc.

## Getting Started
### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.
requires java.util.ArrayList and javax.swing.JButton;

JDK 17 was used

### Executing program

* How to build and run the program
* Step-by-step bullets
```
gradle build
run the jar file

## Development History

Contrary to my code, the 'AI' implementation exhibits numerous functional and correctness issues, rendering it impractical for a Mancala game. Conversely, my code confronts these challenges head-on and rectifies them. To illustrate, I've devised a more modular framework featuring well-defined methods for configuring pits, stores, and initializing the board within my board class. Furthermore, I've structured the code to align with Mancala game rules, mitigating rule violations and ensuring precise gameplay. The handling of the last stone landing in a player's store for a free turn is consistently reliable, contributing to a heightened gaming experience. I've also rectified the validation of game-ending conditions and win/lose scenarios, guaranteeing the accuracy of the game's outcome. Unlike the AI rendition, I've implemented error handling through custom exceptions such as InvalidMoveException and PitNotFoundException, adhering to specified instructions. This not only fortifies the game's reliability but also simplifies the debugging process. Additionally, my code boasts an enhanced user interaction and input handling mechanism, averting unforeseen program terminations and facilitating a seamless experience. Finally, I've introduced a user-friendly representation of the current Mancala board state, enhancing accessibility for users—a feature lacking in the AI version.

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)