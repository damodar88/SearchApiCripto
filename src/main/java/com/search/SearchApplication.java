package com.search;

import com.beust.jcommander.JCommander;
import com.search.api.APICripto;
import com.search.cli.CLIArguments;
import com.search.dao.CriptoCurrencies;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.search.CommanderFunctions.buildCommanderWithNames;
import static com.search.CommanderFunctions.parseArguments;
import static com.search.api.APIFunctions.builtApi;

@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {

        JCommander jCommander = buildCommanderWithNames("search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                        .filter(cli -> cli.getKeyword() != null)
                        .findFirst();

        cliArgumentsOptional.map(CLIFuncions::toMap)
                .map(SearchApplication::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<CriptoCurrencies> executeRequest(Map<String , Object> params){
        APICripto api = builtApi(APICripto.class, "https://www.buda.com");

        return Stream.of(params)
                .map(api::getCryptoCurrencies)
                .flatMap(Collection::stream);
    }


}
