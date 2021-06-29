package com.codegym.model;

public class Counter {
    private int count;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() { //tăng giá trị cho mỗi lần truy cập
        return count++;
    }
}
