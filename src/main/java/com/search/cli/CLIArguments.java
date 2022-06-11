package com.search.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    public CLIArguments() {
    }


    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CLIKeywordValidator.class,
            description = "KEYWORD"
    )
    private String keyword;

    @Parameter(
            names = {"--help", "h"},
            help = true,
            validateWith = CLIKeywordValidator.class,
            description = "Mostrar ayuda"
    )
    private boolean isHelp;

    @Parameter(
            names = {"--name", "n"},
            description = "Cada besqueda puede incluir nombre"
    )
    private String name;


    public String getKeyword() {
        return keyword;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", isHelp=" + isHelp +
                ", name='" + name + '\'' +
                '}';
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }

}
