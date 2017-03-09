package com.jasper.exception;

import com.jasper.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jasper on 2017/3/8.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Some Data");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }

}
