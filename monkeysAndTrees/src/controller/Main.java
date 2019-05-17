package controller;

import model.entity.Fruit;
import model.entity.Node;
import model.entity.Tree;
import model.logic.Monkey;
import model.random.Random;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node root1 = new Node(new ArrayList<>(),5, 20),
                root2 = new Node(new ArrayList<>(),5, 20);
        for (int i = 0; i < Random.randomCountFruit(6, 7); i++) {
            root1.getBranches().add(new Node(5,20));
            root2.getBranches().add(new Node(5,20));
        }
        Tree<Node> theFirstTree = new Tree(root1, Fruit.APPLE);
        Tree<Node> theSecondTree = new Tree(root2, Fruit.BANANA);
        System.out.println(theFirstTree.toString());
        System.out.println(theSecondTree.toString());
        Monkey m1 = new Monkey();
        System.out.println(theFirstTree.getFruitType() + ":  " + m1.countFruitOnTheTree(theFirstTree));
        Monkey m2 = new Monkey();
        System.out.println(theSecondTree.getFruitType() + ": " + m2.countFruitOnTheTree(theSecondTree));
        Monkey m3 = new Monkey();
        System.out.println("IN ALL: " + m3.countFruitOnTheTree(theFirstTree, theSecondTree));
    }

}