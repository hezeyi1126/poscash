package springboot.hello.bus.dao;

import springboot.hello.bus.entity.BusGoods;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
@org.apache.ibatis.annotations.Mapper
public interface BusGoodsDao extends Mapper<BusGoods>{

   int insert(BusGoods busGoods);

    int delete(BusGoods busGoods);

    int deleteByIds(@Param("ids") String[] ids);

    int update(BusGoods busGoods);

    BusGoods getById(@Param("id") String id);

    List<BusGoods> list(BusGoods busGoods);
}