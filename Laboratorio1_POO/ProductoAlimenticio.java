/**
 * Clase que representa un producto alimenticio en el sistema de inventario.
 * Hereda de la clase Producto y añade información sobre fecha de caducidad.
 * 
 * @author Sistema de Inventario
 * @version 1.0
 */
public class ProductoAlimenticio extends Producto {
    
    private String fechaCaducidad;
    
    /**
     * 
     * Constructor parametrizado que inicializa un producto alimenticio.
     * Invoca al constructor de la clase padre para los atributos comunes.
     * 
     * @param codigo Identificador único del producto
     * @param nombre Nombre descriptivo del producto
     * @param precio Precio del producto en unidades monetarias
     * @param fechaCaducidad Fecha de caducidad en formato YYYY-MM-DD
     */
    public ProductoAlimenticio(String codigo, String nombre, double precio, String fechaCaducidad) {
        super(codigo, nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }
    
    /**
     * Obtiene la fecha de caducidad del producto alimenticio.
     * 
     * @return Fecha de caducidad en formato YYYY-MM-DD
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    /**
     * Establece la fecha de caducidad del producto alimenticio.
     * Valida que la fecha no sea una fecha ya pasada (simulación simple).
     * 
     * @param fechaCaducidad Fecha de caducidad en formato YYYY-MM-DD
     * @throws InventarioException Si el producto está caducado
     */
    public void setFechaCaducidad(String fechaCaducidad) throws InventarioException {
        // Validación simple: si la fecha es 2024-01-01 o anterior, está caducada
        if (fechaCaducidad != null && fechaCaducidad.compareTo("2025-01-01") < 0) {
            throw new InventarioException("El producto está caducado.");
        }
        this.fechaCaducidad = fechaCaducidad;
    }
    
    /**
     * Obtiene los detalles completos del producto alimenticio.
     * 
     * @return String con información básica y fecha de caducidad
     */
    public String getDetalles() {
        return getDetalleBase() + ", Fecha de Caducidad: " + fechaCaducidad;
    }
}