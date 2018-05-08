package com.fzy.learn.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fuzhongyu
 * @date 2018/4/3
 */
@Controller
@RequestMapping(value = "/alipay")
public class AlipayController {


  public static final String APP_ID="2018040202492938";

  public static final String CHARSET="UTF-8";

  public static final String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAphcJ3ZKxPh77BNIPIdKfP6qJrtwl6YS0p7MpOla8ks9KHxJKPR9+VevbImVqEE+BL5nHUYBxVJYTUCTPOadpq58Ww9iYPjZDdiXeZnoVnySZ";

  public static final String APP_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCmFwndkrE+HvsE0g8h0p8/qomu3CXphLSnsyk6VrySz0ofEko9H35V69siZWoQT4EvmcdRgHFUlhNQJM85p2mrnxbD2Jg+NkN2Jd5mehWfJJnyPBqfpJ+5++1yQrkrUlPR8t2aNa/a7/4RNH5EPM+wtMU/yG2BmdI4S+f5ge4MubAw8kwT/YW7WRcggjnGzX9R3CmWQLpzxYbDA5t6QmhcImXCnVD/6HdufGOQ1LFFMfLXzYJsSbIHig//qOlMI4cW8YtzEEC9d/5reULI0yO4wfNtcMcdn10HHDzMYf1/SCOvTdxEYvcPOpRljIlu64kZ0BWDiwkaJNLT1IhSTNJtAgMBAAECggEAfUHotcqYkwHoS2Vj9h0S7n/doBr1GJx1ZffPAulBA/MCslYn2Nr0ezYJqHIVQEHFarGtyQB199XKsOlhwthH8B9lmsOxZVGlJOhARsaRodiHpVDAv172+ttM4pwBa/OFtVNU3qTYf+P4lt8gzrOR6nEaRRURyOjJyp0sUFY1wi/aYYuyGxIpn59n6M8GE86p2Ahr6SqyZS38izjeaicf1zxQn1uMldi80pLbVEAqd9FuWjmZlTn1AX5sMpoKeYXl1v6qQcbEfEKy0WZb1YyCBZcMe0KZEGbbgsp0DwIDYrJFuy9YptayK/+f8EK/h1fOnf45k0ygfwNbi1G24iaDfQKBgQDqfn5KSup5yVff8JtpKrW9V/xWPaDrBSBfcQF19WD/iB7weeNRrQ9y4Oh6gsS2luSkOMQvEWl+E7JWmkjwj4bkJRclprOIOARHElh80L5n93BCykbITSAo6tqGN0RroPoGh1gPGMHqWiMgwx/61qy9F+Y0aEDcZZbzOSqkUroi+wKBgQC1UomeMFUznzWRX2IO287Xc74wlJsMHy72aJwgZXgFWk73cW07N9MC3jmq1Q8JukMaPKVJ2fQgpVwUSB1CKMumR+tZXCBGHr7XF9wCGV+bM3nx+IXacDgz2RlAUKl5Fe4lCs3SPC5iZlJj6kLU3t3vHuuDW+NjIPvlF0sBT2ijtwKBgQCVOc5QpQA2ZIVBg7LC6GUji5yPnUSMi4SgeB+/21nRA+T8j/Szg3hzWOFZJWLd94SlZWKjuWbyzsINDr4gKJZlFZ13XnCd3VgLioc5VvX036hXOLZ2vW4b2+kYxI8MFzNFeFf3s3+kDZyROttdG8RtyYm8DCRKnXPEcLrMO8EshQKBgBI+Zb5W2pvBDyC7WiBomV0wNhipOxhzIsSELgFMdFEFjyBydy0YJtEJDwBTQ5oU9Z90LqVJmriWKreXsenwNN1cKx/olw63FTiLHAXSC76P5VslSEJ8PAtrcpD4DLU0MavkdGUMzRX1eaC391V3vxjKIaQr4KserHmWaGOPW9XtAoGAC2HtHB5h01VniRotfumbGDqH1yngJcXjbK7V5W3l1+yC8tu//EByZlLgn0XvZAZ8wjmVrxeVrZ5TgNTURbaVHa60OuiOAAfwZd+f3M1FAfGn2ia7+E3kLggpqJQ/r1api2uGeNJROgpWNc4m2IO2J5Kslo9rdVBKKzz9ixOktCQ=";

  public static final String URL="https://openapi.alipaydev.com/gateway.do";

  public static AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY);


  public static AlipayTradeWapPayResponse pay(String content) throws AlipayApiException {
          // 创建API对应的request
    AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
    // 在公共参数中设置回跳和通知地址(应用提供给支付宝的请求路径),沙箱模式中不起作用(不知道是不是这个原因,支付宝技术客服告诉我正式上线后就没问题)
//     alipayRequest.setReturnUrl("http://xxx.com/xxx");
//      alipayRequest.setNotifyUrl("http://xxx.com/xxx");
     // 填充业务参数
     alipayRequest.setBizContent(content);
    AlipayTradeWapPayResponse alipayResponse = alipayClient
               .pageExecute(alipayRequest);
    return alipayResponse;
  }

  @PostMapping(value="")
 public void wapPay(@RequestParam(value = "content", required = true) String content,HttpServletResponse response) throws IOException, AlipayApiException {
     //设置将发送到客户端的响应的内容类型
    response.setContentType("text/html;charset="+CHARSET);
    AlipayTradeWapPayResponse alipayResponse= pay(content);
    String from= alipayResponse.getBody();
    System.out.println(from);
    //输出支付宝返回的表单页面
    response.getWriter().print(from);
  }

}
