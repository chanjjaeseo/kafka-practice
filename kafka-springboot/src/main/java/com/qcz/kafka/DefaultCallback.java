package com.qcz.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class DefaultCallback implements ListenableFutureCallback {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onFailure(Throwable ex) {
        logger.info(ex.getMessage());
    }

    @Override
    public void onSuccess(Object result) {
        logger.info(result.toString());
    }

}
