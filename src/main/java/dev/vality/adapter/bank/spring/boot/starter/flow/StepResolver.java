package dev.vality.adapter.bank.spring.boot.starter.flow;

import dev.vality.adapter.bank.spring.boot.starter.model.GeneralEntryStateModel;
import dev.vality.adapter.bank.spring.boot.starter.model.GeneralExitStateModel;
import dev.vality.adapter.common.enums.Step;

public interface StepResolver<T extends GeneralEntryStateModel, R extends GeneralExitStateModel> {

    Step resolveEntry(T entryStateModel);

    Step resolveExit(R exitStateModel);

}
