package com.company;

import org.junit.Assert;

import static org.junit.Assert.*;
import static com.company.Main.sum;
public class MainTest {

    @org.junit.Test
    public void TestSum() {
        int[][] Z= {{1,2},{3,4}} ;
        int t = sum(Z, 1, 1, 0, 0, 0);
        int ex = 10;
        Assert.assertEquals(ex,t);
    }
}