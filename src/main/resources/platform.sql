-- 创建用户表
CREATE TABLE `sys_user`(
	 `user_id` int(11) NOT NULL AUTO_INCREMENT  COMMENT '用户id',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名称',
  `telephone` varchar(13) NOT NULL DEFAULT '' COMMENT '手机号',
  `mail` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
	 `password` varchar(40) NOT NULL DEFAULT '' COMMENT '加密后的密码',
	 `salt` varchar(40) NOT NULL DEFAULT '' COMMENT '盐',
	 `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结状态，2：删除',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
	`operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
 PRIMARY KEY (`user_id`)
) COMMENT='用户表' ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
-- 初始化数据
INSERT INTO `sys_user`
VALUES('10000000','admin','135XX72XXXX','marklogzhu@163.com','aca692cbbda72dedb2cbbb1e3a5c9100','',1,'','admin',NOW(),'127.0.0.1')



