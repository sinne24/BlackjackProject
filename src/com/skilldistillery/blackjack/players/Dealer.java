package com.skilldistillery.blackjack.players;

import java.util.List;

import com.skilldistillery.blackjack.entities.*;

public class Dealer extends Player {

	private Deck deck;
	private Card card;
	private Hand dealerHand;

	public Dealer(String name) {
		super(name);
		dealerHand = new Hand();
	}
	
	public Deck openNewDeck() {
		return deck = new Deck();
	}
	
	public Deck shuffleDeck(Deck deck) {
		deck.shuffle();
		return deck;
	}

	public Card dealCard() {
		card = deck.dealCard();
		return card;

	}

	public void dealThisRound() {
		card = deck.dealCard();
		dealerHand.addToHand(card);
		card = deck.dealCard();
		dealerHand.addToHand(card);
		dealerHand(dealerHand);

	}

	public void dealerHand(Hand hand) {
		dealerHand = hand;
	}
	
	public void dealerPlay(Hand dealerHand) {

	}

	@Override
	public String toString() {
		return "Dealer " + dealerHand.toString() ;
	}
	
}
