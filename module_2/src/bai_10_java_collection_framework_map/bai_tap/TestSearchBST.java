package bai_10_java_collection_framework_map.bai_tap;

import bai_10_java_collection_framework_map.thuc_hanh.cai_dat_cay_tim_nhi_phan.BST;

public class TestSearchBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        System.out.println(tree.search(15));
    }
}
