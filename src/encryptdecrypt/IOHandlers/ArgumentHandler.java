package encryptdecrypt.IOHandlers;

import encryptdecrypt.exceptions.ArgumentNotFoundException;

import java.util.HashMap;

public class ArgumentHandler {
    //TODO handle wrong "-mode"-s and missing arguments "-out=not given"
    private String[] args;
    private HashMap<String, String> argumentMap = new HashMap<>();

    public ArgumentHandler(String[] args) {
        this.args = args;
        setArgumentMap();
    }

    public void setArgumentMap() {
        String mode;
        String nextArg;
        for (int i = 0; i < args.length - 1; i += 2) {
            mode = args[i];
            nextArg = args[i + 1];
            argumentMap.put(mode, nextArg);
        }
        System.out.println(argumentMap.toString());
    }

    public HashMap<String, String> getArgumentMap() {
        return argumentMap;
    }
    
    public String getData() {
        return argumentMap.get("-data");
    }

    public int getKey() throws NumberFormatException {
        String key = argumentMap.get("-key");

        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException e) {
            System.out.println("Invalid key: \"" + key + "\"");
            return 0;
        }
    }

    public String getMode() {
        return argumentMap.get("-mode");
    }

    //TODO write unit test for getInPutMode
    public String getInPutMode() {
        if (argumentMap.get("-data") != null) {
            return "console";
        } else if (argumentMap.get("-in") != null) {
            return "file";
        } else {
            throw new ArgumentNotFoundException("Argument not found: -data or -in");
        }
    }

    //TODO write unit test for getOutPutMode
    public String getOutPutMode() {
        if (argumentMap.get("-out") != null) {
            return "file";
        } else {
            return "console";
        }
    }

    public String getInputFileName() {
        return argumentMap.get("-in");
    }

    public String getOutPutFileName() {
        return argumentMap.get("-out");
    }

    public String getAlgorithm() {
        return argumentMap.get("-alg");
    }
}
