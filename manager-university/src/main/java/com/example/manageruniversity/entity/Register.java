package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registers")
@Getter
@Data
public class Register extends Base{
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
    @OneToOne(mappedBy = "register")
    private Grade grade;
    @OneToMany(mappedBy = "targetRegister")
    private List<Transaction> transactions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "major_register_id")
    private MajorRegister majorRegister;
    private boolean openTransaction;

    @Transient
    public List<Register> getRegisterListRequestFromStudent() {
        List<Register> registers = new ArrayList<>();
        for(Transaction transaction: transactions) {
            for(Register register: transaction.getStudent().getRegisters()) {
                if(this.subjectGroup.getSubject().
                        equals(register.getSubjectGroup().getSubject())) {
                    registers.add(register);
                }
            }
        }
        return registers;
    }

}
