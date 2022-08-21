import java.util.Scanner;

public class Rutificador {
    public static void main(String[] args){
        System.out.print("El número verificador es: "+ multiplicarsumar());
    }

    public static int asignarRut(){
        int rut;
        Scanner leer= new Scanner(System.in);
        System.out.print("Ingrese el Rut(sin puntos ni dígito verificador)");
        return rut=leer.nextInt();
    }

    public static int invertir(){
        int rut= asignarRut();
        int cifra, inverso = 0;
        while(rut!=0){
            cifra = rut%10;
            inverso = (inverso * 10) + cifra;
            rut/=10;
        }
        return inverso;
    }

    public static int multiplicarsumar(){
        int d=Integer.toString(invertir()).length();
        int a=invertir();
        int suma = 0;
        int contador=2;

        for(int i=0; i<d;i++){
            String num = String.valueOf(Integer.toString(a).charAt(i));
            if(contador<=7){
                suma=suma+(Integer.parseInt(num)*contador);
                contador=contador+1;
            }if(contador==8){
                suma=suma+(Integer.parseInt(num)*2);

                contador=contador+1;
            }if(contador==9){
                suma=suma+(Integer.parseInt(num)*3);
                contador=contador+1;
            }
        }
        return suma;

    }

    public static int division(){
        int division=multiplicarsumar();
        return division/11;
    }


    public static int cortardecimales(){
        int multiplicar=division();
        return multiplicar*11;
    }

    public static int valorAbsoluto(){
        int a=multiplicarsumar();
        int b=cortardecimales();
        int resta=a-b;

        if(resta<0){
            return resta*(-1);
        }else{
            return resta;
        }
    }

    public static int digitoVerificador(){
        int digito=11-valorAbsoluto();
        int k=100;
        int cero=0;
        if(digito==10){
            return (k);
        }if(digito==11){
            return cero;
        }else{
            return digito;
        }
    }


}
