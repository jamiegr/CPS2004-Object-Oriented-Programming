//
// Created by jamie on 10/01/19.
//

#ifndef OOPCPP_ANIMALS_H
#define OOPCPP_ANIMALS_H
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;


class Animal{
private:
    string name;
    string type;
    int length;
public:
    string getName(){return name;}
    string getType(){return type;}
    int getLength(){return length;}
    void setName(string name){this->name = name;}
    void setLength(int length){this->length = length;}
    Animal(){
        name = "";
        length = 0;
        type = "Animal";
    }

    Animal(string name){
        this->name = name;
        length = 0;
        type = "Animal";
    }

    Animal(string name, int length, string type){
        this->name = name;
        this->length = length;
        this->type = type;
    }

    virtual void printDetails(){
        cout << "Name: " << name << endl;
        cout << "Length: " << length << endl;
        cout << "Type: " << type << endl;
    }

    int compareTo(Animal* animal2){
        if(name > animal2->getName()){
            return 1;
        }else if(name < animal2->getName()){
            return -1;
        }else{
            return 0;
        }
    }

    bool operator > (Animal op2){
        return name > op2.getName();
    }

    bool operator < (Animal op2){
        return name < op2.getName();
    }

    bool operator == (Animal op2){
        return name == op2.getName();
    }

    bool operator > (string op2){
        return name > op2;
    }

    bool operator < (string op2){
        return name < op2;
    }

    bool operator == (string op2){
        return name == op2;
    }

    virtual ~Animal(){}
};

class Mammal : public Animal{
private:
    int avgLitterSize;
public:
    int getLitterSize(){return avgLitterSize;}
    void setLitterSize(int avgLitterSize){this->avgLitterSize = avgLitterSize;}
    Mammal():Animal("Mammal"){
        avgLitterSize = 0;
    }

    Mammal(string name, int length, int avgLitterSize):Animal(name, length, "Mammal"){
        this->avgLitterSize = avgLitterSize;
    }

    void printDetails(){
        cout << "Name: " << getName() << endl;
        cout << "Length: " << getLength() << endl;
        cout << "Type: " << getType() << endl;
        cout << "Average Litter Size: " << avgLitterSize << endl;
    }

    ~Mammal(){}
};

class Reptile : public Animal{
private:
    bool venomous;
    string type = "Reptile";
public:
    bool isVenomous(){return venomous;}
    void setVenomous(bool venomous){this->venomous = venomous;}
    Reptile():Animal("Reptile"){
        venomous = false;
    }

    Reptile(string name, int length, bool venomous):Animal(name, length, "Reptile"){
        this->venomous = venomous;
    }

    void printDetails(){
        cout << "Name: " << getName() << endl;
        cout << "Length: " << getLength() << endl;
        cout << "Type: " << getType() << endl;
        cout << "Venomous: " << venomous << endl;
    }

    ~Reptile(){}
};

class Bird : public Animal{
private:
    bool flying;
    string type = "Bird";
public:
    bool canFly(){return flying;}
    void setFlying(bool flying){this->flying = flying;}
    Bird():Animal("Bird"){
        flying = false;
    }

    Bird(string name, int length, bool flying):Animal(name, length, "Bird"){
        this->flying = flying;
    }

    void printDetails(){
        cout << "Name: " << getName() << endl;
        cout << "Length: " << getLength() << endl;
        cout << "Type: " << getType() << endl;
        cout << "Can Fly: " << flying << endl;
    }

    ~Bird(){}
};

#endif //OOPCPP_ANIMALS_H