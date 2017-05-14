package com.jcsanchez.testing.m6;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by jsssn on 14-May-17.
 */
public class SalesAnalyser {
    private final SalesRepository repo;

    public SalesAnalyser(SalesRepository repo) {

        this.repo = repo;
    }

    public Map<String, Integer> tallyCitySales() {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(Sale::getStore,
                        summingInt(Sale::getValue)));
    }
}
