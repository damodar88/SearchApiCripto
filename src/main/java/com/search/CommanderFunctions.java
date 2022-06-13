package com.search;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {

    public static <T> JCommander buildCommanderWithNames(String cliNome,
                                                         Supplier<T> argumentsSupplier){
         JCommander jCommander= JCommander.newBuilder()
                .addCommand(argumentsSupplier.get())
                .build();

         jCommander.setProgramName(cliNome);
         return jCommander;
    }


    static Optional<List<Object>> parseArguments(
            JCommander jCommander,
            String[] argumets,
            Consumer<JCommander> onError
    ){
        try {
            jCommander.parse(argumets);

            return Optional.of(jCommander.getObjects());
        }catch (ParameterException parameterException){
            onError.accept(jCommander);
        }
            return Optional.empty();
    }

}
