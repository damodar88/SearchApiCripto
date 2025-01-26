package com.search.api.delegate;

import com.search.api.controller.CryptoPriceController;
import com.search.api.mapper.SimpleDelegateMapper;
import com.search.api.model.SimplePriceResponse;
import com.search.domain.modeldto.BitcoinResponseDto;
import com.search.domain.usecase.SimpleUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CryptoPriceDelegate implements CryptoPriceController {

    private final SimpleUseCase useCase;

    private final SimpleDelegateMapper mapper;

    public CryptoPriceDelegate(SimpleUseCase useCase, SimpleDelegateMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    @GetMapping("/simple/price")
    public SimplePriceResponse getBitcoinPriceFromCoingeckoo(@RequestParam String cryptoCurrency, @RequestParam String selectedCurrency) {
        BitcoinResponseDto responseDto = useCase.getSimplePrice(cryptoCurrency, selectedCurrency);
        return mapper.simpleDelegateToBitcoinResponseDtoMapper(responseDto);
    }

}
