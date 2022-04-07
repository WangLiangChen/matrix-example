package com.sintrue.matrix.example.test.cache;

/**
 * @author Liangchen.Wang 2022-01-03 10:30
 */
public interface I {
    default void defaultOne(){}
    default void defaultTwo(){}
    static void staticOne(){}
    static void staticTwo(){}
    void normalOne();

    class Impl implements I{
        @Override
        public void normalOne() {}
        public static void main(String[] args) {
            I.staticOne();
            I impl = new Impl();
            impl.defaultOne();
            impl.normalOne();
        }
    }
}
