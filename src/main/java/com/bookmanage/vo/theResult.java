package com.bookmanage.vo;

/*http请求返回的最外层对象*/
public class theResult<T> {

    private Integer code;

    private String msg;

    private T data;

    private theResult(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private theResult(CodeMsg cm){
        if(cm==null){
            return;
        }else {
            this.code = cm.getCode();
            this.msg = cm.getMsg();
            this.data = null;
        }
    }

    public static <T> theResult<T> success(T data){
        return new theResult<T>(data);
    }

    public static <T> theResult<T> error(CodeMsg cm){
        return new theResult<T>(cm);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}