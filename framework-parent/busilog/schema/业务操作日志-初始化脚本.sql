--------------------------------------------------------
--  DDL for Table T_BUSI_OPER_LOG_TD 业务操作日志表
--------------------------------------------------------
CREATE TABLE "T_BUSI_OPER_LOG_TD" 
(	
"LOG_ID" VARCHAR2(36 BYTE) NOT NULL ENABLE, 
"BUSI_CODE" VARCHAR2(36 BYTE), 
"ETP_ID" VARCHAR2(36 BYTE) NOT NULL ENABLE, 
"BUSI_TYPE" VARCHAR2(32 BYTE) NOT NULL ENABLE, 
"OPER_TYPE" VARCHAR2(32 BYTE) NOT NULL ENABLE, 
"TRAN_CODE" VARCHAR2(128 BYTE) NOT NULL ENABLE, 
"OPER_ABST" VARCHAR2(256 BYTE), 
"OPER_RESU" VARCHAR2(128 BYTE) NOT NULL ENABLE, 
"OPER_TIME" VARCHAR2(26 BYTE) NOT NULL ENABLE, 
"OPERATOR_ID" VARCHAR2(36 BYTE) NOT NULL ENABLE, 
"CAN_DELETE" VARCHAR2(2 BYTE) NOT NULL ENABLE, 
"KEEP_TIME" VARCHAR2(26 BYTE), 
"NOTE" VARCHAR2(128 BYTE), 
CONSTRAINT "PK_T_BUSI_OPER_LOG_TD" PRIMARY KEY ("LOG_ID")
) ;

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."LOG_ID" IS '日志ID';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."BUSI_CODE" IS '业务编号';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."ETP_ID" IS '企业ID';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."BUSI_TYPE" IS '业务类型';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."OPER_TYPE" IS '操作类型';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."TRAN_CODE" IS '交易代码';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."OPER_ABST" IS '操作摘要';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."OPER_RESU" IS '操作结果';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."OPER_TIME" IS '操作时间';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."OPERATOR_ID" IS '操作人ID';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."CAN_DELETE" IS '是否可删';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."KEEP_TIME" IS '保留期限';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_TD"."NOTE" IS '备注';

COMMENT ON TABLE "T_BUSI_OPER_LOG_TD"  IS '业务操作日志表';


--------------------------------------------------------
--  DDL for Table T_BUSI_OPER_COND_TD 业务操作条件记录表
--------------------------------------------------------

CREATE TABLE "T_BUSI_OPER_COND_TD" 
(	"COND_ID" VARCHAR2(36 BYTE) NOT NULL ENABLE, 
"LOG_ID" VARCHAR2(36 BYTE), 
"ABST" VARCHAR2(256 BYTE) NOT NULL ENABLE, 
"COND_JSON" CLOB, 
"JSON_CLASS" VARCHAR2(256 BYTE), 
 CONSTRAINT "PK_T_BUSI_OPER_COND_TD" PRIMARY KEY ("COND_ID")
) ; 

COMMENT ON COLUMN "T_BUSI_OPER_COND_TD"."COND_ID" IS '条件ID';

COMMENT ON COLUMN "T_BUSI_OPER_COND_TD"."LOG_ID" IS '日志ID';

COMMENT ON COLUMN "T_BUSI_OPER_COND_TD"."ABST" IS '摘要';

COMMENT ON COLUMN "T_BUSI_OPER_COND_TD"."COND_JSON" IS '条件JSON';

COMMENT ON COLUMN "T_BUSI_OPER_COND_TD"."JSON_CLASS" IS 'JSON类名';

COMMENT ON TABLE "T_BUSI_OPER_COND_TD"  IS '业务操作条件记录表';


--------------------------------------------------------
--  DDL for Table T_BUSI_OPER_DATA_TD 业务操作数据历史表
--------------------------------------------------------

CREATE TABLE "T_BUSI_OPER_DATA_TD" 
(	"HIS_ID" VARCHAR2(36 BYTE) NOT NULL ENABLE, 
"LOG_ID" VARCHAR2(36 BYTE), 
"DATA_ABST" VARCHAR2(256 BYTE) NOT NULL ENABLE, 
"TAB_NAME" VARCHAR2(64 BYTE), 
"BUSI_CODE" VARCHAR2(36 BYTE), 
"DATA_JSON" CLOB, 
"JSON_CLASS" VARCHAR2(256 BYTE), 
 CONSTRAINT "PK_T_BUSI_OPER_DATA_TD" PRIMARY KEY ("HIS_ID")
) ;


COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."HIS_ID" IS '历史数据ID';

COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."LOG_ID" IS '日志ID';

COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."DATA_ABST" IS '摘要';

COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."TAB_NAME" IS '表名';

COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."BUSI_CODE" IS '业务编号';

COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."DATA_JSON" IS '数据JSON';

COMMENT ON COLUMN "T_BUSI_OPER_DATA_TD"."JSON_CLASS" IS 'JSON类名';

COMMENT ON TABLE "T_BUSI_OPER_DATA_TD"  IS '业务操作数据历史表';

--------------------------------------------------------
--  DDL for Table T_BUSI_OPER_LOG_TD 业务操作日志参数表
--------------------------------------------------------

CREATE TABLE "T_BUSI_OPER_LOG_PARAM_TC" 
(	"PARAM_ID" VARCHAR2(36 BYTE) NOT NULL ENABLE, 
"NAME" VARCHAR2(64 BYTE) NOT NULL ENABLE, 
"CODE" VARCHAR2(32 BYTE) NOT NULL ENABLE, 
"SORT" NUMBER(*,0), 
"PARA_CODE" VARCHAR2(36 BYTE), 
"DEL_FLG" CHAR(1 BYTE), 
"CREATE_TIME" VARCHAR2(26 BYTE), 
"UPDATE_TIME" VARCHAR2(26 BYTE), 
"CREATE_MAN" VARCHAR2(36 BYTE), 
"LAST_MODI_MAN" VARCHAR2(36 BYTE), 
 CONSTRAINT "PK_T_BUSI_OPER_LOG_PARAM_TC" PRIMARY KEY ("PARAM_ID")
) ;

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."PARAM_ID" IS '参数ID';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."NAME" IS '名称';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."CODE" IS '编码';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."SORT" IS '排序';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."PARA_CODE" IS '父参数编码';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."DEL_FLG" IS '删除标识';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."CREATE_TIME" IS '创建时间';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."UPDATE_TIME" IS '更新时间';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."CREATE_MAN" IS '创建人';

COMMENT ON COLUMN "T_BUSI_OPER_LOG_PARAM_TC"."LAST_MODI_MAN" IS '最后修改人';

COMMENT ON TABLE "T_BUSI_OPER_LOG_PARAM_TC"  IS '业务操作日志参数表';

--------------------------------------------------------
--  DATA for Table T_BUSI_OPER_LOG_PARAM_TC 业务操作日志参数表
--------------------------------------------------------
DELETE FROM T_BUSI_OPER_LOG_PARAM_TC;
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('DD6FFB167F59426DB23DDADCF5F73AFB','业务类型','BUSI_TYPE',1,null,'N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F6AFE52E24A64E4BB6EFE985768C4B71','公共','COMMON',1,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('2BD4F2A640A749D1AEE6DE39577DA5D3','登录','LOGIN',2,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('1F7DAF037497433ABD70342C31D4EF2A','权限','AUTH',3,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('E12AD00D00CF464A9EADC33FCAC3BBC0','薪资档案','XZDA',4,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('D4CA5869683741E18D3864B7D3297E5C','薪资组','XZZ',5,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('E9D647E5FF4940F083D1B4816531C90F','薪资计算','XZJS',6,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('E7D17D6A8A534F9E89CEA5883AFE499D','代发记录','DFJL',7,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('41042B1060F842A7A53D009A2B0FD22A','社保','SB',8,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('28506AF9A9824C0083AD507A7DC325D0','工资条','GZT',9,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('546BA8D26FE44F05B2EF4F2A82D81243','报表','BB',10,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('EE221E744CFB4FE4BBAFFA36322FA18C','年终奖','NZJ',11,'BUSI_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('BBC5352729344F9FA22D189098185074','操作类型','OPER_TYPE',2,null,'N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('E0AE1DEF731D491798C05A7B535A94BE','导入数据','COMMON_IMPORT_DATA',1,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F7AA3349B7294491B3A976EDE02610C3','下载数据','COMMON_EXPORT_DATA',2,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('94604D947EBF416D9600136F69811A66','登录','LOGIN_LOGIN',3,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('0AC9384FDC6147398467E902946D1BB0','设置子管理员','AUTH_SZZGLY',4,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('41CA3DF1407B4BFAA4BAC364D3E586D4','主管理员权限转移','AUTH_ZGLYQZZY',5,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('5FC7233151A24254BA7DF282B45D65BF','保存自定义薪资档案字段','XZDA_BCZDYXZDAZD',6,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('267B5530D22649B096115ED71DD15C53','撤销调薪记录','XZDA_CXTXJL',7,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('BD6F0C58F7284E43AF8DDEFA28F8E806','批量撤销调薪','XZDA_PLCXTX',8,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('57D16585B8FE45FFB5DF827766320CC6','新建薪资组','XZZ_XJXZZ',9,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F15F6D282A2C4FFBA281489141EABC46','调整算薪人员','XZZ_TZSXRY',10,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('AD5ED911904B41E084D4E290F9292D9F','加入薪资组','XZZ_JRXZZ',11,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('EBD702D911ED4C6E95C9B608639C728D','重新同步算薪人员','XZZ_CXTBSXRY',12,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('C7BA2551332E48EDBAF37B5B6671E8E6','修改固定算薪人员','XZZ_XGGDSXRY',13,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('9C21EC3341E94F5C80AE4BBEE6918A9C','基本设置','XZZ_JBSZ',14,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('CA3510E465794F7B83CA967FFDC9F494','修改薪资项','XZZ_XGXZX',15,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('DAF643DEEC1642399660F628BDA140C2','计税规则设置','XZZ_JSGZSZ',16,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('FF94F40E067348319CD8D1982769EA36','恢复薪资组','XZZ_HFXZZ',17,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('B41C95FA0C1748D4B2BF2962E2FE3596','停用薪资组','XZZ_TYXZZ',18,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('29435812F0EB4C35ABBB167C841F0D7B','彻底删除薪资组','XZZ_CDSCXZZ',19,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('6D0036FD4AF9431D86645200FB7958D5','计算工资','XZJS_JSGZ',20,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('3D08E9D28A384DDFA376417E0C53BEBE','同步考勤','XZJS_TBKQ',21,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('2F400E48003B4994A2CA36DCDAB8E527','同步社保公积金','XZJS_TBSVGJJ',22,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('AD34B97B8389460BB75E6DAF3B18A2B6','个税计算','XZJS_GSJS',23,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('5230EB228B994BF5B4BB3C92B4CD3879','生成银行代发','XZJS_SCYHDF',24,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F9DF25D1ED8C4890B4F60E785BFF93D2','失败一键重发','DFJL_SBYJCF',25,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('9ECD1A2BAF9D489BA89EF138C8965EC8','重新生成代发','DFJL_CXSCDF',26,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('94CB23772829406E8C6DE21720CE3DA0','新增参保方案','SB_XZCBFA',27,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('2139F0457DA842AB9DC417BD4CC5A6BD','调整参保方案','SB_TZCBFA',28,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F55C03F4A426493CB95213CD4989888A','删除参保方案','SB_SCCBFA',29,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('FB8B4C22B1454A7AB44EEEA67DD2F286','新增、调整投保','SB_XZTZTB',30,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F2D1345E011740A281223FCAD29D9210','员工停保','SB_YGTB',31,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('932E18D8AC454E05B23F21B0F9D81E7A','生成月结账单','SB_SCYJZD',32,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('608222A96B054D4C8F478D95026751C5','重新生成月结账单','SB_CXSCYJZD',33,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('767C6113702B49FD83035F337E2F9889','编辑员工账单信息','SB_BJYGZDXX',34,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('BAA733D32DAF4AF8A16CDF26AC6483E5','撤销参保记录','SB_CXCBJL',35,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('DC6504C9190A4A3A9A60D8069E8354E3','由薪资组生成工资条','GZT_YXZZSCGZT',37,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('E32F5AA0DBC346DF854228CFCF8E5232','删除工资条','GZT_SCGZT',38,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('E06FEAAE7D28435593608BCA671440A4','发送工资条','GZT_FSGZT',39,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('B34E5E74A92340DF9356553C95069D8C','撤回工资条','GZT_CHGZT',40,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('4503064566274C65A9D41DF5DA832F4F','修改工资条设置','GZT_XGGZTSZ',41,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('F65A80FEBEDA4E87A30DC7659F54D1BB','修改人力成本设置','BB_XGRLCBSZ',42,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('46D86735A04047D2B22B528AACD019EF','修改人力成本统计项','BB_XGRLCBTJX',43,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('9240E9070E094E60B22A2209DC130C53','更新统计数据','BB_GXTJSJ',44,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('477B5ABC2F7340C28302010A1E7C38C3','删除年终奖','NZJ_SCNZJ',45,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');
Insert into T_BUSI_OPER_LOG_PARAM_TC (PARAM_ID,NAME,CODE,SORT,PARA_CODE,DEL_FLG,CREATE_TIME,UPDATE_TIME,CREATE_MAN,LAST_MODI_MAN) values ('82FA194410A442B48E98AD6E61D2DF45','生成年终奖代发','NZJ_SCNZJDF',46,'OPER_TYPE','N','2021-08-12 14:09:43','2021-08-12 14:09:43','admin','admin');

commit;