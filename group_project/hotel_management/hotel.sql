-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 29, 2016 at 05:17 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `archive`
--

CREATE TABLE `archive` (
  `ID` int(11) NOT NULL,
  `FirstName` varchar(255) COLLATE latin1_bin NOT NULL,
  `LastName` varchar(255) COLLATE latin1_bin NOT NULL,
  `Gender` varchar(255) COLLATE latin1_bin NOT NULL,
  `IdentityCard` varchar(255) COLLATE latin1_bin NOT NULL,
  `Age` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `archive`
--

INSERT INTO `archive` (`ID`, `FirstName`, `LastName`, `Gender`, `IdentityCard`, `Age`) VALUES
(1, 'Selene', 'Rodriguez', 'female', 'sel123', 23),
(2, 'Ned', 'Stark', 'male', 'ned123', 36),
(3, 'James', 'Sutton', 'male', 'sut123', 37);

-- --------------------------------------------------------

--
-- Table structure for table `extra_service`
--

CREATE TABLE `extra_service` (
  `ID` int(11) NOT NULL,
  `Gym` int(11) NOT NULL DEFAULT '0',
  `Cinema` int(11) NOT NULL DEFAULT '0',
  `Restaurant` int(11) NOT NULL DEFAULT '0',
  `Pool` int(11) NOT NULL DEFAULT '0',
  `Sauna` int(11) NOT NULL DEFAULT '0',
  `Balance` int(11) NOT NULL,
  `DateUpdate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `extra_service`
--

INSERT INTO `extra_service` (`ID`, `Gym`, `Cinema`, `Restaurant`, `Pool`, `Sauna`, `Balance`, `DateUpdate`) VALUES
(1, 0, 0, 0, 0, 0, 0, '2016-09-20 12:00:00'),
(2, 0, 0, 0, 0, 0, 0, '2016-09-15 12:00:00'),
(3, 0, 0, 0, 0, 0, 0, '2016-09-23 12:00:00'),
(4, 0, 0, 0, 0, 0, 0, '2016-09-21 12:00:00'),
(5, 0, 0, 0, 0, 0, 0, '2016-09-24 12:00:00'),
(6, 0, 0, 0, 0, 0, 0, '2016-09-13 12:00:00'),
(7, 0, 0, 0, 0, 0, 0, '2016-09-19 12:00:00'),
(8, 0, 0, 0, 0, 0, 0, '2016-09-14 12:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `information`
--

CREATE TABLE `information` (
  `ID` int(11) NOT NULL,
  `FirstName` varchar(255) COLLATE latin1_bin NOT NULL,
  `LastName` varchar(255) COLLATE latin1_bin NOT NULL,
  `Gender` varchar(25) COLLATE latin1_bin NOT NULL,
  `IdentityCard` varchar(25) COLLATE latin1_bin NOT NULL,
  `Age` int(3) NOT NULL,
  `RoomNumber` int(11) NOT NULL,
  `RoomType` varchar(255) COLLATE latin1_bin NOT NULL,
  `CheckInDate` datetime NOT NULL,
  `UserName` varchar(255) COLLATE latin1_bin NOT NULL,
  `Password` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `information`
--

INSERT INTO `information` (`ID`, `FirstName`, `LastName`, `Gender`, `IdentityCard`, `Age`, `RoomNumber`, `RoomType`, `CheckInDate`, `UserName`, `Password`) VALUES
(1, 'John', 'Snow', 'male', 'john123', 29, 5, 'Single Room', '2016-09-20 12:00:00', 'johny', 12),
(2, 'Monica', 'Bellucci', 'female', 'mon123', 35, 45, 'Apartment', '2016-09-15 12:00:00', 'mon', 12),
(3, 'James', 'Mendez', 'male', 'men123', 32, 23, 'Double Room', '2016-09-23 12:00:00', 'men', 12),
(4, 'Deckard', 'Cain', 'male', 'cain123', 65, 54, 'Single Room', '2016-09-21 12:00:00', 'cain', 12),
(5, 'Joshua', 'Mandroka', 'male', 'man123', 21, 2, 'Single Room', '2016-09-24 12:00:00', 'man', 12);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `ID` int(11) NOT NULL,
  `SingleRoom` int(11) NOT NULL DEFAULT '0',
  `DoubleRoom` int(11) NOT NULL DEFAULT '0',
  `Apartment` int(11) NOT NULL DEFAULT '0',
  `Balance` int(11) NOT NULL,
  `DateUpdate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`ID`, `SingleRoom`, `DoubleRoom`, `Apartment`, `Balance`, `DateUpdate`) VALUES
(1, 20, 0, 0, 20, '2016-09-20 12:00:00'),
(2, 0, 0, 60, 60, '2016-09-15 12:00:00'),
(3, 0, 40, 0, 40, '2016-09-23 12:00:00'),
(4, 20, 0, 0, 20, '2016-09-21 12:00:00'),
(5, 20, 0, 0, 20, '2016-09-24 12:00:00'),
(6, 0, 0, 60, 60, '2016-09-13 12:00:00'),
(7, 0, 40, 0, 40, '2016-09-19 12:00:00'),
(8, 0, 40, 0, 40, '2016-09-14 12:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `archive`
--
ALTER TABLE `archive`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `information`
--
ALTER TABLE `information`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
