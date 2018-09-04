package com.example.demo;

/**
 * @author shancg
 * @data 2018/9/3
 */
public class VaraibleHide {
    interface IInner {
        void printToString();
    }
    public static void main(String[] args) {
        VaraibleHide hide=new VaraibleHide();
        hide.test();
        System.out.println(hide+"11111111111");
    }

    public void test(){
        IInner inner =()->{System.out.println(this);};
        IInner inner2=new IInner() {
            @Override
            public void printToString() {
                System.out.println(this);
            }
            @Override
            public String toString() {
                return "anonymous class toString";
            }
        };
        inner.printToString();
        inner2.printToString();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Outter toString";
    }
}