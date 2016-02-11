/*
 * PokerGame.cpp
 *
 *  Created on: Jan 15, 2016
 *      Author: Allen Bui
 */

#include "PokerGame.hpp"
using namespace std;

/*
    	High Card: Highest value card.
    	One Pair: Two cards of the same value.
    	Two Pairs: Two different pairs.
    	Three of a Kind: Three cards of the same value.
    		Straight: All cards are consecutive values.
    		Flush: All cards of the same suit.
    	Full House: Three of a kind and a pair.
    	Four of a Kind: Four cards of the same value.
    		Straight Flush: All cards are consecutive values of same suit.
    		Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

		The cards are valued in the order:
		2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 */

int PokerGame::cardValues = 13;

bool PokerGame::callHand(string player1, string player2) {

	int cardNum1[cardValues];
	int cardNum2[cardValues];

	callHandUtil(player1, cardNum1);
	callHandUtil(player2, cardNum2);

	int playerOneHand = 0, playerTwoHand = 0;
	bool playerOneFlush = false, playerTwoFlush = false;

	playerOneFlush = findFlush(player1);
	playerTwoFlush = findFlush(player2);

	int playerOneStraight = findStraight(player1, cardNum1);			// 0 = no straight
																	// 1 = straight
	int playerTwoStraight = findStraight(player2, cardNum2);		// 2 = royal

	if (playerOneStraight == 1) {
		if (playerOneFlush == true) {
			playerOneHand = STRAIGHT_FLUSH;
		} else {
			if (playerOneHand < FLUSH) {
				playerOneHand = STRAIGHT;
			}
		}
	}

	if (playerOneStraight == 2) {
		if (playerOneFlush == true) {
			playerOneHand = ROYAL_FLUSH;
		} else {
			if (playerTwoHand < FLUSH) {
				playerOneHand = STRAIGHT;
			}
		}
	}

	int playerOneOther = findPairsTripsAndFours();
	int playerTwoOther = findPairsTripsAndFours();

	if (playerOneOther == 4) {	// four of a kind
		if (playerOneHand < FOUR_OF_A_KIND) {
			playerOneHand = FOUR_OF_A_KIND;
		}
	} else if (playerOneOther == 5) { // boat
		if (playerOneHand < FULL_HOUSE) {
			playerOneHand = FULL_HOUSE;
		}
	} else if (playerOneOther == 3) { // trips
		if (playerOneHand < TRIPS) {
			playerOneHand = TRIPS;
		}
	} else if (playerOneOther == 2) { // two pair
		if (playerOneHand < TWO_PAIR) {
			playerOneHand = TWO_PAIR;
		}
	} else if (playerOneOther == 1) { // pair
		if (playerOneHand < PAIR) {
			playerOneHand = PAIR;
		}
	}

	if (playerTwoOther == 4) {	// four of a kind
		if (playerTwoHand < FOUR_OF_A_KIND) {
			playerTwoHand = FOUR_OF_A_KIND;
		}
	} else if (playerTwoOther == 5) { // boat
		if (playerTwoHand < FULL_HOUSE) {
			playerTwoHand = FULL_HOUSE;
		}
	} else if (playerTwoOther == 3) { // trips
		if (playerTwoHand < TRIPS) {
			playerTwoHand = TRIPS;
		}
	} else if (playerTwoOther == 2) { // two pair
		if (playerTwoHand < TWO_PAIR) {
			playerTwoHand = TWO_PAIR;
		}
	} else if (playerTwoOther == 1) { // pair
		if (playerTwoHand < PAIR) {
			playerTwoHand = PAIR;
		}
	}

	if (playerOneHand == playerTwoHand) {

		int playerOneKicker = findHighCard(cardNum1);
		int playerTwoKicker = findHighCard(cardNum2);

		if (playerOneKicker > playerTwoKicker) {
			playerOneHand = 1;
			playerTwoHand = 0;
		} else {
			playerOneHand = 0;
			playerTwoHand = 1;
		}
	}

	return playerOneHand > playerTwoHand ? true : false;
}

void PokerGame::callHandUtil(string hand, int* cardNum) {
	for (int i = 0; i < hand.length(); i = i + 2) {
		if (hand[i] == 'A') {
			cardNum[12]++;
		} else if (hand[i] == 'K') {
			cardNum[11]++;
		} else if (hand[i] == 'Q') {
			cardNum[10]++;
		} else if (hand[i] == 'J') {
			cardNum[9]++;
		} else {
			cardNum[hand[i] - 1]++;
		}
	}
}

int PokerGame::findPairsTripsAndFours(int* cardNum) {		//returns 1 if one pair, 2 if two pairs, 3 if trips, 4 if four of A Kind, 5 if full house

	int pair = 0, trips = 0, fourOfAKind;

	for (int i = 0; i < cardValues; i++) {
		if (cardNum[i] == 2) {
			pair++;
		} else if (cardNum[i] == 3) {
			trips++;
		} else if (cardNum[i] == 4) {
			fourOfAKind++;
		}
	}

	if (fourOfAKind > 0) {
		return 4;
	} else if (pair > 0 && trips >0) {
		return 5;
	} else if (trips > 0) {
		return 3;
	} else if (pair > 1) {
		return 2;
	} else if (pair == 1) {
		return 1;
	} else {
		return 0;
	}
}

bool PokerGame::findFlush(string player) {
	if (player[1] == player[3] && player[3] == player[5] && player[5] == player[7]  && player[7] == player[9]) {
		return true;
	} else {
		return false;
	}
}

int PokerGame::findStraight(string hand, int *cardNum) {
	bool royal = false;
	int consecutive = 0;
	int returnValue = 0;

	for (int i = 0; i < cardValues && consecutive < 5; i++) {
		if (cardNum[i] > 1) {
			returnValue = 0;		// no flush
			break;
		} else if (consecutive > 0) {
			if (cardNum[i] == 0) {
				returnValue = 0;		// no flush
				break;
			} else {
				consecutive++;	// continue counting
			}
		} else {
			if (cardNum[i] == 1) {
				if (i == 10) {
					royal = true;
				}
				consecutive++;
			}
		}
	}

	if (consecutive == 5) {
		if (royal) {
			returnValue = 2;
		} else {
			returnValue = 1;
		}
	}

	return returnValue;
}

int PokerGame::findHighCard(int* numCard) {

	int highCard = 0;
	for (int i = 13; i > 0; i--) {
		if (numCard[i] == 1) {		//cant be part of a double, triple, or four of a kind
			highCard = i;
			break;
		}
	}
	return highCard;
}
