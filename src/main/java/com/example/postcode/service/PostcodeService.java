package com.example.postcode.service;

import com.example.postcode.dto.PostcodeDTO;
import com.example.postcode.entity.Postcode;
import com.example.postcode.repository.PostcodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostcodeService {

    @Autowired
    private PostcodeRepository postcodeRepository;

    private ModelMapper mapper = new ModelMapper();

    public void savePostcodes(List<PostcodeDTO> postcodeDTOList) {
        List<Postcode> postCodeList = postcodeDTOList.stream()
                .map(postcode -> mapper.map(postcode, Postcode.class))
                .collect(Collectors.toList());
        postcodeRepository.saveAll(postCodeList);
    }

    public List<PostcodeDTO> getPostcodes(Long from, Long to) {
        List<Postcode> postcodeList = postcodeRepository.findAllByCodeBetween(from, to);
        List<PostcodeDTO> postCodeDTOList = postcodeList.stream()
                .map(postcode -> mapper.map(postcode, PostcodeDTO.class))
                .collect(Collectors.toList());
        return postCodeDTOList;
    }

}
