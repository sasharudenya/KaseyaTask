package model.logic;

import model.entity.Node;
import model.entity.Tree;
import java.util.Iterator;

public class Monkey {
    private int countFruitOnTheTree;

    public int countFruitOnTheTree(Tree<Node>...trees) {
        int count = 0;
        for(Tree<Node> tree: trees)
        {
            countFruitOnTheRoot(tree.getRoot());
            count += tree.getRoot().getCountFruitInBranch();
        }
        count += this.countFruitOnTheTree;
        return count;
    }

    private void countFruitOnTheRoot(Node root) {
            Iterator<Node> r = root.getBranches().iterator();
            Node node = null;
            while(r.hasNext()) {
                node = r.next();
                this.countFruitOnTheTree += node.getCountFruitInBranch();
                countFruitOnTheRoot(node);
            }
    }

}
