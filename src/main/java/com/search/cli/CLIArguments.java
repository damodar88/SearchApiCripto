package com.search.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    public CLIArguments() {
    }


    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CLIKeywordValidator.class)
    private String keyword;



}
