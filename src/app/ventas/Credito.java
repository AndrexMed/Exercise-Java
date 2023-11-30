
package app.ventas;

/**
 *
 * @author giova
 */
public class Credito {
    private String nombreCliente;
    private double valorCredito;

    public Credito(String nombreCliente, double valorCredito) {
        this.nombreCliente = nombreCliente;
        this.valorCredito = valorCredito;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getValorCredito() {
        return valorCredito;
    }
    
}
