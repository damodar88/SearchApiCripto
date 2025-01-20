package com.search.api.delegate;

import com.search.api.controller.CryptoController;
import com.search.api.mapper.SimpleDelegateMapper;
import com.search.api.model.SimplePriceResponse;
import com.search.domain.modelDto.BitcoinResponseDto;
import com.search.domain.usecase.SimpleUseCase;
import org.springframework.stereotype.Component;

@Component
public class SimpleDelegate implements CryptoController {

    private final SimpleUseCase useCase;

    private final SimpleDelegateMapper mapper;

    public SimpleDelegate(SimpleUseCase useCase, SimpleDelegateMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public SimplePriceResponse getSimplePrice(String id, String vsCurrencies) {
        BitcoinResponseDto responseDto = useCase.getSimplePrice(id, vsCurrencies);
        return mapper.simpleDelegateToBitcoinResponseDtoMapper(responseDto);
    }

}
