package org.example.at.api;

import org.example.at.params.AtParam;
import org.example.at.service.SeataAtService;
import org.example.params.ReduceParam;
import org.example.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * at模式下，实现下单接口
 * @author LXZ 2025/11/25 16:57
 */
@RestController
@RequestMapping("/seata")
public class SeataAtApi {


    @Autowired
    SeataAtService seataAtService;


    /**
     * 下单
     *
     * @param atParam 下单参数
     */
    @RequestMapping(value = "/at" , method = RequestMethod.POST)
    public ResponseModel<Boolean> atOrder(@RequestBody AtParam atParam) {
        return ResponseModel.success(seataAtService.atOrder(atParam));
    }
}
