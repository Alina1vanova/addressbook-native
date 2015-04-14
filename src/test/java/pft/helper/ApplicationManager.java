package pft.helper;

import java.io.IOException;
import java.util.Properties;

import static pft.config.Constants.*;

public class ApplicationManager {
    private static ApplicationManager singleton;
    private Properties properties;
    private ContactHelper contactHelper;
    private ProcessHelper processHelper;
    private AutoItHelper autoItHelper;

    public static ApplicationManager getInstance(Properties properties) {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(properties);
            singleton.start();
        }
        return singleton;
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public AutoItHelper getAutoItHelper() {
        if (autoItHelper == null) {
            autoItHelper = new AutoItHelper(this);
        }
        return autoItHelper;
    }

    public ProcessHelper getProcessHelper() {
        if (processHelper == null) {
            processHelper = new ProcessHelper(this);
        }
        return processHelper;
    }

    public void start() {
        try {
            getProcessHelper().startAppUnderTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        getAutoItHelper().click(EXIT_BUTTON);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defualtValue) {
        return properties.getProperty(key, defualtValue);
    }
}

