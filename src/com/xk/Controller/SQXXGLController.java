package com.xk.Controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

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

import com.xk.orm.PublicEntity;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月19日 下午9:47:22
 * @version :
 * 
 */
@Controller
@RequestMapping("/SQXXGL")
public class SQXXGLController {
	@Autowired
	private AllService allservice;
	/**
	 * 查找所有单位
	 * @return
	 */
	@RequestMapping(value="/selectallunit",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectAllUnit(@RequestParam("status") String status){
		System.out.println(status);
		return allservice.getSqxxglBll().selectAllnormalUnit(status);
	}
	/**
	 * 查找所有可处理申请信息
	 * @param publicEntity
	 * @return
	 * taskid，processid，基本信息
	 */
	@RequestMapping(value="/selectApplyAndTask",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectApplyAndTask(@RequestBody PublicEntity publicEntity){
		return allservice.getSqxxglBll().SelectApplyAndTask(publicEntity);
	}
	/**
	 *处理当前申请任务 
	 * @param applyid
	 * @param hanglineid
	 * @param handtype {0：申请驳回，1：当前任务处理通过}
	 * @param processid
	 * @return
	 */
	@RequestMapping(value="/handerApply",method=RequestMethod.POST)
	public @ResponseBody JSONArray HanderApply(@RequestParam("handermemo") String handermemo,@RequestParam("applyid") int applyid,@RequestParam("userid") int userid,@RequestParam("hanglineid") int hanglineid,@RequestParam("handtype") int handtype,@RequestParam("processid") int processid,@RequestParam("unitid") int unitid){
		return allservice.getSqxxglBll().HanderApply(handermemo,applyid,userid,hanglineid,handtype,processid,unitid);
	}
	/**
	 * 查询流程历史处理信息
	 * @param processid
	 * @return
	 */
	@RequestMapping(value="/selectHistoryTask",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectHistoryTask(@RequestParam("processid")int processid){
		return allservice.getSqxxglBll().SelectHistoryTaskInfo(processid);
	}
	/**
	 * 根据applyid查找查堪信息
	 * @param applyid
	 * @return
	 */
	@RequestMapping(value="/selectCheckInfo",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectCheckInfo(@RequestParam("applyid")int applyid){
		return allservice.getSqxxglBll().SelectCheckInfo(applyid);
	}
	/**
	 * 根据applyid查找上传文件信息用于下载
	 * @param applyid
	 * @return
	 */
	@RequestMapping(value="/selectApplyDoc",method=RequestMethod.POST)
	public @ResponseBody JSONArray SelectApplyDoc(@RequestParam("applyid")int applyid){
		return allservice.getSqxxglBll().SelectApplyDoc(applyid);
	}
	/**
	 * 下载申请文件
	 * @param applyid
	 * @return
	 */
	@RequestMapping(value="/downApplyDoc")
	public String DownApplyDoc(@RequestParam Map<String,Object> reqMap,HttpServletRequest request,HttpServletResponse rep){
		String directorypath=request.getServletContext().getRealPath("/images");
		System.out.println(directorypath);
		File file=new File(directorypath, "left_right.png");
		if(file.exists())
		{
			rep.setContentType("application/png");
			rep.addHeader("Content-Disposition", "attachment;filename=left_right.png");
			byte[] buffer=new byte[1024];
			FileInputStream fis=null;
			BufferedInputStream bis=null;
			try {
				 fis=new FileInputStream(file);
				 bis=new BufferedInputStream(fis);
				 OutputStream os=rep.getOutputStream();
				 int i=bis.read();
				 while(i!=-1)
				 {
					 os.write(buffer,0,i);
					 i=bis.read(buffer);
				 }
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				if(bis!=null)
				{
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(fis!=null)
				{
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}
