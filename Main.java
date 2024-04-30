package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static int[] generateRandomMatrix(int size,int maxvalue){
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * maxvalue);
        }
        return a;
    }

    static void writeArrayToFileTime(Treap treap, int[] arr, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {
                long startTime = System.nanoTime();
                treap.add(arr[i]);
                long endTime = System.nanoTime();
                writer.write(endTime - startTime  + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeArrayToFileCountOfIterations(Treap treap, int[] arr, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {
                treap.add(arr[i]);
                writer.write(treap.countOfIterations  + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeArrayToFindInArrayFileTime(Treap treap, int[] arr, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {
                long startTime = System.nanoTime();
                treap.find(arr[i]);
                long endTime = System.nanoTime();
                writer.write(endTime - startTime  + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeArrayToFindInArrayFileIterations(Treap treap, int[] arr, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {

                treap.find(arr[i]);

                writer.write(treap.countOfIterations + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeArrayToRemoveInArrayFileTime(Treap treap, int[] arr, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {
                long startTime = System.nanoTime();
                treap.remove(arr[i]);
                long endTime = System.nanoTime();
                writer.write(endTime - startTime  + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void writeArrayToRemoveInArrayFileIterations(Treap treap, int[] arr, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {

                treap.find(arr[i]);

                writer.write(treap.countOfIterations + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        Treap treap = new Treap(1);

        int[] matrixOfRandom10_000Values = generateRandomMatrix(10000,10000);

        writeArrayToFileTime(treap,matrixOfRandom10_000Values,"fileForAddTimeMeasure");
        writeArrayToFileCountOfIterations(treap,matrixOfRandom10_000Values,"fileForAddIterationsMeasure");
        writeArrayToFindInArrayFileTime(treap,matrixOfRandom10_000Values,"fileForFindTimeMeasure");
        writeArrayToFindInArrayFileIterations(treap,matrixOfRandom10_000Values,"fileForFindIterationsMeasure");
        writeArrayToRemoveInArrayFileTime(treap,matrixOfRandom10_000Values,"fileForRemoveTimeMeasure");
        writeArrayToRemoveInArrayFileIterations(treap,matrixOfRandom10_000Values,"fileForRemoveIterationsMeasure");
    }
}