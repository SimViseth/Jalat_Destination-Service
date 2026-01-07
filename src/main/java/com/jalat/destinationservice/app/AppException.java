package com.jalat.destinationservice.app;

import lombok.Getter;
import lombok.Setter;

import static com.jalat.destinationservice.app.AppConstant.FAIL;
import static com.jalat.destinationservice.app.AppConstant.FAIL_CODE;

@Getter
@Setter
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 5531221281437904797L;

    private String status  = FAIL;
    private String code    = FAIL_CODE;
    private String msg    = "";
    private String cmd    = "";
    private String ref    = "";
    private String execInfo    = "";

    public AppException(String msg) {
        this.msg = msg;
    }

    public AppException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AppException(String code, String msg, String execInfo) {
        this.code = code;
        this.msg = msg;
        this.execInfo = execInfo;
    }
}
