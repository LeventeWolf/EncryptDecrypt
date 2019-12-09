package encryptdecrypt.IOHandlers;

public class ArgumentHandler {
    private String[] args;

    public ArgumentHandler(String[] args) {
        this.args = args;
    }

    public String getData() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-data")) {
                return args[i + 1];
            }
        return "";
    }

    public int getKey() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-key"))
                return Integer.parseInt(args[i + 1]);
        return 0;
    }

    public String getMode() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-mode")) {
                return args[i + 1];
            }
        return "enc";
    }

    public String getInputFileName() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-in"))
                return args[i + 1];
        return "";
    }

    public String getOutPutFileName() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-out"))
                return args[i + 1];
        return "";
    }

    public String[] getArgs() {
        return args;
    }

    public String getAlgorithm() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-alg"))
                return args[i + 1];
        return "";
    }
}
