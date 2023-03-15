-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 09, 2023 at 01:47 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CMS`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `AdminID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `PhoneOrMail` varchar(50) DEFAULT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`AdminID`, `Username`, `PhoneOrMail`, `Password`) VALUES
(1, 'Sandesh Bhatta', '98587338893', 'hello'),
(2, 'Ganesh', '98838483989', 'hello');

-- --------------------------------------------------------

--
-- Table structure for table `Assignment`
--

CREATE TABLE `Assignment` (
  `Course` varchar(50) NOT NULL,
  `Module` varchar(50) NOT NULL,
  `Day` varchar(50) NOT NULL,
  `Due Date` varchar(20) NOT NULL,
  `Time` varchar(20) NOT NULL,
  `Description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Assignment`
--

INSERT INTO `Assignment` (`Course`, `Module`, `Day`, `Due Date`, `Time`, `Description`) VALUES
('BSc (Hons) in CS', 'OOPs', 'Thursday', '2023-02-09', '7:45 pm', 'Please Submit your zip file.'),
('BSc (Hons) in CS', 'Numerical', 'Monday', '2023-02-13', '7:45 pm', 'Submit your File in zip file'),
('BSc (Hons) in CS', 'AI', 'Sunday', '2023-02-12', '7:45 pm', 'Please submit your Task in CANVAS'),
('BBA', 'Business', 'Wednesday', '2023-03-02', '12:00 pm', 'Your whole project will be submitted in due date');

-- --------------------------------------------------------

--
-- Table structure for table `Exam`
--

CREATE TABLE `Exam` (
  `Course Name` varchar(200) NOT NULL,
  `Module` varchar(200) NOT NULL,
  `Year` int(20) NOT NULL,
  `Semester` int(20) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Time` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Exam`
--

INSERT INTO `Exam` (`Course Name`, `Module`, `Year`, `Semester`, `Date`, `Time`) VALUES
('International Master in BA', 'OOPs', 1, 4, '', ''),
('BSc (Hons) in CS', 'Numerical Methods and Concurrency', 2, 3, '2079-10-10', '1:00 pm'),
('BSc (Hons) in CS', 'AI', 2, 3, '2079-10-10', '2:00 pm');

-- --------------------------------------------------------

--
-- Table structure for table `Instructor`
--

CREATE TABLE `Instructor` (
  `InstructorID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `PhoneOrMail` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Instructor`
--

INSERT INTO `Instructor` (`InstructorID`, `Username`, `PhoneOrMail`, `Password`) VALUES
(1, 'Raj Shrestha', '98473884893', 'hellohello'),
(2, 'Ram Shah', '39845783993', 'hello');

-- --------------------------------------------------------

--
-- Table structure for table `Marks`
--

CREATE TABLE `Marks` (
  `SN` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Student Id` int(11) NOT NULL,
  `Full Marks` int(11) NOT NULL,
  `Pass Marks` int(11) NOT NULL,
  `Obtained Marks` int(11) NOT NULL,
  `Course` varchar(50) NOT NULL,
  `Module` varchar(50) NOT NULL,
  `Year` int(11) NOT NULL,
  `Semester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Marks`
--

INSERT INTO `Marks` (`SN`, `Name`, `Student Id`, `Full Marks`, `Pass Marks`, `Obtained Marks`, `Course`, `Module`, `Year`, `Semester`) VALUES
(1, 'Prem Bahadur Kayat', 2204963, 100, 40, 90, 'BSc (Hons) in CS', 'OOPs', 2, 3),
(2, 'Prem Bahadur Kayat', 2204963, 100, 40, 89, 'BSc (Hons) in CS', 'Numerical', 2, 3),
(3, 'Prem Bahadur Kayat', 2204963, 100, 40, 88, 'BSc (Hons) in CS', 'AI', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
  `StudentID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `PhoneOrMail` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`StudentID`, `Username`, `PhoneOrMail`, `Course`, `Password`) VALUES
(1, 'Prem Kayat', '987736483823', 'B.IT', 'hello000');

-- --------------------------------------------------------

--
-- Table structure for table `StudentList`
--

CREATE TABLE `StudentList` (
  `SN` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Student Id` int(20) NOT NULL,
  `Number` varchar(15) NOT NULL,
  `Mail Id` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Course` varchar(200) NOT NULL,
  `Semester` int(11) NOT NULL,
  `Year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `StudentList`
--

INSERT INTO `StudentList` (`SN`, `Name`, `Student Id`, `Number`, `Mail Id`, `Password`, `Gender`, `Course`, `Semester`, `Year`) VALUES
(3, 'Shristi Bhusal ', 5, '9948389393', 'Shristi@gmai', 'djfhehf', 'Female', 'BBA', 3, 2),
(4, 'Prem Kayat', 2, '988477383843', 'kayat@gmail.com', '3jehfjejf', 'BSc (Hons) in CS', 'Male', 3, 2),
(5, 'Sandesh Thapa', 3, '934874838', 'sandesh@gmail.com', 'jfnejhfie', 'BSc (Hons) in CS', 'Male', 3, 2),
(6, 'Ganesh Rai', 4, '9939333584', 'ganesh@gmail.com', 'idfikfn', 'BSc (Hons) in CS', 'Male', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `TeacherList`
--

CREATE TABLE `TeacherList` (
  `SN` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Mail Id` varchar(100) NOT NULL,
  `Course` varchar(200) NOT NULL,
  `Module` varchar(200) NOT NULL,
  `Year` int(11) NOT NULL,
  `Semester` int(11) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TeacherList`
--

INSERT INTO `TeacherList` (`SN`, `Name`, `Mail Id`, `Course`, `Module`, `Year`, `Semester`, `Password`) VALUES
(1, 'Raj Shrestha', 'Rajshrestha@gmail.com', 'BSc (Hons) in CS', 'OOPs', 2, 3, 'shrestharaj'),
(2, 'Jenny Rajak', 'rajak@gmail.com', 'BSc (Hons) in CS', 'Numerical Methods', 2, 3, 'jennyrajak');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `Instructor`
--
ALTER TABLE `Instructor`
  ADD PRIMARY KEY (`InstructorID`);

--
-- Indexes for table `Marks`
--
ALTER TABLE `Marks`
  ADD PRIMARY KEY (`SN`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`StudentID`);

--
-- Indexes for table `StudentList`
--
ALTER TABLE `StudentList`
  ADD PRIMARY KEY (`SN`),
  ADD UNIQUE KEY `Student Id` (`Student Id`);

--
-- Indexes for table `TeacherList`
--
ALTER TABLE `TeacherList`
  ADD PRIMARY KEY (`SN`),
  ADD UNIQUE KEY `Mail Id` (`Mail Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Instructor`
--
ALTER TABLE `Instructor`
  MODIFY `InstructorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Marks`
--
ALTER TABLE `Marks`
  MODIFY `SN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Student`
--
ALTER TABLE `Student`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `StudentList`
--
ALTER TABLE `StudentList`
  MODIFY `SN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `TeacherList`
--
ALTER TABLE `TeacherList`
  MODIFY `SN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
