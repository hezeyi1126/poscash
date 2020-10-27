package springboot.hello.bus.service.impl;

import springboot.hello.bus.service.BusGoodsService;
import springboot.hello.bus.dao.BusGoodsDao;
import springboot.hello.bus.entity.BusGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import springboot.hello.entity.base.ParamObject;
import springboot.hello.util.BeanUtil;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
@Service("busGoodsService")
public class BusGoodsServiceImpl implements BusGoodsService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object delSelected(ParamObject<BusGoods> paramObject ) throws Exception {
    	BeanUtil.buildEntity(BusGoods.class, paramObject);
    	String idsArr = (String) paramObject.getValue("ids");
    	String[] ids =  idsArr.split(",");
    	busGoodsDao.deleteByIds(ids);
    	paramObject.setMsg(  "删除成功");
    	return null;
    }

    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object add(ParamObject<BusGoods> paramObject ) throws Exception {
    	BeanUtil.buildEntity(BusGoods.class, paramObject);
    	busGoodsDao.insert(paramObject.getEntity());
    	paramObject.setMsg(  "添加成功");
    	return null;
    }
    
  // @CacheEvict(value = "busGoods", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object del(ParamObject<BusGoods> paramObject ) throws Exception{
    	BeanUtil.buildEntity(BusGoods.class, paramObject);
    	busGoodsDao.delete(paramObject.getEntity());
    	paramObject.setMsg(  "删除成功");
    	 return null;
    }
    
    
    //@Cacheable(value = "busGoods", key = "#p0.id")
    public Object getBId(ParamObject<BusGoods> paramObject) throws Exception{
    	BeanUtil.buildEntity(BusGoods.class, paramObject);
        return  busGoodsDao.selectOne(paramObject.getEntity());
    }
    
    
   // @CachePut(value = "busGoods", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object edit(ParamObject<BusGoods> paramObject ) throws Exception{
    	BeanUtil.buildEntity(BusGoods.class, paramObject);
    	BusGoods entity = paramObject.getEntity();
    	busGoodsDao.updateByPrimaryKey(entity);
    	paramObject.setMsg(  "保存成功");
        return entity;
    }
    
    public Object list(ParamObject<BusGoods> paramObject) throws Exception{
    	BeanUtil.buildEntity(BusGoods.class, paramObject);
        return 	busGoodsDao.select(paramObject.getEntity());
    }




    @Autowired
    private BusGoodsDao busGoodsDao;
    
     @Override
    public BusGoods getById(String id){
        return busGoodsDao.getById(id);
    }
    
        @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  busGoodsDao.deleteByIds(ids);
    }
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(BusGoods busGoods){
        return busGoodsDao.insert(busGoods);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(BusGoods busGoods){
        return busGoodsDao.delete(busGoods);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(BusGoods busGoods){
        return busGoodsDao.updateByPrimaryKey(busGoods);
    }

   

    @Override
    public List<BusGoods> list(BusGoods busGoods){
        return busGoodsDao.select(busGoods);
    }
    
    /**
    *getter and setter
    */
    public BusGoodsDao getBusGoods(){
    	return this.busGoodsDao;
    }
    
    public void setBusGoodsDao(BusGoodsDao busGoodsDao){
      this.busGoodsDao = busGoodsDao;
    }
    

}