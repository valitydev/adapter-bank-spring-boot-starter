package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.StateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.Step;
import org.junit.Assert;
import org.junit.Test;

public class DefaultStepResolverImplTest {

    private DefaultStepResolverImpl defaultStepResolver = new DefaultStepResolverImpl();

    @Test
    public void resolveEntry() {
        StateModel stateModel = StateModel.builder()
                .targetStatus(TargetStatus.CANCELLED)
                .build();
        Step step = defaultStepResolver.resolveEntry(stateModel);
        Assert.assertEquals(Step.CANCEL, step);

        stateModel.setTargetStatus(TargetStatus.CAPTURED);
        step = defaultStepResolver.resolveEntry(stateModel);
        Assert.assertEquals(Step.CAPTURE, step);

        stateModel.setTargetStatus(TargetStatus.PROCESSED);
        step = defaultStepResolver.resolveEntry(stateModel);
        Assert.assertEquals(Step.AUTH, step);

        stateModel.setTargetStatus(TargetStatus.AUTH_RECURRENT);
        step = defaultStepResolver.resolveEntry(stateModel);
        Assert.assertEquals(Step.AUTH_RECURRENT, step);

        stateModel.setTargetStatus(TargetStatus.REFUNDED);
        step = defaultStepResolver.resolveEntry(stateModel);
        Assert.assertEquals(Step.REFUND, step);
    }

    @Test
    public void resolveExit() {
        EntryStateModel entryStateModel = EntryStateModel.builder()
                .stateModel(StateModel.builder()
                        .step(Step.AUTH)
                        .build())
                .build();
        ExitStateModel exitStateModel = ExitStateModel.builder()
                .entryStateModel(entryStateModel)
                .nextStep(Step.FINISH_THREE_DS)
                .build();
        Step step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.FINISH_THREE_DS, step);

        entryStateModel.setStateModel(StateModel.builder()
                .step(Step.AUTH_RECURRENT).build());
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_FINISH_THREE_DS, step);

        exitStateModel.setNextStep(Step.GENERATE_TOKEN_CAPTURE);
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_CAPTURE, step);

        entryStateModel.setStateModel(StateModel.builder()
                .step(Step.GENERATE_TOKEN_FINISH_THREE_DS).build());
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_CAPTURE, step);

        entryStateModel.setStateModel(StateModel.builder()
                .step(Step.GENERATE_TOKEN_CAPTURE).build());
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_REFUND, step);

        entryStateModel.setStateModel(StateModel.builder()
                .step(Step.GENERATE_TOKEN_REFUND).build());
        step = defaultStepResolver.resolveExit(exitStateModel);
        Assert.assertEquals(Step.GENERATE_TOKEN_FINISH, step);
    }

}