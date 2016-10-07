package ru.vdmitriy.threadworker;

/**
 * Created by VasilyevD on 07.10.2016.
 */

/**
 * Воркер вычисляющий значение математической формулы
 * для каждого элемента массива реализующий интерфейс Runnable
 */
public class ArrayThreadWorker implements Runnable{
    float[] arr;
    public ArrayThreadWorker(float[] arr){
        this.arr = arr;
    }
    public ArrayThreadWorker(){

    };

    public void setArr(float[] arr) {
        this.arr = arr;
    }

    public float[] getArr() {
        return arr;
    }

    @Override
    public void run() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}

