package parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommandLineArguments {

    private final List<Path> inputFiles = new ArrayList<>();
    private Path outputPath = Paths.get(".");
    private String prefix = "";
    private boolean appendable = false;
    private boolean shortStat = false;
    private boolean fullStat = false;
    private Statistics statistic = null;

    public Statistics getStatistic() {
        return statistic;
    }

    public Statistics SetStatistic(Statistics statistic) {
        return this.statistic = statistic;
    }

    public void setFiles(Path file) {
        inputFiles.add(file);
    }

    public List<Path> getInputFiles() {
        return inputFiles;
    }

    public void SetShortStat() {
        shortStat = true;
    }
    public void SetFullStat() {
        fullStat = true;
    }

    public Path getOutputPath() {
        return outputPath;
    }
    public void setOutputPath(Path path) {
        this.outputPath = path;
    }

    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isAppendable() {
        return appendable;
    }

    public boolean isShortStat() {
        return shortStat;
    }
    public boolean isFullStat() {return fullStat;
    }
}
