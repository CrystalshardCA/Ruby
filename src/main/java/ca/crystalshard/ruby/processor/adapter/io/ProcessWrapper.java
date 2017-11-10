package ca.crystalshard.ruby.processor.adapter.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessWrapper {

    private ProcessBuilder builder;
    private String output;

    public ProcessWrapper (String workingDirectory) {
        this.builder =  new ProcessBuilder();
        builder.directory(new File(workingDirectory));
        builder.redirectErrorStream(true);
    }

    public void run() throws IOException {
        this.builder.command("cmd.exe", "/c", "script.cmd");
        Process process = this.builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while (true) {
            line = reader.readLine();
            if (line == null) { break; }
            output.append(line).append("\n");
        }
        this.output = output.toString();
    }

    public String getOutput() {
        return output;
    }
}

