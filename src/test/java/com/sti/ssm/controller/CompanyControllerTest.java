package com.sti.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sti.ssm.dao.CompanyDao;
import com.sti.ssm.models.Address;
import com.sti.ssm.models.CompanyContact;
import com.sti.ssm.models.CompanyDetails;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyControllerTest {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @MockBean
    CompanyDao companyDao;

    private ObjectMapper objectMapper;

    private List<CompanyDetails> companyDetailsList;

    @Before
    public void setUp() {
        this.objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                .build();
        createMockCompanyList();
    }

    private void createMockCompanyList() {
        companyDetailsList = new ArrayList<>();
        Address a1 = new Address(1, "Address Line 1", "Address Line 1", "Address Line 3", "City Name", "State Name", "Country Name", "123456");
        CompanyDetails c1 = new CompanyDetails();
        c1.setId(1);
        c1.setCompanyName("Test Company 1");
        c1.setAbbreviation("TC1");
        c1.setBillingAddress(a1);
        c1.setDetails(a1);
        c1.setCompanyContact(new CompanyContact());
        companyDetailsList.add(c1);
        CompanyDetails c2 = new CompanyDetails();
        c2.setId(1);
        c2.setCompanyName("Test Company 2");
        c2.setAbbreviation("TC2");
        c2.setBillingAddress(a1);
        c2.setDetails(a1);
        c2.setCompanyContact(new CompanyContact());
        companyDetailsList.add(c2);
    }

    @Test
    public void getCompanyById() throws Exception {
        when(companyDao.getCompany(anyInt())).thenReturn(companyDetailsList.get(0));
        this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/company/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(document("company/get-by-id"));
    }

    @Test
    public void getAllCompanies() throws Exception {
        when(companyDao.getAllCompanies()).thenReturn(companyDetailsList);
        this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/companys"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(document("company/get-all-companies"));
    }

    @Test
    public void addCompany() throws Exception {
        this.mockMvc.perform(
            RestDocumentationRequestBuilders.post("/company/add")
                  .contentType(MediaType.APPLICATION_JSON_UTF8)
                  .content(this.objectMapper.writeValueAsString(companyDetailsList.get(0))))
            .andExpect(status().isOk())
            .andDo(document("company/add-company"));
    }
}