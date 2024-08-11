import java.util.ArrayList;

public class Banco {
    private ArrayList<Cuenta> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void registrarCuenta(Cuenta nuevaCuenta) {
        cuentas.add(nuevaCuenta);
        System.out.println("Cuenta registrada con éxito.");
    }

    public Cuenta buscarCuenta(String nombre, int pin) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNombre().equals(nombre) && cuenta.getSaldo(pin) != -1) {
                return cuenta;
            }
        }
        return null;
    }
}