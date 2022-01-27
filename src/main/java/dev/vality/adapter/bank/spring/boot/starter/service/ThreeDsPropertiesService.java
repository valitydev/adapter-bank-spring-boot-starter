package dev.vality.adapter.bank.spring.boot.starter.service;

import dev.vality.adapter.bank.spring.boot.starter.model.GeneralExitStateModel;

import java.util.Map;

public interface ThreeDsPropertiesService {
    Map<String, String> initProperties(GeneralExitStateModel generalExitStateModel);
}
