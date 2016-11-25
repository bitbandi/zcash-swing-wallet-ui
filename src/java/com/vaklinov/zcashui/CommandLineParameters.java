package com.vaklinov.zcashui;

import org.apache.commons.cli.*;

public class CommandLineParameters {

    static private Options options = new Options();
    static private CommandLine cmd;

    static public void parse(String argv[]) throws ParseException {

        options.addOption("h", "help", false, "display help");
        options.addOption("datadir", true, "data directory");

        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse( options, argv);
    }

    static public boolean isHelp()
    {
        return cmd.hasOption("h");
    }

    static public void displayHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ZCashSwingWalletUI", options, true );
    }

    static public String getDataDir() {
        return cmd.getOptionValue("datadir", null);
    }
}
