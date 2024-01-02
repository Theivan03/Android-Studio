package es.gsm.menucontextual;

import java.util.ArrayList;


public class CiudadDataSource {
    
	public static ArrayList<Ciudad> ciudades;
	
    public static void Inizialize() {
		
        ciudades =  new ArrayList<Ciudad>();
		
        ciudades.add(new Ciudad("Ciudad Real","Ciudad para tapas",R.drawable.ciudadreal));
        ciudades.add(new Ciudad("Toledo","Ciudad imperial",R.drawable.toledo));
        ciudades.add(new Ciudad("Guadalajara","Ciudad de compras",R.drawable.guadalajara));
        ciudades.add(new Ciudad("Cuenca","Casas Colgantes",R.drawable.cuenca));
        ciudades.add(new Ciudad("Albacete","Feria de la mancha",R.drawable.albacete));
        ciudades.add(new Ciudad("Talavera","Agua y sol",R.drawable.talavera));
    }
}
