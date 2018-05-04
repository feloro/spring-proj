import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.config.ContextLoader;
import com.myapp.database.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by anton.istomin on 03.05.2018.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextLoader.class)
@WebAppConfiguration
public class ApplicationTest {

  @Autowired
  WebApplicationContext context;

  private MockMvc mvc;
  private ObjectMapper mapper;
  private User testUser;

  @Before
  public void setup() {
    mapper = new ObjectMapper();
    mvc = MockMvcBuilders
        .webAppContextSetup(context)
        //.apply(springSecurity())
        .build();
  }

  @Test
  public void userFunctionsTest() throws Exception {
    createUserTest();
    deleteUserTest();
  }


  private void createUserTest() throws Exception {
    testUser = new User();
    testUser.setEmail("test-email@unit-test.com");
    testUser.setLogin("unit-test");
    testUser.setPassword("test_password");
    MvcResult result = this.mvc.perform(MockMvcRequestBuilders.put("/users")
          .content(mapper.writeValueAsString(testUser))
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    Map response = mapper.readValue(result.getResponse().getContentAsString(), Map.class);
    System.out.print(response);
    testUser.setId (new Long((Integer)response.get("id")));
  }

  private void deleteUserTest() throws Exception {
    MvcResult result = this.mvc.perform(MockMvcRequestBuilders.delete(String.format("/users/%d",testUser.getId())))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    Map response = mapper.readValue(result.getResponse().getContentAsString(), Map.class);
    assertThat(response.get("success"), is(Boolean.TRUE));
  }
}
