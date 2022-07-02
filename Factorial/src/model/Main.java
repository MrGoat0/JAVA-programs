package model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cont = 1;
        int number = scanner.nextInt();
        if (number==0){
            System.out.println("0");
        }
        else {
            for (int i=1; i<=number; i++){
                cont*=i;
            }
            System.out.println(cont);
        }



    }
}
