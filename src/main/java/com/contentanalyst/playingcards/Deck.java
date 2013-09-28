package com.contentanalyst.playingcards;

import java.util.NoSuchElementException;
import com.contentanalyst.util.ArrayShuffle;

/**
 * Class that represents a deck of cards in a common 52-card playing card deck.
 * 
 * This class is not thread safe.
 * 
 * @author David Flynt
 */
public final class Deck {
	public final static int DECKSIZE = 52;
	private final Card[] deck = new Card[DECKSIZE];
	private int deckIndex = 0;
	private final ArrayShuffle<Card> shuffler = new ArrayShuffle<Card>();
	
	/**
     * Constructs a newly allocated {@code Deck} object.
	 */
	public Deck() {
		int i = 0;
		for (Card.Rank r: Card.Rank.values()) {
			for (Card.Suit s: Card.Suit.values()) {
				deck[i++] = new Card(r, s);
			}
		}
	}
	
	/**
	 * After a call to shuffle(), this value will be 52.  After 
	 * dealOneCard() has been called 52 (or more times), this value will be 0.
	 * 
	 * @return number of cards that are dealable in this deck.  
	 */
	public int cardsInDeck() {
		return DECKSIZE - deckIndex;
	}
	
	/**
	 * Randomly shuffle entire deck of cards.  After this method is called,
	 * dealOneCard() may be called up to 52 times before requiring another
	 * call to shuffle.
	 */
	public void shuffle() {
		shuffler.shuffle(deck);
		deckIndex = 0;
	}
	
	/**
	 * 
	 * @return a {@code Card} object representing the card on the
	 * top of the deck.  You may deal up the entire 52 card deck contents
	 * before shuffling the deck.  If this method is called more than 52
	 * times without shuffling, an {@code NoSuchElementException} is thrown
	 * 
	 * @throws NoSuchElementException if this method is called more than
	 * 52 times before calling the shuffle method.  
	 */
	public Card dealOneCard() {
		if (deckIndex == DECKSIZE) {
			String endOfDeckError = "cannot deal beyond end of card deck";
			throw new NoSuchElementException(endOfDeckError);
		}
		return deck[deckIndex++];
	}
}
