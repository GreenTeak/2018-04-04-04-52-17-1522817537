package com.tw;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private ReportCard reportCard=new ReportCard();

    public void mianView(){
        System.out.print("1.添加学生\n");
        System.out.print("2.生成成绩单\n");
        System.out.print("3.退出\n");
        System.out.print("请输入你的选择（1~3）");
        Scanner sc=new Scanner(System.in);
        int choose=sc.nextInt();
        switch (choose){
            case 1:dealchoose1();
            case 2:reportCard.TypeScoreCard();
            case 3:return;
        }
    }
    public void dealchoose1(){
        System.out.print("请输入学生信息（格式:姓名,学号,学科:成绩,...），按回车提交\n");
        boolean f=false;
        while (!f){
            f=dealStuStringAndAdd();
            if(!f) System.out.print("请按正确的格式输入（格式:姓名,学号,学科:成绩,...）\n");
        }
    }
    public boolean dealStuStringAndAdd(){
        Scanner s=new Scanner(System.in);
        String stu=s.nextLine();
        String[] student=stu.split(",");
        List<String> project=Arrays.asList(student);
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
        reportCard.add(new Student(project.get(0),Long.parseLong(project.get(1)),score));
        return true;
    }
}
