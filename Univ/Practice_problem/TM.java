package Univ.Practice_problem;

import java.util.Map;
import java.util.TreeMap;

public class TM {

    static class PhyscData {
        String name;
        int height;
        double eye;

        PhyscData(String name, int height, double eye) {
            this.name = name;
            this.height = height;
            this.eye = eye;
        }

        @Override
        public String toString() {
            return String.format("%s(%d, %.1f)", name, height, eye);
        }
    }

    static class node {
        String key;
        PhyscData data;
        node left;
        node right;

        node(String key, PhyscData data) {
            this.key = key;
            this.data = data;
        }
    }

    public static node search(node cur, String key) {
        if (cur == null) return null;

        if (key.compareTo(cur.key) == 0) return cur;
        if (key.compareTo(cur.key) < 0) return search(cur.left, key);
        else return search(cur.right, key);
    }

    public static node insert(node cur, String key, PhyscData data) {
        if (cur == null) return new node(key, data);

        if (key.compareTo(cur.key) < 0) cur.left = insert(cur.left, key, data);
        else if (key.compareTo(cur.key) > 0) cur.right = insert(cur.right, key, data);
        else cur.data = data;

        return cur;
    }

    public static node min_value_node(node node) {
        node cur = node;
        while (cur.left != null)
            cur = cur.left;
        return cur;
    }

    public static node _delete(node cur, String key) {
        if (cur == null) return cur;

        // 만약 키가 루트보다 작으면 왼쪽 서브 트리에 있는 것임
        if (key.compareTo(cur.key) < 0) {
            cur.left = _delete(cur.left, key);
            return cur;
        }
        // 만약 키가 루트보다 크면 오른쪽 서브 트리에 있는 것임
        else if (key.compareTo(cur.key) > 0) {
            cur.right = _delete(cur.right, key);
            return cur;
        }
        // 키가 루트와 같으면 이 노드를 삭제하면 됨

        if (cur.left == null && cur.right == null) {
            System.out.println("check1");
            return null; // case1
        }
        if (cur.left == null) {
            System.out.println("check2");
            return cur.right; // case2
        }
        if (cur.right == null) {
            System.out.println("check2");
            return cur.left; // case2
        }

        System.out.println("check3");
        node min = min_value_node(cur.right);
        cur.key = min.key;
        cur.data = min.data;
        cur.right = _delete(cur.right, min.key);

        return cur;
    }

    public static void preorder(node cur) {
        if (cur != null) {
            System.out.println(cur.data);
            preorder(cur.left);
            preorder(cur.right);
        }
    }

    public static void inorder(node cur) {
        if (cur != null) {
            inorder(cur.left);
            System.out.println(cur.data);
            inorder(cur.right);
        }
    }

    public static void postorder(node cur) {
        if (cur != null) {
            postorder(cur.left);
            postorder(cur.right);
            System.out.println(cur.data);
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
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

        System.out.println("========== TreeMap ==========");
        TreeMap<String, PhyscData> map = new TreeMap<>();

        for (int i = 0; i < x.length; i++)
            map.put(x[i].name, x[i]);

        for (Map.Entry<String, PhyscData> entry : map.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

        System.out.println();
        System.out.println("========== Binary Search Tree ==========");
        node root = null;

        for (int i = 0; i < x.length; i++)
            root = insert(root, x[i].name, x[i]);

        /*
        for (int i = 0; i < x.length; i++) {
            node r = search(root, x[i].name);
            if (r != null) System.out.println(r.data);
        }
        */

        root = _delete(root, "박준");

        System.out.println("[preorder]");
        preorder(root);
        System.out.println();

        System.out.println("[inorder]");
        inorder(root);
        System.out.println();

        System.out.println("[postorder]");
        postorder(root);
        System.out.println();
    }
}
