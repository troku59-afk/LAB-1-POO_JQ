/**
 * Excepción personalizada para manejar errores de negocio en el sistema de inventario.
 * Esta es una checked exception que debe ser manejada explícitamente.
 * 
 * @author Sistema de Inventario
 * @version 1.0
 */
public class InventarioException extends Exception {
    
    /**
     * Constructor que recibe un mensaje de error personalizado.
     * 
     * @param mensaje Descripción del error de negocio ocurrido
     */
    public InventarioException(String mensaje) {
        super(mensaje);
    }
}