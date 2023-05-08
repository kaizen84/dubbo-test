package top.rows.dubbo.test.consumer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONReader;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.utils.SimpleReferenceCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.dubbo.spring.boot.autoconfigure.DubboConfigurationProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.rows.dubbo.test.api.HelloService;
import top.rows.dubbo.test.api.model.ActivityParam;
import top.rows.dubbo.test.api.model.ActivityResp;
import top.rows.dubbo.test.api.model.ShopProductSkuKey;

import java.util.Base64;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConsumerTest {

    private static final String GENERIC = "true";
    @DubboReference
    private HelloService helloService;

    @Autowired
    private DubboConfigurationProperties dubboConfigurationProperties;

    /**
     * passed
     */
    @Test
    public void test() {
        ActivityResp resp = helloService.activity(param());
        System.out.println("success");
    }

    /**
     * failed 泛化调用
     */
    @Test
    public void genericTest() {
        GenericService service = genericService("top.rows.dubbo.test.api.HelloService");
        Object activity = service.$invoke(
                "activity",
                new String[]{"top.rows.dubbo.test.api.model.ActivityParam"},
                new Object[]{param()}
        );
        System.out.println("success");
    }

    /**
     * dubbo GenericService getter
     */
    public GenericService genericService(String interfaceName) {
        SimpleReferenceCache cache = SimpleReferenceCache.getCache();
        GenericService genericService = cache.get(interfaceName);
        if (genericService != null) {
            return genericService;
        }
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setId(interfaceName);
        referenceConfig.setInterface(interfaceName);
        referenceConfig.setConsumer(dubboConfigurationProperties.getConsumer());
        referenceConfig.setTimeout(dubboConfigurationProperties.getConsumer().getTimeout());
        referenceConfig.setGeneric(GENERIC);
        referenceConfig.setAsync(Boolean.FALSE);
        return cache.get(referenceConfig);
    }

    /**
     * mock 参数
     */
    private ActivityParam param() {
        return new ActivityParam()
                .setActivityId(1L)
                .setOrderNo("SS123123123123123123")
                .setUserId(1L)
                .setSkuKeyMap(
                        Map.of(
                                new ShopProductSkuKey().setShopId(2L).setProductId(2L).setSkuId(2L),
                                10
                        )
                );
    }
}