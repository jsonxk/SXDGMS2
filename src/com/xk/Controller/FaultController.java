package com.xk.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xk.orm.HistoryEmail;
import com.xk.orm.LineCheck;
import com.xk.orm.PublicEntity;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月24日 下午12:37:25
 * @version :
 * 缺陷管理
 */
@Controller
@RequestMapping("/FaultMS")
public class FaultController {
	@Autowired
	private AllService allservice;
	/** 
	 * 查询缺陷状态
	 * @return
	 */
	@RequestMapping(value="/SelectFaultType",method=RequestMethod.GET)
	public @ResponseBody JSONArray SelectFaultType(){
		return allservice.getFaultBLL().SelectFaultType();
	}
	/**
	 * 查找所有缺陷信息
	 * @param publicEntity
	 * @return
	 */
	@RequestMapping(value="/selectAllFaultInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllFaultInfo(@RequestBody PublicEntity publicEntity){
		System.out.println(publicEntity.getStarttime()+publicEntity.getFinishtime()+publicEntity.getStatus()+publicEntity.getType()+"萨达萨达撒多撒");
		return allservice.getFaultBLL().SelectAllFaultInfo(publicEntity);
	}
	/**
	 * 根据poleid查找单位，搭挂线路信息
	 * @param poleid
	 * @return
	 */
	@RequestMapping(value="/faultPoleOfLine",method=RequestMethod.POST)
	public @ResponseBody JSONArray FaultPoleOfLine(@RequestParam("poleid") int poleid){
		return allservice.getFaultBLL().FaultPoleOfLine(poleid);
	}
	/**
	 * 根据checkdetailid查找缺陷图片信息
	 * @param checkdetailid
	 * @return
	 */
	@RequestMapping(value="/faultPhoto",method=RequestMethod.POST)
	public @ResponseBody JSONArray FaultPhoto(@RequestParam("checkdetailid") int checkdetailid){
		return allservice.getFaultBLL().FaultPhoto(checkdetailid);
	}
	/**
	 * 发送整改信息邮件
	 * @param checkdetailid
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/submitRepairInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SubmitRepairInfo(HttpServletRequest request,HttpServletResponse response,HistoryEmail historyEmail) throws IllegalStateException, IOException{
		String DBPath = "";
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为"",说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = file.getOriginalFilename();
						// 定义上传路径
						String path = System.getProperty("evan.webapp")
								+ File.separator + "EmailFile";
						File filepackage = new File(path);
						if (!filepackage.exists()) {
							filepackage.mkdirs();
						}
						// String path =
						// "E:"+File.separator+"test"+File.separator+ fileName;
						// String path=request.getServletPath();
						File localFile = new File(path + File.separator
								+ fileName);
						file.transferTo(localFile);
						//DBPath = "http://localhost:8080/SXDGMS2/EmailFile/"+ fileName;
						/**
						 * 文件地址
						 */
						String localpath=request.getSession().getServletContext().getRealPath("")+"\\EmailFile"+"\\"+fileName;
						//String newpath=localpath.replaceAll("\\","\\\\");
						System.out.println(localpath);
						historyEmail.setSenddocpath(localpath);
						JSONArray returnOP=allservice.getFaultBLL().SubmitRepairInfo(historyEmail); 
					}
				}
			}

		}
		try {
			responseMessage(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void responseMessage(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=" + "utf-8");
		//Writer writer = null;
		PrintWriter out = response.getWriter();
		try {
			/*writer = response.getWriter();
			writer.write("{\"code\":" + 200 + ",\"message\":\"" + "上传成功"
					+ "\"}");
			writer.flush();
			writer.close();*/
			out.print("success");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//IOUtils.closeQuietly(writer);
		}
	}
	/**
	 * 新建线路检查
	 * @param linechk
	 * @return jsonarray{"linechkid":value}
	 */
	@RequestMapping(value="/insertNewLineChk",method=RequestMethod.POST)
	public @ResponseBody JSONArray InsertNewLineChk(@RequestBody LineCheck linechk){
		return allservice.getFaultBLL().InsertNewLineChk(linechk);
	}
	/**
	 * 查找搭挂线路线杆查找类型
	 * @return{checktype}
	 */
	@RequestMapping(value="/selectLineChkType",method=RequestMethod.POST)
	public @ResponseBody JSONArray selectLineChkType(){
		return allservice.getFaultBLL().SelectLineChkType();
	}
	@RequestMapping(value="/photoUpLoad",method=RequestMethod.POST)
	public @ResponseBody JSONArray PhotoUpLoad(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		String DBPath = "";
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为"",说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = file.getOriginalFilename();
						// 定义上传路径
						String path = System.getProperty("evan.webapp")
								+ File.separator + "PhotoImg";
						File filepackage = new File(path);
						if (!filepackage.exists()) {
							filepackage.mkdirs();
						}
						// String path =
						// "E:"+File.separator+"test"+File.separator+ fileName;
						// String path=request.getServletPath();
						File localFile = new File(path + File.separator
								+ fileName);
						file.transferTo(localFile);
						//DBPath = "http://localhost:8080/SXDGMS2/EmailFile/"+ fileName;
						/**
						 * 文件地址
						 */
						String localpath=request.getSession().getServletContext().getRealPath("")+"\\PhotoImg"+"\\"+fileName;
						//String newpath=localpath.replaceAll("\\","\\\\");
						System.out.println(localpath);
					}
				}
			}

		}
		try {
			responseMessage(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
