package ru.vdmitriy;

import ru.vdmitriy.threadworker.ArrayWorkerByThreads;
import ru.vdmitriy.worker.ArrayWorker;

/**
 * Created by VasilyevD on 07.10.2016.
 */
public class App {
    public static final int size = 200000; //Размер исходного массива
    static float[] arr = new float[size];
    static int threamAmount = 4; //Количество потоков, для воркера, работающего в несколько потоков

    public static void main(String[] args) {
        initArray(arr);
        System.out.println("Время выполнения в один поток " + ArrayWorker.worker(arr)+" мс");
        initArray(arr);
        ArrayWorkerByThreads arrayWorkerByThreads = new ArrayWorkerByThreads(arr,threamAmount);
        System.out.println("Время выполнения задачи в несколько потоков "+ arrayWorkerByThreads.worker()+" мс");

    }
    public static void initArray(float[] arr){
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }
    }
}
