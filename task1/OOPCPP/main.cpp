#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <iterator>
#include <vector>
#include "bst.h"
#include "animals.h"

using namespace std;

int main() {
    string address;
    cout << "Please input address of commands file:" << endl;
    cin >> address;
    ifstream file(address);
    if(!file){//checks if inputted file address exists
        cout << "Invalid file address, using default file instead" << endl;
        file.open("oop-cpp-example.txt");
    }
    if(!file){//ends program if default file is not found after user inputs invalid address
        cout << "Default file not found, possibly renamed, moved or deleted" << endl;
        return -1;//return -1 to show failure
    }
    string currentLine;
    Node<Animal*> *animals = new Node<Animal*>();
    Animal *tempAnimal;
    try{
        while(getline(file,currentLine)){
            istringstream lineStream(currentLine);
            vector<string> tokens((istream_iterator<string>(lineStream)), istream_iterator<string>());
            if(tokens[0] == "Insert") {
                if(tokens.size() != 5){
                    cout << "Invalid number of arguments, Insert should have 4 arguments after command" << endl;
                }else if(tokens[1] == "mammal"){
                    if(stoi(tokens[3]) <= 0 | stoi(tokens[4]) <= 0){
                        cout << "Length and Average Litter Size parameters must be positive integers" << endl;
                    }else{
                        tempAnimal = new Mammal(tokens[2], stoi(tokens[3]), stoi(tokens[4]));
                        animals = insertNode(tempAnimal, animals);
                    }
                }else if(tokens[1] == "reptile"){
                    if(stoi(tokens[3]) <= 0){
                        cout << "Length parameter must be positive integers" << endl;
                    }else if(tokens[4] != "venomous" & tokens[4] != "non-venomous") {
                        cout << "Last parameter must be 'venomous' or 'non-venomous'" << endl;
                    }else{
                        tempAnimal = new Reptile(tokens[2], stoi(tokens[3]), tokens[4] == "venomous");
                        animals = insertNode(tempAnimal, animals);
                    }
                }else if(tokens[1] == "bird"){
                    if(stoi(tokens[3]) <= 0){
                        cout << "Length parameter must be positive integers" << endl;
                    }else if(tokens[4] != "can-fly" & tokens[4] != "cannot-fly") {
                        cout << "Last parameter must be 'can-fly' or 'cannot-fly'" << endl;
                    }else{
                        tempAnimal = new Bird(tokens[2], stoi(tokens[3]), tokens[4] == "can-fly");
                        animals = insertNode(tempAnimal, animals);
                    }
                }
            }else if(tokens[0] == "Find"){
                if(tokens.size() != 2){
                    cout << "Invalid number of arguments, Find should have 1 argument after command" << endl;
                }else{
                    Animal *found = findNode(animals, new Animal(tokens[1]));
                    if(found != NULL){
                        found->printDetails();
                    }else{
                        cout << "Node not found" << endl;
                    }
                }
            }else if(tokens[0] == "Remove"){
                if(tokens.size() != 2){
                    cout << "Invalid number of arguments, Delete should have 1 argument after command" << endl;
                }else{
                    deleteNode(new Animal(tokens[1]), animals);
                }
            }else{
                cout << "Invalid command, please use Insert, Find or Remove" << endl;
            }
        }
    }catch(invalid_argument&){
        cout << "Invalid argument caught when converting to integer" << endl;
    }
    inOrder(animals);
    return 0;
}