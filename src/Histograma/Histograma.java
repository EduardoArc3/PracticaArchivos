package Histograma;

import java.io.*;


public class Histograma {

    public static void main(String[] args) throws IOException {
        //ARCHIVO
        String PathDivinaComedia = "C:\\Users\\Rafael Arce Gaxiola\\Desktop\\DSIII\\PracticaArchivos\\src\\Histograma\\divina_comedia_sp.txt";

        File archivo = new File(PathDivinaComedia); //OBJETO DEL ARCHIVO

        if (archivo.exists()){  //if para comprobar su existencia

            FileReader fr = null;
            try {  //TRYCATCH
                fr = new FileReader(archivo);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader br = new BufferedReader(fr); //BUFFEREDREADER

            long [] longitudesContables = new long[9]; //LONGITUDES

            String linea;  //LEER LINEA POR LINEA
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
               /*AREGLO DE STRINGS
               /*
                */
               String[] palabraPorPalabra = linea.split("\\s+"); //separar por palabras
                            for (String palabra : palabraPorPalabra){  //CARACTERES ELIMINADOS
                                palabra = eliminar (palabra);
                                                int longitud = palabra.
                                                        length(); //conteo
                                                            if (longitud >= 2 && longitud <= 10){
                                                                    longitudesContables[longitud - 2] ++;
                                                            }
                            }
            }

            br.close();
            //HISTOGRAMA
            for (int i = 0; i < longitudesContables.length; i++){
                System.out.println("Longitud : " +(i + 2)  + "- Cantidad " + longitudesContables[i]);

            }
        }
    }
    private static String eliminar (String palabra){ //ELIMINAR CARACTERES NO DESEADOS

        StringBuilder constructor = new StringBuilder();

        for (char c: palabra.toCharArray()){
            if (Character.isLetter(c)){

                if (Character.isLetter(c) || c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                        c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ) {
                    constructor.append(c);
                }

            }
        }

        return constructor.toString();
    }


}
