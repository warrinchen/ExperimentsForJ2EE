package com.exp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TreeControllerTest {

    @Resource
    private TreeController treeController;

    @Test
    public void testGetExp2JSON() {
        System.out.println(treeController.getExp2JSON());
    }
}