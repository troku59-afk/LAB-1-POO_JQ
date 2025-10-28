/**
 * Clase que representa un producto electrónico en el sistema de inventario.
 * Hereda de la clase Producto y añade información sobre garantía.
 * 
 * @author Sistema de Inventario
 * @version 1.0
 */
public class ProductoElectronico extends Producto {
    
    private int mesesGarantia;
    
    /**
     * Constructor parametrizado que inicializa un producto electrónico.
     * Invoca al constructor de la clase padre para los atributos comunes.
     * 
     * @param codigo Identificador único del producto
     * @param nombre Nombre descriptivo del producto
     * @param precio Precio del producto en unidades monetarias
     * @param mesesGarantia Meses de garantía del producto electrónico
     */
    public ProductoElectronico(String codigo, String nombre, double precio, int mesesGarantia) {
        super(codigo, nombre, precio);
        this.mesesGarantia = mesesGarantia;
    }
    
    /**
     * Obtiene los meses de garantía del producto electrónico.
     * 
     * @return Meses de garantía
     */
    public int getMesesGarantia() {
        return mesesGarantia;
    }
    
    /**
     * Establece los meses de garantía del producto electrónico.
     * Valida que los meses no sean negativos.
     * 
     * @param mesesGarantia Meses de garantía del producto
     * @throws IllegalArgumentException Si los meses de garantía son negativos
     */
    public void setMesesGarantia(int mesesGarantia) {
        if (mesesGarantia < 0) {
            throw new IllegalArgumentException("Los meses de garantía no pueden ser negativos.");
        }
        this.mesesGarantia = mesesGarantia;
    }
    
    /**
     * Obtiene los detalles completos del producto electrónico.
     * 
     * @return String con información básica y meses de garantía
     */
    public String getDetalles() {
        return getDetalleBase() + ", Garantía: " + mesesGarantia + " meses";
    }
}