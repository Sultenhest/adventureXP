-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 17, 2017 at 09:13 AM
-- Server version: 5.6.33
-- PHP Version: 5.6.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `adventureXP`
--

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
(2, 1, 'Gokart #2', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`equ_id`),
  ADD KEY `act_id_idx` (`fk_act_id`),
  ADD KEY `fk_equ_sta_id_idx` (`fk_equ_sta_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `equ_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `act_id` FOREIGN KEY (`fk_act_id`) REFERENCES `activity` (`act_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `equ_sta_id` FOREIGN KEY (`fk_equ_sta_id`) REFERENCES `equipment_status` (`equ_sta_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
