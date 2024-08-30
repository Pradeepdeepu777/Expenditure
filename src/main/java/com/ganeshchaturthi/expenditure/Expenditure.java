package com.ganeshchaturthi.expenditure;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expenditureType;
    private String description;

    @CreationTimestamp
    private Timestamp date;
    
    private Long price;
}
