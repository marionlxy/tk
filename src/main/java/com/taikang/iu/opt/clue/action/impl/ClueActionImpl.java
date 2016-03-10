package com.taikang.iu.opt.clue.action.impl;


import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.com.CommonService;
import com.taikang.iu.com.SMSUtil;
import com.taikang.iu.opt.clue.action.IClueAction;
import com.taikang.iu.opt.clue.model.ClueBO;
import com.taikang.iu.opt.clue.service.IClueService;
import com.taikang.iu.opt.custom.action.ICustomAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.sys.action.IUserAction;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.sequence.SequenceGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;

/**
  * ClueAction
  */
  @Service(IClueAction.ACTION_ID)
public class ClueActionImpl extends BaseActionImpl  
  implements IClueAction {
	//用户表
		@Resource(name=IUserAction.ACTION_ID)
		private IUserAction userAction;
		//客户表
		@Resource(name=ICustomAction.ACTION_ID)
		private ICustomAction customAction;
    /**
      * 注入service
      */
    @Resource(name=IClueService.SERVICE_ID)
	private IClueService<ClueBO> clueService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ClueAction--addClue======>");
		
		ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
		clueService.insertObject(clueBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ClueAction--updateClue======>");
		
		ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
		clueService.updateObject(clueBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ClueAction--deleteClue======>");
		
		ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
		clueService.deleteObject(clueBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ClueAction--findOneClue======>");
		
		ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
		return clueService.findOne(clueBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ClueAction--findAllClue======>");
				
		return clueService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ClueAction--queryClueForPage======>");
		
		return clueService.queryForPage(currentPage);
	}

	public CurrentPage cluequeryForPage(CurrentPage currentPage) {
		// TODO Auto-generated method stub
		return clueService.cluequeryForPage(currentPage);
	}

	@SuppressWarnings("unchecked")
	public Dto addClueAnd(Dto param) {
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto mapImpl=new BaseDto();
//		//获取手机号,判断注册用户是否重复
		String customTel = param.get("customTel").toString();
		Dto  ClueCustomTel = new BaseDto();
		ClueCustomTel.put("customTel", customTel);
		Dto clueTel = customAction.findOne(ClueCustomTel);
		String customId = UUID.randomUUID().toString().replace("-", "");
		//随机密码
		String PWD = getValidCode(6);
		if(param.get("clueId") ==null ||"".equals(param.get("clueId"))){
						if(clueTel.isEmpty()){//客户不存在插入客户表
									Dto custom = new BaseDto();
									custom.put("loginName",param.get("customTel"));
									Dto customDto =customAction.findOne(custom);
									
									if(customDto.get("customId")== null || "".equals(customDto.get("customId")) ){
										Dto dto = new BaseDto();
										dto.put("userId", SequenceGenerator.getInstance("User_Id",1).nextId());
										dto.put("customId",  customId);
										dto.put("customAddress",param.get("customAddress"));
										dto.put("customSex",param.get("customSex"));
										dto.put("customName",param.get("customName"));
										dto.put("customTel",param.get("customTel"));
										dto.put("loginName",param.get("customTel"));//客户登录名
										try {
											dto.put("customPwd",UserUtils.entryptPassword(PWD));
										} catch (TKCheckedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}//默认密码123
										try {
											dto.put("customRepwd",UserUtils.entryptPassword(PWD));
										} catch (TKCheckedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										dto.put("modifiedBy", loginId);
										dto.put("createdBy", loginId);
										dto.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
										dto.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
										dto.put("delflag", "0"); // “0”代表“未删除”
										dto.put("version", "1");
										customAction.insertCustom(dto);//插入客户表
									
										//用户表
										Dto userDto = new BaseDto();
						
										userDto.put("userId",dto.get("userId"));
										userDto.put("userName",param.get("customName"));
										userDto.put("userCode",param.get("customTel"));
										userDto.put("userType",0);
										userDto.put("creator",loginId);
										userDto.put("createTime",TKDateTimeUtils.getTodayTimeStamp());
										userDto.put("lastModby",loginId);
										userDto.put("lastModtime",TKDateTimeUtils.getTodayTimeStamp());
										
										try {
											userDto.put("userPwd",UserUtils.entryptPassword(PWD));
										} catch (TKCheckedException e) {
											e.printStackTrace();
										}
										userAction.insertUser(userDto);
										//发送短信通知用户已注册    业务类型TOABG
										// 接收人的电话号码   每个注册的新用户
										String phoneNo = param.get("customTel").toString();
									
//										String content = "[爱佑汇] 尊敬的:"+param.get("customName").toString()+"，您已成为爱佑汇服务的用户。请您使用手机号加随机密码:"+PWD+",方式登录。登录后，请在个人中心修改登录密码并完善个人信息。感谢您对爱佑汇的信任，我们将为您提供最贴心周到的服务。";
										String content = "[爱佑汇] 尊敬的手机号码"+phoneNo+"用户，您已成功注册爱佑汇。您可以使用手机号加初始密码方式登录，初始密码是："+PWD+"。登录后，请在个人中心完善个人信息。感谢您对爱佑汇的信任，我们将为您提供最贴心周到的服务。";
										// 业务类型
										String businessType = SMSUtil.BUSINESS_TYPE_TOABG;
										System.out.println("mh"+phoneNo+content+businessType);

										// 发送短信
										String result = SMSUtil.sendSMS(phoneNo, content, businessType);
										logger.info("***********"+result);
									}
						}
						if(clueTel.isEmpty()){//如果客户不存在直接生成，新的customId
						
							param.put("clueId", UUID.randomUUID().toString().replace("-", ""));
							param.put("clueCode", "XS"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+CommonService.getBusinessSeqNextValue("CLUECODE"));
							param.put("customId",customId);
							param.put("clueState", "0"); // clueState "0"，代表未确认，"1"代表确认有效，"2"代表确认无效,"3"已派工
							param.put("site",param.get("site"));
							param.put("createdBy", loginId);
							param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
							param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());		
							param.put("modifiedBy", loginId);
							
							param.put("delflag", "0"); // “0”代表“未删除”
							param.put("version", "1");
							ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
							
							clueService.insertObject(clueBO);
							mapImpl.put("MESSAGE_INFO", "添加成功！");
						}else{//如果存在 就去客户表拿到客户的clueTel.get("customId")
							param.put("clueId", UUID.randomUUID().toString().replace("-", ""));
							param.put("clueCode", "XS"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+CommonService.getBusinessSeqNextValue("CLUECODE"));
							param.put("customId",clueTel.get("customId"));
							param.put("clueState", "0"); // clueState "0"，代表未确认，"1"代表确认有效，"2"代表确认无效,"3"已派工
							param.put("createdBy", loginId);
							param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
							param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());		
							param.put("modifiedBy", loginId);
							
							param.put("delflag", "0"); // “0”代表“未删除”
							param.put("version", "1");
							ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
							
							clueService.insertObject(clueBO);
							mapImpl.put("MESSAGE_INFO", "添加成功！");
						}
					}else
						{
							mapImpl.put("MESSAGE_INFO", "添加失败！");

				
						}
//			}else{
//				mapImpl.put("MESSAGE_INFO","用户名已存在！");
//
//			}
		return mapImpl;

	}
	/**随机6位数的密码
  	 * @param length 长度
  	 * @return
  	 * 
  	 */
  	public static String getValidCode(int length) {
  		String res = "";
  		if(length<=18&&length>0){
  			res =(Math.random()+"").substring(2, 2+length); 
  		}
  		return res; 
  	}
  	
	public List<Dto> proxyTelCheck(Dto param) {
		logger.debug("<======ClueAction--findOneClue======>");
		
		//ClueBO clueBO = BaseDto.toModel(ClueBO.class , param);
		return clueService.proxyTelCheck(param);//返回的BO对象自动转换成Dto返回
	}

	public CurrentPage cluequeryForPageT(CurrentPage page) {
		return clueService.cluequeryForPageT(page);
	}	
	
}
