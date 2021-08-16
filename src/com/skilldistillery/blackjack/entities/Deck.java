package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		super();
		this.cards = new ArrayList<>(52);
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card newCard = new Card(suit, rank);
				cards.add(newCard);
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}

	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

}
