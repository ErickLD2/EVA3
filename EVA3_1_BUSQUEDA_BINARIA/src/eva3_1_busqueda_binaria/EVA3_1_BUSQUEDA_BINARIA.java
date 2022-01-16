/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class EVA3_1_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] datos = new int[20];
        llenar(datos);
        imprimir(datos);
        selectionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner(System.in);
        int valor = input.nextInt();
        int resu= binarySearch(datos,valor);
        System.out.println("el elemento esta en la pocision"+resu);
    }

    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimir(int[] datos) {
        System.out.println("");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }

    public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            int iMin = i;
            for (int j = i + 1; j < datos.length; j++) {
                //comparar
                //valor j vs valor min
                if (datos[j] < datos[iMin]) {
                    iMin = j;
                }
            }
            //intercambio 
            if (i != iMin) {
                // 3 pasos
                //respaldar un valor
                int iTemp = datos[i];
                //intercambiar un valor
                datos[i] = datos[iMin];
                //reponer el valor respaldado
                datos[iMin] = iTemp;
            }
        }

    }

    public static int binarySearch(int[] datos, int valor) {
        return binarySearchRecu(datos, valor, 0, datos.length - 1);
    }

    private static int binarySearchRecu(int[] datos, int valor, int ini, int fin) {
        int mid, resu;
        mid = ini + ((fin - ini) / 2);
        resu = -1;
        if (fin >= ini) {
            if (valor == datos[mid]) {
            } else if (valor < datos[mid]) {
                resu = binarySearchRecu(datos, valor, ini, mid - 1);
            } else {
                resu = binarySearchRecu(datos, valor, mid + 1, fin);
            }
        }

        return resu;
    }
}
