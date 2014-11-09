package com.github.cjm0000000.h5.action;

import com.alibaba.fastjson.JSON;
import com.github.cjm0000000.h5.model.Goods;
import com.github.cjm0000000.h5.model.Order;
import com.github.cjm0000000.h5.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * order controller
 * Created by lemon on 14/11/8.
 */
@Controller
@RequestMapping("/orders/")
public class OrderAction {

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ModelAndView showOrder() {
        String templateName = "order";
        Order order = createOrder();
        ModelAndView mv = new ModelAndView("index", "mainViewName", templateName);
        mv.addObject("model", order);
        return mv;
    }

    private Order createOrder() {
        Order order = new Order();
        order.setGoods(makeGoods());
        order.setSender(makeUser());
        order.setRecver(makeUser());
        return order;
    }

    private Goods makeGoods() {
        Goods goods = new Goods();
        goods.setSign(0);
        goods.setWeight(1);
        return goods;
    }

    private User makeUser() {
        User user = new User();
        user.setName(UUID.randomUUID().toString());
        // user.setPhone(String.valueOf(new SecureRandom().nextInt(1000000000)));
        user.setAddr("Addr" + new SecureRandom().nextInt(1000000000));
        return user;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String create(@Valid Order order, BindingResult br) {
        if (br.hasErrors()) {
            return validateError(br.getFieldError().getField(), br.getFieldError().getDefaultMessage());
        }

        return info("下单成功。");
    }

    private String validateError(String field, String errorMsg) {
        Map<String, Object> response = new HashMap<>(4);
        response.put("field", field);
        response.put("msg", errorMsg);
        return JSON.toJSONString(response);
    }

    private String info(String message) {
        return sendJson(true, String.format("<div class=\"alert alert-info\" role=\"alert\">%s</div>", message));
    }

    private String error(String message) {
        return sendJson(false, String.format("<div class=\"alert alert-danger\" role=\"alert\">%s</div>", message));
    }

    private String sendJson(boolean isSuccess, String message) {
        Map<String, Object> response = new HashMap<>(4);
        response.put("success", isSuccess);
        response.put("msg", message);
        return JSON.toJSONString(response);
    }
}
