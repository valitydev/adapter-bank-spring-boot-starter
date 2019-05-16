package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import com.rbkmoney.adapter.bank.spring.boot.starter.exception.UnknownTargetStatusException;
import com.rbkmoney.damsel.domain.TargetInvoicePaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class TargetStatusResolver {

    public TargetStatus resolve(TargetInvoicePaymentStatus target) {
        if (target != null) {
            if (target.isSetCaptured()) {
                return TargetStatus.CAPTURED;
            } else if (target.isSetProcessed()) {
                return TargetStatus.PROCESSED;
            } else if (target.isSetRefunded()) {
                return TargetStatus.REFUNDED;
            } else if (target.isSetCancelled()) {
                return TargetStatus.CANCELLED;
            }
        }
        throw new UnknownTargetStatusException();
    }

}
