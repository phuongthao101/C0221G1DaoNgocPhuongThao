package bai_10_java_collection_framework_map.thuc_hanh.cai_dat_cay_tim_nhi_phan;

public class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public void inorder() {
    }

    @Override
    public int getSize() {
        return 0;
    }


}
