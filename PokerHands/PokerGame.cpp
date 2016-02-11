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

bool PokerGame::callHand(string playerOne, string playerTwo) {

	int cardNum1[13] = {0};
	int cardNum2[13] = {0};

	callHandUtil(playerOne, cardNum1, cardValues);
	callHandUtil(playerTwo, cardNum2, cardValues);

	Rank playerOneHand = EMPTY, playerTwoHand = EMPTY;
	bool playerOneFlush = false, playerTwoFlush = false;

	playerOneFlush = findFlush(playerOne);
	playerTwoFlush = findFlush(playerTwo);

	if (playerOneFlush) playerOneHand = FLUSH;
	if (playerTwoFlush) playerTwoHand = FLUSH;

	int playerOneStraight = findStraight(cardNum1);			// 0 = no straight
																	// 1 = straight
	int playerTwoStraight = findStraight(cardNum2);		// 2 = royal

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

	if (playerTwoStraight == 1) {
		if (playerTwoFlush == true) {
			playerTwoHand = STRAIGHT_FLUSH;
		} else {
			if (playerTwoHand < FLUSH) {
				playerTwoHand = STRAIGHT;
			}
		}
	}

	if (playerTwoStraight == 2) {
		if (playerTwoFlush == true) {
			playerTwoHand = ROYAL_FLUSH;
		} else {
			if (playerTwoHand < FLUSH) {
				playerTwoHand = STRAIGHT;
			}
		}
	}

	int playerOneOther = findPairsTripsAndFours(cardNum1, cardValues);
	int playerTwoOther = findPairsTripsAndFours(cardNum2, cardValues);

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

	if (playerOneHand == playerTwoHand) {		// tie breaker

		int playerOneKicker;
		int playerTwoKicker;


		if (playerOneHand == PAIR) {
			playerOneKicker = findHighPairTripOrFour(2, cardNum1);
			playerTwoKicker = findHighPairTripOrFour(2, cardNum2);
		} else if (playerOneHand == TWO_PAIR) {
			playerOneKicker = findHighPairTripOrFour(2, cardNum1);
			playerTwoKicker = findHighPairTripOrFour(2, cardNum2);
		} else if (playerOneHand == TRIPS) {
			playerOneKicker = findHighPairTripOrFour(3, cardNum1);
			playerTwoKicker = findHighPairTripOrFour(3, cardNum2);
		} else if ( playerOneHand == FOUR_OF_A_KIND) {
			playerOneKicker = findHighPairTripOrFour(4, cardNum1);
			playerTwoKicker = findHighPairTripOrFour(4, cardNum2);
		} else {
			playerOneKicker = findHighCard(cardNum1, cardValues);
			playerTwoKicker = findHighCard(cardNum2, cardValues);
		}


		if (playerOneKicker > playerTwoKicker) {
			playerOneHand = HIGH_CARD;
			playerTwoHand = EMPTY;
		} else {
			playerOneHand = EMPTY;
			playerTwoHand = HIGH_CARD;
		}
	}

	return playerOneHand > playerTwoHand ? true : false;
}

void PokerGame::callHandUtil(string hand, int cardNum[], int cardValues) {
	for (int i = 0; i < hand.length(); i = i + 2) {
		if (hand[i] == 'A') {
			cardNum[12]++;
		} else if (hand[i] == 'K') {
			cardNum[11]++;
		} else if (hand[i] == 'Q') {
			cardNum[10]++;
		} else if (hand[i] == 'J') {
			cardNum[9]++;
		} else if (hand[i] == 'T') {
			cardNum[8]++;
		} else if (hand[i] == '9') {
			cardNum[7]++;
		} else if (hand[i] == '8') {
			cardNum[6]++;
		} else if (hand[i] == '7') {
			cardNum[5]++;
		} else if (hand[i] == '6') {
			cardNum[4]++;
		} else if (hand[i] == '5') {
			cardNum[3]++;
		} else if (hand[i] == '4') {
			cardNum[2]++;
		} else if (hand[i] == '3') {
			cardNum[1]++;
		} else if (hand[i] == '2') {
			cardNum[0]++;
		}
	}
}

int PokerGame::findHighPairTripOrFour(int pairTripOrFour, int* cardNum) {
	int hairPairTripOrFour;

	for (int i = (cardValues - 1); i >= 0; i--) {
		if (cardNum[i] == pairTripOrFour) {
			hairPairTripOrFour = i;
			break;
		}
	}

	return hairPairTripOrFour;
}

int PokerGame::findPairsTripsAndFours(int cardNum[], int cardValues) {		//returns 1 if one pair, 2 if two pairs, 3 if trips, 4 if four of A Kind, 5 if full house

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
int PokerGame::findStraight(int* cardNum) {
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

int PokerGame::findHighCard(int numCard[], int cardValues) {

	int highCard = 0;
	for (int i = 13; i > 0; i--) {
		if (numCard[i] == 1) {		//cant be part of a double, triple, or four of a kind
			highCard = i;
			break;
		}
	}
	return highCard;
}
