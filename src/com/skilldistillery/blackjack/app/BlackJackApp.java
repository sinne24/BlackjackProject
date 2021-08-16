package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.*;
import com.skilldistillery.blackjack.players.*;

// need a dealer(shuffle, deal)
// need a player
// need a hand
// player and dealer both have hands
// determine rules of game
// must play until deck runs out of cards

public class BlackJackApp {
	Hand hand;
	Dealer dealer = new Dealer("Dealer");
	Player player = new Player("Name");
	boolean quit = false;
	Scanner kb = new Scanner(System.in);
	String playerChoice;

	public static void main(String[] args) {
		BlackJackApp game = new BlackJackApp();
		game.run();
	}

	public void run() {
		System.out.println("Welcome to BlackJack!");
		while (!quit) {
			System.out.println("Would you like to play? enter 'y' or 'n'");
			playerChoice = kb.nextLine();
			if (playerChoice.charAt(0) == 'y' || playerChoice.charAt(0) == 'Y') {
				play(kb);
				kb.nextLine();
			} else if (playerChoice.charAt(0) == 'n' || playerChoice.charAt(0) == 'N') {
				quit = true;
				System.out.println("Ok, goodbye!");
			} else {
				System.out.println("Invalid choice. Please try again.");
				kb.nextLine();
			}
		}
		kb.close();
	}

	public void play(Scanner kb) {
		System.out.println("Hello player! Please enter a name for yourself.");
		String playerName = kb.nextLine();
		player = new Player(playerName);
		System.out.println("Great to see you " + player.getName());
		System.out.println("Dealer will now deal cards!\n");
		Deck deck = dealer.openNewDeck();
		dealer.shuffleDeck(deck);
		
		while(deck.checkDeckSize() > 10) {
			Card cardToShow = null;
			int dealerValue = 0;
			int playerValue = 0;
			
			//Dealer deals the round
			playerValue = dealer.dealRound(player, dealerValue, playerValue, cardToShow);
			dealerValue = dealer.returnDealerValue();
			
			//Determine hit, stand, win, lose
			boolean winnerDetermined = false;
			if (playerValue == 21) {
				System.out.println("Nice! You got Black Jack!");
				checkDealerValue(dealerValue);
			} else {
				while (playerValue < 21) {
					boolean hit = hitOrStand(kb);
					if (hit) {
						cardToShow = dealer.dealCard();
						player.addToPlayHand(cardToShow);
						System.out.println(
								"Player's next card: " + cardToShow.toString() + ", valued at " + cardToShow.getValue());
						playerValue += cardToShow.getValue();
						System.out.println("Player's hand is: " + player.toString() + ", which totals up to " + playerValue);
						if (playerValue == 21) {
							System.out.println("Nice! You got Black Jack!");
						}
						else if (playerValue > 21) {
							System.out.println("Too bad, you busted. Dealer Wins!");
							winnerDetermined = true;
						} 
					} else {
						break;
					}
				}
				if (!winnerDetermined) {
					determineWinner (dealerValue, playerValue);
				}
			} 
			
			player.discardPlayHand();
			dealer.discardPlayHand();
			 // Is there enough in the deck to play again?
			if(deck.checkDeckSize() > 10) {
				System.out.println("Next Round!");
			}
			else {
				System.out.println("This deck is out of cards. Game Over. "
						+ "You can choose to play again with a fresh deck! "
						+ "Hit enter to start a new game or quit!");
				break;
			}
		}

	}
	
	public void determineWinner (int dealerValue, int playerValue) {
		
		dealerValue = checkDealerValue(dealerValue);
		if(dealerValue > 21) {
			System.out.println("Dealer's value is " + dealerValue + " Dealer busts, Player wins!");
		} else if (dealerValue == 21 && dealerValue == playerValue) {
			System.out.println("Dealer got black jack too! Dealer wins!");
		} else if (dealerValue == 21) {
			System.out.println("Dealer got black jack! Dealer wins!");
		} else if(dealerValue > playerValue || dealerValue == playerValue) {
			System.out.println("Dealer's value is " + dealerValue + " Dealer wins!");
		}else if(dealerValue < playerValue) {
			System.out.println("Dealer's value is " + dealerValue + " " + player.getName() + " wins!");
		}
	} 
	
	public int checkDealerValue(int dealerValue) {
		System.out.println("Dealer will now show their cards: ");
		dealer.getPlayHand().showHand();
		System.out.println("Dealer's cards value at: " + dealerValue);
		while(dealerValue < 17) {
				Card card = dealer.dealCard();
				dealer.addToPlayHand(card);
				System.out.println("Dealer's next card : " + card.toString() + ", valued at " + card.getValue());
				dealerValue += card.getValue();
			
		}
		if (dealerValue >= 17){
			System.out.println("Dealer's value is " + dealerValue + ", the dealer must stand.");
		}
		return dealerValue;
		
	} 
	
	public boolean hitOrStand(Scanner kb) {
		boolean hit = false;

		System.out.println("What would you like to do? Hit or Stand?");
		playerChoice = kb.nextLine();
		if (playerChoice.charAt(0) == 'h' || playerChoice.charAt(0) == 'H') {
			System.out.println("You chose to hit!");
			hit = true;
		} else if (playerChoice.charAt(0) == 's' || playerChoice.charAt(0) == 'S') {
			hit = false;
			System.out.println("You chose to staaaand.");
		}
		return hit;
	} 

}
