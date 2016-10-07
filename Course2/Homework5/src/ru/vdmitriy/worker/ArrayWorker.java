package ru.vdmitriy.worker;

/**
 * Created by VasilyevD on 07.10.2016.
 */
public class ArrayWorker {
    /**
     * Воркер, вычисляющий значение математической формулы
     * для каждого элемента массива
     * @param arr Массив, для которого необходимо посчитать значение
     *            математической формулы
     * @return  Время в миллисекундах, затраченных на задачу
     */
    public static  long worker(float[] arr){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return (System.currentTimeMillis()-a);
    }

}
