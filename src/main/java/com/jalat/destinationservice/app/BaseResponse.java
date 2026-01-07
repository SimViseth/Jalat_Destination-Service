package com.jalat.destinationservice.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import static com.jalat.destinationservice.app.AppConstant.FAIL;
import static com.jalat.destinationservice.app.AppConstant.FAIL_CODE;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse <T> {
    String code = FAIL_CODE;
    String status = FAIL;
    String msg;
    T data;
}
