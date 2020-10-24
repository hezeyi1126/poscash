package springboot.hello.sys.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月24日.
*/
@Table(name = "SYS_MENU")
public class SysMenu implements Serializable {
        /**
         *菜单ID
         */
         @Id
   		 @GeneratedValue(generator = "UUID")
   		 @Column(name="MENU_ID")
         private String menuId; 
         
        /**
         *是否可用 1可用 0不可用
         */
         @Column(name="IS_AVIABLE")
         private BigDecimal isAviable;
         
        /**
         *菜单类型 1 主菜单  2组  3 子菜单
         */
         @Column(name="MENU_TYPE")
         private BigDecimal menuType;
         
        /**
         *菜单名称
         */
         @Column(name="MENU_NAME")
         private String menuName;
         
        /**
         *菜单url
         */
         @Column(name="MENU_URL")
         private String menuUrl;
         
        /**
         *菜单icon
         */
         @Column(name="MENU_ICON")
         private String menuIcon;
         
        /**
         *排序
         */
         @Column(name="SORT_FLAG")
         private BigDecimal sortFlag;
         
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
         

        public String getMenuId() {
            return menuId;
        }

        public void setMenuId(String menuId) {
            this.menuId = menuId;
        }
        public BigDecimal getIsAviable() {
            return isAviable;
        }

        public void setIsAviable(BigDecimal isAviable) {
            this.isAviable = isAviable;
        }
        public BigDecimal getMenuType() {
            return menuType;
        }

        public void setMenuType(BigDecimal menuType) {
            this.menuType = menuType;
        }
        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
        public String getMenuUrl() {
            return menuUrl;
        }

        public void setMenuUrl(String menuUrl) {
            this.menuUrl = menuUrl;
        }
        public String getMenuIcon() {
            return menuIcon;
        }

        public void setMenuIcon(String menuIcon) {
            this.menuIcon = menuIcon;
        }
        public BigDecimal getSortFlag() {
            return sortFlag;
        }

        public void setSortFlag(BigDecimal sortFlag) {
            this.sortFlag = sortFlag;
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
