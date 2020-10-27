package springboot.hello.bus.service.impl;

import springboot.hello.bus.service.BusGoodsTypeService;
import springboot.hello.bus.dao.BusGoodsTypeDao;
import springboot.hello.bus.entity.BusGoodsType;
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
@Service("busGoodsTypeService")
public class BusGoodsTypeServiceImpl implements BusGoodsTypeService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object delSelected(ParamObject<BusGoodsType> paramObject ) throws Exception {
    	BeanUtil.buildEntity(BusGoodsType.class, paramObject);
    	String idsArr = (String) paramObject.getValue("ids");
    	String[] ids =  idsArr.split(",");
    	busGoodsTypeDao.deleteByIds(ids);
    	paramObject.setMsg(  "删除成功");
    	return null;
    }

    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object add(ParamObject<BusGoodsType> paramObject ) throws Exception {
    	BeanUtil.buildEntity(BusGoodsType.class, paramObject);
    	busGoodsTypeDao.insert(paramObject.getEntity());
    	paramObject.setMsg(  "添加成功");
    	return null;
    }
    
  // @CacheEvict(value = "busGoodsType", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object del(ParamObject<BusGoodsType> paramObject ) throws Exception{
    	BeanUtil.buildEntity(BusGoodsType.class, paramObject);
    	busGoodsTypeDao.delete(paramObject.getEntity());
    	paramObject.setMsg(  "删除成功");
    	 return null;
    }
    
    
    //@Cacheable(value = "busGoodsType", key = "#p0.id")
    public Object getBId(ParamObject<BusGoodsType> paramObject) throws Exception{
    	BeanUtil.buildEntity(BusGoodsType.class, paramObject);
        return  busGoodsTypeDao.selectOne(paramObject.getEntity());
    }
    
    
   // @CachePut(value = "busGoodsType", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object edit(ParamObject<BusGoodsType> paramObject ) throws Exception{
    	BeanUtil.buildEntity(BusGoodsType.class, paramObject);
    	BusGoodsType entity = paramObject.getEntity();
    	busGoodsTypeDao.updateByPrimaryKey(entity);
    	paramObject.setMsg(  "保存成功");
        return entity;
    }
    
    public Object list(ParamObject<BusGoodsType> paramObject) throws Exception{
    	BeanUtil.buildEntity(BusGoodsType.class, paramObject);
        return 	busGoodsTypeDao.select(paramObject.getEntity());
    }




    @Autowired
    private BusGoodsTypeDao busGoodsTypeDao;
    
     @Override
    public BusGoodsType getById(String id){
        return busGoodsTypeDao.getById(id);
    }
    
        @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  busGoodsTypeDao.deleteByIds(ids);
    }
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(BusGoodsType busGoodsType){
        return busGoodsTypeDao.insert(busGoodsType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(BusGoodsType busGoodsType){
        return busGoodsTypeDao.delete(busGoodsType);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(BusGoodsType busGoodsType){
        return busGoodsTypeDao.updateByPrimaryKey(busGoodsType);
    }

   

    @Override
    public List<BusGoodsType> list(BusGoodsType busGoodsType){
        return busGoodsTypeDao.select(busGoodsType);
    }
    
    /**
    *getter and setter
    */
    public BusGoodsTypeDao getBusGoodsType(){
    	return this.busGoodsTypeDao;
    }
    
    public void setBusGoodsTypeDao(BusGoodsTypeDao busGoodsTypeDao){
      this.busGoodsTypeDao = busGoodsTypeDao;
    }
    

}