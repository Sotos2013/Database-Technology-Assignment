-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 20 Νοε 2023 στις 14:47:07
-- Έκδοση διακομιστή: 10.4.28-MariaDB
-- Έκδοση PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `hotel`
--

DELIMITER $$
--
-- Διαδικασίες
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_Driver` (IN `Id` INT(30), IN `Name` VARCHAR(30), IN `Surname` VARCHAR(30), IN `Age` INT(2), IN `Sex` VARCHAR(20), IN `Car` VARCHAR(30), IN `Availability` VARCHAR(30))   BEGIN
	INSERT INTO driver(ID, Όνομα, Επώνυμο, Ηλικία, Φύλο, Αυτοκίνητο, Διαθεσιμότητα) values(Id,Name,Surname,Age,Sex,Car,Availability);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_Employee` (IN `id` INT(11), IN `name` VARCHAR(30), IN `surname` VARCHAR(30), IN `age` INT(2), IN `sex` VARCHAR(30), IN `job` VARCHAR(30), IN `salary` INT(6), IN `phone` INT(30), IN `email` VARCHAR(40))   BEGIN
	INSERT INTO employee 		values(id,name,surname,age,sex,job,salary,phone,email);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_Room` (IN `RoomNum` INT(4), IN `Availability` VARCHAR(20), IN `Clean` VARCHAR(20), IN `Price` INT(4), IN `BedNum` VARCHAR(20))   BEGIN
	INSERT INTO room values(RoomNum,Availability,Clean,Price,BedNum);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customer`
--

CREATE TABLE `customer` (
  `ID` varchar(30) NOT NULL,
  `Αριθμός_Εγγράφου` varchar(30) NOT NULL,
  `Όνομα` varchar(30) NOT NULL,
  `Επώνυμο` varchar(30) NOT NULL,
  `Φύλο` varchar(30) NOT NULL,
  `Χώρα_Διαμονής` varchar(30) NOT NULL,
  `Αριθμός_δωματίου` int(4) NOT NULL,
  `Προσέλευση` varchar(30) NOT NULL,
  `Ποσό_Πληρωμής` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `driver`
--

CREATE TABLE `driver` (
  `ID` int(30) NOT NULL,
  `Όνομα` varchar(30) NOT NULL,
  `Επώνυμο` varchar(30) NOT NULL,
  `Ηλικία` int(2) NOT NULL,
  `Φύλο` varchar(20) NOT NULL,
  `Αυτοκίνητο` varchar(30) NOT NULL,
  `Διαθεσιμότητα` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `employee`
--

CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `Όνομα` varchar(30) NOT NULL,
  `Επώνυμο` varchar(30) NOT NULL,
  `Ηλικία` int(2) NOT NULL,
  `Φύλο` varchar(30) NOT NULL,
  `Είδος Εργασίας` varchar(30) NOT NULL,
  `Μισθός` int(6) NOT NULL,
  `Τηλέφωνο` int(30) NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `employee`
--

INSERT INTO `employee` (`ID`, `Όνομα`, `Επώνυμο`, `Ηλικία`, `Φύλο`, `Είδος Εργασίας`, `Μισθός`, `Τηλέφωνο`, `Email`) VALUES
(1, 'GRSH', 'HRWHR', 43, 'Άνδρας', 'Σέφ', 464236, 753, 'FHDDAH'),
(6, 'HRH', 'HTAJHT', 32, 'Άνδρας', 'Σέφ', 434, 653, 'GSGH');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `login`
--

CREATE TABLE `login` (
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `login`
--

INSERT INTO `login` (`username`, `password`, `last_login`) VALUES
('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2023-11-09 12:15:49');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `room`
--

CREATE TABLE `room` (
  `Αριθμός_δωματίου` int(4) NOT NULL,
  `Διαθεσιμότητα` varchar(20) NOT NULL,
  `Καθαρισμός` varchar(20) NOT NULL,
  `Τιμή` int(4) NOT NULL,
  `Αριθμός_κρεβατιών` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `room`
--

INSERT INTO `room` (`Αριθμός_δωματίου`, `Διαθεσιμότητα`, `Καθαρισμός`, `Τιμή`, `Αριθμός_κρεβατιών`) VALUES
(1, 'Διαθέσιμο', 'Καθαρό', 55, 'Μονόκλινο'),
(2, 'Διαθέσιμο', 'Καθαρό', 66, 'Δίκλινο');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Αριθμός_Εγγράφου`),
  ADD KEY `Αριθμός δωματίου` (`Αριθμός_δωματίου`);

--
-- Ευρετήρια για πίνακα `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`ID`);

--
-- Ευρετήρια για πίνακα `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`);

--
-- Ευρετήρια για πίνακα `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Ευρετήρια για πίνακα `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Αριθμός_δωματίου`),
  ADD KEY `Τιμή` (`Τιμή`);

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Αριθμός_δωματίου`) REFERENCES `room` (`Αριθμός_δωματίου`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
