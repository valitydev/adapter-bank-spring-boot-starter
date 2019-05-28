package com.rbkmoney.adapter.bank.spring.boot.starter.controller;

import com.rbkmoney.adapter.bank.spring.boot.starter.model.Callback;
import com.rbkmoney.adapter.bank.spring.boot.starter.serializer.CallbackSerializer;
import com.rbkmoney.adapter.helpers.hellgate.HellgateAdapterClient;
import com.rbkmoney.adapter.helpers.hellgate.exception.HellgateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.BiFunction;


/**
 * Handler callback 3DS
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/${server.rest.endpoint}")
public class AdapterController {

    private final HellgateAdapterClient hgClient;
    private final CallbackSerializer callbackSerializer;

    @PostMapping(value = "term_url")
    public String receivePaymentIncomingParameters(HttpServletRequest request, HttpServletResponse servletResponse) throws IOException {
        return processCallback(request, servletResponse, hgClient::processPaymentCallback);
    }

    @PostMapping(value = "rec_term_url")
    public String receiveRecurrentIncomingParameters(HttpServletRequest request, HttpServletResponse servletResponse) throws IOException {
        return processCallback(request, servletResponse, hgClient::processRecurrentTokenCallback);
    }

    private String processCallback(HttpServletRequest servletRequest, HttpServletResponse servletResponse, BiFunction<String, ByteBuffer, ByteBuffer> hgFunction) throws IOException {
        String resp = "";
        Callback callbackObj = callbackSerializer.read(servletRequest);
        log.info("ProcessCallback {}", callbackObj);
        try {
            String tag = callbackObj.getMd();
            ByteBuffer callback = ByteBuffer.wrap(callbackSerializer.writeByte(callbackObj));
            ByteBuffer response = hgFunction.apply(tag, callback);
            resp = new String(response.array(), StandardCharsets.UTF_8);
        } catch (HellgateException e) {
            log.warn("Failed handle callback for recurrent", e);
        } catch (Exception e) {
            log.error("Failed handle callback for recurrent", e);
        }
        if (StringUtils.hasText(callbackObj.getTermUrl())) {
            servletResponse.sendRedirect(callbackObj.getTermUrl());
        }
        log.info("ProcessCallback response {}", resp);
        return resp;
    }
}
