package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers.length == 0)
            throw new IllegalArgumentException();

        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> vacanciesRes = new ArrayList<>();

        for (Provider provider : providers) {
            List<Vacancy> vacancies = provider.getJavaVacancies("java Киев");
            if (vacancies != null)
                vacanciesRes.addAll(vacancies);
        }

        System.out.println(vacanciesRes.size());
    }
}