package parser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandLineArgumentsParser {
    public static CommandLineArguments parseArguments(String[] args) {
        CommandLineArguments cli = new CommandLineArguments();

        for (int i = 0; i < args.length; i++) {
            String current = args[i];

            if (current.equals("-s")) {
                cli.SetShortStat();
                cli.SetStatistic(new Statistics());
            } else if (current.equals("-f")) {
                cli.SetfullStat();
                cli.SetStatistic(new Statistics());
            } else {
                cli.setFiles(Paths.get(current));

            }
        }

        if (cli.getInputFiles().isEmpty()) {
            throw new IllegalArgumentException("Вы не указали входные файлы");
        }
        return cli;
    }
}
