package top.rows.dubbo.test.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 张治保
 * date 2022/10/21
 */
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class ShopProductSkuKey implements Serializable {
    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * sku id
     */
    private Long skuId;
}
