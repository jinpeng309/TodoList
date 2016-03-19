package com.capslock.api.error;

import com.capslock.api.support.ErrorResult;
import com.capslock.api.support.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by capslock.
 */
@Controller
public class ErrorPageController implements ErrorController {
    private static Logger logger = LoggerFactory.getLogger(ErrorPageController.class);

    @Value("${error.path:/error}")
    private String errorPath;

    private ErrorAttributes errorAttributes = new DefaultErrorAttributes();

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping(value = "${error.path:/error}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ErrorResult handle(HttpServletRequest request) {
        Map<String, Object> attributes = getErrorAttributes(request);

        final int code = (int) attributes.get("status");
        final String message = (String) attributes.get("error");
        ErrorResult result = new ErrorResult(ResultCode.from(code), message);
        logger.error(result.toString());
        return result;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, false);
    }
}
