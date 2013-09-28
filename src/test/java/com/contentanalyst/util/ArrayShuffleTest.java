package com.contentanalyst.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.contentanalyst.playingcards.Card;
import com.contentanalyst.playingcards.Deck;

public class ArrayShuffleTest {

	private Integer[] arrInt = null;
	private Card[] deck = null;
	private ArrayShuffle<Integer> intShuffler = null;
	private ArrayShuffle<Card> cardShuffler = null;
	
	@Before
	public void setUp() throws Exception {
		arrInt = new Integer[10000];
		for (int i = 0; i < 10000; i++)
			arrInt[i] = i + 1;
		
		deck = new Card[Deck.DECKSIZE];
		int i = 0;
		for (Card.Rank r: Card.Rank.values()) {
			for (Card.Suit s: Card.Suit.values()) {
				deck[i++] = new Card(r, s);
			}
		}
		intShuffler = new ArrayShuffle<Integer>();
		cardShuffler = new ArrayShuffle<Card>();
	}

	@Test
	public void intShuffle() {
		intShuffler.shuffle(arrInt);
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(arrInt));
		
		// check no duplicate values
		assertEquals(10000, s.size());
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(arrInt));
		Collections.sort(l);
		
		// check again no duplicates, and original values
		int i = 1;
		for (Integer j: l) {
			assertEquals(i++, j.intValue());
		}
	}
	
	@Test
	public void cardShuffle() {
		cardShuffler.shuffle(deck);
		Set<Card> cards = new HashSet<Card>(Arrays.asList(deck));
		assertEquals(Deck.DECKSIZE, cards.size());
	}

}
