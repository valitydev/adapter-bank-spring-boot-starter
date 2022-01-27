package dev.vality.adapter.bank.spring.boot.starter.model;

import dev.vality.adapter.common.model.AdapterContext;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralExitStateModel {

    private String errorCode;
    private String errorMessage;
    private AdapterContext adapterContext;
    private GeneralEntryStateModel generalEntryStateModel;

    private Map<String, String> trxExtra;

}
