# Blackjack Project

### Description:
 The BlackJack project application (app) is a black jack game simulator.

### Technologies
 Eclipse IDE

### How to Play
  When the application runs the user is prompted on whether or not to enter a game of black jack. If the user selects yes, then the user will play until the deck runs out of enough cards to play a full round. If the use selects no, the application closes. When the user selects yes the game begins and the first round of cards is dealt. The game follows the same rules as the real game, and the first four cards are dealt in alternating order between user and dealer. The user is provided with the value of their cards and the value of the dealer's only face-up card. The user may then choose to hit or stand by entering h, H, Hit, or any word that starts with the letter h. The same logic applies to the stand option. The user is prompted to continue making this choice until they enter stand or their card value adds up to be grater than 21. Upon finishing the user's turn the app automates the dealer's actions. The dealer reveals their cards, and if the value is less than 17 the dealer deals themselves additional cards until their value is over 17 and must stand or accidentally busts (value reaches greater than 21). If the user gets blackjack and the delear does as well then the dealer wins. IF the user and the dealer values tie above 17, the dealer wins. Otherwise, the user  wins so long as their final value is greater than the dealer's. When the deck runs out of cards for the upcoming round, the user is prompted to hit enter to return the the main menu. There they can again select 'yes' to enter another game or 'no' to quit the application.

### Lessons Learned
  - Pay attention to constructor field initializations
  - Don't catch too much momentum and lose the ability to properly encapsulate without gutting your code.
  - Test, test, test
  