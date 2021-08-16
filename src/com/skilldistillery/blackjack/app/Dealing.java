package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class Dealing {

	public static void main(String[] args) {
		Dealing dealing = new Dealing();
		dealing.run();

	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		Deck deck = new Deck();
		Card card;
		int value = 0;

		System.out.println("How many cards would you like? ");
		kb.nextLine();
		try {
			int numCards = kb.nextInt();
			deck.shuffle();
			List<Card> hand = new ArrayList <>();
			for (int i = 0; i < numCards; i++) {
				card = deck.dealCard();
				hand.add(card);
				System.out.println(card.toString());
				value += card.getValue();
			}
			System.out.println("Total value of these cards is " + value);

		} catch (InputMismatchException ime) {
			System.out.println("You must enter a number using your number " 
					+ "digit keys (0-9). Please try again.");
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("You've asked for too many cards. Please " 
					+ "choose a number between 0 and 52.");
		}

	}
}
