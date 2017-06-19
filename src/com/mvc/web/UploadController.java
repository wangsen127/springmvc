package com.mvc.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping("/showUpload.do")
	public String showUpload(){
		
		return "upload";
	}
	
	@RequestMapping("/upload.do")
	public String upload(HttpServletRequest request, MultipartFile file) throws Exception{
		
		if(file != null){
			String basePath = "E:/up";
			System.out.println(basePath);
			
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			
			String newName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
			System.out.println(newName);
			
			File newFile = new File(basePath + File.separator + newName);
			
			file.transferTo(newFile);
			
			request.setAttribute("fileName", newName);
		}
		
		return "success";
	}
	
	@RequestMapping("/showUpload2.do")
	public String showUpload2(){
		
		return "upload2";
	}
	
	/**
	 * 多个文件上传时，必须在接收数据的参数前加入@RequestParam("files")
	 */
	@RequestMapping("/upload2.do")
	public String upload2(HttpServletRequest request, @RequestParam("files")MultipartFile[] files) throws Exception{
		
		if(files != null && files.length!=0){
			String basePath = request.getSession().getServletContext().getRealPath("haha");
			System.out.println(basePath);
			
			for (MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);
				
				String newName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
				System.out.println(newName);
				
				File newFile = new File(basePath + File.separator + newName);
				
				file.transferTo(newFile);
			}
		}
		
		return "success";
	}
	
	@RequestMapping("/showDownload.do")
	public String showDownload(HttpServletRequest request){
		String basePath = "E:/up";
		
		List<String> list = new ArrayList<String>();
		
		File base = new File(basePath);
		if(base.isDirectory()){
			File[] fs = base.listFiles();
			if(fs!=null && fs.length>0){
				for (File file : fs) {
					list.add(file.getName());
				}
			}
		}
		
		request.setAttribute("filelist", list);
		
		return "download";
	}
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response, String fileName) throws Exception{
		
		if(fileName != null && !fileName.equals("")){
			String basePath = "E:/up";
			File file = new File(basePath + File.separator + fileName);
			
			if(file.exists()){
				//设置响应头
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition","attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				while(bis.read(buffer)!=-1){
					bos.write(buffer);
				}
				bos.flush();
				bis.close();
				bos.close();
			}
		}
		
	}
}
