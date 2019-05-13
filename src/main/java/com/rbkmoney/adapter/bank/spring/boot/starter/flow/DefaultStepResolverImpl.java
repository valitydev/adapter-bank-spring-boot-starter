package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.model.AdapterContext;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.Step;
import org.springframework.stereotype.Component;

@Component
public class DefaultStepResolverImpl implements StepResolver {

    @Override
    public Step resolveEntry(EntryStateModel stateModel) {
        switch (stateModel.getTargetStatus()) {
            case PROCESSED:
                return resolveProcessedSteps(stateModel);
            case CAPTURED:
                return Step.CAPTURE;
            case REFUNDED:
                return Step.REFUND;
            case CANCELLED:
                return Step.CANCEL;
            case AUTH_RECURRENT:
                return resolveAuthRecurrent(stateModel);
            default:
                return null;
        }
    }

    private Step resolveProcessedSteps(EntryStateModel stateModel) {
        if (isNextThreeDs(stateModel)) {
            return Step.FINISH_THREE_DS;
        } else if (stateModel.isMakeRecurrent()) {
            return Step.AUTH_RECURRENT;
        } else if (stateModel.getRecToken() != null) {
            return Step.RECURRENT;
        }
        return Step.AUTH;
    }

    private Step resolveAuthRecurrent(EntryStateModel stateModel) {
        AdapterContext adapterContext = stateModel.getAdapterContext();
        if (adapterContext != null
                && (Step.GENERATE_TOKEN_FINISH_THREE_DS.equals(adapterContext.getNextStep())
                || Step.GENERATE_TOKEN_CAPTURE.equals(adapterContext.getNextStep())
                || Step.GENERATE_TOKEN_REFUND.equals(adapterContext.getNextStep()))) {
            return adapterContext.getNextStep();
        }
        return Step.AUTH_RECURRENT;
    }

    private static boolean isNextThreeDs(EntryStateModel stateModel) {
        return stateModel.getAdapterContext() != null && stateModel.getAdapterContext().getNextStep() != null
                && (Step.FINISH_THREE_DS.equals(stateModel.getAdapterContext().getNextStep())
                || Step.GENERATE_TOKEN_FINISH_THREE_DS.equals(stateModel.getAdapterContext().getNextStep()));
    }

    @Override
    public Step resolveExit(ExitStateModel stateModel) {
        EntryStateModel entryStateModel = stateModel.getEntryStateModel();
        Step step = entryStateModel.getStep();
        switch (step) {
            case AUTH_RECURRENT:
                if (Step.FINISH_THREE_DS.equals(stateModel.getNextStep())) {
                    return Step.GENERATE_TOKEN_FINISH_THREE_DS;
                } else {
                    return Step.GENERATE_TOKEN_CAPTURE;
                }
            case GENERATE_TOKEN_FINISH_THREE_DS:
                return Step.GENERATE_TOKEN_CAPTURE;
            case GENERATE_TOKEN_CAPTURE:
                return Step.GENERATE_TOKEN_REFUND;
            case GENERATE_TOKEN_REFUND:
                return Step.GENERATE_TOKEN_FINISH;
            default:
                return stateModel.getNextStep();
        }
    }
}
