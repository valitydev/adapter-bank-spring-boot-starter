package com.rbkmoney.adapter.bank.spring.boot.starter.flow;

import com.rbkmoney.adapter.bank.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.Step;

public interface StepResolver {

    Step resolveEntry(EntryStateModel stateModel);

    Step resolveExit(ExitStateModel stateModel);

}
