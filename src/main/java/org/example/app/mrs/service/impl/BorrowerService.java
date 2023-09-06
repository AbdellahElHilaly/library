package org.example.app.mrs.service.impl;

import org.example.app.mrs.model.entity.Borrower;
import org.example.app.mrs.repository.BorrowerRepository;
import org.example.app.mrs.service.CrudService;

import java.util.List;

public class BorrowerService implements CrudService<Borrower> {
    private Borrower tempBorrower = new Borrower();
    private final BorrowerRepository borrowerRepository = new BorrowerRepository();


    @Override
    public Borrower save(Borrower borrower) {
        return borrower.mapData(borrowerRepository.save(borrower));
    }

    @Override
    public Borrower select(int id) {
        return null;
    }

    @Override
    public List<Borrower> selectAll() {
        return tempBorrower.mapDataList(borrowerRepository.findAll());
    }

    @Override
    public Borrower update(Borrower borrower, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    public Borrower findByCni(String cni) {

        if (tempBorrower == null) tempBorrower = new Borrower();
        else tempBorrower.initializeObject();

        tempBorrower =  tempBorrower.mapData(borrowerRepository.findBy("cni", cni));
        if (tempBorrower != null) {
            return tempBorrower;
        }
        return null;
    }





}
