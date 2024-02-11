# Arkanoid-Game
Welcome to the Arkanoid game! This Java project brings the classic Arkanoid arcade experience to life through object-oriented programming principles and design patterns. Players will embark on an exhilarating journey filled with block-breaking action and challenging levels.

## How to Run
To start playing the game, compile all Java files and then run the Arkanoid class. You have the option to run the game with or without arguments. If no arguments are provided, the game will proceed through the default sequence of levels (1, 2, 3, 4). However, if you choose to specify arguments, you can determine the order of levels to play. For example:

> java Arkanoid 3 1 4 1

This command will initiate the game with the levels played in the specified order: 3, 1, 4, and 1.

## How to Use
Using the Arkanoid game is straightforward:

- Use the left and right arrow keys to control the paddle's movement.
- Press the 'P' key to pause the game.
- To resume the game after pausing, press the 'P' key again.
- Ensure that none of the balls fall below the paddle, as this will result in losing a life.
- Hit all blocks on the screen to proceed to the next level. Only by clearing all blocks can you achieve victory.

## schema for the Arkanoid
![src](https://github.com/yeela8g/Arkanoid-Game/assets/118124478/2b3e91c4-83ea-4f6a-a507-5b8f1ea9fa8b)

## Implementation
This project embodies various object-oriented programming principles and patterns, ensuring robustness and maintainability:
- Encapsulation: Each class encapsulates its behavior and data, promoting modularity and reusability.
- Polymorphism: Flexible behavior of objects is achieved through polymorphism, enabling them to handle collisions and perform drawing operations dynamically.
 Implemented
In addition to object-oriented principles, this project incorporates design patterns for enhanced structure and flexibility:
- Factory Pattern: The factory pattern dynamically creates different game levels based on user input, allowing for customizable gameplay experiences.
- Listener Pattern: The listener pattern is utilized to notify objects of events such as block hits and ball removals, enabling dynamic responses and interactions within the game.
  
![Arkanoid Gameplay](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExY3YwbjlpdThpZjNldGNlY3c3MG9tbmhubTVlcDc3MTV2ZGluY3k5NyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Bs428XZGLM9sqsG12v/giphy.gif)


The Arkanoid game project offers a compelling implementation of object-oriented programming principles and design patterns, delivering an engaging gaming experience. With its intuitive controls, customizable level sequencing, and challenging victory conditions, Arkanoid promises endless entertainment for players of all skill levels. Get ready to break some blocks and conquer each level in this thrilling arcade adventure!
