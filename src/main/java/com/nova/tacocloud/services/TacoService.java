package com.nova.tacocloud.services;

import com.nova.tacocloud.dao.TacoRepository;
import com.nova.tacocloud.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TacoService {

    @Autowired
    private TacoRepository tacoRepo;

    public void save(Taco taco){
        tacoRepo.save(taco);
    }
}
