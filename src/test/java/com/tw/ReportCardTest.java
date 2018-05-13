package com.tw;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportCardTest {
    Map<String, Integer> score1 = new HashMap<>();
    Map<String, Integer> score2 = new HashMap<>();

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ReportCard reportCard;
    private ScanerRead mockSource;
    private PrintStream console;
    @Before
    public void setup(){
        reportCard=new ReportCard();
        console = System.out;
        System.setOut(new PrintStream(outContent));
        mockSource = mock(ScanerRead.class);

        score1.put("数学", 75);
        score1.put("语文", 95);
        score1.put("英语", 80);
        score1.put("编程", 80);
        score2.put("数学", 85);
        score2.put("语文", 80);
        score2.put("英语", 70);
        score2.put("编程", 90);
    }
    @Test
    public void testAddstu() {
        Student student1 = new Student("张三", 1234890, score1);
        ReportCard reportCard = new ReportCard();
        assertTrue(reportCard.add(student1));
    }

    @Test
    public void testAveragescore() {
        Student student1 = new Student("张三", 1234890, score1);
        Student student2 = new Student("李四", 1234891, score2);

        reportCard.add(student1);
        reportCard.add(student2);
        Double allaverage = 327.5;

        assertEquals(reportCard.averagescore(), allaverage);
    }

    @Test
    public void testmedianscore() {
        Student student1 = new Student("张三", 1234890, score1);
        Student student2 = new Student("李四", 1234891, score2);

        reportCard.add(student1);
        reportCard.add(student2);

        Double medain = 327.5;
        assertEquals(reportCard.medianscore(), medain);
    }
    @Test
    public void testgetline(){
        Student student1 = new Student("张三", 1234890, score1);
        Student student2 = new Student("李四", 1234891, score2);

        reportCard.add(student1);
        reportCard.add(student2);

        String selectnum="1234890";
        reportCard.setsource(mockSource);
        when(mockSource.read()).thenReturn(selectnum);

        List<String> num=Arrays.asList(selectnum);

        assertEquals(reportCard.getLine(), num);
    }
    @Test
    public void testTypeScoreCard(){
        Student student1 = new Student("张三", 1234890, score1);
        Student student2 = new Student("李四", 1234891, score2);

        reportCard.add(student1);
        reportCard.add(student2);

        String selectnum="1234890";
        reportCard.setsource(mockSource);
        when(mockSource.read()).thenReturn(selectnum);


    }
}
