/*
 * Player.hpp
 *
 *  Created on: Jan 15, 2016
 *      Author: allen
 */

#ifndef PLAYER_HPP_
#define PLAYER_HPP_

#include <string>
#include <iostream>
#include <cstdlib>
#include <stdio.h>
using namespace std;


class Player {
private:
	string hand;
	int winCount;

public:
	Player();
	~Player();

	string getHand();

	void setHand(string hand);

	int getWinCount();

	void incWinCount();

};



#endif /* PLAYER_HPP_ */
