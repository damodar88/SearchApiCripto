package com.search;

import com.beust.jcommander.JCommander;

import java.util.function.Supplier;

public class CommanderFunctions {

    public static <T> JCommander buildCommanderWithNames(String cliNome,
                                                         Supplier<T> argumentsSupplier){
         JCommander jCommander= JCommander.newBuilder()
                .addCommand(argumentsSupplier.get())
                .build();
         return jCommander;
    }

}
