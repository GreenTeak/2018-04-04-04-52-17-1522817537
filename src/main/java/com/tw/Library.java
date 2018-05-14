package com.tw;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    public static final String VIEW="1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择(1~3)\n";
    private ReportCard reportCard=new ReportCard();
    public void mianView(){
        System.out.print(VIEW);
        Scanner sc=new Scanner(System.in);
        int choose=sc.nextInt();
        switch (choose){
            case 1:dealchoose1();break;
            case 2:System.out.print(reportCard.TypeScoreCard());break;
            case 3:return;
        }
    }
    public void dealchoose1(){
        System.out.print("请输入学生信息（格式:姓名,学号,学科:成绩,...），按回车提交\n");
        boolean f=false;
        while (!f){
            f=reportCard.dealStuStringAndAdd();
            if(!f) System.out.print("请按正确的格式输入（格式:姓名,学号,学科:成绩,...）\n");
        }
    }

}
