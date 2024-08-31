package com.ganeshchaturthi.expenditure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@CrossOrigin(origins = {"https://vinakayaexpenditure.web.app/", "https://vinakayaexpenditure.firebaseapp.com/"})
@RestController
@RequestMapping("/expenditure/v1.0/apis")
public class ExpenditureController {
    @Autowired
    ExpenditureService service;

    @GetMapping("/all")
    public List<Expenditure> getAll() {
        return service.getAll();
    }
    @GetMapping("/all/{Id}")
    public Optional<Expenditure> getById(@PathVariable Integer Id) {
        return service.getById(Id);
    }


    @PostMapping("/new")
    public void newExpenditure(@RequestBody Expenditure expenditure) {
        service.newExpenditure(expenditure);
    }

    @PutMapping("update/{Id}")
    public void update(@RequestBody Expenditure expenditure,@PathVariable Integer Id) {
        expenditure.setId(Id);
        service.newExpenditure(expenditure);
    }
    
    

}
