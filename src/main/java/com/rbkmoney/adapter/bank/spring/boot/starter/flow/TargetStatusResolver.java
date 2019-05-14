package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import com.rbkmoney.damsel.domain.TargetInvoicePaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class TargetStatusResolver {

    public TargetStatus resolve(TargetInvoicePaymentStatus target) {
        TargetStatus targetStatus= null;
        if (target.isSetCaptured()) {
            targetStatus = TargetStatus.CAPTURED;
        } else if (target.isSetProcessed() ) {
            targetStatus = TargetStatus.PROCESSED;
        } else if (target.isSetRefunded()) {
            targetStatus = TargetStatus.REFUNDED;
        } else if (target.isSetCancelled()) {
            targetStatus =  TargetStatus.CANCELLED;
        }
        return targetStatus;
    }

}
