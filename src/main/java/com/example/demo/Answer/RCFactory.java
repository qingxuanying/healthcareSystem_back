package com.example.demo.Answer;

public class RCFactory {
    private static ReturnCode rc200 = null;
    private static ReturnCode rc500 = null;
    private static ReturnCode rc501 = null;
    private static ReturnCode rc502 = null;

    private static ReturnCode rc503 = null;

    private static ReturnCode rc504 = null;

    public static ReturnCode getSuccess() {
        if (rc200 == null) {
            rc200 = new ReturnCode(ReturnCode.success);
        }
        return rc200;
    }

    public static ReturnCode getFailed() {
        if (rc500 == null) {
            rc500 = new ReturnCode(ReturnCode.failed);
        }
        return rc500;
    }

    public static ReturnCode getNPE() {
        if (rc501 == null) {
            rc501 = new ReturnCode(ReturnCode.null_point_error);
        }
        return rc501;
    }

    public static ReturnCode getNRE() {
        if (rc502 == null) {
            rc502 = new ReturnCode(ReturnCode.null_return_error);
        }
        return rc502;
    }

    public static ReturnCode getTokenErr() {
        if (rc503 == null) {
            rc503 = new ReturnCode(ReturnCode.token_error);
        }
        return rc503;
    }

    public static ReturnCode getExistErr() {
        if (rc504 == null) {
            rc504 = new ReturnCode(ReturnCode.exist_error);
        }
        return rc504;
    }
}
