/*
 * PokerGame.hpp
 *
 *  Created on: Jan 15, 2016
 *      Author: allen
 */

#ifndef POKERGAME_HPP_
#define POKERGAME_HPP_


#include <iostream>
#include "string"
using namespace std;

class PokerGame {
private:

	enum Rank { EMPTY = 0, HIGH_CARD, PAIR, TWO_PAIR, TRIPS, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH };
	void callHandUtil(string hand, int cardNum[], int length);
	int findPairsTripsAndFours(int cardNum[], int length);
	bool findFlush(string player);
	int findHighCard(int numCard[], int length);
	int findStraight(int cardNum[]);
	int findHighPairTripOrFour(int pairTripOrFour, int* cardNum);
public:
	bool callHand(string player1, string player2);
	static int cardValues;


};

#endif /* POKERGAME_HPP_ */
