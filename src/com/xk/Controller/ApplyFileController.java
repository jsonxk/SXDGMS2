package com.xk.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xk.ActivitiUtil.EnumData;
import com.xk.orm.ApplyDoc;
import com.xk.orm.ApplyDocTime;
import com.xk.orm.ApplyMore;
import com.xk.service.AllService;

@Controller
@RequestMapping("/ApplyFile")
public class ApplyFileController {
	@Autowired
	private AllService allservice;

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @param response
	 * @param appDocTime
	 *            文件存储对应实体
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping(value = "/UploadFile", method = RequestMethod.POST)
	public void upload2(HttpServletRequest request,
			HttpServletResponse response, ApplyDocTime appDocTime)
			throws IllegalStateException, IOException {
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
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = file.getOriginalFilename();
						String DBPathFilename=new Date().getTime()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
						// 定义上传路径
						String path = System.getProperty("evan.webapp")
								+ File.separator + "FileUpload";
						File filepackage = new File(path);
						if (!filepackage.exists()) {
							filepackage.mkdirs();
						}
						// String path =
						// "E:"+File.separator+"test"+File.separator+ fileName;
						// String path=request.getServletPath();
						File localFile = new File(path + File.separator
								+ DBPathFilename);
						file.transferTo(localFile);
						DBPath = "http://"+EnumData.ServerAddress+"/SXDGMS2/FileUpload/"
								+ DBPathFilename;
						System.out.println(DBPath
								+ Integer.parseInt(appDocTime.getDoctype()));
						/*
						 * 相关信息存入数据库
						 */
						appDocTime.setDoctypeid(Integer.parseInt(appDocTime.getDoctype()));
						appDocTime.setDocname(fileName);
						appDocTime.setDocpath(DBPath);
						boolean fileinsert=allservice.getApplyMapperBLL().InsertApplydoc(appDocTime);
					}
				}
			}

		}
		responseMessage(response);
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
}
