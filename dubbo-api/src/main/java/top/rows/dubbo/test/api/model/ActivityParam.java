package top.rows.dubbo.test.api.model;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class ActivityParam implements Serializable {


    /* ------------ 入参 --------------- */
    /**
     * 额外参数 入参
     */
    private final JSONObject extra = new JSONObject();
    /**
     * 活动id 入参
     */
    private Long activityId;


    /* ------------ 业务处理数据 --------------- */
    /**
     * 订单号 业务处理数据
     */
    private String orderNo;


    /**
     * 买家id 业务处理数据
     */
    private Long userId;

    /**
     * skuKeys map集合
     * key: skuKey
     * value: 数量
     */
    private Map<ShopProductSkuKey, Integer> skuKeyMap;


}
