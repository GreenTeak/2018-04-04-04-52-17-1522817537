package com.tw;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private long  number;

    public Map<String,Double>score;
    public Student(String name,long number,Map<String,Double>score){
        score=new HashMap<String,Double>();
        this.name=name;
        this.number=number;
        this.score=score;
    }
    public List<Double> getScoreList(){
        List<Double> scorelist=score.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
        return scorelist;
    }
    public Double getTotalScore(){
        List<Double> scorelist=getScoreList();
        DoubleSummaryStatistics status=scorelist.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getSum();
    }
    void printStuInformation(){
        List<Double> scorelist=getScoreList();
        String scoreString=String.join("|",(String[])scorelist.toArray());
        System.out.print(this.name+"|"+scoreString+"/n");
    }
    public Map<String,Double> scoregetScoreMap(){
        return score;
    }

    public double averagescore(){
        List<Double> scorelist=getScoreList();
        DoubleSummaryStatistics status=scorelist.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getAverage();
    }
    public Double medianscore(){
        List<Double> scorelist=getScoreList();
        int size=scorelist.size();
        Double median=scorelist.stream().sorted()
                .filter(s-> s.equals(size%2==0?(scorelist.get(size/2)+scorelist.get(size/2+1))/2:scorelist.get(size/2)))
                .collect(Collectors.toList()).get(0);
        return median;
    }
    public String getName(){return this.name;}
    public long getNumber(){return this.number;}
}
