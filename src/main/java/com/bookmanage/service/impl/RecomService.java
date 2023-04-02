package com.bookmanage.service.impl;

import com.bookmanage.mapper.RecomMapper;
import com.bookmanage.service.RecomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecomService implements RecomServiceImpl {
    @Autowired
    RecomMapper recomMapper;


}
