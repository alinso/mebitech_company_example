-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 30, 2017 at 04:00 PM
-- Server version: 5.7.16-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mebitech`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`, `description`, `updated_at`) VALUES
(25, 'update2', 'vzcxv', '2017-11-29 17:45:04'),
(28, 'update2', 'update2 d', '2017-11-30 10:44:54'),
(30, 'update2', 'update2 d', '2017-11-30 10:46:33');

-- --------------------------------------------------------

--
-- Table structure for table `department_meeting`
--

CREATE TABLE IF NOT EXISTS `department_meeting` (
  `meeting_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department_meeting`
--

INSERT INTO `department_meeting` (`meeting_id`, `department_id`, `updated_at`) VALUES
(10, 28, '2017-11-30 10:52:20'),
(10, 30, '2017-11-30 10:52:27');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `salary` int(11) NOT NULL,
  `modified_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `surname`, `salary`, `modified_at`, `department_id`) VALUES
(13, 'asdads', 'cv', 2000, '2017-11-29 18:49:34', 25),
(15, 'test2', 'test2 s', 2000, '2017-11-30 10:44:55', 25),
(17, 'test2', 'test2 s', 2000, '2017-11-30 10:46:33', 25);

-- --------------------------------------------------------

--
-- Table structure for table `meeting`
--

CREATE TABLE IF NOT EXISTS `meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `meeting`
--

INSERT INTO `meeting` (`id`, `name`, `description`, `updated_at`) VALUES
(2, 'asd', 'xczx', '2017-11-29 14:17:46'),
(3, 'meeting 1', 'met 1 desc', '2017-11-29 14:17:48'),
(4, 'update1', 'update1 m', '2017-11-29 18:56:35'),
(6, 'update2', 'update2 d', '2017-11-29 18:58:45'),
(8, 'update2', 'update2 d', '2017-11-29 18:59:41'),
(10, 'update2', 'update2 d', '2017-11-29 19:00:22'),
(12, 'update2', 'update2 d', '2017-11-29 19:00:40'),
(14, 'update2', 'update2 d', '2017-11-29 19:02:07'),
(16, 'update2', 'update2 d', '2017-11-30 10:44:55'),
(18, 'update2', 'update2 d', '2017-11-30 10:46:34'),
(20, 'update2', 'update2 d', '2017-11-30 10:47:55'),
(22, 'update2', 'update2 d', '2017-11-30 10:50:02');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
