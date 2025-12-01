package org.example.order.server;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 *
 *
 * @author LXZ 2025/11/29 18:42
 */
@LocalTCC
public interface TccOrderService {
    //
    /**
     * name = 事务动作名字全局唯一  commitMethod = 提交方法名  rollbackMethod = 回滚方法名
     * @BusinessActionContextParameter 注解用于参数传递给提交和回滚方法
     */
    @TwoPhaseBusinessAction(name="prepareOrderBalance" , commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext,
                    @BusinessActionContextParameter(paramName = "accountNo") String accountNo,
                    @BusinessActionContextParameter(paramName = "money") Integer money);

    boolean commit(BusinessActionContext actionContext);

    boolean rollback(BusinessActionContext actionContext);
}
