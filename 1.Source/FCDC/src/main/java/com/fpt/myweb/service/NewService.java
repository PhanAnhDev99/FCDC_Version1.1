package com.fpt.myweb.service;

import com.fpt.myweb.dto.request.NewRequet;
import com.fpt.myweb.entity.New;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface NewService {

    public New addNew(NewRequet newRequet,MultipartFile file) throws IOException, ParseException;

    public New editNew(NewRequet newRequet, MultipartFile file) throws IOException, ParseException;

    public void deleteNew(Integer id);

    public List<NewRequet> getNew(Integer page);


    public List<NewRequet> getAllNew();
}
