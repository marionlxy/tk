package com.taikang.iu.opt.seller.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.seller.model.SellerBO;
import com.taikang.iu.opt.seller.service.ISellerService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
import com.taikang.udp.sys.model.UserBO;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.SequenceGenerator;
 
  
/**
 * 商户信息管理
 * @author t-wuke
 * @version [版本号，默认V1.0.0]
 * @Credited 2015年3月18日 上午10:14:22
 */
 @Service(ISellerService.SERVICE_ID)
 public class SellerServiceImpl extends BaseServiceImpl implements ISellerService<SellerBO> {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(SellerBO seller) {
		logger.debug("<======SellerServiceImpl--insertSeller======>");		
		
		UserBO user = new UserBO();
		
		// 获取用户编号
		SequenceGenerator generator = SequenceGenerator.getInstance("User_Id",1);
		long nextid = generator.nextId();
		
		user.setUserId(Integer.valueOf(String.valueOf(nextid)));
		user.setUserCode(seller.getLoginName());
		user.setUserName(seller.getSellerName());
		try {
			user.setUserPwd(UserUtils.entryptPassword(seller.getLoginInitPwd()));
		} catch (TKCheckedException e) {
			logger.error("<======SellerServiceImpl--insertSelle--UserUtils.entryptPasswordr======>");
			e.printStackTrace();
		}
		user.setUserType("2");
		user.setUserStatus("1");
		user.setCreateTime(seller.getCreatedTime());
		user.setCreator(Integer.parseInt(seller.getCreatedBy()));
		
		// 商户数据中设置userId
		seller.setUserId(Integer.valueOf(String.valueOf(nextid)));
		
		appDao.insert("User.addUser",user);
		appDao.insert("Seller.addSeller",seller);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(SellerBO seller) {
		logger.debug("<======SellerServiceImpl--updateSeller======>");
		appDao.update("Seller.updateSeller",seller);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(SellerBO seller) {
		logger.debug("<======SellerServiceImpl--deleteSeller======>");
		appDao.delete("Seller.deleteSeller",seller);
	}
	
	/**
      * 查询数据
      */
	public SellerBO findOne(SellerBO seller) {
		logger.debug("<======SellerServiceImpl--findSeller======>");
		
		SellerBO sellerBackBO=appDao.queryOneObject("Seller.findOneSeller", seller);
		return sellerBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<SellerBO> findAll(SellerBO  seller) {
		logger.debug("<======SellerServiceImpl--findAllSeller======>");
		return appDao.queryForEntityList("Seller.findAllSeller", seller);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======SellerServiceImpl--querySellerByConForPage======>");
		// 注意：这里需要修改成自己写的查询语句
//		return appDao.queryForPage("Seller.querySellerForPage", currentPage);
		return appDao.queryForPage("Seller.querySellerByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======SellerServiceImpl--findAllMapSeller======>");		
		return appDao.queryForMapList("Seller.findAllMapSeller", param);
	}

	public List<Dto> findAllSellers(Dto param) {
		logger.debug("<======SellerServiceImpl--findAllSellers======>");
		return appDao.queryForMapList("Seller.findAllSellers", param);
	}
 }
  