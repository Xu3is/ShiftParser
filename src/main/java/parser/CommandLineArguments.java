package parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommandLineArguments {

    private  final List<Path> inputFiles = new ArrayList<>();
    private  Path outputPath = Paths.get(".");
    private  String prefix = "";
    private  boolean appendable = false;
    private  boolean shortStat = false;
    private  boolean fullStat = false;

    public void setFiles(Path file) {
        inputFiles.add(file);
    }


    public List<Path> getInputFiles() {
        return inputFiles;
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
    public boolean isLongStat() {return fullStat;}
}
