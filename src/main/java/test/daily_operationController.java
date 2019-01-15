/*package test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ht.account.admin.AccInformation;
import com.ht.account.admin.Code;
import com.ht.account.admin.Customer;
import com.ht.account.admin.CustomerclassEntity;
import com.ht.account.admin.Department;
import com.ht.account.admin.GL_VouchDraft;
import com.ht.account.admin.GLmend;
import com.ht.account.admin.GlAccvouch;
import com.ht.account.admin.GradeDef;
import com.ht.account.admin.HT_CCItem;
import com.ht.account.admin.HT_CCItemclass;
import com.ht.account.admin.HT_GLItem;
import com.ht.account.admin.HT_GLItemclass;
import com.ht.account.admin.Inventory;
import com.ht.account.admin.InventoryClass;
import com.ht.account.admin.Person;
import com.ht.account.admin.SettleStyle;
import com.ht.account.admin.Vendor;
import com.ht.account.admin.VendorClass;
import com.ht.account.admin.ZZ_CashTable;
import com.ht.account.admin.ZZ_Digest;
import com.ht.account.admin.ZZ_Lock;
import com.ht.account.admin.dsign;
import com.ht.account.admin.dsigns;
import com.ht.account.admin.gl_bfreq;
import com.ht.account.admin.ua_HoldAuth;
import com.ht.account.admin.ua_Period;
import com.ht.account.admin.ua_RoleAuth;
import com.ht.account.admin.ua_UserRole;
import com.ht.account.admin.vo.CodeV;
import com.ht.account.admin.vo.GL_VouchDraftVo;
import com.ht.account.admin.vo.GlAccvouchVo;
import com.ht.account.service.AccInformationService;
import com.ht.account.service.CodeService;
import com.ht.account.service.CustomerService;
import com.ht.account.service.CustomerclassService;
import com.ht.account.service.DepartmentService;
import com.ht.account.service.FitemService;
import com.ht.account.service.GL_VouchDraftService;
import com.ht.account.service.GLmendService;
import com.ht.account.service.GlAccvouchService;
import com.ht.account.service.GradeDefService;
import com.ht.account.service.HT_CCItemService;
import com.ht.account.service.HT_CCItemclassService;
import com.ht.account.service.HT_GLItemService;
import com.ht.account.service.HT_GLItemclassService;
import com.ht.account.service.InventoryClassService;
import com.ht.account.service.InventoryService;
import com.ht.account.service.ua_HoldAuthService;
import com.ht.account.service.ua_PeriodService;
import com.ht.account.service.ua_RoleAuthService;
import com.ht.account.service.ua_UserRoleService;
import com.ht.account.service.PersonService;
import com.ht.account.service.SettleStyleService;
import com.ht.account.service.SystemService;
import com.ht.account.service.VendorClassService;
import com.ht.account.service.VendorService;
import com.ht.account.service.ZZ_CashTableService;
import com.ht.account.service.ZZ_DigestService;
import com.ht.account.service.ZZ_LockService;
import com.ht.account.service.dsignService;
import com.ht.account.service.dsignsService;
import com.ht.account.service.gl_bfreqService;
import com.ht.account.util.Paging;
import com.ht.account.util.SystemUtil;

import groovy.time.BaseDuration.From;

@Scope("prototype")
@Controller
@RequestMapping("/daily_operationController")
public class daily_operationController {

	@Autowired
	private GradeDefService gradeDefservice;
	@Autowired
	private GlAccvouchService glAccvouchservice;
	@Autowired
	private AccInformationService accInformationservice;
	@Autowired
	private CodeService codeservice; 
	@Autowired
	private ZZ_DigestService zZ_DigestService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerclassService customerclassService;
	@Autowired
	private VendorService vendorservice;
	@Autowired
	private VendorClassService vendorclassservice;
	@Autowired
	private PersonService personservice;
	@Autowired
	private SettleStyleService settleStyleService;
	@Autowired
	private HT_CCItemclassService hT_CCItemclassService;
	@Autowired
	private HT_CCItemService hT_CCItemService;
	@Autowired
	private FitemService fitemService;
	@Autowired
	private HT_GLItemclassService hT_GLItemclassService;
	@Autowired
	private HT_GLItemService hT_GLItemService;
	@Autowired
	private ua_HoldAuthService ua_holdAuthService;
	@Autowired
	private InventoryClassService inventoryclassservice;
	@Autowired
	private InventoryService inventoryservice;
	
	@Autowired
	private ua_UserRoleService ua_userroleService;
	@Autowired
	private ua_RoleAuthService ua_roleauthService; 
	@Autowired
	private ua_PeriodService ua_periodService;
	@Autowired
	private dsignService dsignservice;
	@Autowired
	private dsignsService dsignsservice;
	@Autowired
	private GLmendService GLmendservice;
	@Autowired
	private ZZ_CashTableService ZZ_CashTableservice;
	@Autowired
	private ZZ_LockService zZ_Lockservice;
	@Autowired
	private SystemService systemservice;
	@Autowired
	private GL_VouchDraftService gl_VouchDraftService;
	@Autowired
	private gl_bfreqService gl_bfreqservice;
	
	//获取操作日期
    @RequestMapping(params = "getStartTime")
	@ResponseBody
	public JSONObject getStartTime(HttpServletRequest req){
    	JSONObject jsonObject = new JSONObject();  
    	String data=req.getSession().getAttribute("startTime").toString();
		jsonObject.put("result",data);  
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		jsonObject.put("datenum",simpleDateFormat.parse(data).getTime());  
		} catch (ParseException e) {
			e.printStackTrace();
		}
	   return jsonObject;
   }
	//加载摘要记录
	@RequestMapping(params = "cdigest")
	@ResponseBody
	public List<Map<Object,Object>> cdigest(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<ZZ_Digest> ZZ_Digests= zZ_DigestService.selectAll(database+".dbo.ZZ_Digest");
		List<Map<Object,Object>> list=new ArrayList<Map<Object,Object>>();
		for (ZZ_Digest zz_Digest : ZZ_Digests) {
			Map<Object,Object> map=new HashMap<Object,Object>();
			map.put("id", "");
			map.put("text",zz_Digest.getCdigest());
			list.add(map);
		}
		return list;
	}
	*//**
	 * 凭证类别初始化
	 * *//*
		@RequestMapping(params = "csign")
		@ResponseBody
		public List<dsign> csign(HttpServletRequest req){
			String database=req.getSession().getAttribute("database").toString();
			List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
			return dsigns;
		}
	//选择凭证字动态回显凭证号
	@RequestMapping(params = "getInoid")
	@ResponseBody
	public JSONObject getInoid(HttpServletRequest req){
		try {
			String csign = req.getParameter("parcsign");
			String Dbill_date = req.getParameter("dbill_date");
			String database=req.getSession().getAttribute("database").toString();
			Integer iperiod=ua_periodService.getIperiod(database,Dbill_date);//会记期间
			
			//获取最大凭证号
			Short ino_id=glAccvouchservice.findMaxIno_idByIperiodAndCsign(database+".dbo.GL_accvouch",iperiod,csign);
			AccInformation  HTPZDuanHao= accInformationservice.findBycname(database+".dbo.AccInformation", "HTPZDuanHao");
			if(HTPZDuanHao.getcValue().equals("1")){
				ArrayList<Short> inoids=glAccvouchservice.findIno_idByIperiodAndCsign(database+".dbo.GL_accvouch",iperiod,csign);
				for(Short i=1;i<ino_id;i++){
					if(!inoids.contains(i)){
						ino_id=(short)(i-1);
						break;
					}
				}
			}
				ino_id=ino_id==null?1:(short)(ino_id+1);
				String sinoid=ino_id+"";
				while(true){
					if(sinoid.length()<4){
						sinoid="0"+sinoid;
					}else{
						break;
					}
				}
				 JSONObject jsonObject = new JSONObject();  
		         jsonObject.put("inoid",sinoid);  
		        return jsonObject;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	*//**
	 * 打开常用凭证
	 * **//*
	@RequestMapping(params = "cy_open")
	@ResponseBody
	public JSONObject cy_open(HttpServletRequest req){
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("type", "-1");
		String database=req.getSession().getAttribute("database").toString();
		String userid=req.getSession().getAttribute("userid").toString();
		List<HashMap> systems=systemservice.getJurisdiction(database,userid,"ZZ1101");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","没有增加凭证的权限");  
			return jsonObject;
		}
		List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
		if(dsigns.size()==0 || dsigns==null){
			jsonObject.put("msg","凭证类别没有设置");  
			return jsonObject;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			jsonObject.put("msg", "有互斥功能正在使用中");
			return jsonObject;
		}
		String c_id = req.getParameter("c_id").toString();
		ArrayList<gl_bfreq> glbfre=gl_bfreqservice.findBycidTodet(database,c_id);
		jsonObject.put("type","1");
		jsonObject.put("data",glbfre);
		jsonObject.put("userid",userid);
		return jsonObject;
	}
		*//**
		 * 添加常用凭证
		 * **//*
		@RequestMapping(params = "cy_add")
		@ResponseBody
		public JSONObject cy_add(HttpServletRequest req){
			JSONObject jsonObject = new JSONObject();  
			String database=req.getSession().getAttribute("database").toString();
			String dm = req.getParameter("dm").toString();
			if(dm.length()>10){
				jsonObject.put("type", "-1");
				jsonObject.put("msg", "代码长度不能超过10位");
				return jsonObject;
			}
			ArrayList<gl_bfreq> glbfre=gl_bfreqservice.findBycid(database+".dbo.gl_bfreq",dm);
			if(glbfre!=null && glbfre.size()>0){
				jsonObject.put("type", "-1");
				jsonObject.put("msg", "代码已存在");
				return jsonObject;
			}
			String sm = req.getParameter("sm").toString();
			
			List<HashMap<String,Object>> listmap=(List)JSON.parseArray(req.getParameter("row"),HashMap.class);
			
			String year=listmap.get(0).get("dbill_date").toString().substring(0, 4);
			List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database.substring(0,database.length()-4)+year+".dbo.gl_Accvouch",Integer.parseInt(listmap.get(0).get("iperiod")+""),listmap.get(0).get("csign").toString(), Short.parseShort(listmap.get(0).get("ino_id")+""));
			ArrayList<gl_bfreq> glbfreqs=new ArrayList<>();
			for (int i=0;i<GlAccvouchs.size();i++) {
				GlAccvouchVo glAccvouchVo=GlAccvouchs.get(i);
				gl_bfreq glbfreq=new gl_bfreq();
				glbfreq.setC_id(dm);
				glbfreq.setCtext(sm);
				glbfreq.setInid(glAccvouchVo.getInid());
				glbfreq.setCsign(glAccvouchVo.getCsign());
				glbfreq.setIdoc(glAccvouchVo.getIdoc());
				glbfreq.setCdigest(glAccvouchVo.getCdigest());
				glbfreq.setCcode(glAccvouchVo.getCcode());
				glbfreq.setMd(glAccvouchVo.getMd());
				glbfreq.setMc(glAccvouchVo.getMc());
				glbfreq.setCsettle(glAccvouchVo.getCsettle());
				glbfreq.setCdept_id(glAccvouchVo.getCdept_id());
				glbfreq.setCcus_id(glAccvouchVo.getCcus_id());
				glbfreq.setCsup_id(glAccvouchVo.getCsup_id());
				glbfreq.setCitem_id(glAccvouchVo.getCitem_id());
				glbfreq.setCperson_id(glAccvouchVo.getCperson_id());
				
				//判断现金流
				ZZ_CashTable NzZ_CashTable=new ZZ_CashTable();
				NzZ_CashTable.setIperiod(glAccvouchVo.getIperiod());
				NzZ_CashTable.setCsign(glAccvouchVo.getCsign());
				NzZ_CashTable.setIno_id(glAccvouchVo.getIno_id());
				NzZ_CashTable.setInid(glAccvouchVo.getInid());
				List<ZZ_CashTable> ZZ_CashTables=ZZ_CashTableservice.selectByParameter(database.substring(0,database.length()-4)+year+".dbo.ZZ_CashTable",NzZ_CashTable);
				if(ZZ_CashTables!=null && ZZ_CashTables.size()>0){
					glbfreq.setCashflow(ZZ_CashTables);
				}
				glbfreqs.add(glbfreq);
			}
			
			try{
				gl_bfreqservice.add(database, glbfreqs);
				jsonObject.put("type", "1");
				jsonObject.put("msg", "保存成功");
			}catch(Exception e) {
				e.printStackTrace();
				jsonObject.put("type", "-1");
				jsonObject.put("msg", "保存失败");
			}
			return jsonObject;
		}
		
	//凭证录入初始化
	@RequestMapping(params = "Voucher")
	@ResponseBody
	public Map<Object, Object> daily(HttpServletRequest req,Integer page,Integer rows){
		System.out.println("初适化+++++++++++");
		if(rows==10){
			rows=500;
		}
		String database=req.getSession().getAttribute("database").toString();
		AccInformation  accInformation= accInformationservice.findBycname(database+".dbo.AccInformation", "HTGLUse");
		String cvalue=accInformation.getcValue();
		//ArrayList<GlAccvouch> GL_accvouchs=glAccvouchservice.findGlAccvouchsBysql(database+".dbo.GL_accvouch",cvalue,selectSql);
		HashMap<String,Object> conditionMap=JSON.parseObject(req.getParameter("data"),HashMap.class);
		ArrayList<GlAccvouch> GL_accvouchs=new ArrayList<>();
		if(conditionMap.get("beginDate")!=null && conditionMap.get("beginDate").toString().length()>0){
			String beginyear = conditionMap.get("beginDate").toString().substring(0,4);
			String endyear = conditionMap.get("endDate").toString().substring(0,4);
			String databaseT = database.substring(0,database.length()-4);
			for(Integer begin=Integer.parseInt(beginyear);begin<=Integer.parseInt(endyear);begin++){
				req.setAttribute("database", databaseT+begin);
				String selectSql = SystemUtil.getSelectSql("gl_accvouch",req);
				ArrayList<GlAccvouch> findGlAccvouchsBysql4 = glAccvouchservice.findGlAccvouchsBysql4(databaseT+begin,selectSql);
				GL_accvouchs.addAll(findGlAccvouchsBysql4);
			}
			// GL_accvouchs=glAccvouchservice.findGlAccvouchsBysql3(unall,selectSql);
			// GL_accvouchs=glAccvouchservice.findGlAccvouchsBysql2(databaseT+beginyear,databaseT+endyear,selectSql);
		}else{
			//GL_accvouchs=glAccvouchservice.findGlAccvouchsBysql2(database,database,selectSql);
			req.setAttribute("databse", database);
			String selectSql = SystemUtil.getSelectSql("A",req);
			GL_accvouchs=glAccvouchservice.findGlAccvouchsBysql4(database,selectSql);
		}
		
		for (GlAccvouch glAccvouch : GL_accvouchs) {
			String Ino_id = glAccvouch.getIno_id().toString();
			if(Ino_id.length()==1){
				Ino_id="000"+Ino_id;
			}else if(Ino_id.length()==2){
				Ino_id="00"+Ino_id;
			}else if(Ino_id.length()==3){
				Ino_id="0"+Ino_id;
			}
			glAccvouch.setI_id(glAccvouch.getCsign()+"-"+Ino_id);
			glAccvouch.setCdigest(glAccvouch.getCdigest().substring(1));
			String coutsysname =glAccvouch.getCoutsysname();
			if(coutsysname.equals("IA")){
				glAccvouch.setCdefine1("存货成本");
			}
			if(coutsysname.equals("FA")){
				glAccvouch.setCdefine1("固定资产");
			}
			if(coutsysname.equals("AP")){
				glAccvouch.setCdefine1("应付管理");
			}
			Byte iflag = glAccvouch.getIflag();
			if(iflag==1){
				glAccvouch.setCdefine1("作废");
			}else if(iflag==2){
				glAccvouch.setCdefine1("错误");
			}
		}
		
		Map<Object, Object> map = Paging.pagIng(page, rows, GL_accvouchs);
		ArrayList<GlAccvouch> GlAccvouchrows= (ArrayList<GlAccvouch>)map.get("rows");
		BigDecimal sumMd=new BigDecimal("0");
		BigDecimal sumMc=new BigDecimal("0");
		for (GlAccvouch GlAccvouch : GlAccvouchrows) {
			sumMd=sumMd.add(GlAccvouch.getMd());
			sumMc=sumMc.add(GlAccvouch.getMc());
		}
		GlAccvouch lastrow=new GlAccvouch();
		lastrow.setMd(sumMd);
		lastrow.setMc(sumMc);
		lastrow.setDbill_date("合计");
		GlAccvouchrows.add(lastrow);
		return map;
	}
	
	//凭证录入科目下拉框初始化
	@RequestMapping(params = "subject")
	@ResponseBody
	public List<CodeV> Subject(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<CodeV> codes = codeservice.findAll(database+".dbo.Code");
		Map<String,String> namemap=new HashMap<>();
		for (Code codee : codes) {
			namemap.put(codee.getCcode(),codee.getCcode_name());
		}
		char[] codearr= getCodingruleBykword(database,"code");
		for (Code code : codes) {
			code.setId(code.getCcode());
			code.setText("["+code.getCcode()+"]"+code.getCcode_name());
			String Ccode_name="";
			Integer length=0;
			for (int i = 0; i < code.getIgrade(); i++) {
				length+=Integer.parseInt(codearr[i]+"");
				String ccode = code.getCcode().substring(0,length);
				Ccode_name+="\\"+namemap.get(ccode);
			}
			code.setText2("["+code.getCcode()+"]"+Ccode_name);
		}
		return codes;
	}
	//凭证录入点击科目时查询此科目的具体信息
		@RequestMapping(params = "selectChooseCode")
		@ResponseBody
		public Code selectChooseCode(HttpServletRequest req){
			String database=req.getSession().getAttribute("database").toString();
			String ccode = req.getParameter("ccode");
			Code code=codeservice.selectByCcode(database+".dbo.Code", ccode);
			return code;
		}
	//科目参照初始化
	@RequestMapping(params = "subjectrefer")
	@ResponseBody
	public Map<Object, Object> subjectrefer(HttpServletRequest req,Integer page,Integer rows){
		if(rows==10){
			rows=300;
		}
		String Cclass = req.getParameter("Cclass");
		String Select = req.getParameter("Select");
		String database=req.getSession().getAttribute("database").toString();
		zZ_Lockservice.delInit(database+".dbo.ZZ_Lock");//凭证锁初始化
		//database="HTDATA_101_2015";//测试
		List<CodeV> codes = codeservice.findAll(database+".dbo.Code");
		for (CodeV code : codes) {
			code.setText("["+code.getCcode()+"]"+code.getCcode_name());
			for(int i=1;i<code.getIgrade();i++){
				code.setCcode_name("&emsp;"+code.getCcode_name());
			}
			if(code.getBproperty()){
				code.setBpropertyVo("借");
			}else{
				code.setBpropertyVo("贷");
			}
			if(code.getBdept()){
				code.setBdeptVo("Y");
			}else{
				code.setBdeptVo("");
			}
			if(code.getBperson()){
				code.setBpersonVo("Y");
			}else{
				code.setBpersonVo("");
			}
			if(code.getBcus()){
				code.setBcusVo("Y");
			}else{
				code.setBcusVo("");
			}
			if(code.getBsup()){
				code.setBsupVo("Y");
			}else{
				code.setBsupVo("");
			}
			if(code.getBitem()){
				code.setBitemVo("Y");
			}else{
				code.setBitemVo("");
			}
			if(code.getBcash()){
				code.setBcashVo("Y");
			}else{
				code.setBcashVo("");
			}
			if(code.getBbank()){
				code.setBbankVo("Y");
			}else{
				code.setBbankVo("");
			}
			if(code.getBclose()){
				code.setBcloseVo("Y");
			}else{
				code.setBcloseVo("");
			}
			if(code.getBe()){
				code.setBeVo("Y");
			}else{
				code.setBeVo("");
			}
			if(code.getBr()){
				code.setBrVo("Y");
			}else{
				code.setBrVo("");
			}
		}
		if(Select!=null && Select.length()>0){
			List<CodeV> codes2=new ArrayList<CodeV>();
			for (CodeV code : codes) {
				if(code.getCcode().contains(Select)){
					codes2.add(code);
				}
			}
			codes=codes2;
		}
		if(Cclass!=null && Cclass.length()>0){
			List<CodeV> codes2=new ArrayList<CodeV>();
			for (CodeV code : codes) {
				if(code.getCclass().equals(Cclass)){
					codes2.add(code);
				}
			}
			codes=codes2;
		}
		Map<Object, Object> map = Paging.pagIng(page, rows, codes);
		return map;
	}
	
	
	//科目分类
	@RequestMapping(params = "subjectigrade")
	@ResponseBody
	public List<Code> subjectigrade(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		//database="HTDATA_101_2015";//测试
		List<Code> codes=codeservice.selectByGroupCclass(database+".dbo.Code");
		return codes;
	}
	
	*//**
	 * 冲销凭证
	 * *//*
	@RequestMapping(params = "charge_against")
	@ResponseBody
	public JSONObject charge_against(HttpServletRequest req){
		JSONObject jsonObject = new JSONObject(); 
		String msg="";//返回提示信息
        jsonObject.put("type","0");//默认失败
    try {
		String database=req.getSession().getAttribute("database").toString();
		String username=req.getSession().getAttribute("User").toString();
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		
		List<HashMap> systems=systemservice.getJurisdiction(database,username,"ZZ1101");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","当前用户不具备添加凭证的权限");  
			return jsonObject;
		}
		
		List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
		if(dsigns.size()==0 || dsigns==null){
			jsonObject.put("msg","凭证类别没有设置");  
			return jsonObject;
		}
		
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			jsonObject.put("msg","有互斥功能正在使用中");  
			return jsonObject;
		}
		String startTime=req.getSession().getAttribute("startTime").toString();
		String Dbill_date=list.get(0).getDbill_date();//凭证录入日期
		Integer iperiod=ua_periodService.getIperiod(database,Dbill_date);//会记期间
		//获取最大凭证号
		Short ino_id=glAccvouchservice.findMaxIno_idByIperiodAndCsign(database+".dbo.GL_accvouch",iperiod,list.get(0).getCsign());
		ino_id=ino_id==null?1:(short)(ino_id+1);
		List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(list.get(0).getIperiod()+""),list.get(0).getCsign(), list.get(0).getIno_id());
		for (GlAccvouchVo glAccvouch2 : GlAccvouchs) {
			glAccvouch2.setCode(codeservice.selectByCcode(database+".dbo.code", glAccvouch2.getCcode()));
			glAccvouch2.setCcheck(null);
			glAccvouch2.setCbook(null);
			//判断现金流
			ZZ_CashTable NzZ_CashTable=new ZZ_CashTable();
			NzZ_CashTable.setIperiod(glAccvouch2.getIperiod());
			NzZ_CashTable.setCsign(glAccvouch2.getCsign());
			NzZ_CashTable.setIno_id(glAccvouch2.getIno_id());
			NzZ_CashTable.setInid(glAccvouch2.getInid());
			List<ZZ_CashTable> ZZ_CashTables=ZZ_CashTableservice.selectByParameter(database+".dbo.ZZ_CashTable",NzZ_CashTable);
			if(ZZ_CashTables!=null && ZZ_CashTables.size()>0){
				for (ZZ_CashTable zZ_CashTable : ZZ_CashTables) {
					String citemcode = zZ_CashTable.getCitemcode();
					HT_CCItem hT_CCItem = hT_CCItemService.selectBycitemcode(database+".dbo.hT_CCItem", citemcode);
					zZ_CashTable.setCitemcode(hT_CCItem.getCitemname()+"("+citemcode+")");
				}
				glAccvouch2.setCashflow(ZZ_CashTables);
			}
			String cdept_id = glAccvouch2.getCdept_id();//部门
			if(cdept_id!=null && cdept_id.length()>0){
				List<Department> Departments = departmentService.selectBycDepCode(database+".dbo.department",cdept_id);
				Department Department=Departments.get(0);
				glAccvouch2.setCdept_id(Department.getcDepName()+"("+cdept_id+")");
			}
			String cperson_id = glAccvouch2.getCperson_id();//人员
			if(cperson_id!=null && cperson_id.length()>0){
				Person person = personservice.selectBycPersonCode(database+".dbo.person",cperson_id);
				glAccvouch2.setCperson_id(person.getcPersonName()+"("+cperson_id+")");
			}
			String ccus_id = glAccvouch2.getCcus_id();//客户
			if(ccus_id!=null && ccus_id.length()>0){
				Customer customer = customerService.selectBycCusCode(database+".dbo.customer", ccus_id);
				glAccvouch2.setCcus_id(customer.getCcusname()+"("+ccus_id+")");
			}
			String csup_id = glAccvouch2.getCsup_id();
			if(csup_id!=null && csup_id.length()>0){//供应商
				Vendor vendor=vendorservice.selectBycVenCode(database+".dbo.vendor",csup_id);
				glAccvouch2.setCsup_id(vendor.getcVenName()+"("+csup_id+")");
			}
			String citem_id = glAccvouch2.getCitem_id();
			if(citem_id!=null && citem_id.length()>0){//项目
				HT_GLItem hT_GLItem=hT_GLItemService.selectBycitemcode(database+".dbo.hT_GLItem",citem_id);
				glAccvouch2.setCitem_id(hT_GLItem.getCitemname()+"("+citem_id+")");
			}
			String csettle = glAccvouch2.getCsettle();
			if(csettle!=null && csettle.length()>0){//结算方式
				List<SettleStyle> settleStyles = settleStyleService.selectBycSSCode(database+".dbo.settleStyle", csettle);
				SettleStyle settleStyle=settleStyles.get(0);
				glAccvouch2.setCsettle(settleStyle.getcSSName()+"("+csettle+")");
			}
			
			glAccvouch2.setIno_id(ino_id);
			glAccvouch2.setDbill_date(startTime);
				String cdigest="[冲销"+startTime+"-"+glAccvouch2.getCsign()+"-"+ino_id+"凭证]"+glAccvouch2.getCdigest();
				if(cdigest.getBytes("GBK").length>60){
					cdigest=idgui(cdigest,60);
				}
				glAccvouch2.setCdigest(cdigest);
				BigDecimal md = glAccvouch2.getMd();
				BigDecimal mc = glAccvouch2.getMc();
				if(md!=null && md.compareTo(new BigDecimal("0"))!=0){
					glAccvouch2.setMd(md.negate());
				}
				if(mc!=null && mc.compareTo(new BigDecimal("0"))!=0){
					glAccvouch2.setMc(mc.negate());
				}
		}
			jsonObject.put("GlAccvouchs",GlAccvouchs); 
			jsonObject.put("type","1");  
	} catch (Exception e) {
		e.printStackTrace();
		jsonObject.put("msg","操作异常请重试(异常)");  
	}
    	return jsonObject;
	}
	*//**
	 * 按字节截取字符串
	 * *//*
	public static String idgui(String s,int num)throws Exception{
	    int changdu = s.getBytes("GBK").length;
	    if(changdu > num){
	      s = s.substring(0, s.length() - 1);
	      s = idgui(s,num);
	    }
	    return s;
	  } 
	*//**
	 * 作废凭证
	 * *//*
	@RequestMapping(params = "invalid")
	@ResponseBody
	public JSONObject invalid(HttpServletRequest req){
		JSONObject jsonObject = new JSONObject(); 
		String msg="";//返回提示信息
        jsonObject.put("type","0");
        String typemsg=req.getParameter("typemsg");// 作废||还原
		String database=req.getSession().getAttribute("database").toString();
		String userid=req.getSession().getAttribute("User").toString();
		String username=req.getSession().getAttribute("username").toString();
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		GlAccvouch glAccvouch=list.get(0);
		
		List<HashMap> systems=systemservice.getJurisdiction(database,userid,"ZZ1106");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","当前用户不具备"+typemsg+"凭证的权限");  
			return jsonObject;
		}
		
		List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(glAccvouch.getIperiod()+""),glAccvouch.getCsign(), glAccvouch.getIno_id());
		if(GlAccvouchs==null || GlAccvouchs.size()==0){
			jsonObject.put("msg","当前显示凭证可能已经被其它客户端删除");  
			return jsonObject;
		}
		if(glAccvouch.getCbook()!=null && glAccvouch.getCbook().length()>0){
			jsonObject.put("type","2");
			return jsonObject;
		}
		
		if(glAccvouch.getIflag()!=null && glAccvouch.getIflag()==2){
			jsonObject.put("msg","当前凭证已标错!");  
			return jsonObject;
		}
		if(glAccvouch.getCcheck()!=null && glAccvouch.getCcheck().length()>0){
			jsonObject.put("msg","当前凭证已审核,请取消审核后再做处理！");  
			return jsonObject;
		}
		
		if(glAccvouch.getCoutsysname()!=null && glAccvouch.getCoutsysname().length()>0){
			jsonObject.put("msg","当前凭证外部系统生成的凭证！");  
			return jsonObject;
		}
		
		String cbill = glAccvouch.getCbill();
		if(!username.equals(cbill)){
			AccInformation accInformation = accInformationservice.findBycname(database+".dbo.AccInformation","HTPZZuoFei");
			if(!accInformation.getcValue().equals("1")){
				jsonObject.put("msg","不能"+typemsg+"他人填制的凭证！");  
				return jsonObject;
			}
		}
		
			//锁校验
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",glAccvouch.getIperiod(),glAccvouch.getCsign(),glAccvouch.getIno_id());
			if(zZ_Lock!=null){
				jsonObject.put("msg","当前凭证已被锁定!");  
				return jsonObject;
			}
			
			List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
			if(listmap.size()!=0){
				jsonObject.put("msg","有互斥功能正在使用中!");  
				return jsonObject;
			}
			
			try{
				if(typemsg.equals("还原")){
					glAccvouch.setIflag(null);
				}else if(typemsg.equals("作废")){
					glAccvouch.setIflag((byte)1);
				}
				glAccvouchservice.invalidByIperiodAndcsignAndino_id(database+".dbo.Gl_accvouch",glAccvouch);
				jsonObject.put("type","1");  
				return jsonObject;
			}catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("msg","标记失败!");  
				return jsonObject;
			}
			
	}
	
	*//**
	 * 签字凭证
	 * *//*
	@RequestMapping(params = "signature")
	@ResponseBody
	public JSONObject signature(HttpServletRequest req){
		JSONObject resultObject = new JSONObject(); 
        
        String type = req.getParameter("type");
		String database=req.getSession().getAttribute("database").toString();
		String username=req.getSession().getAttribute("User").toString();
		String signatureflag="";
		if(type.equals("1")){
			signatureflag="签字";
		}else{
			signatureflag="销字";
		}
		List<HashMap> systems=systemservice.getJurisdiction(database,username,"ZZ1103");
		if(systems==null || systems.size()==0){
			resultObject.put("msg","当前用户不具备"+signatureflag+"凭证的权限"); 
			resultObject.put("type","0");
			return resultObject;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			resultObject.put("msg","有互斥功能正在使用中");
			resultObject.put("type","0");
			return resultObject;
		}
		
		List<JSONObject> listObject = new ArrayList<JSONObject>();
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		for(int i=0;i<list.size();i++){
			JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("dbill_date", list.get(i).getDbill_date());
			jsonObject.put("i_id", list.get(i).getCsign()+"-"+list.get(i).getIno_id());
			jsonObject.put("type","0");//默认失败
			
			List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(list.get(i).getIperiod()+""),list.get(i).getCsign(), list.get(i).getIno_id());
			if(GlAccvouchs==null || GlAccvouchs.size()==0){
				jsonObject.put("msg","凭证"+signatureflag+"失败,凭证可能已经被其它客户端删除");  
				listObject.add(jsonObject);
				continue;
			}
			if(GlAccvouchs.get(0).getIflag()!=null && GlAccvouchs.get(0).getIflag()==1){
				jsonObject.put("msg","凭证"+signatureflag+"失败,凭证已作废");  
				listObject.add(jsonObject);
				continue;
			}
			if(signatureflag.equals("签字")){
				if(GlAccvouchs.get(0).getIflag()!=null && GlAccvouchs.get(0).getIflag()==2){
					jsonObject.put("msg","凭证"+signatureflag+"失败,凭证已标错");  
					listObject.add(jsonObject);
					continue;
				}
			}
			if(GlAccvouchs.get(0).getCcheck()!=null && GlAccvouchs.get(0).getCcheck().length()>0){
				jsonObject.put("msg","凭证"+signatureflag+"失败,凭证已审核");  
				listObject.add(jsonObject);
				continue;
			}
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",GlAccvouchs.get(0).getIperiod(),GlAccvouchs.get(0).getCsign(),GlAccvouchs.get(0).getIno_id());
			if(zZ_Lock!=null){
				jsonObject.put("msg","凭证"+signatureflag+"失败,凭证已被锁定");  
				listObject.add(jsonObject);
				continue;
			}
			if(type.equals("1")){
				if(GlAccvouchs.get(0).getCcashier()!=null && GlAccvouchs.get(0).getCcashier().length()>0){
					jsonObject.put("msg","凭证签字失败,凭证已签字");  
					listObject.add(jsonObject);
					continue;
				}
				boolean bankorcash=false;
				for (GlAccvouchVo glAccvouchVo : GlAccvouchs) {
					Code Ccode = codeservice.selectByCcode(database+".dbo.code",glAccvouchVo.getCcode());
					if(Ccode.getBcash() || Ccode.getBbank()){
						bankorcash=true;
					}
				}
				if(!bankorcash){
					jsonObject.put("msg","凭证签字失败,凭证没有现金或银行科目,不需要出纳签字");  
					listObject.add(jsonObject);
					continue;
				}
				GlAccvouchs.get(0).setCcashier(req.getSession().getAttribute("username").toString());
			}else{
				if(GlAccvouchs.get(0).getCcashier()==null){
					jsonObject.put("msg","凭证销字失败,凭证尚未签字");  
					listObject.add(jsonObject);
					continue;
				}
				GlAccvouchs.get(0).setCcashier(null);
			}
			
			try{
				glAccvouchservice.signature(req,GlAccvouchs.get(0));
				jsonObject.put("type","1"); 
				jsonObject.put("msg","凭证"+signatureflag+"成功!");  
				listObject.add(jsonObject);
			}catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("msg","凭证"+signatureflag+"失败,数据库错误");  
				listObject.add(jsonObject);
			}
		}
		resultObject.put("type","1");//通过权限和互斥
		resultObject.put("resultList",listObject);
		return resultObject;
	}
	*//**
	 * 标错凭证
	 * *//*
	@RequestMapping(params = "Berror")
	@ResponseBody
	public JSONObject Berror(HttpServletRequest req){
		JSONObject jsonObject = new JSONObject(); 
		String msg="";//返回提示信息
        jsonObject.put("type","0");
        String stype = req.getParameter("type").toString();
		String database=req.getSession().getAttribute("database").toString();
		String username=req.getSession().getAttribute("User").toString();
		
		List<HashMap> systems=systemservice.getJurisdiction(database,username,"ZZ1105");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","当前用户不具备"+stype+"凭证的权限");  
			return jsonObject;
		}
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		GlAccvouch glAccvouch=list.get(0);
		
		List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(glAccvouch.getIperiod()+""),glAccvouch.getCsign(), glAccvouch.getIno_id());
		if(GlAccvouchs==null || GlAccvouchs.size()==0){
			jsonObject.put("msg","当前显示凭证可能已经被其它客户端删除");  
			return jsonObject;
		}
		if(glAccvouch.getCbook()!=null && glAccvouch.getCbook().length()>0){
			jsonObject.put("msg","当前凭证已经记账");  
			return jsonObject;
		}
		
		if(glAccvouch.getCcheck()!=null && glAccvouch.getCcheck().length()>0){
			jsonObject.put("msg","当前凭证已经审核不能"+stype+"，请取消审核后再做处理");  
			return jsonObject;
		}
		
		if(glAccvouch.getIflag()==1){
			jsonObject.put("msg","当前凭证已经作废");  
			return jsonObject;
		}
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",glAccvouch.getIperiod(),glAccvouch.getCsign(),glAccvouch.getIno_id());
			if(zZ_Lock!=null){
				jsonObject.put("msg","当前凭证已被锁定，不能"+stype+"!");  
				return jsonObject;
			}
			
			List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
			if(listmap.size()!=0){
				jsonObject.put("msg","有互斥功能正在使用中，不能"+stype+"!");  
				return jsonObject;
			}
			
			try{
				glAccvouchservice.bjerrorByIperiodAndcsignAndino_id(database+".dbo.Gl_accvouch",glAccvouch,stype);
				jsonObject.put("type","1");  
				return jsonObject;
			}catch (Exception e) {
				e.printStackTrace();
				jsonObject.put("msg","标记失败!");  
				return jsonObject;
			}
			
	}
	
	
	*//**
	 * 校验 添加权限
	 * *//*
	@RequestMapping(params = "addAuth")
	@ResponseBody
	public JSONObject addAuth(HttpServletRequest req){
		JSONObject jsonObject = new JSONObject(); 
        jsonObject.put("type","-1");//默认失败
        String database=req.getSession().getAttribute("database").toString();
        String userid=req.getSession().getAttribute("User").toString();
        List<HashMap> systems=systemservice.getJurisdiction(database,userid,"ZZ1101");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","当前用户不具备修改凭证的权限");  
			return jsonObject;
		}
		List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
		if(dsigns.size()==0 || dsigns==null){
			jsonObject.put("msg","凭证类别没有设置");  
			return jsonObject;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			jsonObject.put("msg", "有互斥功能正在使用中");
			return jsonObject;
		}
		List<GlAccvouchVo> list = showPZ(req);
		jsonObject.put("type","1");
		jsonObject.put("data",list);
		jsonObject.put("userid",userid);
		return jsonObject;
	}
	*//**
	 *校验是否具备凭证修改权限 
	 * *//*
	@RequestMapping(params = "jurisdiction")
	@ResponseBody
	public JSONObject jurisdiction(HttpServletRequest req){
		JSONObject jsonObject = new JSONObject(); 
        jsonObject.put("type","0");//默认失败
        
        String database=req.getSession().getAttribute("database").toString();
        String userid=req.getSession().getAttribute("User").toString();
        String username=req.getSession().getAttribute("username").toString();
        List<HashMap> systems=systemservice.getJurisdiction(database,userid,"ZZ1102");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","当前用户不具备修改凭证的权限");  
			return jsonObject;
		}
		
		String selectrow = req.getParameter("selectrow");
		List<GlAccvouch> list=(List)JSON.parseArray(selectrow,GlAccvouch.class);
		GlAccvouch glAccvouch=list.get(0);
		List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(glAccvouch.getIperiod()+""),glAccvouch.getCsign(), glAccvouch.getIno_id());
		glAccvouch=GlAccvouchs.get(0);
		
		if(glAccvouch==null){
			jsonObject.put("msg","当前显示凭证可能已经被其它客户端删除");  
			return jsonObject;
		}
		if(glAccvouch.getCoutsysname()!=null && glAccvouch.getCoutsysname().length()>0){
			jsonObject.put("msg","当前凭证外部系统生成的凭证，不能修改！");  
			return jsonObject;
		}
		if(glAccvouch.getCcheck()!=null && glAccvouch.getCcheck().length()>0){
			jsonObject.put("msg","当前凭证已审核，不能修改！");  
			return jsonObject;
		}
		if(glAccvouch.getCcashier()!=null && glAccvouch.getCcashier().length()>0){
			jsonObject.put("msg","当前凭证已出纳签字，不能修改！");  
			return jsonObject;
		}
		if(glAccvouch.getIflag()!=null && glAccvouch.getIflag()==1){
			jsonObject.put("msg","当前凭证已作废，不能修改！");  
			return jsonObject;
		}
		String cbill = glAccvouch.getCbill();
		if(!username.equals(cbill)){
			AccInformation accInformation = accInformationservice.findBycname(database+".dbo.AccInformation","HTPZEdit");
			if(!accInformation.getcValue().equals("1")){
				jsonObject.put("msg","不能修改他人填制的凭证！");  
				return jsonObject;
			}
		}
		//锁校验
		ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",glAccvouch.getIperiod(),glAccvouch.getCsign(),glAccvouch.getIno_id());
		if(zZ_Lock!=null){
			jsonObject.put("msg","当前凭证已被锁定，不能修改!");  
			return jsonObject;
		}else{
			zZ_Lockservice.insertLock(database+".dbo.ZZ_Lock",glAccvouch);
		}
		jsonObject.put("type","1");
		return jsonObject;
	}
	
	*//**
	 * 展示凭证数据
	 * *//*
	@RequestMapping(params = "showPZ")
	@ResponseBody
	public List<GlAccvouchVo> showPZ(HttpServletRequest req){
        String database=req.getSession().getAttribute("database").toString();
		System.out.println(req.getParameter("selectrow"));
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<HashMap<String,Object>> listmap=(List)JSON.parseArray(req.getParameter("selectrow"),HashMap.class);
		// List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		String year=listmap.get(0).get("dbill_date").toString().substring(0, 4);
		database=database.substring(0,database.length()-4)+year;
		List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(listmap.get(0).get("iperiod")+""),listmap.get(0).get("csign").toString(), Short.parseShort(listmap.get(0).get("ino_id")+""));
		
		if(GlAccvouchs==null || GlAccvouchs.size()==0){
			return null;
		}
		
		List<CodeV> findAll = codeservice.findAll(database+".dbo.code");
		HashMap<String,CodeV> codemap=new HashMap<String,CodeV>();
		for (CodeV codeV : findAll) {
			codemap.put(codeV.getCcode(), codeV);
		}
		
		char[] codearr= getCodingruleBykword(database,"code");
		for (Code code : findAll) {
			String Ccode_name="";
			Integer length=0;
			for (int i = 0; i < code.getIgrade(); i++) {
				length+=Integer.parseInt(codearr[i]+"");
				String ccode = code.getCcode().substring(0,length);
				Ccode_name+="\\"+codemap.get(ccode).getCcode_name();
			}
			code.setText2("["+code.getCcode()+"]"+Ccode_name);
		}
		
		List<Department> selectDepartment = departmentService.selectDepartment(database+".dbo.Department");
		HashMap<String,Department> Depmap=new HashMap<String,Department>();
		for (Department department : selectDepartment) {
			Depmap.put(department.getcDepCode(), department);
		}
		List<Person> all = personservice.getAll(database+".dbo.Person");
		HashMap<String,Person> persmap=new HashMap<String,Person>();
		for (Person person : all) {
			persmap.put(person.getcPersonCode(), person);
		}
		List<Customer> all2 = customerService.getAll(database+".dbo.Customer");
		HashMap<String,Customer> custmap=new HashMap<String,Customer>();
		for (Customer customer : all2) {
			custmap.put(customer.getCcuscode(), customer);
		}
		List<Vendor> all3 = vendorservice.getAll(database+".dbo.Vendor");
		HashMap<String,Vendor> vendmap=new HashMap<String,Vendor>();
		for (Vendor vendor : all3) {
			vendmap.put(vendor.getcVenCode(), vendor);
		}
		List<HT_GLItem> findAll2 = hT_GLItemService.findAll(database+".dbo.hT_GLItem");
		HashMap<String,HT_GLItem> hT_GLImap=new HashMap<String,HT_GLItem>();
		for (HT_GLItem ht_GLItem : findAll2) {
			hT_GLImap.put(ht_GLItem.getCitemcode(), ht_GLItem);
		}
		
		for (GlAccvouchVo glAccvouch2 : GlAccvouchs) {
			//Code selectByCcode = codeservice.selectByCcode(database+".dbo.code", glAccvouch2.getCcode());
			Code selectByCcode =codemap.get(glAccvouch2.getCcode());
			if(selectByCcode!=null){
				glAccvouch2.setCode(selectByCcode);
				//glAccvouch2.setCcode("["+selectByCcode.getCcode()+"]"+selectByCcode.getCcode_name());
			}
			
			//判断现金流
			Boolean getbCashItem = false;
			if(selectByCcode!=null){
				getbCashItem = selectByCcode.getbCashItem();
			}
			if(getbCashItem){
				ZZ_CashTable NzZ_CashTable=new ZZ_CashTable();
				NzZ_CashTable.setIperiod(glAccvouch2.getIperiod());
				NzZ_CashTable.setCsign(glAccvouch2.getCsign());
				NzZ_CashTable.setIno_id(glAccvouch2.getIno_id());
				NzZ_CashTable.setInid(glAccvouch2.getInid());
				List<ZZ_CashTable> ZZ_CashTables=ZZ_CashTableservice.selectByParameter(database+".dbo.ZZ_CashTable",NzZ_CashTable);
				if(ZZ_CashTables!=null && ZZ_CashTables.size()>0){
					for (ZZ_CashTable zZ_CashTable : ZZ_CashTables) {
						String citemcode = zZ_CashTable.getCitemcode();
						HT_CCItem hT_CCItem = hT_CCItemService.selectBycitemcode(database+".dbo.hT_CCItem", citemcode);
						if(hT_CCItem!=null){
							zZ_CashTable.setCitemcode("["+citemcode+"]"+hT_CCItem.getCitemname());
						}
						if(zZ_CashTable.getMd().compareTo(new BigDecimal("0"))==0){
							zZ_CashTable.setMd(null);
						}
						if(zZ_CashTable.getMc().compareTo(new BigDecimal("0"))==0){
							zZ_CashTable.setMc(null);
						}
					}
					glAccvouch2.setCashflow(ZZ_CashTables);
				}
			}
			
			//部门
			String cdept_id = glAccvouch2.getCdept_id();
			if(cdept_id!=null && cdept_id.length()>0){
				//List<Department> Departments = departmentService.selectBycDepCode(database+".dbo.department",cdept_id);
				Department department2 = Depmap.get(cdept_id);
				if(department2!=null ){
					//Department Department=Departments.get(0);
					glAccvouch2.setCdept_id("["+cdept_id+"]"+department2.getcDepName());
				}
			}
			String cperson_id = glAccvouch2.getCperson_id();//人员
			if(cperson_id!=null && cperson_id.length()>0){
				//Person person = personservice.selectBycPersonCode(database+".dbo.person",cperson_id);
				Person person =persmap.get(cperson_id);
				if(person!=null){
					glAccvouch2.setCperson_id("["+cperson_id+"]"+person.getcPersonName());
				}
			}
			String ccus_id = glAccvouch2.getCcus_id();//客户
			if(ccus_id!=null && ccus_id.length()>0){
				//Customer customer = customerService.selectBycCusCode(database+".dbo.customer", ccus_id);
				Customer customer =custmap.get(ccus_id);
				if(customer!=null){
					glAccvouch2.setCcus_id("["+ccus_id+"]"+customer.getCcusname());
				}
			}
			String csup_id = glAccvouch2.getCsup_id();
			if(csup_id!=null && csup_id.length()>0){//供应商
				//Vendor vendor=vendorservice.selectBycVenCode(database+".dbo.vendor",csup_id);
				Vendor vendor=vendmap.get(csup_id);
				if(vendor!=null){
					glAccvouch2.setCsup_id("["+csup_id+"]"+vendor.getcVenName());
				}
			}
			String citem_id = glAccvouch2.getCitem_id();
			if(citem_id!=null && citem_id.length()>0){//项目
				//HT_GLItem hT_GLItem=hT_GLItemService.selectBycitemcode(database+".dbo.hT_GLItem",citem_id);
				HT_GLItem hT_GLItem=hT_GLImap.get(citem_id);
				if(hT_GLItem!=null){
					glAccvouch2.setCitem_id("["+citem_id+"]"+hT_GLItem.getCitemname());
				}
			}
			String csettle = glAccvouch2.getCsettle();
			if(csettle!=null && csettle.length()>0){//结算方式
				List<SettleStyle> settleStyles = settleStyleService.selectBycSSCode(database+".dbo.settleStyle", csettle);
				if(settleStyles!=null && settleStyles.size()>0){
					SettleStyle settleStyle=settleStyles.get(0);
					glAccvouch2.setCsettle("["+csettle+"]"+settleStyle.getcSSName());
				}
			}
		}
		return GlAccvouchs;
	}
	
	*//**
	 * 展示凭证数据
	 * *//*
	@RequestMapping(params = "showvoucher")
	@ResponseBody
	public List<GlAccvouchVo> showvoucher(HttpServletRequest req,String selectrow){
        String database=req.getSession().getAttribute("database").toString();
        @SuppressWarnings("unchecked")
		Map<Object, Object> row= (Map<Object, Object>) JSON.parse(selectrow);
        System.err.println(row.get("iperiod"));
        System.err.println(row.get("csign"));
        System.err.println(row.get("ino_id"));
		List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(row.get("iperiod")+""),row.get("csign").toString(),Short.valueOf(row.get("ino_id").toString()));
		
		if(GlAccvouchs==null || GlAccvouchs.size()==0){
			return null;
		}
		
		for (GlAccvouchVo glAccvouch2 : GlAccvouchs) {
			Code selectByCcode = codeservice.selectByCcode(database+".dbo.code", glAccvouch2.getCcode());
			glAccvouch2.setCode(selectByCcode);
			//判断现金流
			ZZ_CashTable NzZ_CashTable=new ZZ_CashTable();
			NzZ_CashTable.setIperiod(glAccvouch2.getIperiod());
			NzZ_CashTable.setCsign(glAccvouch2.getCsign());
			NzZ_CashTable.setIno_id(glAccvouch2.getIno_id());
			NzZ_CashTable.setInid(glAccvouch2.getInid());
			List<ZZ_CashTable> ZZ_CashTables=ZZ_CashTableservice.selectByParameter(database+".dbo.ZZ_CashTable",NzZ_CashTable);
			if(ZZ_CashTables!=null && ZZ_CashTables.size()>0){
				for (ZZ_CashTable zZ_CashTable : ZZ_CashTables) {
					String citemcode = zZ_CashTable.getCitemcode();
					HT_CCItem hT_CCItem = hT_CCItemService.selectBycitemcode(database+".dbo.hT_CCItem", citemcode);
					zZ_CashTable.setCitemcode(hT_CCItem.getCitemname()+"("+citemcode+")");
				}
				glAccvouch2.setCashflow(ZZ_CashTables);
			}
			//部门
			String cdept_id = glAccvouch2.getCdept_id();
			if(cdept_id!=null && cdept_id.length()>0){
				List<Department> Departments = departmentService.selectBycDepCode(database+".dbo.department",cdept_id);
				Department Department=Departments.get(0);
				glAccvouch2.setCdept_id(Department.getcDepName()+"("+cdept_id+")");
			}
			String cperson_id = glAccvouch2.getCperson_id();//人员
			if(cperson_id!=null && cperson_id.length()>0){
				Person person = personservice.selectBycPersonCode(database+".dbo.person",cperson_id);
				glAccvouch2.setCperson_id(person.getcPersonName()+"("+cperson_id+")");
			}
			String ccus_id = glAccvouch2.getCcus_id();//客户
			if(ccus_id!=null && ccus_id.length()>0){
				Customer customer = customerService.selectBycCusCode(database+".dbo.customer", ccus_id);
				glAccvouch2.setCcus_id(customer.getCcusname()+"("+ccus_id+")");
			}
			String csup_id = glAccvouch2.getCsup_id();
			if(csup_id!=null && csup_id.length()>0){//供应商
				Vendor vendor=vendorservice.selectBycVenCode(database+".dbo.vendor",csup_id);
				glAccvouch2.setCsup_id(vendor.getcVenName()+"("+csup_id+")");
			}
			String citem_id = glAccvouch2.getCitem_id();
			if(citem_id!=null && citem_id.length()>0){//项目
				HT_GLItem hT_GLItem=hT_GLItemService.selectBycitemcode(database+".dbo.hT_GLItem",citem_id);
				glAccvouch2.setCitem_id(hT_GLItem.getCitemname()+"("+citem_id+")");
			}
			String csettle = glAccvouch2.getCsettle();
			if(csettle!=null && csettle.length()>0){//结算方式
				List<SettleStyle> settleStyles = settleStyleService.selectBycSSCode(database+".dbo.settleStyle", csettle);
				SettleStyle settleStyle=settleStyles.get(0);
				glAccvouch2.setCsettle(settleStyle.getcSSName()+"("+csettle+")");
			}
		}
		return GlAccvouchs;
	}
	
	
	//核算分类选择树形菜单初始化
	@RequestMapping(params = "checkTree")
	@ResponseBody
	public Object[] checkTree(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String type = req.getParameter("type");
		Object[] array = null;
		Object[] array2 =null;
		if(type!=null && type.equals("cdept_id")){//部门
			char[]arr=getCodingruleBykword(database,"Department");
			List<Department> departments=departmentService.selectDepartment(database+".dbo.department");
			for (Department department : departments) {
				department.setName("["+department.getcDepCode()+"]"+department.getcDepName());
				String cDepCode=department.getcDepCode();
				department.setId(cDepCode);
				byte Grade = department.getiDepGrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					department.setpId(cDepCode.substring(0,pidlength));
				}
			}
			return departments.toArray();
		}else if(type!=null && type.equals("csettle")){//结算方式
			char[]arr=getCodingruleBykword(database,"settlestyle");
			List<SettleStyle> settleStyles=settleStyleService.selectSettleStyle(database+".dbo.SettleStyle");
			for (SettleStyle settleStyle : settleStyles) {
				settleStyle.setName("["+settleStyle.getcSSCode()+"]"+settleStyle.getcSSName());
				String cDCCode=settleStyle.getcSSCode();
				settleStyle.setId(cDCCode);
				byte Grade = settleStyle.getiSSGrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					settleStyle.setpId(cDCCode.substring(0,pidlength));
				}
			}
			return settleStyles.toArray();
		}else if(type!=null && type.equals("cperson_id")){//人员
			char[]arr=getCodingruleBykword(database,"Department");
			List<Department> departments=departmentService.selectDepartment(database+".dbo.department");
			for (Department department : departments) {
				department.setName("["+department.getcDepCode()+"]"+department.getcDepName());
				String cDepCode=department.getcDepCode();
				department.setId(cDepCode);
				byte Grade = department.getiDepGrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					department.setpId(cDepCode.substring(0,pidlength));
				}
			}
			List<Person>  Persons= personservice.selectByParameter(database+".dbo.Person", new Person());
			for (Person person : Persons) {
				person.setId(person.getcPersonCode());
				person.setpId(person.getcDepCode());
				person.setName("["+person.getcPersonCode()+"]"+person.getcPersonName());
			}
			array = departments.toArray();
			array2 = Persons.toArray();
		}else if(type!=null && type.equals("ccus_id")){//客户
			char[]arr=getCodingruleBykword(database,"customerclass");
			List<CustomerclassEntity> Customerclasss=customerclassService.selectAll(database+".dbo.CustomerClass");
			for (CustomerclassEntity customerclassEntity : Customerclasss) {
				customerclassEntity.setName("["+customerclassEntity.getCcccode()+"]"+customerclassEntity.getCccname());
				String ccccode=customerclassEntity.getCcccode();
				customerclassEntity.setId(ccccode);
				byte Grade=customerclassEntity.getIccgrade();
				if(Grade!=1){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					customerclassEntity.setpId(ccccode.substring(0,pidlength));
				}
			}
			List<Customer> customers=customerService.selectByParameter(database+".dbo.Customer",new Customer());
			for (Customer customer : customers) {
				customer.setId(customer.getCcuscode());
				customer.setpId(customer.getCcccode());
				customer.setName("["+customer.getCcuscode()+"]"+customer.getCcusname());
			}
			 array = Customerclasss.toArray();
			 array2 = customers.toArray();
		}else if(type!=null && type.equals("csup_id")){//供应商
			char[]arr=getCodingruleBykword(database,"vendorclass");
			List<VendorClass> VendorClasss=vendorclassservice.selectAll(database+".dbo.VendorClass");
			for (VendorClass vendor : VendorClasss) {
				vendor.setName("["+vendor.getcVCCode()+"]"+vendor.getcVCName());
				String cVCCode=vendor.getcVCCode();
				vendor.setId(cVCCode);
				byte Grade = vendor.getiVCGrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					vendor.setpId(cVCCode.substring(0,pidlength));
				}
			}
			//List<Vendor> vendors=vendorservice.selectByParameter(database+".dbo.vendor",new Vendor());
			List<Vendor> vendors=vendorservice.getAll(database+".dbo.vendor");
			for (Vendor vendor : vendors) {
				vendor.setId(vendor.getcVenCode());
				vendor.setpId(vendor.getcVCCode());
				vendor.setName("["+vendor.getcVenCode()+"]"+vendor.getcVenName());
			}
			array = VendorClasss.toArray();
			array2 = vendors.toArray();
		}else if(type!=null && type.equals("csup_ID")){//供应商类别
			char[]arr=getCodingruleBykword(database,"vendorclass");
			List<VendorClass> VendorClasss=vendorclassservice.selectAll(database+".dbo.VendorClass");
			for (VendorClass vendor : VendorClasss) {
				vendor.setName("["+vendor.getcVCCode()+"]"+vendor.getcVCName());
				String cVCCode=vendor.getcVCCode();
				vendor.setId(cVCCode);
				vendor.setNocheck(false);
				byte Grade = vendor.getiVCGrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					vendor.setpId(cVCCode.substring(0,pidlength));
				}
			}
			return VendorClasss.toArray();
		}else if(type!=null && type.equals("citem_id")){//项目
			char[]arr=getCodingruleBykword(database,"ht_glitemclass");
			List<HT_GLItemclass> hT_GLItemclasss=hT_GLItemclassService.selectAll(database+".dbo.HT_GLItemclass");
			for (HT_GLItemclass hT_GLItemclass : hT_GLItemclasss) {
				hT_GLItemclass.setName("["+hT_GLItemclass.getcItemCcode()+"]"+hT_GLItemclass.getcItemCname());
				String cItemCcode=hT_GLItemclass.getcItemCcode();
				hT_GLItemclass.setId(cItemCcode);
				byte Grade = hT_GLItemclass.getiItemCgrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					hT_GLItemclass.setpId(cItemCcode.substring(0,pidlength));
				}
			}
			List<HT_GLItem>  HT_GLItems= hT_GLItemService.selectByParameter(database+".dbo.HT_GLItem",new HT_GLItem());
			for (HT_GLItem HT_GLItem : HT_GLItems) {
				HT_GLItem.setId(HT_GLItem.getCitemcode());
				HT_GLItem.setpId(HT_GLItem.getCitemccode());
				HT_GLItem.setName("["+HT_GLItem.getCitemcode()+"]"+HT_GLItem.getCitemname());
			}
			array = hT_GLItemclasss.toArray();
			array2 = HT_GLItems.toArray();
			//search="选择项目";
		}else if(type.equals("cashflowitem")){//现金流量项目
			String Crule=fitemService.selectCruleBycitem_class(database+".dbo.fitem","88"); 
			char[]arr=Crule.toCharArray();
			List<HT_CCItemclass> HT_CCItemclasss=hT_CCItemclassService.selectAll(database+".dbo.hT_CCItemclass");
			for (HT_CCItemclass hT_CCItemclass : HT_CCItemclasss) {
				hT_CCItemclass.setName("["+hT_CCItemclass.getcItemCcode()+"]"+hT_CCItemclass.getcItemCname());
				String cVCCode=hT_CCItemclass.getcItemCcode();
				hT_CCItemclass.setId(cVCCode);
				byte Grade = hT_CCItemclass.getiItemCgrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					hT_CCItemclass.setpId(cVCCode.substring(0,pidlength));
				}
			}
			
			List<HT_CCItem> HT_CCItems=hT_CCItemService.selectAll(database+".dbo.hT_CCItem");
			for (HT_CCItem HT_CCItem : HT_CCItems) {
				HT_CCItem.setId(HT_CCItem.getCitemcode());
				HT_CCItem.setpId(HT_CCItem.getCitemccode());
				HT_CCItem.setName("["+HT_CCItem.getCitemcode()+"]"+HT_CCItem.getCitemname());
			}
			array = HT_CCItemclasss.toArray();
			array2 = HT_CCItems.toArray();
		}else if(type.equals("inventory")){//存货
			char[]arr=getCodingruleBykword(database,"InventoryClass");
			List<InventoryClass> inventorys=inventoryclassservice.selectAll(database+".dbo.InventoryClass");
			for (InventoryClass inventory : inventorys) {
				inventory.setName("["+inventory.getCinvCCode()+"]"+inventory.getCinvCName());
				String cinvCCode=inventory.getCinvCCode();
				inventory.setId(cinvCCode);
				byte Grade = inventory.getiInvCGrade();
				if(Grade!=1){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					inventory.setpId(cinvCCode.substring(0,pidlength));
				}
			}
			
			List<Inventory> Inventorys=inventoryservice.selectAll(database+".dbo.Inventory");
			for (Inventory Inventory : Inventorys) {
				Inventory.setId(Inventory.getcInvCode());
				Inventory.setpId(Inventory.getcInvCCode());
				Inventory.setName("["+Inventory.getcInvCode()+"]"+Inventory.getcInvName());
			}
			array = inventorys.toArray();
			array2 = Inventorys.toArray();
		}else if(type.equals("cashflowstatistics")){//现金流量项目
			String Crule=fitemService.selectCruleBycitem_class(database+".dbo.fitem","88"); 
			char[]arr=Crule.toCharArray();
			List<HT_CCItemclass> HT_CCItemclasss=hT_CCItemclassService.selectAll(database+".dbo.hT_CCItemclass");
			for (HT_CCItemclass hT_CCItemclass : HT_CCItemclasss) {
				hT_CCItemclass.setName("["+hT_CCItemclass.getcItemCcode()+"]"+hT_CCItemclass.getcItemCname());
				String cVCCode=hT_CCItemclass.getcItemCcode();
				hT_CCItemclass.setId(cVCCode);
				byte Grade = hT_CCItemclass.getiItemCgrade();
				if(Grade!=1 ){
					Integer pidlength=0;
					for(int i=0;i<Grade-1;i++){
						pidlength+=Integer.parseInt(arr[i]+"");
					}
					hT_CCItemclass.setpId(cVCCode.substring(0,pidlength));
				}
			}
			
			return HT_CCItemclasss.toArray();
		}
		return ArrayUtils.addAll(array, array2);
	}
	*//**
	 * 关闭窗口删除凭证锁
	 * *//*
	@RequestMapping(params = "delLock")
	@ResponseBody
	public void delLock(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		for (GlAccvouch glAccvouch : list) {
			System.out.println(glAccvouch);
		}
			zZ_Lockservice.del(database+".dbo.ZZ_Lock",list.get(0));//删除凭证锁
	}
	
	*//**
	 * 凭证审核确认
	 * *//*
	@RequestMapping(params = "AffirmAudit")
	@ResponseBody
	public JSONObject AffirmAudit(HttpServletRequest req){
        String database=req.getSession().getAttribute("database").toString();
        String username=req.getSession().getAttribute("User").toString();
        
    	AccInformation accinformation = accInformationservice.findBycsysidAndcname(database+".dbo.accInformation", "GL", "HTCashier");
        List<HashMap> systems=systemservice.getJurisdiction(database,username,"ZZ1104");
		
        JSONObject resultObject = new JSONObject(); 
		if(systems==null || systems.size()==0){
			resultObject.put("type","0");
			resultObject.put("msg","审核失败,当前用户不具备审核凭证的权限");  
			return resultObject;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			resultObject.put("type","0");
			resultObject.put("msg","审核失败,有互斥功能正在使用中");  
			return resultObject;
		}
		List<JSONObject> listObject = new ArrayList<JSONObject>();
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		outer: 
		for (GlAccvouch glAccvouch : list) {
			JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("dbill_date", glAccvouch.getDbill_date());
			jsonObject.put("i_id", glAccvouch.getCsign()+"-"+glAccvouch.getIno_id());
			jsonObject.put("type","0");//默认失败
			List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(glAccvouch.getIperiod()+""),glAccvouch.getCsign(),glAccvouch.getIno_id());
			
			if(GlAccvouchs==null || GlAccvouchs.size()==0){
				jsonObject.put("msg","审核失败,凭证可能已经被其它客户端删除");
				listObject.add(jsonObject);
				continue;
			}
			if(GlAccvouchs.get(0).getIflag()!=null && GlAccvouchs.get(0).getIflag()==1){
				jsonObject.put("msg","审核失败,凭证已作废");  
				listObject.add(jsonObject);
				continue;
			}
			if(GlAccvouchs.get(0).getIflag()!=null && GlAccvouchs.get(0).getIflag()==2){
				jsonObject.put("msg","审核失败,凭证已标错");  
				listObject.add(jsonObject);
				continue;
			}
			
			if(GlAccvouchs.get(0).getCcheck()!=null && GlAccvouchs.get(0).getCcheck().length()>=0){
				jsonObject.put("msg","审核失败,凭证已审核");  
				listObject.add(jsonObject);
				continue;
			}
			if(GlAccvouchs.get(0).getCbill().equals(req.getSession().getAttribute("username").toString())){
				jsonObject.put("msg","审核失败,制单和审核不能是同一人");  
				listObject.add(jsonObject);
				continue;
			}
			
			Boolean flag=false;//错误检查标记
			String flagmsg="";
			for (int i=0;i<GlAccvouchs.size();i++) {
				GlAccvouch glAccvouchVo=GlAccvouchs.get(i);
				Code code = codeservice.selectByCcode(database+".dbo.code", glAccvouchVo.getCcode());
				if(accinformation.getcValue().equals("1")){
					if(code.getBcash() || code.getBbank()){
						if(glAccvouchVo.getCcashier()==null || glAccvouchVo.getCcashier().length()==0){
							jsonObject.put("msg","审核失败,凭证出纳尚未签字");  
							listObject.add(jsonObject);
							continue outer;
						}
					}
				}
				if(!code.getBend()){//非末级科目
					flag=true;
					flagmsg+="第"+(i+1)+"行分录非末级科目;";
				}
				if(code.getBdept()){//部门核算科目
					String cdept_id = glAccvouchVo.getCdept_id();
					if(cdept_id==null || cdept_id.length()==0){
						flag=true;
						flagmsg+="第"+(i+1)+"行分录科目没有填写部门;";
					}
				}
				if(code.getBperson()){//人员核算科目
					String cperson_id = glAccvouchVo.getCperson_id();
					if(cperson_id==null || cperson_id.length()==0){
						flag=true;
						flagmsg+="第"+(i+1)+"行分录科目没有填写人员;";
					}
				}
				if(code.getBsup()){//供应商核算科目
					String csup_id = glAccvouchVo.getCsup_id();
					if(csup_id==null || csup_id.length()==0){
						flag=true;
						flagmsg+="第"+(i+1)+"行分录科目没有填写供应商;";
					}
				}
				if(code.getBcus()){//客户核算科目
					String ccus_id = glAccvouchVo.getCcus_id();
					if(ccus_id==null || ccus_id.length()==0){
						flag=true;
						flagmsg+="第"+(i+1)+"行分录科目没有填写客户;";
					}
				}
				if(code.getBitem()){//项目核算科目
					String citem_id = glAccvouchVo.getCitem_id();
					if(citem_id==null || citem_id.length()==0){
						flag=true;
						flagmsg+="第"+(i+1)+"行分录科目没有填写项目;";
					}
				}
			}
			if(flag){
				try{
					glAccvouchservice.bjerrorByIperiodAndcsignAndino_id(database+".dbo.Gl_accvouch",GlAccvouchs.get(0),"标错");
					jsonObject.put("msg","审核失败,已标记为错误凭证-("+flagmsg+")");  
					listObject.add(jsonObject);
					continue;
				} catch (Exception e) {
					jsonObject.put("msg","审核失败,数据库错误-标错失败");  
					listObject.add(jsonObject);
					continue;
				}
			}
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",GlAccvouchs.get(0).getIperiod(),GlAccvouchs.get(0).getCsign(),GlAccvouchs.get(0).getIno_id());
			if(zZ_Lock!=null){
				jsonObject.put("msg","审核失败,凭证已被锁定");  
				listObject.add(jsonObject);
				continue;
			}
			try{
				GlAccvouchs.get(0).setCcheck(req.getSession().getAttribute("username").toString());
				glAccvouchservice.audit(req,GlAccvouchs.get(0));
				jsonObject.put("type","1");
				jsonObject.put("msg","审核成功");  
				listObject.add(jsonObject);
			} catch (Exception e) {
				jsonObject.put("msg","审核失败,数据库错误");  
				listObject.add(jsonObject);
			}
		}
		resultObject.put("type","1");//通过权限和互斥
		resultObject.put("resultList",listObject);
		return resultObject;
	}
	
	
	*//**
	 * 取消审核
	 * *//*
	@RequestMapping(params = "canceAudit")
	@ResponseBody
	public JSONObject canceAudit(HttpServletRequest req){
		JSONObject resultObject = new JSONObject(); 
        
        String database=req.getSession().getAttribute("database").toString();
        String userid=req.getSession().getAttribute("User").toString();
        String username=req.getSession().getAttribute("username").toString();
        AccInformation accinformation = accInformationservice.findBycsysidAndcname(database+".dbo.accInformation", "GL", "HTPZUnCheck");
        
        List<HashMap> systems=systemservice.getJurisdiction(database,userid,"ZZ1104");
		if(systems==null || systems.size()==0){
			resultObject.put("msg","当前用户不具备审核凭证的权限");  
			resultObject.put("type","0");
			return resultObject;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			resultObject.put("msg","有互斥功能正在使用中");  
			resultObject.put("type","0");
			return resultObject;
		}
		
		List<JSONObject> listObject = new ArrayList<JSONObject>();
		List<GlAccvouch> list=(List)JSON.parseArray(req.getParameter("selectrow"),GlAccvouch.class);
		for(int i=0;i<list.size();i++){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("dbill_date", list.get(i).getDbill_date());
			jsonObject.put("i_id", list.get(i).getCsign()+"-"+list.get(i).getIno_id());
			jsonObject.put("type","0");//默认失败
			
			List<GlAccvouchVo> GlAccvouchs = glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_Accvouch",Integer.parseInt(list.get(i).getIperiod()+""),list.get(i).getCsign(), list.get(i).getIno_id());
			if(GlAccvouchs==null || GlAccvouchs.size()==0){
				jsonObject.put("msg","消审失败,凭证可能已经被其它客户端删除");  
				listObject.add(jsonObject);
				continue;
			}
			if(GlAccvouchs.get(0).getCcheck()==null || GlAccvouchs.get(0).getCcheck().length()==0){
				jsonObject.put("msg","消审失败,凭证还未审核");  
				listObject.add(jsonObject);
				continue;
			}
			if(GlAccvouchs.get(0).getIbook()==1){
				jsonObject.put("msg","消审失败,凭证已经记账");  
				listObject.add(jsonObject);
				continue;
			}
			if(!GlAccvouchs.get(0).getCcheck().equals(username)){
				if(!accinformation.getcValue().equals("1")){
					jsonObject.put("msg","消审失败,不能消审他人审核的凭证");  
					listObject.add(jsonObject);
					continue;
				}
			}
			ZZ_Lock zZ_Lock=zZ_Lockservice.getLock(database+".dbo.ZZ_Lock",GlAccvouchs.get(0).getIperiod(),GlAccvouchs.get(0).getCsign(),GlAccvouchs.get(0).getIno_id());
			if(zZ_Lock!=null){
				jsonObject.put("msg","消审失败,凭证已被锁定");  
				listObject.add(jsonObject);
				continue;
			}
			try{
				GlAccvouchs.get(0).setCcheck(null);
				glAccvouchservice.audit(req,GlAccvouchs.get(0));
				jsonObject.put("type","1");
				jsonObject.put("msg","消审成功");  
				listObject.add(jsonObject);
			} catch (Exception e) {
				jsonObject.put("msg","消审失败,数据库错误");  
				listObject.add(jsonObject);
			}
		}
		resultObject.put("type","1");//通过权限和互斥
		resultObject.put("resultList",listObject);
		return resultObject;
	}
	*//**
	 * 保存草稿
	 * *//*
	@RequestMapping(params = "saveDraft")
	@ResponseBody
	public JSONObject saveDraft(HttpServletRequest req){
		JSONObject jsonobj=new JSONObject();
		List<GlAccvouchVo> list=(List)JSON.parseArray(req.getParameter("rows"),GlAccvouchVo.class);
		String database=req.getSession().getAttribute("database").toString();
		String userid=req.getSession().getAttribute("userid").toString();
		try{
			gl_VouchDraftService.saveDraft(database,list,userid);
			jsonobj.put("type", "1");
			jsonobj.put("msg", "草稿保存成功");
		}catch(Exception e) {
			e.printStackTrace();
			jsonobj.put("type", "-1");
			jsonobj.put("msg", "草稿保存失败");
		}
		return jsonobj;
	}
	
	*//**
	 * 打开草稿
	 * *//*
	@RequestMapping(params = "openDraft")
	@ResponseBody
	public JSONObject openDraft(HttpServletRequest req){
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("type", "-1");
		String database=req.getSession().getAttribute("database").toString();
		String userid=req.getSession().getAttribute("userid").toString();
		List<HashMap> systems=systemservice.getJurisdiction(database,userid,"ZZ1101");
		if(systems==null || systems.size()==0){
			jsonObject.put("msg","没有增加凭证的权限");  
			return jsonObject;
		}
		List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
		if(dsigns.size()==0 || dsigns==null){
			jsonObject.put("msg","凭证类别没有设置");  
			return jsonObject;
		}
		List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
		if(listmap.size()!=0){
			jsonObject.put("msg", "有互斥功能正在使用中");
			return jsonObject;
		}
		ArrayList<GL_VouchDraft> list=gl_VouchDraftService.getGl_VouchDraft(database,userid);
		// gl_VouchDraftService.delvoucher(database,userid);
		jsonObject.put("type","1");
		jsonObject.put("data",list);
		jsonObject.put("userid",userid);
		return jsonObject;
	}
	*//**
	 * 查询草稿是否存在
	 * *//*
	@RequestMapping(params = "findDraft")
	@ResponseBody
	public JSONObject findDraft(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String username=req.getSession().getAttribute("User").toString();
		ArrayList<GL_VouchDraft> gl_VouchDrafts=gl_VouchDraftService.selectBycuserid(database+".dbo.GL_vouchdraft",username);
			JSONObject result=new JSONObject();
			if(gl_VouchDrafts==null || gl_VouchDrafts.size()==0){
				result.put("type", "-1");
			}else{
				result.put("type", "1");
			}
		return result;
	}
		*//**
		 * 凭证保存
		 * *//*
		@RequestMapping(params = "vouchersave")
		@ResponseBody
		public JSONObject vouchersave(HttpServletRequest req){
			List<Integer> indexs = new ArrayList<Integer>();
			JSONObject jsonObject = new JSONObject(); 
	        jsonObject.put("type", "1");//默认成功
	        String msg="";//返回提示信息
			
			List<GlAccvouchVo> list=(List)JSON.parseArray(req.getParameter("arrmap"),GlAccvouchVo.class);
			String database=req.getSession().getAttribute("database").toString();
			String username=req.getSession().getAttribute("User").toString();
			String addORupdate = req.getParameter("addORupdate");//0增加1修改
			
		try {
			if(addORupdate.equals("0")){//校验添加权限(修改权限已校验)
				List<HashMap> systems=systemservice.getJurisdiction(database,username,"ZZ1101");
				if(systems==null || systems.size()==0){
					jsonObject.put("msg","保存失败,当前用户不具备添加凭证的权限");  
					jsonObject.put("type", "0");
					return jsonObject;
				}
			}
			GlAccvouchVo listGlAccvouchVo=null;
			for (GlAccvouchVo glAccvouchVo : list) {
				if(glAccvouchVo!=null && glAccvouchVo.getCcode()!=null && glAccvouchVo.getCcode().length()>0){
					listGlAccvouchVo=glAccvouchVo;
					break;
				}
			}
			if(listGlAccvouchVo==null){
				jsonObject.put("msg","保存失败,请先录入凭证");  
				jsonObject.put("type", "0");
				return jsonObject;
			}
			
			String Dbill_date=listGlAccvouchVo.getDbill_date();//凭证录入日期
			Integer iperiod=ua_periodService.getIperiod(database,Dbill_date);//会记期间.
			GLmend gLmend=GLmendservice.findByIperiod(database+".dbo.gl_mend",iperiod);//获取该月份是否月结
			
			if(gLmend==null){
				msg+="当前日期对应会计期间不存在*";
				jsonObject.put("type", "0");
			}else{
				if(addORupdate.equals("1")){//修改 -不可以修改所在会记期间(月份)
					if(!(listGlAccvouchVo.getIperiod()+"").equals(iperiod+"")){
						msg+="凭证所在月份不能修改*";
						jsonObject.put("type", "0");
					}
				}
				
				AccInformation accinformation13month = accInformationservice.findBycname(database+".dbo.accinformation","HTPZ13Month");
				if (accinformation13month!=null) {
					if(accinformation13month.getcValue().equals("1")){//13期凭证
						String dbdate=Dbill_date.substring(Dbill_date.indexOf("-")+1);
						String[] arr = dbdate.split("-");
						if(arr[0].equals("12") && arr[1].equals("31") && gLmend.getBflag()){//满足日期为12/31,并且12月已月结
							//13期操作
							iperiod=13;
						}else{
							if(gLmend.getBflag()){
								msg+="凭证日期所在会计期间已经月末结账*";
								jsonObject.put("type", "0");
							}
						}
					}else{
						if(gLmend.getBflag()){
							msg+="凭证日期所在会计期间已经月末结账*";
							jsonObject.put("type", "0");
						}
					}
				}
			}
			
			
			boolean update_inoid_flag=false;
			String update_inoid = req.getParameter("update_inoid");//修改凭证 原凭证号
			if(update_inoid!=null && update_inoid.length()>0){
				if(listGlAccvouchVo.getIno_id()!=Short.parseShort(update_inoid)){
					update_inoid_flag=true;
				}
			}
			//凭证号校验
			if(addORupdate.equals("0") || update_inoid_flag){// 增加 || 修改-凭证号改变
				List<GlAccvouchVo> glAccvouchs= glAccvouchservice.selectByIperiodAndcsignAndino_id(database+".dbo.gl_accvouch",iperiod,listGlAccvouchVo.getCsign(),listGlAccvouchVo.getIno_id());
				if(glAccvouchs.size()>0){
					Short ino_id2=glAccvouchservice.findMaxIno_idByIperiodAndCsign(database+".dbo.GL_accvouch",iperiod,listGlAccvouchVo.getCsign());
					ino_id2=(short)(ino_id2+1);
					String sinoid=ino_id2+"";
					while(true){
						if(sinoid.length()<4){
							sinoid="0"+sinoid;
						}else{
							break;
						}
					}
					msg+="该凭证号已使用,建议使用新的凭证号("+sinoid+")*";
					jsonObject.put("type", "0");
					jsonObject.put("inoid", sinoid);
				}
			}
			
				List<dsign> dsigns = dsignservice.selectAll(database+".dbo.dsign");
				if(dsigns.size()==0 || dsigns==null){
					msg+="凭证类别没有设置*";
					jsonObject.put("type", "0");
				}
				List<Map<String, Object>> listmap=glAccvouchservice.findExclusion(database+".dbo.HT_LockUse");
				if(listmap.size()!=0){
					msg+="有互斥功能正在使用中*";
					jsonObject.put("type", "0");
				}
				
				AccInformation accinformationMustSett = accInformationservice.findBycname(database+".dbo.accinformation","HTPZMustSett");
				AccInformation accinformationCashItem = accInformationservice.findBycname(database+".dbo.accinformation","HTPZCashItem");
				//保存后自动新增
				AccInformation HTPZAutoAdd = accInformationservice.findBycname(database+".dbo.accinformation","HTPZAutoAdd");
				
				
					Integer ctext1 = listGlAccvouchVo.getCtext1().getBytes("GBK").length;
					Integer ctext2 = listGlAccvouchVo.getCtext2().getBytes("GBK").length;
						if(ctext1>10){
							msg+="凭证备注文本1最多只能5个汉字或10个字母数字*";
							jsonObject.put("type", "0");
						}
						if(ctext2>10){
							msg+="凭证备注文本2最多只能5个汉字或10个字母数字*";
							jsonObject.put("type", "0");
						}
					Short idoc=listGlAccvouchVo.getIdoc()==null?0:listGlAccvouchVo.getIdoc();
					if(idoc<0){
						msg+="附单据数不能小于零*";
						jsonObject.put("type", "0");
					}
					
					//科目限制方式查询
					dsign ds=dsignservice.selectBycsign(database+".dbo.dsign",listGlAccvouchVo.getCsign());
					//科目限制方式对应科目
					dsigns dss=null;
					List<dsigns> dsslist=dsignsservice.selectBycsign(database+".dbo.dsigns",listGlAccvouchVo.getCsign());
					if(dsslist!=null && dsslist.size()>0){
						dss=dsslist.get(0);//科目存在不是一个的情况 后续要改
					}
					Code code = codeservice.selectByCcode(database+".dbo.code", dss==null?null:dss.getCcode());
					boolean borrow=false;
					boolean lend=false;
					boolean flag=false;//标记凭证限制科目是否存
					boolean Ystatistics=false;//标记是否存在统计类科目
					boolean Nstatistics=false;//标记是否存在非统计类科目
					BigDecimal borrowsum=new BigDecimal("0");
					BigDecimal lendsum=new BigDecimal("0");
					dsign dsign = dsignservice.selectBycsign(database+".dbo.dsign", listGlAccvouchVo.getCsign());
					Byte isignseq = dsign.getIsignseq();
					
					List<CodeV> findAll = codeservice.findAll(database+".dbo.code");
					HashMap<String,CodeV> codemap=new HashMap<String,CodeV>();
					for (CodeV codeV : findAll) {
						codemap.put(codeV.getCcode(), codeV);
					}
					List<Department> selectDepartment = departmentService.selectDepartment(database+".dbo.Department");
					HashMap<String,Department> Depmap=new HashMap<String,Department>();
					for (Department department : selectDepartment) {
						Depmap.put(department.getcDepCode(), department);
					}
					List<Person> all = personservice.getAll(database+".dbo.Person");
					HashMap<String,Person> persmap=new HashMap<String,Person>();
					for (Person person : all) {
						persmap.put(person.getcPersonCode(), person);
					}
					List<Customer> all2 = customerService.getAll(database+".dbo.Customer");
					HashMap<String,Customer> custmap=new HashMap<String,Customer>();
					for (Customer customer : all2) {
						custmap.put(customer.getCcuscode(), customer);
					}
					List<Vendor> all3 = vendorservice.getAll(database+".dbo.Vendor");
					HashMap<String,Vendor> vendmap=new HashMap<String,Vendor>();
					for (Vendor vendor : all3) {
						vendmap.put(vendor.getcVenCode(), vendor);
					}
					List<HT_GLItem> findAll2 = hT_GLItemService.findAll(database+".dbo.hT_GLItem");
					HashMap<String,HT_GLItem> hT_GLImap=new HashMap<String,HT_GLItem>();
					for (HT_GLItem ht_GLItem : findAll2) {
						hT_GLImap.put(ht_GLItem.getCitemcode(), ht_GLItem);
					}
					for(int i=0;i<list.size();i++){
						if(list.get(i)==null || list.get(i).getCcode()==null  || list.get(i).getCcode().equals("")){
							continue;
						}
						if(iperiod!=null){
							list.get(i).setIperiod((byte)iperiod.intValue());
						}
						list.get(i).setIsignseq(isignseq);
						list.get(i).setIbook((byte)0);
						list.get(i).setInid((short)(i+1));
						list.get(i).setCbill(req.getSession().getAttribute("username").toString());
						if(	(list.get(i).getMd()==null || list.get(i).getMd().compareTo(new BigDecimal("0"))==0)&&
							(list.get(i).getMc()==null || list.get(i).getMc().compareTo(new BigDecimal("0"))==0)){
							msg+="第"+(i+1)+"行借贷方金额不能都为空或0*";
							indexs.add(i+1);
							jsonObject.put("type", "0");
						}
						
						if(list.get(i).getCdigest()==null || list.get(i).getCdigest().equals("") || list.get(i).getCdigest().getBytes("GBK").length>60){
								msg+="第"+(i+1)+"行摘要不能为空,并且不能超过60个字符(至多30个中文或60个字母数字)*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
						}
						
						if(list.get(i).getCcode().startsWith("9")){
							Ystatistics=true;
						}else{
							Nstatistics=true;
						}
						
						borrowsum=borrowsum.add(list.get(i).getMd()==null?new BigDecimal("0"):list.get(i).getMd());
						lendsum=lendsum.add(list.get(i).getMc()==null?new BigDecimal("0"):list.get(i).getMc());
						if(dss!=null && list.get(i).getCcode().equals(dss.getCcode())){
							flag=true;
							if(list.get(i).getMd()!=null && list.get(i).getMd().compareTo(new BigDecimal("0"))!=0){
								borrow=true;
							}
							if(list.get(i).getMc()!=null && list.get(i).getMc().compareTo(new BigDecimal("0"))!=0){
								lend=true;
							}
						}
						String codetext=list.get(i).getCcode();
						// codetext=codetext.substring(codetext.indexOf("[")+1,codetext.indexOf("]"));
						// list.get(i).setCcode(codetext);
						//Code glcode = codeservice.selectByCcode(database+".dbo.code",list.get(i).getCcode() );
						Code glcode = codemap.get(list.get(i).getCcode());
						if(!glcode.getBend()){
							msg+="第"+(i+1)+"行科目不是末级*";
							indexs.add(i+1);
							jsonObject.put("type", "0");
						}
						if(glcode!=null && glcode.getCexch_name()!=null && glcode.getCexch_name().length()>0){//外币科目
							if(list.get(i).getNfrat()==null ){
								msg+="第"+(i+1)+"行请输入汇率*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}
							if(list.get(i).getMd_f()==null){
								msg+="第"+(i+1)+"行请输入金额*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}
						}
						if(glcode!=null && glcode.getBdept()){//部门科目
							String cdept_id = list.get(i).getCdept_id();
							if(cdept_id==null || cdept_id.equals("")){
								msg+="第"+(i+1)+"行请选择部门*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}else{
								//判断部门是否合法（jsj）
								//List<Department> department=departmentService.selectBycDepCode(database+".dbo.Department",cdept_id.substring(cdept_id.indexOf("[")+1,cdept_id.indexOf("]")));
								Department department=Depmap.get(cdept_id.substring(cdept_id.indexOf("[")+1,cdept_id.indexOf("]")));
								if(department!=null){
									if(department.getcDepName().equals(cdept_id.substring(cdept_id.indexOf("]")+1,cdept_id.length()))){
										list.get(i).setCdept_id(cdept_id.substring(cdept_id.indexOf("[")+1,cdept_id.indexOf("]")));
									}else{
										msg+="第"+(i+1)+"行请选择正确的部门*";
										indexs.add(i+1);
										jsonObject.put("type", "0");
									}
								}else{
									msg+="第"+(i+1)+"行请选择正确的部门*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}
						if(glcode!=null && glcode.getCmeasure()!=null && glcode.getCmeasure().length()>0){//数量科目
							Double nd_s = list.get(i).getNd_s();
							if(nd_s==null){
								msg+="第"+(i+1)+"行请输入单位数量*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}
						}
						if(glcode!=null && glcode.getBperson()){//个人科目
							String cperson_id = list.get(i).getCperson_id();
							if(cperson_id==null || cperson_id.equals("")){
								msg+="第"+(i+1)+"行请选择人员*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}else{
								//判断人员是否合法（jsj）
								//Person person=personservice.selectBycPersonCode(database+".dbo.Person",cperson_id.substring(cperson_id.indexOf("[")+1,cperson_id.indexOf("]")));
								Person person=persmap.get(cperson_id.substring(cperson_id.indexOf("[")+1,cperson_id.indexOf("]")));
								if(person!=null){
									if(person.getcPersonName().equals(cperson_id.substring(cperson_id.indexOf("]")+1,cperson_id.length()))){
										list.get(i).setCperson_id(cperson_id.substring(cperson_id.indexOf("[")+1,cperson_id.indexOf("]")));
									}else{
										msg+="第"+(i+1)+"行请选择正确的人员*";
										indexs.add(i+1);
										jsonObject.put("type", "0");
									}
								}else{
									msg+="第"+(i+1)+"行请选择正确的人员*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}
						if(glcode!=null && glcode.getBcus()){//客户科目
							String ccus_id = list.get(i).getCcus_id();
							if(ccus_id==null || ccus_id.equals("")){
								msg+="第"+(i+1)+"行请选择客户*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}else{
								//判断客户是否合法（jsj）
								//Customer customer=customerService.selectBycCusCode(database+".dbo.Customer",ccus_id.substring(ccus_id.indexOf("[")+1,ccus_id.indexOf("]")));
								Customer customer=custmap.get(ccus_id.substring(ccus_id.indexOf("[")+1,ccus_id.indexOf("]")));
								if(customer!=null){
									if(customer.getCcusname().equals(ccus_id.substring(ccus_id.indexOf("]")+1,ccus_id.length()))){
										list.get(i).setCcus_id(ccus_id.substring(ccus_id.indexOf("[")+1,ccus_id.indexOf("]")));
									}else{
										msg+="第"+(i+1)+"行请选择正确的客户*";
										indexs.add(i+1);
										jsonObject.put("type", "0");
									}
								}else{
									msg+="第"+(i+1)+"行请选择正确的客户*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}
						if(glcode!=null && glcode.getBsup()){//供应商科目
							String csup_id = list.get(i).getCsup_id();
							if(csup_id==null || csup_id.equals("")){
								msg+="第"+(i+1)+"行请选择供应商*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}else{
								//判断供应商是否合法（jsj）
								//Vendor vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor",csup_id.substring(csup_id.indexOf("[")+1,csup_id.indexOf("]")));
								Vendor vendor=vendmap.get(csup_id.substring(csup_id.indexOf("[")+1,csup_id.indexOf("]")));
								if(vendor!=null){
									if(vendor.getcVenName().equals(csup_id.substring(csup_id.indexOf("]")+1,csup_id.length()))){
										list.get(i).setCsup_id(csup_id.substring(csup_id.indexOf("[")+1,csup_id.indexOf("]")));
									}else{
										msg+="第"+(i+1)+"行请选择正确的供应商*";
										indexs.add(i+1);
										jsonObject.put("type", "0");
									}
								}else{
									msg+="第"+(i+1)+"行请选择正确的供应商*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}
						if(glcode!=null && glcode.getBitem()){//项目科目
							String citem_id = list.get(i).getCitem_id();
							if(citem_id==null || citem_id.equals("")){
								msg+="第"+(i+1)+"行请选择项目*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}else{
								//判断项目是否合法（jsj）
								//HT_GLItem hT_GLItem=hT_GLItemService.selectBycitemcode(database+".dbo.hT_GLItem",citem_id.substring(citem_id.indexOf("[")+1,citem_id.indexOf("]")));
								HT_GLItem hT_GLItem=hT_GLImap.get(citem_id.substring(citem_id.indexOf("[")+1,citem_id.indexOf("]")));
								if(hT_GLItem!=null){
									if(hT_GLItem.getCitemname().equals(citem_id.substring(citem_id.indexOf("]")+1,citem_id.length()))){
										list.get(i).setCitem_id(citem_id.substring(citem_id.indexOf("[")+1,citem_id.indexOf("]")));
									}else{
										System.out.println(hT_GLItem.getCitemname()+"1111111"+citem_id.substring(citem_id.indexOf("]")+1,citem_id.length()));
										msg+="第"+(i+1)+"行请选择正确的项目*";
										indexs.add(i+1);
										jsonObject.put("type", "0");
									}
								}else{
									System.out.println("222222");
									msg+="第"+(i+1)+"行请选择正确的项目*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}
						if(glcode!=null && glcode.getBbank()){//银行科目
							String csettle = list.get(i).getCsettle();
							if(csettle==null || csettle.equals("")){
								if(accinformationMustSett.getcValue().equals("1")){
									msg+="第"+(i+1)+"行请选择结算方式*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}else{
								list.get(i).setCsettle(csettle.substring(csettle.indexOf("[")+1,csettle.indexOf("]")));
								if(list.get(i).getCn_id()==null || list.get(i).getCn_id().equals("")){
									msg+="第"+(i+1)+"行请输入票据号*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}else if(list.get(i).getCn_id().length()>10){
									msg+="第"+(i+1)+"行票据号长度不能大于10*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
								if(list.get(i).getDt_date()==null || list.get(i).getDt_date().equals("")){
									msg+="第"+(i+1)+"行请输入结算日期*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}
						//if(glcode!=null && glcode.getBcash()){//测试
						if(glcode!=null && glcode.getbCashItem()){//现金流科目
							List<ZZ_CashTable> ZZ_CashTables = list.get(i).getCashflow();
							if(ZZ_CashTables==null || ZZ_CashTables.size()==0){
								if(accinformationCashItem.getcValue().equals("1")){
									msg+="第"+(i+1)+"行请录入现金流量*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}else{
								BigDecimal cdshmd=new BigDecimal("0");
								BigDecimal cdshmc=new BigDecimal("0");
								for (int j=0;j<ZZ_CashTables.size()-2;j++) {
									ZZ_CashTable zz_CashTable=ZZ_CashTables.get(j);
									if(zz_CashTable.getMd()!=null){
										cdshmd = cdshmd.add(zz_CashTable.getMd());
									}
									if (zz_CashTable.getMc()!=null) {
										cdshmc = cdshmc.add(zz_CashTable.getMc());
									}
								}
								BigDecimal recmd = list.get(i).getMd()==null?new BigDecimal("0"):list.get(i).getMd();
								BigDecimal recmc = list.get(i).getMc()==null?new BigDecimal("0"):list.get(i).getMc();
								if(!(cdshmd.compareTo(recmd)==0 && cdshmc.compareTo(recmc)==0)){
									msg+="第"+(i+1)+"行现金流项目借贷金额总计与该条分录借贷金额不符*";
									indexs.add(i+1);
									jsonObject.put("type", "0");
								}
							}
						}else{
							if(list.get(i).getCashflow()!=null && list.get(i).getCashflow().size()>0){
								msg+="第"+(i+1)+"行参数错误,非现金流科目存在现金流参数*";
								indexs.add(i+1);
								jsonObject.put("type", "0");
							}
						}
					}
					//循环结束
					if(!(borrowsum.compareTo(lendsum)==0)){
						msg+="借贷金额总计必须一致*";
						jsonObject.put("type", "0");
					}
					if(Ystatistics && Nstatistics){
						msg+="凭证中不可以同时有统计类和非统计类科目*";
						jsonObject.put("type", "0");
					}
					if(ds.getItype()==1){//借方必有
						if(!borrow && code!=null){
							msg+="借方缺少必要科目("+dss.getCcode()+")"+code.getCcode_name()+"*";
							jsonObject.put("type", "0");
						}
					}else if(ds.getItype()==2){//贷方必有
						if(!lend && code!=null){
							msg+="贷方缺少必要科目("+dss.getCcode()+")"+code.getCcode_name()+"*";
							jsonObject.put("type", "0");
						}
					}else if(ds.getItype()==3){//凭证必无
						if(flag && code!=null){
							msg+="凭证录入中不可有科目("+dss.getCcode()+")"+code.getCcode_name()+"*";
							jsonObject.put("type", "0");
						}
					}else if(ds.getItype()==4){//凭证必有
						if(!flag && code!=null){
							msg+="凭证录入中必须有科目("+dss.getCcode()+")"+code.getCcode_name()+"*";
							jsonObject.put("type", "0");
						}
					}
					String type=jsonObject.get("type").toString();
					if(type.equals("1")){//无错误信息
							if(addORupdate.equals("0")){
								glAccvouchservice.addList(database,list);
							}else if(addORupdate.equals("1")){
								glAccvouchservice.updateList(database,list,update_inoid);
								zZ_Lockservice.del(database+".dbo.ZZ_Lock",listGlAccvouchVo);//删除凭证锁
							}
							msg="凭证保存提交成功";
					}
					jsonObject.put("HTPZAutoAdd",HTPZAutoAdd.getcValue());
			} catch (Exception e) {
				e.printStackTrace();
				msg="凭证保存提交失败(异常)";
				jsonObject.put("type", "0");
			}
			jsonObject.put("msg",msg);
			jsonObject.put("indexs", indexs);
			return jsonObject;
		}
		
	*//**
	 * 编码规则查询
	 * *//*
	public char[] getCodingruleBykword(String database,String keyword){
		List<GradeDef> gradeDefs=gradeDefservice.selectCodingruleBYkeyword(database+".dbo.GradeDef",keyword);
		return gradeDefs.get(0).getCODINGRULE().toCharArray();
	}
}
*/