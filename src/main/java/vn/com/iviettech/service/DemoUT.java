package vn.com.iviettech.service;

public class DemoUT {
    private int physical;
    private int math;

    public int average() {
        return (this.physical + this.math)/2;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
}
