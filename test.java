//test service
@SpringbootTest

//test controller
@WebMvcTest(value = User.class, exculdAutoConfiguration = SecurityAutoConfiguration.class,exludeFilters={@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = xxx.class)})
@AutoConfigureMockMvc


//test repo
@DataJpaTest



  ==========================

@Captor
ArgumentCaptor<Email> emailCaptor;

@Test
void whenDoesSupportHtml_expectHTMLEmailFormat() {
    String to = "info@baeldung.com";
    String subject = "Using ArgumentCaptor";
    String body = "Hey, let'use ArgumentCaptor";

    emailService.send(to, subject, body, true);

  
    // ArgumentCaptor<Email> emailCaptor = ArgumentCaptor.forClass(Email.class);   //同@Captor
    verify(platform).deliver(emailCaptor.capture());
    Email value = emailCaptor.getValue();
    assertThat(value.getFormat()).isEqualTo(Format.HTML);
}

=========================

  @Mock
  HttpSession sesseion;

  @Mock
  HttpServletRequest request;

  Mockito.when(request.getSession()).thenReturn(sesseion);
  Mockito.when(session.getAttribute("test")).thenReturn("test01")
  
