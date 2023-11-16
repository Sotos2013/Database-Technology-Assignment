-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 16 Νοε 2023 στις 12:51:02
-- Έκδοση διακομιστή: 10.4.28-MariaDB
-- Έκδοση PHP: 8.2.4

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

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customer`
--

CREATE TABLE `customer` (
  `ID` varchar(30) NOT NULL,
  `Αριθμός Εγγράφου` varchar(30) NOT NULL,
  `Όνομα` varchar(30) NOT NULL,
  `Επώνυμο` varchar(30) NOT NULL,
  `Φύλο` varchar(30) NOT NULL,
  `Χώρα Διαμονής` varchar(30) NOT NULL,
  `Αριθμός δωματίου` int(4) NOT NULL,
  `Προσέλευση` varchar(30) NOT NULL,
  `Ποσό Πληρωμής` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `driver`
--

CREATE TABLE `driver` (
  `ID` int(30) NOT NULL,
  `Όνομα` varchar(30) NOT NULL,
  `Επώνυμο` varchar(30) NOT NULL,
  `Ηλικία` int(10) NOT NULL,
  `Φύλο` varchar(20) NOT NULL,
  `Αυτοκίνητο` varchar(30) NOT NULL
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
  `Αριθμός δωματίου` int(4) NOT NULL,
  `Διαθεσιμότητα` varchar(20) NOT NULL,
  `Καθαρισμός` varchar(20) NOT NULL,
  `Τιμή` varchar(20) NOT NULL,
  `Αριθμός κρεβατιών` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Αριθμός Εγγράφου`),
  ADD KEY `Αριθμός δωματίου` (`Αριθμός δωματίου`);

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
  ADD PRIMARY KEY (`Αριθμός δωματίου`);

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Αριθμός δωματίου`) REFERENCES `room` (`Αριθμός δωματίου`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
