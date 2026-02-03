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
                cli.SetFullStat();
                cli.SetStatistic(new Statistics());
            } else if (current.equals("-p")) {
                if (i + 1 >= args.length) {
                    throw new IllegalArgumentException("Вы не указали префикс");
                }
                cli.setPrefix(args[i + 1]);
                i++;
            } else if (current.startsWith("-o")) {
                if (i + 1 >= args.length) {
                    throw new IllegalArgumentException("Для -o нужен путь");
                }
                cli.setOutputPath(Paths.get(args[i + 1]));
                i++;
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
