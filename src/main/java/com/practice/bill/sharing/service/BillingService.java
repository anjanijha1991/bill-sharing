package com.practice.bill.sharing.service;

import com.practice.bill.sharing.entity.Contributors;

import java.util.List;
import java.util.Map;

public interface BillingService {

    void addBill(String billId, String groupId, Integer amount, String paidBy, List<Contributors> contributors);

    Map<String, Integer> getUserAmount(String emailId);
}
