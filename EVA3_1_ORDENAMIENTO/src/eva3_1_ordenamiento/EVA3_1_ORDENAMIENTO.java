/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamiento;

/**
 *
 * @author PC
 */
public class EVA3_1_ORDENAMIENTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] datos = new int[10];
        int[] copiaSel = new int[datos.length];
        int[] copiaIns = new int[datos.length];
        int[] copiaBub = new int[datos.length];
        int[] copiaQuick = new int[datos.length];
        long iniT, finT;
        llenar(datos);

        System.out.println("prueba con selection sort");
        duplicar(datos, copiaSel);
        imprimir(copiaSel);
        iniT = System.nanoTime();
        selectionSort(copiaSel);
        finT = System.nanoTime();
        imprimir(copiaSel);
        System.out.println("");
        System.out.println("tiempo en orden:" + (finT - iniT));

        System.out.println("prueba con insertion sort");
        duplicar(datos, copiaIns);
        imprimir(copiaIns);
        iniT = System.nanoTime();
        insertionSort(copiaIns);
        finT = System.nanoTime();
        imprimir(copiaIns);
        System.out.println("");
        System.out.println("tiempo en orden:" + (finT - iniT));

        System.out.println("prueba con Bubble sort");
        duplicar(datos, copiaBub);
        imprimir(copiaBub);
        iniT = System.nanoTime();
        bubbleSort(copiaBub);
        finT = System.nanoTime();
        imprimir(copiaBub);
        System.out.println("");
        System.out.println("tiempo en orden:" + (finT - iniT));

        System.out.println("prueba con quick sort");
        duplicar(datos, copiaQuick);
        imprimir(copiaQuick);
        iniT = System.nanoTime();
        quickSort(copiaQuick);
        finT = System.nanoTime();
        imprimir(copiaQuick);
        System.out.println("");
        System.out.println("tiempo en orden:" + (finT - iniT));

    }

    //llenado de arreglo
    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    //duplicar arreglo
    public static void duplicar(int[] datos, int[] copia) {
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
    }
    //copia de arreglo

    //imprimir arreglo
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

    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];
            int insP = i;
            for (int prev = i - 1; prev > 0; prev--) {
                if (datos[prev] > temp) {
                    datos[insP] = datos[prev];
                    insP--;
                } else {
                    break;
                }
            }
            //insertamos
            datos[insP] = temp;
        }

    }

    public static void bubbleSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < (datos.length - 1); j++) {
                //comparamos j vs j+1
                if (datos[j] > datos[j + 1]) {
                    //intercambios
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] datos) {
        quickSortRecu(datos, 0, datos.length - 1);
    }

    private static void quickSortRecu(int[] datos, int ini, int fin) {
        int iPivote;
        int too_big;
        int too_small;
        boolean stopBig = false, stopSmall = false;
        //controlar la recursividad
        int tama = fin - ini + 1;
        if (tama > 1) {
            iPivote = ini;
            too_big = ini + 1;
            too_small = fin;
            for (int i = ini + 1; i <= fin; i++) {
                if ((datos[too_big] < datos[iPivote]) && (!stopBig)) {
                    too_big++;
                } else {
                    stopBig = true;
                }
                if ((datos[too_small] >= datos[iPivote]) && (!stopSmall)) {
                    too_small++;
                } else {
                    stopSmall = true;
                }
                if (stopBig && stopSmall) {
                    if (too_big < too_small) {
                        int temp = datos[too_big];
                        datos[too_big] = datos[too_small];
                        datos[too_small] = temp;
                        stopBig = false;
                        stopSmall = false;
                    } else {
                        break;
                    }
                }
                int temp = datos[iPivote];
                datos[iPivote] = datos[too_small];
                datos[too_small] = temp;
                iPivote = too_small;
                // quick izq
                quickSortRecu(datos, ini, iPivote - 1);
                //quick der
                quickSortRecu(datos, iPivote + 1, fin);
            }
        }
    }
}
