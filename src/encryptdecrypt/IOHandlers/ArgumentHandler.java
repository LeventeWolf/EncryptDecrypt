package encryptdecrypt.IOHandlers;

public class ArgumentHandler {
    //TODO use a HashMap for arguments:
    //key: -data value: "Welcome to hyperskill!
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

    //TODO write unit test for getInPutMode
    public String getInPutMode() {
        boolean wasData = false;
        boolean wasInPutFileName = false;

        for (String arg : args) {
            if (arg.equals("-data")) wasData = true;
            else if (arg.equals("-in")) wasInPutFileName = true;
        }
        if (wasData) {
            return "console";
        } else if (wasInPutFileName) {
            return "file";
        } else {
            //TODO: can throw ArgumentNullException
            //Hyperskill implementation = return "";
            return "";
        }
    }

    //TODO write unit test for getOutPutMode
    public String getOutPutMode() {
        boolean wasOutPut = false;

        for (String arg : args) {
            if (arg.equals("-out")) {
                wasOutPut = true;
                break;
            }
        }

        if (wasOutPut) return "file";
        else return "console";
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

    public String getAlgorithm() {
        for (int i = 0; i < args.length; i++)
            if (args[i].equals("-alg"))
                return args[i + 1];
        return "";
    }
}
