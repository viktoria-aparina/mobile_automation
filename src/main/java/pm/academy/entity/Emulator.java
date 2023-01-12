package pm.academy.entity;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pm.academy.configuration.capabilities.CapabilitiesReader;

import java.io.IOException;

import static java.lang.String.format;
import static pm.academy.configuration.types.RunType.LOCAL;
import static pm.academy.device.DeviceType.ANDROID;

@Log4j2
public class Emulator {

    private static final String KILL_AVD = "adb -s %s emu kill";

    private final String udid;

    public Emulator(String udid) {
        this.udid = udid == null ? CapabilitiesReader.get(ANDROID, LOCAL).udid() : udid;
    }

    public void close() {
        try {
            Runtime.getRuntime().exec(format(KILL_AVD, udid));
            log.info("AVD '{}' is closed", udid);
        } catch (IOException e) {
            log.info("AVD '{}' was not closed", udid, e);
        }
    }
}