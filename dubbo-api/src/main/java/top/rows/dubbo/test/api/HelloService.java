package top.rows.dubbo.test.api;

import top.rows.dubbo.test.api.model.ActivityParam;
import top.rows.dubbo.test.api.model.ActivityResp;

/**
 * @author 张治保
 * date 2023/5/8
 */
public interface HelloService {

    ActivityResp activity(ActivityParam param);
}
