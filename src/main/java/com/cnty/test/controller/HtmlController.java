package com.cnty.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/8 16:26
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Controller
public class HtmlController {
    @GetMapping("/")
    public String html() {
        return "index";
    }
}
