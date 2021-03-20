CREATE TABLE `t_user` (
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `account`  varchar(20) DEFAULT NULL COMMENT '账号',
    `password` varchar(20) DEFAULT NULL COMMENT '密码',
    `name`     varchar(20) DEFAULT NULL COMMENT '名字',
    `sex`      int(11)     DEFAULT NULL COMMENT '性别，0-男，1-女',
    `age`      int(11)     DEFAULT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `t_room` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(20) DEFAULT NULL COMMENT '科室名',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_doctor` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `account` varchar(20) DEFAULT NULL COMMENT '账号',
    `password` varchar(20) DEFAULT NULL COMMENT '密码',
    `name` varchar(20) DEFAULT NULL COMMENT '名字',
    `sex` int(11) DEFAULT NULL COMMENT '性别，0-男，1-女',
    `age` int(11) DEFAULT NULL COMMENT '年龄',
    `rid` int(11) DEFAULT NULL COMMENT '科室ID',
    PRIMARY KEY (`id`),
    KEY `rid` (`rid`),
    CONSTRAINT `t_doctor_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `t_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_record` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `uid` int(11) DEFAULT NULL COMMENT '用户id',
    `did` int(11) DEFAULT NULL COMMENT '医生id',
    `description` varchar(100) DEFAULT NULL COMMENT '医嘱',
    `state` varchar(20) DEFAULT NULL COMMENT '状态',
    `date` timestamp NULL DEFAULT NULL COMMENT '就诊时间',
    PRIMARY KEY (`id`),
    KEY `uid` (`uid`),
    KEY `did` (`did`),
    CONSTRAINT `t_record_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
    CONSTRAINT `t_record_ibfk_2` FOREIGN KEY (`did`) REFERENCES `t_doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;