package codelab02;

import codelab02.external.ExternalStockPriceService;
import codelab02.external.StockPriceInfoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTest {

    private StockService stockService;
    private ExternalStockPriceService stockPriceServiceMock;
    private StockMapper stockMapperMock;

    @BeforeEach
    void setUp() {
        stockMapperMock = Mockito.mock(StockMapper.class);
        stockPriceServiceMock = Mockito.mock(ExternalStockPriceService.class);
        stockService = new StockService(stockPriceServiceMock, stockMapperMock);
    }

    @Test
    void whenGettingStockDetails_thenMethodsAreCalledInCorrectOrderWithCorrectInput() {
        //given
        String stockId = "testId";
        InOrder inOrder = Mockito.inOrder(stockPriceServiceMock, stockMapperMock);
        StockPriceInfoDto infoToReturn = new StockPriceInfoDto(new BigDecimal(5), "testId", "testName");
        Mockito.when(stockPriceServiceMock.fetchCurrentPrice(stockId))
                .thenReturn(infoToReturn);
        //when
        stockService.displayStockDetails(stockId);
        //then
        inOrder.verify(stockPriceServiceMock).connect();
        inOrder.verify(stockPriceServiceMock).fetchCurrentPrice(stockId);
        inOrder.verify(stockMapperMock).mapToStock(infoToReturn);
    }
}