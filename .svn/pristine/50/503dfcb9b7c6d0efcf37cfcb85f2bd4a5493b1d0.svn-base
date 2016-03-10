package com.taikang.iu.opt.finance.account.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.taikang.iu.opt.finance.account.action.IFinanceAction;
import com.taikang.iu.opt.finance.account.model.FinanceBO;
import com.taikang.iu.opt.seller.model.SellerBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * FinanceController
  */
@Controller("financeController")
@RequestMapping(value="/finance")
public class FinanceController  extends BaseController  {
		
	@Resource(name=IFinanceAction.ACTION_ID)
	private IFinanceAction financeAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showFinanceIndexPage(Model model) {
//		Dto param=new BaseDto();
//		List<Dto> list=financeAction.findAll(param);
//		if(list.get(0)==null||"".equals(list.get(0)))
//		{			
//			model.addAttribute("countPrice","0");
//		}
//		else
//		{
//			model.addAttribute("countPrice",list.get(0).get("countPrice"));
//		}
		return "finance/financeIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getFinanceList(HttpServletRequest request,CurrentPage page,Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = financeAction.queryForPage(page);
	
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 导出财务报表
	 * @author t-lilong
	 * @Credited 2015年7月27日 上午11:18:56
	 * @return
	 */
	  @RequestMapping(value="/downloadFinance")
	    public String download(HttpServletRequest request,HttpServletResponse response ) throws IOException{
	        String fileName="excel";
	        request.setCharacterEncoding("UTF-8");
	        String payTime =request.getParameter("payTime");
	        String payTime1 =request.getParameter("payTime1");
	        String payMethod =request.getParameter("payMethod");
	        String angelName =request.getParameter("angelName");
	        //填充projects数据
	        List<FinanceBO> projects=createData(payTime,payTime1,payMethod,angelName);
	        List<Map<String,Object>> list=createExcelRecord(projects);
	        String columnNames[]={"主订单编号","支付时间","支付方式","订单金额","流水号","银行账号","天使姓名","到账状态"};//列
	        String keys[]   =    {"orderCode","payTime","payMethod","orderPrice","serialno","bankAccount","angelName","accountState"};//map中的key
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
	  
	    private List<FinanceBO> createData(String payTime,String payTime1,String payMethod,String angelName) {
	    	Dto param = new BaseDto();
	    	if(payTime != null){
	    		param.put("payTime", payTime);
	    	}
	    	if(payTime1 != null){
	    		param.put("payTime1", payTime1);
	    	}
	    	if(payMethod != null){
	    		param.put("payMethod", payMethod);
	    	}
	    	if(angelName != null){
	    		param.put("angelName", angelName);
	    	}
	    	param.put("delflag", "0");
	    	List <FinanceBO> list = financeAction.findAllFinance(param);
	        return list;
	    }
	    private List<Map<String, Object>> createExcelRecord(List<FinanceBO> projects) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        FinanceBO financeBO=null;
	        for (int j = 0; j < projects.size(); j++) {
	        	financeBO=projects.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("orderCode", financeBO.getOrderCode());
	            mapValue.put("payTime", financeBO.getPayTime());
	            mapValue.put("payMethod", financeBO.getPayMethod());
	            mapValue.put("orderPrice", financeBO.getOrderPrice());
	            mapValue.put("serialno", financeBO.getSerialno());
	            mapValue.put("bankAccount", financeBO.getBankAccount());
	            mapValue.put("angelName", financeBO.getAngelName());
	            mapValue.put("accountState", financeBO.getAccountState());
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }
	@RequestMapping("/sumFinanceAccount")
	@ResponseBody
	 public Dto sumFinanceAccount(String payTime,String payTime1,String payMethod, String angelName){
		Dto param=new BaseDto();
		param.put("payTime", payTime);
		param.put("payTime1", payTime1);
		param.put("payMethod", payMethod);
		if(angelName != null ){
		angelName=URLDecoder.decode(URLDecoder.decode(angelName));
		}
		param.put("angelName", angelName);
		List<Dto> list=financeAction.findAll(param);
		if(list.get(0) == null){
			Dto cPrice = new BaseDto();
			cPrice.put("countPrice", "0.00");
			return cPrice;
		}else{
			return list.get(0);
		}
	}
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showFinanceEditPage(String rowId,Model model) {
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "finance/financeEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getFinanceById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return financeAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveFinanceInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			financeAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			financeAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteFinance(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		financeAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 修改对账状态为已到账
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="ok")
	@ResponseBody
	public Map<String,String> ok(String orderId)
	{
		System.out.println(orderId);
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("orderId", orderId);
		param.put("accountState", "1");
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		Dto versionParam = new BaseDto();
		versionParam.put("orderId", orderId);
		Dto versionResult = financeAction.findOne(versionParam);
		int version = 1;
		
		// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
		if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
			version = 2;
		}else {
			version = Integer.parseInt(versionResult.get("version").toString())+1;
		}
		
		param.put("version", version);
		financeAction.updateObject(param);
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		return map;
	}
	
	/**
	 * 修改对账状态为未到账
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="ok1")
	@ResponseBody
	public Map<String,String> ok1(String orderId)
	{
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("orderId", orderId);
		param.put("accountState", "0");
		
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		Dto versionParam = new BaseDto();
		versionParam.put("orderId", orderId);
		Dto versionResult = financeAction.findOne(versionParam);
		int version = 1;
		
		// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
		if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
			version = 2;
		}else {
			version = Integer.parseInt(versionResult.get("version").toString())+1;
		}
		
		param.put("version", version);
		financeAction.updateObject(param);
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		return map;
	}
	
	
	/**
	 * 修改对账状态为作废
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="ok2")
	@ResponseBody
	public Map<String,String> ok2(String orderId)
	{
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("orderId", orderId);
		param.put("accountState", "2");
		
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		Dto versionParam = new BaseDto();
		versionParam.put("orderId", orderId);
		Dto versionResult = financeAction.findOne(versionParam);
		int version = 1;
		
		// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
		if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
			version = 2;
		}else {
			version = Integer.parseInt(versionResult.get("version").toString())+1;
		}
		
		param.put("version", version);
		financeAction.updateObject(param);
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		return map;
	}
}

