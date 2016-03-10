package com.taikang.iu.opt.test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.com.ExcelUtil;
import com.taikang.iu.opt.order.model.OrderBO;
import com.taikang.iu.opt.test.action.ITestAction;
import com.taikang.iu.opt.test.model.TestBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Arrays;

/**
 * TestController
 */
@Controller("testController")
@RequestMapping(value = "/test")
public class TestController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	@Resource(name = ITestAction.ACTION_ID)
	private ITestAction testAction;

	/**
	 * 打开主查询页面
	 * 
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showTestIndexPage() {
		return "test/testIndex";
	}

	/**
	 * 查询信息列表
	 * 
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> getTestList(HttpServletRequest request,
			CurrentPage page) {
		Map<String, Object> map = new HashMap<String, Object>();

		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = testAction.queryForPage(page);
		//ReflectionToStringBuilder.toString(course);
		map.put("rows", currentPage.getPageItems());
		
		map.put("total", currentPage.getTotalRows());

		return map;
	}

	/**
	 * 打开新增或修改页面
	 * 
	 * @return
	 */
	@RequestMapping("edit")
	public String showTestEditPage(String rowId, Model model) {

		if (rowId != null && !rowId.equals("")) {
			model.addAttribute("rowId", rowId);
		}

		return "test/testEdit";
	}

	/**
	 * 打开新增页面
	 * 
	 * @return
	 */
	@RequestMapping("add")
	public String showCemeteryAddPage(String SERIAL_ID, Model model) {

		if (SERIAL_ID != null && !SERIAL_ID.equals("")) {
			model.addAttribute("SERIAL_ID", SERIAL_ID);
		}

		return "test/testAdd";
	}

	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * 
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getTestById(@RequestParam("rowId") String rowId) {
		Dto param = new BaseDto();
		param.put("serialId", rowId);
		return testAction.findOne(param);
	}
	
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@RequestMapping("/view")
	public String showTestViewPage(String serialId,Model model) {
		
		if(serialId!=null && !serialId.equals(""))
		{
			model.addAttribute("serialId",serialId );
		}
		
		return "test/testView"; 
	}
	
	/**
	 * 保存新增
	 * //@RequestParam("file") MultipartFile file,HttpServletRequest request,MultipartHttpServletRequest request
	 * @return
	 */
	@RequestMapping("/saveNew")
	@ResponseBody
	private Map<String, String> saveNewTestInfo(MultipartHttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;   
		
        MultipartFile file = multipartRequest.getFile("file"); 
        MultipartFile image = multipartRequest.getFile("image");
        String filename = file.getOriginalFilename();
        String imagename=image.getOriginalFilename();
        String upLoadPath = CommonUtil.uploadFilePath();
        System.out.println(filename);   
        String name=request.getParameter("serialId");  //用于用户验证
        String pwd=request.getParameter("num");
        if(!file.isEmpty()){
        	/* //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中*/ 
        	String realPath = request.getSession().getServletContext().getRealPath("/static/upload");  
			log.debug("Process file: {}", file.getOriginalFilename());
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(upLoadPath, System.currentTimeMillis()+ filename));
				String child = System.currentTimeMillis()+ imagename;
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(upLoadPath, child));
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, child));
				log.debug("上传在tomacat下的文件 Process file: {}", child);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Dto param = getParamAsDto(request);

		testAction.insertObject(param);
//		log.debug("Process file: {}", file.getOriginalFilename());
//		try {
//			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\temp\\imooc\\", System.currentTimeMillis()+ file.getOriginalFilename()));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		map.put(MESSAGE_INFO, "新增成功！");

		map.put(RTN_RESULT, "true");

		return map;
	}

	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * 
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String, String> saveTestInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();

		Dto param = getParamAsDto(request);
		if (param.get("serialId") == null || "".equals(param.get("serialId"))) {
			testAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");

		} else {
			testAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");

		return map;
	}

	/**
	 * 删除一条或多条记录
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public Map<String, String> deleteTest(
			@RequestParam("serial_id") String serial_id) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("serialId", serial_id);
		testAction.deleteObject(param);

		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");

		return map;
	}
	
	/**
	 * 导出订单列表excel
	 * @author t-pengyangyang
	 * @Credited 2015年7月16日 下午4:18:17
	 * @return
	 */
	  @RequestMapping(value="downloadTest")
	    public String downloadTest(HttpServletRequest request,HttpServletResponse response,CurrentPage page) throws IOException{
		  	String fileName=""
		  			+ ""
		  			+ ""
		  			+ "excel"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "");
		  	String serialId =request.getParameter("serialId");
		  	String num =request.getParameter("num");
	        //处理中文请求内容
	        byte[] newtitle =request.getParameter("title").getBytes("iso-8859-1");
	        String title = new String(newtitle,"UTF-8");
	        byte[] newtext =request.getParameter("text").getBytes("iso-8859-1");
	        String text = new String(newtext,"UTF-8");
	        page.setParamObject(getParamAsDto(request));
	        //填充projects数据
	        List<TestBO> projects=createData(serialId,num,title,text);
	        List<Map<String,Object>> list=createExcelRecord(projects);
	        String columnNames[]={"测试序号","排序","标题","文本"};//列名
	        String keys[]   =    {"serialId","num","title","text"};//map中的key
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
	  
	    @SuppressWarnings("unchecked")
		private List<TestBO> createData(String serialId,String num,String title,String text) {
	    	Dto param = new BaseDto();
	    	if(serialId != null){
	    		param.put("serialId", serialId);
	    	}
	    	if(num != null){
	    		param.put("num", num);
	    	}
	    	if(title != null){
	    		param.put("title", title);
	    	}
	    	if(text != null){
	    		param.put("text", text);
	    	}
	    	
	    	List<TestBO> listDto = testAction.findAllTestBO(param);
	        return listDto;
	    }
	    private List<Map<String, Object>> createExcelRecord(List<TestBO> projects) {
	        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("sheetName", "sheet1");
	        listmap.add(map);
	        TestBO testBo=null;
	        for (int j = 0; j < projects.size(); j++) {
	        	testBo=projects.get(j);
	            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("serialId",testBo.getSerialId());
	            mapValue.put("num", testBo.getNum());
	            mapValue.put("title", testBo.getTitle());
	            mapValue.put("text", testBo.getText());
	           
	            listmap.add(mapValue);
	        }
	        return listmap;
	    }
	
}
