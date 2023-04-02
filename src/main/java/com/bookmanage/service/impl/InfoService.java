package com.bookmanage.service.impl;

import com.bookmanage.mapper.InfoMapper;
import com.bookmanage.service.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService implements InfoServiceImpl {
    @Autowired
    InfoMapper infoMapper;


}
