package dev.vality.adapter.bank.spring.boot.starter.service;

import dev.vality.adapter.bank.spring.boot.starter.model.GeneralExitStateModel;
import dev.vality.adapter.common.constants.ThreeDsFields;
import dev.vality.adapter.common.model.AdapterContext;
import dev.vality.adapter.common.properties.CommonAdapterProperties;
import dev.vality.adapter.common.utils.converter.RedirectUtils;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreeDsPropertiesServiceImpl implements ThreeDsPropertiesService {

    private final CommonAdapterProperties adapterProperties;

    @Override
    public Map<String, String> initProperties(GeneralExitStateModel generalExitStateModel) {
        Map<String, String> params = new HashMap<>();
        AdapterContext adapterContext = generalExitStateModel.getAdapterContext();
        params.put(ThreeDsFields.PA_REQ.getValue(), adapterContext.getPaReq());
        params.put(ThreeDsFields.MD.getValue(), adapterContext.getMd());
        params.put(ThreeDsFields.TERM_URL.getValue(), RedirectUtils.getCallbackUrl(
                adapterProperties.getCallbackUrl(),
                adapterProperties.getPathCallbackUrl())
        );
        return params;
    }

}
