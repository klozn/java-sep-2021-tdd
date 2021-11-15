package codelab02.external;

import java.math.BigDecimal;

public class NasdaqStockPriceService implements ExternalStockPriceService {

    @Override
    public void connect() {
        System.out.println("Connected!");
    }

    @Override
    public StockPriceInfoDto fetchCurrentPrice(String stockId) {
        return new StockPriceInfoDto(new BigDecimal(Math.random()), stockId, "Euro");
    }
}
