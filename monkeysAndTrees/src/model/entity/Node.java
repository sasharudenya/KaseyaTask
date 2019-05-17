package model.entity;

import model.random.Random;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int countFruitInBranch;
    private List<Node> branches = new ArrayList<>();

    public Node(List<Node> branches, int beginRandom, int endRandom) {
        this.countFruitInBranch = Random.randomCountFruit(beginRandom, endRandom);
        this.branches = branches;
    }

    public Node(int beginRandom, int endRandom) {
        this.countFruitInBranch = Random.randomCountFruit(beginRandom,endRandom);
    }

    public int getCountFruitInBranch() {
        return countFruitInBranch;
    }

    public List<Node> getBranches() {
        return branches;
    }

    public void setBranches(List<Node> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "model.entity.Node{" +
                "countFruitInBranch=" + countFruitInBranch  +
                ", branches=" + branches +
                '}';
    }
}
