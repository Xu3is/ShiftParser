package parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ComandLineArguments {

    private final List<Path> inputFiles = new ArrayList<>();
    private final Path outputPath = Paths.get(".");
    private final String prefix = "";
    private final boolean appendable = false;
    private final boolean shortStat = false;
    private final boolean longStat = false;

    public List<Path> getInputFiles() {
        return inputFiles;
    }
    public void setFiles(Path file) {
        inputFiles.add(file);
    }
    public Path getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppendable() {
        return appendable;
    }
    public boolean isShortStat() {
        return shortStat;
    }

    public boolean isLongStat() {
        return longStat;
    }
}
