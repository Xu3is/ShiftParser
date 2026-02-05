package parser;

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
                    System.out.println("Для опции -p нужен префикс, опция игнорируется");
                    continue;
                }
                String prefixParse = args[i + 1];
                if (prefixParse.startsWith("-")) {
                    System.out.println("После опции -p должен идти префикс, опция игнорируется");
                    continue;
                }
                if (prefixParse.trim().isEmpty()) {
                    System.out.println("Префикс пустой, опция -p игнорируется");
                    continue;
                }
                if (prefixParse.toLowerCase().endsWith(".txt")) {
                    System.out.println("Префикс не может быть файлом, опция -p игнорируется");
                    continue;
                }
                cli.setPrefix(prefixParse);
                i++;
            } else if (current.startsWith("-o")) {
                if (i + 1 >= args.length) {
                    System.out.println("Для опции -o нужен путь, опция игнориуется, файлы созданы в рабочей папке");
                    continue;
                }
                String pathParse = args[i + 1];
                if (pathParse.startsWith("-")) {
                    System.out.println("После опции -о должен идти путь, опция игнориуется, файлы созданы в рабочей папке");
                    continue;
                }
                if (pathParse.trim().isEmpty()) {
                    System.out.println("Путь пустой, -o опция игнориуется, файлы созданы в рабочей папке");
                    continue;
                }
                if (pathParse.toLowerCase().endsWith(".txt")) {
                    System.out.println("Путь не может быть файлом, опция -о игнорируется, файлы созданы в рабочей папке");
                    continue;
                }
                cli.setOutputPath(Paths.get(pathParse));
                i++;
            } else if (current.equals("-a")){
                cli.setAppendable();
            } else if (current.startsWith("-")) {
                System.out.println("Опции " + current + " не существует, неизвестная опция пропущена");
                continue;
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
