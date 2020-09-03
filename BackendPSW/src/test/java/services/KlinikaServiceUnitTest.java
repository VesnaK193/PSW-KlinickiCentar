package services;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.repository.KlinikaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
public class KlinikaServiceUnitTest {

	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    KlinikaRepository klinikaRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();

    }
    
    @Test
	public void testFindAll() {
		List<Klinika> students = klinikaRepository.findAll();
		assertThat(students).hasSize(4);
	}
    
    @Test
    public void testFindClinicsSuccessfull() throws Exception {
        Klinika k = new Klinika();
        Klinika k1 = new Klinika();
        Klinika k2 = new Klinika();
        Klinika k3 = new Klinika();
        
        List<Klinika> kli = new ArrayList<Klinika>();
        kli.add(k);
        kli.add(k1);
        kli.add(k2);
        kli.add(k3);
        
        Mockito.when(klinikaRepository.findAll()).thenReturn(kli);
        List<Klinika> klinike = klinikaRepository.findAll();
        assertThat(klinike.size()).isEqualTo(kli.size());

    }

}
