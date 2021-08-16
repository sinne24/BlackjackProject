package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds"),;

	final private String suit;

	Suit(String s) {
		suit = s;
	}

	@Override
	public String toString() {
		return suit;
	}

}
