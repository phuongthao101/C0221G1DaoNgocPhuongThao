package bai_9_stack_queue.bai_tap.kt_dau_ngoac_su_dung_stack;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String[] string = "s * (s – a) * (s – b) * ((s – c))) ".split("");
        Stack bStack = new Stack();
        for (String sym : string) {
            if (sym.equals("(")) {   // string dùng equal
                bStack.push("(");  // thêm vào stack
            } else if (sym.equals(")")) {
                if (bStack.isEmpty()) {
                    System.out.println(false);
                    return;
                }
                bStack.pop();
            }

        }
        if (bStack.isEmpty()) {
            System.out.println(true);
            return;
        } else {
            System.out.println(false);
            return;
        }
    }

}

