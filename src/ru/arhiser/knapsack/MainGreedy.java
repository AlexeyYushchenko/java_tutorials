package ru.arhiser.knapsack;

import java.util.ArrayList;

public class MainGreedy {

    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxWeight = 13;

        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int resultWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            indexes.add(i);
        }

        while (!indexes.isEmpty()) {
            int maxValue = prices[indexes.get(0)];
            int maxIndex = 0;

            for (int i = 1; i < indexes.size(); i++) {
                if (maxValue < prices[indexes.get(i)]) {
                    maxValue = prices[indexes.get(i)];
                    maxIndex = i;
                }
            }

            if (maxWeight - resultWeight >= weights[indexes.get(maxIndex)]) { //добавляем позицию, только если есть свободное место для неё.
                resultWeight += weights[indexes.get(maxIndex)];
                result.add(indexes.get(maxIndex));
                if (resultWeight == maxWeight) break; //если ничего нельзя добавить, прерываем цикл.
            }

            indexes.remove(maxIndex);
        }

        System.out.println("Оптимальное содержимое рюкзака:");
        for (Integer integer : result) {
            System.out.println(integer + 1);
        }
        System.out.println("total weight: " + resultWeight);
        System.out.println("total backpack value: " + result.stream().mapToInt(x -> prices[x]).sum());
    }
}
