import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controllers.KlinikaControllerIntegrationTest;
import controllers.KlinikaControllerUnitTest;
import services.KlinikaServiceIntegrationTest;
import services.KlinikaServiceUnitTest;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        KlinikaServiceUnitTest.class,
        KlinikaControllerUnitTest.class,
        KlinikaServiceIntegrationTest.class,
        KlinikaControllerIntegrationTest.class,
})
public class KlinikaSuite {

}
