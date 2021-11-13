package org.geekbrains;

import java.util.Arrays;

public class Homework {

    public static void main(String[] args) {

        // Задание 1
        int[] array = {1,1,0,0,1,0,1,1,0,0};
        invertArray(array);
        System.out.printf("Массив после инвертирования: %s%n",Arrays.toString(array));

        // Задание 2
        array = returnFilledArray(100);
        System.out.printf("%nМассив длинной 100: %s%n",Arrays.toString(array));

        // Задание 3
        int[] newArray = {1,5,3,2,11,4,5,2,4,8,9,1};
        changeArray(newArray);
        System.out.printf("%nМассив где все числа меньше 6 умножены на 2: %s%n",Arrays.toString(newArray));

        // Задание 4
        fillDiagonalArray(5);

        // Задание 5
        int[] sizeableArray = filledIntArray(7, -4);
        System.out.printf("%nМассив указанного размера, где все элементы заполнены переданным в метод значением': %s%n",Arrays.toString(sizeableArray));

        // Задание 6
        scanArray();

        // Задание 7
        int[] partitionedArray = {1,2,3,6};
        Boolean equal = ifArrayPartsEqual(partitionedArray);
        System.out.printf("%nЧасти массива %s равны = %b%n",Arrays.toString(partitionedArray),equal);

        // Задание 8
        int[] shiftArray = {2,4,6,8,10};
        int shiftAmount = -1;
        shiftArray(shiftArray,shiftAmount);
        System.out.printf("%nМассив со смещением на %d: %s%n",shiftAmount,Arrays.toString(shiftArray));
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     * @param array Массив значений 0 или 1
    */
    private static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] ^= 1; // Используем XOR на 1 для инвертирования
        }
    }

    /**
     * Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     * @param arrayLength Длина массива
     * @return Массив заполненный числами от 1 до длинны массива
     */
    private static int[] returnFilledArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        return array;
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньше 6 умножить на 2;
     * @param array Массив чисел
     */
    private static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     * (можно только одну из диагоналей, если обе сложно).
     * <p>
     * Определить элементы одной из диагоналей можно по следующему принципу:
     * индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     * @param arraySize Размер двумерного массива
     */
    private static void fillDiagonalArray(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i || j == array.length-1-i) {
                    array[i][j] = 1;
                }
                // 1-5, 2-4, 3-3, 4-2, 5-1
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Написать метод, принимающий на вход два аргумента: len и initialValue,
     * и возвращающий одномерный массив типа int длиной len,
     * каждая ячейка которого равна initialValue;
     * @param arrayLength Размер одномерного массива
     * @param initialvalue Исходное значение каждой ячейки
     * @return Одномерный массив целочисленных значений
     */
    private static int[] filledIntArray(int arrayLength, int initialvalue) {
        int[] array = new int[arrayLength];
        Arrays.fill(array,initialvalue);
        return array;
    }

    /**
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы;
     */
    private static void scanArray() {
        int[] array = {-2, 9, 6, -7, 13, 0, 17, -4};
        System.out.printf("%nМассив: %s%n",Arrays.toString(array));
        // Выводим минимальный элемент и максимальный элементы
        System.out.printf("%nМинимальный элемент массива равен %d", array[0]);
        System.out.printf("%nМаксимальный элемент массива равен %d%n", array[array.length-1]);

        // Теперь поищем минимальное значение и максимальное значением
        // Для этого отсортируем массив
        Arrays.sort(array);
        System.out.printf("%nМинимальное значение массива равно %d", array[0]);
        System.out.printf("%nМаксимальное значение массива равно %d%n", array[array.length-1]);
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место,
     * в котором сумма левой и правой части массива равны.
     * @param array Целочисленный массив
     * @return Булево значение
     */
    private static Boolean ifArrayPartsEqual(int[] array) {
        int i = 1;
        do {
            int sumLeft = 0;
            for (int j = i; j > 0; j--) {
                sumLeft = sumLeft+array[j-1];
            }
            int sumRight = 0;
            for (int j = i; j < array.length; j++) {
                sumRight = sumRight+array[j];
            }
            if (sumLeft==sumRight) {
                return true;
            }
            i++;
        } while (i<array.length);
        return false;
    }

    /**
     * Написать метод, которому на вход подается одномерный массив и число n
     * (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
     * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     * При каком n в какую сторону сдвиг можете выбирать сами.
     * @param shiftArray Целочисленный массив
     * @param shiftAmount Количество знаков для смещения массива
     */
     private static void shiftArray(int[] shiftArray, int shiftAmount) {
        int shiftTimes = 0;
        if (shiftAmount > 0) {
            do {
                int tempValue = shiftArray[shiftArray.length - 1];
                for (int i = shiftArray.length - 1; i >= 0; i--) {
                    if (i == 0) {
                        shiftArray[i] = tempValue;
                    } else {
                        shiftArray[i] = shiftArray[i - 1];
                    }
                }
                shiftTimes++;
            } while (shiftTimes < shiftAmount);
        } else if (shiftAmount < 0) {
            do {
                int tempValue = shiftArray[0];
                for (int i = 0; i < shiftArray.length; i++) {
                    if (i == shiftArray.length-1) {
                        shiftArray[shiftArray.length-1] = tempValue;
                    } else {
                        shiftArray[i] = shiftArray[i + 1];
                    }
                }
                shiftTimes--;
            } while (shiftTimes > shiftAmount);
        }
    }
}
