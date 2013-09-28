package com.contentanalyst.playingcards;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.contentanalyst.util.ArrayShuffleTest;

@RunWith(Suite.class)
@SuiteClasses({ DeckTest.class, CardTest.class, ArrayShuffleTest.class })
public class AllTests {

}
