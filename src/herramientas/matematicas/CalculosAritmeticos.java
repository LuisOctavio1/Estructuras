package herramientas.matematicas;

/**
 * Clase que hara calculos aritmeticos.
 */
public class CalculosAritmeticos {
    /**
     * Metodo que realiza la multiplicacion de dos numeros recursivamente.
     * @param a El numero a multiplicar.
     * @param b El numero que definira cuantas veces se repitira la suma.
     * @return El resultado de la multiplicacion.
     */
    public static double multiplicacion(double a, double b){
        if(b==1){
            return a;
        }else{
            return  a + multiplicacion(a,b-1);
        }
    }

    /**
     * Metodo que indica si un numero es primo.
     * @param primo El numero a comprobar si es primo.
     * @return
     */
    public static boolean esNumeroPrimo(int primo){
        return numeroPrimoAux(primo,primo-1);
    }

    /**
     * Metodo auxiliar y recursivo que indicara si un numero es binario.
     * @param primo El numero a comprobar si es primo.
     * @param divisor El numero por el que diviremos nuestro numero.
     * @return true si es primo, false en caso contrario.
     */
    private static boolean numeroPrimoAux(int primo, int divisor){
        if(primo ==1){
            return false;
        }
        if(divisor ==1){
            return true;
        }else{
            if(primo % divisor == 0){
                return false;
            }else{
                return numeroPrimoAux(primo,divisor-1);
            }
        }
    }

    /**
     * Metodo que indica el maximo comun divisor de dos numeros.
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return El maximo comun divisor entre los dos.
     */
    public static int maximoComunDivisor(int a, int b){
        if(a == b){
            return a;
        }else{
            if(a<b){
                return maximoComunDivisor(a,b-a);
            }else{
                return maximoComunDivisor(a-b,b);
            }
        }
    }



}
