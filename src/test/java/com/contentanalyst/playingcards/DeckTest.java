package com.contentanalyst.playingcards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class DeckTest {

	private Deck deck;
	
	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	@Test
	@Ignore
	public void testShuffle() {
		deck.shuffle();
		System.out.println(deck.dealOneCard());
	}

	@Test
	public void dealOne() {
		assertEquals(new Card(Card.Rank.ACE, Card.Suit.CLUB), 
				deck.dealOneCard());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void dealOneTooMany() {
		dealAll();
		deck.dealOneCard();
	}
	
	private void dealAll() {
		for (int i = 0; i < Deck.DECKSIZE; i++)
			deck.dealOneCard();
	}
	
	@Test
	public void resetDeck() {
		dealAll();
		assertEquals(0, deck.cardsInDeck());
		deck.shuffle();
		assertEquals(Deck.DECKSIZE, deck.cardsInDeck());
		Card card = deck.dealOneCard();
		assertNotNull(card);
	}
}
