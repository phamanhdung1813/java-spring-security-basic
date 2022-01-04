package com.anhdungpham.services;

import com.anhdungpham.entities.AEntity;
import com.anhdungpham.entities.BEntity;
import com.anhdungpham.repositories.ARepository;
import com.anhdungpham.repositories.BRepository;
import com.anhdungpham.services.imp.IDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DBService implements IDBService {
    private final ARepository aRepository;
    private final BRepository bRepository;

    @Override
    public AEntity saveA(AEntity aname) {
        return aRepository.save(aname);
    }

    @Override
    public BEntity saveB(BEntity bname) {
        return bRepository.save(bname);
    }

    @Override
    public void addBtoA(String aname, String bname) {
        AEntity a = aRepository.findByAName(aname);
        BEntity b = bRepository.findByBName(bname);
        a.getBEntityList().add(b);
    }
}
