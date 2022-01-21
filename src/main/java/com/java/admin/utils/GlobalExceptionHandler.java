package com.java.admin.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 所有异常
     * @return R
     */
    @ExceptionHandler(value = Exception.class)
    public R allException(Exception e) {
        log.error("【异常】-【全局异常】->" + e.getMessage());
        return R.error();
    }

    /**
     * sql异常
     * @return R
     */
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public R allException(BadSqlGrammarException e) {
        log.error("【异常】-【sql异常】->" + e.getMessage());
        return R.setResult(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    }

    /**
     * 自定义异常
     * @return R
     */
    @ExceptionHandler(value = CustomException.class)
    public R allException(CustomException e) {
        log.error("【异常】-【自定义异常】->" + e.getMessage());
        return R.error().message(e.getMessage());
    }
}
