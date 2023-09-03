package org.example.app.service.impl;

import org.example.app.model.Borrower;
import org.example.app.repository.BorrowerRepository;
import org.example.app.service.CrudService;

import java.sql.SQLException;
import java.util.List;

public class BorrowerService implements CrudService<Borrower> {
    private final Borrower borrower = new Borrower();
    private final BorrowerRepository borrowerRepository = new BorrowerRepository();


    @Override
    public Borrower save(Borrower borrower) {
        return null;
    }

    @Override
    public Borrower select(int id) {
        return null;
    }

    @Override
    public List<Borrower> selectAll() {
        return null;
    }

    @Override
    public Borrower update(Borrower borrower, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
