-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 08, 2018 at 12:10 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assignment1`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `SSN` int(11) NOT NULL,
  `Bdate` varchar(10) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Address` varchar(160) NOT NULL,
  `Salary` int(7) NOT NULL,
  `Sex` char(1) NOT NULL,
  PRIMARY KEY (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Employee table';

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`SSN`, `Bdate`, `Name`, `Address`, `Salary`, `Sex`) VALUES
(1, '01-10-1994', 'Aaron Mooney', 'Waterford', 50000, 'M'),
(2, '25-05-1993', 'John Smyth', 'Dublin', 62000, 'M'),
(3, '02-01-1996', 'Claire Murphy', 'Wexford', 37000, 'F'),
(4, '24-05-1990', 'Kim Larson', 'Dublin', 60000, 'F');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
