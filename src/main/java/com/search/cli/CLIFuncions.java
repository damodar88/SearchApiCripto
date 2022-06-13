package com.search.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFuncions {

    public static Map<String, Object> toMap(CLIArguments cliArguments){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("description", cliArguments.getKeyword());
    }

}
