/*
 * Player.cpp
 *
 *  Created on: Jan 15, 2016
 *      Author: allen
 */


	//	char hand[2][5];
	//  [] value [] suit
	//	winCount;

#include "Player.hpp"
using namespace std;

Player::Player() {
	winCount = 0;
	hand = NULL;
}

Player::~Player() {

}

string Player::getHand() {
	return hand;
}

void Player::setHand(string stringHand) {
	hand = stringHand;
}

int Player::getWinCount() {
	return winCount;
}

void Player::incWinCount() {
	winCount++;
}

