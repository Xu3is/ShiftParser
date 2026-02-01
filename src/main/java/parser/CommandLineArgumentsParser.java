package parser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandLineArgumentsParser {
    public static CommandLineArguments parseArguments(String[] args) {
        CommandLineArguments cli = new CommandLineArguments();

        for (int i = 0; i < args.length; i++) {
            String current = args[i];
            cli.setFiles(Paths.get(current));
        }

        if (cli.getInputFiles().isEmpty()) {
            throw new IllegalArgumentException("Вы не указали входные файлы");
        }
        return cli;
    }
}
