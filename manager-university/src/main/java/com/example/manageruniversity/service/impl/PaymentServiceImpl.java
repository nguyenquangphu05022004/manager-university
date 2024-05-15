package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.entity.*;
import com.example.manageruniversity.repository.MajorRegisterRepository;
import com.example.manageruniversity.repository.PaymentRepository;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final RegisterRepository registerRepository;

    @Override
    public void save(String description, String transactionPaymentId, int totalPay) {
        String words[] = description.split("\\s+");
        Student student = new Student();
        student.setId(Long.parseLong(words[0]));
        MajorRegister majorRegister = new MajorRegister();
        majorRegister.setId(Long.parseLong(words[1]));
        List<Register> registers = registerRepository
                .findAllByStudentIdAndMajorRegisterId(student.getId(),
                        majorRegister.getId());
        Integer totalPriceOfStudent = getTuitionOfStudent(registers);
            Payment payment = new Payment(
                    student,
                    majorRegister,
                    description,
                    transactionPaymentId,
                    totalPay,
                    (totalPriceOfStudent == totalPay));
            paymentRepository.save(payment);
    }

    private Integer getTuitionOfStudent(List<Register> registers) {
        int t = 0;
        for(Register r : registers) {
            MajorRegister m = r.getMajorRegister();
            if(m.getTuition() != null) {
                t += r.getSubjectGroup().getSubject().getCredit() * m.getTuition().getMoneyPerCredit();
            }
        }
        return t;
    }
}
