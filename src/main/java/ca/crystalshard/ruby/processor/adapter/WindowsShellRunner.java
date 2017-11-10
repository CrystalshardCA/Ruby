package ca.crystalshard.ruby.processor.adapter;

import ca.crystalshard.ruby.processor.adapter.io.ProcessWrapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WindowsShellRunner implements ca.crystalshard.ruby.processor.domain.ShellRunner {

    public WindowsShellRunner() {
    }

    @Override
    public String run(String workingDirectory, String command) {
        String output = "";
        File scriptFile = createFile(workingDirectory + "//script.cmd", command);

        ProcessWrapper processWrapper = new ProcessWrapper(workingDirectory);

        try {
            processWrapper.run();
            output = processWrapper.getOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scriptFile.delete();
        return output;
    }

    private File createFile(String location, String content) {
        File script = new File(location);
        try {
            FileWriter fileWriter = new FileWriter(script, false);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return script;
    }

}
