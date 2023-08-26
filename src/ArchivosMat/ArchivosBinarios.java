package ArchivosMat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArchivosBinarios {

    public static void main(String[] args) {
        // PATH DE LOS ARCHIVOS
        String matA = "C:\\Users\\Rafael Arce Gaxiola\\Desktop\\DSIII\\PracticaArchivos\\src\\ArchivosMat\\a.mat";
        String matB = "C:\\Users\\Rafael Arce Gaxiola\\Desktop\\DSIII\\PracticaArchivos\\src\\ArchivosMat\\b.mat";

        //UTILIZAR DOUBLE POR EL MANEJO DE NUMERO DECIMALES

        double[][] matrizA = leerMatriz(matA);  //Double
        double[][] matrizB = leerMatriz(matB);  //Double

        double[][] matrizResultado = multiplicarMatrices(matrizA, matrizB); //double

        // Guardar la matriz resultado en un archivo c.mat
        guardarMatriz(matrizResultado, "C:\\Users\\Rafael Arce Gaxiola\\Desktop\\DSIII\\PracticaArchivos\\src\\ArchivosMat\\c.mat");

    }

    private static double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;



        double[][] resultado = new double[filasA][columnasB];
        //AQUI MULTIPLICAMOS LAS MATRICES
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                double suma = 0.0;
                for (int k = 0; k < columnasA; k++) {
                    suma += matrizA[i][k] * matrizB[k][j];
                }
                resultado[i][j] = suma;
            }
        }

        return resultado;
    }
    //MetodoLeer
    private static double[][] leerMatriz(String archivo) {
        try (FileInputStream entrada = new FileInputStream(archivo);
             DataInputStream salida = new DataInputStream(entrada)) {

            //LEER MATRITZITA
            int numFilas = salida.readByte();   //tuve que utilizar el ReadByte.
            int numColumnas = salida.readByte();   //CON ReadInt, no me aparecían las matrices.

                //MATRIZ
            double[][] matriz = new double[numFilas][numColumnas];
                            //lEER EL ARCHIVO
            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numColumnas; j++) {
                    matriz[i][j] = salida.readDouble();
                }
            }
                //RESULTADO
            System.out.println("LA MATRIZ SE ENCUENTRA  EN " + archivo + ":");
            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numColumnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

            return matriz;
        } catch (IOException e) {   //EXEPCIONESS NECESARIAS VISTAS EN CLASE
            e.printStackTrace();    //NO OLVIDAR, NO BORRAR Eduardo.
            return new double[0][];
        }
    }
        //METODOLEER
    private static void guardarMatriz(double[][] matriz, String archivo) {
        try (FileOutputStream salida = new FileOutputStream(archivo);
             DataOutputStream dos = new DataOutputStream(salida)) {

            int numFilas = matriz.length;
            int numColumnas = matriz[0].length;
//Escrib....
            dos.writeInt(numFilas);
            dos.writeInt(numColumnas);
//ESCRIBIR EWN EL ARHIVO
            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numColumnas; j++) {
                    dos.writeDouble(matriz[i][j]);
                }
            }

            System.out.println("LA MATRIZ MULTIPLICADA, HA SIDO GUARDAD EN :  " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
