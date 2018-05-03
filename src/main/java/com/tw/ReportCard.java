package com.tw;

import java.util.*;
import java.util.stream.Collectors;

public class ReportCard {
    private List<Student> students;
    public ReportCard(){
        students=new ArrayList<Student>();
    }
   public boolean add(Student stu){
        int size=students.size();
        students.add(stu);
        System.out.print("学生"+stu.getName()+"的成绩被添加\n");
        return students.size()!=size;
    }
    public List<String> getnextline(){
        Scanner sc=new Scanner(System.in);
        String choose=sc.nextLine();
        String[] number=choose.split(",");
        List<String> num= Arrays.asList(number);
        return num;
    }
    public void TypeScoreCard(){
        System.out.print("请输入要打印的学生的学号（格式：学号,学号,学号,...）,按回车键提交\n");
        List<String> num=this.getnextline();
        System.out.print("成绩单\n");
        System.out.print("姓名|数学|语文|英语|编程|平均分|总分\n");
        System.out.print("=====================\n");
        //students.stream().forEach(Student::printStuInformation);
        for(String i:num){
            Student stu=students.stream().filter(x->x.getNumber()==Long.parseLong(i)).collect(Collectors.toList()).get(0);
            stu.printStuInformation();
        }
        System.out.print("=====================\n");
        System.out.print("全班总分平均数：");
        System.out.print(averagescore()+"\n");
        System.out.print("全班总分中位数：");
        System.out.print(medianscore()+"\n");
    }
    public Double averagescore(){
        List<Integer> score=getStuScoreList();
        DoubleSummaryStatistics status=score.stream().mapToDouble((x)->x).summaryStatistics();
        return status.getAverage();
    }
    public List<Integer> getStuScoreList(){
        List<Integer> score=students.stream().map(Student::getTotalScore).collect(Collectors.toList());
        return score;
    }
    public Double medianscore(){
        List<Integer> scorelist=getStuScoreList();
        int size=scorelist.size();
        Double median=0.0;
        List<Integer> list=scorelist.stream().sorted().collect(Collectors.toList());
        if(size%2==0){
            Integer S=scorelist.get(size/2)+scorelist.get(size/2-1);
            median=Double.parseDouble(S.toString())/2;
        }
        else median=Double.parseDouble(scorelist.get(size/2).toString());
        return median;
    }
}
