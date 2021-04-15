package bai_10_java_collection_framework_map.bai_tap;

public class PreOrderBST extends BinarySearchTree {
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root=createBinarySearchTree();
        preOrder(root);
    }
}
