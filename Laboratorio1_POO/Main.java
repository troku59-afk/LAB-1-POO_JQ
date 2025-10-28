import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el sistema de gestión de inventario.
 * Captura datos del usuario y maneja excepciones de forma robusta.
 * Permite registrar productos electrónicos y alimenticios mediante un menú interactivo.
 * 
 * @author Sistema de Inventario
 * @version 1.0
 */
public class Main {
    
    /**
     * Método principal que inicia la aplicación.
     * Presenta un menú para elegir el tipo de producto a registrar.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = null;
        boolean continuar = true;
        
        try {
            scanner = new Scanner(System.in);
            // Configurar el scanner para usar punto como separador decimal
            scanner.useLocale(Locale.US);
            
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("X    SISTEMA DE GESTIÓN DE INVENTARIO       X");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println();
            
            // Bucle principal del menú
            while (continuar) {
                // Mostrar menú de opciones
                mostrarMenu();
                
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                System.out.println();
                
                switch (opcion) {
                    case 1:
                        registrarProductoElectronico(scanner);
                        break;
                    case 2:
                        registrarProductoAlimenticio(scanner);
                        break;
                    case 3:
            
                       
                        
            
                        continuar = false;
                        break;
                    default:
                        System.err.println("❌ Opción inválida. Por favor seleccione 1, 2 o 3.");
                }
                
                // Pausa antes de mostrar el menú nuevamente
                if (continuar) {
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine();
                    System.out.println("\n");
                }
            }
            
        } catch (InputMismatchException e) {
            System.err.println("\n Error de entrada: Debe ingresar un número válido para la opción.");
            
        } catch (Exception e) {
            System.err.println("\n Error inesperado: " + e.getMessage());
            
        } finally {
            // Cerrar el Scanner en el bloque finally
            if (scanner != null) {
                scanner.close();
            }
            
            // Mostrar el contador total de productos creados
            System.out.println("\n" + "=".repeat(45));
            System.out.println(" Total de productos creados: " + Producto.getContadorProductos());
            System.out.println("=".repeat(45));
        }
    }
    
    /**
     * Muestra el menú principal de opciones al usuario.
     */
    private static void mostrarMenu() {
        System.out.println("x...........................................x");
        System.out.println("x       MENÚ DE REGISTRO DE PRODUCTOS       x");
        System.out.println("x...........................................x");
        System.out.println("x  1. Registrar Producto Electrónico        x");
        System.out.println("x  2. Registrar Producto Alimenticio        x");
        System.out.println("x  3. Salir                                 x");
        System.out.println("x...........................................x");
        System.out.println();
    }
    
    /**
     * Registra un nuevo producto electrónico solicitando los datos al usuario.
     * Maneja las excepciones de validación de forma específica.
     * 
     * @param scanner Scanner para capturar la entrada del usuario
     */
    private static void registrarProductoElectronico(Scanner scanner) {
        ProductoElectronico producto = null;
        
        try {
            System.out.println("─── REGISTRO DE PRODUCTO ELECTRÓNICO ───");
            System.out.println();
            
            // Solicitar código del producto
            System.out.print("Ingrese el código del producto: ");
            String codigo = scanner.nextLine();
            
            // Solicitar nombre del producto
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            
            // Solicitar precio del producto
            System.out.print("Ingrese el precio del producto: $");
            double precio = scanner.nextDouble();
            
            // Solicitar meses de garantía
            System.out.print("Ingrese los meses de garantía: ");
            int mesesGarantia = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            // Crear el producto electrónico
            producto = new ProductoElectronico(codigo, nombre, precio, mesesGarantia);
            
            // Validar los datos mediante setters
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setMesesGarantia(mesesGarantia);
            
            // Mostrar los detalles del producto creado
            System.out.println();
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("x    PRODUCTO REGISTRADO EXITOSAMENTE        x");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(producto.getDetalles());
            
        } catch (IllegalArgumentException e) {
            // Manejo de errores de validación
            System.err.println("\n Error de validación: " + e.getMessage());
            
        } catch (InputMismatchException e) {
            // Manejo de errores de entrada del usuario
            System.err.println("\n Error de entrada: Debe ingresar un valor numérico válido.");
            scanner.nextLine(); // Limpiar el buffer en caso de error
            
        } catch (Exception e) {
            // Manejo de cualquier otro error inesperado
            System.err.println("\n Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Registra un nuevo producto alimenticio solicitando los datos al usuario.
     * Maneja las excepciones de validación y de negocio de forma específica.
     * 
     * @param scanner Scanner para capturar la entrada del usuario
     */
    private static void registrarProductoAlimenticio(Scanner scanner) {
        ProductoAlimenticio producto = null;
        
        try {
            System.out.println("─── REGISTRO DE PRODUCTO ALIMENTICIO ───");
            System.out.println();
            
            // Solicitar código del producto
            System.out.print("Ingrese el código del producto: ");
            String codigo = scanner.nextLine();
            
            // Solicitar nombre del producto
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            
            // Solicitar precio del producto
            System.out.print("Ingrese el precio del producto: $");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            
            // Solicitar fecha de caducidad
            System.out.print("Ingrese la fecha de caducidad (YYYY-MM-DD): ");
            String fechaCaducidad = scanner.nextLine();
            
            // Crear el producto alimenticio
            producto = new ProductoAlimenticio(codigo, nombre, precio, fechaCaducidad);
            
            // Validar la fecha de caducidad (lanza checked exception)
            producto.setFechaCaducidad(fechaCaducidad);
            
            // Validar otros datos mediante setters
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            
            // Mostrar los detalles del producto creado
            System.out.println();
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("x    PRODUCTO REGISTRADO EXITOSAMENTE        x");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(producto.getDetalles());
            
        } catch (InventarioException e) {
            // Manejo de errores de negocio (producto caducado)
            System.err.println("\n Error de negocio: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
            // Manejo de errores de validación
            System.err.println("\n Error de validación: " + e.getMessage());
            
        } catch (InputMismatchException e) {
            // Manejo de errores de entrada del usuario
            System.err.println("\n Error de entrada: Debe ingresar un valor numérico válido para el precio.");
            scanner.nextLine(); // Limpiar el buffer en caso de error
            
        } catch (Exception e) {
            // Manejo de cualquier otro error inesperado
            System.err.println("\n Error inesperado: " + e.getMessage());
        }
    }
}