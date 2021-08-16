package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> cardsInHand;

	public Hand() {
		super();
		cardsInHand = new ArrayList<>();
	}
	
	public void addToHand(Card card) {
		cardsInHand.add(card);
	}
	public void discardPlayHand() {
		cardsInHand.removeAll(cardsInHand);
	}
	public void showHand() {
		for (Card card : cardsInHand) {
			System.out.println(card.toString());
		}	
	}
	public int getValue() {
		int val = 0;
		for (Card card : cardsInHand) {
			val += card.getValue();
		}
		return val;
	}
	@Override
	public String toString() {
		return " " + cardsInHand;
	}
}
