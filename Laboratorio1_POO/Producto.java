/**
 * Clase padre que representa un producto genérico en el sistema de inventario.
 * Implementa encapsulamiento mediante atributos privados y métodos de acceso.
 * 
 * @author Sistema de Inventario
 * @version 1.0
 */
public class Producto {
    
    private String codigo;
    private String nombre;
    private double precio;
    private static int contadorProductos = 0;
    
    /**
     * Constructor parametrizado que inicializa un producto con sus datos básicos.
     * Incrementa automáticamente el contador de productos creados.
     * 
     * @param codigo Identificador único del producto
     * @param nombre Nombre descriptivo del producto
     * @param precio Precio del producto en unidades monetarias
     */
    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        contadorProductos++;
    }
    
    /**
     * Obtiene el código del producto.
     * 
     * @return Código del producto
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene el nombre del producto.
     * 
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el precio del producto.
     * 
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Establece un nuevo código para el producto.
     * 
     * @param codigo Nuevo código del producto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Establece un nuevo nombre para el producto.
     * Valida que el nombre no sea nulo o vacío.
     * 
     * @param nombre Nuevo nombre del producto
     * @throws IllegalArgumentException Si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es requerido.");
        }
        this.nombre = nombre;
    }
    
    /**
     * Establece un nuevo precio para el producto.
     * Valida que el precio no sea negativo.
     * 
     * @param precio Nuevo precio del producto
     * @throws IllegalArgumentException Si el precio es negativo
     */
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }
    
    /**
     * Obtiene el número total de productos creados en el sistema.
     * Este es un método estático que pertenece a la clase, no a las instancias.
     * 
     * @return Contador total de productos creados
     */
    public static int getContadorProductos() {
        return contadorProductos;
    }
    
    /**
     * Genera una cadena con la información básica del producto.
     * Método protected para ser utilizado por las clases hijas.
     * 
     * @return String con código, nombre y precio del producto
     */
    protected String getDetalleBase() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: $" + precio;
    }
}