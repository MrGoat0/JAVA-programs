package model;

import javax.swing.*;

public class Main {
    /**
     -En esta clase se van a hacer ejemplos de expepciones
     -Para gestionar las Excepciones, se debe proteger el código con un bloque try{} catch{}
     -En el try{} se encuentra el código que puede generar la excepción y en el cacth{}, la acción
     cuando ocurre la excepción
     */

    public static void main(String[] args) {
        // dividir este cero
        int num1 = 10, num2 = 0;
        try {
            double div = num1/num2;
            System.out.printf("%d/%d=%f\n",num1,num2,div);
        } catch (ArithmeticException e){
            System.out.println("No se puede dividir entre cero");
        }
        try {
            int number = Integer.parseInt(JOptionPane.showInputDialog("Valor: "));
            System.out.println(number);
        }catch (NumberFormatException e){
            System.out.println("Valor invalido");
        }
        int[] nums = {11,2,3,4};
        try {
            System.out.println(nums[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Indice fuera de los limites del arreglo");
        }

        System.out.println("******************FIN DEL PROGRAMA*********************");
    }
}
