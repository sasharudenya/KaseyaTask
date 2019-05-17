package model.entity;

import model.entity.Fruit;
import model.random.Random;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree<T extends Node> {
    private T root;
    private Fruit fruitType;

    public Tree(T root, Fruit fruitType) {
        this.root = root;
        addBranch(root);
        this.fruitType = fruitType;
    }

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public Fruit getFruitType() {
        return fruitType;
    }

    public void setFruitType(Fruit fruitType) {
        this.fruitType = fruitType;
    }

    public void addBranch(Node root)   {
        Iterator<Node> r = root.getBranches().iterator();
        Node node = null;
        while(r.hasNext()) {
            node = r.next();
            for( int j = 0; j < root.getBranches().size(); j++) {
                root.getBranches().get(j).setBranches(new ArrayList<>());
                for (int i = 0; i < Random.randomCountFruit(0, root.getBranches().size()); i++) {
                    root.getBranches().get(j).getBranches().add(new Node(2,25));
                }
            }
            addBranch(node);
        }
    }

    @Override
    public String toString() {
        return "model.entity.Tree{" +
                "root=" + root +
                ", fruitType=" + fruitType +
                '}';
    }
}
