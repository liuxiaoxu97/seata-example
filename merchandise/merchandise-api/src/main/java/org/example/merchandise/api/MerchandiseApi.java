package org.example.merchandise.api;

import org.example.fegin.MerchandiseFeign;
import org.example.params.ReduceParam;
import org.example.response.ResponseModel;
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

    /**
     * 减少库存接口
     *
     * @param reduceParam
     */
    @Override
    @RequestMapping(value = "/reduce" , method = RequestMethod.POST)
    public ResponseModel<Boolean> reduce(@RequestBody ReduceParam reduceParam) {
        return null;
    }
}
