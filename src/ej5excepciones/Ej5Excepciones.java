/*
 Escribir un programa en Java que juegue con el usuario a adivinar un número. La
computadora debe generar un número aleatorio entre 1 y 500, y el usuario tiene que
intentar adivinarlo. Para ello, cada vez que el usuario introduce un valor, la computadora
debe decirle al usuario si el número que tiene que adivinar es mayor o menor que el que
ha introducido el usuario. Cuando consiga adivinarlo, debe indicárselo e imprimir en
pantalla el número de veces que el usuario ha intentado adivinar el número. Si el usuario
introduce algo que no es un número, se debe controlar esa excepción e indicarlo por
pantalla. En este último caso también se debe contar el carácter fallido como un intento.
 */
package ej5excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej5Excepciones {

    public static void main(String[] args) {
       int num_random=(int)(Math.random() * 500);
       boolean seguir = true;
       int contador=0;
       while(seguir){ 
           try{
               if(compararNumero(pedirNumero(),num_random)){
                   seguir=false;
               }     
           }catch(InputMismatchException e){
               System.out.println("EL CARACTER INGRESADO NO ES VALIDO");
           }finally{
               contador++;
           }
       }
       
        System.out.println("FELICIDADES, EL NUMERO ERA : "+ num_random + "LO ADIVINASTE!!!");
        System.out.println("SOLO TARDASTE " + contador + "INTENTOS");
    }
    
    public static int pedirNumero()throws InputMismatchException{
        Scanner leer= new Scanner(System.in);
        System.out.println("INGRESE EL NUMERO QUE PIENSA QUE ES");
        return leer.nextInt();
    }
    
    public static boolean compararNumero(int num, int num_random){
        if (num==num_random)
        {
            return true;
        }if(num>num_random){
            System.out.println("INGRESE UN NUMERO MAS PEQUEÑO");
        }if(num<num_random){
            System.out.println("INGRESE UN NUMERO MAS GRANDE");
        }
        return false;
    }
    
}
