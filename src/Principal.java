import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        ConversorMoneda converter = new ConversorMoneda();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (true) {

            System.out.println("**********************************************");
            System.out.println("*** Sea Bienvenido al Conversor de Divisas ***");
            System.out.println();
            System.out.println("1. Dolar ==> Peso Aregentino");
            System.out.println("2. Peso Argentino ==> Dolar");
            System.out.println("3. Dolar ==> Real Brasileño");
            System.out.println("4. Real Brasileño ==> Dolar");
            System.out.println("5. Dolar ==> Peso Colombiano");
            System.out.println("6. Colombiano ==> Dolar");
            System.out.println("7. Salir");
            System.out.println("**********************************************");
            while (true) {
                System.out.print("Elige una opción (1-7): ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();

                    if (opcion >= 1 && opcion <= 7) {
                        break;
                    } else {
                        System.out.println("Opción fuera de rango. Intenta de nuevo.\n");
                    }
                } else {
                    System.out.println("Entrada inválida. Debes digitar un número.\n");
                    scanner.next();
                }
            }
            if (opcion == 7) {
                System.out.println("Saliendo del programa...");
                break;
            }

            double monto;
            while (true) {
                System.out.print("Ingresa el monto a convertir: ");

                if (scanner.hasNextDouble()) {
                    monto = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Entrada inválida. Debes digitar un número válido.\n");
                    scanner.next();
                }
            }

            try {
                double resultado;

                switch (opcion) {
                    case 1:
                        resultado = converter.convertir("USD", "ARS", monto);
                        System.out.println(monto + " USD = " + resultado + " ARS");
                        break;

                    case 2:
                        resultado = converter.convertir("ARS", "USD", monto);
                        System.out.println(monto + " ARS= " + resultado + " USD");
                        break;

                    case 3:
                        resultado = converter.convertir("USD", "BRL", monto);
                        System.out.println(monto + " USD= " + resultado + " BRL");
                        break;

                    case 4:
                        resultado = converter.convertir("BRL", "USD", monto);
                        System.out.println(monto + " BRL= " + resultado + " USD");
                        break;

                    case 5:
                        resultado = converter.convertir("USD", "COP", monto);
                        System.out.println(monto + " USD= " + resultado + " COP");
                        break;

                    case 6:
                        resultado = converter.convertir("COP", "USD", monto);
                        System.out.println(monto + " COP= " + resultado + " USD");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Error en la conversion: " + e.getMessage());
            }
            System.out.println();
        }
        while (opcion != 7) ;

        scanner.close();
    }

}
