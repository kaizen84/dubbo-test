package top.rows.dubbo.test.api.model;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * 活动请求参数
 *
 * @author 张治保
 * <p>
 * date 2023/3/15
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ActivityResp implements Serializable {

    /**
     * 额外信息
     */
    private JSONObject extra = new JSONObject();

    /**
     * sku对应的价格 map
     */
    private Map<ShopProductSkuKey, Long> skuKeyPriceMap = Collections.emptyMap();

    /**
     * 是否可用优惠
     */
    private StackableDiscount stackable = new StackableDiscount();


}
