/*
 * binarySearchTree.cpp
 *
 *  Created on: Jan 31, 2016
 *      Author: allen
 */


/**
*	Allen Bui
*	January 31, 2016
*	Binary Search Tree in C++
**/

#include "binarySearchTree.hpp"
using namespace std;

binarySearchTree::binarySearchTree() {
 	root = NULL;
}

void binarySearchTree::destroyTree() {
	destroyTreeUtil(root);
}

void binarySearchTree::destroyTreeUtil(node *leaf) {
	if (leaf == NULL) return;

	destroyTreeUtil(leaf->left);
	destroyTreeUtil(leaf->right);

	delete(leaf);
}

void binarySearchTree::insertNode(int key) {
	if (root != NULL) {
		root = new node;
		root->data = key;
		root->left = NULL;
		root->right = NULL;
	}
	else {
		insertNodeUtil(key, root);
	}
}

void binarySearchTree::insertNodeUtil(int key, node *leaf) {
	if (leaf == NULL) {
		leaf = new node;
		leaf->data = key;
		leaf->left = NULL;
		leaf->right = NULL;
		return;
	}
	else if (leaf->data == key) {
		return;
	}
	else if (leaf->data > key) {
		insertNodeUtil(key, leaf->left);
	} else {/*(leaf->data > key)*/
		insertNodeUtil(key, leaf->right);
	}
}

//depth first search
node *binarySearchTree::search(int key) {
	if (root == NULL) {
		return NULL;
	}
	else {
		return searchUtil(key, root);
	}
}

node *binarySearchTree::searchUtil(int key, node*leaf) {
	if (leaf == NULL) return NULL;
	if (leaf->data == key) return leaf;
	else if (leaf->data < key) searchUtil(key, leaf->right);
	else searchUtil(key, leaf->left);
}

node *binarySearchTree::deleteNode(int data) {
	return deleteNodeUtil(root, data);
}

node *binarySearchTree::deleteNodeUtil(node *leaf, int data) {
	if (leaf == NULL) return leaf;
	if (leaf->data < data) {
		deleteNodeUtil(leaf->right, data);
	}
	else if (leaf->data > data) {
		deleteNodeUtil(leaf->left, data);
	}
	else {	//found the node to delete
		int numChildren = evalNumChildren(leaf);

		if (numChildren == 0) {
			delete(leaf);
			leaf = NULL;
		}
		else if (numChildren == 1) {
			node *temp = leaf;
			if (leaf->left == NULL) {	//then it has a rightChild
				leaf = leaf->right;
				delete(temp);
			}
			else {//it has a leftChild
				leaf = leaf->left;
				delete(temp);
			}
		}
		else { //numChildren == 2
			node *successor = getSuccessor(leaf->right);
			leaf->data = successor->data;
			leaf->right = deleteNodeUtil(leaf->right, successor->data);
		}
	}
	return leaf;
}

node *binarySearchTree::getSuccessor(node *child) {
	if (child->left == NULL) {
		return child;
	}
	getSuccessor(child->left);
}

int binarySearchTree::evalNumChildren(node *leaf) {
	int numChildren = 0;

	if (leaf->right != NULL) {
		if (leaf->left != NULL) {
			numChildren = 2;
		}
		numChildren = 1;
	}

	if (leaf->left != NULL) {
		if (leaf->right != NULL) {
			numChildren = 2;
		}
		numChildren = 1;
	}

	return numChildren;
}


void binarySearchTree::inOrderTraversal() {
	inOrderTraversalUtil(root);
}

void binarySearchTree::inOrderTraversalUtil(node * leaf) {
	if(leaf == NULL) return;
	inOrderTraversalUtil(leaf->left);
	inOrderTraversalUtil(leaf->right);
	cout << leaf->data << endl;
}

/***********************************************************************************
*		utility functions to check whether students created correct tree structures
**/
bool binarySearchTree::isBinarySearchTree(node *leaf) {
	checkForBinarySearchTree(leaf, INT_MAX, INT_MIN);
}


//O(n)
bool binarySearchTree::checkForBinarySearchTree(node *leaf, int minValue, int maxValue) {
	if (leaf == NULL) return true;

	if (leaf->data > minValue && leaf->data < maxValue && checkForBinarySearchTree(leaf->left, minValue, leaf->data) && checkForBinarySearchTree(leaf->right, leaf->data, maxValue)) return true;
	else return false;
}

bool binarySearchTree::isSubTreeLesser(node *leaf, int data) {
	if (leaf == NULL) return true;
	if (leaf->data <= data && isSubTreeLesser(leaf->left, data) && isSubTreeLesser(root->right, data)) return true;
	else return false;
}


bool binarySearchTree::isSubTreeGreater(node *leaf, int data) {
	if (leaf == NULL) return true;
	if (leaf->data  < data && isSubTreeGreater(leaf->left, data) && isSubTreeGreater(root->right, data)) return true;
	else return false;
}

/*  NAIVE APPROACH

//O(n^2)
bool checkForBinarySearchTree(node *leaf) {

	if (leaf == NULL) return true;

	if (isSubTreeLesser(leaf->left, leaf->data) && isSubTreeGreater(leaf->right, leaf->data) && checkForBinarySearchTree(root->left) && checkForBinarySearchTree(root->right)) return true;
	else {return false};
}

*/





