package com.example.demo;

import com.example.demo.controller.AppUserController;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.model.AppUser;
import com.example.demo.service.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
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
public class AppUserControllerTest {
    @InjectMocks
    AppUserController appUserController;

    @Mock
    AppUserDAO appUserDAO;

    @Mock
    AppUserService userService;

    @Test
    public void getEmployeesTest(){
        // given
        MockHttpServletRequest request = new MockHttpServletRequest();

        AppUser employee1 = new AppUser(1, "First1", "Last1", 1,"1");
        AppUser employee2 = new AppUser(2, "First2", "Last2", 2,"2");

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(userService.getAllUsers(any(),any(),any(),any())).thenReturn(Arrays.asList(employee1, employee2));
        // when
        List<AppUser> result = appUserController.getEmployees(0,"","","");

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        doNothing().when(userService).insertUser(any());

        AppUser employee1 = new AppUser(1, "First1", "Last1", 1,"1");

        appUserController.addUser(employee1);

    }
}
