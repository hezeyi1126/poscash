package springboot.hello.bus.service;

import springboot.hello.bus.entity.BusGoodsType;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
public interface BusGoodsTypeService {

    int insert(BusGoodsType busGoodsType);

    int delete(BusGoodsType busGoodsType);

    int deleteByIds(String[] ids);

    int update(BusGoodsType busGoodsType);

    BusGoodsType getById(String id);

    List<BusGoodsType> list(BusGoodsType busGoodsType);
    
}