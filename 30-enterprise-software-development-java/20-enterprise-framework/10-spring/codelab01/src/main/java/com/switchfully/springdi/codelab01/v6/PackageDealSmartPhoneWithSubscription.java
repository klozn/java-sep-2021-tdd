package com.switchfully.springdi.codelab01.v6;

import org.springframework.beans.factory.annotation.Autowired;

public class PackageDealSmartPhoneWithSubscription {
    private Smartphone phone;
    private PhoneSubscription subscription;

    public PackageDealSmartPhoneWithSubscription(Smartphone phone, PhoneSubscription subscription){
        this.phone = phone;
        this.subscription = subscription;
    }

    public String getDealInfo() {
        return "--------------------\n" +
                phone.toString() + "\n" +
                subscription.toString() + "\n" +
                "--------------------";
    }
}
