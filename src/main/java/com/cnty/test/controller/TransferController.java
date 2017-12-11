package com.cnty.test.controller;

import com.cnty.test.client.TransferClient;
import com.cnty.test.pojo.Transfer;
import com.cnty.test.util.ResultFormatter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/8 15:47
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@RestController("/transfer")
public class TransferController {

    @PostMapping("/")
    public Map<String,Object> sendMessage(@RequestBody Transfer transfer){
        TransferClient client = new TransferClient("localhost", 10010);
        client.init();
        client.send(transfer);
        return ResultFormatter.formatResult(200,"SUCCESS",null);
    }

}
