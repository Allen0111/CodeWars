/*
 * binarySearchTest.cpp
 *
 *  Created on: Jan 31, 2016
 *      Author: allen
 */




#include <cstdlib>
#include <iostream>
#include "binarySearchTree.hpp"
using namespace std;

int main() {
	binarySearchTree tree;
	tree.insertNode(123);
	tree.insertNode(25);
	tree.insertNode(12253);
	tree.insertNode(12564);
	tree.insertNode(1231);
	tree.insertNode(13);
	tree.insertNode(1);
	tree.insertNode(121323);
	tree.insertNode(1423);
	tree.insertNode(1623);
	tree.insertNode(1283);
	tree.insertNode(1293);
	tree.insertNode(9123);

	tree.inOrderTraversal();

	return 0;
}
