/*
 * LargestPrime.cpp
 *
 *  Created on: Jan 12, 2016
 *      Author: allen
 */

#include <cstdlib>
#include <iostream>
#include <cmath>
using namespace std;

int main() {
	const long numm = 600851475143;
	long newnumm = numm;
	long largestFact = 0;

	int counter = 2;
	while (counter * counter <= newnumm) {
	    if (newnumm % counter == 0) {
	        newnumm = newnumm / counter;
	        largestFact = counter;
	    } else {
	    	counter = (counter == 2) ? 3 : counter + 2;
	    }
	}
	if (newnumm > largestFact) { // the remainder is a prime number
	    largestFact = newnumm;
	}
	cout << largestFact << endl;
}

