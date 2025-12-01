package org.example.merchandise.api;

import org.example.feign.MerchandiseFeign;
import org.example.merchandise.server.MerchandiseService;
import org.example.merchandise.server.TccMerchandiseService;
import org.example.params.ReduceParam;
import org.example.response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author LXZ 2025/11/24 17:30
 */
@RestController
@RequestMapping("merchandise")
public class MerchandiseApi implements MerchandiseFeign {

    @Autowired
    MerchandiseService merchandiseService;
    @Autowired
    TccMerchandiseService tccMerchandiseService;

    /**
     * 减少库存接口
     *
     * @param reduceParam
     */
    @Override
    @RequestMapping(value = "/reduce" , method = RequestMethod.POST)
    public ResponseModel<Boolean> reduce(@RequestBody ReduceParam reduceParam) {
        return ResponseModel.success(merchandiseService.reduce(reduceParam));
    }

    /**
     *
     * 减少库存接口 tcc模式
     *
     * @param reduceParam
     */
    @Override
    @RequestMapping(value = "/reduce/tcc" , method = RequestMethod.POST)
    public ResponseModel<Boolean> reduceTcc(ReduceParam reduceParam) {
        return ResponseModel.success(tccMerchandiseService.prepare(null , reduceParam.getId(), reduceParam.getNum()));
    }
}
