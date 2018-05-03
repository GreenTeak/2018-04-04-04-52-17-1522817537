package com.tw;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private long  number;

    public Map<String,Integer>score;
    public Student(String name,long number,Map<String,Integer>s){
        score=new HashMap<String,Integer>();
        this.name=name;
        this.number=number;
        for(Map.Entry<String,Integer>entry:s.entrySet()){
            this.score.put(entry.getKey(),entry.getValue());
        }
    }
    private List<Integer> getScoreList(){
        List<Integer> scorelist= scorelist =score.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
        return scorelist;
    }
    public Integer getTotalScore(){
        List<Integer> scorelist=getScoreList();
        IntSummaryStatistics status=scorelist.stream().mapToInt((x)->x).summaryStatistics();
        Long sum=status.getSum();
        return sum.intValue();
    }
    void printStuInformation(){
        String[] list={"数学","语文","英语","编程"};
        List<String> printqueue=Arrays.asList(list);
        String scoreString=new String();
        for (String str:list){
            scoreString+=score.get(str)+"|";
        }
        System.out.print(this.name+"|"+scoreString+averagescore()+"|"+getTotalScore()+"\n");
    }
    public Map<String,Integer> scoregetScoreMap(){
        return score;
    }
    public Double averagescore(){
        List<Integer> scorelist=getScoreList();
        DoubleSummaryStatistics status=scorelist.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getAverage();
    }
    public String getName(){return this.name;}
    public long getNumber(){return this.number;}
}
