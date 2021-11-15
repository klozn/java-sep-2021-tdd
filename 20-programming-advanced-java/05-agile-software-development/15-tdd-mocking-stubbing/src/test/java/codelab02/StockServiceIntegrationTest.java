package codelab02;

import codelab02.domain.Stock;
import codelab02.external.ExternalStockPriceService;
import codelab02.external.NasdaqStockPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StockServiceIntegrationTest {

    private StockService stockService;
    private ExternalStockPriceService externalStockPriceService;
    private StockMapper stockMapper;

    @BeforeEach
    void setUp() {
        stockMapper = new StockMapper();
        externalStockPriceService = new NasdaqStockPriceService();
        stockService = new StockService(externalStockPriceService, stockMapper);
    }

    @Test
    void displayStockDetailsIntegrationTest() {
        Optional<Stock> result = stockService.displayStockDetails("testId");

        Stock stock = result.get();

        assertEquals("testId", stock.getStockId());
        assertEquals("Euro", stock.getPrice().getCurrency());
    }
}
