package modelo;

public class ListaPersonajes {

    // Vector de 100 espacios
    public static Personaje[] lista = new Personaje[10];
    public static int contador = 0;

    // Método para agregar personajes
    public static boolean agregar(Personaje p) {
        if (contador < 100) {
            lista[contador] = p;
            contador++;
            return true;
        }
        return false;
    }

    // Obtener personaje
    public static Personaje get(int i) {
        if (i >= 0 && i < contador) {
            return lista[i];
        }
        return null;
    }

    // Tamaño actual
    public static int size() { 
        return contador;
    }

    //Método para cargar 4 personajes iniciales
    public static void cargarIniciales() {
        
        agregar(new Personaje("1", "Harry", "Gryffindor", "Nimbus 2000",0));
        agregar(new Personaje("2", "Draco", "Slytherin", "Nimbus 2001",0));
        agregar(new Personaje("3", "Cedric", "Hufflepuff", "Saeta de Fuego",0));
        agregar(new Personaje("4", "Cho", "Ravenclaw", "Nimbus 2000",0));
        
    }

    
    
}