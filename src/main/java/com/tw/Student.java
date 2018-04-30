package com.tw;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private long  number;

    public Map<String,Integer>score;
    public Student(String name,long number,Map<String,Integer>score){
        score=new HashMap<String,Integer>();
        this.name=name;
        this.number=number;
        this.score=score;
    }
    public List<Integer> getScoreList(){
        List<Integer> scorelist=score.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
        return scorelist;
    }
    public Double getTotalScore(){
        List<Integer> scorelist=getScoreList();
        DoubleSummaryStatistics status=scorelist.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getSum();
    }
    void printStuInformation(){
        List<Integer> scorelist=getScoreList();
        String scoreString=String.join("|",(String[])scorelist.toArray());
        System.out.print(this.name+"|"+scoreString+"|"+averagescore()+"|"+getTotalScore()+"/n");
    }
    public Map<String,Integer> scoregetScoreMap(){
        return score;
    }

    public double averagescore(){
        List<Integer> scorelist=getScoreList();
        DoubleSummaryStatistics status=scorelist.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getAverage();
    }
    public String getName(){return this.name;}
    public long getNumber(){return this.number;}
}
