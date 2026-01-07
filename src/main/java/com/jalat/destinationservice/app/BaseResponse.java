package com.jalat.destinationservice.app;

import lombok.Getter;
import lombok.Setter;

import static com.jalat.destinationservice.app.AppConstant.FAIL;
import static com.jalat.destinationservice.app.AppConstant.FAIL_CODE;

@Getter
@Setter
public class BaseResponse <T> {
    String code = FAIL_CODE;
    String status = FAIL;
    String msg;
    T data;
}
