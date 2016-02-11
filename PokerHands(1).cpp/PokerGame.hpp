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
	enum Rank { HIGH_CARD = 1, PAIR, TWO_PAIR, TRIPS, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH };
	static int cardValues;


	void callHandUtil(string hand, int* cardNum);
	int findPairsTripsAndFours(int* cardNum);
	bool findFlush(string player);
	int findStraight(string player, int* cardNum);
	int findPairsTripsAndFours();
	int findHighCard(int* numCard);


public:

	bool callHand(string player1, string player2);


};

#endif /* POKERGAME_HPP_ */
