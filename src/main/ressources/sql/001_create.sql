CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `email`, `password`) VALUES
(1,	'jeremy.curny.pro@gmail.com',	'5f4dcc3b5aa765d61d8327deb882cf99'),
(2,	'john.connor@fakemail.com',	'5f4dcc3b5aa765d61d8327deb882cf99'),
(3,	'arnold.schwarzenegger@fakemail.com',	'5f4dcc3b5aa765d61d8327deb882cf99');