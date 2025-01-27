package com.search.api.delegate;

import com.search.api.controller.CryptoPriceController;
import com.search.api.mapper.BitcoinDtoToPriceResponseMapper;
import com.search.api.model.MarketPriceResponse;
import com.search.domain.modeldto.CryptoMarketPriceDomainDTO;
import com.search.domain.usecase.GetMarketPriceFromCoinGeckoUseCase;
import com.search.domain.usecase.GetMarketPriceFromBudaUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CryptoPriceDelegate implements CryptoPriceController {

    private final GetMarketPriceFromCoinGeckoUseCase geckoUseCase;

    private final GetMarketPriceFromBudaUseCase budaUseCase;

    private final BitcoinDtoToPriceResponseMapper mapper;

    public CryptoPriceDelegate(GetMarketPriceFromCoinGeckoUseCase geckoUseCase, GetMarketPriceFromBudaUseCase budaUseCase, BitcoinDtoToPriceResponseMapper mapper) {
        this.geckoUseCase = geckoUseCase;
        this.budaUseCase = budaUseCase;
        this.mapper = mapper;
    }

    @Override
    @GetMapping("/markets/crypto/prices")
    public MarketPriceResponse getBitcoinPriceFromCoingeckoo(@RequestParam String cryptoCurrency, @RequestParam String selectedCurrency) {

        CryptoMarketPriceDomainDTO responseGeckoDto = geckoUseCase.getBitcoinPrice(cryptoCurrency, selectedCurrency);
        CryptoMarketPriceDomainDTO responseBudaDto = budaUseCase.getBitcoinPrice(cryptoCurrency);

        return mapper.simpleDelegateToBitcoinResponseDtoMapper(responseGeckoDto, responseBudaDto);
    }

}
