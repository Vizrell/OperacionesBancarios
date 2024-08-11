public class Cuenta {
    private String nombre;
    private double saldo;
    private int pin;

    // Constructor
    public Cuenta(String nombre, double saldoInicial, int pin) {
        this.nombre = nombre;
        this.saldo = saldoInicial;
        this.pin = pin;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getSaldo(int pin) {
        if (this.pin == pin) {
            return saldo;
        } else {
            System.out.println("PIN incorrecto.");
            return -1;
        }
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("El monto a depositar debe ser mayor a cero.");
        }
    }

    public boolean retirar(double monto, int pin) {
        if (this.pin == pin) {
            if (saldo >= monto) {
                saldo -= monto;
                return true;
            } else {
                System.out.println("Fondos insuficientes.");
                return false;
            }
        } else {
            System.out.println("PIN incorrecto.");
            return false;
        }
    }
}