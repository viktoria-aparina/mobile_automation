package pm.academy.configuration.capabilities;

import org.aeonbits.owner.ConfigCache;
import pm.academy.configuration.TestData;

public final class TestDataReader {

    private TestDataReader() {
    }

    public static TestData get() {
        return ConfigCache.getOrCreate(TestData.class, System.getProperties());
    }
}
