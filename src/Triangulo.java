import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangulo {
    private double lado1, lado2, lado3;
    private static final LogWriter logger = new LogWriter();

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }


    public String identificarTipoTriangulo() {

        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }


    public static double obtenerLado(Scanner scanner) {
        while (true) {
            try {
                double lado = scanner.nextDouble();
                if (lado >= 0) {
                    return lado;
                } else {
                    System.out.println("Error: La longitud del lado no puede ser negativa. Intenta nuevamente:");
                    logger.escribir("Error: La longitud del lado no puede ser negativa. Intenta nuevamente:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido para la longitud del lado, recuerda separar por coma los decimales. Intenta nuevamente:");
                logger.escribir("Los datos ingresados no tienen el formato correcto, se esperaba un numero entero positivo o decimal separado por coma");
                scanner.next();
            }
        }
    }

    public static void nuevoTriangulo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la longitud del lado 1:");
        double lado1 = Triangulo.obtenerLado(scanner);
        System.out.println("Ingrese la longitud del lado 2:");
        double lado2 = Triangulo.obtenerLado(scanner);
        System.out.println("Ingrese la longitud del lado 3:");
        double lado3 = Triangulo.obtenerLado(scanner);

    }


}
