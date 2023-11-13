package com.jayden.bean;

import lombok.Data;

@Data
public class Result<T> {
    private Result(){

    }

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static Result sucess(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        return result;
    }

    public static Result sucess(Integer code,String message){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> success(Integer code,String message,T data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        return result;
    }

    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(Integer code,String message,T data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        result.setData(data);
        return result;
    }
}
