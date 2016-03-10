package com.taikang.iu.opt.worksheet.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.com.ExcelUtil;
import com.taikang.iu.com.SMSUtil;
import com.taikang.iu.opt.clue.action.IClueAction;
import com.taikang.iu.opt.employee.action.IEmployeeAction;
import com.taikang.iu.opt.employee.model.EmployeeBO;
import com.taikang.iu.opt.seller.model.SellerBO;
import com.taikang.iu.opt.worksheet.action.IWorksheetAction;
import com.taikang.iu.opt.worksheet.model.WorksheetBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IUserAction;
import com.taikang.udp.sys.action.IUserRoleAction;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * WorksheetController
  */
@Controller("worksheetController")
@RequestMapping(value="/worksheet")
public class WorksheetController  extends BaseController  {
		
	@Resource(name=IWorksheetAction.ACTION_ID)
	private IWorksheetAction worksheetAction;
	//线索表
	@Resource(name=IClueAction.ACTION_ID)
	private IClueAction clueAction;
	//用户表
	@Resource(name=IUserAction.ACTION_ID)
	private IUserAction userAction;
	//员工表
	@Resource(name=IEmployeeAction.ACTION_ID)
	private IEmployeeAction employeeAction;
	//用户角色表
	@Resource(name=IUserRoleAction.ACTION_ID)
	private IUserRoleAction userRoleAction;
	/**
	 * 派工单的页面
	 */
	@RequestMapping("/worksheetClue")
	public String showWorksheetIndexPageN() {
		return "worksheet/wclueIndex"; 
	}
	/**
	 * 派工单线索查询信息列表
	 * @return 分页列表数据
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/clueList")
	@ResponseBody
	public Map<String,Object> getClueList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		String roleId = role();
		CurrentPage currentPage = new CurrentPage();
		//运营经理的角色(roleID =2104),可以看到所有站点
		if(roleId.equals("success")){
			page.setParamObject(getParamAsDto(request));
			currentPage = clueAction.cluequeryForPage(page);
		}else{
			String site = siteT();
			Dto  clue = getParamAsDto(request);
			clue.put("site", site);
			page.setParamObject(clue);
			currentPage = clueAction.cluequeryForPageT(page);
			
		}
		//创建人，通过查询user表，把userName 传给CREATED_BY
		List<Dto> clueList =  new LinkedList<Dto>();
		clueList = currentPage.getPageItems();
		
		for (int i = 0; i < clueList.size(); i++) {
			Dto clueBO = new BaseDto();
			 clueBO =   clueList.get(i);
			 if(clueBO.get("CREATED_BY") != null){
				 if(!clueBO.get("CREATED_BY").equals("客户发起")){
					 
					 Dto user = new BaseDto();
					 user.put("userId", clueBO.get("CREATED_BY"));
					 Dto userOne = userAction.findOne(user);
					 clueBO.put("CREATED_BY", userOne.get("userName"));
				 }
			 }

			 if(clueBO.get("CONFIRM_BY") != null){//页面显示修改人
				 Dto employeeName = new BaseDto();
				 employeeName.put("userId", clueBO.get("CONFIRM_BY"));
				 Dto employeeOne = employeeAction.findOne(employeeName);
				 clueBO.put("CONFIRM_BY", employeeOne.get("employeeName"));
			 }
		}
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**
	 * 坐席打开的页面
	 * @return 页面地址
	 */
	@RequestMapping("/worksheetIndexNew")
	public String showWorksheetIndexNewPage() {
		return "worksheet/worksheetIndexNew"; 
	}
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showWorksheetIndexPage() {
		return "worksheet/worksheetIndex"; 
	}
	
	/**
	 * 根据当前用户id跟运营角色roleid = "2014"
	 * 判断当前登录人是否是运营经理
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String role(){
		//当前登录用户id
		LoginUser userT = UserUtils.getUser();
		String loginId = String.valueOf(userT.getUserId());
		String flag = "";
		//根据userId，获取角色
		Dto param = new BaseDto();
		param.put("userId",loginId);
		param.put("roleId","2104");
		Dto userRole = userRoleAction.findOne(param);
		if(userRole.isEmpty()){//不是运营经理 
			flag = "fail";
		}else{
			flag = "success";
		}
		return flag;
	}
	
	/**
	 * 获取当前登录用户的站点
	 */
	
	public String siteT(){
		//当前登录用户id
			LoginUser userT = UserUtils.getUser();
			String loginId = String.valueOf(userT.getUserId());
			
			Dto param = new BaseDto();
			param.put("userId",loginId);
			
			Dto employee = employeeAction.findOne(param);
			String site = employee.getAsString("site");
			return site;
	} 
	/**
	 * 坐席   工单查看
	 * @param request
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/listT")
	@ResponseBody
	public Map<String,Object> getWorksheetListT(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = worksheetAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
		
	}
	/**
	 * 工单查询信息列表
	 * @return 分页列表数据
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getWorksheetList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		String roleId = role();
		CurrentPage currentPage = new CurrentPage();
		//运营经理的角色(roleID =2104),可以看到所有站点
		if(roleId.equals("success")){
			page.setParamObject(getParamAsDto(request));
			currentPage = worksheetAction.queryForPage(page);

		}else{
			String site = siteT();
			Dto  workSheet = getParamAsDto(request);
			workSheet.put("site", site);
			page.setParamObject(workSheet);
			currentPage = worksheetAction.queryForPageT(page);
			
		}
		
		//创建人，通过查询user表，把userName 传给CREATED_BY
				List<Dto> worksheetList =  new LinkedList<Dto>();
				worksheetList = currentPage.getPageItems();
				for (int i = 0; i < worksheetList.size(); i++) {
					Dto clueBO = new BaseDto();
					 clueBO =   worksheetList.get(i);
					 
					 if(clueBO.get("CREATED_BY") != null){
						 String clue =  clueBO.get("CREATED_BY").toString();
						 if(clue.getBytes().length == clue.length()){//没有汉字
							 
							 if(!clueBO.get("CREATED_BY").equals("客户发起")){
								 
								 Dto user = new BaseDto();
								 user.put("userId", clueBO.get("CREATED_BY"));
								 Dto userOne = userAction.findOne(user);
								 clueBO.put("CREATED_BY", userOne.get("userName"));
							 }
						 }
					 }
				}
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String showWorksheetEditPage(String worksheetId,Model model) {
		
		if(worksheetId!=null && !worksheetId.equals(""))
		{
			model.addAttribute("worksheetId",worksheetId );
		}
		
		return "worksheet/worksheetEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getWorksheetById(@RequestParam("worksheetId")String worksheetId)
	{
		Dto param = new BaseDto();
		param.put("worksheetId", worksheetId);
		return worksheetAction.findOne(param);
	}
	/**弹出框输入天使信息
	 * 
	 * @param clueId
	 * @param model
	 * @return
	 */
	@RequestMapping("wedit")
	public String showClueEditPage1(String clueId,Model model) {
		
		if(clueId!=null && !clueId.equals(""))
		{
			model.addAttribute("clueId",clueId );
		}
		
		return "worksheet/wclueEdit"; 
	}
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@RequestMapping("/view")
	public String showWorksheetViewPage(String worksheetId,Model model) {
		
		if(worksheetId!=null && !worksheetId.equals(""))
		{
			model.addAttribute("worksheetId",worksheetId );
		}
		
		return "worksheet/worksheetView"; 
	}
	
	/**
	*
	*派工单
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/weditSave")
	@ResponseBody
	public Map<String, String>  worksheetEdite(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Dto paramNew = getParamAsDto(request);
		int clueSate = Integer.parseInt(paramNew.get("clueState").toString());
		if( clueSate == 3){
			map.put(RTN_RESULT, "true");
			map.put(MESSAGE_INFO, "线索已派工单！");
		}else{
		Dto param = new BaseDto();
		param.put("clueId", paramNew.get("clueId"));
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);	
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("clueState", "3"); //clueState "0"，代表未确认，"1"代表确认有效，"2"代表确认无效,"3"代表已派工单
		param.put("version", Integer.parseInt(paramNew.get("version").toString())+1);
		clueAction.updateObject(param);
		//根据clueId 查询工单
		
			if(!paramNew.get("clueId").equals("")){
				Dto worksheet = new BaseDto();
				String worksheetCode = "GD"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("WORKSHEET_CODE").nextId();
				if(worksheet.get("worksheetId") == null || "".equals(worksheet.get("worksheetId"))){
					worksheet.put("worksheetId", UUID.randomUUID().toString().replace("-", ""));
					worksheet.put("worksheetCode", worksheetCode);
					worksheet.put("worksheetState", "0");
					worksheet.put("angelCode", paramNew.get("angelCode"));//天使编号
					worksheet.put("angelName", paramNew.get("angelName")); //天使姓名
					worksheet.put("angelTel", paramNew.get("angelTel"));//天使电话
					
					
					//线索的数据
					worksheet.put("clueId", paramNew.get("clueId"));
					worksheet.put("clueCode", paramNew.get("clueCode"));
					worksheet.put("customId", paramNew.get("customId"));
					worksheet.put("customName", paramNew.get("customName"));
					worksheet.put("customSex", paramNew.get("customSex"));
					worksheet.put("customTel", paramNew.get("customTel"));
					worksheet.put("customAddress", paramNew.get("customAddress"));
					worksheet.put("customRequire", paramNew.get("customRequire"));
					worksheet.put("doorTime", paramNew.get("doorTime"));
					worksheet.put("invalidReason", paramNew.get("invalidReason"));
					worksheet.put("proxyTel", paramNew.get("proxyTel"));
					worksheet.put("remark", paramNew.get("remark"));
					worksheet.put("site", paramNew.get("site"));
					//常用的数据
					worksheet.put("createdBy", loginId);
					worksheet.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
					worksheet.put("delflag", "0"); // “0”代表“未删除”
					worksheet.put("version", 1);
					
					worksheetAction.insertObject(worksheet);
					
					/**
					 * 发送短信通知天使 业务类型:TOABI
					 */
					
//					EmployeeBO  listDto = new EmployeeBO();
//					List<EmployeeBO>  listCustomTel = worksheetAction.findCustomTel(listDto);
//					for (int i = 0; i < listCustomTel.size(); i++) {
						
//						String phoneNo = listCustomTel.get(i).getEmployeeTel();
						// 接收人的电话号码
						String phoneNo = paramNew.get("angelTel").toString();
						String content = "[爱佑汇]请留意，您获得一个新的派工单:"+worksheetCode.toString()+"。请尽快查看和处理。";
						// 业务类型
						String businessType = SMSUtil.BUSINESS_TYPE_TOABI;
						
						System.out.println("mh"+phoneNo+content+businessType);

						// 发送短信
						String result = SMSUtil.sendSMS(phoneNo, content, businessType);
						logger.info("***********"+result);
//					}
				}
			}
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		
		
		}
		return map;
	}
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveWorksheetInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		
		Dto param = getParamAsDto(request);
		if(param.get("worksheetId") ==null ||"".equals(param.get("worksheetId")))
		{
//			param.put("clueId",param.get("clueId"));
//			param.put("angelName",param.get("angelName"));
//			param.put("angelTel",param.get("angelTel"));
			param.put("worksheetId", UUID.randomUUID().toString().replace("-", ""));
//			param.put("angelCode", "GD"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("ANGELCODE").nextId());
			param.put("worksheetCode", "GD"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("WORKSHEET_CODE").nextId());
			param.put("worksheetState", "1"); // “1”代表“使用中”
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			worksheetAction.insertObject(param);
			
			map.put(MESSAGE_INFO, "添加成功！");
			
		}
		else
		{
			param.put("angelName",param.get("angelName"));
			param.put("angelTel",param.get("angelTel"));
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			worksheetAction.updateObject(param);
			map.put(MESSAGE_INFO, "修改成功！");
		}
		map.put(RTN_RESULT, "true");
		showWorksheetIndexPage();
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteWorksheet(@RequestParam("worksheetId") String worksheetId, @RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("worksheetId", worksheetId);
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("delflag", "1"); // “1”代表“已删除”
		param.put("version", Integer.parseInt(version)+1);
		worksheetAction.updateObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	*未成单处理
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/delwork")
	@ResponseBody
	public Map<String, String> delwork(@RequestParam("worksheetId") String worksheetId, @RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("worksheetId", worksheetId);
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("worksheetState", "2"); // “2”代表“未成单”
		param.put("version", Integer.parseInt(version)+1);
		worksheetAction.updateObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	/**
	 * 获取员工天使的信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getAngelList")
	@ResponseBody
	public List getAngel()
	{
		String site = siteT();//当前登录人站点
		Dto tmpDto = new BaseDto();
		Dto param = new BaseDto();
		String fl = role();//判断登录人 是否是运营经理
		List<EmployeeBO> getAngelList = new ArrayList<EmployeeBO>();
		if(fl.equals("fail")){//不是运营经理
			param.put("site", site);
			getAngelList = employeeAction.finAllEmpTS(param);
		}else{
			getAngelList = employeeAction.finAllEmpT(param);
		}
		
		List<Dto> listDto = new ArrayList<Dto>();
		for (EmployeeBO employeeBO : getAngelList) {
			tmpDto = new BaseDto();
			tmpDto.put("angelCode", employeeBO.getEmployeeCode());
			tmpDto.put("angelName", employeeBO.getEmployeeName());
			tmpDto.put("angelTel", employeeBO.getEmployeeTel());
			
			listDto.add(tmpDto);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", listDto);
		return listDto;
	}
	/**
	 * 导出excel
	 * @return
	 */
	  @RequestMapping(value="downloadSeller")
	    public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{
	        String fileName="工单管理";
	        request.setCharacterEncoding("utf-8");
	        String worksheetCode =request.getParameter("worksheetCode");
	        String customName =request.getParameter("customName");
	        String createdTime =request.getParameter("createdTime");
	        String createdTime1 =request.getParameter("createdTime1");
	        String customTel =request.getParameter("customTel");
	        String angelName =request.getParameter("angelName");
	        String worksheetState =request.getParameter("worksheetState");

	        //填充projects数据
	        List<Dto> projects=createData(worksheetCode,customName,createdTime,createdTime1,customTel,angelName,worksheetState);
	        List<Map<String,Object>> list=createExcelRecord(projects);
	        String columnNames[]={"工单编号","客户姓名","客户电话","天使姓名","天使电话","代理人电话","创建时间","工单状态"};//列名
	        String keys[]   =    {"worksheetCode","customName","customTel","angelTel","angelName","proxyTel","createdTime","worksheetState"};//map中的key
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        try {
	            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);
	        // 设置response参数，可以打开下载页面
	        response.reset();
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	        ServletOutputStream out = response.getOutputStream();
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        try {
	            bis = new BufferedInputStream(is);
	            bos = new BufferedOutputStream(out);
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (final IOException e) {
	            throw e;
	        } finally {
	            if (bis != null)
	                bis.close();
	            if (bos != null)
	                bos.close();
	        }
	        return null;
	    }
	  /**
	   * 查询出符合条件的数据列表
	   * @param worksheetCode
	   * @param customName
	   * @param customTel
	   * @param angelTel
	   * @param angelName
	   * @param proxyTel
	   * @param createdTime
	   * @param worksheetState
	   * @return
	   */
	    @SuppressWarnings("unchecked")
		private List<Dto> createData(String worksheetCode,String customName,String createdTime,String createdTime1,String customTel,String angelName,String worksheetState) {
	    	Dto param = new BaseDto();
	    	List<Dto> list = new ArrayList<Dto>();
	    	
	    	if(!worksheetCode.isEmpty()){
	    		param.put("worksheetCode", worksheetCode);
	    	}
	    	if(!customName.isEmpty()){
	    		param.put("customName", customName);
	    	}
	    	if(!createdTime.isEmpty()){
	    		param.put("createdTime", createdTime);
	    	}
	    	if(!createdTime1.isEmpty()){
	    		param.put("createdTime1", createdTime1);
	    	}
	    	if(!customTel.isEmpty()){
	    		param.put("customTel", customTel);
	    	}
	    	if(!angelName.isEmpty()){
	    		param.put("angelName", angelName);
	    	}
	    	if(!worksheetState.isEmpty()){
	    		param.put("worksheetState", worksheetState);
	    	}
	    	String roleId = role();
			//运营经理的角色(roleID =2104),可以看到所有站点
			if(roleId.equals("success")){
		    	 list = worksheetAction.findAllWorksheet(param);
			}else{
				String site = siteT();
				param.put("site", site);
		    	 list = worksheetAction.findAllWorksheet(param);
				
			}
			
	        return list;
	    }
	    /**
	     * 填充到excl的数据字段
	     * @param projects
	     * @return
	     */
	    private List<Map<String, Object>> createExcelRecord(List<Dto> projects) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        Dto workSheetBO=null;
	        for (int j = 0; j < projects.size(); j++) {
	        	workSheetBO=projects.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("worksheetCode", workSheetBO.get("WORKSHEET_CODE"));
	            mapValue.put("customName", workSheetBO.get("CUSTOM_NAME"));
	            mapValue.put("customTel", workSheetBO.get("CUSTOM_TEL"));
	            mapValue.put("angelTel",  workSheetBO.get("ANGEL_TEL"));
	            mapValue.put("angelName",workSheetBO.get("ANGEL_NAME"));
	            mapValue.put("proxyTel",workSheetBO.get("PROXY_TEL"));
	            mapValue.put("createdTime",workSheetBO.get("CREATED_TIME").toString().substring(0, 19));
	           if(workSheetBO.get("WORKSHEET_STATE").equals("0")){
	        	   
	        	   mapValue.put("worksheetState","未处理");
	           }else if(workSheetBO.get("WORKSHEET_STATE").equals("1")){
	        	   
	        	   mapValue.put("worksheetState","已成单");
	           }else if(workSheetBO.get("WORKSHEET_STATE").equals("2")){
	        	   
	        	   mapValue.put("worksheetState","未成单");
	           }
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }
	    
}

