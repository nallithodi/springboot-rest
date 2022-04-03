package com.example.postcode.rest;

import com.example.postcode.dto.PostcodeDTO;
import com.example.postcode.entity.Postcode;
import com.example.postcode.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostcodeController {

    @Autowired
    PostcodeService postcodeService;

    @PostMapping("/postcodes")
    public ResponseEntity savePostcodes(@RequestBody List<PostcodeDTO> postcodeList,
                              HttpServletRequest httpRequest) {
        postcodeService.savePostcodes(postcodeList);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/postcodes")
    public ResponseEntity getPostcodes(Long from, Long to){
        if(from != null & to != null) {
            List<PostcodeDTO> postcodeList = postcodeService.getPostcodes(from, to);
            List<String> nameList = postcodeList.stream()
                    .map(PostcodeDTO::getName).sorted()
                    .collect(Collectors.toList());
            ResponseEntity response = new ResponseEntity(nameList+"\n Total characrers: "+nameList.toString().length(), HttpStatus.OK);
            return response;
        } else {
            return new ResponseEntity("Invalid Request Param", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
