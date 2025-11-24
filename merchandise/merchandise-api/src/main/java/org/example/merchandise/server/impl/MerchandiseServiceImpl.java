package org.example.merchandise.server.impl;

import org.example.merchandise.server.MerchandiseService;
import org.example.params.ReduceParam;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author LXZ 2025/11/24 18:14
 */
@Service
public class MerchandiseServiceImpl implements MerchandiseService {
    /**
     * 减少库存接口
     *
     * @param reduceParam
     */
    @Override
    public Boolean reduce(ReduceParam reduceParam) {
        return null;
    }
}
