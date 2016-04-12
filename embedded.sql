
--
-- 表的结构 `friend`
--

CREATE TABLE IF NOT EXISTS `friend` (
  `user_id_1` int(11) NOT NULL,
  `user_id_2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `strength`
--

CREATE TABLE IF NOT EXISTS `strength` (
  `record_id` int(11) NOT NULL,
  `strength_1` double NOT NULL,
  `strength_2` double NOT NULL,
  `strength_3` double NOT NULL,
  `strength_4` double NOT NULL,
  `point_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `point` (
  `id` int(11) NOT NULL,
  `strength_1` double NOT NULL,
  `strength_2` double NOT NULL,
  `strength_3` double NOT NULL,
  `strength_4` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `last_point_id` int(11) NULL DEFAULT '0',
  `current_point_id` int(11) NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `wifi`
--

CREATE TABLE IF NOT EXISTS `wifi` (
  `id` int(16) NOT NULL,
  `name` varchar(64) NOT NULL,
  `mac` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

ALTER TABLE `strength` CHANGE `record_id` `record_id` INT(11) NOT NULL AUTO_INCREMENT;

--
-- Indexes for table `strength`
--
ALTER TABLE `strength`
  ADD PRIMARY KEY (`record_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `wifi`
--
ALTER TABLE `wifi`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mac` (`mac`);

ALTER TABLE `friend`
  ADD CONSTRAINT `friend_ibfk_1` FOREIGN KEY (`user_id_1`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `friend_ibfk_2` FOREIGN KEY (`user_id_2`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
