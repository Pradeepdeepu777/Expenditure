package com.ganeshchaturthi.expenditure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin(origins = "https://vinakayaexpenditure.web.app/")
public class ExpenditureService {

    @Autowired
    ExpenditureRepository repo;

    public List<Expenditure> getAll(){
        return (List)(repo.findAll());
    }
    public Optional<Expenditure> getById(Integer Id){
        return repo.findById(Id);
    }

    public void newExpenditure(Expenditure expenditure){
        repo.save(expenditure);

    }

    void updateExpenditure( Expenditure expenditure){
        repo.save(expenditure);

    }

}
