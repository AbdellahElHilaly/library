package org.example.app.mrs.repository;

import org.example.app.mrs.model.entity.Borrower;
import org.example.dao.ORM.BaseRepository;

public class BorrowerRepository extends BaseRepository<Borrower> {


    public BorrowerRepository() {
        super(Borrower.class);
    }



}
