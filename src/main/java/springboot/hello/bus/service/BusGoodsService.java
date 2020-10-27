package springboot.hello.bus.service;

import springboot.hello.bus.entity.BusGoods;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
public interface BusGoodsService {

    int insert(BusGoods busGoods);

    int delete(BusGoods busGoods);

    int deleteByIds(String[] ids);

    int update(BusGoods busGoods);

    BusGoods getById(String id);

    List<BusGoods> list(BusGoods busGoods);
    
}