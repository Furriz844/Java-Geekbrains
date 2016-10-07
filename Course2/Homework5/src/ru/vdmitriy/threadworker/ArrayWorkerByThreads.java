package ru.vdmitriy.threadworker;

import ru.vdmitriy.App;

import java.util.ArrayList;

/**
 * Created by VasilyevD on 07.10.2016.
 */

/**
 * Класс, разбивающий исходный массив на несколько
 * и создающий потоки для вычисления значений математической формулы
 * для каждого элемента массива
 */
public class ArrayWorkerByThreads{
    static int h; //Размер для "кусочков" исходного массива
    static float[] arr;
    static ArrayList<float[]> arrayList = new ArrayList<>();
    static ArrayList<Thread> threadList = new ArrayList<>(); //Коллекция потоков, для управления ими
    static int threads;
    /**
     * Конструктор, создающий экземпляр класса ArrayWorkerByThreads
     * @param arr Массив, для которого необходимо посчитать значение
     *            математической формулы
     * @param threads количество потоков, на которые следуюет разбить задачу
     */
    public  ArrayWorkerByThreads(float[] arr, int threads) {
        this.arr = arr;
        this.threads = threads;
        this.h = App.size/threads;
    }
    /**
     * Метод, реализующий разбиение исходного массива и запуск воркеров по потокам
     * @return Время в миллисекундах, затраченных на задачу
     */
    public static long worker(){
        long a = System.currentTimeMillis();

        for (int i = 0; i <threads ; i++) {
            float[] ar = new float[h];
            System.arraycopy(arr, 0, ar, 0, h);
            arrayList.add(ar);
        }
        for(float[] arr: arrayList) {
            ArrayThreadWorker arrayThreadWorker = new ArrayThreadWorker(arr);
            Thread thread = new Thread(arrayThreadWorker);
            thread.start();
            threadList.add(thread);
        }
        for(Thread t: threadList){
            try {
                t.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        int iterator = 0;
        for(float[] ar: arrayList) {
            System.arraycopy(ar, 0, arr, h*iterator, h);
            iterator++;
        }
        return System.currentTimeMillis()-a;
    }
}
