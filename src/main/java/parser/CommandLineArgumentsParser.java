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
                    System.out.println("Для утилинты -p нужен префикс, опция -p игнорируется");
                    continue;
                }
                String next = args[i + 1];
                if (next.startsWith("-")) {
                    System.out.println("После опции -p должен идти префикс, опция игнорируется");
                    continue;
                }
                if (next.trim().isEmpty()) {
                    System.out.println("Префикс пустой, опция -p игнорируется");
                    continue;
                }
                if (next.toLowerCase().endsWith(".txt")) {
                    System.out.println("Префикс не может быть файлом, опиция -p игнорируется");
                    continue;
                }
                cli.setPrefix(next);
                i++;
            } else if (current.startsWith("-o")) {
                if (i + 1 >= args.length) {
                    throw new IllegalArgumentException("Для -o нужен путь");
                }
                cli.setOutputPath(Paths.get(args[i + 1]));
                i++;
            } else if (current.equals("-a")){
                cli.setAppendable();
            } else {
                cli.setFiles(Paths.get(current));
            }
        }
        if (cli.getInputFiles().isEmpty()) {
            System.out.println("Вы не указали входные файлы, программа отработать не сможет");
            System.exit(1);
        }
        return cli;
    }
}
