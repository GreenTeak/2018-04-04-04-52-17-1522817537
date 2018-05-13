package com.tw;

import java.util.Scanner;

public class ScanerRead {
    private final Scanner source;

    public ScanerRead() { source = new Scanner(System.in);}
    public String read(){
        return source.nextLine();
    }
}
