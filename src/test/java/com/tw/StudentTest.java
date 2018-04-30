package com.tw;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    @Test
    public void testgetScoreList(){
        Map<String,Integer> score=new HashMap<>();
        score.put("数学",75);
        score.put("语文",95);
        score.put("英语",80);
        score.put("编程",80);
        Student student=new Student("张三",1234890,score);
        Integer[] array = new Integer[]{75,95,80,80};
        List<Integer> arrayList = Arrays.asList(array);
        assertThat(student.getScoreList());
    }
}
