package Univ.Practice_problem;

import java.util.*;

class PhyscData implements Comparable<PhyscData> {

    String name;
    int height;
    double eye;

    public PhyscData(String name, int height, double eye) {
        this.name = name;
        this.height = height;
        this.eye = eye;
    }

    @Override
    public int compareTo(PhyscData o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %.1f)", name, height, eye);
    }
}

class Node {
    PhyscData data;
    Node left;
    Node right;

    public Node(PhyscData data) {
        this.data = data;
    }
}

class BinaryTree {

    Node root;

    public void insert(PhyscData data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, PhyscData data) {

        if (node == null)
            return new Node(data);

        if (data.compareTo(node.data) < 0)
            node.left = insertRec(node.left, data);
        else
            node.right = insertRec(node.right, data);

        return node;
    }

    // 전위
    public void preorder(Node node) {
        if (node == null) return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위
    public void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    // 후위
    public void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
    }
}

public class using_treemap {

    private PhyscData x[] = {
            new PhyscData("박준서", 175, 2.0),
            new PhyscData("유서범", 171, 1.5),
            new PhyscData("장경오", 174, 1.2),
            new PhyscData("김찬우", 173, 0.7),
            new PhyscData("황지안", 169, 0.8),
            new PhyscData("이수연", 168, 0.4),
            new PhyscData("강민하", 162, 0.3),
            new PhyscData("박준", 175, 2.0),
            new PhyscData("유서", 171, 1.5),
            new PhyscData("장경", 174, 1.2),
            new PhyscData("김찬", 173, 0.7),
            new PhyscData("황지", 169, 0.8),
            new PhyscData("이수", 168, 0.4),
            new PhyscData("강민", 162, 0.3)
    };

    public void run() {

        System.out.println("================================");
        System.out.println("1. TreeMap");
        System.out.println("================================");

        TreeMap<PhyscData, String> map = new TreeMap<>();

        for (PhyscData p : x) {
            map.put(p, p.name);
        }

        for (Map.Entry<PhyscData, String> e : map.entrySet()) {
            System.out.println(e.getKey());
        }

        System.out.println("\n================================");
        System.out.println("2. Binary Search Tree");
        System.out.println("================================");

        BinaryTree tree = new BinaryTree();

        for (PhyscData p : x) {
            tree.insert(p);
        }

        System.out.println("\n[PreOrder]");
        tree.preorder(tree.root);

        System.out.println("\n[InOrder]");
        tree.inorder(tree.root);

        System.out.println("\n[PostOrder]");
        tree.postorder(tree.root);

        System.out.println("\n================================");
        System.out.println("3. Comparable 확인");
        System.out.println("================================");

        System.out.println(
                "compareTo()를 제거하면 TreeMap<PhyscData,...> 생성 시\n" +
                "ClassCastException 발생\n" +
                "이유 : TreeMap은 key 정렬을 위해 Comparable 필요");
    }

    public static void main(String[] args) {
        new using_treemap().run();
    }
}