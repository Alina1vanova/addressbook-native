package pft.helper;

import java.io.IOException;

/**
 * Created by linka on 08.04.2015.
 */
public class ProcessHelper extends BaseHelper {
    private Process process;

    public ProcessHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void startAppUnderTest() throws IOException {
        String command = manager.getProperty("app.path");
        process = Runtime.getRuntime().exec(command);
    }

    public void stoptAppUnderTest() {
        process.destroy();
    }
}
