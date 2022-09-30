package com.technical.service;

import com.technical.repository.LentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LentDetailServiceImpl implements LentDetailService{

    @Autowired
    private LentDetailRepository lentDetailRepository;
}
