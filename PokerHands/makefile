CC = g++ -g -Wall

all: Poker

Poker: Player.o PokerGame.o Poker.cpp
	$(CC) -o Poker Poker.cpp PokerGame.o Player.o

PokerGame.o: PokerGame.hpp PokerGame.cpp
	$(CC) -c PokerGame.cpp
	
Player.o: Player.hpp Player.cpp
	$(CC) -c Player.cpp
     
tidy :
	rm -f PokerGame.o Player.o core

clean :
	rm -f Poker PokerGame.o Player.o core
