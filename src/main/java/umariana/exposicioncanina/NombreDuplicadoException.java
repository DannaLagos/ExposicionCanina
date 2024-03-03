
package umariana.exposicioncanina;

/**
 * @author JULIANA MUÑOZ
 * @author DANNA LAGOS
 */
public class NombreDuplicadoException extends Exception {
 public NombreDuplicadoException () {
     super("Ya existe un perro con ese nombre, intentelo nuevamente");
 }   
}
