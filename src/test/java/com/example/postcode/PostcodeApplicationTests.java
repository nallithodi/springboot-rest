package com.example.postcode;

import com.example.postcode.dto.PostcodeDTO;
import com.example.postcode.rest.PostcodeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class PostcodeApplicationTests {

    @Mock
    PostcodeController controller;

    @Test
    void testSavePostcodes() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity responseEntity1 = new ResponseEntity(
                HttpStatus.OK
        );
        when(controller.savePostcodes(any(List.class),eq(request))).thenReturn(responseEntity1);

        PostcodeDTO postcodeDTO1 = new PostcodeDTO(2000L, "Sydney");
        ResponseEntity responseEntity = controller.savePostcodes(Arrays.asList(postcodeDTO1),request);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void testFindAllInSortOrder()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        PostcodeDTO postcodeDTO1 = new PostcodeDTO(2000L, "Sydney");
        PostcodeDTO postcodeDTO2 = new PostcodeDTO(2114L, "Ryde");
        ResponseEntity<?> responseEntity1 = new ResponseEntity<>(
                "[Ryde,Sydney]Total characrers: 13",
                HttpStatus.OK
        );
        when(controller.savePostcodes(any(List.class), any(HttpServletRequest.class))).thenReturn(responseEntity1);
        ResponseEntity responseEntity2 = controller.savePostcodes(Arrays.asList(postcodeDTO1,postcodeDTO2),request);
        Assertions.assertThat(responseEntity2.getStatusCode().value()).isEqualTo(200);

        when(controller.getPostcodes(any(Long.class), any(Long.class))).thenReturn(responseEntity1);
        ResponseEntity responseEntity3 = controller.getPostcodes(1000L, 5000L);
        Assertions.assertThat(responseEntity3.getStatusCode().value()).isEqualTo(200);
        Assertions.assertThat(responseEntity3.getBody()).isEqualTo("[Ryde,Sydney]Total characrers: 13");
    }

}
