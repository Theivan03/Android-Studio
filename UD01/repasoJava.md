#  :iphone: Programación Multimedia y Dispositivos Móviles 2023/2024

## :books: UD01 - Análisis de tecnologías para aplicaciones en dispositivos móviles

</br>
</br>

**REPASO JAVA:**

**Ejercicio 1**:

   Dado el siguiente listado de atributos...

       String nombre;
       String direccion;
       int telefono;
       long fecha; // Milisegundos desde 1970.
       String foto;
       String url;
       String comentario;
       float valoracion;
       Coordenada posicion;                                   


 Crea una <span style="color:#b22222;">clase "Sitio"</span> en Java para almacenar datos de sitios y almacenar toda esa información sobre él. Añade el constructor, los métodos getter's y setter's de sus atributos y el método toString().

 Para inicializar la  fecha, utiliza System.currentTimeMillis();

 A continuación, crea una <span style="color:#b22222;">clase "Coordenada"</span>, que representará la longitud y latitud del sitio (ambos de tipo double). Añade el constructor, los getter's y setter's de sus atributos y el método toString(). Además añade, el método calcular distancia entre coordenadas.


      public double calcularDistanciaCoordenadas(Coordenada coord) {
          final double RADIO_TIERRA = 6371000; // metros
          double dLat = Math.toRadians(latitud - coord.latitud);
          double dLon = Math.toRadians(longitud - coord.longitud);
          double lat1 = Math.toRadians(coord.latitud);
          double lat2 = Math.toRadians(latitud);
          double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                     Math.sin(dLon/2) * Math.sin(dLon/2) *
                     Math.cos(lat1) * Math.cos(lat2);
          double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
          return c * RADIO_TIERRA;
       }


  Por último, crea una <span style="color:#b22222;">clase "Principal"</span>, donde crees un objeto de la clase "Sitio" e imprimas sus valores.

</br>

**Ejercicio 2**:

Crea una <span style="color:#b22222;">interfaz "RepoSitios"</span>, que nos permite almacenar una lista de objetos Sitio.

     public interface RepoSitios {
        Sitio elemento(int id); // Busca el sitio dado su id
        void anyade(Sitio s);   // Añade un sitio
        int nuevo();            // Añade un sitio vacio y devuelve su id
        void borrar(int id);    // Elimina el sitio con el id indicado
        int tamanyo();          // Devuelve el número de elementos
        void actualiza(int id, Sitio s); // Reemplaza el sitio
      }        

</br>

**Ejercicio 3**:

Crea un tipo enumerado <span style="color:#b22222;">"TipoSitio"</span>, para diferenciar los diferentes sitios que vamos a almacenar. Además, a cada tipo, le asociaremos un nombre y un número.

    public enum TipoSitio {
      OTROS ("Otros", 0),
      RESTAURANTE ("Restaurante", 1),
      HOTEL ("Hotel", 2),
      ESPECTACULO ("Espectáculo", 3),            
      NATURALEZA ("Naturaleza", 4)

      private final String texto;
      private final int recurso;

      // Define el constructor y sus métodos get.
      TipoSitio(...) {          

      }
      public String getTexto() {return texto;}
      public int getRecurso() {return recurso;}
    }


Modifica la <span style="color:#b22222;">clase "Sitio"</span> y añade el atributo a la clase:

    private TipoSitio tipo;
    
Además, añadelo también al constructor con parámetros e incluye el método get/set para este nuevo atributo.

Modifica el método toString() de la <span style="color:#b22222;">clase "Sitio"</span> para que incluye el nuevo atributo y modifica la <span style="color:#b22222;">clase "Principal"</span> para que el objeto sitio creado incluya el nuevo parámetro (por ejemplo: TipoSitio.HOTEL).

**Ejercicio 4**:

Crea la <span style="color:#b22222;">clase "ListaSitios"</span> que almacene un conjunto de objetos <span style="color:#b22222;">"Sitio"</span> dentro de una lista.

    public class ListaSitios implements RepoSitios {

       protected List lst;

       public ListaSitios() {
        lst = new ArrayList<>();
        inicializa();
       }

       public Sitio elemento(int id) {
           return lst.get(id);
       }

       public void anyade(Sitio s) {
           lst.add(s);
       }

       public int nuevo() {          
          lst.add(new Sitio());
          return lst.size()-1;
       }

       public void borrar(int id) {
           lst.remove(id);
       }

       public int tamanyo() {
           return lst.size();
       }

       public void actualiza(int id, Sitio s) {
           lst.set(id, s);
       }

       public void inicializa() {
        anyade(new Sitio("Congreso de los diputados", "Cra de S.Jerónimo s/n, 28071 Madrid", 40.41705, -3.69670,
            TipoLugar.OTROS, 913906000, "http://www.congreso.es",
            "Sin comentarios.", 0));

        // Crea otros sitios...        

       }

     }

Modifica la <span style="color:#b22222;">clase "Principal"</span> y reemplaza el código del main() por:

     RepoSitios sitios = new ListaSitios();

     for (int i=0; i<sitios.tamanyo(); i++) {
        System.out.println(sitios.elemento(i).toString());
     }
