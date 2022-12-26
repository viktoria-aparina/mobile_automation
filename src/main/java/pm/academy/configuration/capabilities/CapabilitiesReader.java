package pm.academy.configuration.capabilities;

import org.aeonbits.owner.ConfigCache;
import pm.academy.configuration.types.RunType;
import pm.academy.device.DeviceType;

import java.util.Map;

public final class CapabilitiesReader {

    private static final String DEVICE_TYPE_KEY = "deviceType";
    private static final String RUN_TYPE_KEY = "runType";

    private CapabilitiesReader() {
    }

    public static Capabilities get(DeviceType deviceType, RunType runType) {
        return ConfigCache.getOrCreate(Capabilities.class, System.getProperties(),
                Map.of(DEVICE_TYPE_KEY, deviceType.toString(), RUN_TYPE_KEY, runType.toString()));
    }

    public static Capabilities get() {
        return ConfigCache.getOrCreate(Capabilities.class, System.getProperties());
    }
}
