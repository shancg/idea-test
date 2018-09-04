package com.example.demo;

import java.util.function.Function;

/**
 * @author shancg
 * @data 2018/8/31
 */
public class Lambda {

    public static void main(String[] args) {


        SayHello sayHello = ()->System.out.println("Hello");
        sayHello.sayHello();

        System.out.println(addNums((a, b) -> a + b,1,2));

        int x = 20;
        IInner inner = new IInner() {

            @Override
            public void printInt(int x) {
                System.out.println(x);
            }
        };
        inner.printInt(30);

        IInner newInner = (a)-> System.out.println(x);
        newInner.printInt(30);
    }



    public static int addNums(AddNum addNum,int a,int b){
        return addNum.add(a,b);
    }

    interface IInner {
        void printInt(int x);
    }

}
interface SayHello{
    void sayHello();
    static void sayGoodbye(){};
    default void sayGoodMorning(){};
}

interface AddNum{
    int add(int a,int b);
}


