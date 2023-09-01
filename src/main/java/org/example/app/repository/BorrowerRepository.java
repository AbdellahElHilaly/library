package org.example.app.repository;

import org.example.app.model.Borrower;
import org.example.dao.ORM.BaseRepository;

public class BorrowerRepository extends BaseRepository<Borrower> {


    public BorrowerRepository() {
        super(Borrower.class);
    }


}
