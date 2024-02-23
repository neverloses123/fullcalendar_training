-- test.calendar_event_master definition

CREATE TABLE `calendar_event_master` (
  `event_id` int NOT NULL AUTO_INCREMENT,
  `event_name` varchar(255) DEFAULT NULL,
  `event_start_date` date DEFAULT NULL,
  `event_end_date` date DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

--這是測試資料
insert into calendar_event_master(event_name,event_start_date,event_end_date) value('我是帥哥','2024-02-20','2024-02-28');
