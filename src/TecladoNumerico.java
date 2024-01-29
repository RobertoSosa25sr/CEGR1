import java.util.InputMismatchException;
import java.util.Scanner;

public class TecladoNumerico {


    public TecladoNumerico() {
    }

    public static double ingresarLado(){
        Scanner entradaTeclado = new Scanner(System.in);
        try{
            return entradaTeclado.nextDouble();
        }
        catch (InputMismatchException e){
            return -1;
        }

    }

    public  void ingresarLados(Triangulo triangulo) {
        double[] ladosTriangulo = new double[3];
        double ladoIngresado;
        System.out.println("Ingrese la  longitud de los 3 lados del triángulo:");
        for (int i = 0; i < 3; i++) {
            ladoIngresado = ingresarLado();
            if (ladoIngresado > 0) {
                ladosTriangulo[i] = ladoIngresado;
            } else {
                while (ladoIngresado <= 0) {
                    System.out.println("El lado ingresado no es correcto, recuerde ingresar un número mayor a cero y usar una coma para separar los decimales");
                    ladoIngresado = ingresarLado();
                }
            }
        }
        System.out.println(ladosTriangulo[0]);
        System.out.println(ladosTriangulo[1]);
        System.out.println(ladosTriangulo[2]);

    }
}
