package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.Step;
import org.junit.Assert;
import org.junit.Test;

public class DefaultStepResolverImplTest {

    DefaultStepResolverImpl defaultStepResolver = new DefaultStepResolverImpl();

    @Test
    public void resolveEntry() {
        EntryStateModel entryStateModel = EntryStateModel.builder().
                targetStatus(TargetStatus.CANCELLED)
                .build();
        Step step = defaultStepResolver.resolveEntry(entryStateModel);
        Assert.assertEquals(Step.CANCEL, step);

        entryStateModel.setTargetStatus(TargetStatus.CAPTURED);
        step = defaultStepResolver.resolveEntry(entryStateModel);
        Assert.assertEquals(Step.CAPTURE, step);

        entryStateModel.setTargetStatus(TargetStatus.PROCESSED);
        step = defaultStepResolver.resolveEntry(entryStateModel);
        Assert.assertEquals(Step.AUTH, step);

        entryStateModel.setTargetStatus(TargetStatus.AUTH_RECURRENT);
        step = defaultStepResolver.resolveEntry(entryStateModel);
        Assert.assertEquals(Step.AUTH_RECURRENT, step);

        entryStateModel.setTargetStatus(TargetStatus.REFUNDED);
        step = defaultStepResolver.resolveEntry(entryStateModel);
        Assert.assertEquals(Step.REFUND, step);
    }

    @Test
    public void resolveExit() {
        EntryStateModel entryStateModel = EntryStateModel.builder()
                .step(Step.AUTH)
                .build();
        ExitStateModel exitStateModel = ExitStateModel.builder()
                .entryStateModel(entryStateModel)
                .nextStep(Step.FINISH_THREE_DS)
                .build();
        Step step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.FINISH_THREE_DS, step);

        entryStateModel.setStep(Step.AUTH_RECURRENT);
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_FINISH_THREE_DS, step);

        exitStateModel.setNextStep(Step.GENERATE_TOKEN_CAPTURE);
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_CAPTURE, step);

        entryStateModel.setStep(Step.GENERATE_TOKEN_FINISH_THREE_DS);
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_CAPTURE, step);

        entryStateModel.setStep(Step.GENERATE_TOKEN_CAPTURE);
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_REFUND, step);

        entryStateModel.setStep(Step.GENERATE_TOKEN_REFUND);
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_FINISH, step);
    }
}