package com.search;

import com.beust.jcommander.JCommander;
import com.search.cli.CLIArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.search.CommanderFunctions.buildCommanderWithNames;

@SpringBootApplication
public class SearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}

	JCommander jCommander = buildCommanderWithNames("search", CLIArguments::newInstance);


}
