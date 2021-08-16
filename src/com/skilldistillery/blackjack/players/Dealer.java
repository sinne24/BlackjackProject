package com.skilldistillery.blackjack.players;

import java.util.List;

import com.skilldistillery.blackjack.entities.*;

public class Dealer extends Player {

	private Deck deck;
	private Card card;
	private Hand dealerHand;
	private int dealerValue;

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
	public int dealRound(Player player, int dealerValue, int playerValue, Card cardToShow) {
		this.dealerValue = dealerValue;
		System.out.println("****************** Deal **********************\n" + "");
		cardToShow = dealCard();
		player.addToPlayHand(cardToShow);
		System.out.println("Player's first card: " + cardToShow.toString());
		playerValue = cardToShow.getValue();

		cardToShow = dealCard();
		addToPlayHand(cardToShow);
		System.out.println("Dealer's first card is face down.");
		this.dealerValue = cardToShow.getValue();

		cardToShow = dealCard();
		player.addToPlayHand(cardToShow);
		System.out.println("Player's second card: " + cardToShow.toString());
		playerValue += cardToShow.getValue();

		cardToShow = dealCard();
		addToPlayHand(cardToShow);
		this.dealerValue += cardToShow.getValue();
		System.out.println("Dealer's second card: " + cardToShow.toString());
		System.out.println("");

		System.out.println("Dealer's hand is: one card face down and the " + cardToShow.toString() + ", valued at "
				+ cardToShow.getValue());
		System.out.println("Player's hand is: " + player.toString() + ", which totals up to " + playerValue);
		
		return playerValue;
	}
	public int returnDealerValue() {
		return dealerValue;
		
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
