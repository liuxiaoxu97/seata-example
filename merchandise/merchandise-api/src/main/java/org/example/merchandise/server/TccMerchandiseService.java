package org.example.merchandise.server;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 *
 * 商品信息
 *
 * @author LXZ 2025/11/29 18:59
 */
@LocalTCC
public interface TccMerchandiseService {

    @TwoPhaseBusinessAction(name="prepareMerchandiseBalance" , commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext,
                    @BusinessActionContextParameter(paramName = "id") Long id,
                    @BusinessActionContextParameter(paramName = "num") Integer num);

    boolean commit(BusinessActionContext actionContext);

    boolean rollback(BusinessActionContext actionContext);
}
