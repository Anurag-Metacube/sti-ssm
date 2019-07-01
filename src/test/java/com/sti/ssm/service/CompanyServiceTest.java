package com.sti.ssm.service;

import com.sti.ssm.dao.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

    @InjectMocks
    CompanyService companyService;

    @Mock
    CompanyDao companyDao;

    @Test
    public void addCompany() {
        companyService.addCompany(any());
        verify(companyDao, times(1)).addCompany(any());
    }
}