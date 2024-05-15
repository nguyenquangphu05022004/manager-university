package com.example.manageruniversity.payment;

import com.example.manageruniversity.service.IPaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaymentController {

    private final VNPayService vnPayService;
    private final IPaymentService paymentService;
    @Value("${vnPay.urlReturn}")
    private String urlFrontEndPage;


    @PostMapping("/api/v1/payment")
    @ResponseBody
    public String submitOrder(@RequestParam("amount") int orderTotal,
                            @RequestParam("orderInfo") String orderInfo,
                            HttpServletRequest request){
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
        return vnpayUrl;
    }

    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request){
        int paymentStatus =vnPayService.orderReturn(request);
        String urlRedirect = urlFrontEndPage + "?status=";
        if(paymentStatus == 1) {
            String description = request.getParameter("vnp_OrderInfo");
            String transactionId = request.getParameter("vnp_TransactionNo");
            String totalPrice = request.getParameter("vnp_Amount");
            paymentService.save(description, transactionId, Integer.parseInt(totalPrice)/100);
            urlRedirect += "Success";
        } else {
            urlRedirect += "Fail";
        }
        return "redirect:" + urlRedirect;
    }
}
