package com.tw;

import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class StudentTest {
    @Test
    public void testgetTotalScore(){
        Map<String,Integer> score=new HashMap<>();
        score.put("数学",75);
        score.put("语文",95);
        score.put("英语",80);
        score.put("编程",80);
        Student student=new Student("张三",1234890,score);
        Integer totalScore=330;
        assertEquals(student.getTotalScore(),totalScore);
    }
    @Test
    public void testaveragescore(){
        Map<String,Integer> score=new HashMap<>();
        score.put("数学",75);
        score.put("语文",95);
        score.put("英语",80);
        score.put("编程",80);
        Student student=new Student("张三",1234890,score);
        Double average=82.5;
        assertEquals(student.averagescore(), average);
    }
    @Test
    public void testprintStuInformation(){
        Map<String,Integer> score=new HashMap<>();
        score.put("数学",75);
        score.put("语文",95);
        score.put("英语",80);
        score.put("编程",80);
        Student student=new Student("张三",1234890,score);
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        student.printStuInformation();
        assertThat(outputStream.toString(),is("张三|75|95|80|80|82.5|330\n"));
        //assertThat(systemOut().endWith("张三|75|95|80|80|82.5|330\n")).isTrue();
    }
}
