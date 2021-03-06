-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 24, 2017 at 09:00 AM
-- Server version: 5.6.33
-- PHP Version: 5.6.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `adventure_xp`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `act_id` int(11) NOT NULL,
  `act_name` varchar(45) DEFAULT NULL,
  `act_min_age` int(11) DEFAULT NULL,
  `act_min_height` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`act_id`, `act_name`, `act_min_age`, `act_min_height`) VALUES
(1, 'Gokart', 18, 150),
(2, 'Hockey', 0, 100),
(3, 'CHEESE', 12, 122),
(4, 'kjn', 22, 22),
(5, 'Kat', 33, 123),
(6, 'Phuong', 22, 22),
(7, 'lsdjf', 32, 22);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bk_id` int(11) NOT NULL,
  `bk_act_id` int(11) NOT NULL,
  `bk_instructor` varchar(45) NOT NULL,
  `bk_customer` varchar(45) NOT NULL,
  `bk_date` date DEFAULT NULL,
  `bk_startTime` VARCHAR(5) DEFAULT NULL,
  `bk_endTime` varchar(5) DEFAULT NULL,
  `bk_participants` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- new addition

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `equ_id` int(11) NOT NULL,
  `fk_act_id` int(11) NOT NULL,
  `equ_name` varchar(45) DEFAULT NULL,
  `fk_equ_sta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`equ_id`, `fk_act_id`, `equ_name`, `fk_equ_sta_id`) VALUES
(1, 1, 'Gokart #1', 1),
(2, 1, 'Gokart #2', 2),
(3, 2, 'Pind', 1);

-- --------------------------------------------------------

--
-- Table structure for table `equipment_status`
--

CREATE TABLE `equipment_status` (
  `equ_sta_id` int(11) NOT NULL,
  `equ_sta_name` varchar(45) DEFAULT NULL,
  `equ_sta_usable` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `equipment_status`
--

INSERT INTO `equipment_status` (`equ_sta_id`, `equ_sta_name`, `equ_sta_usable`) VALUES
(1, 'Funktionel', 1),
(2, 'Ødelagt', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`act_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bk_id`),
  ADD KEY `fk_act_id_idx` (`bk_act_id`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`equ_id`),
  ADD KEY `act_id_idx` (`fk_act_id`),
  ADD KEY `fk_equ_sta_id_idx` (`fk_equ_sta_id`);

--
-- Indexes for table `equipment_status`
--
ALTER TABLE `equipment_status`
  ADD PRIMARY KEY (`equ_sta_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `act_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bk_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `equ_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `equipment_status`
--
ALTER TABLE `equipment_status`
  MODIFY `equ_sta_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `fk_act_id` FOREIGN KEY (`bk_act_id`) REFERENCES `activity` (`act_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `act_id` FOREIGN KEY (`fk_act_id`) REFERENCES `adventureXP`.`activity` (`act_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `equ_sta_id` FOREIGN KEY (`fk_equ_sta_id`) REFERENCES `adventureXP`.`equipment_status` (`equ_sta_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
