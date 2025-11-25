package org.example.merchandise.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.merchandise.entity.Merchandise;
import org.example.merchandise.mapper.MerchandiseMapper;
import org.example.merchandise.server.MerchandiseService;
import org.example.params.ReduceParam;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 *
 *
 * @author LXZ 2025/11/24 18:14
 */
@Service
public class MerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper , Merchandise> implements MerchandiseService {
    /**
     * 减少库存接口
     *
     * @param reduceParam
     */
    @Override
    public Boolean reduce(ReduceParam reduceParam) {

        Merchandise entity = lambdaQuery().eq(Merchandise::getId, reduceParam.getId()).one();

        if (Objects.isNull(entity)) {
            return false;
        }
        return lambdaUpdate()
                .eq(Merchandise::getId, reduceParam.getId())
                .set(Merchandise::getNumber , entity.getNumber() - reduceParam.getNum())
                .set(Merchandise::getUpdateAt, new Date())
                .update();
    }
}
