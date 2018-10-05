package com.clases.clase3;

import java.util.Map;
import java.util.TreeMap;

public class MapaDirecciones {
    public static Map<String,String> getMap(){
            Map<String,String> mapa = new TreeMap();
            mapa.put("Carlos"   , "10.12.2.198");
            mapa.put("Ariel"    , "10.12.3.24");
            mapa.put("Jonathan" , "10.12.2.236");
            mapa.put("Nahuel"   , "10.12.3.28");
            mapa.put("Matias"   , "10.12.3.84");
            mapa.put("Gerardo"  , "10.12.3.25");
            mapa.put("Hugo"     , "10.12.3.86");

            return mapa;
        }
        
}
