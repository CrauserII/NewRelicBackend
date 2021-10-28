package com.example.demo;

import com.example.demo.controller.AppCompanyController;
import com.example.demo.controller.AppUserController;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.model.AppCompany;
import com.example.demo.model.AppUser;
import com.example.demo.service.AppCompanyService;
import com.example.demo.service.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppCompanyControllerTest {
    @InjectMocks
    AppCompanyController appCompanyController;

    @Mock
    AppUserDAO appUserDAO;

    @Mock
    AppCompanyService appCompanyService;

    @Test
    public void getEmployeesTest(){
        // given
        MockHttpServletRequest request = new MockHttpServletRequest();

        AppCompany company = new AppCompany(1, "First1");
        AppCompany company2 = new AppCompany(2, "Second");

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(appCompanyService.getAllCompanies()).thenReturn(Arrays.asList(company, company2));
        // when
        List<AppCompany> result = appCompanyController.getCompanies();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        doNothing().when(appCompanyService).insertCompany(any());


        AppCompany company = new AppCompany(1, "First1");

        appCompanyController.addComapany(company);

    }
}
