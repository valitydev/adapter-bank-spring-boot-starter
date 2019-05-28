package com.rbkmoney.adapter.bank.spring.boot.starter.service;

import com.rbkmoney.adapter.bank.spring.boot.starter.config.properties.AdapterProperties;
import com.rbkmoney.adapter.bank.spring.boot.starter.constants.ThreeDsFields;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.bank.spring.boot.starter.utils.RedirectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ThreeDsPropertiesServiceImpl implements ThreeDsPropertiesService {

    private final AdapterProperties adapterProperties;

    @Override
    public Map<String, String> initProperties(ExitStateModel exitStateModel) {
        Map<String, String> params = new HashMap<>();
        params.put(ThreeDsFields.PA_REQ, exitStateModel.getPaReq());
        params.put(ThreeDsFields.MD, exitStateModel.getMd());
        params.put(ThreeDsFields.TERM_URL, RedirectUtils.getCallbackUrl(adapterProperties.getCallbackUrl(), adapterProperties.getPathCallbackUrl()));
        return params;
    }

}
