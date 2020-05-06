package com.lcu.res.service;

import java.io.File;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lcu.res.dao.FoodMapper;
import com.lcu.res.po.Food;
import com.lcu.res.po.Restaurant;
import com.lcu.res.po.User;
import com.lcu.res.util.Message;

@Service
public class UtilServicelmpl implements UtilService{

	@Autowired
	CodeService codeservice;
	
	@Autowired
	FoodMapper foodmapper;
	
	//用户信息各种判断
	public String userJudgment(User user, String flg) {
		
		if ("login".equals(flg)) {
			return comJudgment(user);
		} else if ("userRegister".equals(flg) || "shopRegister".equals(flg)) {
			
			if ("userRegister".equals(flg)) {
				if ("".equals(user.getRestaurantNumber())) {
					return Message.RESCODE_EMPTY_ERROR;
				}
				
				if (user.getRestaurantNumber().length() > 20) {
					return Message.RESCODE_LENGTH_ERROR;
				}
			}
			
			String msg = comJudgment(user);
			
			if ("SUCCESS".equals(msg)) {
				
				if ("".equals(user.getTelephoneNumber())) {
					return Message.TELEPHONE_EMPTY_ERROR;
				}
				
				if (user.getTelephoneNumber().length() > 11) {
					return Message.TELEPHONE_LENGTH_ERROR;
				}
				
				//判断格式
				
				if ("userRegister".equals(flg)) {
					if ("".equals(user.getActualName())) {
						return Message.ACTUALNAME_EMPTY_ERROR;
					}
					
					if (user.getActualName().length() > 20) {
						return Message.ACTUALNAME_LENGTH_ERROR;
					}
				}
			} else {
				return msg;
			}
			
			return Message.SUCCESS;
		} else {
			return Message.EXCPTION_ERROR;
		}
		
	}
	
	//用户名密码判断、用户公共的判断
	private String comJudgment(User user) {
		
		if ("".equals(user.getUserName())) {
			return Message.USERNAME_EMPTY_ERROR;
		}
		
		if (user.getUserName().length() > 20) {
			return Message.USERNAME_LENGTH_ERROR;
		}
		
		if ("".equals(user.getPassword())) {
			return Message.PASSWORD_EMPTY_ERROR;
		}
		
		if (user.getPassword().length() < 8 || user.getUserName().length() > 20) {
			return Message.PASSWORD_LENGTH_ERROR;
		}
		
		//判断格式
		
		return Message.SUCCESS;

	}

	//店铺信息的各种判断
	public String shopJudgment(Restaurant res) {
		
		if ("".equals(res.getRestaurantName())) {
			return Message.RESTAURANTNAME_EMPTY_ERROR;
		}
		
		if (res.getRestaurantName().length() > 30) {
			return Message.RESTAURANTNAME_LENGTH_ERROR;
		}
		
		if ("".equals(res.getRestaurantTelephone())) {
			return Message.TELEPHONE_EMPTY_ERROR;
		}
		
		if (res.getRestaurantTelephone().length() > 11) {
			return Message.TELEPHONE_LENGTH_ERROR;
		}
		
		//判断格式
		
		if ("".equals(res.getRestaurantAddress())) {
			return Message.RESTAURANTADDRESS_EMPTY_ERROR;
		}
		
		if (res.getRestaurantAddress().length() > 100) {
			return Message.RESTAURANTADDRESS_LENGTH_ERROR;
		}
		
		if ("".equals(res.getRestaurantManager())) {
			return Message.RESTAURANTMANAGER_EMPTY_ERROR;
		} 
		
		if (res.getRestaurantManager().length() > 10) {
			return Message.RESTAURANTMANAGER_LENGTH_ERROR;
		}
		
		return Message.SUCCESS;
	}
	
	//上传图片
	public String uploadImg(HttpServletRequest request, MultipartFile imgUpload) {
		
		//1.获取服务器端存放文件的物理地址
		String path = request.getServletContext().getRealPath("uploadFile/img");
		System.out.println(path);
		//2.重命名客户端上传的文件“上传时间毫秒值.扩展名”
		String imgname = imgUpload.getOriginalFilename();
		long time = System.currentTimeMillis();
		String newImgname = String.valueOf(time)+imgname.substring(imgname.lastIndexOf("."));
		System.out.println(newImgname);
		//3.文件读写：将客户端上传的文件数据写入到服务器指定目录下的新文件中
		File newfile = new File(path,newImgname);
		if(!newfile.exists())
			newfile.mkdirs();
		try {
			//流的读写过程
			imgUpload.transferTo(newfile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newImgname;
	}

	//删除图片
	@Override
	public void deleteImg(HttpServletRequest request, Food food) {
		String path = request.getServletContext().getRealPath("uploadFile/img");
		System.out.println(path);
		File file = new File(path + "\\" + food.getPictureName());
		file.delete();
	}
		
}
