package top.rows.dubbo.test.provider;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.apache.dubbo.config.annotation.DubboService;
import top.rows.dubbo.test.api.HelloService;
import top.rows.dubbo.test.api.model.ActivityParam;
import top.rows.dubbo.test.api.model.ActivityResp;
import top.rows.dubbo.test.api.model.StackableDiscount;

import java.time.Duration;
import java.util.Map;

/**
 * @author 张治保
 * date 2023/5/8
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public ActivityResp activity(ActivityParam param) {
        System.out.println("参数接收...");
        System.out.println(JSON.toJSONString(param));
        JSONObject extra = new JSONObject();
        extra.put("teamNo", "TM20210508100001");
        return new ActivityResp()
                .setExtra(extra)
                .setStackable(new StackableDiscount().setPayTimeout(Duration.ofMillis(30)))
                .setSkuKeyPriceMap(
                        Map.of(
                                param.getSkuKeyMap().keySet().iterator().next(),
                                100L
                        )
                );
    }
}
