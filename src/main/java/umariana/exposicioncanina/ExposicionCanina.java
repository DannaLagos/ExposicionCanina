
package umariana.exposicioncanina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author JULIANA MUÑOZ
 * @author DANNA LAGOS
 */
public class ExposicionCanina {
    private ArrayList<Perro> misPerros;
    private Scanner lector;

public ExposicionCanina() {
        //Permite inicializar los productos de una clase
        misPerros = new ArrayList<>();
        lector = new Scanner(System.in);
    }
    //Muestra el Menu de Opciones
    public void mostrarMenu() {
        boolean activo = true;
        
        do {
            //Imprimir el Menu
            System.out.println("====== Menu de opciones ======");
            System.out.println("1. Agregar un nuevo Perro");
            System.out.println("2. Mostrar la informacion de un perro especifico");
            System.out.println("3. Organizador de Raza,Puntaje y Edad");
            System.out.println("4. Modificar informacion registrada");
            System.out.println("5. Buscar Perro con mayor puntaje");
            System.out.println("6. Buscar perro con menor puntaje");
            System.out.println("7. Buscar perro con mayor edad");
            System.out.println("8. Eliminar Perro");
            System.out.println("9. Salir ");
            System.out.println("Digite su opción");
            System.out.println("=================================");            
            
            //Lee las opciones del usuario
            int opcion = lector.nextInt();
                //Ejecuta la accion, de opcion selecionada
                switch (opcion) {
                case 1:
                    try {
                    agregarPerro();
                    }catch(NombreDuplicadoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                       encontrarPerroPorNombre();
                    }
                    break;
                    case 3:
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                       mostrarInformacionPerroEspecifico();
                    }
                    break;
                case 4:
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                       modificarInformacion();
                    }
                    break;
                case 5:  
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                       perroGanador();
                    }
                    break;
                case 6:
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                        perroMenorPuntaje();
                    }
                    break;
                case 7:
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                       perroMayor();
                    }
                    break;
                case 8:
                    if(misPerros.size()==0){
                        System.out.println("No hay Perros agregados");
                    } else {
                        //Llama al metodo 
                       eliminarPerro();
                    }
                    break;
                case 9:
                    //Cambia la variable para salir del menu
                    activo = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    //Para opciones invalidas
                    System.out.println("opcion no valida");
            }
        } 
        //Bucle para cuando se cumple las variables
        while (activo);
    }
    
    //Metodo agregar Perro
    public void agregarPerro () throws NombreDuplicadoException{
               System.out.println("Ingrese el nombre del perro");
               lector.nextLine();
               String nombre = lector.nextLine();
                  //Llama a la excepcion si hay un nombre repetido
                  if (!misPerros.isEmpty()) {
                  for(Perro p: misPerros)
                  {
                  if (p.getNombre().equalsIgnoreCase(nombre)) 
                  {
                  throw new NombreDuplicadoException();
                  }
                 }
               }
              System.out.println("Ingrese la edad del perro en meses");
              int edadMeses = lector.nextInt();
              System.out.println("Ingrese la raza del perro");
              lector.nextLine();
              String raza = lector.nextLine();
              
              // Solicita al usuario que ingrese el puntaje del perro de 1 a 5, y repite hasta que el puntaje sea válido
              int puntaje;
              do {
              System.out.println("Ingrese los puntos del perro de 1 a 5");
              puntaje = lector.nextInt();
              if (puntaje < 1 || puntaje > 5) {
              //// Verifica si el puntaje está fuera del rango válido
              System.out.println("La puntos debe estar entre 1 a 5. Inténtelo otra vez.");
              }else{
              }
              } while (puntaje < 1 || puntaje > 5);
              
              System.out.println("Ingrese la foto del perro ej:chucho.jpg");
              lector.nextLine();
              String foto = lector.nextLine();
              //Crea un nuevo Objeto
              Perro nuevoPerro = new Perro( nombre, edadMeses, raza, puntaje,foto);
              //Agrega el nuevoPerro al ArrayList de misPerros
              misPerros.add(nuevoPerro);
              System.out.println("Informacion del perro agregada satisfactoriamente");   
    }

   //Metodo encontrar perro por nombre
    public void encontrarPerroPorNombre() {
        lector.nextLine();
        System.out.println("Ingrese el nombre del perro que desea encontrar:");
        String nombre = lector.nextLine();
        boolean encontrado = false;
    
        for (Perro p : misPerros) {
             // Comprobar si el nombre del perro coincide con el nombre ingresado por el usuario
             if (p.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                // Imprimir la información del perro encontrado
                System.out.println("Información del perro:");
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Edad En Meses: " + p.getEdadMeses());
                System.out.println("Raza: " + p.getRaza());
                System.out.println("Puntaje " + p.getPuntaje());
                System.out.println("Foto: " + p.getFoto());
                // Continúa mostrando la información que desees sobre el perro
             break;
        }
      }
      // Si no se encontró el perro, imprimir un mensaje indicando lo mismo
      if (!encontrado) {
        System.out.println("No se encontró ningún perro con ese nombre.");
      }
     }
    
    public void mostrarInformacionPerroEspecifico() {
          // Bucle 
          do {
              System.out.println("====== ¿Como desea ordenar los Perros? ========");
              System.out.println("1. Puntaje.");
              System.out.println("2. Edad.");
              System.out.println("3. Raza.");
              System.out.println("4. Salir del menú.");
              System.out.println("============================");
              
              // Leer la opción ingresada por el usuario
              int opcion = lector.nextInt();
              lector.nextLine(); 
              
              // Opción seleccionada por el usuario
              switch (opcion) {
                  case 1:
                      // Organiza la lista de perros por puntaje y mustrar el listado
                      organizarPorPuntaje();
                      mostrarListadoPerros("Puntaje");
                      break;
                  case 2:
                      // Organizar la lista de perros por edad y mustrar el listado
                      organizarPorEdad();
                      mostrarListadoPerros("Edad");
                      break;
                  case 3:
                      //Organizar la lista de perros por edad y mustrar el listado
                      organizarRaza();
                      mostrarListadoPerros("Raza");
                  break;
                  case 4:
                      // Salir del menú de opciones
                      System.out.println("Salió del menú.");
                      System.out.println("====================");
                      return;
                  default:
                      // Para opciones inválidas
                      System.out.println("Opción no válida.");
                      break;
              }
              // Repite el menú hasta que el usuario decida salir
          } while (true); // Repite el menú hasta que el usuario decida salir
      }
    private void organizarRaza(){
        //funcion para mistrar la raza en orden
        Collections.sort(misPerros, Comparator.comparing(Perro::getRaza));
        System.out.println("La raza de los perros");
        for(Perro p:misPerros){
            System.out.println(p.getRaza());
        }
    }

      // Ordena la lista de perros por edad en orden ascendente
      private void organizarPorEdad() {
           // Utiliza el algoritmo de ordenamiento de burbuja
          for (int i = 0; i < misPerros.size() - 1; i++) {
              for (int j = 0; j < misPerros.size() - i - 1; j++) {
                  if (misPerros.get(j).getEdadMeses() > misPerros.get(j + 1).getEdadMeses()) {
                      // Intercambiar perros si el perro actual tiene una edad mayor que el siguiente perro
                      Perro p = misPerros.get(j);
                      misPerros.set(j, misPerros.get(j + 1));
                      misPerros.set(j + 1, p);
                  }
              }
          }
      }

      // Ordenar la lista de perros por puntaje en orden ascendente
      private void organizarPorPuntaje() {
           // Utiliza el algoritmo de ordenamiento de burbuja
          for (int i = 0; i < misPerros.size() - 1; i++) {
              for (int j = 0; j < misPerros.size() - i - 1; j++) {
                  if (misPerros.get(j).getPuntaje() > misPerros.get(j + 1).getPuntaje()) {
                      // Intercambiar perros si el perro actual tiene un puntaje mayor que el siguiente perro
                      Perro p = misPerros.get(j);
                      misPerros.set(j, misPerros.get(j + 1));
                      misPerros.set(j + 1, p);
                  }
              }
          }
      }

      // Mustrar el listado de perros ordenado por edad o puntaje
      private void mostrarListadoPerros(String orden) {
          System.out.println("Listado de caninos ordenado por " + orden + ":");
          for (Perro p : misPerros) {
              System.out.println( "1. Nombre: "+ p.getNombre()+"\n"
                        + "2. Edad en Meses: "+ p.getEdadMeses()+"\n"
                        + "3. Raza: "+ p.getRaza()+"\n"
                        + "4. Puntaje: "+ p.getPuntaje()+"\n"
                        + "5. Foto: "+ p.getFoto()+"\n"
                        + "6. Salir\n"
                        + "_____");
          }
          System.out.println("============================================================");
      }
       
    public void modificarInformacion() {
           lector.nextLine();
           System.out.println("Ingrese el perro al que desea modificar la informacion:");
           String nombreBuscado = lector.nextLine();
           boolean activo = false;
           
           for (Perro p: misPerros) {
           // Comprobar si el nombre del perro coincide con el nombre buscado
           if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
           do {
               // Mostrar el menú de opciones para modificar la información del perro
               System.out.println("==== ¿Que informacion desea modificar? ====");
               System.out.println("1. La edad.");
               System.out.println("2. La raza.");
               System.out.println("3. El puntaje.");
               System.out.println("4. La foto.");
               System.out.println("5. Para salir del menu.");
               System.out.println("=============================");
                       
            int opcion = lector.nextInt();
                       lector.nextLine(); 
                       switch (opcion) {
                           case 1:
                               modificarEdad(p);
                               break;
                           case 2:
                               modificarRaza(p);
                               break;
                           case 3:
                               modificarPuntaje(p);
                               break;
                           case 4:
                               modificarFoto(p);
                               break;
                           case 5:
                               salir();
                               activo = true;
                               break;
                           default:
                               System.out.println("Opción no válida");
                               break;
                       }
                   } while (!activo);
               }
           }
       }

       public void modificarEdad(Perro p) {
       System.out.println("Ingrese la nueva edad en meses:");
       int nuevaEdadMeses = lector.nextInt();
       // Actualiza la edad del perro 
       p.setEdadMeses(nuevaEdadMeses);
       System.out.println("Edad modificada con éxito.");
    }

       public void modificarRaza(Perro p) {
       System.out.println("Ingrese la nueva raza:");
       // Lee la nueva raza proporcionada por el usuario
       String nuevaRaza = lector.nextLine();
       // Actualiza la raza del perro 
       p.setRaza(nuevaRaza);
        System.out.println("Raza modificada con éxito.");
    }

       public void modificarPuntaje(Perro p) {
       System.out.println("Ingrese el nuevo puntaje:");
       // Lee el nuevo puntaje  
       int nuevoPuntaje = lector.nextInt();
       // Actualizar el puntaje del perro 
       p.setPuntaje(nuevoPuntaje);
       System.out.println("Puntaje modificado con éxito.");
    }
       public void modificarFoto(Perro p) {
       System.out.println("Ingrese la nueva Foto:");
       // Lee la nueva 
       String nuevaFoto = lector.nextLine();
       // Actualizar la raza del perro 
       p.setFoto(nuevaFoto);
        System.out.println("Foto modificada con éxito.");
    }

       // Método de salida
       public void salir() {
       System.out.println("Salió de las modificaciones.");
       System.out.println("================================");    
    }
       
       
   public void perroGanador() {
    System.out.println("=== Muestra el perro con mayor puntaje===");
        for (int i = 0; i < misPerros.size() - 1; i++) {
        for (int j = i + 1; j < misPerros.size(); j++) {
            Perro perro1 = misPerros.get(i);
            Perro perro2 = misPerros.get(j);
            if (perro1.getPuntaje()> perro2.getPuntaje()) {
                // Intercambia los perros si están en el orden incorrecto
                misPerros.set(i, perro2);
                misPerros.set(j, perro1);
            }
        }
       }
    
       // Muestra el perro con mayor puntaje
       Perro perroMayorPuntaje = misPerros.get(misPerros.size() - 1);
       System.out.println("Perro con mayor puntaje: ");
       System.out.println("Nombre Perro: " + perroMayorPuntaje.getNombre()
                        + "\nEdad: " + perroMayorPuntaje.getEdadMeses()
                        + "\nRaza: " + perroMayorPuntaje.getRaza()
                        + "\nPuntaje: " + perroMayorPuntaje.getPuntaje()
                        + "\nFoto: " + perroMayorPuntaje.getFoto()
                        + "\n==================");
    }
    
    public void perroMenorPuntaje() {
         System.out.println("=== Muestra el perro con menor puntaje ===");
           for (int i = 0; i < misPerros.size() - 1; i++) {
              for (int j = i + 1; j < misPerros.size(); j++) {
                   Perro perro1 = misPerros.get(i);
                    Perro perro2 = misPerros.get(j);
                  if (perro1.getPuntaje() > perro2.getPuntaje()) {
                      // Intercambia los perros si están en el orden incorrecto
                   misPerros.set(i, perro2);
                   misPerros.set(j, perro1);
            }
        }
    }
             // Muestra el perro con menor puntaje
            Perro perroMenorPuntaje = misPerros.get(0);
            System.out.println("Perro con menor puntaje: ");
            System.out.println("Nombre Perro: " + perroMenorPuntaje.getNombre()
                        + "\nEdad: " + perroMenorPuntaje.getEdadMeses()
                        + "\nRaza: " + perroMenorPuntaje.getRaza()
                        + "\nPuntaje: " + perroMenorPuntaje.getPuntaje()
                        + "\nFoto: " + perroMenorPuntaje.getFoto()
                        + "\n==================");
}
    
    public void perroMayor() {
         System.out.println("=== Muestra el perro con mayor edad ===");

         // Ordena los perros por edad (de menor a mayor)
         for (int i = 0; i < misPerros.size() - 1; i++) {
           for (int j = i + 1; j < misPerros.size(); j++) {
            Perro perro1 = misPerros.get(i);
            Perro perro2 = misPerros.get(j);
            if (perro1.getEdadMeses() > perro2.getEdadMeses()) {
                // Intercambia los perros si están en el orden incorrecto
                misPerros.set(i, perro2);
                misPerros.set(j, perro1);
            }
        }
    }

    // Muestra el perro con mayor edad
        Perro perroMayorEdad = misPerros.get(misPerros.size() - 1); // El último perro es el de mayor edad
        System.out.println("Perro con mayor edad: ");
        System.out.println("Nombre Perro: " + perroMayorEdad.getNombre()
                + "\nEdad: " + perroMayorEdad.getEdadMeses()
                + "\nRaza: " + perroMayorEdad.getRaza()
                + "\nPuntaje: " + perroMayorEdad.getPuntaje()
                + "\nFoto: " + perroMayorEdad.getFoto()
                + "\n==================");
}
    public void eliminarPerro(){
        System.out.println("Ingrese el nombre del perro que quiere eliminar");
                    lector.nextLine();
                    String nombre = lector.nextLine();
                        for(Perro p: misPerros){
                        // Comprobar si el nombre del perro coincide con el nombre buscado
                        if(p.getNombre().equalsIgnoreCase(nombre)){
                                    // Mostrar mensaje de confirmación para eliminar el perro
		                    System.out.println("¿Esta seguro de eliminar este perro?");
		                    System.out.println("Ingrese: 1 para eliminar o 2 para Salir: ");
                                    // Leer la opción seleccionada
		                    int opcion = lector.nextInt();
		                    if (opcion == 1) {
                                        //Elimina el perro
		                        misPerros.remove(p);
		                        System.out.println("El perro con el nombre: " + nombre + " ha sido eliminado.");
		                    } else if(opcion==2){
		                        System.out.println("El perro no ha sido eliminado.");
		                    }
                                    // Salir del bucle ya que se encontró el perro
		                    break;
		                } else{
                            //Mensaje si el nombre no coincide 
		                System.out.println("No se encontro ningun perro con ese nombre.");
		            }
		            
		            }
		        }

    public static void main(String[] args) {
        //Crea un Objeto de la clase Diario
        ExposicionCanina expo = new ExposicionCanina();
        //Llama al metodo de mostrarmenu de Opciones para la ejecutacion
        expo.mostrarMenu();
    }
}
