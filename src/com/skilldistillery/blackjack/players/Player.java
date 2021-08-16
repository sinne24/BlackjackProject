package com.skilldistillery.blackjack.players;

import java.util.List;

import com.skilldistillery.blackjack.entities.*;

public class Player{
	private String name;
	private Hand playHand;
	
	public Player(String name) {
		super();
		this.name = name;
		playHand = new Hand();
	}
	public String getName() {
		return name;
	}
	
	public Hand getPlayHand() {
		return playHand;
	}

	public void addToPlayHand(Card card) {
		this.playHand.addToHand(card);
	}
	@Override
	public String toString() {
		return "" + playHand.toString();
	}


}
