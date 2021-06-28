//
// Created by jamie on 09/01/19.
//

#ifndef OOPCPP_BST_H
#define OOPCPP_BST_H
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;

template <class T> class Node{
private:

    Node<T> *leftChild, *rightChild;
    T data;

public:

    Node(){
        data = NULL;
        leftChild = NULL;
        rightChild = NULL;
    }

    Node(T data){
        this->data = data;
        leftChild = NULL;
        rightChild = NULL;
    }

    Node(T data, Node<T> *leftChild, Node<T> *rightChild){
        this->data = data;
        this->leftChild = leftChild;
        this->rightChild = rightChild;
    }

    T getData(){return this->data;}
    Node<T> *getLeftChild(){return this->leftChild;}
    Node<T> *getRightChild(){return this->rightChild;}

    void setData(T data){this->data = data;}
    void setLeftChild(Node<T> *leftChild){this->leftChild = leftChild;}
    void setRightChild(Node<T> *rightChild){this->rightChild = rightChild;}
};

template <class T> Node<T> *getSmallestNode(Node<T> *rootNode){
    Node<T> *currentNode = rootNode;

    while(currentNode->getLeftChild() != NULL){
        currentNode = currentNode->getLeftChild();
    }

    return currentNode;
}

template <class T> T findNode(Node<T> *rootNode, T key){
    Node<T> *currentNode = rootNode;
    while(currentNode != NULL){
        if(currentNode->getData()->template compareTo(key) == 0){
            cout << "Node found" << endl;
            return currentNode->getData();
        }else if(currentNode->getData()->template compareTo(key) == 1){
            currentNode = currentNode->getLeftChild();
        }else if(currentNode->getData()->template compareTo(key) == -1){
            currentNode = currentNode->getRightChild();
        }
    }
    cout << "Node not found" << endl;
    return NULL;
}

template <class T> Node<T> *insertNode(T data, Node<T> *rootNode){
    if(rootNode->getData() == NULL){
        Node<T> *tempNode = new Node<T>(data);
        rootNode = tempNode;
        cout << "Node added as head" << endl;
        return rootNode;
    }else{
        Node<T> *runnerNode = rootNode;
        while(runnerNode != NULL){
            if(data->template compareTo(runnerNode->getData()) == -1){
                if(runnerNode->getLeftChild() == NULL){
                    runnerNode->setLeftChild(new Node<T>(data));
                    cout << "Node added" << endl;
                    return rootNode;
                }else{
                    runnerNode = runnerNode->getLeftChild();
                }
            }else if(data->template compareTo(runnerNode->getData()) == 1){
                if(runnerNode->getRightChild() == NULL){
                    runnerNode->setRightChild(new Node<T>(data));
                    cout << "Node added" << endl;
                    return rootNode;
                }else{
                    runnerNode = runnerNode->getRightChild();
                }
            }else{
                cout << "Data to be entered is not unique" << endl;
                return rootNode;
            }
        }
    }
}

template <class T> Node<T> *deleteNode(T key, Node<T> *rootNode){
    if(rootNode == NULL){
        cout << "Node to be deleted not found" << endl;
        return rootNode;
    }else if(key->template compareTo(rootNode->getData()) == -1){
        rootNode->setLeftChild(deleteNode(key, rootNode->getLeftChild()));
        return rootNode;
    }else if(key->template compareTo(rootNode->getData()) == 1){
        rootNode->setRightChild(deleteNode(key, rootNode->getRightChild()));
        return rootNode;
    }else{
        if(rootNode->getLeftChild() == NULL){
            rootNode = rootNode->getRightChild();
            cout << "Node deleted" << endl;
            return rootNode;
        }else if(rootNode->getRightChild() == NULL){
            rootNode = rootNode->getLeftChild();;
            cout << "Node deleted" << endl;
            return rootNode;
        }else{//if rootNode to be deleted has two children
            Node<T> *tempNode = getSmallestNode(rootNode->getRightChild());//first fetching inorder successor i.e. smallest rootNode in right subtree
            rootNode->setData(tempNode->getData());//replacing data of rootNode to be deleted with its inorder successor
            deleteNode(rootNode->getData(), rootNode->getRightChild());//deleting the inorder successor so as not to duplicate it
        }
    }
}

template <class T> void inOrder(Node<T> *rootNode){
    if(rootNode->getData() == NULL){
        cout << "null" << endl;
    }else{
        if(rootNode->getLeftChild() != NULL){
            inOrder(rootNode->getLeftChild());
        }
        rootNode->getData()->printDetails();
        if(rootNode->getRightChild() != NULL){
            inOrder(rootNode->getRightChild());
        }
    }
}

template <class T> void preOrder(Node<T> *rootNode){
    if(rootNode->getData() == NULL){
        return;
    }else{
        rootNode->getData()->printDetails();
        if(rootNode->getLeftChild() != NULL){
            inOrder(rootNode->getLeftChild());
        }
        if(rootNode->getRightChild() != NULL){
            inOrder(rootNode->getRightChild());
        }
    }
}

template <class T> void postOrder(Node<T> *rootNode){
    if(rootNode->getData() == NULL){
        return;
    }else{
        if(rootNode->getLeftChild() != NULL){
            inOrder(rootNode->getLeftChild());
        }
        if(rootNode->getRightChild() != NULL){
            inOrder(rootNode->getRightChild());
        }
        rootNode->getData()->printDetails();
    }
}


#endif //OOPCPP_BST_H