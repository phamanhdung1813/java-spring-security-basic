package com.anhdungpham.services.imp;

import com.anhdungpham.entities.AEntity;
import com.anhdungpham.entities.BEntity;

public interface IDBService {
    AEntity saveA(AEntity aname);
    BEntity saveB(BEntity bname);

    void addBtoA(String aname, String bname);
}
