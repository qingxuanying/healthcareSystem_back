package com.example.demo.Answer;

public class ReturnCode {

    private final int code;
    private String msg;
    public final static int success = 200;
    public final static int failed = 500;

    public final static int null_point_error = 501;

    public final static int null_return_error = 502;

    public final static int token_error = 503;

    public final static int exist_error = 504;


    public ReturnCode(int code) {
        this.code = code;
        switch (code) {
            case 200:
                this.msg = "操作成功";
                break;
            case 500:
                this.msg = "操作失败";
                break;
            case 501:
                this.msg = "出现空指针错误";
                break;
            case 502:
                this.msg = "出现空返回值";
                break;
            case 503:
                this.msg = "token出现错误";
                break;
            case 504:
                this.msg = "已经存储过相关信息";
                break;
        }
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}