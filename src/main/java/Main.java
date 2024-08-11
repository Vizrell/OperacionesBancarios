import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú del Banco");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Acceder a cuenta existente");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    System.out.print("Ingrese un PIN de 4 dígitos: ");
                    int pin = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    Cuenta nuevaCuenta = new Cuenta(nombre, saldoInicial, pin);
                    banco.registrarCuenta(nuevaCuenta);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del titular de la cuenta: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese su PIN: ");
                    pin = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    Cuenta cuenta = banco.buscarCuenta(nombre, pin);
                    if (cuenta != null) {
                        boolean cuentaActiva = true;
                        while (cuentaActiva) {
                            System.out.println("\nOperaciones de la cuenta");
                            System.out.println("1. Consultar saldo");
                            System.out.println("2. Depositar");
                            System.out.println("3. Retirar");
                            System.out.println("4. Salir");
                            System.out.print("Selecciona una opción: ");
                            int opcionCuenta = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer

                            switch (opcionCuenta) {
                                case 1:
                                    System.out.println("Saldo actual: " + cuenta.getSaldo(pin));
                                    break;
                                case 2:
                                    System.out.print("Ingrese el monto a depositar: ");
                                    double montoDeposito = scanner.nextDouble();
                                    cuenta.depositar(montoDeposito);
                                    break;
                                case 3:
                                    System.out.print("Ingrese el monto a retirar: ");
                                    double montoRetiro = scanner.nextDouble();
                                    cuenta.retirar(montoRetiro, pin);
                                    break;
                                case 4:
                                    cuentaActiva = false;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                        }
                    } else {
                        System.out.println("Cuenta no encontrada o PIN incorrecto.");
                    }
                    break;

                case 3:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
        System.out.println("Gracias por utilizar el banco.");
    }
}
