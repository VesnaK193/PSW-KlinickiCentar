package controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.models.PretragaKlinikaDTO;
import com.tim3.backendPSW.repository.KlinikaRepository;
import com.tim3.backendPSW.services.KlinikaService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
public class KlinikaControllerUnitTest {

	private MockMvc mockMvc;

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @MockBean
    KlinikaRepository klinikaRepository;
    
	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private KlinikaService klinikaService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();

	}
	
	@Test
	public void testKlinikaSearchSuccessful() throws Exception {
		PretragaKlinikaDTO pretragaKlinika = new PretragaKlinikaDTO(null,null,"gogoljeva",null);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("adresa", "gogoljeva");
		String json = jsonObject.toString();

		Mockito.when(klinikaService.getSearchedKlinike(pretragaKlinika)).thenReturn(new ArrayList<>());
		this.mockMvc.perform(MockMvcRequestBuilders.post("/getSearchedKlinike").content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
