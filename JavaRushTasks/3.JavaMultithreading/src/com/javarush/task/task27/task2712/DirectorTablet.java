package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    // сумма заработанная на рекламе, сгруппированная по дням
    public void printAdvertisementProfit() {
        Map<Date, Double> videosSelected = StatisticManager.getInstance().getProfitReport();

        Double total = 0.0;
        for (Map.Entry<Date, Double> i : videosSelected.entrySet()) {
            total += i.getValue();
            System.out.println(String.format("%s - %s", new SimpleDateFormat("dd-MMM-yyyy").format(i.getKey()), i.getValue() / 100));
        }
        System.out.println(String.format("Total - %s", total / 100));
    }

    // загрузка (рабочее время) повара, сгруппированная по дням
    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cooksReport = StatisticManager.getInstance().getCooksReport();

        for (Map.Entry<Date, Map<String, Integer>> i : cooksReport.entrySet()) {
            ConsoleHelper.writeMessage(new SimpleDateFormat("dd-MMM-yyyy").format(i.getKey()));

            for (Map.Entry<String, Integer> j : i.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", j.getKey(), j.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    // список активных роликов и оставшееся количество показов по каждому
    public void printActiveVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

        List<Advertisement> activeVideo = statisticAdvertisementManager.getActiveAdvertisements();
        activeVideo.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : activeVideo){
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
    }

    // список неактивных роликов (с оставшемся количеством показов равным нулю)
    public void printArchivedVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

        List<Advertisement> noActiveVideo = statisticAdvertisementManager.getNoActiveAdvertisements();
        noActiveVideo.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : noActiveVideo){
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
