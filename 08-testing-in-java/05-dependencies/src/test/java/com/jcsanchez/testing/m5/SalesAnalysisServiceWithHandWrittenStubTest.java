package com.jcsanchez.testing.m5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by jsssn on 14-May-17.
 */
public class SalesAnalysisServiceWithHandWrittenStubTest {

    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples", "Cardiff", 10, 2),
            new Sale("Oranges", "Cardiff", 3, 5),
            new Sale("Bananas", "Cardiff", 6, 20),
            new Sale("Oranges", "London", 5, 7)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
    }

    @Test
    public void shouldAggregateStoreSales() {
        SalesRepository stubRepository = new SalesRepository() {
            @Override
            public List<Sale> loadSales() {
                return exampleSales;
            }
        };
        SalesAnalysisService analysisService = new SalesAnalysisService(stubRepository);

        Map<String, Integer> storeSales = analysisService.tallyStoreSales();

        assertEquals(expectedStoreSales, storeSales, "Calculated wrong store sales");
    }
}
