package services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.repository.KlinikaRepository;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class KlinikaServiceIntegrationTest {
	
	@Autowired
    KlinikaRepository klinikaRepository;
	
	@Test
    public void testGetAllKlinikaSuccessful() {
        List<Klinika> klinike = klinikaRepository.findAll();
        Assert.assertTrue(klinike.size() == 4);
    }
	
	@Test
    public void testGetClinicFail() {
        Optional<Klinika> c = klinikaRepository.findById(11L);
        Assert.assertFalse(c.isPresent());
    }
	
	@Test
    public void testGetKlinikaSuccessful() {
        Optional<Klinika> klinika = klinikaRepository.findById(1L);
        Assert.assertTrue(klinika.isPresent());
    }

}
