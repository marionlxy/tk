package com.taikang.iu.opt.characterset.action;

import com.taikang.iu.opt.characterset.model.CharactersetBO;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
  * ICharactersetAction
  */

public interface ICharactersetAction extends IBaseAction { 

	final String ACTION_ID = "charactersetAction"; 	
	
	CurrentPage queryForLinkPage(CurrentPage page);

	void deleteLink(Dto param);

	List<CharactersetBO> findAllServerService(Dto param);
	/**
	 * 通过用品Id查询套餐下是否有此用品
	 * @param param
	 * @return
	 */
	List<CharactersetBO> findApplianList(Dto param);
	
	Dto findOneLink(Dto param);
//新增环节
	void insertLink(Dto param);
//修改环节
	void updateLink(Dto param);
//查询用品列表
	CurrentPage queryForAppliancePage(CurrentPage page);
	//根据站点查询用品列表
	List<CharactersetBO> findAllAppliance(Dto param);
//删除用品
	void delAppliance(Dto param);
//展示选中物品
	CurrentPage queryForShowAppliancePage(CurrentPage page);
//添加用品
	void insertLinkServer(Dto param);
//添加服务
	void insertServer(Dto param);
//查询环节下是否有服务
	List<CharactersetBO> findCharactersetService(Dto param);
//删除环节下服务
	void delCharactersetService(Dto param);
//更新环节下服务
	void updateServer(Dto param);
//查询环节所选服务
	List<CharactersetBO> findOneServerService(Dto param);
//初始化服务列表
	CurrentPage queryForServicePage(CurrentPage page);
//显示环节下服务
	CurrentPage findOneService(CurrentPage page); 	
	//查询环节列表
		List<CharactersetBO> findLink(Dto paras);
	//查询套餐修改环节
		CurrentPage findEditLinkPage(CurrentPage page);
	//查询套餐列表
		List<CharactersetBO> findEditMealList(Dto param);
	//查询单个套餐
		Dto findOneMeal(Dto param);
	//查询套餐下环节列表
		List<CharactersetBO> findEditMealCheckList(Dto param);
	//通过serviceId查询个性套餐下是否有此服务
		List<CharactersetBO> findApplianceRelation(Dto param);
	//查询环节下用品
		List<CharactersetBO> findApplianceList(Dto params);
	//查询套餐下环节
		List<CharactersetBO> findDelLink(Dto param);

		List<CharactersetBO> findDelLinks(Dto param);
		
		void delApplianceLink(Dto param);

		List<CharactersetBO> findRelation(Dto param);

		void updateAppliance(Dto params);

		List<CharactersetBO> findApplianceLists(Dto params);

		CurrentPage findOneServices(CurrentPage page);
		
		/**
		 * 查询个性化用品服务ID为空的数据
		 */
		public List<Dto> FindapplianceByServerIdIsNull(Dto param);

		List<CharactersetBO> findChacterAppliacnce(Dto param);

		void delService(Dto params);

		List<CharactersetBO> searchAppliance(Dto applianceParam);

		List<CharactersetBO> searchOneService(Dto param);
		/**
		 * 通过用品Id查询用品
		 * @param appliancParam
		 * @return
		 */
		List<CharactersetBO> searchOneAppliance(Dto appliancParam);
		/**
		 * 通过服务关系表Id查询服务
		 * @param servicearam
		 * @return
		 */
		List<CharactersetBO> searchOnesService(Dto servicearam);

		List<CharactersetBO> findOneLinkService(Dto serParam);

		String uploadBySpringGrpFixed(HttpServletRequest request);

		List<CharactersetBO> findDelApplianceList(Dto serverParam);

		List<CharactersetBO> findUpdateRelation(Dto param);

		


}
