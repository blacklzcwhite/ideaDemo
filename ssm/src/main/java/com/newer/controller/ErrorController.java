package com.newer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

/*
全局异常处理类
 */

@ControllerAdvice
public class ErrorController {

    //异常
    @ExceptionHandler(value = NumberFormatException.class)
    public  String exception(Exception e){

        System.out.println(e.getMessage());

        return  "error";
    }

    @ExceptionHandler(value = SQLException.class)
    public String sqlException(SQLException e){

        System.out.println(e.getMessage());

        return "error";
    }
}
