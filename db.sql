# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     bank_application
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2019-12-10 18:29:54
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for bank_application
CREATE DATABASE IF NOT EXISTS `bank_application` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bank_application`;


# Dumping structure for table bank_application.acc_details
CREATE TABLE IF NOT EXISTS `acc_details` (
  `accno` text,
  `uname` text,
  `acc_type` text,
  `details` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table bank_application.acc_details: 2 rows
/*!40000 ALTER TABLE `acc_details` DISABLE KEYS */;
INSERT INTO `acc_details` (`accno`, `uname`, `acc_type`, `details`) VALUES ('4450872', 'shub', 'SAVING', 'vnkdshfk;s'), ('948145', 'om', 'SAVING', 'jkdfgbks');
/*!40000 ALTER TABLE `acc_details` ENABLE KEYS */;


# Dumping structure for table bank_application.newaccount
CREATE TABLE IF NOT EXISTS `newaccount` (
  `accountno` int(10) DEFAULT NULL,
  `USERNAME` text,
  `PASSWORD` text,
  `REPASSWORD` text,
  `AMOUNT` text,
  `ADDRESS` text,
  `PHONE` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table bank_application.newaccount: 0 rows
/*!40000 ALTER TABLE `newaccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `newaccount` ENABLE KEYS */;


# Dumping structure for table bank_application.otpcodetble
CREATE TABLE IF NOT EXISTS `otpcodetble` (
  `email` text,
  `otpcode` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table bank_application.otpcodetble: 1 rows
/*!40000 ALTER TABLE `otpcodetble` DISABLE KEYS */;
INSERT INTO `otpcodetble` (`email`, `otpcode`) VALUES ('example@gmail.com', 'AYXQQ');
/*!40000 ALTER TABLE `otpcodetble` ENABLE KEYS */;


# Dumping structure for table bank_application.tx_details
CREATE TABLE IF NOT EXISTS `tx_details` (
  `uname` text,
  `acc_no` text,
  `operation` text,
  `amt` text,
  `balance` text,
  `time1` text,
  `isnew` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table bank_application.tx_details: 22 rows
/*!40000 ALTER TABLE `tx_details` DISABLE KEYS */;
INSERT INTO `tx_details` (`uname`, `acc_no`, `operation`, `amt`, `balance`, `time1`, `isnew`) VALUES ('shub', '4450872', 'DEPOSITE', '1000', '1000', 'Sat Nov 30 12:11:26 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '500', '500', 'Sat Nov 30 12:26:27 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '100', '400', 'Sat Nov 30 12:55:29 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '10', '390', 'Sat Nov 30 12:59:33 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '10', '380', 'Sat Nov 30 13:00:30 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '5', '375', 'Sat Nov 30 13:02:41 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '4', '371', 'Sat Nov 30 13:04:10 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '2', '369', 'Sat Nov 30 13:12:28 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '1', '368', 'Sat Nov 30 13:19:24 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '1', '367', 'Sat Nov 30 13:20:00 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '10', '357', 'Sat Nov 30 13:22:17 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '11', '346', 'Sat Nov 30 13:26:21 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '21', '325', 'Sat Nov 30 13:28:12 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '1', '324', 'Sat Nov 30 13:55:48 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '15', '309', 'Sat Nov 30 13:57:46 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '12', '297', 'Sat Nov 30 13:59:34 IST 2019', 'NO'), ('shub', '4450872', 'DEPOSITE', '1000', '1297', 'Sat Nov 30 14:01:22 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '20', '1277', 'Sat Nov 30 14:01:31 IST 2019', 'NO'), ('shub', '4450872', 'WITHDRAW', '10', '1267', 'Sat Nov 30 14:02:53 IST 2019', 'NO'), ('om', '948145', 'DEPOSITE', '10', '10', 'Sat Nov 30 14:02:53 IST 2019', 'NO'), ('shub', '4450872', 'TRANSFER', '21', '1246', 'Sat Nov 30 14:03:35 IST 2019', 'YES'), ('om', '948145', 'DEPOSITE', '21', '31', 'Sat Nov 30 14:03:35 IST 2019', 'YES');
/*!40000 ALTER TABLE `tx_details` ENABLE KEYS */;


# Dumping structure for table bank_application.user_details
CREATE TABLE IF NOT EXISTS `user_details` (
  `uname` text,
  `upass` text,
  `sec_question` text,
  `answer` text,
  `address` text,
  `email` text,
  `mobile` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table bank_application.user_details: 3 rows
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` (`uname`, `upass`, `sec_question`, `answer`, `address`, `email`, `mobile`) VALUES ('shub', '123', 'Your Car Number', 'Mh12ds2321', 'pune', 'example@gmail.com', '8605061234'), ('om', '123', 'Your Mothers Name', 'hjgj', 'pune', 'example123@gmail.com', '8605067524'), ('amar', '123', 'Your First School Name', 'asw', 'pune', 'example@gmail.com', '8605061234');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
