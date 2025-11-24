package org.example.merchandise.server;

import org.example.params.ReduceParam;
import org.example.response.ResponseModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *
 * @author LXZ 2025/11/24 18:12
 */
public interface MerchandiseService {

    /**
     * 减少库存接口
     *
     * @param reduceParam
     */
    Boolean reduce(ReduceParam reduceParam);
}
