/*package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.launcher.resources.launcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ht.account.admin.AccInformation;
import com.ht.account.admin.Code;
import com.ht.account.admin.Customer;
import com.ht.account.admin.Department;
import com.ht.account.admin.GLmend;
import com.ht.account.admin.GlAccvouch;
import com.ht.account.admin.HT_GLItem;
import com.ht.account.admin.Person;
import com.ht.account.admin.UFFJ_AccLog;
import com.ht.account.admin.User;
import com.ht.account.admin.Vendor;
import com.ht.account.admin.ZZ_CashTable;
import com.ht.account.admin.ZZ_Lock;
import com.ht.account.admin.dsign;
import com.ht.account.admin.ua_Period;
import com.ht.account.admin.vo.CodeV;
import com.ht.account.admin.vo.GlAccvouchVo;
import com.ht.account.service.AccInformationService;
import com.ht.account.service.AccountService;
import com.ht.account.service.CodeService;
import com.ht.account.service.CustomerService;
import com.ht.account.service.DepartmentService;
import com.ht.account.service.GL_accassService;
import com.ht.account.service.GL_accsumService;
import com.ht.account.service.GLmendService;
import com.ht.account.service.GlAccvouchService;
import com.ht.account.service.HT_CCItemService;
import com.ht.account.service.HT_GLItemService;
import com.ht.account.service.PersonService;
import com.ht.account.service.SettleStyleService;
import com.ht.account.service.SystemService;
import com.ht.account.service.UFFJ_AccLogService;
import com.ht.account.service.VendorService;
import com.ht.account.service.ZZ_CashTableService;
import com.ht.account.service.ZZ_DLZMService;
import com.ht.account.service.ZZ_LockService;
import com.ht.account.service.dsignService;
import com.ht.account.service.gl_bfreqService;
import com.ht.account.service.ua_PeriodService;
import com.ht.account.service.ua_UserService;
import com.ht.account.util.ConstantUtil;
import com.ht.account.util.ExcelUtil;
import com.ht.account.util.Paging;
import com.ht.account.util.SystemUtil;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

@Scope("prototype")
@Controller
@RequestMapping("/glAccvouchController")
public class GlAccvouchController {
	
	private static final String HashMap = null;
	@Autowired
	private GlAccvouchService glAccvouchService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PersonService personService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private HT_GLItemService ht_GLItemService;
	@Autowired
	private HT_CCItemService ht_CCItemService;
	@Autowired
	private SettleStyleService settleStyleService;
	@Autowired
	private SystemService systemservice;
	@Autowired
	private AccountService accountService;
	@Autowired
	private GL_accassService gL_accassService;
	@Autowired
	private AccInformationService accInformationService;
	@Autowired
	private ZZ_DLZMService zz_DLZMService;
	@Autowired
	private GLmendService GLmendservice;
	@Autowired
	private GlAccvouchService glAccvouchservice;
	@Autowired
	private ZZ_LockService zZ_Lockservice;
	@Autowired
	private GL_accsumService gl_accsumservice;
	@Autowired
	private GL_accassService gl_accassService;
	@Autowired
	private ua_PeriodService ua_periodService;
	@Autowired
	private dsignService dsignservice;
	@Autowired
	private ZZ_CashTableService zz_CashTableservice;
	@Autowired
	private UFFJ_AccLogService uffj_AccLogService;
	@Autowired
	private ua_UserService ua_userservice;
	@Autowired
	private gl_bfreqService gl_bfreqService;
	@Autowired
	private SystemService systemService;
	@RequestMapping(params = "glAccvouchs")
	@ResponseBody
	public Map<Object, Object> getGlAccvouchs(HttpServletRequest request){
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		String startTime=request.getParameter("startTime");
		String IgradeBegin=request.getParameter("IgradeBegin");
		String IgradeEnd=request.getParameter("IgradeEnd");
		String isbilling2=request.getParameter("isbilling2");
		String attribute1 =request.getSession().getAttribute("database").toString()+".dbo.gl_accvouch ";
		String attribute2 =request.getSession().getAttribute("database").toString()+".dbo.Code ";
		String pageNumber=request.getParameter("page");
		
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		Integer page=Integer.valueOf(pageNumber);
		page=(page-1)*Integer.valueOf(pageSize);	
		List<Map<Object, Object>> glAccvouchs= glAccvouchService.getGlAccvouchs(attribute1,attribute2,startTime,IgradeBegin,IgradeEnd,pageSize,String.valueOf(page));
		List<Map<Object, Object>> glAccvouchs2=new ArrayList<Map<Object,Object>>();
		for (Map<Object, Object> map : glAccvouchs) {
			if ((new BigDecimal(String.valueOf(map.get("todaydebit"))).compareTo(new BigDecimal(0))!=0)||
					(new BigDecimal(String.valueOf(map.get("todaylenders"))).compareTo(new BigDecimal(0))!=0)||
					("true".equals(String.valueOf(isbilling2))&&(new BigDecimal(String.valueOf(map.get("todayamont"))).compareTo(new BigDecimal(0))!=0))) {
				glAccvouchs2.add(map);
			}
		}
		if (glAccvouchs2.size()<1) {
			resultmap.put("rows", glAccvouchs2);
			return resultmap;
		}
		BigDecimal yesterdayamontsum=new BigDecimal("0");//昨日余额合计
		BigDecimal todaydebitsum=new BigDecimal("0");//今日借方合计
		BigDecimal todaylenderssum=new BigDecimal("0");//今日贷方合计
		BigDecimal todayamontsum=new BigDecimal("0");//今日余额合计
		BigDecimal numofborrowerssum=new BigDecimal("0");//借方笔数合计
		BigDecimal numoflenderssum=new BigDecimal("0");//贷方笔数合计
		for (int i = 0; i < glAccvouchs2.size();) {
			Map<Object, Object> map = glAccvouchs2.get(i);
			if ("1".equals(String.valueOf(map.get("igrade")))) {
				yesterdayamontsum=yesterdayamontsum.add(new BigDecimal(String.valueOf(map.get("yesterdayamont"))));
				todaydebitsum=todaydebitsum.add(new BigDecimal(String.valueOf(map.get("todaydebit"))));
				todaylenderssum=todaylenderssum.add(new BigDecimal(String.valueOf(map.get("todaylenders"))));
				todayamontsum=todayamontsum.add(new BigDecimal(String.valueOf(map.get("todayamont"))));
				numofborrowerssum=numofborrowerssum.add(new BigDecimal(String.valueOf(map.get("numofborrowers"))));
				numoflenderssum=numoflenderssum.add(new BigDecimal(String.valueOf(map.get("numoflenders"))));
			}
			if (String.valueOf(map.get("yesterdayamont")).equals("0")) {
				map.put("ydayamontdirect", "平");//昨日余额方向
			}
			//昨日余额与0比较
			int a1 = new BigDecimal(String.valueOf(map.get("yesterdayamont"))).compareTo(new BigDecimal(0));
			if (a1==1) {
				map.put("ydayamontdirect", "借");	
			}else if (a1==-1) {
				map.put("ydayamontdirect", "贷");
				map.put("yesterdayamont", String.valueOf(new BigDecimal("-1").multiply(new BigDecimal(String.valueOf(map.get("yesterdayamont"))))));
			}
			if (String.valueOf(map.get("todayamont")).equals("0")) {
				map.put("tdayamontdirect", "平");//今日余额方向
			}
			//今日余额与0比较
			int a2 = new BigDecimal(String.valueOf(map.get("todayamont"))).compareTo(new BigDecimal(0));
			if (a2==1) {
				map.put("tdayamontdirect", "借");
				map.put("todayamont", new BigDecimal(map.get("todayamont").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
			}else if (a2==-1) {
				map.put("tdayamontdirect", "贷");
				map.put("todayamont", String.valueOf(new BigDecimal("-1").multiply(new BigDecimal(String.valueOf(map.get("todayamont")))).add(new BigDecimal("0.00")).setScale(2)));
			}
			//昨日外币余额与0比较
			int a3 = new BigDecimal(String.valueOf(map.get("yesterdayforcurr"))).compareTo(new BigDecimal(0));
			//今日外币借方与0比较
			int a4 = new BigDecimal(String.valueOf(map.get("todayforcurrdebit"))).compareTo(new BigDecimal(0));
			//今日外币贷方与0比较
			int a5 = new BigDecimal(String.valueOf(map.get("todayforcurrcredit"))).compareTo(new BigDecimal(0));
			if (a3==1||a4==1||a5==1) {
				//如果有增加一行外币记录
				Map<Object, Object> mapadd=new HashMap<Object, Object>();
				mapadd.put("ccode", "");
				mapadd.put("ccode_name", "");
				mapadd.put("currency", String.valueOf(map.get("currency")));
				if (a3==0) {
					mapadd.put("ydayamontdirect", "平");
					mapadd.put("yesterdayamont", "");
				}else if (a3==1) {
					mapadd.put("ydayamontdirect", "借");
					mapadd.put("yesterdayamont", new BigDecimal(map.get("yesterdayforcurr").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
				}else if (a3==-1) {
					mapadd.put("ydayamontdirect", "贷");
					mapadd.put("yesterdayamont", String.valueOf(new BigDecimal("-1").multiply(new BigDecimal(String.valueOf(map.get("yesterdayforcurr")))).add(new BigDecimal("0.00")).setScale(2).toString()));
				}
				mapadd.put("todaydebit", new BigDecimal(map.get("todayforcurrdebit")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				mapadd.put("todaylenders", new BigDecimal(map.get("todayforcurrcredit")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				//今日外币余额
				int a6=new BigDecimal(String.valueOf(map.get("todayforcurramont"))).compareTo(new BigDecimal(0));
				if (a6==0) {
					mapadd.put("tdayamontdirect", "平");
					mapadd.put("todayamont", "");
				}else if (a6==1) {
					mapadd.put("tdayamontdirect", "借");
					mapadd.put("todayamont", new BigDecimal(map.get("todayforcurramont")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}else if (a6==-1) {
					mapadd.put("tdayamontdirect", "贷");
					mapadd.put("todayamont", new BigDecimal("-1").multiply(new BigDecimal(map.get("todayforcurramont")+"")).add(new BigDecimal("0.00")).setScale(2).toString());
				}
				mapadd.put("numofborrowers", new BigDecimal(map.get("numofborrowers")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				mapadd.put("numoflenders", new BigDecimal(map.get("numoflenders")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				glAccvouchs2.add(i+1, mapadd);
				i+=2;
			}
				if (Double.valueOf(map.get("todaydebit")+"")==0) {
					map.put("todaydebit", "");
				}else {
					map.put("todaydebit", new BigDecimal(map.get("todaydebit")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}
				if (Double.valueOf(map.get("todaylenders")+"")==0) {
					map.put("todaylenders", "");
				}else {
					map.put("todaylenders", new BigDecimal(map.get("todaylenders")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}
				if (Double.valueOf(map.get("numofborrowers")+"")==0) {
					map.put("numofborrowers", "");
				}else {
					map.put("numofborrowers", new BigDecimal(map.get("numofborrowers")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}
				if (Double.valueOf(map.get("numoflenders")+"")==0) {
					map.put("numoflenders", "");
				}else {
					map.put("numoflenders", new BigDecimal(map.get("numoflenders")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}
				if (Double.valueOf(map.get("yesterdayamont")+"")==0) {
					map.put("yesterdayamont", "");
				}else {
					map.put("yesterdayamont", new BigDecimal(map.get("yesterdayamont")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}
			i++;
		}
		Map<Object, Object> mapadd=new HashMap<Object, Object>();
		mapadd.put("ccode", "合计：");
		//昨日余额合计与0比较
		int a7=yesterdayamontsum.compareTo(new BigDecimal("0"));
		if (a7==0) {
			mapadd.put("ydayamontdirect", "平");
			mapadd.put("yesterdayamont", "");
		}else if (a7==-1) {
			mapadd.put("ydayamontdirect", "贷");
			mapadd.put("yesterdayamont", (new BigDecimal("-1").multiply(yesterdayamontsum)).add(new BigDecimal("0.00")).setScale(2).toString());
		}else if (a7==1) {
			mapadd.put("ydayamontdirect", "借");
			mapadd.put("yesterdayamont", yesterdayamontsum.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if (todaydebitsum.compareTo(new BigDecimal("0"))==0) {
			mapadd.put("todaydebit", "");
		}else{
			mapadd.put("todaydebit", todaydebitsum.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if(todaylenderssum.compareTo(new BigDecimal("0"))==0){
			mapadd.put("todaylenders", "");
		}else {
			mapadd.put("todaylenders", todaylenderssum.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		//今日余额合计与0比较
		int a8=todayamontsum.compareTo(new BigDecimal("0"));
		if (a8==0) {
			mapadd.put("tdayamontdirect", "平");
			mapadd.put("todayamont", "");
		}else if (a8==-1) {
			mapadd.put("tdayamontdirect", "贷");
			mapadd.put("todayamont", (new BigDecimal("-1").multiply(todayamontsum)).add(new BigDecimal("0.00")).setScale(2).toString());
		}else if (a8==1) {
			mapadd.put("tdayamontdirect", "借");
			mapadd.put("todayamont", todayamontsum.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if(numofborrowerssum.compareTo(new BigDecimal("0"))==0){
			mapadd.put("numofborrowers", "");
		}else {
			mapadd.put("numofborrowers", numofborrowerssum.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if(numoflenderssum.compareTo(new BigDecimal("0"))==0){
			mapadd.put("numoflenders", "");
		}else {
			mapadd.put("numoflenders", numoflenderssum.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		//获取外币合计记录
		List<Map<Object, Object>> fircurrsums=glAccvouchService.getfircurrsum(attribute1,attribute2,startTime,IgradeBegin,IgradeEnd);
		//若有外币合计记录，则增加一行外币显示记录
		if (fircurrsums!=null&&fircurrsums.size()>0) {
			Map<Object, Object> mapadd2=new HashMap<Object, Object>();
			yesterdayamontsum=new BigDecimal("0");
			todayamontsum=new BigDecimal("0");
			numofborrowerssum=new BigDecimal("0");//借方笔数合计
			numoflenderssum=new BigDecimal("0");//贷方笔数合计
			todaydebitsum=new BigDecimal("0");//今日借方合计
			todaylenderssum=new BigDecimal("0");//今日贷方合计
			HttpSession session = request.getSession();
			for (int j = 0; j < fircurrsums.size(); j++) {
				Map<Object, Object> map = fircurrsums.get(j);
				yesterdayamontsum=yesterdayamontsum.add(new BigDecimal(String.valueOf(map.get("yesterdayamont"))));
				todayamontsum=todayamontsum.add(new BigDecimal(String.valueOf(map.get("todayamont"))));
				numofborrowerssum=numofborrowerssum.add(new BigDecimal(String.valueOf(map.get("numofborrowers"))));
				numoflenderssum=numoflenderssum.add(new BigDecimal(String.valueOf(map.get("numoflenders"))));
				todaydebitsum=todaydebitsum.add(new BigDecimal(String.valueOf(map.get("debit"))));
				todaylenderssum=todaylenderssum.add(new BigDecimal(String.valueOf(map.get("credit"))));
			}
			session.setAttribute("numofborrowerssum", numofborrowerssum.toString());
			session.setAttribute("numoflenderssum", numoflenderssum.toString());
			session.setAttribute("todaydebitsum", todaydebitsum.toString());
			session.setAttribute("todaylenderssum", todaylenderssum.toString());
			int a9=yesterdayamontsum.compareTo(new BigDecimal("0"));
			if (a9==0) {
				mapadd2.put("ydayamontdirect", "平");
			}else if (a9==-1) {
				mapadd2.put("ydayamontdirect", "贷");
				mapadd2.put("yesterdayamont", (new BigDecimal("-1").multiply(yesterdayamontsum)).add(new BigDecimal("0.00")).setScale(2).toString());
			}else if (a9==1) {
				mapadd2.put("ydayamontdirect", "借");
				mapadd2.put("yesterdayamont", yesterdayamontsum.add(new BigDecimal("0.00")).setScale(2).toString());
			}
			mapadd2.put("todaydebit", todaylenderssum.add(new BigDecimal("0.00")).setScale(2).toString());//今日贷方
			mapadd2.put("todaylenders", todaydebitsum.add(new BigDecimal("0.00")).setScale(2).toString());//今日借方
			int a10=todayamontsum.compareTo(new BigDecimal("0"));
			if (a10==0) {
				mapadd2.put("tdayamontdirect", "平");
			}else if (a10==-1) {
				mapadd2.put("tdayamontdirect", "贷");
				mapadd2.put("todayamont", (new BigDecimal("-1").multiply(todayamontsum)).add(new BigDecimal("0.00")).setScale(2).toString());
			}else if (a10==1) {
				mapadd2.put("tdayamontdirect", "借");
				mapadd2.put("todayamont", todayamontsum.add(new BigDecimal("0.00")).setScale(2).toString());
			}
			mapadd2.put("numofborrowers", numofborrowerssum.add(new BigDecimal("0.00")).setScale(2).toString());
			mapadd2.put("numoflenders", numoflenderssum.add(new BigDecimal("0.00")).setScale(2).toString());
			glAccvouchs2.add(mapadd2);//外币合计行
		}
		
		glAccvouchs2.add(mapadd);
		
		List<Map<Object, Object>> total = glAccvouchService.getGlAccvouchscount(attribute1,attribute2,startTime,IgradeBegin,IgradeEnd,pageSize,String.valueOf(page));

		resultmap.put("total", total.get(0).get("count"));
		resultmap.put("rows", glAccvouchs2);
		return resultmap;
	}
	//获取级次
	@RequestMapping(params = "getmaxIgrade")
	@ResponseBody
	public String getgrade(HttpServletRequest request){
		String attribute =request.getSession().getAttribute("database").toString()+".dbo.Code ";
		String maxIgrade=codeService.getMaxIgrade(attribute);
		return maxIgrade;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "daily")
	@ResponseBody
	public List<Map<Object, Object>> daily(HttpServletRequest request){
		HttpSession session = request.getSession();
		String row = request.getParameter("row");
		Map<Object, Object> mapjson=(Map<Object, Object>) JSON.parse(row);
		List<Map<Object, Object>> listmap=new ArrayList<Map<Object,Object>>();
		Map<Object, Object> map=new HashMap<Object, Object>();
			map.put("emptycolumn", "昨日余额");
			map.put("direction", mapjson.get("ydayamontdirect"));//方向
			map.put("amount", mapjson.get("yesterdayamont"));//金额
			map.put("forcurr", mapjson.get("yesterdayforcurr"));//外币
			map.put("pensnum", "");//笔数
			listmap.add(map);
			map=new HashMap<Object, Object>();
			map.put("emptycolumn", "今日共借");
			map.put("direction","");//方向
			map.put("amount", mapjson.get("todaydebit"));//金额
			map.put("forcurr", session.getAttribute("todaydebitsum"));//外币
			map.put("pensnum", mapjson.get("numofborrowers"));//笔数
			listmap.add(map);
			map=new HashMap<Object, Object>();
			map.put("emptycolumn", "今日共贷");
			map.put("direction", mapjson.get(""));//方向
			map.put("amount", mapjson.get("todaylenders"));//金额
			map.put("forcurr", session.getAttribute("todaylenderssum"));//外币
			map.put("pensnum", mapjson.get("numoflenders"));//笔数
			listmap.add(map);
			map=new HashMap<Object, Object>();
			map.put("emptycolumn", "今日余额");
			map.put("direction", mapjson.get("tdayamontdirect"));//方向
			map.put("amount", mapjson.get("todayamont"));//金额
			map.put("forcurr", mapjson.get("yesterdayforcurr"));//外币
			map.put("pensnum", "");//笔数
			listmap.add(map);
		return listmap;
	}
	//获取登录时的操作日期
	@RequestMapping(params = "startTime2")
	@ResponseBody
	public String startTime2(HttpServletRequest request){
	String date =  (String) request.getSession().getAttribute("startTime");
		return date;
	}
	@RequestMapping(params = "exceltable")
	@ResponseBody
	public void exceltable(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String path="";
		try {
			String flag = request.getParameter("flag");
			String columns=request.getParameter("field_colname");
			List<String>fieldName=new ArrayList<String>();
			List<String>fieldTitle=new ArrayList<String>();
			String[] field = columns.split(",");
			int length = field.length;
			for (int i = 0; i < length; i++) {
				String[] field2 = field[i].split("__");
				fieldName.add(field2[0]);
				fieldTitle.add(field2[1]);
			}
			String rows=request.getParameter("rows");
			List<Map<Object, Object>> rowMaps=(List<Map<Object, Object>>) JSON.parse(rows);
			//获取当前日期
			SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
			Date date=new Date();
			String uname=df.format(date);
			String name="报表("+uname+").xlsx";
			if("capital".equals(flag)){
				name="资金日报表("+uname+").xlsx";
			}else if ("journal".equals(flag)) {
				name="序时账报表("+uname+").xlsx";
			}
			path=generateexcel(fieldName, fieldTitle, rowMaps, name,request,response);
			download(path,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*//**
	 * 生成excel
	 * *//*
	public String generateexcel(List<String>fieldName,List<String>fieldTitle,List<Map<Object, Object>> rowMaps,String filename,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//创建excel工作薄
		XSSFWorkbook workbook=new XSSFWorkbook();
		//创建一个工作表sheet
		XSSFSheet sheet=workbook.createSheet();
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		XSSFCellStyle setBorder=workbook.createCellStyle();
		setBorder.setAlignment(HSSFCellStyle.ALIGN_LEFT);//文字居中
		setBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		setBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		
		XSSFCellStyle headercellStyle = workbook.createCellStyle();
		headercellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headercellStyle.setBorderBottom(BorderStyle.NONE);
		
		XSSFFont headerFontStyle=workbook.createFont();
		headerFontStyle.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		headerFontStyle.setFontHeightInPoints((short)12);
		
		XSSFRow firstrow=sheet.createRow(0);
		XSSFCell tmp = firstrow.createCell(0);
		headercellStyle.setFillPattern(CellStyle.NO_FILL);  
		headercellStyle.setFont(headerFontStyle);
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,12));
		Calendar now = Calendar.getInstance();
		tmp.setCellValue("日期: ("+now.get(Calendar.YEAR)+"年"+(now.get(Calendar.MONTH) + 1)+"月"+now.get(Calendar.DAY_OF_MONTH)+"日)");
		tmp.setCellStyle(headercellStyle);
		headercellStyle.setFont(headerFontStyle);
		
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headercellStyle = workbook.createCellStyle();
		headercellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		headercellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		headercellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		headercellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		headercellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		
		//创建第一行
		XSSFRow row=sheet.createRow(2);
		XSSFCell cell=null;
		
		for (int i = 0; i < fieldTitle.size(); i++) {
			sheet.setColumnWidth(i, 20*256); 
			 //创建一行的一格
		    cell = row.createCell(i);
		    //赋值
		    cell.setCellValue(fieldTitle.get(i));
		    cell.setCellStyle(setBorder);
		}
		int j=3;
		for (int i = 0; i < rowMaps.size(); i++) {
			row=sheet.createRow(j);
			row.setRowStyle(headercellStyle);
			Map<Object, Object> map = rowMaps.get(i);
			for (int k = 0; k < fieldName.size(); k++) {
				XSSFCell createCell = row.createCell(k);
				createCell.setCellStyle(setBorder);
				createCell.setCellValue(String.valueOf(map.get(fieldName.get(k))).equals("null")?"":String.valueOf(map.get(fieldName.get(k))));
			}
			j++;
		}
		String path = request.getRealPath("upload/excel")+"/"+filename;
		File file =new File(path);
		try{
			file.createNewFile();
			FileOutputStream fos =FileUtils.openOutputStream(file);
			workbook.write(fos);
		}
        catch (Exception e){
            e.printStackTrace();
        }
		return path;
	}
	@RequestMapping(params = "thedaybefore")
	@ResponseBody
	public String thedaybefore(HttpServletRequest request) throws Exception{
		String date =  (String) request.getSession().getAttribute("startTime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date2=sdf.parse(date);
		date=sdf.format(new Date(date2.getTime() - (long)1 * 24 * 60 * 60 * 1000));
		return date;
	}
	@RequestMapping(params = "thedayafter")
	@ResponseBody
	public String thedayafter(HttpServletRequest request) throws Exception{
		String date =  (String) request.getSession().getAttribute("startTime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date2=sdf.parse(date);
		date=sdf.format(new Date(date2.getTime() + (long)1 * 24 * 60 * 60 * 1000));
		return date;
	}
	@RequestMapping(params = "download")
	@ResponseBody
	public void download(String path,HttpServletResponse response) throws Exception {
		OutputStream out = null;
		InputStream in = null;
		try {
			File file = new File(path);// path是根据日志路径和文件名拼接出来的
			if (file != null&&file.exists()) {
				out = response.getOutputStream();
				response.setContentType("multipart/form-data");
				response.setContentType("application/force-download");
				// 设置Content-Disposition
				in = new FileInputStream(file);
				
				response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("GBK"), "ISO-8859-1"));
				response.setContentLength(in.available());
				
				int len = 0;
				byte[] buffer = new byte[1024];
				out = response.getOutputStream();
				while ((len = in.read(buffer)) !=-1) {
					out.write(buffer, 0, len);
				}
				out.flush();
			} else {
				response.getWriter().print("error");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("error");
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	@RequestMapping(params = "getcCheck")
	@ResponseBody
	public List<String> getcCheck(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		List<String> list=glAccvouchService.getcCheck(database+".dbo.gl_accvouch ");
		list.add(0,"未审核凭证");
		list.add(0,"已审核凭证");
		list.add(0,"全部");
		return list;
	}
	@RequestMapping(params = "getcbill")
	@ResponseBody
	public List<String> getcbill(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		List<String> list=glAccvouchService.getcbill(database+".dbo.gl_accvouch ");
		list.add(0,"全部");
		return list;
	}
	@RequestMapping(params = "getcCashier")
	@ResponseBody
	public List<String> getcCashier(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		List<String> list=glAccvouchService.getcCashier(database+".dbo.gl_accvouch ");
		list.add(0,"未签字凭证");
		list.add(0,"已签字凭证");
		list.add(0,"全部");
		return list;
	}
	@RequestMapping(params = "getcbook")
	@ResponseBody
	public List<String> getcbook(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		List<String> list=glAccvouchService.getcbook(database+".dbo.gl_accvouch ");
		list.add(0,"未记账凭证");
		list.add(0,"已记账凭证");
		list.add(0,"全部");
		return list;
	}
	@RequestMapping(params = "getAccount")
	@ResponseBody
	public Map<Object, Object> getAccount(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String database1=request.getSession().getAttribute("database").toString()+".dbo.gl_accvouch ";
		String database2=request.getSession().getAttribute("database").toString()+".dbo.code ";
		String pageNumber=request.getParameter("page");
		
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		String orderby1=" dbill_date,gl_accvouch.csign,ino_id,inid ";
		String orderby2=" singletime,vouchernum,ino_id,inid ";
		String cursor="with q as (select ROW_NUMBER() over (partition by isnull(1,1) order by "+orderby1+" ) rn ,convert(varchar(10),dbill_date,23) as singletime,isnull(csign+'-'+ right('0000'+cast(ino_id as varchar(4)),4),'') as vouchernum,gl_accvouch.ccode, code.ccode_name,cdigest, md, mc, iperiod, csign, ino_id, inid, isnull(cdept_id,'') cdept_id , isnull(cperson_id,'') as cperson_id, isnull(csup_id,'') as csup_id, isnull(ccus_id,'') as ccus_id, isnull(citem_id,'') as citem_id, code.bdept, code.bperson, code.bsup, code.bcus, code.bitem, code.bcashitem From "+database1+" left join "+database2+" on gl_accvouch.ccode = code.ccode Where 0=0 and ";
		cursor+=SystemUtil.getSelectSql("Gl_Accvouch",request)+")";
		Integer page=Integer.valueOf(pageNumber);
		String sql=cursor+"select top "+pageSize+" * from  q where q.rn not in (select top "+(page-1)*Integer.valueOf(pageSize)+" ROW_NUMBER() over (partition by isnull(1,1) order by "+orderby2+") as c from q )";
		List<Map<Object, Object>> listmap=glAccvouchService.getJournal(sql);
		for (Map<Object, Object> map : listmap) {
			if (new BigDecimal(map.get("md").toString()).compareTo(new BigDecimal(0))==0) {
				map.put("md", "");
			}else {
				map.put("md", new BigDecimal(map.get("md").toString()).setScale(2).toString());
			}
			if (new BigDecimal(map.get("mc").toString()).compareTo(new BigDecimal(0))==0) {
				map.put("mc", "");
			}else {
				map.put("mc", new BigDecimal(map.get("mc").toString()).setScale(2).toString());
			}
			map.put("auxiliaryproject", "");
			String auxiliaryproject="";
			if (map.get("bdept")!=null&&"true".equals(map.get("bdept").toString())) {
				auxiliaryproject="部门核算：";
				if(map.get("cdept_id")!=null&&map.get("cdept_id").toString().trim().length()>0){
					auxiliaryproject+=departmentService.getDepName(database+".dbo.Department",(String)map.get("cdept_id"))+",";
				}
			}
			if(map.get("bperson")!=null&&map.get("bperson").toString().equals("true")){
				auxiliaryproject+="人员核算：";
				if(map.get("cperson_id")!=null&&map.get("cperson_id").toString().trim().length()>0){
					auxiliaryproject+=personService.getPersonName(database+".dbo.person",(String)map.get("cperson_id"))+",";
				}
			}
			if (map.get("bsup")!=null&&map.get("bsup").toString().equals("true")) {
				auxiliaryproject+="供应商核算：";
				if(map.get("csup_id")!=null&&map.get("csup_id").toString().trim().length()>0){
					auxiliaryproject+=vendorService.getVendorName(database+".dbo.vendor",(String)map.get("csup_id"))+",";
				}
			}
			if (map.get("bcus")!=null&&map.get("bcus").toString().equals("true")) {
				auxiliaryproject+="客户核算：";
				if(map.get("ccus_id")!=null&&map.get("ccus_id").toString().trim().length()>0){
					auxiliaryproject+=customerService.getCustName(database+".dbo.customer",(String)map.get("ccus_id"))+",";
				}
			}
			if (map.get("bitem")!=null&&map.get("bitem").toString().equals("true")) {
				auxiliaryproject+="项目核算：";
				if(map.get("citem_id")!=null&&map.get("citem_id").toString().trim().length()>0){
					auxiliaryproject+=ht_GLItemService.getHt_itemName(database+".dbo.hT_GLItem",(String)map.get("citem_id"))+",";
				}
			}
			if (auxiliaryproject.length()>0) {
				auxiliaryproject=auxiliaryproject.substring(0,auxiliaryproject.length()-1);
			}
			map.put("auxiliaryproject", auxiliaryproject);
			map.put("cashflow", "");
			if (map.get("bcashitem")!=null&&map.get("bcashitem").toString().equals("true")) {
				String cashflowsql=" select top 1 citemname from "+database+".dbo.zz_cashtable Left Join "+database+".dbo.ht_CCitem On zz_cashtable.citemcode = ht_ccitem.citemcode"
				+ " Where iperiod = " + map.get("iperiod") + " and csign = '" + map.get("csign") 
				+ "' and ino_Id = " + map.get("ino_id") + " and inid = " + map.get("inid");
				String cashflow = ht_CCItemService.getCashflow(cashflowsql);
				map.put("cashflow", cashflow);
			}
			map.put("ccode_name", "("+map.get("ccode")+")"+map.get("ccode_name"));
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		String count=cursor+" select count(*) count from q ";
		List<Map<Object, Object>> findBySql = gl_accassService.findBySql(count);
		Integer total = Integer.valueOf(findBySql.get(0).get("count").toString());
		map.put("total", total);
		if ((total/Integer.valueOf(pageSize))==0) {
			total=(total/Integer.valueOf(pageSize));
		}else {
			total=(total/Integer.valueOf(pageSize))+1;
		}
		map.put("pages", total);
		map.put("rows", listmap);
		return map;
	}
	@RequestMapping(params = "tallyInit")
	@ResponseBody
	public ArrayList<GlAccvouch> tallyInit(HttpServletRequest request){
		String type = request.getParameter("type");
		if(type.equals("1")){
			return glAccvouchService.canceTally_select(request);
		}else{
			return glAccvouchService.Tally_select(request);
		}
	}
	//部门科目总账
	@RequestMapping(params = "getcollect")
	@ResponseBody
	public Map<Object, Object> getcollect(HttpServletRequest request){
		String data=request.getParameter("data");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object>jsonmap=jsonmaps.get(0);
		Map<Object, Object> map=new HashMap<Object, Object>();
		//部门条件
		StringBuffer deptcondition=new StringBuffer("");
		if (jsonmap.get("departmentbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentbegin")))) {
			deptcondition.append("and (aaa.cdept_id >= '"+ jsonmap.get("departmentbegin") + "')");
		}
		if (jsonmap.get("departmentend")!=null) {
			deptcondition.append("and (aaa.cdept_id <= '" + jsonmap.get("departmentend") + "' or aaa.cdept_id like '" + jsonmap.get("departmentend") + "%')");
		}
		//期初sql
		StringBuffer Initialbalancesql=new StringBuffer("select ccode,cdept_id,sum(md - mc) as mb from " + request.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().substring(0,4) + ".dbo.gl_accvouch gl_accvouch  where isnull(iflag,0) <> 1");
		//发生sql
		StringBuffer happensql1=new StringBuffer("");
		if (jsonmap.get("isbilling").toString().equals("false")) {
			Initialbalancesql.append("and (iperiod = 0 or ibook = 1)");
		}
		Initialbalancesql.append(" and cdept_id is not null and iperiod < "+jsonmap.get("monthbegin").toString().substring(5) +" group by ccode,cdept_id");
		//累计发生sql
		StringBuffer cumulativehappensql1=new StringBuffer("");
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			happensql1.append("select ccode,cdept_id, md, mc from " + request.getSession().getAttribute("database").toString().substring(0,11)+i + " .dbo.gl_accvouch where isnull(iflag,0) <> 1");
			cumulativehappensql1.append("select ccode,cdept_id, md, mc from " + request.getSession().getAttribute("database").toString().substring(0,11)+i + " .dbo.gl_accvouch where isnull(iflag,0) <> 1");
			if (String.valueOf(jsonmap.get("isbilling")).equals("false")) {
				happensql1.append(" and (iperiod = 0 or ibook = 1)");
				cumulativehappensql1.append(" and (iperiod = 0 or ibook = 1)");
			}
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				happensql1.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + "");
			}else {
				happensql1.append(" and iperiod >= 1");
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				cumulativehappensql1.append(" and cdept_id is not null and iperiod >= "+jsonmap.get("monthbegin").toString().substring(5)+" and iperiod <= " + jsonmap.get("monthend").toString().substring(5) + "");
				happensql1.append(" and iperiod <= "+ jsonmap.get("monthend").toString().substring(5) +"");
			}else {
				cumulativehappensql1.append("and cdept_id is not null and iperiod >= 1 and iperiod <= " + 12 + "");
				happensql1.append(" and iperiod <= 12");
			}
			if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				cumulativehappensql1.append(" union all ");
				happensql1.append(" union all ");
			}
		}
		//修改发生sql
		StringBuffer happensql2=new StringBuffer("select ccode, cdept_id, sum(md) md, sum(mc) mc from ");
		happensql2.append("("+happensql1+") ssc group by ccode, cdept_id");
		//修改累计发生sql
		StringBuffer cumulativehappensql2=new StringBuffer("select ccode, cdept_id, sum(md) lmd, sum(mc) lmc from ");
		cumulativehappensql2.append("(" + cumulativehappensql1 + ") ssd group by ccode, cdept_id");
		
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")||pageSize.equals("NaN")) {
			pageSize="500";
		}
		String a = "";
		String b="";
		if(pageSize.equals("全部")){
			a="";
			b="*";
		}else {
			a=pageSize;
			b=(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize) +"";
		}
		
		
		List<Map<Object, Object>> collects = glAccvouchService.getcollect(request.getSession().getAttribute("database").toString(),String.valueOf(jsonmap.get("isbilling")),Initialbalancesql.toString(),
				happensql2.toString(),cumulativehappensql2.toString(),jsonmap.get("subject").toString(),deptcondition.toString(),a,b);
		List<Map<Object, Object>> getcollectcount = glAccvouchService.getcollectcount(request.getSession().getAttribute("database").toString(),String.valueOf(jsonmap.get("isbilling")),Initialbalancesql.toString(),
				happensql2.toString(),cumulativehappensql2.toString(),jsonmap.get("subject").toString(),deptcondition.toString(),a,b);
		if (collects!=null&&collects.size()>0) {
		BigDecimal mbtotal=new BigDecimal("0");//期初余额合计
		BigDecimal mdtotal=new BigDecimal("0");//借方
		BigDecimal mctotal=new BigDecimal("0");//贷方
		BigDecimal lmdtotal=new BigDecimal("0");//累计借方
		BigDecimal lmctotal=new BigDecimal("0");//累计贷方
		BigDecimal metotal=new BigDecimal("0");//期末余额
		BigDecimal mecount=new BigDecimal("0");//期末余额(不是绝对值)
		BigDecimal mbcount=new BigDecimal("0");//期初余额(不是绝对值)
		
		for (int i = 0; i < collects.size(); i++) {
			map = collects.get(i);
			int mb_direction = new BigDecimal(map.get("mb").toString()).compareTo(new BigDecimal(0)); //期初余额比较
			mbcount=mbcount.add(new BigDecimal(map.get("mb").toString()));
			//mb_direction 期初方向
			if (-1==mb_direction) {
				map.put("mb_direction", "贷");
			}else if (0==mb_direction) {
				map.put("mb_direction", "平");
			}else if (1==mb_direction) {
				map.put("mb_direction", "借");
			}
			map.put("mb", new BigDecimal(map.get("mb").toString()).setScale(2));
			
			int me_direction = new BigDecimal(map.get("me").toString()).compareTo(new BigDecimal(0)); //期末余额比较
			mecount=mecount.add(new BigDecimal(map.get("me").toString()));
			//me_direction 期末方向
			if (-1==me_direction) {
				map.put("me_direction", "贷");
			}else if (0==me_direction) {
				map.put("me_direction", "平");
			}else if (1==me_direction) {
				map.put("me_direction", "借");
			}
			map.put("me", new BigDecimal(map.get("me").toString()).setScale(2));
			
			if (map.get("isfinalstage").toString().equals("true")) {
				mbtotal=mbtotal.add(new BigDecimal(map.get("mb").toString()));
				mdtotal=mdtotal.add(new BigDecimal(map.get("md").toString()));
				mctotal=mctotal.add(new BigDecimal(map.get("mc").toString()));
				lmdtotal=lmdtotal.add(new BigDecimal(map.get("lmd").toString()));
				lmctotal=lmctotal.add(new BigDecimal(map.get("lmc").toString()));
				metotal=metotal.add(new BigDecimal(map.get("me").toString()));
			}
			if (0==Double.valueOf((map.get("mb")+""))) {
				map.put("mb", "");
			}
			if (0==Double.valueOf((map.get("md")+""))) {
				map.put("md", "");
			}
			if (0==Double.valueOf((map.get("mc")+""))) {
				map.put("mc", "");
			}
			if (0==Double.valueOf((map.get("me")+""))) {
				map.put("me", "");
			}
		}
		map=new HashMap<Object, Object>();
		map.put("cdepcode", "合计");
		map.put("lmd", mdtotal.setScale(2).add(new BigDecimal("0.00")));
		map.put("lmc", mctotal.setScale(2).add(new BigDecimal("0.00")));
		map.put("me", metotal.setScale(2).add(new BigDecimal("0.00")));
		map.put("md", mdtotal);
		map.put("mc", mctotal);
		if (map.get("mb")!=null&&0==Double.valueOf((map.get("mb")+""))) {
			map.put("mb", "");
		}
		if (map.get("md")!=null&&0==Double.valueOf((map.get("md")+""))) {
			map.put("md", "");
		}
		if (map.get("mc")!=null&&0==Double.valueOf((map.get("mc")+""))) {
			map.put("mc", "");
		}
		if (map.get("me")!=null&&0==Double.valueOf((map.get("me")+""))) {
			map.put("me", "");
		}
		int a1=mbcount.compareTo(new BigDecimal("0"));//期初余额合计(mbcount不是绝对值)
		if (a1==-1) {
			map.put("mb_direction", "贷");
		}else if(a1==0){
			map.put("mb_direction", "平");
		}else if (a1==1) {
			map.put("mb_direction", "借");
		}
		int a2=mecount.compareTo(new BigDecimal("0"));//期末余额合计(mecount不是绝对值)
		if (a2==-1) {
			map.put("me_direction", "贷");
		}else if(a2==0){
			map.put("me_direction", "平");
		}else if (a2==1) {
			map.put("me_direction", "借");
		}
		collects.add(map);
		}
		map=new HashMap<Object, Object>();
		Integer total = getcollectcount.size();
		map.put("total", total);
		if ((total/Integer.valueOf(pageSize))==0) {
			total=(total/Integer.valueOf(pageSize));
		}else {
			total=(total/Integer.valueOf(pageSize))+1;
		}
		map.put("pages", total);
		map.put("rows", collects);
		return map;
	}
	
	//整理凭证列表
	@RequestMapping(params = "neatenGlvoucher")
	@ResponseBody
	public ArrayList<GlAccvouch> neatenGlvoucher(HttpServletRequest request){
		ArrayList<GlAccvouch> list=new ArrayList<GlAccvouch>();
		String kj_month = request.getParameter("month");
		if(kj_month!=null){
			String database=request.getSession().getAttribute("database").toString();
			String selectSql = SystemUtil.getSelectSql("A",request);
			list=glAccvouchservice.findGlAccvouchsBysql2(database,database,selectSql);
		}
		for (GlAccvouch glAccvouch : list) {
			String Ino_id = glAccvouch.getIno_id().toString();
			if(Ino_id.length()==1){
				Ino_id="000"+Ino_id;
			}else if(Ino_id.length()==2){
				Ino_id="00"+Ino_id;
			}else if(Ino_id.length()==3){
				Ino_id="0"+Ino_id;
			}
			glAccvouch.setI_id(glAccvouch.getCsign()+"-"+Ino_id);
		}
		return list;
	}
	//整理凭证确定
	@RequestMapping(params = "neaten_ok")
	@ResponseBody
	public JSONObject neaten_ok(HttpServletRequest request){
		JSONObject jsonObject = new JSONObject(); 
		try {
			glAccvouchservice.neaten(request);
			jsonObject.put("type", "1");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("type", "-1");
		}
		return jsonObject;
	}
	
	
	//部门总账
	@RequestMapping(params = "getdeptaccount")
	@ResponseBody
	public Map<Object, Object> getdeptaccount(HttpServletRequest request){
		String data=request.getParameter("data");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		Map<Object, Object> map=new HashMap<Object, Object>();
		//期初sql
		StringBuffer Initialbalancesql=new StringBuffer("select ccode,cdept_id,sum(md - mc) as mb from " + request.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().substring(0,4) + ".dbo.gl_accvouch gl_accvouch  where isnull(iflag,0) <> 1");
		//发生sql
		StringBuffer happensql1=new StringBuffer("");
		if (jsonmap.get("isbilling").toString().equals("false")) {
			Initialbalancesql.append("and (iperiod = 0 or ibook = 1)");
		}
		Initialbalancesql.append(" and cdept_id is not null and iperiod < "+jsonmap.get("monthbegin").toString().substring(5) +" group by ccode,cdept_id");
		//累计发生sql
		StringBuffer cumulativehappensql1=new StringBuffer("");
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			happensql1.append("select ccode,cdept_id, md, mc from " + request.getSession().getAttribute("database").toString().substring(0,11)+i + " .dbo.gl_accvouch where isnull(iflag,0) <> 1");
			cumulativehappensql1.append("select ccode,cdept_id, md, mc from " + request.getSession().getAttribute("database").toString().substring(0,11)+i + " .dbo.gl_accvouch where isnull(iflag,0) <> 1");
			if (String.valueOf(jsonmap.get("isbilling")).equals("false")) {
				happensql1.append(" and (iperiod = 0 or ibook = 1)");
				cumulativehappensql1.append(" and (iperiod = 0 or ibook = 1)");
			}
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				happensql1.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + "");
			}else {
				happensql1.append(" and iperiod >= 1");
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				cumulativehappensql1.append(" and cdept_id is not null and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + " and iperiod <= " + jsonmap.get("monthend").toString().substring(5) + "");
				happensql1.append(" and iperiod <= "+ jsonmap.get("monthend").toString().substring(5) +"");
			}else {
				cumulativehappensql1.append("and cdept_id is not null and iperiod >= " + jsonmap.get("monthend").toString().substring(5) + " and iperiod <= " + 12 + "");
				happensql1.append(" and iperiod <= 12");
			}
			if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				cumulativehappensql1.append(" union all ");
				happensql1.append(" union all ");
			}
		}
		//修改发生sql
		StringBuffer happensql2=new StringBuffer("select ccode, cdept_id, sum(md) md, sum(mc) mc from ");
		happensql2.append("("+happensql1+") ssc group by ccode, cdept_id");
		//修改累计发生sql
		StringBuffer cumulativehappensql2=new StringBuffer("select ccode, cdept_id, sum(md) lmd, sum(mc) lmc from ");
		cumulativehappensql2.append("(" + cumulativehappensql1 + ") ssd group by ccode, cdept_id");
		
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")||pageSize.equals("NaN")) {
			pageSize="500";
		}
		String a = "";
		String b="";
		if(pageSize.equals("全部")){
			a="";
			b="*";
		}else {
			a=pageSize;
			b=(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize) +"";
		}
		List<Map<Object, Object>> deptaccounts = glAccvouchService.getdeptaccount(request.getSession().getAttribute("database").toString(),String.valueOf(jsonmap.get("isbilling")),Initialbalancesql.toString(),
		happensql2.toString(),cumulativehappensql2.toString(),jsonmap.get("deptcode").toString(),a,b);
		
		List<Map<Object, Object>> deptaccountcount= glAccvouchService.getdeptaccountcount(request.getSession().getAttribute("database").toString(),String.valueOf(jsonmap.get("isbilling")),Initialbalancesql.toString(),
				happensql2.toString(),cumulativehappensql2.toString(),jsonmap.get("deptcode").toString(),a,b);
		if (deptaccounts!=null&&deptaccounts.size()>0) {
		
		BigDecimal mbtotal=new BigDecimal("0");//期初余额合计
		BigDecimal mdtotal=new BigDecimal("0");//借方
		BigDecimal mctotal=new BigDecimal("0");//贷方
		BigDecimal lmdtotal=new BigDecimal("0");//累计借方
		BigDecimal lmctotal=new BigDecimal("0");//累计贷方
		BigDecimal metotal=new BigDecimal("0");//期末余额
		BigDecimal mecount=new BigDecimal("0");//期末余额(不是绝对值)
		BigDecimal mbcount=new BigDecimal("0");//期初余额(不是绝对值)
		for (int i = 0; i < deptaccounts.size(); i++) {
			map = deptaccounts.get(i);
			int mb_direction = new BigDecimal(map.get("mb").toString()).compareTo(new BigDecimal(0)); //期初余额比较
			mbcount=mbcount.add(new BigDecimal(map.get("mb").toString()));
			//mb_direction 期初方向
			if (-1==mb_direction) {
				map.put("mb_direction", "贷");
			}else if (0==mb_direction) {
				map.put("mb_direction", "平");
			}else if (1==mb_direction) {
				map.put("mb_direction", "借");
			}
			//map.put("mb", new BigDecimal(map.get("me").toString()).abs());
			
			int me_direction = new BigDecimal(map.get("me").toString()).compareTo(new BigDecimal(0)); //期末余额比较
			mecount=mecount.add(new BigDecimal(map.get("me").toString()));
			//me_direction 期末方向
			if (-1==me_direction) {
				map.put("me_direction", "贷");
			}else if (0==me_direction) {
				map.put("me_direction", "平");
			}else if (1==me_direction) {
				map.put("me_direction", "借");
			}
			
			
			
			map.put("me", new BigDecimal(map.get("me")+"").add(new BigDecimal("0.00")).setScale(2).abs());
			map.put("mb", new BigDecimal(map.get("mb")+"").add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("md", new BigDecimal(map.get("md")+"").add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("mc", new BigDecimal(map.get("mc")+"").add(new BigDecimal("0.00")).setScale(2).toString());
			
			if (Double.valueOf(map.get("me")+"")==0.00) {
				map.put("me", "");
			}
			if (Double.valueOf(map.get("mb")+"")==0.00) {
				map.put("mb", "");
			}
			if (Double.valueOf(map.get("md")+"")==0.00) {
				map.put("md", "");
			}
			if (Double.valueOf(map.get("mc")+"")==0.00) {
				map.put("mc", "");
			}
			if (map.get("isfinalstage").toString().equals("true")) {
				if (!"".equals(map.get("mb"))) {
					mbtotal=mbtotal.add(new BigDecimal(map.get("mb").toString()));
				}
				if (!"".equals(map.get("md"))) {
					mdtotal=mdtotal.add(new BigDecimal(map.get("md").toString()));
				}
				if (!"".equals(map.get("mc"))) {
					mctotal=mctotal.add(new BigDecimal(map.get("mc").toString()));
				}
				if (!"".equals(map.get("lmd"))) {
					lmdtotal=lmdtotal.add(new BigDecimal(map.get("lmd").toString()));
				}
				if (!"".equals(map.get("lmd"))) {
					lmctotal=lmctotal.add(new BigDecimal(map.get("lmc").toString()));
				}
				if (!"".equals(map.get("me"))) {
					metotal=metotal.add(new BigDecimal(map.get("me").toString()));
				}
			}
		}
		map=new HashMap<Object, Object>();
		map.put("cCode", "合计");
		if (mbtotal.compareTo(new BigDecimal("0"))!=0) {
			map.put("mb", mbtotal.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if (mdtotal.compareTo(new BigDecimal("0"))!=0) {
			map.put("md", mdtotal.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if (mctotal.compareTo(new BigDecimal("0"))!=0) {
			map.put("mc", mctotal.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if (metotal.compareTo(new BigDecimal("0"))!=0) {
			map.put("me", metotal.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if (lmctotal.compareTo(new BigDecimal("0"))!=0) {
			map.put("lmc", lmctotal.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		if (lmdtotal.compareTo(new BigDecimal("0"))!=0) {
			map.put("lmd", lmdtotal.add(new BigDecimal("0.00")).setScale(2).toString());
		}
		int a1=mbcount.compareTo(new BigDecimal("0"));//期初余额合计(mbcount不是绝对值)
		if (a1==-1) {
			map.put("mb_direction", "贷");
		}else if(a1==0){
			map.put("mb_direction", "平");
		}else if (a1==1) {
			map.put("mb_direction", "借");
		}
		int a2=mecount.compareTo(new BigDecimal("0"));//期末余额合计(mecount不是绝对值)
		if (a2==-1) {
			map.put("me_direction", "贷");
		}else if(a2==0){
			map.put("me_direction", "平");
		}else if (a2==1) {
			map.put("me_direction", "借");
		}
		deptaccounts.add(map);
		map=new HashMap<Object, Object>();
		map.put("rows", deptaccounts);
		Integer total = deptaccountcount.size();
		map.put("total", total);
		if ((total/Integer.valueOf(pageSize))==0) {
			total=(total/Integer.valueOf(pageSize));
		}else {
			total=(total/Integer.valueOf(pageSize))+1;
		}
		map.put("pages", total);
		
		}else {
			map.put("rows", "");
		}
		return map;
	}
	
	//部门科目明细账
	@SuppressWarnings("deprecation")
	@RequestMapping(params = "deptdetailsacc")
	@ResponseBody
	public Map<Object, Object> deptdetailsacc(HttpServletRequest request){//部门科目明细账
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object>jsonmap=jsonmaps.get(0);
		
		//部门条件
		StringBuffer deptcondition=new StringBuffer("");
		if (jsonmap.get("departmentbegin")!=null&&(String.valueOf(jsonmap.get("departmentbegin")).trim().length()>0)) {
			deptcondition.append("and (aaa.cdept_id >= '"+ jsonmap.get("departmentbegin") + "')");
		}
		if (jsonmap.get("departmentend")!=null&&(String.valueOf(jsonmap.get("departmentend")).trim().length()>0)) {
			deptcondition.append("and (aaa.cdept_id <= '"+jsonmap.get("departmentend")+"') ");
		}
		//期初sql
		StringBuffer Initialbalancesql=new StringBuffer("select  gl_accvouch.cdept_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc,sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook,");
		Initialbalancesql.append(jsonmap.get("monthbegin").toString().substring(0, 4)+" as syear from "+request.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().substring(0, 4)+".dbo.gl_accvouch gl_accvouch "
		+ "left join "+request.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().substring(0, 4)+".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1");
		if (!(boolean) jsonmap.get("isbilling")) {
			Initialbalancesql.append(" and (iperiod = 0 or ibook = 1)");
		}
		Initialbalancesql.append("and code.bdept = 1 and iperiod <"+jsonmap.get("monthbegin").toString().substring(5)+" ");
		Initialbalancesql.append(" and gl_accvouch.ccode like '" + jsonmap.get("subject").toString() + "%' group by gl_accvouch.cdept_id ");
		//累计发生sql
		StringBuffer cumulativehappensql=new StringBuffer("");
		//发生sql
		StringBuffer happensql=new StringBuffer("");
		StringBuffer thismonthsql=new StringBuffer("");//本月合计sql
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			//账套
			String account=request.getSession().getAttribute("database").toString().substring(0,11)+i;
			happensql.append("select gl_accvouch.cdept_id, cdigest,convert(varchar(10),dbill_date,20) as dbill_date,csign, ino_id, md, mc,md - mc as me, iperiod,'1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4)+right('0000'+cast(inid as varchar),4) as px, cperson_id, citem_id, csup_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook,"+i+" as syear From "+account+".dbo.gl_accvouch gl_accvouch left join "+account+".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
			thismonthsql.append("select gl_accvouch.cdept_id, '本月合计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, sum( md), sum(mc), 0 as me, iperiod, '99998888' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook,"+i+" as syear from " + account + ".dbo.gl_accvouch gl_accvouch left join "+account+".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
			cumulativehappensql.append("select gl_accvouch.cdept_id, '累    计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id,isnull((select sum(md) from "+account+".dbo.gl_accvouch gl_accvouch00  where ccode like '" + jsonmap.get("subject") + "%' and cdept_id = gl_accvouch.cdept_id and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0),isnull((select sum(mc) from "+account+".dbo.gl_accvouch gl_accvouch00  where ccode like '" + jsonmap.get("subject") + "%' and cdept_id = gl_accvouch.cdept_id and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0), 0 as me, iperiod, '99999999' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook,"
			+i+" as syear from "+account+".dbo.gl_accvouch gl_accvouch left join "+account+".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1");
			if (!(boolean) jsonmap.get("isbilling")) {
				happensql.append("and (iperiod = 0 or ibook = 1) ");
				thismonthsql.append("and (iperiod = 0 or ibook = 1) ");
				cumulativehappensql.append("and (iperiod = 0 or ibook = 1) ");
			}
			happensql.append("and code.bdept = 1 ");
			thismonthsql.append("and code.bdept = 1 ");
			cumulativehappensql.append("and code.bdept = 1 ");
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				happensql.append("and iperiod >= "+ jsonmap.get("monthbegin").toString().substring(5) +" ");
				thismonthsql.append("and iperiod >= "+jsonmap.get("monthbegin").toString().substring(5)+"");
				cumulativehappensql.append("and iperiod >= "+jsonmap.get("monthbegin").toString().substring(5)+"");
			}else {
				happensql.append("and iperiod >= 1 ");
				thismonthsql.append("and iperiod >=1 ");
				cumulativehappensql.append("and iperiod >= "+jsonmap.get("monthbegin").toString().substring(5)+"");
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append("and iperiod <= " + jsonmap.get("monthend").toString().substring(5) + " ");
				thismonthsql.append(" and iperiod <= "+jsonmap.get("monthend").toString().substring(5)+" ");
				cumulativehappensql.append(" and iperiod <= "+jsonmap.get("monthend").toString().substring(5)+" ");
			}else {
				happensql.append("and iperiod <= 12 ");
				thismonthsql.append(" and iperiod <= 12 ");
				cumulativehappensql.append(" and iperiod <= 12 ");
			}
			happensql.append("and gl_accvouch.ccode like '" + jsonmap.get("subject") + "%'");
			thismonthsql.append("and gl_accvouch.ccode like '" + jsonmap.get("subject") + "%' group by gl_accvouch.cdept_id, iperiod");
			cumulativehappensql.append("and gl_accvouch.ccode like '" + jsonmap.get("subject") + "%' group by gl_accvouch.cdept_id, iperiod ");
			if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append(" union all ");
				thismonthsql.append(" union all ");
				cumulativehappensql.append(" union all ");
			}
		}
		List<Map<Object, Object>> deptdetailsaccs = glAccvouchService.deptdetailsacc(database,Initialbalancesql.toString(),happensql.toString(),thismonthsql.toString(),cumulativehappensql.toString(),deptcondition.toString(),pageSize,(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize));
		List<Map<Object, Object>> listcount = glAccvouchService.deptdetailsacccount(database,Initialbalancesql.toString(),happensql.toString(),thismonthsql.toString(),cumulativehappensql.toString(),deptcondition.toString(),pageSize,(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize));
		String startTime=request.getSession().getAttribute("startTime").toString();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int month = 0;
		try {
			month = df.parse(startTime).getMonth()+1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		BigDecimal accumulation =new BigDecimal("0");//累加余额
		for (int i = 0; i < deptdetailsaccs.size(); i++) {
			Map<Object, Object> map = deptdetailsaccs.get(i);
			StringBuffer setasummary=new StringBuffer();//设置摘要
			if (map.get("cdigest").equals("期初余额")) {
				if (Integer.valueOf(jsonmap.get("monthbegin").toString().substring(5))==1) {
					map.put("cdigest", "上年结转");
				}else {
					map.put("cdigest", "期初余额");
				}
			}else if (map.get("cdigest").equals("本月合计")) {
				if (!(Integer.valueOf(map.get("iperiod").toString())>=month)) {
					map.put("cdigest", "当前合计");
				}else {
					map.put("cdigest", "本月合计");
				}
			}else if (map.get("cdigest").equals("累    计")) {
				if (!(Integer.valueOf(map.get("iperiod").toString())>=month)) {
					map.put("cdigest", "当前累计");
				}else {
					map.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
				}
			}else {
				setasummary.append(map.get("cdigest")+"_");
				if(jsonmap.get("abs_dept").toString().equals("true")){
					if (map.get("cdept_id")!=null&&!"".equals(map.get("cdept_id").toString())) {
						String deptname=departmentService.getDepName(database+".dbo.Department", map.get("cdept_id").toString());
						setasummary.append(deptname+"_");
					}
				}
				
				if(jsonmap.get("abs_person").toString().equals("true")){
					if (map.get("cperson_id")!=null&&!"".equals(map.get("cperson_id").toString())) {
						String person_name=personService.getPersonName(database+".dbo.person", map.get("cperson_id").toString());
						setasummary.append(person_name+"_");
					}
				}
				if(jsonmap.get("abs_project").toString().equals("true")){
					if (map.get("citem_id")!=null&&!"".equals(map.get("citem_id").toString())) {
						String citem_name=ht_GLItemService.getHt_itemName(database+".dbo.HT_GLItem", map.get("citem_id").toString());
						setasummary.append(citem_name+"_");
					}
				}
				if(jsonmap.get("abs_cus").toString().equals("true")){
					if (map.get("ccus_id")!=null&&!"".equals(map.get("ccus_id").toString())) {
						String ccus_name=customerService.getCustName(database+".dbo.customer", map.get("ccus_id").toString());
						setasummary.append(ccus_name+"_");
					}
				}
				if(jsonmap.get("abs_sup").toString().equals("true")){
					if (map.get("csup_id")!=null&&!"".equals(map.get("csup_id").toString())) {
						String csup_name=vendorService.getVendorName(database+".dbo.vendor", map.get("csup_id").toString());
						setasummary.append(csup_name+"_");
					}
				}
				if(jsonmap.get("abs_jsfs").toString().equals("true")){
					if (map.get("csettle")!=null&&!"".equals(map.get("csettle").toString())) {
						String csettle_name=settleStyleService.getcssname(database+".dbo.settleStyle",map.get("csettle").toString());
						setasummary.append(csettle_name+"_");
					}
				}
				if(jsonmap.get("abs_billno").toString().equals("true")){
					if (map.get("cn_id")!=null&&!(String.valueOf(map.get("cn_id"))).equals("")) {
						setasummary.append(map.get("cn_id")+"_");
					}
				}
				
				if(jsonmap.get("abs_date").toString().equals("true")){
					if (map.get("dt_date")!=null&&!(String.valueOf(map.get("dt_date"))).equals("")) {
						setasummary.append(map.get("dt_date")+"_");
					}
				}
				if(jsonmap.get("abs_clerk").toString().equals("true")){
					if (map.get("cname")!=null&&!(String.valueOf(map.get("cname"))).equals("")) {
						setasummary.append(map.get("cname")+"_");
					}
				}

				if (map.get("ibook").toString().equals("0")) {
					setasummary.insert(0, "*");
				}
				char c = setasummary.charAt(setasummary.length()-1);
				if (String.valueOf(c).equals("_")) {
					setasummary = setasummary.deleteCharAt(setasummary.length()-1);
				}
				map.put("cdigest", setasummary);
			}
			if(i==0){
				BigDecimal me=new BigDecimal(map.get("me")+"");
				accumulation=accumulation.add(me);
				map.put("me", accumulation);
			}
			if(i>0){
				Map<Object, Object> map2 = deptdetailsaccs.get(i-1);
				String citem_id = map.get("cdept_id").toString();
				String citem_id2 = map2.get("cdept_id").toString();
				if (citem_id.equals(citem_id2)) {
					BigDecimal me=new BigDecimal(map.get("me")+"");
					accumulation=accumulation.add(me);
					map.put("me", accumulation);
				}else {
					accumulation=new BigDecimal(0);
					BigDecimal me=new BigDecimal(map.get("me")+"");
					accumulation=accumulation.add(me);
					map.put("me", accumulation);
				}
			}
			int a=new BigDecimal(map.get("me")+"").compareTo(new BigDecimal("0"));//累加余额比较0
			if (a==1) {
				map.put("me_direction", "借");
			}else if (a==0) {
				map.put("me_direction", "平");
			}else {
				map.put("me_direction", "贷");
			}
			if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
				map.put("year", String.valueOf(map.get("dbill_date")).substring(0,4));
				map.put("month", String.valueOf(map.get("dbill_date")).substring(5,7));
				map.put("day", String.valueOf(map.get("dbill_date")).substring(8,10));
			}
			if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
				String str=String.valueOf(map.get("csign"))+"-0000";
				String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
				map.put("ino_id2", ino_id);
			}
			map.put("md", new BigDecimal(map.get("md").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("mc", new BigDecimal(map.get("mc").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
			if (new BigDecimal(map.get("md")+"").compareTo(new BigDecimal("0"))==0) {
				map.put("md", "");
			}
			if (new BigDecimal(map.get("mc")+"").compareTo(new BigDecimal("0"))==0) {
				map.put("mc", "");
			}
			if (new BigDecimal(map.get("me")+"").compareTo(new BigDecimal("0"))==0) {
				map.put("me", "");
			}
		}
		List<Map<Object, Object>> subjecttotals = glAccvouchService.getsubjecttotal(database,Initialbalancesql,cumulativehappensql,thismonthsql,deptcondition);
		if (subjecttotals!=null&&subjecttotals.size()>0) {
			Map<Object, Object> mapto = new HashMap<Object, Object>();
			mapto.putAll(subjecttotals.get(0));
			if (!String.valueOf(mapto.get("cdigest")).equals("期初余额")) {
				mapto.put("cdepname", "科目合计");
				mapto.put("me_direction", "平");
				mapto.put("period", "0");
				if (String.valueOf(jsonmap.get("monthbegin")).toString().substring(5).equals("1")) {
					mapto.put("cdigest", "上年结转");
				}else {
					mapto.put("cdigest", "期初余额");
				}
				mapto.put("mc", "");
				mapto.put("md", "");
				deptdetailsaccs.add(mapto);
			}
			accumulation=new BigDecimal("0");
			
			for (int i = 0; i < subjecttotals.size(); i++) {
				Map<Object, Object> map2 = subjecttotals.get(i);
				if (String.valueOf(map2.get("cdigest")).equals("期初余额")) {
					if (String.valueOf(jsonmap.get("monthbegin")).toString().substring(5).equals("1")) {
						map2.put("cdigest", "上年结转");
					}else {
						map2.put("cdigest", "期初余额");
					}
					map2.put("cdepname", "科目合计");
				}else if (String.valueOf(map2.get("cdigest")).equals("本月合计")) {
					if (!(Integer.valueOf(map2.get("iperiod").toString())>=month)) {//登录时的月份
						map2.put("cdigest", "当前合计");
					}else {
						map2.put("cdigest", "本月合计");
					}
				}else if (String.valueOf(map2.get("cdigest")).equals("累    计")) {
					if (!(Integer.valueOf(map2.get("iperiod").toString())>=month)) {//登录时的月份
						map2.put("cdigest", "当前累计");
					}else {
						map2.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
					}
				}
				if (String.valueOf(map2.get("cdigest")).equals("期初余额")) {
					accumulation=new BigDecimal(map2.get("me").toString());
				}else {
					accumulation=accumulation.add(new BigDecimal(map2.get("me").toString()));
				}
				map2.put("md", new BigDecimal(map2.get("md").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
				map2.put("mc", new BigDecimal(map2.get("mc").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
				map2.put("me", new BigDecimal(map2.get("me").toString()).add(new BigDecimal(map2.get("md").toString())).subtract(new BigDecimal(map2.get("mc").toString())).setScale(2).toString());
				
				int b = new BigDecimal(map2.get("me")+"").compareTo(new BigDecimal("0"));
				if (b==1) {
					map2.put("me_direction", "借");
				}else if (b==0) {
					map2.put("me_direction", "平");
				}else if (b==-1) {
					map2.put("me_direction", "贷");
				}
				
				if (new BigDecimal(map2.get("md")+"").compareTo(new BigDecimal("0"))==0) {
					map2.put("md", "");
				}
				if (new BigDecimal(map2.get("mc")+"").compareTo(new BigDecimal("0"))==0) {
					map2.put("mc", "");
				}
				if (new BigDecimal(map2.get("me")+"").compareTo(new BigDecimal("0"))==0) {
					map2.put("me", "");
				}
				deptdetailsaccs.add(map2);
			}
		}
		
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("rows", deptdetailsaccs);
		map.put("total", listcount.size());
		return map;
	}
	
	//部门明细账
	@RequestMapping(params = "getdeptdetail")
	@ResponseBody
	public Map<Object, Object> getdeptdetail(HttpServletRequest request){
		String database = request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String startaccount=database.substring(0,database.length()-4)+jsonmap.get("monthbegin").toString().substring(0,4);
		//期初sql
		StringBuffer Initialbalancesql=new StringBuffer("select gl_accvouch.ccode, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook,"+jsonmap.get("monthbegin").toString().substring(0,4)+" as syear from ");
		Initialbalancesql.append(startaccount+".dbo.gl_accvouch gl_accvouch left join "+startaccount+" .dbo.Code as Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
		if (jsonmap.get("isbilling").toString().equals("false")) {
			Initialbalancesql.append("and (iperiod = 0 or ibook = 1)");
		}
		Initialbalancesql.append("and Code.bdept = 1 and iperiod <" + jsonmap.get("monthbegin").toString().substring(5) + " and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%' group by gl_accvouch.cdept_id,gl_accvouch.ccode ");
		//发生sql
		StringBuffer happensql=new StringBuffer("");
		//本月sql
		StringBuffer thismonth=new StringBuffer("");
		//累计发生sql
		StringBuffer cumulativehappensql=new StringBuffer("");
		
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			database=database.substring(0, database.length()-4)+i;
			happensql.append("select gl_accvouch.ccode, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod,'1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4)+right('0000'+cast(inid as varchar),4) as px, cperson_id, citem_id, csup_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook, "+i+" as syear From "+database+".dbo.gl_accvouch gl_accvouch left join "+database+".dbo.Code as Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
			thismonth.append("select gl_accvouch.ccode, '本月合计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, sum( md), sum(mc), 0 as me, iperiod, '99998888' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + i + " as syear from " + database + ".dbo.gl_accvouch gl_accvouch left join " + database + ".dbo.Code as Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1");
			cumulativehappensql.append("select gl_accvouch.ccode, '累    计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, isnull((select sum(md) from " + database + ".dbo.gl_accvouch gl_accvouch00  where cdept_id  like '" + jsonmap.get("deptcode") + "%' and ccode = gl_accvouch.ccode and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0),isnull((select sum(mc) from " + database + ".dbo.gl_accvouch gl_accvouch00  where cdept_id like '" + jsonmap.get("deptcode") + "%' and ccode = gl_accvouch.ccode and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0), 0 as me, iperiod, '99999999' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + i + " as syear from " +  database + ".dbo.gl_accvouch gl_accvouch left join " +  database + ".dbo.Code as Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1");
			if (String.valueOf(jsonmap.get("isbilling")).equals("false")) {
				thismonth.append(" and (iperiod = 0 or ibook = 1)");
				happensql.append(" and (iperiod = 0 or ibook = 1)");
				cumulativehappensql.append(" and (iperiod = 0 or ibook = 1)");
			}
			happensql.append("and Code.bdept = 1");
			thismonth.append("and Code.bdept = 1");
			cumulativehappensql.append("and Code.bdept = 1");
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				happensql.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + "");
				thismonth.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + "");
				cumulativehappensql.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + "");
			}else {
				happensql.append(" and iperiod >= 1");
				thismonth.append(" and iperiod >= 1");
				cumulativehappensql.append(" and iperiod >= 1");
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append(" and iperiod <= "+ jsonmap.get("monthend").toString().substring(5) +"");
				thismonth.append(" and iperiod <= "+ jsonmap.get("monthend").toString().substring(5) +"");
				cumulativehappensql.append(" and iperiod <= "+ jsonmap.get("monthend").toString().substring(5) +"");
			}else {
				happensql.append(" and iperiod <= 12");
				thismonth.append(" and iperiod <= 12");
				cumulativehappensql.append(" and iperiod <= 12");
			}
			happensql.append("and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%'");
			thismonth.append("and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%' group by gl_accvouch.ccode, iperiod");
			cumulativehappensql.append("and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%' group by gl_accvouch.ccode,iperiod");
			if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				cumulativehappensql.append(" union all ");
				happensql.append(" union all ");
				thismonth.append(" union all ");
			}
		}
		String startTime=request.getSession().getAttribute("startTime").toString();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int month = 0;
		try {
			month = df.parse(startTime).getMonth()+1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String subjectcode=String.valueOf(jsonmap.get("subjectcode"));
		if(String.valueOf(jsonmap.get("flag")).equals("deptaccount")){
			if(subjectcode!=null&&!subjectcode.equals("")){
				subjectcode=" and aaa.ccode = '"+subjectcode+"'";
			}else{
				subjectcode=" and aaa.ccode like '"+subjectcode+"%'";
			}
		}
		if(subjectcode==null||"null".equals(String.valueOf(subjectcode))){
			subjectcode="";
		}
		String sqlstr="with q as ( select aaa.ccode, Code.cCode_Name, cdigest, dbill_date, isnull(csign,'') csign, ino_id, md, mc, me, iperiod,px, isnull(cperson_id,'') as cperson_id, isnull(citem_id, '') as citem_id, isnull(csup_id,'') as csup_id, isnull( ccus_id, '') as ccus_id, isnull( csettle, '') as csettle, isnull(cn_id, '') as cn_id , isnull( dt_date, '') as dt_date, isnull(cname, '') as cname, ibook, syear From "+"(" + Initialbalancesql +" Union All "+happensql+" Union All "+thismonth +" Union All "+ cumulativehappensql +") aaa Left join "+database+".dbo.Code on aaa.ccode = Code.ccode Where 1=1 "+subjectcode+" and (md <> 0 or mc <> 0 or me <> 0)) select * from q order by  q.ccode, syear, iperiod, px ";
		String countsql="with q as ( select aaa.ccode, Code.cCode_Name, cdigest, dbill_date, isnull(csign,'') csign, ino_id, md, mc, me, iperiod,px, isnull(cperson_id,'') as cperson_id, isnull(citem_id, '') as citem_id, isnull(csup_id,'') as csup_id, isnull( ccus_id, '') as ccus_id, isnull( csettle, '') as csettle, isnull(cn_id, '') as cn_id , isnull( dt_date, '') as dt_date, isnull(cname, '') as cname, ibook, syear From "+"(" + Initialbalancesql +" Union All "+happensql+" Union All "+thismonth +" Union All "+ cumulativehappensql +") aaa Left join "+database+".dbo.Code on aaa.ccode = Code.ccode Where 1=1 "+subjectcode+" and (md <> 0 or mc <> 0 or me <> 0)) select * from q";
		List<Map<Object, Object>> deptdetails=glAccvouchService.getdeptdetail(sqlstr);
		BigDecimal cumulationamount=new BigDecimal("0");
		String dbill_date="";
		for (int i = 0; i < deptdetails.size(); i++) {
			Map<Object, Object> map = deptdetails.get(i);
		StringBuffer setasummary=new StringBuffer();//设置摘要
		if (String.valueOf(map.get("cdigest")).equals("期初余额")) {
			if(jsonmap.get("monthbegin").equals("1")){
				map.put("cdigest", "上年结转");
			}else {
				map.put("cdigest", "期初余额");
			}
		}else if (String.valueOf(map.get("cdigest")).equals("本月合计")) {
			if ((Integer.valueOf(map.get("iperiod").toString())>=month)) {//登录时的月份
				map.put("cdigest", "当前合计");
			}else {
				map.put("cdigest", "本月合计");
			}
		}else if (String.valueOf(map.get("cdigest")).equals("累    计")) {
			if ((Integer.valueOf(map.get("iperiod").toString())>=month)) {//登录时的月份
				map.put("cdigest", "当前累计");
			}else {
				map.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
			}
		}else {
			setasummary.append(map.get("cdigest")+"_");
		if(jsonmap.get("abs_dept").toString().equals("true")){
			if (map.get("cdept_id")!=null&&!"".equals(map.get("cdept_id").toString())) {
				String deptname=departmentService.getDepName(database+".dbo.Department", map.get("cdept_id").toString());
				setasummary.append(deptname+"_");
			}
		}
		
		if(jsonmap.get("abs_person").toString().equals("true")){
			if (map.get("cperson_id")!=null&&!"".equals(map.get("cperson_id").toString())) {
				String person_name=personService.getPersonName(database+".dbo.person", map.get("cperson_id").toString());
				setasummary.append(person_name+"_");
			}
		}
		if(jsonmap.get("abs_project").toString().equals("true")){
			if (map.get("citem_id")!=null&&!"".equals(map.get("citem_id").toString())) {
				String citem_name=ht_GLItemService.getHt_itemName(database+".dbo.HT_GLItem", map.get("citem_id").toString());
				setasummary.append(citem_name+"_");
			}
		}
		if(jsonmap.get("abs_cus").toString().equals("true")){
			if (map.get("ccus_id")!=null&&!"".equals(map.get("ccus_id").toString())) {
				String ccus_name=customerService.getCustName(database+".dbo.customer", map.get("ccus_id").toString());
				setasummary.append(ccus_name+"_");
			}
		}
		if(jsonmap.get("abs_sup").toString().equals("true")){
			if (map.get("csup_id")!=null&&!"".equals(map.get("csup_id").toString())) {
				String csup_name=vendorService.getVendorName(database+".dbo.vendor", map.get("csup_id").toString());
				setasummary.append(csup_name+"_");
			}
		}
		if(jsonmap.get("abs_jsfs").toString().equals("true")){
			if (map.get("csettle")!=null&&!"".equals(map.get("csettle").toString())) {
				String csettle_name=settleStyleService.getcssname(database+".dbo.settleStyle",map.get("csettle").toString());
				setasummary.append(csettle_name+"_");
			}
		}
		if(jsonmap.get("abs_billno").toString().equals("true")){
			if (map.get("cn_id")!=null&&!(String.valueOf(map.get("cn_id"))).equals("")) {
				setasummary.append(map.get("cn_id")+"_");
			}
		}
		
		if(jsonmap.get("abs_date").toString().equals("true")){
			if (map.get("dt_date")!=null&&!(String.valueOf(map.get("dt_date"))).equals("")) {
				setasummary.append(map.get("dt_date")+"_");
			}
		}
		if(jsonmap.get("abs_clerk").toString().equals("true")){
			if (map.get("cname")!=null&&!(String.valueOf(map.get("cname"))).equals("")) {
				setasummary.append(map.get("cname")+"_");
			}
		}

		if (map.get("ibook").toString().equals("0")) {
			setasummary.insert(0, "*");
		}
		char c = setasummary.charAt(setasummary.length()-1);
		if (String.valueOf(c).equals("_")) {
			setasummary = setasummary.deleteCharAt(setasummary.length()-1);
		}
			map.put("cdigest", setasummary);
		}
			if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
				String str=String.valueOf(map.get("csign"))+"-0000";
				String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
				map.put("ino_id2", ino_id);
			}
			if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
				map.put("year", String.valueOf(map.get("dbill_date")).substring(0,4));
				map.put("month", String.valueOf(map.get("dbill_date")).substring(5,7));
				map.put("day", String.valueOf(map.get("dbill_date")).substring(8,10));
			}
//				if (String.valueOf(map.get("cdigest")).equals("本月合计")) {
//					Map<Object, Object>mapcopy=new HashMap<Object, Object>();
//					mapcopy.putAll(map);
//					mapcopy.put("cdigest", "累计");
//					deptdetails.add(i+1,mapcopy);
//				}
			
//				BigDecimal mb=new BigDecimal(0);
//				if (!(map.get("md")==null)||!"".equals(map.get("md")+"")) {
//					mb=new BigDecimal(map.get("md")+"");
//				}
//				BigDecimal mc=new BigDecimal(0);
//				if (!(map.get("mc")==null)||!"".equals(map.get("mc")+"")) {
//					mc=new BigDecimal(map.get("mc")+"");
//				}
			BigDecimal me=new BigDecimal(0);
			if (!(map.get("me")==null)||!"".equals(map.get("me")+"")) {
				me=new BigDecimal(map.get("me")+"");
			}
			cumulationamount=cumulationamount.add(me);
			map.put("me", cumulationamount);
			int a = cumulationamount.compareTo(new BigDecimal("0"));
			if (a==1) {
				map.put("direction", "借");
			}else if (a==-1) {
				map.put("direction", "贷");
			}else if (a==0) {
				map.put("direction", "平");
			}
			if (map.get("px").toString().equals("99999999")) {
				cumulationamount=new BigDecimal(0);
			}
			
			
			map.put("md", new BigDecimal(map.get("md").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("mc", new BigDecimal(map.get("mc").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
			if(new BigDecimal(map.get("md")+"").compareTo(new BigDecimal("0"))==0){
				map.put("md", "");
			}
			if(new BigDecimal(map.get("mc")+"").compareTo(new BigDecimal("0"))==0){
				map.put("mc", "");
			}
			if(new BigDecimal(map.get("me")+"").compareTo(new BigDecimal("0"))==0){
				map.put("me", "");
			}
			
			if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
				dbill_date = map.get("dbill_date").toString();
			}
			if (i!=0){
				if (!"".equals(dbill_date)) {
					map.put("year", dbill_date.substring(0,4));
					map.put("month", dbill_date.substring(5,7));
				}
			}
		}
		
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		List<Map<Object, Object>> getdeptdetail = glAccvouchService.getdeptdetail(countsql);
		Map<Object, Object> map=new HashMap<Object, Object>();
		Integer total = getdeptdetail.size();
		map.put("total", total);
		if ((total/Integer.valueOf(pageSize))==0) {
			total=(total/Integer.valueOf(pageSize));
		}else {
			total=(total/Integer.valueOf(pageSize))+1;
		}
		map.put("pages", total);
		map.put("rows", deptdetails);
		return map;
	}
	

	@RequestMapping(params = "getAccountBookList")
	@ResponseBody
	public Map<Object, Object> getAccountBookList(HttpServletRequest request){
		//String database1=request.getSession().getAttribute("database").toString()+".dbo.gl_accvouch ";
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			//pageSize="50";
			pageSize="300";
		}
		String data=request.getParameter("data");
		HashMap<String,String> condition=JSON.parseObject(data,HashMap.class);
		String sql2="";//sqL语句where后面的条件
		//String sql = "Select top "+pageSize+" * from (select ROW_NUMBER() over (partition by isnull(1,1) order by dbill_date ) rn, iperiod,convert(varchar(10),dbill_date,23) as singletime,Isnull(csign,'')as csign,ino_id as vouchernum ,IsNull(Min(REPLACE(STR(inid,4),'','0')+IsNull(cdigest,'')),'') as cdigest,Sum(md) as md,isnull(max(ctext1),'') as remark1,isnull(max(ctext2),'')as remark2,isnull(cbill,'') as cbill,isnull(ccashier,'')as ccashier,isnull(ccheck,'')as ccheck,isnull(cbook,'') as cbook,isnull(iflag,0)as iflag,isnull(max(coutsysname),'')as coutsysname From "+database1+" Where 0=0 ";
		String startdate = String.valueOf(condition.get("beginDate"));
		String enddate = String.valueOf(condition.get("endDate"));
		String startyear = startdate.equals("")?"2017":startdate.substring(0, 4);
		String endyear = enddate.equals("")?"2017":enddate.substring(0, 4);
		String account = request.getSession().getAttribute("account").toString();
		//String database1=request.getSession().getAttribute("database").toString()+".dbo.gl_accvouch "	
		String sql = "";
		for(int i = Integer.parseInt(startyear);i <= Integer.parseInt(endyear);i++){
			sql = sql+"Select * From HTDATA_"+account+"_"+String.valueOf(i)+".dbo.gl_accvouch "	;
			if (i != Integer.parseInt(endyear)) {
				sql = sql +" union ";
			}
		}
		sql = " from ("+sql+") gl_accvouch where 0=0 ";
		if (condition.get("monthoryear").equals("1")) {
			sql+=" and iperiod = '"+condition.get("month")+"'";
			sql2+=" and iperiod = '"+condition.get("month")+"'";
		}else{
			sql+=" and convert(varchar(10),dBill_date,23) between '"+condition.get("beginDate")+"' and '"+condition.get("endDate")+"'";
			sql2+=" and convert(varchar(10),dBill_date,23) between '"+condition.get("beginDate")+"' and '"+condition.get("endDate")+"'";
		}
		if(!StringUtils.isBlank(condition.get("ctext1"))){
			if (condition.get("ctext1Like").equals("1")) {
				sql+=" and ctext1 = '%"+condition.get("ctext1")+"%'";
				sql2+=" and ctext1 = '%"+condition.get("ctext1")+"%'";
			}else if(condition.get("ctext1Like").equals("0")){
				sql+=" and ctext1 = '"+condition.get("ctext1")+"'";
				sql2+=" and ctext1 = '"+condition.get("ctext1")+"'";
			}
		}

		if(!StringUtils.isBlank(condition.get("ctext2"))){
			if (condition.get("ctext2Like").equals("1")) {
				sql+=" and ctext2 like '%"+condition.get("ctext2")+"%'";
				sql2+=" and ctext2 like '%"+condition.get("ctext2")+"%'";
			}else if(condition.get("ctext2Like").equals("0")){
				sql+=" and ctext2 = '"+condition.get("ctext2")+"'";
				sql2+=" and ctext2 = '"+condition.get("ctext2")+"'";
			}
		}
		
	
		if (!StringUtils.isBlank(condition.get("externalsystem"))) {//外部系统
			if(condition.get("externalsystem").equals("a")){
				sql+=" and (GL_Accvouch.coutsysname = 'IA' or GL_Accvouch.coutsysname = '存货核算')";
				sql2+=" and (GL_Accvouch.coutsysname = 'IA' or GL_Accvouch.coutsysname = '存货核算')";
			}
			if(condition.get("externalsystem").equals("b")){
				sql+=" and (GL_Accvouch.coutsysname = 'AP' or GL_Accvouch.coutsysname = '应付款管理')";
				sql2+=" and (GL_Accvouch.coutsysname = 'AP' or GL_Accvouch.coutsysname = '应付款管理')";
			}
			if(condition.get("externalsystem").equals("c")){
				sql+=" and (GL_Accvouch.coutsysname = 'FA' or GL_Accvouch.coutsysname = '固定资产')";
				sql2+=" and (GL_Accvouch.coutsysname = 'FA' or GL_Accvouch.coutsysname = '固定资产')";
			}
		}
		if (condition.get("dt_date")!=null&&!"".equals(condition.get("dt_date"))) {
			sql+=" and convert(varchar(10),dt_date,23) between '"+condition.get("dt_date")+"' and '"+condition.get("dt_date")+"'";
			sql2+=" and convert(varchar(10),dt_date,23) between '"+condition.get("dt_date")+"' and '"+condition.get("dt_date")+"'";
		}
		if (condition.get("csettle")!=null&&!"".equals(condition.get("csettle"))) {
			sql+=" and csettle ='"+condition.get("csettle")+"'";
			sql2+=" and csettle ='"+condition.get("csettle")+"'";
		}
		//借贷方向存在问题
		String JorD="md";
		if (StringUtils.isBlank(condition.get("direction"))) {
			if(condition.get("beginMoney")!=null&&!"".equals(condition.get("beginMoney"))){
				sql+="and (case when md <> 0 then md else mc end)>='"+condition.get("beginMoney")+"'";
			}
			if(condition.get("endMoney")!=null&&!"".equals(condition.get("endMoney"))){
				sql+="and (case when md <> 0 then md else mc end)<='"+condition.get("endMoney")+"'";
			}
		}
		if (condition.get("direction").equals("md")) {
			sql+="and (md<>0 ";
			if(condition.get("beginMoney")!=null&&!"".equals(condition.get("beginMoney"))){
				sql+="and md>='"+condition.get("beginMoney")+"'";
			}
			if(condition.get("endMoney")!=null&&!"".equals(condition.get("endMoney"))){
				sql+="and md<='"+condition.get("endMoney")+"'";
			}
			sql+=")";
		}
		if (condition.get("direction").equals("mc")) {
			JorD = "mc";
			sql+="and (mc<>0 ";
			if(condition.get("beginMoney")!=null&&!"".equals(condition.get("beginMoney"))){
				sql+="and mc>='"+condition.get("beginMoney")+"'";
			}
			if(condition.get("endMoney")!=null&&!"".equals(condition.get("endMoney"))){
				sql+="and mc<='"+condition.get("endMoney")+"'";
			}
			sql+=")";
		}
		
		if (condition.get("cdigest")!=null&&!"".equals(condition.get("cdigest"))) {
			sql+=" and cdigest like '%"+condition.get("cdigest")+"%'";
			sql2+=" and cdigest like '%"+condition.get("cdigest")+"%'";
		}
		if (condition.get("cdept_id")!=null&&!"".equals(condition.get("cdept_id"))) {//部门
			sql+=" and cdept_id = '"+condition.get("cdept_id")+"'";
			sql2+=" and cdept_id = '"+condition.get("cdept_id")+"'";
		}
		if (condition.get("citem_id")!=null&&!"".equals(condition.get("citem_id"))) {
			sql+=" and (citem_id = '"+condition.get("citem_id")+"' and citem_class = '77')";
			sql2+=" and (citem_id = '"+condition.get("citem_id")+"' and citem_class = '77')";
		}
		if (condition.get("cperson_id")!=null&&!"".equals(condition.get("cperson_id"))) {
			sql+=" and cperson_id = '"+condition.get("cperson_id")+"'";
			sql2+=" and cperson_id = '"+condition.get("cperson_id")+"'";
		}
		if (condition.get("csup_id")!=null&&!"".equals(condition.get("csup_id"))) {
			sql+=" and csup_id = '"+condition.get("csup_id")+"'";
			sql2+=" and csup_id = '"+condition.get("csup_id")+"'";
		}
		if (condition.get("ccus_id")!=null&&!"".equals(condition.get("ccus_id"))) {
			sql+=" and cCus_id = '"+condition.get("ccus_id")+"'";
			sql2+=" and cCus_id = '"+condition.get("ccus_id")+"'";
		}
		if (condition.get("ccode")!=null&&!"".equals(condition.get("ccode"))) {
			sql+=" and GL_Accvouch.cCode = '"+condition.get("ccode")+"'";
			sql2+=" and GL_Accvouch.cCode = '"+condition.get("ccode")+"'";
		}

			if (StringUtils.isBlank(condition.get("csign"))) {
				sql+="";
				sql2+="";
			}else {
				sql+=" and csign = '"+condition.get("csign")+"'";
				sql2+=" and csign = '"+condition.get("csign")+"'";
			}
		
		if(condition.get("beginIno_id")!=null&&!"".equals(condition.get("beginIno_id"))){
			sql+=" and (ino_id >= '"+condition.get("beginIno_id")+"')";
			sql2+=" and (ino_id >= '"+condition.get("beginIno_id")+"')";
		}
		if(condition.get("endIno_id")!=null&&!"".equals(condition.get("endIno_id"))){
			sql+=" and (ino_id <= '"+condition.get("endIno_id")+"')";
			sql2+=" and (ino_id <= '"+condition.get("endIno_id")+"')";
		}
		

			if (StringUtils.isBlank(condition.get("ccheck"))) {
				sql+="";
				sql2+="";
			}else if (condition.get("ccheck").equals("已审核凭证")) { 
				sql+="and isnull(ccheck,'') = ''";
				sql2+="and isnull(ccheck,'') = ''";
			}else if (condition.get("ccheck").equals("未审核凭证")) {
				sql+="and isnull(ccheck,'') <> ''";
				sql2+="and isnull(ccheck,'') <> ''";
			}else {
				sql+=" and ccheck = '"+condition.get("examine")+"'";
				sql2+=" and ccheck = '"+condition.get("examine")+"'";
			}
		

			if (StringUtils.isBlank(condition.get("ccashier"))) {
				sql+="";
				sql2+="";
			}else if (condition.get("ccashier").equals("已签字凭证")) { 
				sql+="and isnull(ccashier,'') = ''";
				sql2+="and isnull(ccashier,'') = ''";
			}else if (condition.get("ccashier").equals("未签字凭证")) {
				sql+="and isnull(ccashier,'') <> ''";
				sql2+="and isnull(ccashier,'') <> ''";
			}else {
				sql+=" and ccashier = '"+condition.get("ccashier")+"'";
				sql2+=" and ccashier = '"+condition.get("ccashier")+"'";
			}
		

			if (StringUtils.isBlank(condition.get("cbook"))) {
				sql+="";
				sql2+="";
			}else if (condition.get("cbook").equals("已签字凭证")) { 
				sql+="and isnull(cbook,'') = ''";
				sql2+="and isnull(cbook,'') = ''";
			}else if (condition.get("cbook").equals("未签字凭证")) {
				sql+="and isnull(cbook,'') <> ''";
				sql2+="and isnull(cbook,'') <> ''";
			}else {
				sql+=" and cbook = '"+condition.get("accounting")+"'";
				sql2+=" and cbook = '"+condition.get("accounting")+"'";
			}
		

			if (StringUtils.isBlank(condition.get("cbill"))) {
				sql+="";
				sql2+="";
			}else {
				sql+=" and cbill = '"+condition.get("cbill")+"'";
				sql2+=" and cbill = '"+condition.get("cbill")+"'";
			}
		
		if(condition.get("iflag")!=null&&!"".equals(condition.get("iflag"))){
			sql+=" and Isnull(GL_Accvouch.iflag,0) in ("+condition.get("iflag")+")";
			sql2+=" and Isnull(GL_Accvouch.iflag,0) in ("+condition.get("iflag")+")";
		}

		Integer page=Integer.valueOf(pageNumber);
		page=(page-1)*Integer.valueOf(pageSize);
		//sql+=" Group By iperiod,dbill_date,csign,ino_id,cbill,ccashier,ccheck,cbook,iflag ) as q where q.rn not in (select top "+page+" ROW_NUMBER() over (partition by isnull(1,1) order by dbill_date)as c from "+database1+" Where 0=0";
		//String sql3="select count(*) from ( select iperiod,convert(varchar(10),dbill_date,23) as singletime,Isnull(csign,'')as csign,ino_id as vouchernum ,IsNull(Min(REPLACE(STR(inid,4),'','0')+IsNull(cdigest,'')),'') as cdigest,Sum(md) as md,isnull(max(ctext1),'') as remark1,isnull(max(ctext2),'')as remark2,isnull(cbill,'') as cbill,isnull(ccashier,'')as ccashier,isnull(ccheck,'')as ccheck,isnull(cbook,'') as cbook,isnull(iflag,0)as iflag,isnull(max(coutsysname),'')as coutsysname "+sql+" Group By iperiod,dbill_date,csign,ino_id,cbill,ccashier,ccheck,cbook,iflag ) c ";
		//sql2+=")";
		//sql+=sql2;
		//sql+= "Order By iperiod,csign ";
		
		//caijy修改替换
		//sql = "select top "+pageSize+" ROW_NUMBER() over (partition by isnull(1,1) order by dbill_date ) rn,iperiod,convert(varchar(10),dbill_date,23) as singletime,Isnull(csign,'')as csign,ino_id as vouchernum ,IsNull(Min(REPLACE(STR(inid,4),'','0')+IsNull(cdigest,'')),'') as cdigest,Sum(md) as md,isnull(max(ctext1),'') as remark1,isnull(max(ctext2),'')as remark2,isnull(cbill,'') as cbill,isnull(ccashier,'')as ccashier,isnull(ccheck,'')as ccheck,isnull(cbook,'') as cbook,isnull(iflag,0)as iflag,isnull(max(coutsysname),'')as coutsysname "+sql;
		sql = "select iperiod,convert(varchar(10),dbill_date,23) as singletime,Isnull(csign,'')as csign,ino_id as vouchernum ,IsNull(Min(REPLACE(STR(inid,4),'','0')+IsNull(cdigest,'')),'') as cdigest,Sum("+JorD+") as md,isnull(max(ctext1),'') as remark1,isnull(max(ctext2),'')as remark2,isnull(cbill,'') as cbill,isnull(ccashier,'')as ccashier,isnull(ccheck,'')as ccheck,isnull(cbook,'') as cbook,isnull(iflag,0)as iflag,isnull(max(coutsysname),'')as coutsysname "+sql;
		
		sql+=" Group By iperiod,dbill_date,csign,ino_id,cbill,ccashier,ccheck,cbook,iflag ";
		sql+= "Order By singletime,vouchernum ";
		List<Map<Object, Object>> listmap=glAccvouchService.getJournal(sql);
		DecimalFormat df_number = new DecimalFormat("#.00");
		for (Map<Object, Object> map : listmap) {
			String vouchernum = map.get("vouchernum").toString();
			if(vouchernum.length()==1){
				vouchernum="000"+vouchernum;
			}else if(vouchernum.length()==2){
				vouchernum="00"+vouchernum;
			}else if(vouchernum.length()==3){
				vouchernum="0"+vouchernum;
			}
			//caijy 添加及注释 以下4行代码
			map.put("ino_id", vouchernum);
			map.put("dbill_date", map.get("singletime"));
			map.put("i_id", map.get("csign").toString()+"-"+vouchernum);
			//map.put("csign", map.get("csign").toString()+"-"+vouchernum);
			
			map.put("cdigest", map.get("cdigest").toString().substring(4));
			map.put("month",map.get("singletime").toString().substring(5,7));
			map.put("day",map.get("singletime").toString().substring(8));
			String coutsysname = map.get("coutsysname").toString();
			//(IA =  存货成本；AP= 应付管理；FA = 固定资产
			if(coutsysname.equals("IA")){
				map.put("coutsysname","存货成本");
			}
			if(coutsysname.equals("FA")){
				map.put("coutsysname","固定资产");		
			}
			if(coutsysname.equals("AP")){
				map.put("coutsysname","应付管理");
			}
			//iflag(NULL,0正常,1作废,2错误)
			String iflag = map.get("iflag").toString();
			if(iflag.equals("1")){
				map.put("coutsysname","作废");
			}else if(iflag.equals("2")){
				map.put("coutsysname","错误");
			}
			if(new BigDecimal(map.get("md").toString()).compareTo(new BigDecimal(0))==0){
				map.put("md","");
			}else{
				map.put("md", df_number.format(new BigDecimal(map.get("md").toString())));
			}
		}
		
		//caijy修改替换
		Map<Object, Object> map = new HashMap<Object, Object>();
		Integer total=glAccvouchService.Count(sql3);//总行数
		map.put("total", total);
		if ((total/Integer.valueOf(pageSize))==0) {
			total=(total/Integer.valueOf(pageSize));
		}else {
			total=(total/Integer.valueOf(pageSize))+1;
		}
		map.put("pages", total);
		map.put("rows", listmap);
		Map<Object, Object> map = Paging.pagIng(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), listmap);
		return map;
	}

	@RequestMapping(params = "cancetally")
	@ResponseBody
	public Map<Object, Object> cancetally(HttpServletRequest request){
		Map<Object, Object> resultmap=new HashMap<>();
		resultmap.put("type",'0');//默认失败
		String database = request.getSession().getAttribute("database").toString();
		String iperiod = request.getSession().getAttribute("SmNoAccount").toString();
		GLmend gLmend=GLmendservice.findByIperiod(database+".dbo.gl_mend",Integer.parseInt(iperiod));//获取该月份是否月结
		if(gLmend.getBflag()){
			resultmap.put("msg","本月总账系统已经结账");
			return resultmap;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			resultmap.put("msg","有互斥功能正在使用中");  
			return resultmap;
		}
		resultmap.put("type",'1');
		List<Map<Object, Object>> rowMaps=(List<Map<Object, Object>>) JSON.parse(request.getParameter("selectrow"));
		List<Map<Object, Object>> resultArrMap=new ArrayList<>();
		for (Map<Object, Object> map : rowMaps) {
			String ino_id = map.get("ino_id").toString();
			String csign = map.get("csign").toString();
			List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(iperiod),csign,Short.parseShort(ino_id));
			if(GlAccvouchs==null || GlAccvouchs.size()==0){
				map.put("operationEnd", "没有找到实际凭证");
				resultArrMap.add(map);
				continue;
			}
			GlAccvouch glAccvouch = GlAccvouchs.get(0);
			if(glAccvouch.getCbook()==null || glAccvouch.getCbook().length()==0){
				map.put("operationEnd", "凭证并未记账");
				resultArrMap.add(map);
				continue;
			}
			if(glAccvouch.getIflag()!=null && glAccvouch.getIflag()==1){
				map.put("operationEnd", "作废");
				resultArrMap.add(map);
				continue;
			}
			if(glAccvouch.getIflag()!=null && glAccvouch.getIflag()==2){
				map.put("operationEnd", "错误");
				resultArrMap.add(map);
				continue;
			}
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",Byte.parseByte(iperiod),csign,Short.parseShort(ino_id));
			if(zZ_Lock!=null){
				map.put("msg","当前凭证已被锁定，不能修改!");  
				resultArrMap.add(map);
				continue;
			}
			String cdept_id = map.get("cdept_id")==null?"":map.get("cdept_id").toString();//部门
			String cperson_id = map.get("cperson_id")==null?"":map.get("cperson_id").toString();//人员
			String ccus_id = map.get("ccus_id")==null?"":map.get("ccus_id").toString();//客户
			String csup_id = map.get("csup_id")==null?"":map.get("csup_id").toString();//供应商
			String citem_id = map.get("citem_id")==null?"":map.get("citem_id").toString();//项目
			
			GlAccvouch gl_accvouch=new GlAccvouch();
			gl_accvouch.setCdept_id(cdept_id);
			gl_accvouch.setCperson_id(cperson_id);
			gl_accvouch.setCcus_id(ccus_id);
			gl_accvouch.setCsup_id(csup_id);
			gl_accvouch.setCitem_id(citem_id);
			gl_accvouch.setIperiod(Byte.parseByte(iperiod));
			gl_accvouch.setCsign(csign);
			gl_accvouch.setIno_id(Short.parseShort(ino_id));
			try{
				glAccvouchService.canceTally(request,gl_accvouch);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("operationEnd","当前凭证取消记账失败-数据库操作错误");  
				resultArrMap.add(map);
			}
		}
		if(resultArrMap.size()>0){
			resultmap.put("msg", "有部份凭证取消记账失败");
		}else{
			resultmap.put("msg", "取消记账成功");
		}
		resultmap.put("resultArrMap", resultArrMap);
		return resultmap;
	}
	
	//查询起始日期
	@RequestMapping(params = "finddatabycName")
	@ResponseBody
	public Map<Object, Object> finddatabycName(HttpServletRequest request){
		Map<Object, Object> map=new HashMap<Object, Object>();
		String database=request.getSession().getAttribute("database").toString();
		String startTime=request.getSession().getAttribute("startTime").toString();
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		int month = 0;//当前会计期间
		int year=Integer.valueOf(startTime.substring(0,4));
		try {
			month = df.parse(startTime).getMonth()+1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		map.put("monthend", year+"."+month);
		//查询起始日期
		String accouncover = accountService.findbycName(database+".dbo.accinformation","dGLStartDate");
		String startperiod="";
		if (year!=Integer.valueOf(accouncover.substring(0,4))) {
			startperiod=1+"";//起始期间
		}else {
			startperiod=accouncover.substring(5,7);//起始期间
		}
		Integer flag1=Integer.valueOf(startTime.substring(0,4));//循环时候的年起始值
		if (Integer.valueOf(accouncover.substring(0,4))>flag1) {
			flag1=Integer.valueOf(accouncover.substring(0,4));
		}
		map.put("monthbegin", flag1+"."+startperiod);
		return map;
		
	}
	
	
	//部门三栏总账
	@RequestMapping(params = "getdeptthreeacc")
	@ResponseBody
	public Map<Object, Object> getdeptthreeacc(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String startTime=request.getSession().getAttribute("startTime").toString();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int month = 0;//当前会计期间
		int year=Integer.valueOf(startTime.substring(0,4));
		try {
			month = df.parse(startTime).getMonth()+1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//查询起始日期
		String accouncover = accountService.findbycName(database+".dbo.accinformation","dGLStartDate");
		
		String sql = "select max(iperiod) iperiod from "+database+".dbo.GL_Mend where bflag = 1 ";
		List<Map<Object, Object>> maxiperiods = gL_accassService.findBySql(sql);
		Integer iperiod = Integer.valueOf(maxiperiods.get(0).get("iperiod").toString());
		String startperiod="";
		if (year!=Integer.valueOf(accouncover.substring(0,4))) {
			startperiod=1+"";//起始期间
		}else {
			startperiod=accouncover.substring(5,7);//起始期间
		}
		
		String startaccount=database.substring(0,database.length()-4)+accouncover.substring(0,4);
		Integer flag1=Integer.valueOf(startTime.substring(0,4));//循环时候的年起始值
		//期初sql
		StringBuffer beginperiodsql = new StringBuffer("");
		if (Integer.valueOf(accouncover.substring(0,4))>flag1) {
			flag1=Integer.valueOf(accouncover.substring(0,4));
			beginperiodsql.append("select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb from " + startaccount + ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subject") + "%' and cdept_id like '" + jsonmap.get("departmentbegin") + "%'");
		}else {
			beginperiodsql.append("select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb from " + database + ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subject") + "%' and cdept_id like '" + jsonmap.get("departmentbegin") + "%'");
		}
		List<Map<Object, Object>> beginperiods = gL_accassService.findBySql(beginperiodsql.toString());
		List<Map<Object, Object>> resultList=new ArrayList<Map<Object,Object>>();
		BigDecimal me = new BigDecimal("0");
				if (beginperiods!=null&&beginperiods.size()>0) {
					Map<Object, Object> map = beginperiods.get(0);
					if (map!=null) {
						if (Integer.valueOf(startperiod)>1) {
							map.put("cdigest", "期初余额");
						}else {
							map.put("cdigest", "上年结转");
						}
						if (map.get("mb")!=null) {
							int a = new BigDecimal(map.get("mb").toString()).compareTo(new BigDecimal("0"));
							if (a==1) {
								map.put("me_direction", "借");
							}else if (a==-1) {
								map.put("me_direction", "贷");
							}else if (a==0) {
								map.put("me_direction", "平");
							}
						}
						map.put("me", Math.abs(new BigDecimal(map.get("mb").toString()).doubleValue()));
						beginperiods=new ArrayList<Map<Object,Object>>();
						resultList.add(map);
						me=new BigDecimal(map.get("mb").toString());//期末余额=期初余额
					}else {
						map = new HashMap<Object, Object>();
						map.put("cdigest", "上年结转");
						map.put("me_direction", "平");
						resultList.add(map);
					}
				}else {
					Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("cdigest", "上年结转");
					map.put("me_direction", "平");
					resultList.add(map);
				}
				BigDecimal debitdebtabout = new BigDecimal("0");//借方累计
				BigDecimal creditdebtabout = new BigDecimal("0");//贷方累计
				Integer flag2=13;//yue
				Double med=0.00;
				for (int j = flag1; j <= Integer.valueOf(startTime.substring(0,4)); j++) {
					String currentdatabase=database.substring(0,database.length()-4)+j;//当前账套
					if (flag1==year) {
						flag2=month;
					}
					for (int k = 1; k <= flag2;k++) {
						AccInformation accInformation = accInformationService.findBycname(database+".dbo.AccInformation", "HTM"+k);
						String isMonthly="";
						if (accInformation!=null) {
							if ("1".equals(accInformation.getcValue())) {
								isMonthly="已月结";
							}
						}
							StringBuffer happed=new StringBuffer("");
							if ("true".equals(String.valueOf(jsonmap.get("isbilling")))) {
								happed.append("Select IsNull(Sum(md),0) as md, IsNull(Sum(mc),0) as mc From " + currentdatabase + ".dbo.GL_accvouch GL_accvouch Where IsNull(iflag,0)=0 "
								+ "And iperiod=" + k + " And ccode Like '" + jsonmap.get("subject") + "%' and cdept_id like '" + jsonmap.get("departmentbegin") + "%'");
							}else {
								happed.append("Select md, mc From " + currentdatabase + ".dbo.GL_accass GL_accass Where iperiod=" + k + " And ccode Like '" + jsonmap.get("subject") + "%' and cdept_id like '" + jsonmap.get("departmentbegin") + "%'");
							}
							List<Map<Object, Object>> happenList=glAccvouchService.getdeptdetail(happed.toString());//执行sql语句的方法
							if (happenList!=null&&happenList.size()>0) {
								Map<Object, Object> map2 = happenList.get(0);
								if (map2!=null) {
									Double mdd=Double.valueOf(map2.get("md")+"");
									Double mcd=Double.valueOf(map2.get("mc")+"");
									if ((map2.get("md")!=null&&mdd!=0.00)||(map2.get("mc")!=null&&mcd!=0.00)) {
										if ("已月结".equals(isMonthly)) {
											map2.put("cdigest", "本月合计");
										}else {
											map2.put("cdigest", "当前合计");
										}
										debitdebtabout=debitdebtabout.add(new BigDecimal(map2.get("md")+""));
										map2.put("md", new BigDecimal(map2.get("md")+"").setScale(2).toString());
										creditdebtabout=creditdebtabout.add(new BigDecimal(map2.get("mc")+""));
										map2.put("mc", new BigDecimal(map2.get("mc")+"").setScale(2).toString());
										me=me.add(debitdebtabout).subtract(creditdebtabout);
										int compareTo = me.compareTo(new BigDecimal("0"));
										if (compareTo==1) {
											map2.put("me_direction", "借");
										}else if (compareTo==-1) {
											map2.put("me_direction", "贷");
											map2.put("me", me.add(new BigDecimal("0.00")).setScale(2).toString());
										}else if (compareTo==0) {
											map2.put("me_direction", "平");
										}
										map2.put("me", med+mdd-mcd);
										map2.put("month", k);
										resultList.add(map2);
										map2=new HashMap<Object, Object>();
										if (k==iperiod) {
											map2.put("cdigest", "本年累计");
										}else if (k<iperiod) {
											map2.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
										}else {
											map2.put("cdigest", "当前累计");
										}
										map2.put("md", debitdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
										map2.put("mc", creditdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
										map2.put("month", k);
										resultList.add(map2);
									}
								}
							}
					}
				}
			Map<Object, Object> mapreturn=new HashMap<Object, Object>();
			mapreturn.put("total", resultList.size());
			String pageNumber=request.getParameter("page");
			
			if (pageNumber==null||pageNumber.equals("")) {
				pageNumber="1";
			}
			String pageSize=request.getParameter("rows");
			if (pageSize==null||pageSize.equals("")) {
				pageSize="500";
			}
			Integer toindex=null;
			Integer fromindex=null;
			if(pageNumber.equals("1")&&pageSize.equals("500")){
				if (Integer.valueOf("500")<=resultList.size()) {
					toindex=500;
				}else {
					toindex=resultList.size();
				}
				resultList=resultList.subList(Integer.valueOf(pageNumber), toindex);
			}else {
				if (Integer.valueOf(pageNumber)-Integer.valueOf(pageSize)*Integer.valueOf(pageSize)<=resultList.size()) {
					fromindex=Integer.valueOf(pageNumber)-Integer.valueOf(pageSize)*Integer.valueOf(pageSize);
				}else {
					fromindex=resultList.size();
				}
				if (Integer.valueOf(pageSize)<=resultList.size()) {
					toindex=Integer.valueOf(pageSize);
				}else {
					toindex=resultList.size();
				}
				resultList=resultList.subList(fromindex, toindex);
			}
			
			if (resultList!=null&&resultList.size()>0) {
				mapreturn.put("rows", resultList);
			}else {
				mapreturn.put("rows", "");
			}
			return mapreturn;
		}
	
	
	//部门科目余额表
	@RequestMapping(params = "getdeptsubjectamout")
	@ResponseBody
	public Map<Object, Object> getdeptsubjectamout(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String startaccount=database.substring(0,database.length()-4)+jsonmap.get("monthbegin").toString().substring(0,4);
		String isbilling="";//是否记账条件
		if (String.valueOf(jsonmap.get("isbilling")).equals("false")) {
			isbilling=" and (iperiod = 0 or ibook = 1) ";
		}
		//科目范围条件：
		String subjectrange="";
		if (String.valueOf(jsonmap.get("subjectbegin")).equals("")
				&&String.valueOf(jsonmap.get("subjectend")).equals("")) {
			subjectrange=" (isnull(bend,0)=1 And isnull(bdept,0)=1) ";
		}else if (!String.valueOf(jsonmap.get("subjectbegin")).equals("")
				&&String.valueOf(jsonmap.get("subjectend")).equals("")) {
			subjectrange=" ((Code.cCode Like '" + jsonmap.get("subjectbegin")+ "%' Or Code.cCode>='" + jsonmap.get("subjectbegin")+ "') And isnull(bend,0)=1 And isnull(bdept,0)=1)";
		}else if (String.valueOf(jsonmap.get("subjectbegin")).equals("")
				&&!String.valueOf(jsonmap.get("subjectend")).equals("")) {
			subjectrange=" ((Code.cCode Like '" + jsonmap.get("subjectend") + "%' Or Code.cCode<='" + jsonmap.get("subjectend")+ "') And isnull(bend,0)=1 And isnull(bdept,0)=1) ";
		}else if (!String.valueOf(jsonmap.get("subjectbegin")).equals("")
				&&!String.valueOf(jsonmap.get("subjectend")).equals("")) {
			subjectrange=" (((Code.cCode>='" + jsonmap.get("subjectbegin") + "' And Code.cCode<='" + jsonmap.get("subjectend") + "') Or Code.cCode Like '" + jsonmap.get("subjectbegin") + "%' Or Code.cCode Like '" + jsonmap.get("subjectend") + "%') And isnull(bend,0)=1 And isnull(bdept,0)=1) ";
		}
		if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("cbox")){
			subjectrange="(Code.cCode Like '"+jsonmap.get("subjectbegin")+"%' And isnull(bend,0)=1 And isnull(bdept,0)=1) ";
		}
		//期初sql
		StringBuffer beginperiodsql=new StringBuffer(" select ccode, cdept_id, (case when sum(md-mc)>0 then '借' when sum(md-mc)<0 then '贷' else '平' end) cbegind_c, sum(md_f - mc_f) as mb_f, sum(nd_s - nc_s) as nb_s, sum(md - mc) as mb, 0 mb_f2, 0 nb_s2, 0 mb2 from " + startaccount + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 and iperiod < " + jsonmap.get("monthbegin").toString().substring(5) + " and cdept_id <> ''group by ccode, cdept_id");
		//发生sql
		StringBuffer happensql=new StringBuffer("");
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			String loopdatabase=database.substring(0, database.length()-4)+i;
			happensql.append("select ccode,cdept_id, md_f, nd_s, md, mc_f, nc_s, mc From " + loopdatabase + " .dbo.GL_accvouch Where IsNull(iflag,0)<>1 " + isbilling + " and cdept_id <> '' ");
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				happensql.append(" and iperiod>=" + jsonmap.get("monthbegin").toString().substring(5));
			}else {
				happensql.append(" and iperiod>=1");
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append(" And iperiod<=" + jsonmap.get("monthend").toString().substring(5));
			}else {
				happensql.append(" And iperiod<= 12 ");
			}
			if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append(" union all ");
			}
		}
		StringBuffer happensqlup=new StringBuffer("select ccode, cdept_id, Sum(md_f) As md_f,Sum(nd_s) As nd_s,Sum(md) As md,Sum(mc_f) As mc_f,Sum(nc_s) As nc_s,Sum(mc) As mc from (" + happensql+ ") ssb Group By ccode,cdept_id");
		String sql="with q as ( select ROW_NUMBER() over (partition by isnull(1,1) Order By Code.ccode,Department.cDepCode ) rn ,Code.ccode,Code.ccode_name,IsNull(Department.cDepCode,'') as cDepCode,IsNull(Department.cDepName,'') as cDepName,IsNull(A.cbegind_c,'平') as cbegind_c,IsNull(A.mb_f,0) as mb_f,"
				+ "IsNull(A.nb_s,0) as nb_s,IsNull(A.mb,0) as mb,IsNull(A.mb_f2,0) as mb_f2,IsNull(A.nb_s2,0) as nb_s2,IsNull(A.mb2,0) as mb2,IsNull(B.md_f,0) as md_f,IsNull(B.nd_s,0) as nd_s,IsNull(B.md,0) as md,"
				+ "IsNull(B.mc_f,0) as mc_f,IsNull(B.nc_s,0) as nc_s,IsNull(B.mc,0) as mc From  (" + beginperiodsql + ") As A Full Join (" + happensqlup + ") As B On "
						+ "A.cCode=B.cCode And A.cdept_id=B.cdept_id Left Join "+database+".dbo.Code On IsNull(A.ccode,B.cCode)=Code.cCode Left Join "+database+".dbo.Department On "
						+ "IsNull(A.cdept_id,B.cdept_id)=Department.cDepCode Where (IsNull(A.mb_f,0)<>0 Or IsNull(A.nb_s,0)<>0 Or IsNull(A.mb,0)<>0 Or "
						+ "IsNull(B.md_f,0)<>0 Or IsNull(B.nd_s,0)<>0 Or IsNull(B.md,0)<>0 Or IsNull(B.mc_f,0)<>0 Or IsNull(B.nc_s,0)<>0 Or "
						+ "IsNull(B.mc,0)<>0)  And (" + subjectrange + ")) "
								+ "select top "+pageSize+" * from  q where q.rn not in (select top "+(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize)+" ROW_NUMBER() over (partition by isnull(1,1) Order By q.ccode,q.cDepCode )as rn from q ) Order By q.ccode,q.cDepCode";
		String sql2="with q as ( select ROW_NUMBER() over (partition by isnull(1,1) Order By Code.ccode,Department.cDepCode ) rn ,Code.ccode,Code.ccode_name,IsNull(Department.cDepCode,'') as cDepCode,IsNull(Department.cDepName,'') as cDepName,IsNull(A.cbegind_c,'平') as cbegind_c,IsNull(A.mb_f,0) as mb_f,"
				+ "IsNull(A.nb_s,0) as nb_s,IsNull(A.mb,0) as mb,IsNull(A.mb_f2,0) as mb_f2,IsNull(A.nb_s2,0) as nb_s2,IsNull(A.mb2,0) as mb2,IsNull(B.md_f,0) as md_f,IsNull(B.nd_s,0) as nd_s,IsNull(B.md,0) as md,"
				+ "IsNull(B.mc_f,0) as mc_f,IsNull(B.nc_s,0) as nc_s,IsNull(B.mc,0) as mc From  (" + beginperiodsql + ") As A Full Join (" + happensqlup + ") As B On "
						+ "A.cCode=B.cCode And A.cdept_id=B.cdept_id Left Join "+database+".dbo.Code On IsNull(A.ccode,B.cCode)=Code.cCode Left Join "+database+".dbo.Department On "
						+ "IsNull(A.cdept_id,B.cdept_id)=Department.cDepCode Where (IsNull(A.mb_f,0)<>0 Or IsNull(A.nb_s,0)<>0 Or IsNull(A.mb,0)<>0 Or "
						+ "IsNull(B.md_f,0)<>0 Or IsNull(B.nd_s,0)<>0 Or IsNull(B.md,0)<>0 Or IsNull(B.mc_f,0)<>0 Or IsNull(B.nc_s,0)<>0 Or "
						+ "IsNull(B.mc,0)<>0)  And (" + subjectrange + ")) select rn from q";
		List<Map<Object, Object>> deptsubjectamouts=glAccvouchService.getDeptsubjectamout(sql);
		List<Map<Object, Object>> deptsubjectamout = glAccvouchService.getDeptsubjectamout(sql2);
		//期初的
		BigDecimal data5=new BigDecimal("0");//外币
		BigDecimal data6=new BigDecimal("0");//数量
		BigDecimal data7=new BigDecimal("0");//期初本币
		BigDecimal data8=new BigDecimal("0");//期初本币借方
		BigDecimal data9=new BigDecimal("0");//期初本币贷方
		//本期的
		BigDecimal data10=new BigDecimal("0");//借方外币
		BigDecimal data11=new BigDecimal("0");//数量
		BigDecimal data12=new BigDecimal("0");//本币
		BigDecimal data13=new BigDecimal("0");//贷方外币
		BigDecimal data14=new BigDecimal("0");//数量
		BigDecimal data15=new BigDecimal("0");//本币
		//期末的
		BigDecimal data17=new BigDecimal("0");
		BigDecimal data18=new BigDecimal("0");
		BigDecimal data19=new BigDecimal("0");
		BigDecimal data20=new BigDecimal("0");
		BigDecimal data21=new BigDecimal("0");
		for (int i = 0; i < deptsubjectamouts.size(); i++) {
			Map<Object, Object> map = deptsubjectamouts.get(i);
			if (String.valueOf(map.get("cbegind_c")).equals("贷")) {
				map.put("data5", Takeback(new BigDecimal(map.get("mb_f")+"")).add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data6", Takeback(new BigDecimal(map.get("nb_s")+"")).add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data7", Takeback(new BigDecimal(map.get("mb")+"")).add(new BigDecimal("0.00")).setScale(2).toString());
				if (Double.valueOf(map.get("data5")+"")==0.00) {
					map.put("date5", "");
				}if (Double.valueOf(map.get("data6")+"")==0.00) {
					map.put("data6", "");
				}if (Double.valueOf(map.get("data7")+"")==0.00) {
					map.put("data7", "");
				}
			}
			if (String.valueOf(map.get("cbegind_c")).equals("借")||String.valueOf(map.get("cbegind_c")).equals("平")) {
				map.put("data8", new BigDecimal(map.get("mb")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data9", "");
				if (Double.valueOf(map.get("data8")+"")==0.00) {
					map.put("data8", "");
				}
			}else {
				map.put("data8", "");
				map.put("data9", new BigDecimal("-1").multiply(new BigDecimal(map.get("mb").toString())).setScale(2).toString());
				if (Double.valueOf(map.get("data9")+"")==0.00) {
					map.put("data9", "");
				}
			}
			//--5
//			map.put("data10", new BigDecimal(map.get("md_f")+"").add(new BigDecimal("0.00")).setScale(2).toString());
//			map.put("data11", new BigDecimal(map.get("nd_s")+"").add(new BigDecimal("0.00")).setScale(2).toString());
//			map.put("data12", new BigDecimal(map.get("md")+"").add(new BigDecimal("0.00")).setScale(2).toString());
//			map.put("data13", new BigDecimal(map.get("mc_f")+"").add(new BigDecimal("0.00")).setScale(2).toString());
//			map.put("data14", new BigDecimal(map.get("nc_s")+"").add(new BigDecimal("0.00")).setScale(2).toString());
//			map.put("data15", new BigDecimal(map.get("mc")+"").add(new BigDecimal("0.00")).setScale(2).toString());
			
			map.put("data10", map.get("md_f"));
			map.put("data11", map.get("nd_s"));
			map.put("data12", map.get("md"));
			map.put("data13", map.get("mc_f"));
			map.put("data14", map.get("nc_s"));
			map.put("data15", map.get("mc"));
			
			
			if (Double.valueOf(map.get("data10")+"")==0.00) {
				map.put("data10", "");
			}if (Double.valueOf(map.get("data11")+"")==0.00) {
				map.put("data11", "");
			}if (Double.valueOf(map.get("data12")+"")==0.00) {
				map.put("data12", "");
			}if (Double.valueOf(map.get("data13")+"")==0.00) {
				map.put("data13", "");
			}if (Double.valueOf(map.get("data14")+"")==0.00) {
				map.put("data14", "");
			}if (Double.valueOf(map.get("data15")+"")==0.00) {
				map.put("data15", "");
			}
			//——6
			//期末外币
			BigDecimal QMF = new BigDecimal(map.get("mb_f")+"").add(new BigDecimal(map.get("mb2")+"")).subtract(new BigDecimal(map.get("mc_f")+""));
			//期末数量
			BigDecimal QMN = new BigDecimal(map.get("nb_s")+"").add(new BigDecimal(map.get("md_f")+"")).subtract(new BigDecimal(map.get("nc_s")+""));
			//期末外币
			BigDecimal QMM = new BigDecimal(map.get("mb")+"").add(new BigDecimal(map.get("md")+"")).subtract(new BigDecimal(map.get("mc")+"")); 
			//——7.
			int compareTo = QMM.compareTo(new BigDecimal("0"));
			if (compareTo==1) {
				map.put("data16", "借");
				map.put("data17", QMF.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data18", QMN.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data19", QMM.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data20", QMM.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data21", "");
				if (Double.valueOf(map.get("data17")+"")==0.00) {
					map.put("data17", "");
				}if (Double.valueOf(map.get("data18")+"")==0.00) {
					map.put("data18", "");
				}if (Double.valueOf(map.get("data19")+"")==0.00) {
					map.put("data19", "");
				}if (Double.valueOf(map.get("data20")+"")==0.00) {
					map.put("data20", "");
				}
			}else if (compareTo==-1) {
				map.put("data16", "贷");
				map.put("data17", QMF.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data18", QMN.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data19", QMM.add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data20", "");
				map.put("data21", QMM.add(new BigDecimal("0.00")).setScale(2).toString());
				if (Double.valueOf(map.get("data17")+"")==0.00) {
					map.put("data17", "");
				}if (Double.valueOf(map.get("data18")+"")==0.00) {
					map.put("data18", "");
				}if (Double.valueOf(map.get("data19")+"")==0.00) {
					map.put("data19", "");
				}if (Double.valueOf(map.get("data21")+"")==0.00) {
					map.put("data21", "");
				}
			}else {
				map.put("data16", "平");
				map.put("data17", new BigDecimal("-1").multiply(QMF).add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data18", new BigDecimal("-1").multiply(QMN).add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data19", new BigDecimal("-1").multiply(QMM).add(new BigDecimal("0.00")).setScale(2).toString());
				map.put("data20", "");
				map.put("data21", new BigDecimal("-1").multiply(QMM).add(new BigDecimal("0.00")).setScale(2).toString());
				if (Double.valueOf(map.get("data17")+"")==0.00) {
					map.put("data17", "");
				}if (Double.valueOf(map.get("data18")+"")==0.00) {
					map.put("data18", "");
				}if (Double.valueOf(map.get("data19")+"")==0.00) {
					map.put("data19", "");
				}if (Double.valueOf(map.get("data21")+"")==0.00) {
					map.put("data21", "");
				}
			}
			//期初
			data5=data5.add(new BigDecimal(map.get("mb_f")+""));
			data6=data6.add(new BigDecimal(map.get("nb_s")+""));
			data7=data7.add(new BigDecimal(map.get("mb")+""));
			int compareTo2 = new BigDecimal(map.get("mb")+"").compareTo(new BigDecimal("0"));
			if (compareTo2==1) {
				data8=data8.add(new BigDecimal(map.get("mb")+""));
			}
			if (compareTo2==-1) {
				Double qmf=Math.abs(new BigDecimal(map.get("mb")+"").doubleValue());
				data9=data9.add(new BigDecimal(qmf));
			}
			//本期
			data10=data10.add(new BigDecimal(map.get("md_f")+""));
			data11=data11.add(new BigDecimal(map.get("nd_s")+""));
			data12=data12.add(new BigDecimal(map.get("md")+""));
			data13=data13.add(new BigDecimal(map.get("mc_f")+""));
			data14=data14.add(new BigDecimal(map.get("nc_s")+""));
			data15=data15.add(new BigDecimal(map.get("mc")+""));
			//期末
			data17=data17.add(QMF.setScale(2));
			data18=data18.add(QMN.setScale(2));
			data19=data19.add(QMM.setScale(2));
			
			if (!"".equals(map.get("data20")+"")) {
				data20=data20.add(new BigDecimal(map.get("data20")+""));
			}
			if (!"".equals(map.get("data21")+"")) {
				data21=data21.add(new BigDecimal(map.get("data21")+""));
			}
		}
		
		Map<Object, Object> map=new HashMap<Object, Object>();
		if (deptsubjectamouts!=null&&deptsubjectamouts.size()>0) {
			map.put("ccode", "合计");
			map.put("data5", data5.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			if (Double.valueOf(map.get("data5")+"")==0.00) {
				map.put("data5", "");
			}
			map.put("data6", data6.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			if (Double.valueOf(map.get("data6")+"")==0.00) {
				map.put("data6", "");
			}
			map.put("data7", data7.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			if (Double.valueOf(map.get("data7")+"")==0.00) {
				map.put("data7", "");
			}
			map.put("data8", data8.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			if (Double.valueOf(map.get("data8")+"")==0.00) {
				map.put("data8", "");
			}
			System.out.println(data9.setScale(2,BigDecimal.ROUND_HALF_UP));
			map.put("data9", data9.setScale(2,BigDecimal.ROUND_HALF_UP).add(new BigDecimal("0.00")).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
			if (Double.valueOf(map.get("data9")+"")==0.00) {
				map.put("data9", "");
			}
			map.put("data10", data10.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			if (Double.valueOf(map.get("data10")+"")==0.00) {
				map.put("data10", "");
			}
			map.put("data11", data11.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			if (Double.valueOf(map.get("data11")+"")==0.00) {
				map.put("data11", "");
			}
//			map.put("data12", data12.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data12", data12);
			if (Double.valueOf(map.get("data12")+"")==0.00) {
				map.put("data12", "");
			}
//			map.put("data13", data13.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data13", data13);
			if (Double.valueOf(map.get("data13")+"")==0.00) {
				map.put("data13", "");
			}
//			map.put("data14", data14.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data14", data14);
			if (Double.valueOf(map.get("data14")+"")==0.00) {
				map.put("data14", "");
			}
//			map.put("data15", data15.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data15", data15);
			if (Double.valueOf(map.get("data15")+"")==0.00) {
				map.put("data15", "");
			}
//			map.put("data17", data17.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());			
			map.put("data17", data17);
			if (Double.valueOf(map.get("data17")+"")==0.00) {
				map.put("data17", "");
			}
//			map.put("data18", data18.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data18", data18);
			if (Double.valueOf(map.get("data18")+"")==0.00) {
				map.put("data18", "");
			}
//			map.put("data19", data19.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data19", data19);
			if (Double.valueOf(map.get("data19")+"")==0.00) {
				map.put("data19", "");
			}
//			map.put("data20", data20.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data20", data20);
			if (Double.valueOf(map.get("data20")+"")==0.00) {
				map.put("data20", "");
			}
//			map.put("data21", data21.setScale(2).add(new BigDecimal("0.00")).setScale(2).toString());
			map.put("data21", data21);
			if (Double.valueOf(map.get("data21")+"")==0.00) {
				map.put("data21", "");
			}
			deptsubjectamouts.add(map);
		}
		map=new HashMap<Object, Object>();
		map.put("total", deptsubjectamout.size());
		map.put("rows", deptsubjectamouts);
		return map;
	}
	
	BigDecimal Takeback(BigDecimal a){//取反
		if (a.compareTo(new BigDecimal(0))==-1) {
			return a.abs();
		}else {
			return new BigDecimal("-1").multiply(a);
		}
	}
	
	//部门三栏明细账
	@RequestMapping(params = "deptthreedetailed")
	@ResponseBody
	public Map<Object, Object> deptthreedetailed(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		String pageNumber=request.getParameter("page");
		
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String startaccount=database.substring(0,database.length()-4)+jsonmap.get("monthbegin").toString().substring(0,4);
		String isbilling="";//是否记账条件
		if (String.valueOf(jsonmap.get("isbilling")).equals("false")) {
			isbilling=" and (iperiod = 0 or ibook = 1) ";
		}
		//期初sql
		StringBuffer Initialbalancesql=new StringBuffer("select '' as cdept_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, isnull(sum(md - mc),0) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + String.valueOf(jsonmap.get("monthbegin")).substring(0,4) + " as syear from " + startaccount + ".dbo.gl_accvouch gl_accvouch left join " + database.substring(0,database.length()-4)+String.valueOf(jsonmap.get("monthbegin")).substring(0,4) + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling + " and code.bdept = 1 and iperiod <  " + String.valueOf(jsonmap.get("monthbegin")).substring(5) + " and gl_accvouch.ccode like '" + jsonmap.get("subjectcode") + "%' and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%'");
		//发生sql
		StringBuffer happensql=new StringBuffer("");
		//累计发生查询SQL
		StringBuffer cumulativehappensql=new StringBuffer("");
		//本月查询SQL
		StringBuffer thismonth=new StringBuffer("");
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			String loopdatabase=database.substring(0,database.length()-4)+i;
			happensql.append("select gl_accvouch.cdept_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4)+right('0000'+cast(inid as varchar),4) as px, cperson_id, citem_id, csup_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook , " + i + " as syear from " + loopdatabase + ".dbo.gl_accvouch gl_accvouch left join " + loopdatabase + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling + " and code.bdept = 1 ");
			cumulativehappensql.append("select '' as cdept_id, '累    计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, isnull((select sum(md) from " + loopdatabase + ".dbo.gl_accvouch aa where ccode like '" + jsonmap.get("subjectcode") + "%' and cdept_id like '" + jsonmap.get("deptcode") + "%' and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0) as md, isnull((select sum(mc) from " + loopdatabase + ".dbo.gl_accvouch aa where ccode like '" + jsonmap.get("subjectcode")+ "%' and cdept_id like '" + jsonmap.get("deptcode") + "%' and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0) as mc, 0 as me, iperiod, '99999999' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + i + " as syear from " + loopdatabase+ ".dbo.gl_accvouch gl_accvouch left join " + loopdatabase + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling + " and code.bdept = 1 ");
			thismonth.append("select '' as cdept_id, '本月合计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, sum( md), sum(mc), 0 as me, iperiod, '99998888' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook , " + i + " as syear from " + loopdatabase + ".dbo.gl_accvouch gl_accvouch left join " + loopdatabase + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling + " and code.bdept = 1 ");
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				happensql.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + " ");
				cumulativehappensql.append(" and iperiod >=  " + jsonmap.get("monthbegin").toString().substring(5) + " ");
				thismonth.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + " ");
			}else {
				happensql.append(" and iperiod >= 1 ");
				cumulativehappensql.append(" and iperiod >= 1 ");
				thismonth.append(" and iperiod >= 1 ");
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append(" and iperiod <= " + jsonmap.get("monthend").toString().substring(5) + " ");
				cumulativehappensql.append(" and iperiod <=" + jsonmap.get("monthend").toString().substring(5) + " ");
				thismonth.append(" and iperiod <=" + jsonmap.get("monthend").toString().substring(5) + " ");
			}else {
				happensql.append(" and iperiod <= 12 ");
				cumulativehappensql.append(" and iperiod <= 12 ");
				thismonth.append(" and iperiod <= 12 ");
			}
			happensql.append("and gl_accvouch.ccode like '" + jsonmap.get("subjectcode")+ "%' and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode")+ "%'");
			cumulativehappensql.append(" and gl_accvouch.ccode like '" + jsonmap.get("subjectcode") + "%' and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%'  group by iperiod ");
			thismonth.append("and gl_accvouch.ccode like '" + jsonmap.get("subjectcode") + "%' and gl_accvouch.cdept_id like '" + jsonmap.get("deptcode") + "%' group by iperiod");
			if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				happensql.append(" union all ");
				cumulativehappensql.append(" union all ");
				thismonth.append(" union all ");
			}
		}
		//汇总sql
		String sqlstr="with q as (Select ROW_NUMBER() over (partition by isnull(1,1) order by syear, iperiod, px ) rn , aaa.cdept_id, '' as cdepname, cdigest, dbill_date, isnull(csign,'') as csign, ino_id, md, mc, me, iperiod, px, isnull(cperson_id,'') as cperson_id, "
				+ "isnull(citem_id, '') as citem_id, isnull(csup_id,'') as csup_id, isnull( ccus_id, '') as ccus_id, isnull( csettle, '') as csettle, isnull(cn_id, '') as cn_id, isnull( dt_date, '') as dt_date, "
				+ "isnull(cname, '') as cname, ibook, syear From ( "+ Initialbalancesql +" Union All "+ happensql +" Union All "+ thismonth +" Union All "+ cumulativehappensql + ") aaa) "
		+ "select top "+pageSize+"* from q where q.rn not in (select top "+(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize)+" ROW_NUMBER() over (partition by isnull(1,1) order by syear, iperiod, px ) rn from q) order by syear, iperiod, px";
		List<Map<Object, Object>> deptthreedetaileds = glAccvouchService.deptthreedetailed(sqlstr);
		String sqlstr2="with q as (Select ROW_NUMBER() over (partition by isnull(1,1) order by syear, iperiod, px ) rn , aaa.cdept_id, '' as cdepname, cdigest, dbill_date, isnull(csign,'') as csign, ino_id, md, mc, me, iperiod, px, isnull(cperson_id,'') as cperson_id, "
				+ "isnull(citem_id, '') as citem_id, isnull(csup_id,'') as csup_id, isnull( ccus_id, '') as ccus_id, isnull( csettle, '') as csettle, isnull(cn_id, '') as cn_id, isnull( dt_date, '') as dt_date, "
				+ "isnull(cname, '') as cname, ibook, syear From ( "+ Initialbalancesql +" Union All "+ happensql +" Union All "+ thismonth +" Union All "+ cumulativehappensql + ") aaa) select rn from q";
		List<Map<Object, Object>> deptthreedetailed = glAccvouchService.deptthreedetailed(sqlstr2);
		String starttime=request.getSession().getAttribute("startTime").toString();
		Integer month = Integer.valueOf(starttime.split("-")[1]);
		BigDecimal accumulation=new BigDecimal("0");//累加余额
		for (Map<Object, Object> map : deptthreedetaileds) {
			StringBuffer setasummary=new StringBuffer();//设置摘要
			if (map.get("cdigest").equals("期初余额")) {
				if (Integer.valueOf(jsonmap.get("monthbegin").toString().substring(5))==1) {
					map.put("cdigest", "上年结转");
				}else {
					map.put("cdigest", "期初余额");
					map.put("month","");
				}
			}else if (map.get("cdigest").equals("本月合计")) {
				if (Integer.valueOf(map.get("iperiod").toString())>=month) {
					map.put("cdigest", "当前合计");
				}else {
					map.put("cdigest", "本月合计");
				}
			}else if (map.get("cdigest").equals("累    计")) {
				if (!(Integer.valueOf(map.get("iperiod").toString())>=month)) {
					map.put("cdigest", "当前累计");
				}else {
					map.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
				}
			}else {setasummary.append(map.get("cdigest")+"_");
			if(jsonmap.get("abs_dept").toString().equals("true")){
				if (map.get("cdept_id")!=null&&!"".equals(map.get("cdept_id").toString())) {
					String deptname=departmentService.getDepName(database+".dbo.Department", map.get("cdept_id").toString());
					setasummary.append(deptname+"_");
				}
			}
			
			if(jsonmap.get("abs_person").toString().equals("true")){
				if (map.get("cperson_id")!=null&&!"".equals(map.get("cperson_id").toString())) {
					String person_name=personService.getPersonName(database+".dbo.person", map.get("cperson_id").toString());
					setasummary.append(person_name+"_");
				}
			}
			if(jsonmap.get("abs_project").toString().equals("true")){
				if (map.get("citem_id")!=null&&!"".equals(map.get("citem_id").toString())) {
					String citem_name=ht_GLItemService.getHt_itemName(database+".dbo.HT_GLItem", map.get("citem_id").toString());
					setasummary.append(citem_name+"_");
				}
			}
			if(jsonmap.get("abs_cus").toString().equals("true")){
				if (map.get("ccus_id")!=null&&!"".equals(map.get("ccus_id").toString())) {
					String ccus_name=customerService.getCustName(database+".dbo.customer", map.get("ccus_id").toString());
					setasummary.append(ccus_name+"_");
				}
			}
			if(jsonmap.get("abs_sup").toString().equals("true")){
				if (map.get("csup_id")!=null&&!"".equals(map.get("csup_id").toString())) {
					String csup_name=vendorService.getVendorName(database+".dbo.vendor", map.get("csup_id").toString());
					setasummary.append(csup_name+"_");
				}
			}
			if(jsonmap.get("abs_jsfs").toString().equals("true")){
				if (map.get("csettle")!=null&&!"".equals(map.get("csettle").toString())) {
					String csettle_name=settleStyleService.getcssname(database+".dbo.settleStyle",map.get("csettle").toString());
					setasummary.append(csettle_name+"_");
				}
			}
			if(jsonmap.get("abs_billno").toString().equals("true")){
				if (map.get("cn_id")!=null&&!(String.valueOf(map.get("cn_id"))).equals("")) {
					setasummary.append(map.get("cn_id")+"_");
				}
			}
			
			if(jsonmap.get("abs_date").toString().equals("true")){
				if (map.get("dt_date")!=null&&!(String.valueOf(map.get("dt_date"))).equals("")) {
					setasummary.append(map.get("dt_date")+"_");
				}
			}
			if(jsonmap.get("abs_clerk").toString().equals("true")){
				if (map.get("cname")!=null&&!(String.valueOf(map.get("cname"))).equals("")) {
					setasummary.append(map.get("cname")+"_");
				}
			}

			if (map.get("ibook").toString().equals("0")) {
				setasummary.insert(0, "*");
			}
			char c = setasummary.charAt(setasummary.length()-1);
			if (String.valueOf(c).equals("_")) {
				setasummary = setasummary.deleteCharAt(setasummary.length()-1);
			}
			map.put("cdigest", setasummary);}
			accumulation=accumulation.add(new BigDecimal(map.get("me").toString()));
			int a=accumulation.compareTo(new BigDecimal("0"));//累加余额比较0
			if (a==1) {
				map.put("me_direction", "借");
			}else if (a==0) {
				map.put("me_direction", "平");
			}else {
				map.put("me_direction", "贷");
			}
			map.put("me", accumulation.setScale(2).abs());
			if (new BigDecimal(map.get("me")+"").compareTo(new BigDecimal("0"))==0) {
				map.put("me", "");
			}else {
				map.put("me", accumulation.setScale(2).abs().toString());
			}
			if (new BigDecimal(map.get("md")+"").compareTo(new BigDecimal("0"))==0) {
				map.put("md", "");
			}else {
				map.put("md", new BigDecimal(map.get("md").toString()).setScale(2).toString());
			}
			if (new BigDecimal(map.get("mc")+"").compareTo(new BigDecimal("0"))==0) {
				map.put("mc", "");
			}else {
				map.put("mc", new BigDecimal(map.get("mc").toString()).setScale(2).toString());
			}
			if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
				map.put("year", String.valueOf(map.get("dbill_date")).substring(0,4));
				map.put("month", String.valueOf(map.get("dbill_date")).substring(5,7));
				map.put("day", String.valueOf(map.get("dbill_date")).substring(8,10));
			}
			if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
				String str=String.valueOf(map.get("csign"))+"-0000";
				String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
				map.put("ino_id2", ino_id);
			}
		}
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("total", deptthreedetailed.size());
		map.put("rows", deptthreedetaileds);
		return map;
	}
	
 	@RequestMapping(params = "findbycolumn")
 	@ResponseBody
 	public Object findbycolumn(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		Object attribute = request.getSession().getAttribute("MDcodes");
		return attribute;
 		
 	}
	//多栏账
	@SuppressWarnings("deprecation")
	@RequestMapping(params = "getmulticolumnaccount")
	@ResponseBody
	public Map<Object, Object> getmulticolumnaccount(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		List<Map<Object, Object>> resultmap=new ArrayList<Map<Object,Object>>();
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String isbilling="";//是否记账条件
		if (!(boolean) jsonmap.get("isbilling")) {
			isbilling=" And GL_accvouch.iBook=1 ";
		}
		String startTime=request.getSession().getAttribute("startTime").toString();
		List<Map<Object, Object>> MDcodes = new ArrayList<Map<Object,Object>>();//借方栏目
		List<Map<Object, Object>> MCcodes = new ArrayList<Map<Object,Object>>();//贷方栏目
		
		String iType = zz_DLZMService.getiTypeByccode(database+".dbo.ZZ_DLZM",jsonmap.get("subjectcode"));
		if (iType!=null&&!"".equals(iType)) {
			MDcodes=zz_DLZMService.getMDcodes(database,jsonmap.get("subjectcode"));//借方
			if (MDcodes==null||MDcodes.size()<1) {
				MDcodes=codeService.findcodeandname(database,jsonmap.get("subjectcode"));
			}
			MCcodes=zz_DLZMService.getMCcodes(database,jsonmap.get("subjectcode"));//贷方
			if (MCcodes==null||MCcodes.size()<1) {
				MCcodes=MDcodes;
			}
		}else {
			MDcodes=zz_DLZMService.getjuniorsubject(database,jsonmap.get("subjectcode"));
		}
		request.getSession().setAttribute("MDcodes", MDcodes);
		request.getSession().setAttribute("MCcodes", MCcodes);
		
		StringBuffer Initialbalancesql = new StringBuffer("Select IsNull(Sum(GL_accvouch.md),0) value0,IsNull(Sum(GL_accvouch.mc),0) value1 From "+database.substring(0,database.length()-4)+String.valueOf(jsonmap.get("monthbegin")).substring(0,4)+".dbo.GL_accvouch GL_accvouch"
+ " Where GL_accvouch.ccode Like '"+jsonmap.get("subjectcode")+"%' And GL_accvouch.iperiod< "+jsonmap.get("monthbegin").toString().substring(5)+" And IsNull(GL_accvouch.iflag,0)=0 "
		+ isbilling +" ");
		
		resultmap=glAccvouchService.getdeptdetail(Initialbalancesql.toString());//期初的结果
		resultmap.get(0).put("year", "");
		resultmap.get(0).put("month", String.valueOf(jsonmap.get("monthbegin")).substring(5));
		resultmap.get(0).put("day", "");
		if (Integer.valueOf(String.valueOf(jsonmap.get("monthbegin")).substring(5))==1) {
			resultmap.get(0).put("cdigest", "上年结转");
		}else {
			resultmap.get(0).put("cdigest", "期初余额");
		}
		BigDecimal value0=new BigDecimal(String.valueOf(resultmap.get(0).get("value0")));
		BigDecimal value1=new BigDecimal(String.valueOf(resultmap.get(0).get("value1")));
		BigDecimal mb=value0.subtract(value1);//期末余额
		int a = mb.compareTo(new BigDecimal("0"));
		if (a==1) {
			resultmap.get(0).put("me_direction", "借");
		}else if (a==-1) {
			resultmap.get(0).put("me_direction", "贷");
		}else if (a==0) {
			resultmap.get(0).put("me_direction", "平");
		}
		resultmap.get(0).put("me", Math.abs(mb.doubleValue()));
		Integer Mbegin = null;
		Integer Mend = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BigDecimal M=new BigDecimal("0");
		M=M.add(mb);
		for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
			String dataname=database.substring(0,database.length()-4)+i;
			if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
				Mbegin=Integer.valueOf(jsonmap.get("monthbegin").toString().substring(5));
			}else {
				Mbegin=1;
			}
			if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
				Mend=Integer.valueOf(jsonmap.get("monthend").toString().substring(5));
			}else {
				Mend=12;
			}
			for (int j = Mbegin; j <= Mend; j++) {
				String sql="Select GL_accvouch.md,GL_accvouch.mc,GL_accvouch.dbill_date,GL_accvouch.csign,GL_accvouch.ino_id,GL_accvouch.cdigest,GL_accvouch.cCode,GL_accvouch.iBook From " + dataname +
				".dbo.GL_accvouch GL_accvouch Left Join "+ dataname +".dbo.dsign dsign On GL_accvouch.csign=dsign.csign Where GL_accvouch.ccode Like '"+jsonmap.get("subjectcode")+"%' And GL_accvouch.iperiod="+j+
				"And IsNull(GL_accvouch.iflag,0)=0 "+isbilling+" Order By Gl_accvouch.dbill_date,dsign.isignseq,GL_accvouch.ino_id,GL_accvouch.cCode";
				List<Map<Object, Object>> findBySql = gL_accassService.findBySql(sql);
				if (findBySql!=null&&findBySql.size()>0) {
					for (Map<Object, Object> map : findBySql) {
						try {
							Date date = sdf.parse(String.valueOf(map.get("dbill_date")));
							map.put("dbill_date", String.valueOf(map.get("dbill_date")));
							map.put("year", date.getYear()+1900);
							map.put("month", date.getMonth()+1);
							map.put("day", date.getDate());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						//凭证号= Rs.Value(3) + "-" + Format(Rs.Value(4), "0000")
						String ino_id=map.get("csign")+"-0000";
						ino_id=ino_id.substring(0,ino_id.length()-map.get("ino_id").toString().length())+map.get("ino_id");
						map.put("ino", map.get("ino_id"));
						map.put("ino_id", ino_id);
						
						//摘要=IIf(Rs.Value(7) = 1, "", "*") + Rs.Value(5)
						if ("0".equals(map.get("iBook").toString())) {
							map.put("cdigest", "*"+map.get("cdigest"));
						}else {
							map.put("cdigest", map.get("cdigest"));
						}
						//借方金额=FormatSelf(Rs.Value(0))
						BigDecimal md=new BigDecimal(map.get("md").toString());
						map.put("md", md);
						map.put("Debtor", md);
						//借方合计=FormatSelf(Rs.Value(0))
						BigDecimal mdsum=new BigDecimal(map.get("md").toString());
						map.put("mdsum", mdsum);
						//贷方金额=FormatSelf(Rs.Value(1))
						BigDecimal mc=new BigDecimal(map.get("mc").toString());
						map.put("mc", mc);
						map.put("Lender", mc);
						//贷方合计=FormatSelf(Rs.Value(1))
						BigDecimal mcsum=new BigDecimal(map.get("mc").toString());
						map.put("mcsum",mcsum);
						//设M=M+value(0) - value(1)
						M=M.add(md.subtract(mc));
						//期末余额方向=如果M>0 则为 “借” 如果M<0 则为 “贷" 否则为 平
						int a1 = M.compareTo(new BigDecimal("0"));
						if (a1==1) {
							map.put("me_direction", "借");
						}else if (a1==0) {
							map.put("me_direction", "平");
						}else if (a1==-1) {
							map.put("me_direction", "贷");
						}
						//期末余额=abs(M)
						map.put("me", Math.abs(M.doubleValue()));
						for (int k = 0; k < MDcodes.size(); k++) {
							if (md.compareTo(new BigDecimal("0"))!=0) {
								map.put("md"+map.get("cCode"), md.add(new BigDecimal("0.00")).setScale(2).toString());
							}else {
								map.put("md"+map.get("cCode"), "");
							}
						}
						for (int k = 0; k < MCcodes.size(); k++) {
							if (mc.compareTo(new BigDecimal("0"))!=0) {
								map.put("mc"+map.get("cCode"), mc.add(new BigDecimal("0.00")).setScale(2).toString());
							}else {
								map.put("mc"+map.get("cCode"), "");
							}
						}
						resultmap.add(map);
						map.put("mc", new BigDecimal(map.get("mc")+"").add(new BigDecimal("0.00")).setScale(2).toString());
						if (Double.valueOf(map.get("mc")+"")==0.00) {
							map.put("mc", "");
						}
						map.put("me", new BigDecimal(map.get("me")+"").add(new BigDecimal("0.00")).setScale(2).toString());
						if (Double.valueOf(map.get("me")+"")==0.00) {
							map.put("me", "");
						}
						map.put("md", new BigDecimal(map.get("md")+"").add(new BigDecimal("0.00")).setScale(2).toString());
						if (Double.valueOf(map.get("md")+"")==0.00) {
							map.put("md", "");
						}
					}
					String sql2="Select IsNull(Sum(GL_accvouch.md),0) as md,IsNull(Sum(GL_accvouch.mc),0) as mc From "+ dataname +".dbo.GL_accvouch Where GL_accvouch.ccode Like '"+jsonmap.get("subjectcode")+"%' And GL_accvouch.iperiod="+j+" And IsNull(GL_accvouch.iflag,0)=0 ";
					List<Map<Object, Object>> findBySql2 = gL_accassService.findBySql(sql2);
					for (Map<Object, Object> map2 : findBySql2) {
							map2.put("year", i);
							map2.put("month", j);
						if (i<Integer.valueOf(startTime.substring(0,4))||j<Integer.valueOf(startTime.substring(5,7))) {
							map2.put("cdigest", "本月合计");
						}else{
							map2.put("cdigest", "当前合计");
						}
						map2.put("flag", "1");
//						借方金额=FormatSelf(Rs.Value(0))
						map2.put("md", map2.get("md"));
//						借方合计=FormatSelf(Rs.Value(0))
						map2.put("mdsum", map2.get("md"));
//						贷方金额=FormatSelf(Rs.Value(1))
						map2.put("mc", map2.get("mc"));
//						贷方合计=FormatSelf(Rs.Value(1))	
						map2.put("mcsum", map2.get("mc"));
						map2.put("Debtor", map2.get("md"));
						map2.put("Lender", map2.get("mc"));
//						M=M.add(new BigDecimal(map2.get("md").toString()).subtract(new BigDecimal(map2.get("mc").toString())));
						
						int a2=M.compareTo(new BigDecimal("0"));
						if (a2==-1) {
							map2.put("me_direction", "贷");
						}else if (a2==0) {
							map2.put("me_direction", "平");
						}else if (a2==1) {
							map2.put("me_direction", "借");
						}
						map2.put("me", M.abs());
						for (Map<Object, Object> map3 : MDcodes) {
							String sql3 = "Select IsNull(Sum(GL_accvouch.md),0) as a From "
									+ dataname
									+ ".dbo.GL_accvouch Where GL_accvouch.ccode Like '"
									+ map3.get("cCode")
									+ "%' "
									+ "And GL_accvouch.iperiod='"
									+ j
									+ "' And IsNull(GL_accvouch.iflag,0)=0 "
									+ isbilling + " ";
							List<Map<Object, Object>> mdresult = gl_accassService
									.findBySql(sql3);
							Object value = mdresult.get(0).get("a");
							if (new BigDecimal(value + "")
									.compareTo(new BigDecimal("0")) != 0) {
								map2.put(
										"md" + map3.get("cCode"),
										new BigDecimal(value.toString())
												.add(new BigDecimal("0.00"))
												.setScale(2).toString());
							} else {
								map2.put("md" + map3.get("cCode"), "");
							}
						}
						for (Map<Object, Object> map3 : MCcodes) {
							String sql3 = "Select IsNull(Sum(GL_accvouch.mc),0) as a "
									+ "From "
									+ dataname
									+ ".dbo.GL_accvouch Where GL_accvouch.ccode Like '"
									+ map3.get("cCode")
									+ "%' And GL_accvouch.iperiod='"
									+ j
									+ "'"
									+ " And IsNull(GL_accvouch.iflag,0)=0 "
									+ isbilling + " ";
							List<Map<Object, Object>> mcresult = gl_accassService
									.findBySql(sql3);
							Object value = mcresult.get(0).get("a");
							if (new BigDecimal(value + "")
									.compareTo(new BigDecimal("0")) != 0) {
								map2.put(
										"mc" + map3.get("cCode"),
										new BigDecimal(value.toString())
												.add(new BigDecimal("0.00"))
												.setScale(2).toString());
							} else {
								map2.put("mc" + map3.get("cCode"), "");
							}
						}
						map2.put("mc",new BigDecimal(map2.get("mc") + "").add(new BigDecimal("0.00")).setScale(2).toString());
						
						map2.put("Lender", new BigDecimal(map2.get("mc") + "").add(new BigDecimal("0.00")).setScale(2).toString());
						if (Double.valueOf(map2.get("mc") + "") == 0.00) {
							map2.put("mc", "");
						}
						map2.put("me",new BigDecimal(map2.get("me") + "").add(new BigDecimal("0.00")).setScale(2).toString());
						
						if (Double.valueOf(map2.get("me") + "") == 0.00) {
							map2.put("me", "");
						}
						BigDecimal map2md = map2.get("md")==null?new BigDecimal(0):new BigDecimal(map2.get("md")+"");
						map2.put("md",map2md.add(new BigDecimal("0.00")).setScale(2).toString());
						map2.put("Debtor", map2md.add(new BigDecimal("0.00")).setScale(2).toString());
						
						
						resultmap.add(map2);
					}
					//最后 一行
					Map<Object, Object> map = new HashMap<Object, Object>();
					List<Map<Object, Object>> bflag = gl_accassService.findBySql("select bflag from "+ database+ ".dbo.gl_mend where iperiod="+ String.valueOf(jsonmap.get("monthbegin")).substring(5) + "");
					if (bflag.get(0).get("bflag").toString().equals("true")) {
						map.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
					} else {
						map.put("cdigest", "当前累计");
					}
					map.put("flag", "1");
					map.put("me_direction", "平");
					map.put("me", "");
					BigDecimal mdhj = new BigDecimal("0.00");
					for (Map<Object, Object> map3 : MDcodes) {//借方
						String sql3="Select IsNull(Sum(GL_accvouch.md),0) as a From " + dataname + ".dbo.GL_accvouch Where GL_accvouch.ccode Like '" + map3.get("cCode") + "%' And GL_accvouch.iperiod<='"+j+"' And IsNull(GL_accvouch.iflag,0)=0 "+ isbilling +" ";
						List<Map<Object, Object>> mdresult = gl_accassService.findBySql(sql3);
						Object value = mdresult.get(0).get("a");
						mdhj = mdhj.add(new BigDecimal(value.toString()));
						if (new BigDecimal(value + "").compareTo(new BigDecimal("0")) != 0) {
							map.put("md" + map3.get("cCode"),new BigDecimal(value.toString()).add(new BigDecimal("0.00")).setScale(2).toString());
						} else {
							map.put("md" + map3.get("cCode"), "");
						}
					}
					map.put("md", mdhj);
					BigDecimal mchj = new BigDecimal("0.00");
					for (Map<Object, Object> map3 : MCcodes) {//贷方
						String sql3 = "Select IsNull(Sum(GL_accvouch.mc),0) as a " + "From " + dataname + ".dbo.GL_accvouch Where GL_accvouch.ccode Like '"+ map3.get("cCode")+ "%' "+ " and GL_accvouch.iperiod > 0 And GL_accvouch.iperiod<='"+ j+ "' And IsNull(GL_accvouch.iflag,0)=0 "+ isbilling + " ";
						List<Map<Object, Object>> mcresult = gl_accassService.findBySql(sql3);
						Object value = mcresult.get(0).get("a");
						mchj = mchj.add(new BigDecimal(value.toString()));
						if (new BigDecimal(value + "").compareTo(new BigDecimal("0")) != 0) {
							map.put("mc" + map3.get("cCode"),new BigDecimal(value.toString()).add(new BigDecimal("0.00")).setScale(2).toString());
						} else {
							map.put("mc" + map3.get("cCode"), "");
						}
					}
					map.put("mc",mchj.add(new BigDecimal("0.00")).setScale(2).toString());
					if (Double.valueOf(map.get("mc") + "") == 0.00) {
						map.put("mc", "");
					}
					resultmap.add(map);
				}
			}
		}
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("total", resultmap.size());
		String pageNumber=request.getParameter("page");
		
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		Integer toindex=null;
		Integer fromindex=null;
		if(pageNumber.equals("1")&&pageSize.equals("500")){
			if (Integer.valueOf("500")<=resultmap.size()) {
				toindex=500;
			}else {
				toindex=resultmap.size();
			}
			resultmap=resultmap.subList(Integer.valueOf(pageNumber), toindex);
		}else {
			if (Integer.valueOf(pageNumber)-Integer.valueOf(pageSize)*Integer.valueOf(pageSize)<=resultmap.size()) {
				fromindex=Integer.valueOf(pageNumber)-Integer.valueOf(pageSize)*Integer.valueOf(pageSize);
			}else {
				fromindex=resultmap.size();
			}
			if (Integer.valueOf(pageSize)<=resultmap.size()) {
				toindex=Integer.valueOf(pageSize);
			}else {
				toindex=resultmap.size();
			}
			resultmap=resultmap.subList(fromindex, toindex);
		}
//		if (MDcodes!=null&&MDcodes.size()>0) {
//			map.put("rows", MDcodes);
//		}
//		if (MCcodes!=null&&MCcodes.size()>0) {
//			map.put("rows", MCcodes);
//		}
//		if(resultmap.size()>2){
//			resultmap.get(resultmap.size()-1).put("me", "");
//		}
		if (resultmap!=null&&resultmap.size()>0) {
			map.put("rows", resultmap);
		}
		return map;
	}
	
	*//**
	 * 恢复到月初状态
	 * *//*
	@RequestMapping(params = "regainState")
	@ResponseBody
	public Map<Object, Object> regainState(HttpServletRequest request){
		Map<Object, Object> resultmap=new HashMap<>();
		resultmap.put("type", '0');
		String database = request.getSession().getAttribute("database").toString();
		String SmNoAccount = request.getSession().getAttribute("SmNoAccount").toString();
		Integer iperiod=Integer.parseInt(SmNoAccount);
		GLmend gLmend=GLmendservice.findByIperiod(database+".dbo.gl_mend",iperiod);//获取该月份是否月结
		Boolean bflag = gLmend.getBflag();
		if(bflag){
			resultmap.put("msg","本月总账系统已经结账");
			return resultmap;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			resultmap.put("msg","有互斥功能正在使用中");  
			return resultmap;
		}
		Integer count=zZ_Lockservice.getMonthAccvouch(database+".dbo.ZZ_Lock",database+".dbo.GL_accvouch",iperiod);
		if(count>0){
			resultmap.put("msg","有凭证被锁定，不能执行恢复记账到月初！");
			return resultmap;
		}
		try{
			gl_accsumservice.restoreMonBegState(request,database,iperiod);
			resultmap.put("msg","恢复记账到月初状态成功");
			resultmap.put("type", '1');
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("msg","恢复记账到月初状态失败-数据库错误");
		}
		return resultmap;
	}
	
	*//**
	 * 凭证记账
	 * *//*
	@RequestMapping(params = "tally")
	@ResponseBody
	public Map<Object, Object> tally(HttpServletRequest request){
		Map<Object, Object> resultmap=new HashMap<>();
		resultmap.put("type",'0');//默认失败
		String database = request.getSession().getAttribute("database").toString();
		String iperiod = request.getSession().getAttribute("SmNoAccount").toString();
		GLmend gLmend=GLmendservice.findByIperiod(database+".dbo.gl_mend",Integer.parseInt(iperiod));//获取该月份是否月结
		if(gLmend.getBflag()){
			resultmap.put("msg","本月总账系统已经结账");
			return resultmap;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			resultmap.put("msg","有互斥功能正在使用中");  
			return resultmap;
		}
		resultmap.put("type",'1');
		List<Map<Object, Object>> resultArrMap=new ArrayList<>();
		List<Map<Object, Object>> rowMaps=(List<Map<Object, Object>>) JSON.parse(request.getParameter("selectrow"));
		for (Map<Object, Object> map : rowMaps) {
			String ino_id = map.get("ino_id").toString();
			String csign = map.get("csign").toString();
			List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(iperiod),csign,Short.parseShort(ino_id));
			if(GlAccvouchs==null || GlAccvouchs.size()==0){
				map.put("operationEnd", "没有找到实际凭证");
				resultArrMap.add(map);
				continue;
			}
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",Byte.parseByte(iperiod),csign,Short.parseShort(ino_id));
			if(zZ_Lock!=null){
				map.put("msg","当前凭证已被锁定");  
				resultArrMap.add(map);
				continue;
			}
			GlAccvouch glAccvouch = GlAccvouchs.get(0);
			if(glAccvouch.getCcheck()==null || glAccvouch.getCcheck().length()==0){
				map.put("msg","凭证并未审核");  
				resultArrMap.add(map);
				continue;
			}
			
			if(glAccvouch.getCbook()!=null && glAccvouch.getCbook().length()>0){
				map.put("operationEnd", "凭证已记账");
				resultArrMap.add(map);
				continue;
			}
			
			if(glAccvouch.getIflag()!=null && glAccvouch.getIflag()==1){
				map.put("operationEnd", "作废");
				resultArrMap.add(map);
				continue;
			}
			if(glAccvouch.getIflag()!=null && glAccvouch.getIflag()==2){
				map.put("operationEnd", "错误");
				resultArrMap.add(map);
				continue;
			}
			Double Contrast=glAccvouchservice.findMdContrastMc(database+".dbo.GL_accvouch",database+".dbo.code",iperiod,csign,ino_id);
			if(Contrast!=null && Contrast>0){
				map.put("operationEnd", "借贷不平");
				resultArrMap.add(map);
				//标错
				glAccvouchservice.updateIflag(database+".dbo.GL_accvouch ",ConstantUtil.mistake,iperiod,csign,ino_id);
				continue;
			}
			//记账
			
			String cdept_id = map.get("cdept_id")==null?"":map.get("cdept_id").toString();//部门
			String cperson_id = map.get("cperson_id")==null?"":map.get("cperson_id").toString();//人员
			String ccus_id = map.get("ccus_id")==null?"":map.get("ccus_id").toString();//客户
			String csup_id = map.get("csup_id")==null?"":map.get("csup_id").toString();//供应商
			String citem_id = map.get("citem_id")==null?"":map.get("citem_id").toString();//项目
			
			GlAccvouch gl_accvouch=new GlAccvouch();
			gl_accvouch.setCdept_id(cdept_id);
			gl_accvouch.setCperson_id(cperson_id);
			gl_accvouch.setCcus_id(ccus_id);
			gl_accvouch.setCsup_id(csup_id);
			gl_accvouch.setCitem_id(citem_id);
			gl_accvouch.setIperiod(Byte.parseByte(iperiod));
			gl_accvouch.setCsign(csign);
			gl_accvouch.setIno_id(Short.parseShort(ino_id));
			try{
				glAccvouchService.Tally(request,gl_accvouch);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("operationEnd","当前凭证记账失败-数据库操作错误");  
				resultArrMap.add(map);
			}
		}
		
		if(resultArrMap.size()>0){
			resultmap.put("msg", "有部份凭证记账失败");
		}else{
			resultmap.put("msg", "记账成功");
		}
		resultmap.put("resultArrMap", resultArrMap);
		return resultmap;
	}
	
	
	
		public static void readFile(String path){
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String readLine = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	*//**
	 * 凭证导出
	 * *//*
	@RequestMapping(params = "voucherExcelPort")
	@ResponseBody
	public Map<String,String> voucherExcelPort(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> resultmap=new HashMap<>();
		resultmap.put("type", "0");
		String path="";//文件下载的位置
		String realPath =request.getRealPath("export/template")+"/"+"model.xls";
		if(realPath==null || realPath.length()==0){
			resultmap.put("msg", "凭证导出无法继续! 模板文件(model.xls)不存在.");
			return resultmap;
		}
		
		String database = request.getSession().getAttribute("database").toString();
		String parameter = request.getParameter("rows");
		List<List<GlAccvouchVo>> GlAccvouchsList=new ArrayList<>();
		List<GlAccvouch> GlAccvouchs=(List)JSON.parseArray(parameter,GlAccvouch.class);
		for (GlAccvouch glAccvouch : GlAccvouchs) {
			List<GlAccvouchVo> selectGlAccvouchs = glAccvouchService.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch", (int)glAccvouch.getIperiod(), glAccvouch.getCsign(), glAccvouch.getIno_id());
			dsign dsign = dsignservice.selectBycsign(database+".dbo.dsign", glAccvouch.getCsign());
			for (GlAccvouchVo glAccvouchv : selectGlAccvouchs) {
				Code code = codeService.selectByCcode(database+".dbo.code",glAccvouchv.getCcode());
				glAccvouchv.setCodeName(code.getCcode_name());
				//现金流
				ZZ_CashTable zZ_CashTable=new ZZ_CashTable();
				zZ_CashTable.setIperiod(glAccvouchv.getIperiod());
				zZ_CashTable.setCsign(glAccvouchv.getCsign());
				zZ_CashTable.setIno_id(glAccvouchv.getIno_id());
				zZ_CashTable.setInid(glAccvouchv.getInid());
				List<ZZ_CashTable> ZZ_CashTables = zz_CashTableservice.selectByParameter(database+".dbo.zz_CashTable", zZ_CashTable);
				if(ZZ_CashTables!=null && ZZ_CashTables.size()>0){
					glAccvouchv.setCashCode(ZZ_CashTables.get(0).getCitemcode());
				}
			}
			selectGlAccvouchs.get(0).setCsignName(dsign.getCtext());
			GlAccvouchsList.add(selectGlAccvouchs);
		}
		
		HashMap<String,List> sumMap=new HashMap<>();
		List<CodeV> codes=codeService.findAll(database+".dbo.code");
		List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
		List<Department> departments = departmentService.selectDepartment(database+".dbo.department");
		List<Person> persons = personService.getAll(database+".dbo.person");
		List<Customer> customers = customerService.getAll(database+".dbo.customer");
		List<Vendor> vendors = vendorService.getAll(database+".dbo.vendor");
		List<HT_GLItem> ht_GLItems =ht_GLItemService.findAll(database+".dbo.ht_GLItem");
		sumMap.put("codes", codes);
		sumMap.put("dsigns", dsigns);
		sumMap.put("departments", departments);
		sumMap.put("persons", persons);
		sumMap.put("customers", customers);
		sumMap.put("vendors", vendors);
		sumMap.put("ht_GLItems", ht_GLItems);
		try {
			//获取当前日期
			SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
			Date date=new Date();
			String uname=df.format(date);
			String FileName="凭证报表("+uname+").xlsx";
			path = request.getRealPath("upload/excel/accvouch")+"/"+FileName;
			ExcelUtil.accvouchExport(sumMap,GlAccvouchsList,path,realPath, request, response);
			} catch (Exception e) {
				e.printStackTrace();
				resultmap.put("msg", "凭证导出失败(系统错误)");
				return resultmap;
			}
		resultmap.put("type", "1");
		resultmap.put("msg", "凭证导出成功");
		resultmap.put("path", path);
		return resultmap;
	}
	*//**
	 * 凭证导入
	 * *//*
	@RequestMapping(params = "voucherExcelImPort")
	@ResponseBody
	public HashMap<Object,Object> voucherExcelPort(@RequestParam(value="file",required = false)MultipartFile file,HttpServletRequest request
			,HttpServletResponse response){
		String cover = request.getParameter("cover").toString();
		String database = request.getSession().getAttribute("database").toString();
		HashMap<Object,Object> resultmap=new ExcelUtil().getExcelInfo(file,request,ConstantUtil.gl_accvouch);
		if(resultmap.get("resultList")==null){
			resultmap.put("type", "0");
			return resultmap;
		}else{
			List<List<GlAccvouchVo>> resultList = (List<List<GlAccvouchVo>>)resultmap.get("resultList");
			List<GlAccvouchVo> skiplist=new ArrayList<>();//放弃覆盖跳过导入的凭证
			for (int i=0; i<resultList.size(); i++) {
				List<GlAccvouchVo> list=resultList.get(i);
				HashMap<Object,Object> excelImport = glAccvouchService.excelImport(request,list,cover);
				String type = excelImport.get("type").toString();
				if(type.equals("0")){
					excelImport.put("msg","凭证导入失败:第"+(i+1)+"张凭证,"+excelImport.get("msg").toString());
					return excelImport;
				}else{
					GlAccvouchVo glAccvouchVo = list.get(0);
					Short inoid = glAccvouchVo.getIno_id();
					//校验完毕-数据库添加凭证 凭证号--1:1000号跳过,2:负数的凭证号采用覆盖,3:正数凭证号采用
					try {  
						if(inoid==10000){
							skiplist.add(glAccvouchVo);
							continue;
						}else if(inoid<0){
							glAccvouchService.updateList(database,list,null);
						}else if(inoid>0){
							glAccvouchService.addList(database,list);
						}
						uffj_AccLogService.insertinto(request, "凭证录入","导入" ,glAccvouchVo.getCsign()+","+glAccvouchVo.getIperiod()+","+glAccvouchVo.getIno_id(), "原始凭证号:"+glAccvouchVo.getCtext1());
					 } catch (Exception e) {    
						 e.printStackTrace();
						resultmap.put("type", "0");
						resultmap.put("msg","凭证导入失败,第"+(i+1)+"张凭证,数据库操作错误");
						return resultmap;
					 }
				}
			}
			int glAccsize = resultList.size();//总凭证数
			int skipsize = skiplist.size();//跳过张数
			resultmap.put("type", "1");
			resultmap.put("msg","成功导入凭证"+(glAccsize-skipsize)+"张,跳过覆盖"+skipsize+"张");
			return resultmap;
		}
	}
	
	*//**
	 * 账簿查询-余额表 月份 初始化
	 * *//*
	@RequestMapping(params = "monthinit")
	@ResponseBody
	public List<Object> monthinit(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		AccInformation accInformation = accInformationService.findBycname(database+".dbo.AccInformation","HTGLUse");
		String cValue = accInformation.getcValue();
		if(cValue.equals("0")){
			cValue="1";
		}
		List<Object> list=new ArrayList<>();
		String year=request.getSession().getAttribute("year").toString();
		for(int i=Integer.parseInt(cValue);i<13;i++){
			HashMap<String,String> map=new HashMap();
			map.put("id",i+"");
			if(i<10){
				map.put("text", year+".0"+i);
			}else{
				map.put("text", year+"."+i);
			}
			list.add(map);
		}
		return list;
	}
	*//**
	 * 账簿查询-余额表 查询
	 * *//*
	@RequestMapping(params = "balanceSelect")
	@ResponseBody
	public Map<Object, Object> balanceSelect(HttpServletRequest request,Integer page,Integer rows){
		if(rows==10){
			rows=500;
		}
		String database=request.getSession().getAttribute("database").toString();
		
		HashMap<Object,Object> map=JSON.parseObject(request.getParameter("record"),HashMap.class);
		String year = map.get("year").toString();
		database=database.substring(0,database.length()-4)+year;
		map.put("tablename", "HTZZFSEYEB");
		map.put("endcode", "0");
		boolean keepZflag=(boolean)map.get("keepZflag");//是否包含未记账
		boolean showAssist=(boolean)map.get("showAssist");//是否显示辅助核算内容
		if(keepZflag){
			map.put("keepZflag", "0");
		}else{
			map.put("keepZflag", "1");
		}
		HashMap<String,Code> codemap=new HashMap<>();
		List<Code> findAllcodes = codeService.selectAll(database+".dbo.code");
		for (Code codeV : findAllcodes) {
			codemap.put(codeV.getCcode(),codeV);
		}
		ArrayList<Code> codes=codeService.findGroupCclass(database+".dbo.code");
		HashMap<String,String> codeclassmap=new HashMap<>();
		String sql="Case cClass";
		for (Code code : codes) {
			codeclassmap.put(code.getCcode(), code.getCclass());
			sql+=" when \""+code.getCclass()+"\" then "+code.getCcode();
		}
		sql+=" end as lx";
		map.put("case", sql);
		ArrayList<HashMap<Object,Object>> list=glAccvouchService.findBalance(database+".dbo.GL_P_FSEYEB",map);
		HashMap<Object,Object> CodeFZlistmap=new HashMap<>();//科目辅助核算
		for (HashMap<Object, Object> hashMap : list) {
			if(hashMap.get("lx").toString().equals("9")){
				hashMap.put("ccode","合计");
			}else{
				if(hashMap.get("ccode").equals("zz")){
					hashMap.put("ccode",codeclassmap.get(hashMap.get("lx").toString())+"小计");
				}else{
					String ccode=hashMap.get("ccode").toString();
					Code code = codemap.get(ccode);
					if(code==null){
						continue;
					}
					Byte igrade =code.getIgrade();
					hashMap.put("ccode_name2",hashMap.get("ccode_name"));
					for(int i=0;i<(igrade-1)*2;i++){
						hashMap.put("ccode_name","&emsp;"+hashMap.get("ccode_name"));
					}
					HashMap<Object,Object> FZlistmap=null;
					Boolean bend = code.getBend();//末级科目
					//辅助核算数据集合
					if(showAssist && bend &&(code.getBperson()||code.getBcus()||code.getBsup()||code.getBdept()||code.getBitem())){
						FZlistmap=new HashMap<>();
						String type="";
						if(code.getBdept()){//部门
							type+="dep";
						}
						if(code.getBperson()){//个人
							type+="per";
						}
						if(code.getBsup()){//供应商
							type+="sup";
						}
						if(code.getBcus()){//客户
							type+="cus";
						}
						if(code.getBitem()){//项目
							type+="itm";
						}
						String asswhere="";
						String asswhere2="";
						String database2="";
						for(int i=3;i<=type.length();i+=3){
							if(type.substring(i-3,i).equals("dep")){
								database2=database+".dbo.department";
							}else if(type.substring(i-3,i).equals("per")){
								database2=database+".dbo.person";
							}else if(type.substring(i-3,i).equals("sup")){
								database2=database+".dbo.vendor";
							}else if(type.substring(i-3,i).equals("cus")){
								database2=database+".dbo.customer";
							}else if(type.substring(i-3,i).equals("itm")){
								database2=database+".dbo.ht_glitem";
							}
							
							if(i==3){
								ArrayList<HashMap<Object,Object>> Assistlist=glAccvouchservice.findAssistBalance
										(type.substring(i-3,i),database+".dbo.gl_Accvouch",database2,map.get("beginmonth").toString(),map.get("endmonth").toString(),ccode,asswhere);
								FZlistmap.put(type.substring(i-3,i), Assistlist);
							}else if(i==6){
								FZlistmap.put(type.substring(i-3,i),new ArrayList<HashMap<Object,Object>>());
								String subtype=type.substring(0,3);
								if(subtype.equals("dep")){
									asswhere="cdept_id";
								}else if(subtype.equals("per")){
									asswhere="cperson_id";
								}else if(subtype.equals("sup")){
									asswhere="csup_id";
								}else if(subtype.equals("cus")){
									asswhere="ccus_id";
								}else if(subtype.equals("itm")){
									asswhere="citem_id";
								}
								ArrayList<HashMap<Object, Object>> arrayList = (ArrayList<HashMap<Object, Object>>)FZlistmap.get(subtype);
								for (HashMap<Object, Object> hashMap2 : arrayList) {
									ArrayList<HashMap<Object,Object>> Assistlist=glAccvouchservice.findAssistBalance(type.substring(i-3,i),database+".dbo.gl_Accvouch",database2,map.get("beginmonth").toString(),map.get("endmonth").toString(),ccode,"and "+asswhere+"="+hashMap2.get(asswhere));
									if(Assistlist!=null){
										ArrayList<HashMap<Object, Object>> listobj=(ArrayList<HashMap<Object, Object>>)FZlistmap.get(type.substring(i-3,i));
										listobj.addAll(Assistlist);
										FZlistmap.put(type.substring(i-3,i),listobj);
									}
								}
							}else if(i==9){
								FZlistmap.put(type.substring(6,9),new ArrayList<HashMap<Object,Object>>());
								String subtype=type.substring(0,3);
								String subtype2=type.substring(3,6);
								if(subtype.equals("dep")){
									asswhere="cdept_id";
								}else if(subtype.equals("per")){
									asswhere="cperson_id";
								}else if(subtype.equals("sup")){
									asswhere="csup_id";
								}else if(subtype.equals("cus")){
									asswhere="ccus_id";
								}else if(subtype.equals("itm")){
									asswhere="citem_id";
								}
								if(subtype2.equals("dep")){
									asswhere2="cdept_id";
								}else if(subtype2.equals("per")){
									asswhere2="cperson_id";
								}else if(subtype2.equals("sup")){
									asswhere2="csup_id";
								}else if(subtype2.equals("cus")){
									asswhere2="ccus_id";
								}else if(subtype2.equals("itm")){
									asswhere2="citem_id";
								}
								ArrayList<HashMap<Object, Object>> arrayList = (ArrayList<HashMap<Object, Object>>)FZlistmap.get(subtype);
								ArrayList<HashMap<Object, Object>> arrayList2 = (ArrayList<HashMap<Object, Object>>)FZlistmap.get(subtype2);
								for (HashMap<Object, Object> hashMap2 : arrayList) {
									for (HashMap<Object, Object> hashMap3 : arrayList2) {
										ArrayList<HashMap<Object,Object>> Assistlist=glAccvouchservice.findAssistBalance(type.substring(i-3,i),database+".dbo.gl_Accvouch",database2,map.get("beginmonth").toString(),map.get("endmonth").toString(),ccode,"and "+asswhere+"="+hashMap2.get(asswhere)+"and "+asswhere2+"="+hashMap3.get(asswhere2));
										if(Assistlist!=null){
											ArrayList<HashMap<Object, Object>> listobj=(ArrayList<HashMap<Object, Object>>)FZlistmap.get(type.substring(i-3,i));
											listobj.addAll(Assistlist);
											FZlistmap.put(type.substring(i-3,i),listobj);
										}
									}
								}
							}
						}
					}
					CodeFZlistmap.put(ccode, FZlistmap);
				}
			}
			Double bmoney=0.0;
			if(Double.parseDouble(hashMap.get("sbb").toString())>0){
				hashMap.put("btype","借");
				bmoney=Double.parseDouble(hashMap.get("sbb").toString());
			}else if(Double.parseDouble(hashMap.get("sbb1").toString())>0){
				hashMap.put("btype","贷");
				bmoney=Double.parseDouble(hashMap.get("sbb1").toString());
			}else{
				hashMap.put("sdd_f","");
				hashMap.put("smm_f","");
				hashMap.put("btype","平");
			}
			hashMap.put("bmoney",bmoney);
			Double emoney=0.0;
			if(Double.parseDouble(hashMap.get("smm").toString())>0){
				hashMap.put("etype","借");
				emoney=Double.parseDouble(hashMap.get("smm").toString());
			}else if(Double.parseDouble(hashMap.get("smm1").toString())>0){
				hashMap.put("etype","贷");
				emoney=Double.parseDouble(hashMap.get("smm1").toString());
			}else{
				hashMap.put("sbb_s","");
				hashMap.put("smm_s","");
				hashMap.put("etype","平");
			}
			hashMap.put("emoney",emoney);
		}
		ArrayList<HashMap<Object, Object>> resultList=new ArrayList<HashMap<Object, Object>>();
		for (HashMap<Object, Object> hashMap2 : list) {
				hashMap2.put("text","["+hashMap2.get("ccode")+"]"+hashMap2.get("ccode_name"));
			if(CodeFZlistmap.get(hashMap2.get("ccode"))!=null && ((HashMap<Object, Object>)CodeFZlistmap.get(hashMap2.get("ccode"))).size()>0){
				HashMap<Object, Object> mapp=(HashMap<Object, Object>)CodeFZlistmap.get(hashMap2.get("ccode"));
				for (Object skey : mapp.keySet()) {
					ArrayList<HashMap<Object, Object>> fzresultList=new ArrayList<HashMap<Object, Object>>();
					ArrayList<HashMap<Object,Object>> listmap=(ArrayList<HashMap<Object,Object>>)mapp.get(skey);
					for (int j=0;j<listmap.size();j++) {
						HashMap<Object,Object> hashMap=listmap.get(j);
						HashMap<Object, Object> fzmap=new HashMap<Object, Object>();
						fzmap.put("FZcode",skey);
						fzmap.put("ccode2",hashMap2.get("ccode"));
						String btype = (String)hashMap2.get("btype");
						String etype = (String)hashMap2.get("etype");
						fzmap.put("btype",btype);//方向
						fzmap.put("etype",etype);//方向
						fzmap.put("sdd_f",hashMap.get("mb_f"));//期初外币
						fzmap.put("smd_f",hashMap.get("md_f"));//本期借方外币
						fzmap.put("smc_f",hashMap.get("mc_f"));//本期贷方外币
						fzmap.put("smm_f",hashMap.get("me_f"));//期末外币
						fzmap.put("sbb_s",hashMap.get("nb_s"));//期初数量
						fzmap.put("smd_s",hashMap.get("nd_s"));//本期借方数量
						fzmap.put("smc_s",hashMap.get("nc_s"));//本期贷方数量
						fzmap.put("smm_s",hashMap.get("ne_s"));//期末数量
						fzmap.put("smd",hashMap.get("md"));//本期借方
						fzmap.put("smc",hashMap.get("mc"));//本期贷方
						fzmap.put("sld",hashMap.get("md_"));//累计借方
						fzmap.put("slc",hashMap.get("mc_"));//累计贷方
						fzmap.put("sld_f",hashMap.get("md_f_"));//累计借方外币
						fzmap.put("slc_f",hashMap.get("mc_f_"));//累计贷方外币
						fzmap.put("sld_s",hashMap.get("nd_s_"));//累计借方数量
						fzmap.put("slc_s",hashMap.get("nc_s_"));//累计贷方数量
						fzmap.put("ccode","&emsp;"+hashMap.get("id"));//id
						fzmap.put("ccode_name","&emsp;"+hashMap.get("name"));//名称
						Code code = codemap.get(hashMap2.get("ccode"));
						for(int i=0;i<(code.getIgrade()-1)*2;i++){//级别空格
							fzmap.put("ccode_name","&emsp;"+fzmap.get("ccode_name"));//名称
						}
						if(btype.equals("借")){
							fzmap.put("sbb",hashMap.get("mb"));
						}else if(btype.equals("贷")){
							fzmap.put("sbb1",hashMap.get("mb"));
						}
						fzmap.put("bmoney",hashMap.get("mb"));//期初余额
						if(etype.equals("借")){
							fzmap.put("smm",hashMap.get("me"));
						}else if(etype.equals("贷")){
							fzmap.put("smm1",hashMap.get("me"));
						}
						fzmap.put("emoney",hashMap.get("me"));//期末余额
						fzresultList.add(fzmap);
					}
					if(fzresultList.size()>0){
						//hashMap2.put("FZcode","1");
					}
					resultList.add(hashMap2);
					resultList.addAll(fzresultList);
				}
			}else{
				resultList.add(hashMap2);
			}
		}
		Map<Object, Object> RESULTmap = Paging.pagIng(page, rows, resultList);
        return RESULTmap;
		//return resultList;
	}
	
	@RequestMapping(params = "getcashflowwrite")
	@ResponseBody
	public Map<Object, Object> getcashflowwrite(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();//部门
		String pageNumber=request.getParameter("page");
		
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		HashMap<String,Object> conditionMap=JSON.parseObject(request.getParameter("data"),HashMap.class);
		String cursor="";
		Integer page=Integer.valueOf(pageNumber);
		String orderby1="GL_accvouch.iperiod, GL_accvouch.isignseq, GL_accvouch.ino_id";
		String orderby2="q.iperiod, q.isignseq, q.ino_id";
		String orderby3 = "a.iperiod, a.isignseq, a.ino_id";
			cursor="with q as ( "
					+ "select ROW_NUMBER() over (partition by isnull(1,1) order by "+orderby3+" ) rn ,a.* from ("
					+ "Select ROW_NUMBER() OVER ( PARTITION BY cast(GL_accvouch.csign as varchar)+cast(GL_accvouch.ino_id as varchar) order by "+orderby1+") as rank"
					+ ",GL_accvouch.csign, GL_accvouch.ino_id, GL_accvouch.dbill_date, GL_accvouch.cdigest, GL_accvouch.ccode, code.ccode_name, GL_accvouch.md, GL_accvouch.mc, GL_accvouch.cbill, GL_Accvouch.iPeriod, GL_Accvouch.inid, "
			+ "Isnull((select sum(md - mc) from "+database+".dbo.ZZ_CashTable "
			+ "Where iPeriod = Gl_accvouch.iperiod And csign = Gl_Accvouch.csign and ino_id = gl_accvouch.ino_id and inid = gl_accvouch.inid),0) as me, "
			+ "isnull(zz_cashtable.citemcode,'') citemcode, isnull(ht_ccitem.citemname,'') citemname ,GL_accvouch.isignseq "
			+ "From "+database+".dbo.gL_accvouch Left Join "+database+".dbo.Code on Gl_Accvouch.cCode = Code.cCode left join "+database+".dbo.zz_cashtable on gl_accvouch.iperiod = zz_cashtable.iperiod and gl_accvouch.csign = zz_cashtable.csign and gl_accvouch.ino_id = zz_cashtable.ino_id and gl_accvouch.inid = zz_cashtable.inid"
			+ " left join "+database+".dbo.ht_ccitem on zz_cashtable.citemcode = ht_ccitem.citemcode where  Code.bCashItem=1 And GL_accvouch.iperiod>=1 and ";
			cursor+=SystemUtil.getSelectSql("Gl_Accvouch",request)+") a )"
			+ " select top "+pageSize+" * from q where q.rn not in (select top "+(page-1)*Integer.valueOf(pageSize)+" ROW_NUMBER() over (partition by isnull(1,1) order by "+orderby2+" ) rn from q ) and rank = 1";
		page=(page-1)*Integer.valueOf(pageSize);
		String startTime=request.getSession().getAttribute("startTime").toString();
		int year=Integer.valueOf(startTime.substring(0,4));
		//查询起始日期
		String accouncover = accountService.findbycName(database+".dbo.accinformation","dGLStartDate");
		Integer startperiod=null;
		if (year>=Integer.valueOf(accouncover.substring(0,4))) {
			startperiod=1;//起始期间
		}else {
			startperiod=Integer.valueOf(accouncover.substring(5,7));//起始期间
		}
		List<Map<Object, Object>> listmap=gl_accassService.findBySql(cursor);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < listmap.size(); i++) {
			Map<Object, Object> map = listmap.get(i);
			if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
				String str=String.valueOf(map.get("csign"))+"-0000";
				String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
				map.put("ino_id2", ino_id);
			}
			BigDecimal md=new BigDecimal(map.get("md")+"");//value6
			BigDecimal mc=new BigDecimal(map.get("mc")+"");//value7
			BigDecimal me=new BigDecimal(map.get("me")+"");//value11
			Date parse=null;
			try {
				parse = sdf.parse(map.get("dbill_date").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			map.put("dbill_date", sdf.format(parse));
			if (me.compareTo(new BigDecimal("0"))==0) {
				map.put("me", "未录入");
			}else if (md.subtract(mc).subtract(me).compareTo(new BigDecimal("0"))==0) {
				map.put("me", "完成");
			}else {
				map.put("me", "录入不正确");
			}
				
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		String countsql=""
				+ "select COUNT(*) from "+database+".dbo.gL_accvouch Left Join "+database+".dbo.Code on Gl_Accvouch.cCode = Code.cCode "
				+ "left join "+database+".dbo.zz_cashtable on gl_accvouch.iperiod = zz_cashtable.iperiod and gl_accvouch.csign = zz_cashtable.csign "
				+ "and gl_accvouch.ino_id = zz_cashtable.ino_id and gl_accvouch.inid = zz_cashtable.inid left join "+database+".dbo.ht_ccitem on "
				+ "zz_cashtable.citemcode = ht_ccitem.citemcode Where Code.bCashItem=1 And GL_accvouch.iperiod>= '"+startperiod+"'";
		Integer total=glAccvouchService.Count(countsql);//总行数
		map.put("total", total);
		if ((total/Integer.valueOf(pageSize))==0) {
			total=(total/Integer.valueOf(pageSize));
		}else {
			total=(total/Integer.valueOf(pageSize))+1;
		}
		map.put("pages", total);
		map.put("rows", listmap);
		return map;
	}
	
	//综合辅助账
	@SuppressWarnings("deprecation")
	@RequestMapping(params = "getauxiliaryacc")
	@ResponseBody
	public Map<Object, Object> getauxiliaryacc(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="500";
		}
		
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String maintype=jsonmap.get("maintype").toString();
		String [] sectypes=jsonmap.get("sectype").toString().split(",");
		String CodeStart = null,CodeEnd= null,DepStart= null,DepEnd= null,PerStart= null,PerEnd= null,CusStart= null,CusEnd= null,VenStart= null,VenEnd= null,ItmStart= null,ItmEnd= null,IsBook = "";
		
		boolean Code = false,Dep=false,Per=false,Cus=false,Ven=false,Itm=false;
		String L2="";
		boolean issecCode=false,issecDep=false,issecPer=false,issecCus=false,issecVen=false,issecItm=false;
		String codelimit="";
		for (String sectype : sectypes) {
			if (sectype.equals("secCode")) {
				Code=true;
				issecCode=true;
				CodeStart = jsonmap.get("secsubjectid1")+"";
				CodeEnd = jsonmap.get("secsubjectid2")+"";
			}else if (sectype.equals("secDep")) {
				Dep=true;
				issecDep=true;
				DepStart=jsonmap.get("secdeptid1")+"";
				DepEnd=jsonmap.get("secdeptid2")+"";
				codelimit+=" bdept = 1";
			}else if (sectype.equals("secPer")) {
				Per=true;
				issecPer=true;
				PerStart=jsonmap.get("secpersonid1")+"";
				PerEnd=jsonmap.get("secpersonid2")+"";
				codelimit+=" bperson = 1";
			}else if (sectype.equals("secCus")) {
				Cus=true;
				issecCus=true;
				CusStart=jsonmap.get("seccustomerid1")+"";
				CusEnd=jsonmap.get("seccustomerid2")+"";
				codelimit+=" bcus = 1";
			}else if (sectype.equals("secVen")) {
				Ven=true;
				issecVen=true;
				VenStart=jsonmap.get("secsupplierid1")+"";
				VenEnd=jsonmap.get("secsupplierid2")+"";
				codelimit+=" bsup = 1";
			}else if (sectype.equals("secItm")) {
				Itm=true;
				issecItm=true;
				ItmStart=jsonmap.get("secprojectid1")+"";
				ItmEnd=jsonmap.get("secprojectid2")+"";
				codelimit+=" bitem = 1";
			}
		}
		if (maintype.equals("Code")) {
			Code=true;
			CodeStart = jsonmap.get("mainparmter1")+"";
			CodeEnd = jsonmap.get("mainparmter2")+"";
		}else if (!maintype.equals("Code")&&issecCode==false) {
			Code=false;
			CodeStart = "";
			CodeEnd = "";
		}
		if (maintype.equals("Dep")) {
			Dep=true;
			DepStart=jsonmap.get("mainparmter1")+"";
			DepEnd=jsonmap.get("mainparmter2")+"";
		}else if (!maintype.equals("Dep")&&issecDep==false) {
			Dep=false;
			DepStart="";
			DepEnd="";
		}
		if (maintype.equals("Per")) {
			Per=true;
			PerStart=jsonmap.get("mainparmter1")+"";
			PerEnd=jsonmap.get("mainparmter2")+"";
		}else if (!maintype.equals("Per")&&issecPer==false) {
			Per=false;
			PerStart="";
			PerEnd="";
		}
		if (maintype.equals("Cus")) {
			Cus=true;
			CusStart=jsonmap.get("mainparmter1")+"";
			CusEnd=jsonmap.get("mainparmter2")+"";
		}else if (!maintype.equals("Cus")&&issecCus==false) {
			Cus=false;
			CusStart="";
			CusEnd="";
		}
 		if (maintype.equals("Ven")) {
			Ven=true;
			VenStart=jsonmap.get("mainparmter1")+"";
			VenEnd=jsonmap.get("mainparmter2")+"";
		}else if (!maintype.equals("Ven")&&issecVen==false) {
			Ven=false;
			VenStart="";
			VenEnd="";
		}
 		if (maintype.equals("Itm")) {
			Itm=true;
			ItmStart=jsonmap.get("mainparmter1")+"";
			ItmEnd=jsonmap.get("mainparmter2")+"";
		}else if (!maintype.equals("Itm")&&issecItm==false) {
			Itm=false;
			ItmStart="";
			ItmEnd="";
		}
		String DateB=jsonmap.get("month1").toString().substring(5),
		DateE=jsonmap.get("month2").toString().substring(5),
		YearBegin=jsonmap.get("month1").toString().substring(0,4),
		yearEnd=jsonmap.get("month2").toString().substring(0,4);
		String dbname=database;
		
		if ((boolean) jsonmap.get("isbilling")) {
			IsBook="1";
		}else {
			IsBook="0";
		}
		
		if (maintype.equals("Code")&&(String.valueOf(jsonmap.get("mainparmter1")).equals(jsonmap.get("mainparmter2")))) {
			codelimit="";
		}
		
		List<Map<Object, Object>> dynamic_cbox=null;
		String sql="";
		//where条件:S
		String S="";
		if (Code) {
			if (codelimit!=null&&codelimit.trim().length()>0) {
				S+=" And ccode In ( select ccode from "+database+".dbo.code where isnull(bend,0)=1 and "+codelimit+"  and ((ccode >= '"+CodeStart+"' and ccode <= '"+CodeEnd+"' + 'z' ) Or ccode Like '"+CodeStart+"%' Or ccode Like '"+CodeEnd+"%'))";
			}else {
				S+=" And ccode In ( select ccode from "+database+".dbo.code where isnull(bend,0)=1 and ((ccode >= '"+CodeStart+"' and ccode <= '"+CodeEnd+"' + 'z' ) Or ccode Like '"+CodeStart+"%' Or ccode Like '"+CodeEnd+"%'))";
			}
		}
		if (Dep) {
			S+=" And cdept_id In ( select cdepcode from "+database+".dbo.department where isnull(bdepend,0)=1 and ((cdepcode >= '"+DepStart+"' and cdepcode <= '"+DepEnd+"' + 'z') Or cDepCode Like '"+DepStart+"%' Or cDepCode Like '"+DepEnd+"%')) And cCode In (Select cCode From "+database+".dbo.Code Where bdept=1) ";
		}
		if (Per) {
			S+=" And cperson_id In ( select cpersoncode from "+database+".dbo.person where  (cpersoncode >= '"+PerStart+"' and cpersoncode <= '"+PerEnd+"' + 'z' ) ) And cCode In (Select cCode From "+database+".dbo.Code Where bperson=1) ";
		}
		if (Cus) {
			S+=" And ccus_id In ( select ccuscode from "+database+".dbo.customer where  (ccuscode >= '"+CusStart+"' and ccuscode <= '"+CusEnd+"' + 'z' )) And cCode In (Select cCode From "+database+".dbo.Code Where bcus=1) ";
		}
		if (Ven) {
			S+=" And csup_id In ( select cvencode from "+database+".dbo.vendor where  (cvencode >= '"+VenStart+"' and cvencode <= '"+VenEnd+"' + 'z' )) And cCode In (Select cCode From "+database+".dbo.Code Where bsup=1) ";
		}
		if (Itm) {
			S+=" And citem_id In ( select citemcode from "+database+".dbo.ht_glitem where  (citemcode >= '"+ItmStart+"' and citemcode <= '"+ItmEnd+"' + 'z' )) And cCode In (Select cCode From "+database+".dbo.Code Where bitem=1) ";
		}
		String L="";
		if (maintype.equals("Code")) {
			L = "cCode,";
			if (jsonmap.get("dynamic_cbox")!=null&&jsonmap.get("dynamic_cbox").toString().trim().length()>0&&!jsonmap.get("dynamic_cbox").toString().equals("0")) {
				S+=" And ccode='"+jsonmap.get("dynamic_cbox")+"'";
			}
			if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("combobox")){
				CodeStart="";CodeEnd="";
			}
			if (codelimit!=null&&codelimit.trim().length()>0) {
				sql="select ccode as id, ccode_name as text from "+database+".dbo.code where isnull(bend,0)=1 and "+codelimit+" and (ccode >= '"+CodeStart+"' and ccode <= '"+CodeEnd+"' + 'z' ) order by ccode";
			}else {
				sql="select ccode as id, ccode_name as text from "+database+".dbo.code where isnull(bend,0)=1 and (ccode >= '"+CodeStart+"' and ccode <= '"+CodeEnd+"' + 'z' ) order by ccode";
			}
			dynamic_cbox=gl_accassService.findBySql(sql);
		}else if (maintype.equals("Dep")) {
			L = "cdept_id,";
			if (jsonmap.get("dynamic_cbox")!=null&&jsonmap.get("dynamic_cbox").toString().trim().length()>0&&!jsonmap.get("dynamic_cbox").toString().equals("0")) {
				S+=" And cdept_id='"+jsonmap.get("dynamic_cbox")+"' ";
			}
			if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("combobox")){
				DepStart="";DepEnd="";
			}
			sql="select cdepcode as id, cdepname as text from "+database+".dbo.department where isnull(bdepend,0)=1  and (cdepcode >= '"+DepStart+"' and cdepcode <= '"+DepEnd+"' + 'z' )  order by cdepcode";
			dynamic_cbox=gl_accassService.findBySql(sql);
		}else if (maintype.equals("Per")) {
			L = "cperson_id,";
			if (jsonmap.get("dynamic_cbox")!=null&&jsonmap.get("dynamic_cbox").toString().trim().length()>0&&!jsonmap.get("dynamic_cbox").toString().equals("0")) {
				S+=" And cperson_id='"+jsonmap.get("dynamic_cbox")+"' ";
			}
			if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("combobox")){
				PerStart="";PerEnd="";
			}
			sql="select cpersoncode as id, cpersonname as text from "+database+".dbo.person where  (cpersoncode >= '"+PerStart+"' and cpersoncode <= '"+PerEnd+"' + 'z' )  order by cpersoncode";
			dynamic_cbox=gl_accassService.findBySql(sql);
		}else if (maintype.equals("Cus")) {
			L = "ccus_id,";
			if (jsonmap.get("dynamic_cbox")!=null&&jsonmap.get("dynamic_cbox").toString().trim().length()>0&&!jsonmap.get("dynamic_cbox").toString().equals("0")) {
				S+=" And ccus_id='"+jsonmap.get("dynamic_cbox")+"' ";
			}
			if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("combobox")){
				CusStart="";CusEnd="";
			}
			sql="select ccuscode as id, ccusname as text from "+database+".dbo.customer where  (ccuscode >= '"+CusStart+"' and ccuscode <= '"+CusEnd+"' + 'z' )  order by ccuscode";
			dynamic_cbox=gl_accassService.findBySql(sql);
		}else if (maintype.equals("Ven")) {
			L = "csup_id,";
			if (jsonmap.get("dynamic_cbox")!=null&&jsonmap.get("dynamic_cbox").toString().trim().length()>0&&!jsonmap.get("dynamic_cbox").toString().equals("0")) {
				S+=" And csup_id='"+jsonmap.get("dynamic_cbox")+"' ";
			}
			if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("combobox")){
				VenStart="";VenEnd="";
			}
			sql="select cvencode as id, cvenname as text from "+database+".dbo.vendor where  (cvencode >= '"+VenStart+"' and cvencode <= '"+VenEnd+"' + 'z' )  order by cvencode";
			dynamic_cbox=gl_accassService.findBySql(sql);
		}else if (maintype.equals("Itm")) {
			L = "citem_id,";
			if (jsonmap.get("dynamic_cbox")!=null&&jsonmap.get("dynamic_cbox").toString().trim().length()>0&&!jsonmap.get("dynamic_cbox").toString().equals("0")) {
				S+=" And citem_id='"+jsonmap.get("dynamic_cbox")+"' ";
			}
			if(jsonmap.get("flag")!=null&&jsonmap.get("flag").toString().equals("combobox")){
				ItmStart="";ItmEnd="";
			}
			sql="select citemcode as id, citemname as text from "+database+".dbo.ht_glitem where  (citemcode >= '"+ItmStart+"' and citemcode <= '"+ItmEnd+"' + 'z' )  order by citemcode";
			dynamic_cbox=gl_accassService.findBySql(sql);
		}
		L2="A."+L;
		if (IsBook.equals("0")) {
			S+= " and iBook=1 ";
		}
		S+=" and isnull(iflag,0) = 0 ";
		if (codelimit!=null&&codelimit.trim().length()>0) {
			S+=" And cCode In (select cCode From "+database+".dbo.Code Where " + codelimit + ")";
		}
		String U="";//查询的列
		if (Code) {
			U+="cCode,";
		}else {
			U+="null as cCode,";
		}
		if (Dep) {
			U+="cdept_id,";
		}else {
			U+="null as cdept_id,";
		}
		if (Per) {
			U+="cperson_id,";
		}else {
			U+="null as cperson_id,";
		}
		if (Cus) {
			U+="ccus_id,";
		}else {
			U+="null as ccus_id,";
		}
		if (Ven) {
			U+="csup_id,";
		}else {
			U+="null as csup_id,";
		}
		if (Itm) {
			U+="citem_id,";
		}else {
			U+="null as citem_id,";
		}
		if (U.length()>0) {
			U=U.substring(0,U.length()-1);
		}
//		
		if (Code&&!maintype.equals("Code")) {
			L+="cCode,";
		}
		if (Dep&&!maintype.equals("Dep")) {
			L+="cdept_id,";
		}
		if (Per&&!maintype.equals("Per")) {
			L+="cperson_id,";
		}
		if (Cus&&!maintype.equals("Cus")) {
			L+="ccus_id,";
		}
		if (Ven&&!maintype.equals("Ven")) {
			L+="csup_id,";
		}
		if (Itm&&!maintype.equals("Itm")) {
			L+="citem_id,";
		}
		if (L.length()>0) {
			L=L.substring(0,L.length()-1);
		}
		
		String t1="";//期初查询语句T1
		String t2="";//发生查询语句T2
		if (Integer.valueOf(YearBegin)!=Integer.valueOf(database.substring(database.length()-4,database.length()))) {
				dbname = database.substring(0,database.length()-4)+YearBegin+".dbo.";
			t1= "Select null As dbill_date ,null As csign ,null As ino_id,-1 As inid ,'期初余额' As cdigest," + U + ",Sum(nd_s-nc_s) As N,Sum(md_f-mc_f) As F,Sum(md-mc) As M,1 As T, 1 as ibook , 0 as d_c " + 
			"From " + dbname + "GL_Accvouch GL_accvouch Where iperiod < " + DateB + " " + S + " " + "Group By " + L;
			
			for (int i = Integer.valueOf(YearBegin); i <= Integer.valueOf(yearEnd); i++) {
				String dbname2=database.substring(0,database.length()-4)+i+".dbo.";
				Integer mBegin = null;
				Integer mEnd  = null;
				if (i==Integer.valueOf(YearBegin)) {
					mBegin=Integer.valueOf(DateB);
				}else {
					mBegin=1;
				}
				if (i==Integer.valueOf(yearEnd)) {
					mEnd=Integer.valueOf(DateE);
				}else {
					mEnd=12;
				}
				t2+="Select dbill_date,csign,ino_id,inid,cdigest," + U + ",(nd_s-nc_s) As N,(md_f-mc_f) As F,(md-mc) As M,2 As T, ibook,"
						+ " (Case when md <> 0 Then 1 Else 0 End) From " + dbname2 + "GL_accvouch GL_accvouch Where iperiod>='" + mBegin 
						+ "' And iperiod<='" + mEnd + "' "+ S;
				if (i!=Integer.valueOf(yearEnd)) {
					t2+=" Union All ";
				}
			}
		}else {
			t1 = "Select null As dbill_date ,null As csign ,null As ino_id,-1 As inid ,'期初余额' As cdigest," +
					U + ",Sum(nd_s-nc_s) As N,Sum(md_f-mc_f) As F,Sum(md-mc) As M,1 As T, 1 as ibook , 0 as d_c " +
					"From "+database+".dbo.GL_accvouch Where iperiod<'" + DateB + "' " + S + " " +
					"Group By " + L;
		    t2 = "Select dbill_date,csign,ino_id,inid,cdigest," +
					U + ",(nd_s-nc_s) As N,(md_f-mc_f) As F,(md-mc) As M,2 As T, ibook, (Case when md <> 0 Then 1 Else 0 End) " +
		    		database+".dbo.From GL_accvouch Where iperiod>='" + DateB + "' And iperiod<='" + DateE + "' " + S;
		}
		L=L2;
		if (Code&&!maintype.equals("Code")) {
			L+="A.cCode,";
		}
		if (Dep&&!maintype.equals("Dep")) {
			L+="A.cdept_id,";
		}
		if (Per&&!maintype.equals("Per")) {
			L+="A.cperson_id,";
		}
		if (Cus&&!maintype.equals("Cus")) {
			L+="A.ccus_id,";
		}
		if (Ven&&!maintype.equals("Ven")) {
			L+="A.csup_id,";
		}
		if (Itm&&!maintype.equals("Itm")) {
			L+="A.citem_id,";
		}
		if (L.length()>0) {
			L=L.substring(0,L.length()-1);
		}
		String copyL="";//因为分页，后面的别名要变一下
		copyL=L;
		copyL=copyL.replace("A.", "q.");
		
		String T = " Select ROW_NUMBER() over (partition by isnull(1,1) Order By " + L + ",dbill_date,A.T,dsign.isignseq,A.ino_id,A.inid ) rn , dbill_date as dbill_date, A.csign as csign,ino_id as ino_id, cdigest as cdigest, IsNull(A.cCode,'') as cCode, IsNull(Code.ccode_name,'') as ccode_name, IsNull(A.cdept_id,'') as cdept_id, IsNull(Department.cDepName,'') as cDepName, "
				+ "IsNull(A.cperson_id,'') as cperson_id , IsNull(Person.cPersonName,'') as cPersonName , IsNull(A.ccus_id,'') as ccus_id, IsNull(Customer.cCusName,'') as cCusName, IsNull(A.csup_id,'') as csup_id, IsNull(Vendor.cVenName,"
				+ "'') as cVenName, IsNull(A.citem_id,'') as citem_id, IsNull(HT_GLItem.citemname,'') as citemname , IsNull(F,0) as f , IsNull(N,0) as n, IsNull(M,0) as m, T, ibook, d_c From (" + t1+" Union All " 
				+ t2 + ") As A Left Join "+database+".dbo.dsign On A.csign=dsign.csign Left Join "+database+".dbo.Code On A.cCode=Code.cCode Left Join "+database+".dbo.Department On A.cdept_id=Department.cDepCode "
				+ "Left Join "+database+".dbo.Person On A.cperson_id=Person.cPersonCode Left Join "+database+".dbo.Customer On A.ccus_id=Customer.cCusCode Left Join "+database+".dbo.Vendor On A.csup_id=Vendor.cVenCode "
				+ "Left Join "+database+".dbo.HT_GLItem On A.citem_id=HT_GLItem.citemcode";
//		        " select top "+pageSize+"* from q where q.rn not in (select top "+(Integer.valueOf(pageNumber)-1)*Integer.valueOf(pageSize)+" ROW_NUMBER() over (partition by isnull(1,1) Order By " + copyL + ",dbill_date,q.T,q.ino_id) rn from q)";
		List<Map<Object, Object>> resultmaps = gl_accassService.findBySql(T);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BigDecimal FD = new BigDecimal("0.00");
		BigDecimal ND = new BigDecimal("0.00");
		BigDecimal MD = new BigDecimal("0.00");
		BigDecimal FC = new BigDecimal("0.00");
		BigDecimal NC = new BigDecimal("0.00");
		BigDecimal MC = new BigDecimal("0.00");
		BigDecimal mesum = new BigDecimal("0.00");//余额小计
		BigDecimal mdsum = new BigDecimal("0.00");//借方余额小计
		BigDecimal mcsum = new BigDecimal("0.00");//贷方余额小计
		BigDecimal mdtotal=new BigDecimal(0); //借方合计（最后一行）
		BigDecimal mctotal=new BigDecimal(0); //贷方合计（最后一行）
		BigDecimal metotal=new BigDecimal(0); //余额合计（最后一行）
		for (int i = 0; i < resultmaps.size();i++) {
		String project1="";
		String project2="";
		Map<Object, Object> map = resultmaps.get(i);
		Map<Object, Object> map2=null;
		if (i==0) {
			Map<Object, Object> temporarymap = new HashMap<Object, Object>();
			temporarymap.putAll(map);
			if (String.valueOf(temporarymap.get("T")).equals("1")) {
				temporarymap.put("data19", temporarymap.get("f"));
				temporarymap.put("data22", temporarymap.get("n"));
				temporarymap.put("cdigest", temporarymap.get("cdigest"));
				temporarymap.put("me", temporarymap.get("m"));
				try {
					if (new BigDecimal(map.get("me")+"").compareTo(new BigDecimal(0))==0) {
						temporarymap.put("me_direction", "平");
					}else if (new BigDecimal(map.get("me")+"").compareTo(new BigDecimal(0))==1) {
						temporarymap.put("me_direction", "借");
					}else {
						temporarymap.put("me_direction", "贷");
					}
				} catch (Exception e) {
					temporarymap.put("me_direction", "平");
				}
				
			}else if(String.valueOf(temporarymap.get("T")).equals("2")){
				temporarymap.put("me_direction", "平");
				temporarymap.put("cdigest", "期初余额");
				temporarymap.put("me", "");
			}
			resultmaps.add(i,temporarymap);
			L="C"+ map.get("cCode")+"D"+map.get("cdept_id")+"P"+map.get("ccus_id")+"U"+map.get("ccus_id")+"V"+map.get("csup_id")+"I"+map.get("citem_id");
			continue;
		}else {
			if (i<resultmaps.size()-1) {
				map = resultmaps.get(i);
				map2 = resultmaps.get(i+1);
				project1="C"+ map.get("cCode")+"D"+map.get("cdept_id")+"P"+map.get("ccus_id")+"U"+map.get("ccus_id")+"V"+map.get("csup_id")+"I"+map.get("citem_id");
				project2="C"+ map2.get("cCode")+"D"+map2.get("cdept_id")+"P"+map2.get("ccus_id")+"U"+map2.get("ccus_id")+"V"+map2.get("csup_id")+"I"+map2.get("citem_id");
			}
		}
		Map<Object, Object> temporarymap = new HashMap<Object, Object>();
		temporarymap.putAll(map);//因为是给:'project1'添加小计行，所以是map 
		if (!map.get("T").toString().equals("1")) {
			Date date = null;
			try {
				if (map.get("dbill_date")!=null) {
					date = sdf.parse(map.get("dbill_date")+"");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (map.get("dbill_date")!=null) {
				map.put("month", date.getMonth()+1);
				map.put("day", date.getDate());
			}
			if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
				String str=String.valueOf(map.get("csign"))+"-0000";
				String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
				map.put("ino_id2", ino_id);
			}
			if (map.get("d_c")!=null&&map.get("d_c").toString().equals("1")) {//借方
				map.put("data17", map.get("f"));
				map.put("data18", map.get("n"));
				map.put("data19", map.get("m"));
				map.put("data20", "");
				map.put("data21", "");
				map.put("data22", "");
				FD=FD.add(new BigDecimal(map.get("f")+""));
				ND=ND.add(new BigDecimal(map.get("n")+""));
				MD=MD.add(new BigDecimal(map.get("m")+""));
				mdsum=mdsum.add(new BigDecimal(map.get("m")+""));
			}else {//贷方
				map.put("data17", "");
				map.put("data18", "");
				map.put("data19", "");
				map.put("data20", map.get("f"));
				map.put("data21", map.get("n"));
				map.put("data22", map.get("m"));
				if (map.get("f")!=null) {
					FC = FC.add(new BigDecimal(map.get("f")+""));
				}
				if (map.get("n")!=null) {
					NC = NC.add(new BigDecimal(map.get("n")+""));
				}
				if (map.get("m")!=null) {
					MC = MC.add(new BigDecimal(map.get("m")+""));
				}
				mcsum=mcsum.add(new BigDecimal(map.get("m")+""));
			}
		}
			if (!map.get("T").toString().equals("1")) {
				map.put("cdigest", "*"+map.get("cdigest"));
			}
		if (project1.equals(project2)) {//是否与下一条科目数据一致
			mesum=mesum.add(new BigDecimal(map.get("f")+"")).subtract(new BigDecimal(map.get("n")+"")).add(new BigDecimal(map.get("m")+""));
			map.put("me", mesum);
		}else {
			mesum=mesum.add(new BigDecimal(map.get("f")+"")).subtract(new BigDecimal(map.get("n")+"")).add(new BigDecimal(map.get("m")+""));
			map.put("me", mesum);
			temporarymap.put("cdigest", "小&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
			temporarymap.put("me", mesum);
			temporarymap.put("data19", mdsum);
			temporarymap.put("data22", mcsum);
			mdtotal=mdtotal.add(mdsum);
			mctotal=mctotal.add(mcsum);
			metotal=metotal.add(mesum);
			mdsum=new BigDecimal(0);
			mcsum=new BigDecimal(0);
			if (mesum.compareTo(new BigDecimal(0))==0) {
				temporarymap.put("me_direction", "平");
			}else if (mesum.compareTo(new BigDecimal(0))==1) {
				temporarymap.put("me_direction", "借");
			}else {
				temporarymap.put("me_direction", "贷");
			}
			mesum=new BigDecimal(0);
			resultmaps.add(i+1,temporarymap);
			temporarymap = new HashMap<Object, Object>();
			boolean isadd=false;//如果true添加
			if (!map2.get("T").toString().equals("1")) {
				isadd=true;
				temporarymap.putAll(map2);//因为是给:'project2'添加 期初余额 行，所以是map2
				if (String.valueOf(temporarymap.get("T")).equals("1")) {
					temporarymap.put("data19", temporarymap.get("f"));
					temporarymap.put("data22", temporarymap.get("n"));
					temporarymap.put("me", temporarymap.get("m"));
					if(map2.get("me")!=null){
						if (new BigDecimal(map2.get("me")+"").compareTo(new BigDecimal(0))==0) {
							temporarymap.put("me_direction", "平");
						}else if (new BigDecimal(map2.get("me")+"").compareTo(new BigDecimal(0))==1) {
							temporarymap.put("me_direction", "借");
						}else {
							temporarymap.put("me_direction", "贷");
						}
					}else {
						temporarymap.put("me_direction", "平");
					}
				}else if(String.valueOf(temporarymap.get("T")).equals("2")){
					temporarymap.put("me_direction", "平");
					temporarymap.put("cdigest", "期初余额");
					temporarymap.put("me", "");
				}
				resultmaps.add(i+2,temporarymap);
			}
			if(isadd){
				i+=2;
			}else {
				i+=1;
			}
		}
		
		if (new BigDecimal(map.get("me")+"").compareTo(new BigDecimal(0))==0) {
			map.put("me_direction", "平");
		}else if (new BigDecimal(map.get("me")+"").compareTo(new BigDecimal(0))==1) {
			map.put("me_direction", "借");
		}else {
			map.put("me_direction", "贷");
		}
		}
		
		if(resultmaps!=null&&resultmaps.size()>0){
			Map<Object, Object> lastmap=new HashMap<Object, Object>();
			lastmap.putAll(resultmaps.get(resultmaps.size()-1));
			lastmap.put("cdigest", "小&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
			resultmaps.add(lastmap);
			lastmap=new HashMap<Object, Object>();
			lastmap.put("cdigest", "合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
			Map<Object, Object> map2 = resultmaps.get(resultmaps.size()-1);
			if (map2.get("data19")!=null) {
				Object data19 = map2.get("data19")==null? map2.get("data19"):"0";
				lastmap.put("data19", mdtotal.add(new BigDecimal(data19+"")));
			}else {
				lastmap.put("data19", mdtotal);
			}
			if (map2.get("data22")!=null&&!"".equals(map2.get("data22"))) {
				Object data22 = map2.get("data22")==null?map2.get("data22"):"0";
				lastmap.put("data22", mctotal.add(new BigDecimal(data22+"")));
			}else {
				lastmap.put("data22", mctotal);
			}
			if (map2.get("me")!=null) {
				Object me = map2.get("me")==null? map2.get("me"):"0";
				lastmap.put("me", metotal.add(new BigDecimal(me+"")));
			}else {
				lastmap.put("me", metotal);
			}
			if (metotal.compareTo(new BigDecimal(0))==0) {
				lastmap.put("me_direction", "平");
			}else if (metotal.compareTo(new BigDecimal(0))==1) {
				lastmap.put("me_direction", "借");
			}else {
				lastmap.put("me_direction", "贷");
			}
			resultmaps.add(lastmap);
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("id", "0");
		map.put("text", "全部");
		dynamic_cbox.add(0,map);
		map = new HashMap<Object, Object>();
		map.put("dynamic_cbox", dynamic_cbox);
		if(resultmaps.size()>0){
			if (resultmaps.get(2).get("dbill_date")!=null) {
				Date date = null;
				try {
					date = sdf.parse(resultmaps.get(1).get("dbill_date")+"");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				map.put("year", date.getYear()+1900);
				map.put("month", date.getMonth()+1);
			}else {
				map.put("year","");
			}
		}
		map.put("rows", resultmaps);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params= "cashflowsave")
	@ResponseBody
	public Map<Object, Object> cashflowsave(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String account=request.getParameter("account");
		String cashflow=request.getParameter("cashflow");
		String userName=request.getSession().getAttribute("User").toString();
		Map<Object, Object> account0=(Map<Object, Object>) JSON.parse(account);
		List<Map<Object, Object>> cashflows=(List<Map<Object, Object>>) JSON.parse(cashflow);
		try {
			glAccvouchservice.deleteoldcash(account0.get("iPeriod"),account0.get("csign"),account0.get("ino_id"),account0.get("inid"),database);//删除
			ZZ_CashTable zz_CashTable = new ZZ_CashTable();
			for (int i = 0; i < cashflows.size()-2; i++) {
				Map<Object, Object> cashflowi = cashflows.get(i);
				zz_CashTable.setIperiod(Byte.parseByte(account0.get("iPeriod").toString()));
				zz_CashTable.setCsign(account0.get("csign").toString());
				zz_CashTable.setIno_id(Short.parseShort(account0.get("ino_id").toString()));
				zz_CashTable.setInid(Byte.parseByte(account0.get("inid").toString()));
				int a = Integer.valueOf(account0.get("inid").toString());
				zz_CashTable.setInid2((byte)a);
				zz_CashTable.setCitemcode(cashflowi.get("citemcode").toString());
				if (cashflowi.get("md")!=null&&cashflowi.get("md").toString().trim().length()>0) {
					zz_CashTable.setMd(new BigDecimal(cashflowi.get("md").toString()).add(new BigDecimal("0.00")));
				}else {
					zz_CashTable.setMd(new BigDecimal("0.00"));
				}
				if (cashflowi.get("mc")!=null&&cashflowi.get("mc").toString().trim().length()>0) {
					zz_CashTable.setMc(new BigDecimal(cashflowi.get("mc").toString()));
				}else {
					zz_CashTable.setMc(new BigDecimal("0.00"));
				}
				zz_CashTableservice.add(database+".dbo.ZZ_CashTable ",zz_CashTable);
			}
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("现金流量");
			uffj_AccLog.setAction("修改");
			uffj_AccLog.setCode(account0.get("csign").toString()+account0.get("iPeriod").toString()+account0.get("ino_id").toString());
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		return map;
	}
	
	@RequestMapping(params= "regularvoucher")
	@ResponseBody
	public Map<Object, Object> getregularvoucher(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		
		String pageNumber=request.getParameter("page");
		if (pageNumber==null||pageNumber.equals("")) {
			pageNumber="1";
		}
		String pageSize=request.getParameter("rows");
		if (pageSize==null||pageSize.equals("")) {
			pageSize="50";
		}
		int a = Integer.valueOf(pageNumber)-1;
		int b = Integer.valueOf(pageSize);
		
		String sql="with q as (select ROW_NUMBER() over (partition by isnull(1,1) order by gl_bfreq.c_id ) rn , gl_bfreq.c_id as c_id, max(gl_bfreq.ctext) as gtext, max(gl_bfreq.csign) as csign, max(gl_bfreq.idoc) as idoc, Max(dsign.ctext) as dtext From "+database+".dbo.gl_bfreq Left Join "+database+".dbo.dsign On gl_bfreq.csign = dsign.csign group by c_id ) "
		+ "select top "+b+" * from  q where q.rn not in (select top "+a+" ROW_NUMBER() over (partition by isnull(1,1) order by c_id) from q ) Order by c_id";
		List<Map<Object, Object>> regularvouchers = gl_accassService.findBySql(sql);
		for (int i = 0; i < regularvouchers.size(); i++) {
			Map<Object, Object> map = regularvouchers.get(i);
			map.put("csign2", map.get("csign"));
			map.put("csign", map.get("csign")+"&nbsp;&nbsp;&nbsp;&nbsp;"+map.get("dtext"));
		}
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("rows", regularvouchers);
		map.put("total", regularvouchers.size());
		return map;
	}
	@RequestMapping(params= "voucherdetailed")
	@ResponseBody
	public Map<Object, Object> getvoucherdetailed(HttpServletRequest request,String c_id){
		String database=request.getSession().getAttribute("database").toString();
		String sql="select cdigest, gl_bfreq.cCode,cCode_name,bdept,bperson,bcus,bsup,bitem, bbank, md, mc, csettle,(select cssname from "+database+".dbo.settlestyle where csscode = Gl_bfreq.csettle) as cssname,"
				+ "cdept_id,(select cdepname from "+database+".dbo.department where cdepcode = gl_bfreq.cdept_id) as cdepname,"
				+ "cperson_id,(select cpersonname from "+database+".dbo.person where cpersoncode = gl_bfreq.cperson_id) as cpersonname,"
				+ "ccus_id, (select ccusname from "+database+".dbo.customer where ccuscode = gl_bfreq.ccus_id) as ccusname,"
				+ "csup_id, (select cvenname from "+database+".dbo.vendor where cvencode = gl_bfreq.csup_id) as cvenname,"
				+ "citem_id , (select citemname from "+database+".dbo.HT_GLItem where citemcode = gl_bfreq.citem_id) as citemname"
				+ " from "+database+".dbo.gl_bfreq Left Join "+database+".dbo.Code On Gl_bfreq.ccode = code.ccode where c_id = '"+c_id+"' order by inid";
		List<Map<Object, Object>> regularvouchers = gl_accassService.findBySql(sql);
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("rows", regularvouchers);
		return map;
	}
	@RequestMapping(params= "isrepeat")
	@ResponseBody
	public Map<Object, Object> getisrepeat(HttpServletRequest request,String c_id){
		String database=request.getSession().getAttribute("database").toString();
		String sql="select count(*) as count from "+database+".dbo.Gl_bfreq where c_id = '"+c_id+"'";
		List<Map<Object, Object>> counts = gl_accassService.findBySql(sql);
		Map<Object, Object> map=new HashMap<Object, Object>();
		if (counts!=null&&counts.size()>0) {
			map.put("total", counts.get(0).get("count"));
		}else {
			map.put("total", 0);		
		}
		return map;
	}
	@RequestMapping(params= "edit_gl_bfreq")
	@ResponseBody
	public Map<Object, Object> edit_gl_bfreq(HttpServletRequest request,String c_id,String data,boolean isdelete,String csign,String explain,String sheetnum){
		String database=request.getSession().getAttribute("database").toString();
		String userName=request.getSession().getAttribute("User").toString();
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> listmap = (List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		try {
			if (isdelete) {
				gl_bfreqService.deleteByc_id(database,c_id);
			}
			if("SR".equals(csign.substring(0,2))){
				csign=csign.substring(0,2);
			}else {
				csign=csign.substring(0,1);
			}
			String batchinsert="";
			for (int i = 0; i < listmap.size(); i++) {
				Map<Object, Object> map = listmap.get(i);
				int inid=i+1;
				batchinsert+="('"+c_id+"','"+inid+"','"+csign+"','"+explain+"','"+sheetnum+"','"+map.get("cdigest")+"','"+map.get("cCode")+"','"+map.get("md")+"','"+map.get("mc")+"',";
				if (map.get("csettle")==null) {
					batchinsert+=null+",";
				}else {
					batchinsert+="'"+map.get("csettle")+"',";
				}
				if (map.get("cdept_id")==null) {
					batchinsert+=null+",";				
				}else {
					batchinsert+="'"+map.get("cdept_id")+"',";
				}
				if (map.get("cperson_id")==null) {
					batchinsert+=null+",";
				}else {
					batchinsert+="'"+map.get("cperson_id")+"',";
				}
				if (map.get("ccus_id")==null) {
					batchinsert+=null+",";
				}else {
					batchinsert+="'"+map.get("ccus_id")+"',";
				}
				if (map.get("csup_id")==null) {
					batchinsert+=null+",";
				}else {
					batchinsert+="'"+map.get("csup_id")+"',";
				}
				if (map.get("citem_id")==null) {
					batchinsert+=null+",";
				}else {
					batchinsert+="'"+map.get("citem_id")+"',";
				}
				if (map.get("citem_id")==null) {
					batchinsert+=null+"),";
				}else {
					batchinsert+="'77'),";
				}
			}
			batchinsert=batchinsert.substring(0,batchinsert.length()-1);
			gl_bfreqService.insert(database,batchinsert);
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("常用凭证");
			uffj_AccLog.setAction("删除");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
			resultmap.put("flag", "常用凭证["+c_id+"]保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("flag", "常用凭证[" + c_id + "]保存失败！可能是与服务器连接不正常");
		}
		return resultmap;
	}
	
	@RequestMapping(params= "delete_gl_bfreq")
	@ResponseBody
	public Map<Object, Object> delete_gl_bfreq(HttpServletRequest request,String c_id){
		String database=request.getSession().getAttribute("database").toString();
		String userName=request.getSession().getAttribute("User").toString();
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("flag", "常用凭证["+c_id+"]删除成功！");
		try {
			//删除现金流量
			gl_bfreqService.deletecashflow(database,c_id);
			gl_bfreqService.deletevoucher(database,c_id);
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("常用凭证");
			uffj_AccLog.setAction("删除");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("flag", "常用凭证["+c_id+"]删除失败！");
		}
		return resultmap;
	}
	
	
	@RequestMapping(params= "getGl_bfreq_c_id")
	@ResponseBody
	public Map<Object, Object> getGl_bfreq_c_id(HttpServletRequest request,String c_id){
		String database=request.getSession().getAttribute("database").toString();
		List<Map<Object, Object>> findBySql = gl_accassService.findBySql("select c_id From "+database+".dbo.Gl_bfreq group by c_id");
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("rows", findBySql);
		return resultmap;
	}
	
	@RequestMapping(params= "transmatic")
	@ResponseBody
	public Map<Object, Object> transmatic(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String sql = "Select ROW_NUMBER() over (partition by isnull(1,1) order by ZZ_Auto.cCode ) as rn,ZZ_Auto.cCode,Code.ccode_name as ccode_name1,ZZ_Auto.cCodeOut,B.ccode_name as ccode_name2,ZZ_Auto.cCodeIn,C.ccode_name as ccode_name3 "
				+ "From "+database+".dbo.ZZ_Auto Left Join "+database+".dbo.Code On ZZ_Auto.cCode=Code.ccode Left Join "+database+".dbo.Code As B On ZZ_Auto.cCodeOut=B.cCode "
				+ "Left Join "+database+".dbo.Code As C On ZZ_Auto.cCodeIn=C.cCode Where ZZ_Auto.iType=2 And Code.bend=1 And Code.bclose=0 "
				+ "Order By ZZ_Auto.cCode";
		List<Map<Object, Object>> transmatics=gl_accassService.findBySql(sql);
		for (int i = 0; i < transmatics.size(); i++) {
			Map<Object, Object> map = transmatics.get(i);
			if (map.get("cCode").toString().equals(map.get("cCodeOut")+"")) {
				map.put("cCodeOut", "");
				map.put("ccode_name2", "");
			}
		}
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("rows", transmatics);
		return map;
	}
	@RequestMapping(params= "createvoucher")
	@ResponseBody
	public Map<Object, Object> createvoucher(HttpServletRequest request){
		Map<Object, Object>map=new HashMap<Object, Object>();
		String database=request.getSession().getAttribute("database").toString();
		Integer thismonth=null;
		Integer lastmonth=null;
		String startTime=request.getSession().getAttribute("startTime").toString();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=sdf.parse(startTime);
			thismonth=date.getMonth()+1;
			lastmonth = date.getMonth();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GLmend thisgLmend = GLmendservice.findByIperiodthismonth(database+".dbo.gl_mend", thismonth);
		if(thisgLmend!=null){
			if (thisgLmend.getBflag()) {
				map.put("msg", "当前会计期间已经月末结账!");
				map.put("flag", 0);
				return map;
			}
		}
		GLmend lastgLmend = GLmendservice.findByIperiodlastmonth(database+".dbo.gl_mend", lastmonth);
		if(lastgLmend!=null){
			if (!lastgLmend.getBflag()) {
				map.put("msg", "上个会计期间还没有月末结账!");
				map.put("flag", 0);
				return map;
			}
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			map.put("msg","有互斥功能正在使用中!");
			map.put("flag", 0);
			return map;
		}
		String sql="Select * From "+database+".dbo.GL_accvouch Where ibook<>1 and (GL_accvouch.iperiod<1 or iperiod="+thismonth+") and isnull(iflag,0)<>1";
		List<Map<Object, Object>> list = gl_accassService.findBySql(sql);
		try {
			if (list.size()>0) {
				map.put("msg","还有部分凭证没有记账，是否继续？");
				map.put("flag", 1);
			}
		} catch (Exception e) {
			map.put("msg","没有可供转账的内容!");
			map.put("flag", 0);
			return map;
		}
		
		return map;
	}
	private static String colmuns1="";
	private static String batchaddsql1="";//Auxiliaryacc.equals("1")
	private static String colmuns2="";
	private static String batchaddsql2="";//Auxiliaryacc.equals("0")
	
	
	@RequestMapping(params= "createvoucher2")
	@ResponseBody
	public Map<Object, Object> createvoucher2(HttpServletRequest request,String csign){
		Map<Object, Object> resultmap =new HashMap<Object, Object>();
		String database=request.getSession().getAttribute("database").toString();
		String rows = request.getParameter("rows").toString();
		Integer thismonth=null;
		String startTime=request.getSession().getAttribute("startTime").toString();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse(startTime);
			thismonth=date.getMonth()+1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dsign dsign = dsignservice.selectBycsign(database+".dbo.dsign", csign);
		if (dsign==null) {
			resultmap.put("msg", "没有自动转账的定义!");
			resultmap.put("flag", "0");
			return resultmap;
		}
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        String last = sdf.format(calendar.getTime());
        
        String sign=csign;
        Byte iseqsign =dsign.getIsignseq();
        String vouchdate = last;
        String vouchiperiod = thismonth+"";
        String makebillperson=request.getSession().getAttribute("username").toString();
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> listmap = (List<Map<Object, Object>>) JSON.parse(rows);
		String sql="";
		BigDecimal incur = new BigDecimal("0");
		boolean iscreate=false;
		List<GlAccvouchVo> glAccvouchVos = new ArrayList<GlAccvouchVo>();
		GlAccvouchVo glAccvouchVo = new GlAccvouchVo();
		for (int i = 0; i < listmap.size(); i++) {
			Map<Object, Object> map=listmap.get(i);
			if (map.get("cCodeOut")==null||"".equals(map.get("cCodeOut").toString())) {
				map.put("cCodeOut", map.get("cCode"));
			}
			//然后读取损益类科目的方向=value(0)
			String bproperty = codeService.findbpropertyBycode(database,map.get("cCode").toString());
			// 读取结转科目否辅助核算=value(0)
			String Auxiliaryacc = codeService.isAuxiliaryacc(database,map.get("cCode").toString());
			if (Auxiliaryacc.equals("1")) {
				
				sql = "Select cendd_c,me From "+database+".dbo.GL_accsum Where ccode='"+map.get("cCode")+"' And iperiod="+thismonth;
				List<Map<Object, Object>> find = gl_accassService.findBySql(sql);
				
				if (find.size()>0&&(find.get(0).get("cendd_c").toString().equals("平")||Double.valueOf(find.get(0).get("me").toString())==0)) {
					continue;
				}else{
				sql="Select cdept_id,cperson_id,ccus_id,csup_id,citem_id,cendd_c,me From "+database+".dbo.GL_accass " + "Where me <> 0 and ccode='" + map.get("cCode") + "' And iperiod="+thismonth;
				List<Map<Object, Object>> list = gl_accassService.findBySql(sql);
				for (int k = 0; k < list.size(); k++) {
					String cdigest ="";
					String vouchercode="";
					String outcur="";
					String md="";
					String mc="";
					colmuns1="(csign,isignseq,dbill_date,iperiod,cbill,";
					batchaddsql1+="("+sign+","+iseqsign+","+vouchdate+","+vouchiperiod+","+makebillperson+",";
					if (list!=null&&list.get(k)!=null) {
						
							cdigest="期间损益["+listmap.get(i).get("listmap")+"]";
							colmuns1+="cdigest,";
							batchaddsql1+=cdigest+",";
							glAccvouchVo.setCdigest(cdigest);
						
						vouchercode=listmap.get(i).get("cCodeOut").toString();
						colmuns1+="ccode,";
						batchaddsql1+=vouchercode+",";
						glAccvouchVo.setCcode(vouchercode);
						outcur=list.get(k).get("me").toString();
						if (list.get(k).get("cendd_c").toString().equals("贷")) {
							outcur=Takeback(new BigDecimal(outcur)).toString();
						}
						if (bproperty.equals("1")) {
							md="0";
							mc=outcur;
						}else {
							md=new BigDecimal("-1").multiply(new BigDecimal(outcur)).toString();
							mc="0";
						}
						colmuns1+="cexch_name,cmeasure,md,mc,";
						batchaddsql1+=null+","+null+","+md+","+mc;
						glAccvouchVo.setMd(new BigDecimal(md));
						glAccvouchVo.setMc(new BigDecimal(mc));
						incur=incur.add(new BigDecimal(outcur));
						if (list.get(k).get("cdept_id")!=null) {
							colmuns1+="cdept_id,";
							batchaddsql1+=list.get(k).get("cdept_id").toString();
							glAccvouchVo.setCdept_id(list.get(k).get("cdept_id").toString());
						}
						if (list.get(k).get("cperson_id")!=null) {
							colmuns1+="cperson_id,";
							batchaddsql1+=list.get(k).get("cperson_id").toString();
							glAccvouchVo.setCperson_id(list.get(k).get("cperson_id").toString());
						}
						if (list.get(k).get("ccus_id")!=null) {
							colmuns1+="ccus_id,";
							batchaddsql1+=list.get(k).get("ccus_id").toString();
							glAccvouchVo.setCcus_id(list.get(k).get("ccus_id").toString());
						}
						if (list.get(k).get("csup_id")!=null) {
							colmuns1+="csup_id,";
							batchaddsql1+=list.get(k).get("csup_id").toString();
							glAccvouchVo.setCsup_id(list.get(k).get("csup_id").toString());
						}
						if (list.get(k).get("citem_id")!=null) {
							colmuns1+="citem_id,";
							batchaddsql1+=list.get(k).get("citem_id").toString();
							glAccvouchVo.setCitem_id(list.get(k).get("citem_id").toString());
						}
						colmuns1+="citem_class)";
						batchaddsql1+="77),";
						glAccvouchVo.setCitem_class("77");
						glAccvouchVos.add(glAccvouchVo);
						try {
							iscreate=true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				}
			}else {
				sql="Select cendd_c,me From "+database+".dbo.GL_accsum "
						+ "Where ccode='" + map.get("cCode") + "' And iperiod="+thismonth;
				List<Map<Object, Object>> list = gl_accassService.findBySql(sql);
				String mc="";
				String md="";
				String cdigest="";
				String ccode="";
				BigDecimal outcur = new BigDecimal("0");
				if (list!=null) {
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j).get("cendd_c").toString().equals("平")||list.get(j).get("me").toString().equals("0")) {
							continue;
						}
						cdigest="期间损益["+listmap.get(i).get("ccode_name1")+"]";
						ccode=listmap.get(i).get("cCodeOut").toString();
						if (list.get(j).get("cendd_c").toString().equals("贷")) {
							outcur = Takeback(new BigDecimal(list.get(j).get("me")+""));
						}
						if (bproperty.equals("1")) {
							md="0";
							mc=list.get(j).get("me").toString();
						}else {
							md=new BigDecimal("-1").multiply(new BigDecimal(list.get(j).get("me").toString())).toString();
							mc="0";
						}
						incur=incur.add(outcur);
						colmuns2="(csign,isignseq,dbill_date,iperiod,cbill,cdigest,md,mc,ccode)";
						batchaddsql2+="("+sign+","+iseqsign+","+vouchdate+","+vouchiperiod+","+makebillperson+","+cdigest+","+md+","+mc+","+ccode+"),";
						glAccvouchVo.setCsign(sign);
						glAccvouchVo.setIsignseq(iseqsign);
						glAccvouchVo.setDbill_date(vouchdate);
						glAccvouchVo.setIperiod(Byte.valueOf(vouchiperiod));
						glAccvouchVo.setCdigest(cdigest);
						glAccvouchVo.setMd(new BigDecimal(md));
						glAccvouchVo.setMc(new BigDecimal(mc));
						glAccvouchVo.setCcode(ccode);
						glAccvouchVos.add(glAccvouchVo);
						try {
							iscreate=true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		//本年利润
		if (!(incur.compareTo(new BigDecimal(0))==0)) {
			String cdigest = "期间损益自动结转";
			String ccode=listmap.get(0).get("cCodeIn").toString();
			String md="";
			String mc="";
			int a = incur.compareTo(new BigDecimal(0));//用于判断方向
			if (a==-1) {
				md = "0"; mc = new BigDecimal("-1").multiply(incur).toString();
			}else if (a==1) {
				md=incur.toString(); mc = "0";
			}
			String column="(cdigest,md,mc,ccode)";
			String values="("+cdigest+","+md+","+mc+","+ccode+")";
			String insertsql="insert into "+database+".dbo.GL_accvouch"+column+"values"+values;
			try {
				glAccvouchservice.insertBysql(insertsql);
				glAccvouchVo = new GlAccvouchVo();
				glAccvouchVo.setCsign(sign);
				glAccvouchVo.setIsignseq(iseqsign);
				glAccvouchVo.setDbill_date(vouchdate);
				glAccvouchVo.setIperiod(Byte.valueOf(vouchiperiod));
				glAccvouchVo.setCdigest(cdigest);
				glAccvouchVo.setMd(new BigDecimal(md));
				glAccvouchVo.setMc(new BigDecimal(mc));
				glAccvouchVo.setCcode(ccode);
				glAccvouchVos.add(glAccvouchVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (!iscreate) {
			resultmap.put("msg", "没有可供转账的数据，不能生成凭证!");
			resultmap.put("flag", "0");
			return resultmap;
		}else {
			resultmap.put("rows", glAccvouchVos);
			resultmap.put("flag", "1");
			return resultmap;
		}
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(params= "addRecording")
	@ResponseBody
	public Map<Object, Object> addRecording(HttpServletRequest request,String csign){
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		String database=request.getSession().getAttribute("database").toString();
		String userName=request.getSession().getAttribute("User").toString();
		if (batchaddsql1!=null&&batchaddsql1.trim().length()>0) {
			batchaddsql1 = batchaddsql1.substring(0,batchaddsql1.length()-1);
		}
		if (batchaddsql2!=null&&batchaddsql2.trim().length()>0) {
			batchaddsql2 = batchaddsql2.substring(0,batchaddsql2.length()-1);
		}
		try {
			String startTime=request.getSession().getAttribute("startTime").toString();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Integer month=null;
			try {
				Date date=sdf.parse(startTime);
				month=date.getMonth()+1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String sql="Select Max(ino_id) ino_id From GL_accvouch Where csign='" + csign + "' And iperiod='"+month+"'";
			List<Map<Object, Object>> list = gl_accassService.findBySql(sql);
			String ino_id = list.get(0).get("ino_id").toString();
			colmuns1=colmuns1.substring(0,colmuns1.length()-1)+",ino_id)";
			colmuns2=colmuns2.substring(0,colmuns2.length()-1)+",ino_id)";
			batchaddsql1=batchaddsql1.substring(0,batchaddsql1.length()-1)+","+ino_id+")";
			batchaddsql2=batchaddsql2.substring(0,batchaddsql2.length()-1)+","+ino_id+")";
			sql="insert into "+database+".dbo.GL_accvouch"+colmuns1+"values"+batchaddsql1;
			glAccvouchservice.insertBysql(sql);
			sql="insert into "+database+".dbo.GL_accvouch"+colmuns2+"values"+batchaddsql2;
			glAccvouchservice.insertBysql(sql);
			int a = 4-ino_id.length();
			for (int i = 0; i < a; i++) {
				ino_id="0"+ino_id;
			}
			resultmap.put("msg", "已生成凭证 ["+ino_id+"]！");
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("msg", "凭证生成失败!");
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr=null;
			try {
				addr = InetAddress.getLocalHost();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("期间损益自动转账");
			uffj_AccLog.setAction("添加");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		}
		return resultmap;
	}
	
	//现金流量录入时的摘要
	@RequestMapping(params="cashflowopen")
	@ResponseBody
	public Map<Object, Object> cashflowopen(HttpServletRequest request,String ino_id,String iPeriod,String csign,Integer inid){
		String database=request.getSession().getAttribute("database").toString();
		Map<Object, Object> map = new HashMap<Object, Object>();
		String sql="select GL_accvouch.i_id,GL_accvouch.inid,GL_accvouch.ccode,code.ccode_name,GL_accvouch.cdigest from "+database+".dbo.GL_accvouch,"+database+".dbo.code  where GL_accvouch.ccode  = code.ccode and ino_id = '"+ino_id+"' and csign = '"+csign+"' and (bcash = 1 or bbank = 1)and iperiod = "+iPeriod;
		List<Map<Object, Object>> combobox = gl_accassService.findBySql(sql);
		sql="Select ZZ_CashTable.citemcode,HT_CCItem.citemname,ZZ_CashTable.md,ZZ_CashTable.mc From "+database+".dbo.ZZ_CashTable Left Join "+database+".dbo.HT_CCItem "
		+ "On ZZ_CashTable.citemcode=HT_CCItem.citemcode Where iperiod="+iPeriod+" And csign='"+csign+"' And ino_id="+ino_id+" And inid = "+inid+" Order By inid2";
		List<Map<Object, Object>> rows = gl_accassService.findBySql(sql);
		map.put("combobox", combobox);
		map.put("rows", rows);
		
		return map;
	}
	
	@RequestMapping(params = "changecashflow")
	@ResponseBody
	public Map<Object, Object> changecashflow(HttpServletRequest request,String i_id){
		String database=request.getSession().getAttribute("database").toString();
		Map<Object, Object> map = new HashMap<Object, Object>();
		String sql="select * from "+database+".dbo.GL_ACCVOUCH where i_id='"+i_id+"'";
		List<Map<Object, Object>> list = gl_accassService.findBySql(sql);
		map.put("rows", list);
		return map;
	}
	
	
	@RequestMapping(params = "getcombobox")
	@ResponseBody
	public Map<Object, Object> getcombobox(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		Map<Object, Object> map = new HashMap<Object, Object>();
		String sql="select ccode as cCode,'['+ccode+']'+ccode_name as cCode_name from "+database+".dbo.code where bend = 1 order by ccode";
		List<Map<Object, Object>> codes = gl_accassService.findBySql(sql);
		map.put("code", codes);
		sql="select cDepCode as cdept_id,'['+cDepCode+']'+cDepName as cdepname from "+database+".dbo.Department where bdepEnd = 1 order by cdepcode";
		List<Map<Object, Object>> depts = gl_accassService.findBySql(sql);
		map.put("dept", depts);
		sql="select cSSCode as csettle,'['+cSSCode+']'+cSSName as cssname from "+database+".dbo.settleStyle";
		List<Map<Object, Object>> css = gl_accassService.findBySql(sql);
		map.put("settle", css);
		sql="select cPersonCode as cperson_id,'['+cPersonCode+']'+cPersonName as cpersonname from "+database+".dbo.person";
		List<Map<Object, Object>> persons = gl_accassService.findBySql(sql);
		map.put("person", persons);
		sql="select cCusCode as ccus_id,'['+cCusCode+']'+cCusName as ccusname from "+database+".dbo.customer";
		List<Map<Object, Object>> ccus = gl_accassService.findBySql(sql);
		map.put("ccus", ccus);
		sql="select cVenCode as csup_id,'['+cVenCode+']'+cVenName as cvername from "+database+".dbo.vendor";
		List<Map<Object, Object>> supp = gl_accassService.findBySql(sql);
		map.put("supp", supp);
		sql="select citemcode as citem_id,'['+citemcode+']'+citemname as citemname from "+database+".dbo.hT_GLItem";
		List<Map<Object, Object>> items = gl_accassService.findBySql(sql);
		map.put("item", items);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
}












*/