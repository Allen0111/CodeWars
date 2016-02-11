/*
 * binarySearchTree.hpp
 *
 *  Created on: Jan 31, 2016
 *      Author: allen
 */

#ifndef BINARYSEARCHTREE_HPP_
#define BINARYSEARCHTREE_HPP_



	#include <iostream>
	#include <cstdlib>
	#include <limits.h>
	using namespace std;

	struct 	node {
		int data;
		node *left;
		node *right;
	};

	class binarySearchTree {
	public:
		binarySearchTree();
		//~binarySearchTree();

		void insertNode(int key);
		node *search(int key);
		void destroyTree();
		node *deleteNode(int data);
		void inOrderTraversal();

		// for extraction and placement in a later scenario,
		// this checks to see if students are implementing their
		// BST correctly
		bool isBinarySearchTree(node *leaf);

	private:
		void destroyTreeUtil(node *leaf);
		void insertNodeUtil(int key, node *leaf);
		node *searchUtil(int key, node*leaf);
		node *deleteNodeUtil(node *leaf, int data);
		int evalNumChildren(node *leaf);
		node *getSuccessor(node *child);
		void inOrderTraversalUtil(node *leaf);

		//utilities for the isBinarySearchTree function
		bool checkForBinarySearchTree(node *leaf, int minValue, int maxValue);
		bool isSubTreeLesser(node *leaf, int data);
		bool isSubTreeGreater(node *leaf, int data);



		//root node, must be immutable
		node *root;
	};


#endif /* BINARYSEARCHTREE_HPP_ */
