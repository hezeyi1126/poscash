package springboot.hello.bus.dao;

import springboot.hello.bus.entity.BusGoodsType;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
@org.apache.ibatis.annotations.Mapper
public interface BusGoodsTypeDao extends Mapper<BusGoodsType>{

   int insert(BusGoodsType busGoodsType);

    int delete(BusGoodsType busGoodsType);

    int deleteByIds(@Param("ids") String[] ids);

    int update(BusGoodsType busGoodsType);

    BusGoodsType getById(@Param("id") String id);

    List<BusGoodsType> list(BusGoodsType busGoodsType);
}