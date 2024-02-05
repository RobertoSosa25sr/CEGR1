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

    public static boolean esTriangulo(double lado1, double lado2, double lado3) {
        boolean condicion1 = lado1 + lado2 > lado3;
        boolean condicion2 = lado1 + lado3 > lado2;
        boolean condicion3 = lado2 + lado3 > lado1;

        return condicion1 && condicion2 && condicion3;
    }

    public String identificarTipoTriangulo() {
        if(!esTriangulo(lado1, lado2, lado3)){
            System.out.println("No es posible un triángulo con esos lados, la suma de dos lados debe ser mayor al tercer lado");
            logger.escribir("No es posible un triángulo con esos lados, la suma de dos lados debe ser mayor al tercer lado");
            System.exit(0);
        }
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
        Triangulo.obtenerDatosTriangulo(lado1,lado2,lado3);
    }

    public static void obtenerDatosTriangulo(double lado1, double lado2, double lado3){
        try {
            Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
            System.out.println("El tipo de triángulo es: " + triangulo.identificarTipoTriangulo());
            System.out.println("El área del triángulo es: " + triangulo.calcularArea());
        } catch (InputMismatchException e) {
            logger.escribir("Los datos ingresados no tienen el formato correcto, se esperaba un numero entero positivo o decimal separado por coma");
            System.out.println("Error: Los datos ingresados no son correctos");

        } catch (Exception e) {
            logger.escribir("Se produjo un error al obtener los datos del triángulo");
        }
    }
}