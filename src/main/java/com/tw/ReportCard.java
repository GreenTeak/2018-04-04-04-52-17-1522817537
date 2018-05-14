package com.tw;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReportCard {
    public static final String TRUE_TYPE_NUMBER="请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    public static final String BE_TYPE_NUMBER="请输入要打印的学生的学号（格式：学号,学号,学号,...）,按回车键提交\n";
    public static final String REPORT_TITLE="成绩单\n";
    public static final String REPORT_ITEM_TITLE="姓名|数学|语文|英语|编程|平均分|总分\n";
    public static final String DIVIDE_LINE="=====================\n";
    public static final String AVERAGE_TITLE="全班总分平均数：";
    public static final String MEDIAN_TITLE="全班总分中位数：";

    private List<Student> students;
    private ScanerRead scanerRead;

    public ReportCard(){
        scanerRead=new ScanerRead();
        students=new ArrayList<Student>();
    }

    public void setsource(ScanerRead scanerRead){
        this.scanerRead=scanerRead;
    }

    public boolean add(Student stu){
        int size=students.size();
        students.add(stu);
        System.out.print("学生"+stu.getName()+"的成绩被添加\n");
        return students.size()!=size;
    }
    public boolean dealStuStringAndAdd(){
        List<String> project=getLine();
        if(project.size()<3) return false;
        List<String> id=project.stream().skip(2)
                .filter(x->x.equals(x.substring(0,x.indexOf(":")-1)))
                .collect(Collectors.toList());
        List<Integer> number=project.stream().skip(2)
                .filter(x->x.equals(x.substring(x.indexOf(":")+1,x.length()-1)))
                .map((x)->Integer.valueOf(x))
                .collect(Collectors.toList());
        Map<String,Integer> score=new HashMap<>();
        for(int i=0;i<id.size();i++) score.put(id.get(i),number.get(i));
        boolean isadd=add(new Student(project.get(0),Long.parseLong(project.get(1)),score));
        return isadd;
    }
    public List<String> getLine(){
        String sc=scanerRead.read();
        String[] number=sc.split(",");
        List<String> num= Arrays.asList(number);
        return num;
    }
    public List<String> isgetlinelegal(){//判断是不符合输入
        int flag=1;
        List<String> num=new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\d+$");
        while (flag!=0){
            flag=0;
            num=getLine();
            for(String i:num){
                Matcher isNum = pattern.matcher(i);
                if( !isNum.matches() ){
                    flag=1;
                    System.out.print(TRUE_TYPE_NUMBER);
                }
            }
        }
        return num;
    }
    public String TypeScoreCard(){//打印成绩单
        String TypeScore=new String();
        List<String> num=this.isgetlinelegal();
        TypeScore+=BE_TYPE_NUMBER+REPORT_TITLE+REPORT_ITEM_TITLE+DIVIDE_LINE;
        for(String i:num){
            Student stu=students.stream().filter(x->x.getNumber()==Long.parseLong(i)).collect(Collectors.toList()).get(0);
            TypeScore+=stu.printStuInformation();
        }
        TypeScore+=DIVIDE_LINE+AVERAGE_TITLE+averagescore()+"\n"+MEDIAN_TITLE+medianscore()+"\n";
        return TypeScore;
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
