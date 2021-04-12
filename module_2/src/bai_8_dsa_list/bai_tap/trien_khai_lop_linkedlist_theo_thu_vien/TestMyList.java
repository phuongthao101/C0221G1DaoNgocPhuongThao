package bai_8_dsa_list.bai_tap.trien_khai_lop_linkedlist_theo_thu_vien;

public class TestMyList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFist(7);
        list.addFist(5);
        list.addFist(6);
        list.add(7,9);
        list.addLast(8);
        list.printList();
    }
}
