package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.models.PretragaKlinikaDTO;
import com.tim3.backendPSW.services.KlinikaService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
public class KlinikaControllerIntegrationTest {

	@Autowired
    private KlinikaService klinikaService;

	@Test
    @Transactional
    public void testKlinikaSearchSuccessful() {
		PretragaKlinikaDTO pretragaKlinka = new PretragaKlinikaDTO(null,null,"Gogoljeva","Klinika");
        List<Klinika> rez = klinikaService.getSearchedKlinike(pretragaKlinka);
        Assert.assertTrue(rez.size() == 1);
    }
	
	@Test
    @Transactional
    public void testKlinikaSearchFail() {
		PretragaKlinikaDTO pretragaKlinka = new PretragaKlinikaDTO(null,null,"Gogoljeva","Klinika");
        List<Klinika> rez = klinikaService.getSearchedKlinike(pretragaKlinka);
        Assert.assertTrue(rez.size() == 10);
    }
}
