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
    public Borrower save(Borrower borrower) throws SQLException {
        return borrower.mapData(borrowerRepository.save(borrower));
    }

    @Override
    public Borrower select(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Borrower> selectAll() throws SQLException {
        return null;
    }

    @Override
    public Borrower update(Borrower borrower, int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

}
