package com.contentanalyst.playingcards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;


public class CardTest {

	private Card jackOfHearts;
	private Card aceDiamonds;
	
	@Before
	public void setUp() throws Exception {
		jackOfHearts = new Card(Card.Rank.JACK, Card.Suit.HEART);
		aceDiamonds = new Card(Card.Rank.ACE, Card.Suit.DIAMOND);
	}

	@Test
	public void testToString() {
		assertEquals("Jack Heart", jackOfHearts.toString());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(new Card(Card.Rank.JACK, Card.Suit.HEART), jackOfHearts);
		assertFalse(aceDiamonds.equals(jackOfHearts));
	}
	
	@Test
	public void testRank() {
		assertEquals(1, aceDiamonds.getRank().getRankValue());
		assertEquals(Card.Rank.JACK, jackOfHearts.getRank());
	}
	
	@Test
	public void testSuit() {
		assertEquals(Card.Suit.DIAMOND, aceDiamonds.getSuit());
	}

}
