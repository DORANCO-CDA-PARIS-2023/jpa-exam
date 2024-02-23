package com.doranco;


import com.doranco.jpaexam.service.JpaExamCLI;

public class App {
    public static void main( String[] args ) {
        JpaExamCLI jpaCLI = new JpaExamCLI(System.in);
        System.exit(jpaCLI.start());
    }
}
