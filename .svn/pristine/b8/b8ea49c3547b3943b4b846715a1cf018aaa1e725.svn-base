package com.taikang.iu.opt.characterset.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.characterset.model.CharactersetBO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.iu.opt.characterset.service.ICharactersetService;
import com.taikang.iu.opt.characterset.action.ICharactersetAction;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.iu.opt.fixed.service.IfixedService;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.service.IFileloadService;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;

import org.springframework.stereotype.Service;

/**
  * CharactersetAction
  */
  @Service(ICharactersetAction.ACTION_ID)
public  class CharactersetActionImpl extends BaseActionImpl 
  implements ICharactersetAction {

    /**
      * 注入service
      */
    @Resource(name=ICharactersetService.SERVICE_ID)
	private ICharactersetService<CharactersetBO> charactersetService;	
	
	@Resource(name = IFileloadService.SERVICE_ID)
	private IFileloadService fileloadService;
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======CharactersetAction--addCharacterset======>");
		param.put("mealCode", "GX"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("MEAL_CODE").nextId());
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class, param);
		charactersetService.insertObject(charactersetBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======CharactersetAction--updateCharacterset======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.updateObject(charactersetBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======CharactersetAction--deleteCharacterset======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.deleteObject(charactersetBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======CharactersetAction--findOneCharacterset======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		return charactersetService.findOne(charactersetBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======CharactersetAction--findAllCharacterset======>");
				
		return charactersetService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======CharactersetAction--queryCharactersetForPage======>");
		
		return charactersetService.queryForPage(currentPage);
	}	
	
	/**
	 * 分页查询环节数据
	 */
	public CurrentPage queryForLinkPage(CurrentPage page) {
		logger.debug("<======CharactersetAction--queryCharactersetForPage======>");
		
		return charactersetService.queryForLinkPage(page);
	}

	public void deleteLink(Dto param) {
		logger.debug("<======CharactersetAction--deleteLink======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.deleteLink(charactersetBO);
		
	}

	public List<CharactersetBO> findAllServerService(Dto param) {
		CharactersetBO chacter = BaseDto.toModel(CharactersetBO.class , param);
		return charactersetService.findAllServerService(chacter);
	}
//环节修改查询
	public Dto findOneLink(Dto param) {
	logger.debug("<=！====CharactersetAction--findOneLink======>");
		
	CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		return charactersetService.findOneLink(charactersetBO).toDto();//返回的BO对象自动转换成Dto返回
	}
//新增环节
	public void insertLink(Dto param) {
		logger.debug("<======CharactersetAction--insertLink======>");
		param.put("linkCode","GH"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("LINK_CODE").nextId()); 
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.insertLink(charactersetBO);
	}
//修改环节
	public void updateLink(Dto param) {
		logger.debug("<======CharactersetAction--updateCharacterset======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.updateLink(charactersetBO);
	}
//分页查询用品数据
	public CurrentPage queryForAppliancePage(CurrentPage page) {
		logger.debug("<======CharactersetAction--queryForAppliancePage======>");
		
		return charactersetService.queryForAppliancePage(page);
	}

	public List<CharactersetBO> findAllAppliance(Dto param) {
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		return charactersetService.findAllAppliance(charactersetBO);
	}
//删除用品
	public void delAppliance(Dto param) {
		logger.debug("<======CharactersetAction--delAppliance======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.delAppliance(charactersetBO);
		
	}
//展示选中物品
	public CurrentPage queryForShowAppliancePage(CurrentPage page) {
		logger.debug("<======CharactersetAction--queryForShowAppliancePage======>");
		
		return charactersetService.queryForShowAppliancePage(page);
	}
//添加用品
	public void insertLinkServer(Dto param) {
		logger.debug("<======CharactersetAction--insertLinkServer======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.insertLinkServer(charactersetBO);
		
	}
//添加服务
	public void insertServer(Dto param) {
		logger.debug("<======CharactersetAction--insertServer======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.insertServer(charactersetBO);
		
	}
//查看环节下服务
	public List<CharactersetBO> findCharactersetService(Dto param) {
         logger.debug("<======CharactersetAction--findCharactersetService======>");
		
         CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		return charactersetService.findCharactersetService(CharactersetBO);
	}
//删除环节下服务
	public void delCharactersetService(Dto param) {
		logger.debug("<======CharactersetAction--delCharactersetService======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.delCharactersetService(charactersetBO);
	}

	public void updateServer(Dto param) {
		logger.debug("<======CharactersetAction--updateServer======>");
		
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		charactersetService.updateServer(charactersetBO);
	}
//查询环节下服务
	public List<CharactersetBO> findOneServerService(Dto param) {
		CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
		return  charactersetService.findOneServerService(charactersetBO);
	}
//分页查询服务列表
	public CurrentPage queryForServicePage(CurrentPage page) {
	logger.debug("<======CharactersetAction--queryForServicePage======>");
		
		return charactersetService.queryForServicePage(page);
	}
//显示环节下服务
	public CurrentPage findOneService(CurrentPage page) {
		logger.debug("<======CharactersetAction--queryCharactersetForPage======>");
		
		return charactersetService.findOneService(page);
	}

public List<CharactersetBO> findLink(Dto param) {
	CharactersetBO charactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findLink(charactersetBO);
}

public CurrentPage findEditLinkPage(CurrentPage page) {
	logger.debug("<======CharactersetAction--findEditLinkPage======>");
	
	return charactersetService.findEditLinkPage(page);
}

public List<CharactersetBO> findEditMealList(Dto param) {
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findEditMealList(CharactersetBO);
}

public Dto findOneMeal(Dto param) {
	logger.debug("<======CharactersetAction--findOneMeal======>");
	
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findOneMeal(CharactersetBO).toDto();//返回的BO对象自动转换成Dto返回
}

public List<CharactersetBO> findEditMealCheckList(Dto param) {
	logger.debug("<======CharactersetAction--findEditMealCheckList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findEditMealCheckList(CharactersetBO);
}

public List<CharactersetBO> findApplianceList(Dto params) {
	logger.debug("<======CharactersetAction--findApplianceList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , params);
	return charactersetService.findApplianceList(CharactersetBO);
}

public List<CharactersetBO> findDelLink(Dto param) {
	logger.debug("<======CharactersetAction--findApplianceList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findDelLink(CharactersetBO);
}

public List<CharactersetBO> findDelLinks(Dto param) {
	logger.debug("<======CharactersetAction--findApplianceList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findDelLinks(CharactersetBO);
}

public void delApplianceLink(Dto param) {
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	charactersetService.delApplianceLink(CharactersetBO);
	
}

public List<CharactersetBO> findRelation(Dto param) {
	logger.debug("<======CharactersetAction--findApplianceList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findRelation(CharactersetBO);
}

public void updateAppliance(Dto params) {
	logger.debug("<======CharactersetAction--updateCharacterset======>");
	
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , params);
	charactersetService.updateAppliance(CharactersetBO);
	
}

public List<CharactersetBO> findApplianceLists(Dto params) {
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , params);
	return charactersetService.findApplianceLists(CharactersetBO);
}

public CurrentPage findOneServices(CurrentPage page) {
	logger.debug("<======CharactersetAction--findOneServices======>");
	return charactersetService.findOneServices(page);
}
/**
 * 查询个性化用品服务ID为空的数据
 */
public List<Dto> FindapplianceByServerIdIsNull(Dto param){
	logger.debug("<======CharactersetServiceImpl--findApplianceLists1======>");		
	return charactersetService.FindapplianceByServerIdIsNull(param);
}

public List<CharactersetBO> findChacterAppliacnce(Dto param) {
	CharactersetBO chacter = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findChacterAppliacnce(chacter);	
}

public void delService(Dto params) {
	
	logger.debug("<======CharactersetAction--delService======>");
	
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , params);
	charactersetService.delService(CharactersetBO);
	
}

public List<CharactersetBO> searchAppliance(Dto applianceParam) {
	logger.debug("<======CharactersetAction--searchAppliance======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , applianceParam);
	return charactersetService.searchAppliance(CharactersetBO);
}

public List<CharactersetBO> searchOneService(Dto param) {
	logger.debug("<======CharactersetAction--searchOneService======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.searchOneService(CharactersetBO);
}

public List<CharactersetBO> findApplianceRelation(Dto param) {
	logger.debug("<======CharactersetAction--findApplianceRelation======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findApplianceRelation(CharactersetBO);
}

public List<CharactersetBO> findApplianList(Dto param) {
	logger.debug("<======CharactersetAction--findApplianList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findApplianList(CharactersetBO);
}

public List<CharactersetBO> searchOneAppliance(Dto appliancParam) {
	logger.debug("<======CharactersetAction--searchOneAppliance======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , appliancParam);
	return charactersetService.searchOneAppliance(CharactersetBO);
}

public List<CharactersetBO> searchOnesService(Dto servicearam) {
	logger.debug("<======CharactersetAction--searchOnesService======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , servicearam);
	return charactersetService.searchOnesService(CharactersetBO);
}

public List<CharactersetBO> findOneLinkService(Dto serParam) {
	logger.debug("<======CharactersetAction--findOneLinkService======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , serParam);
	return charactersetService.findOneLinkService(CharactersetBO);
}

public String uploadBySpringGrpFixed(HttpServletRequest request) {
	Map<String, String> map = new HashMap<String, String>();
	Dto param = new BaseDto();
	String pictureUrl = null;
	String upLoadPath = CommonUtil.uploadFilePath();
	String mealId = request.getParameter("mealId");
	try {
		pictureUrl = fileloadService.uploadBySpringGrpFixed(request,upLoadPath,"character","");
	} catch (TKCheckedException e) {
	}
	if(mealId != null && !"".equals(mealId)){
		if(pictureUrl!=null && !"".equals(pictureUrl)){
			param.put("mealId", mealId);
			param.put("mealPicture", pictureUrl);
			
			CharactersetBO filePath = BaseDto.toModel(CharactersetBO.class , param);
			charactersetService.updateObject(filePath);
		
			return pictureUrl;
		}
	}
	return pictureUrl;
}

public List<CharactersetBO> findDelApplianceList(Dto serverParam) {
	logger.debug("<======CharactersetAction--findDelApplianceList======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , serverParam);
	return charactersetService.findDelApplianceList(CharactersetBO);
}

public List<CharactersetBO> findUpdateRelation(Dto param) {
	logger.debug("<======CharactersetAction--findUpdateRelation======>");
	CharactersetBO CharactersetBO = BaseDto.toModel(CharactersetBO.class , param);
	return charactersetService.findUpdateRelation(CharactersetBO);
}


}
