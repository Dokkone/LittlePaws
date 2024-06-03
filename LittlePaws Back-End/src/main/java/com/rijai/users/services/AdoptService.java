package com.rijai.users.services;

import com.rijai.users.model.Adopt;
import com.rijai.users.repository.AdoptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptService implements IAdoptService {

    @Autowired
    private AdoptRepository AdoptRepository;

    public Adopt addMessage(Adopt adopt)
    {
        return AdoptRepository.save(adopt);
    }

}
