package com.search.api.delegate;

import com.search.api.controller.CryptoController;
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
public class SimpleDelegate implements CryptoController {

    private final SimpleUseCase useCase;

    private final SimpleDelegateMapper mapper;

    public SimpleDelegate(SimpleUseCase useCase, SimpleDelegateMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    @GetMapping("/simple/price")
    public SimplePriceResponse getSimplePrice(@RequestParam String id, @RequestParam String vsCurrencies) {
        BitcoinResponseDto responseDto = useCase.getSimplePrice(id, vsCurrencies);
        return mapper.simpleDelegateToBitcoinResponseDtoMapper(responseDto);
    }

}
