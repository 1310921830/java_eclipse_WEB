package com.yuantu.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File upload;// �ļ�
	private String uploadFileName;// ��ʾ���û����ļ���
	private String downLoadFileName;
	private String message;
	private String newFileName;


	public String uploadFile() {
		InputStream is = null;
		OutputStream os = null;
		if (upload == null) {
			return SUCCESS;
		}
		try {
			//������
			is = new FileInputStream(upload);
			String filePath = "/uploadImg";
			String realPath = getRequest().getRealPath(filePath);
			System.out.println(realPath);
			File destDir = new File(realPath);
			if (!destDir.exists()) {
				destDir.mkdir();
			}
			int dotPosition= uploadFileName.lastIndexOf(".");
			UUID uuid= UUID.randomUUID();
			newFileName=uuid.toString()+uploadFileName.substring(dotPosition);
			File destFile = new File(realPath, newFileName);
			//�����
			os = new FileOutputStream(destFile);
			byte[] buffer = new byte[4000];// �����С
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				// д���ļ�
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			message = "�ϴ��ɹ�";
		} catch (Exception ex) {
			ex.printStackTrace();
			message = "�ϴ�ʧ��";
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return SUCCESS;
	}

	public void downloadFile() {
		String path = getRequest().getRealPath("/uploadImg");
		path = path + "/" + downLoadFileName;
		System.out.println(path);
		File fis = new File(path);
		String fisName = fis.getName();

		try {
			if (fis.exists()) {
				// fisName = fisName.substring(fisName.indexOf(".")+1);
				InputStream in = new FileInputStream(fis);
				getResponse().addHeader("Content-Disposition",
						"attachment;filename=" + uploadFileName);
				OutputStream out = getResponse().getOutputStream();
				try {
					byte[] buf = new byte[1024];
					int len;
					while ((len = in.read(buf)) != -1) {
						out.write(buf, 0, len);
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.getResponse().getWriter().println("���س���");
				} finally {
					in.close();
					out.close();
				}
			} else {
				this.getResponse().getWriter().println("�ļ������ڣ�");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	private HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getDownLoadFileName() {
		return downLoadFileName;
	}

	public void setDownLoadFileName(String downLoadFileName) {
		this.downLoadFileName = downLoadFileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	
}