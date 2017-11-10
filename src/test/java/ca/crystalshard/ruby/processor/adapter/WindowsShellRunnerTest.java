package ca.crystalshard.ruby.processor.adapter;

import org.junit.Before;
import org.junit.Test;

public class WindowsShellRunnerTest {

    private WindowsShellRunner windowsShellRunner;

    @Before
    public void setUp() {
        windowsShellRunner = new WindowsShellRunner();
    }

    @Test
    public void run_should() {
        System.out.print(windowsShellRunner.run("C:\\Test", "copy test.cmd test1.cmd\ntest1.cmd"));
    }

}