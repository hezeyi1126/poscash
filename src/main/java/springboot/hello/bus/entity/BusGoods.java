package springboot.hello.bus.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
@Table(name = "BUS_GOODS")
public class BusGoods implements Serializable {
        /**
         *商品ID
         */
         @Id
   		 @GeneratedValue(generator = "UUID")
   		 @Column(name="GOODS_ID")
         private String goodsId; 
         
        /**
         *类型ID
         */
         @Column(name="TYPE_ID")
         private String typeId;
         
        /**
         *商品名称
         */
         @Column(name="GOODS_NAME")
         private String goodsName;
         
        /**
         *条码
         */
         @Column(name="BAR_CODE")
         private String barCode;
         
        /**
         *货号
         */
         @Column(name="GOODS_CODE")
         private String goodsCode;
         
        /**
         *规格
         */
         @Column(name="SPECE")
         private String spece;
         
        /**
         *拼音
         */
         @Column(name="PINYIN")
         private String pinyin;
         
        /**
         *库存
         */
         @Column(name="RESERVE")
         private BigDecimal reserve;
         
        /**
         *主单位 对应编码表单位
         */
         @Column(name="UNIT_CODE")
         private String unitCode;
         
        /**
         *进货价
         */
         @Column(name="STOCK_PRICE")
         private BigDecimal stockPrice;
         
        /**
         *销售价
         */
         @Column(name="SELL_PRICE")
         private BigDecimal sellPrice;
         
        /**
         *批发价
         */
         @Column(name="PLENTY_SELL_PRICE")
         private BigDecimal plentySellPrice;
         
        /**
         *会员价
         */
         @Column(name="MEMBER_PRICE")
         private BigDecimal memberPrice;
         
        /**
         *是否会员折扣1是0否
         */
         @Column(name="IS_MEMBER_REBATE")
         private BigDecimal isMemberRebate;
         
        /**
         *供应商
         */
         @Column(name="SUPPLIER_ID")
         private String supplierId;
         
        /**
         *生产日期
         */
   		 @JsonFormat(pattern = "yyyy-MM-dd")
         @Column(name="PREDUCE_DATE")
         private Date preduceDate;
         
        /**
         *保质期 单位-天
         */
         @Column(name="QUALITY_DAYS")
         private BigDecimal qualityDays;
         
        /**
         *一品多码 1是0否
         */
         @Column(name="IS_MULTY_CODE")
         private BigDecimal isMultyCode;
         
        /**
         *是否不计库存1是 0 否
         */
         @Column(name="IS_NO_RESERVE")
         private BigDecimal isNoReserve;
         
        /**
         *是否可用 1可用 0不可用
         */
         @Column(name="IS_AVIABLE")
         private BigDecimal isAviable;
         
        /**
         *排序
         */
         @Column(name="SORT_FLAG")
         private BigDecimal sortFlag;
         
        /**
         *备注
         */
         @Column(name="REMARK")
         private String remark;
         
        /**
         *创建人
         */
         @Column(name="CREATE_USER_ID")
         private String createUserId;
         
        /**
         *创建时间
         */
   		 @JsonFormat(pattern = "yyyy-MM-dd")
         @Column(name="CREATE_TIME")
         private Date createTime;
         

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }
        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }
        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }
        public String getBarCode() {
            return barCode;
        }

        public void setBarCode(String barCode) {
            this.barCode = barCode;
        }
        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }
        public String getSpece() {
            return spece;
        }

        public void setSpece(String spece) {
            this.spece = spece;
        }
        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }
        public BigDecimal getReserve() {
            return reserve;
        }

        public void setReserve(BigDecimal reserve) {
            this.reserve = reserve;
        }
        public String getUnitCode() {
            return unitCode;
        }

        public void setUnitCode(String unitCode) {
            this.unitCode = unitCode;
        }
        public BigDecimal getStockPrice() {
            return stockPrice;
        }

        public void setStockPrice(BigDecimal stockPrice) {
            this.stockPrice = stockPrice;
        }
        public BigDecimal getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(BigDecimal sellPrice) {
            this.sellPrice = sellPrice;
        }
        public BigDecimal getPlentySellPrice() {
            return plentySellPrice;
        }

        public void setPlentySellPrice(BigDecimal plentySellPrice) {
            this.plentySellPrice = plentySellPrice;
        }
        public BigDecimal getMemberPrice() {
            return memberPrice;
        }

        public void setMemberPrice(BigDecimal memberPrice) {
            this.memberPrice = memberPrice;
        }
        public BigDecimal getIsMemberRebate() {
            return isMemberRebate;
        }

        public void setIsMemberRebate(BigDecimal isMemberRebate) {
            this.isMemberRebate = isMemberRebate;
        }
        public String getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
        }
        public Date getPreduceDate() {
            return preduceDate;
        }

        public void setPreduceDate(Date preduceDate) {
            this.preduceDate = preduceDate;
        }
        public BigDecimal getQualityDays() {
            return qualityDays;
        }

        public void setQualityDays(BigDecimal qualityDays) {
            this.qualityDays = qualityDays;
        }
        public BigDecimal getIsMultyCode() {
            return isMultyCode;
        }

        public void setIsMultyCode(BigDecimal isMultyCode) {
            this.isMultyCode = isMultyCode;
        }
        public BigDecimal getIsNoReserve() {
            return isNoReserve;
        }

        public void setIsNoReserve(BigDecimal isNoReserve) {
            this.isNoReserve = isNoReserve;
        }
        public BigDecimal getIsAviable() {
            return isAviable;
        }

        public void setIsAviable(BigDecimal isAviable) {
            this.isAviable = isAviable;
        }
        public BigDecimal getSortFlag() {
            return sortFlag;
        }

        public void setSortFlag(BigDecimal sortFlag) {
            this.sortFlag = sortFlag;
        }
        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }
        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
}
