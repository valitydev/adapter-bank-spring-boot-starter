package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.model.GeneralEntryStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.GeneralExitStateModel;
import com.rbkmoney.adapter.common.enums.Step;

public interface StepResolver<N extends GeneralEntryStateModel, X extends GeneralExitStateModel>  {

    Step resolveEntry(N entryStateModel);

    Step resolveExit(X exitStateModel);

}
