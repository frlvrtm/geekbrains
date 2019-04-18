package com.geekbrains.lesson11;

import com.geekbrains.lesson11.annotations.AfterSuite;
import com.geekbrains.lesson11.annotations.BeforeSuite;
import com.geekbrains.lesson11.annotations.Test;

public class Tests {

    @Test(priority = 1)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("test4");
    }

    @Test(priority = 5)
    public void test5() {
        System.out.println("test5");
    }

    @Test(priority = 6)
    public void test6() {
        System.out.println("test6");
    }

    @Test(priority = 7)
    public void test7() {
        System.out.println("test7");
    }

    @Test(priority = 8)
    public void test8() {
        System.out.println("test8");
    }

    @Test(priority = 9)
    public void test9() {
        System.out.println("test9");
    }

    @Test(priority = 10)
    public void test10() {
        System.out.println("test10");
    }

    @BeforeSuite
    public void testBefore() {
        System.out.println("testBefore");
    }

    @AfterSuite
    public void testAfter() {
        System.out.println("testAfter");
    }
}
