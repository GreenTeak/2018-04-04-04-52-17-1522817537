package com.tw;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCard {
    private List<Student> students;
    public ReportCard(){
        students=new ArrayList<Student>();
    }
    boolean add(Student stu){
        int size=students.size();
        students.add(stu);
        System.out.print("学生"+stu.getName()+"的成绩被添加\n");
        return students.size()!=size;
    }
    void TypeScoreCard(){
        System.out.print("成绩单\n");
        System.out.print("姓名|数学|语文|英语|编程|平均分|总分\n");
        System.out.print("=====================\n");
        students.stream().forEach(Student::printStuInformation);
        System.out.print("=====================\n");
        System.out.print("全班总分平均数：");
        System.out.print(averagescore()+"\n");
        System.out.print("全班总分中位数：");
        System.out.print(medianscore()+"\n");
    }
    public double averagescore(){
        List<Double> score=getStuScoreList();
        DoubleSummaryStatistics status=score.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getAverage();
    }
    private List<Double> getStuScoreList(){
        List<Double> score=students.stream().map(Student::getTotalScore).collect(Collectors.toList());
        return score;
    }
    public Double medianscore(){
        List<Double> scorelist=getStuScoreList();
        int size=scorelist.size();
        Double median=scorelist.stream().sorted()
                .filter(s-> s.equals(size%2==0?(scorelist.get(size/2)+scorelist.get(size/2+1))/2:scorelist.get(size/2)))
                .collect(Collectors.toList()).get(0);
        return median;
    }
}
