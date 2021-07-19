package ro.iss.guruclinic.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.HashSet;
import java.util.Set;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.iss.guruclinic.model.Owner;
import ro.iss.guruclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

  @Mock private OwnerService ownerService;

  @InjectMocks private OwnerController controller;

  private Set<Owner> owners;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() throws Exception {
    owners = new HashSet<>();
    owners.add(Owner.builder().id(1l).build());
    owners.add(Owner.builder().id(2l).build());

    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void testListOwners() throws Exception {
    Mockito.when(ownerService.findAll()).thenReturn(owners);
    mockMvc
        .perform(get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", Matchers.hasSize(2)));
  }

  @Test
  void testListOwnersByIndex() throws Exception {
    Mockito.when(ownerService.findAll()).thenReturn(owners);
    mockMvc
        .perform(get("/owners/index"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", Matchers.hasSize(2)));
  }

  @Test
  void testFindOwners() throws Exception {
    mockMvc.perform(get("/owners/find")).andExpect(view().name("notImplemented"));
    Mockito.verifyNoInteractions(ownerService);
  }
}
