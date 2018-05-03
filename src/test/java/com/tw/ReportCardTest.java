package com.tw;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ReportCardTest {
    @Test
    public void testAddstu() {
        Map<String, Integer> score1 = new HashMap<>();
        score1.put("数学", 75);
        score1.put("语文", 95);
        score1.put("英语", 80);
        score1.put("编程", 80);
        Student student1 = new Student("张三", 1234890, score1);
        ReportCard reportCard = new ReportCard();
        assertTrue(reportCard.add(student1));
    }

    @Test
    public void testAveragescore() {
        Map<String, Integer> score1 = new HashMap<>();
        score1.put("数学", 75);
        score1.put("语文", 95);
        score1.put("英语", 80);
        score1.put("编程", 80);
        Student student1 = new Student("张三", 1234890, score1);
        Map<String, Integer> score2 = new HashMap<>();
        score2.put("数学", 85);
        score2.put("语文", 80);
        score2.put("英语", 70);
        score2.put("编程", 90);
        Student student2 = new Student("李四", 1234891, score2);
        ReportCard reportCard = new ReportCard();

        reportCard.add(student1);
        reportCard.add(student2);
        Double allaverage = 327.5;
        assertEquals(reportCard.averagescore(), allaverage);
    }

    /*@Test
    public void testmedianscore() {
        Map<String, Integer> score1 = new HashMap<>();
        score1.put("数学", 75);
        score1.put("语文", 95);
        score1.put("英语", 80);
        score1.put("编程", 80);
        Student student1 = new Student("张三", 1234890, score1);
        Map<String, Integer> score2 = new HashMap<>();
        score2.put("数学", 85);
        score2.put("语文", 80);
        score2.put("英语", 70);
        score2.put("编程", 90);
        Student student2 = new Student("李四", 1234891, score2);
        ReportCard reportCard = new ReportCard();

        reportCard.add(student1);
        reportCard.add(student2);

        Double medain = 327.5;
        assertEquals(reportCard.medianscore(), medain);
    }*/
}
