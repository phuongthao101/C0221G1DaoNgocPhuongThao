package bai_10_java_collection_framework_map.thuc_hanh.cai_dat_cay_tim_nhi_phan;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public int getSize();
}
