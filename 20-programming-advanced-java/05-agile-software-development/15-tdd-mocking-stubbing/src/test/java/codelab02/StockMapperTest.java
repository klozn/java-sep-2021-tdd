package codelab02;

import codelab02.domain.Stock;
import codelab02.external.StockPriceInfoDto;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StockMapperTest {

    private StockMapper mapper;

    @Test
    void mappingToStock_whenInfoIsNull_thenReturnEmptyOptional() {
        mapper = new StockMapper();

        Optional<Stock> stockOptional =  mapper.mapToStock(null);

        assertTrue(stockOptional.isEmpty());
    }

    @Test
    void mappingToStock_whenInfoNotNull_thenReturnOptionalWithCorrectValues() {
        mapper = new StockMapper();
        StockPriceInfoDto infoDto = new StockPriceInfoDto(BigDecimal.TEN, "testId", "testCurrency");

        Optional<Stock> result = mapper.mapToStock(infoDto);

        assertTrue(result.isPresent());
        Stock stock = result.get();

        assertEquals(BigDecimal.TEN, stock.getPrice().getValue());
        assertEquals("testId", stock.getStockId());
        assertEquals("testCurrency", stock.getPrice().getCurrency());
    }
}